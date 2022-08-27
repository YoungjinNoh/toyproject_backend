package com.youngjin.toyproject_backend.service;

import com.youngjin.toyproject_backend.dto.TodoDto;
import com.youngjin.toyproject_backend.entity.Todo;
import com.youngjin.toyproject_backend.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> index() {
        return todoRepository.findAll();
    }

    public Todo create(TodoDto dto) {
        Todo todo = dto.toEntity();
        if (todo.getId() != null||todo.getChecked()!=null)
            return null;
        todo.setChecked(false);
        return todoRepository.save(todo);
    }

    public Todo update(Long id) {
        Todo target = todoRepository.findById(id).orElse(null);
        if (target == null)
            return null;

        target.patch();
        return todoRepository.save(target);
    }

    public Todo delete(Long id) {
        Todo target=todoRepository.findById(id).orElse(null);
        if(target==null)
            return null;

        todoRepository.delete(target);
        return target;
    }
}
