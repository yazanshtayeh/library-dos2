package com.example.order.controller;

import com.example.order.model.Book;
import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class OrderController {

    private final OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/purchase/{id}")
    public ResponseEntity<Book> purchase(@PathVariable Long id){
        System.out.println(id);
        Book book=orderService.getBook(id);
        if(book.getCount()>0){
            orderService.setNewCount(book.getCount()-1, id);
                book.setCount(book.getCount()-1);
        }
        return new ResponseEntity<>(book, HttpStatus.BAD_REQUEST);
    }
}
