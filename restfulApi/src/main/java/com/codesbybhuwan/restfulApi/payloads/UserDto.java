package com.codesbybhuwan.restfulApi.payloads;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collector;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private int id;
//    Hibernate Validator annoted to enable annotation we will enable from Controller
    @NotEmpty
//    Instead of NotNull NotEmpty would be better option since it will check both the condtion
    @Size(min = 3, message = "Username must have atleast 3 characters")
    private String name;

    @Email(message = "Email address is not valid")
    private String email;

    @NotEmpty
    @Size(min = 8, message="The password must have atleast 8 character")
    @Pattern(regexp = ".*([a-zA-Z0-9]{4}$)")
    private String password;

    @NotEmpty
    private String about;

}
