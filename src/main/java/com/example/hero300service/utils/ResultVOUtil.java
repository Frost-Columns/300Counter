package com.example.hero300service.utils;

public class ResultVOUtil {

    public static <T> ResultVO success (T data, Long count) {
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setCode(200);
        resultVO.setMsg("成功！");
        resultVO.setData(data);
        resultVO.setCount(count);
        return resultVO;
    }

    public static <T> ResultVO error (T data, Long count) {
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setCode(201);
        resultVO.setMsg("异常！");
        resultVO.setData(data);
        resultVO.setCount(count);
        return resultVO;
    }
}
