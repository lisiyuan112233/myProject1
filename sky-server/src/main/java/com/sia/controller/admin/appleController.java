package com.sia.controller.admin;

import com.sia.Utils.EmployeeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apple")
public class appleController {
    @Autowired
    private EmployeeUtil employeeUtil;
    @GetMapping("/{num}")
    public String getApple(@PathVariable("num") int num){
        System.out.println(employeeUtil.getEmployeeId());
        return "give your "+num+" apple";
    }

}
