package com.sia.controller.admin;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.annotation.EnumValue;
import com.sia.Utils.JwtUtil;
import com.sia.constant.RedisConstant;
import com.sia.dto.EmployeeDTO;
import com.sia.dto.EmployeeLoginDTO;
import com.sia.dto.EmployeePageQueryDTO;
import com.sia.entity.Employee;
import com.sia.result.Result;
import com.sia.service.EmployeeService;
import com.sia.vo.EmployeeLoginVO;
import jakarta.annotation.PostConstruct;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 员工管理
 */
@RestController
@RequestMapping("/admin/employee")
@Slf4j
@Validated
public class EmployeeController {

    @Autowired
    private JwtUtil jwtUtil;

   @Autowired
   private AuthenticationManager authenticationManager;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @PostConstruct
    public void init() {
        System.out.println(authenticationManager);
    }
    @GetMapping("/page")
    public Result page(@Valid EmployeePageQueryDTO pageQueryDTO) {
        return employeeService.getPage(pageQueryDTO);
    }
    @PostMapping("/add")
    public Result addEmployee(@RequestBody @Valid EmployeeDTO employeeDTO) {
        return employeeService.addEmployee(employeeDTO);

    }
    @PostMapping("/status/{status}")
    public Result updateStatus(@PathVariable int status, @NotBlank(message = "员工ID不能为空") String id) {
        if (status != 0 && status != 1) {
            return Result.error("状态不合法");
        }
        boolean b = employeeService.lambdaUpdate().eq(Employee::getId, id).set(Employee::getStatus, status).update();
        return b ? Result.success("修改成功") : Result.error("用户不存在");
    }
    @PostMapping("/login")
    public Result login(@RequestBody EmployeeLoginDTO employeeLoginDTO) {
//         1. 验证用户名密码
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        employeeLoginDTO.getUsername(),
                        employeeLoginDTO.getPassword()
                )
        );
        // 2. 生成JWT令牌
        String token = jwtUtil.generateToken(authentication);
        stringRedisTemplate.opsForSet().add(RedisConstant.TOKEN_USER+employeeLoginDTO.getUsername(),token);
        Employee user = employeeService.lambdaQuery().eq(Employee::getUsername, employeeLoginDTO.getUsername()).one();
        EmployeeLoginVO employeeLoginVO = new EmployeeLoginVO();
        BeanUtil.copyProperties(user, employeeLoginVO);
        employeeLoginVO.setUserName(user.getUsername());
        employeeLoginVO.setToken(token);

        // 3. 返回令牌
        return Result.success(employeeLoginVO, "登录成功");
    }

    /**
     * 退出
     *
     * @return
     */
    @PostMapping("/logout")
    public Result<String> logout(String token) {
        if (token == null) {
            return Result.error("登出失败");
        }
        if(!jwtUtil.validateToken(token)){
            return Result.error("令牌无效");
        }
        stringRedisTemplate.delete(RedisConstant.TOKEN_USER + jwtUtil.getUsernameFromToken(token));
        return Result.success("登出成功");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        StringBuilder errors = new StringBuilder();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String errorMessage = error.getDefaultMessage();
            errors.append(errorMessage).append("; ");
        });
        Map<String, Object> result = new HashMap<>();
        result.put("code", "0");
        result.put("data", null);
        result.put("msg", errors.toString());
        return result;
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String, Object> handleConstraintViolationExceptions(ConstraintViolationException ex) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", "0");
        result.put("data", null);
        result.put("msg", ex.getMessage());
        return result;
    }
}
