package com.codeforgety.catalog.model;

import javax.persistence.*;

import lombok.*;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

//    public Book(@NonNull String name, @NonNull String topic, @NonNull Integer count, @NonNull Double cost) {
//        this.name = name;
//        this.topic = topic;
//        this.count = count;
//        this.cost = cost;
//    }
}
