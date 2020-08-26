package com.springtest.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Person {
    private UUID id;
    private final String name;

    public Person(@JsonProperty("id") UUID id, 
                  @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }
    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
}