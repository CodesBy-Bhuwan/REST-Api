package com.codesbybhuwan.restfulApi.exceptions;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//extend to RuntimeException since we are making unchecked exception
public class ResourceNotFoundException extends RuntimeException{

    String resourceName;
    String fieldName;
    long fieldValue;

    public ResourceNotFoundException( String resourceName, String fieldName, long fieldValue) {
        super(String.format("%s not found with %s : %l", resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
