package com.example.order.model;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @NonNull
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String topic;
    @NonNull
    private Integer count;
    @NonNull
    private Double cost;

    public Book(String name) {
        this.name = name;
    }

    public Book(@NonNull String name, @NonNull String topic, @NonNull Integer count, @NonNull Double cost) {
        this.name = name;
        this.topic = topic;
        this.count = count;
        this.cost = cost;
    }
}
