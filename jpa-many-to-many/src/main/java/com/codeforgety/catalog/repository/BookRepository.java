package com.codeforgety.catalog.repository;

import com.codeforgety.catalog.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b.name FROM Book b WHERE b.topic like %?1%")
    List<String> findByTopic(String topic);

    @Query("SELECT b.name FROM Book b WHERE b.name like %?1%")
    List<String> findByName(String name);

    @Query("SELECT b FROM Book b WHERE b.name like %?1%")
    List<Book> findAllByName(String name);

    @Query("SELECT b FROM Book b WHERE b.topic like %?1%")
    List<Book> findAllByTopic(String topic);



//    @Query("SELECT b FROM Book b WHERE b.topic like %?1%")
//    List<Book> findAllByTopic(String topic);
}
