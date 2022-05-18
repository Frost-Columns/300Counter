package com.example.hero300service.utils;

import lombok.Data;

@Data
public class ResultVO<T> {
    private Integer code;
    private String msg;
    private T data;
    private Long count;
}
