package com.example.front.controller;


import com.example.front.exceptions.noBookWithThisIdExceptuon;
import com.example.front.model.Book;
import com.example.front.service.FrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;


@RestController
@RequestMapping("/")
public class FrontController {
    private final FrontService frontService;
    @Autowired
    public FrontController(FrontService frontService) {
        this.frontService = frontService;
    }

    @GetMapping("/search/topic/{topic}")

    public ResponseEntity<List<String>> searchByTopic(@PathVariable String topic){
        List<String> books=frontService.searchByTopic(topic);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/search/name/{name}")
    public ResponseEntity<List<String>> searchByName(@PathVariable String name){
        System.out.println(name);
        List<String> books=frontService.searchByName(name);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/info/topic/{topic}")
    public ResponseEntity<List<Book>> infoByTopic(@PathVariable String topic){
        List<Book> books=frontService.infoByTopic(topic);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/info/name/{name}")
    public ResponseEntity<List<Book>> infoByName(@PathVariable String name){
        List<Book> books=frontService.info(name);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<Book> infoByName(@PathVariable Long id) throws noBookWithThisIdExceptuon {
        if(id>7) {
            throw new noBookWithThisIdExceptuon();

        }
        Book book=frontService.findById(id);
        return new ResponseEntity<>(book,HttpStatus.OK);
    }


    @GetMapping("/info/cost/{id}")
    public ResponseEntity<Book> editPrice(@PathVariable Long id,@RequestParam Double cost){
        Book book = frontService.editPrice(id,cost);
        return new ResponseEntity<>(book,HttpStatus.OK);

    }

    @GetMapping("/info/count/{id}")
    public ResponseEntity<Book> editCount(@PathVariable Long id,@RequestParam Long count){
        Book book = frontService.editCount(id,count);
        return new ResponseEntity<>(book,HttpStatus.OK);

    }

    @GetMapping("/purchase/{id}")
    public ResponseEntity<Book> purchase(@PathVariable Long id){
        System.out.println(id);
        Book book=frontService.purchase(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}
