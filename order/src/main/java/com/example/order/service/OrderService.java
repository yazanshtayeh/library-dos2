package com.example.order.service;


import com.example.order.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    int[] ports={8081,9081};
    int num=0;
    int port=9081;

    private final RestTemplate restTemplate;
    @Autowired
    public OrderService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Book getBook(Long id) {
        String url = "http://localhost:"+port+"/info/"+id;
        this.changePort();
        return this.restTemplate.getForObject(url, Book.class);
    }

    public Book setNewCount(Integer cost,Long id) {
        String url = "http://localhost:"+port+"/info/count/"+id+"?count="+cost;
        this.changePort();
        return this.restTemplate.getForObject(url,Book.class);
    }
    public void changePort(){
        port=ports[num];
        num=(num+1)%2;
    }

}
