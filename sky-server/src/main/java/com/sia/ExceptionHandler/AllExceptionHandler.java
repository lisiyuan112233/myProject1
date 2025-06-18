package com.sia.ExceptionHandler;
//
//import com.sia.result.Result;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import javax.validation.ConstraintViolationException;
//import java.util.HashMap;
//import java.util.Map;
//
//@ControllerAdvice
//public class AllExceptionHandler {
//    @ExceptionHandler
//    public Result handleException(Exception e) {
//        return Result.error("服务器内部错误" + e.getMessage());
//    }
//    @ExceptionHandler({MethodArgumentNotValidException.class, ConstraintViolationException.class})
//    public Map<String, Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        StringBuilder errors = new StringBuilder();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String errorMessage = error.getDefaultMessage();
//            errors.append(errorMessage).append("; ");
//        });
//        Map<String, Object> result = new HashMap<>();
//        result.put("code", "0");
//        result.put("msg", errors.toString());
//        return result;
//    }
//}
