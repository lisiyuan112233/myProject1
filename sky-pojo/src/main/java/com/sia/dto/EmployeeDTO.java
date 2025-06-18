package com.sia.dto;

import com.baomidou.mybatisplus.annotation.EnumValue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;



import java.io.Serializable;

@Data
public class EmployeeDTO implements Serializable {

    private String id;

    private String username;
    @NotNull(message = "名字不能为空")
    private String name;
    @Pattern(regexp = "^1(3\\d|4[5-9]|5[0-35-9]|66|7[0-8]|8\\d|9[89])\\d{8}$", message = "手机号格式错误")
    private String phone;
    @Pattern(regexp = "[10]" , message = "性别格式错误")
    private String sex;
    @Pattern(regexp = "^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$", message = "身份证号格式错误")
    private String idNumber;

}
