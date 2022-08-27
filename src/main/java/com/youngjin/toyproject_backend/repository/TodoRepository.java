package com.youngjin.toyproject_backend.repository;

import com.youngjin.toyproject_backend.entity.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface TodoRepository extends CrudRepository<Todo,Long> {
    @Override
    ArrayList<Todo> findAll();
}
