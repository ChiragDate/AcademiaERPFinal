package com.chirag.festaurant.academiaerp.Exception;


import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class EmployeeNotFoundException extends RuntimeException {
    private final String msg;
}
