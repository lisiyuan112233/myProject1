package com.sia.handler;

//import com.sia.exception.BaseException;
//import com.sia.result.Result;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
///**
// * 全局异常处理器，处理项目中抛出的业务异常
// */
//@RestControllerAdvice
//@Slf4j
//public class GlobalExceptionHandler {
//
//    /**
//     * 捕获业务异常
//     * @param ex
//     * @return
//     */
//    @ExceptionHandler
//    public Result exceptionHandler(BaseException ex){
//        // 记录异常信息
//        log.error("异常信息：{}", ex.getMessage());
//        // 返回错误结果
//        return Result.error(ex.getMessage());
//    }
//
//}
