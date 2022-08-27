package com.youngjin.toyproject_backend.entity;

import javax.persistence.*;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String content;
    @Column
    private Boolean checked;

    public Todo() {
    }

    public Todo(Long id, String content, Boolean checked) {
        this.id = id;
        this.content = content;
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", checked=" + checked +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public void patch() {
        checked = !checked;
    }
}
