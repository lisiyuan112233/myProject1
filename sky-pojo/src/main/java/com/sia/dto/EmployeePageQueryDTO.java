package com.sia.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


import java.io.Serializable;

@Data
public class EmployeePageQueryDTO implements Serializable {

    //员工姓名
    private String name;

    //页码
    @Min(value = 1, message = "页码不能小于1")
    private int page;

    //每页显示记录数
    @Max(value = 100, message = "每页显示记录数不能超过100")
    @Min(value = 1, message = "每页显示记录数不能小于1")
    private int pageSize;

}
