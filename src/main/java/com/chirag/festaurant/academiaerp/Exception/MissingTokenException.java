package com.chirag.festaurant.academiaerp.Exception;


import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MissingTokenException extends RuntimeException {
    private final String msg;
}
