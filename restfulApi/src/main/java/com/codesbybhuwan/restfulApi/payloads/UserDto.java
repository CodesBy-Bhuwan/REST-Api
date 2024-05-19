package com.codesbybhuwan.restfulApi.payloads;


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
    private String name;
    private String email;
    private String password;
    private String about;

}
