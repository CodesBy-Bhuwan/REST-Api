package com.codesbybhuwan.restfulApi.exceptions;
import com.codesbybhuwan.restfulApi.payloads.ApiResponse;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
//    Means whenever RNFE aries then this method will be executed
    public ResponseEntity<ApiResponse> responseNotFoundExceptionHandler(ResourceNotFoundException ex){
        String message=ex.getMessage();
        ApiResponse apiResponse= new ApiResponse(message,false);

        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException exx){

        Map<String, String> resp = new HashMap<>();
        exx.getBindingResult().getAllErrors().forEach((error) ->{
            String fieldName = ((FieldError)error).getField();
            String messgae = error.getDefaultMessage();
            resp.put(fieldName, messgae);
        });

        return new ResponseEntity<Map<String, String>>(resp,HttpStatus.BAD_REQUEST);

    }
}
