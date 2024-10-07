package com.example.mocklogin.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Role {
    private long id;
    private String name;

    public Role() {
    }

    public Role(long id, String name) {
        this.id = id;
        this.name = name;
    }
}