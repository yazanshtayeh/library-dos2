package com.codeforgety.catalog.services;


import com.codeforgety.catalog.model.Book;
import com.codeforgety.catalog.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save(Book book){
        return bookRepository.save(book);
    }
    public Optional<Book> findById(Long id){
        return bookRepository.findById(id);
    }
    public List<String> searchByTopic(String topic){
        return bookRepository.findByTopic(topic);
    }
    public List<String> searchByName(String name){
        return bookRepository.findByName(name);
    }

    public List<Book> info(String name){
        return bookRepository.findAllByName(name);
    }

    public List<Book> infoByTopic(String topic){
        return bookRepository.findAllByTopic(topic);
    }
}
