package com.codesbybhuwan.restfulApi.repository;

import com.codesbybhuwan.restfulApi.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {


}
