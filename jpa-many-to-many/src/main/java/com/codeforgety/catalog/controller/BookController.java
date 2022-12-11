package com.codeforgety.catalog.controller;


import com.codeforgety.catalog.model.Book;
import com.codeforgety.catalog.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class BookController {
    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/search/topic/{topic}")
    public ResponseEntity<List<String>> findByTopic(@PathVariable String topic){
        List<String> books=bookService.searchByTopic(topic);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/search/name/{name}")
    public ResponseEntity<List<String>> findByName(@PathVariable String name){
        List<String> books=bookService.searchByName(name);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/info/name/{name}")
    public ResponseEntity<List<Book>> infoByName(@PathVariable String name){
        List<Book> books=bookService.info(name);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/info/topic/{topic}")
    public ResponseEntity<List<Book>> infoByTopic(@PathVariable String topic){
        List<Book> books=bookService.infoByTopic(topic);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<Book> infoByName(@PathVariable Long id){
        Optional<Book> book=bookService.findById(id);
        if(book.isPresent()){
            Book book1=book.get();
            return new ResponseEntity<>(book1,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/info/cost/{id}")
    public ResponseEntity<Book> editPrice(@PathVariable Long id,@RequestParam Double cost){
        Optional<Book> book=bookService.findById(id);
        if(book.isPresent()){
            Book book1=book.get();
            book1.setCost(cost);
            bookService.save(book1);
            return new ResponseEntity<>(book1,HttpStatus.OK);
        }
        else {
            Book boook=new Book("null","null",-1,0.0);
            boook.setId((long) -1);
            return new ResponseEntity<>(boook,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/info/count/{id}")
    public ResponseEntity<Book> editCount(@PathVariable Long id,@RequestParam Integer count){
        Optional<Book> book=bookService.findById(id);
        if(book.isPresent()){
            Book book1=book.get();
            book1.setCount(count);
            bookService.save(book1);
            return new ResponseEntity<>(book1,HttpStatus.OK);
        }
        else {
            Book boook=new Book("null","null",-1,0.0);
            boook.setId((long) -1);
            return new ResponseEntity<>(boook,HttpStatus.BAD_REQUEST);
        }
    }
}
