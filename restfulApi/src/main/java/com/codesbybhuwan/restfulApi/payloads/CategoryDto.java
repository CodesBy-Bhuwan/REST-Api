package com.codesbybhuwan.restfulApi.payloads;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private int categoryId;
    private String categoryTitle;
    private String categoryDescription;

}
