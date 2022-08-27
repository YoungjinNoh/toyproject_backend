package com.youngjin.toyproject_backend.dto;

import com.youngjin.toyproject_backend.entity.Todo;

public class TodoDto {
    private Long id;
    private String content;
    private Boolean checked;

    public TodoDto(Long id, String content, Boolean checked) {
        this.id = id;
        this.content = content;
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "TodoDto{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", checked=" + checked +
                '}';
    }

    public Todo toEntity(){
        return new Todo(id,content,checked);
    }
}
