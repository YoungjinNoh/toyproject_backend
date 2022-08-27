package com.youngjin.toyproject_backend.controller;

import com.youngjin.toyproject_backend.dto.TodoDto;
import com.youngjin.toyproject_backend.entity.Todo;
import com.youngjin.toyproject_backend.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/todos")
    public List<Todo> index() {
        return todoService.index();
    }

    @PostMapping("/todos")
    public ResponseEntity<Todo> create(@RequestBody TodoDto dto) {
        Todo created = todoService.create(dto);
        return (created != null) ? ResponseEntity.status(HttpStatus.OK).body(created) : ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @PatchMapping("/todos/{id}")
    public ResponseEntity<Todo> update(@PathVariable Long id) {
        Todo updated = todoService.update(id);
        return (updated != null) ? ResponseEntity.status(HttpStatus.OK).body(updated) : ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<Todo> delete(@PathVariable Long id) {
        Todo deleted = todoService.delete(id);
        return (deleted != null) ? ResponseEntity.status(HttpStatus.OK).body(deleted) : ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

}
