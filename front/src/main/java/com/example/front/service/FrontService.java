package com.example.front.service;

import com.example.front.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FrontService {
    int[] orderPorts={9082,8082};
    int[] catalogPorts={9081,8081};
    int catalogPort=9081;
    int orderPort=9082;
    int orderNum=0;
    int catalogNum=0;
    private final RestTemplate restTemplate;

    @Autowired
    public FrontService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    @Cacheable(value="name")
    public List<String> searchByName(String name){
        String url = "http://localhost:"+catalogPort+"/search/name/"+name;
        changeCatalogPort();
        return this.restTemplate.getForObject(url,List.class);

    }
    @Cacheable(value="name")
    public List<String> searchByTopic(String topic) {
        String url = "http://localhost:"+catalogPort+"/search/topic/"+topic;
        changeCatalogPort();
        return this.restTemplate.getForObject(url,List.class);
    }
    @Cacheable(value="book", key="#id")
    public List<Book> infoByTopic(String topic) {
        String url = "http://localhost:"+catalogPort+"/info/topic/"+topic;
        changeCatalogPort();
        return this.restTemplate.getForObject(url,List.class);
    }
    @Cacheable(value="book", key="#id")
    public List<Book> info(String name) {
        String url = "http://localhost:"+catalogPort+"/info/name/"+name;
        changeCatalogPort();
        return this.restTemplate.getForObject(url,List.class);
    }

    @Cacheable(value="book", key="#id")
    public Book findById(Long id) {
        String url = "http://localhost:"+catalogPort+"/info/"+id;
        changeCatalogPort();
        return this.restTemplate.getForObject(url,Book.class);
    }
    @CacheEvict(value = "book", key = "#id")
    public Book editPrice(Long id,Double cost){
        String url = "http://localhost:"+catalogPort+"/info/cost/"+id+"?cost="+cost;
        changeCatalogPort();
        return this.restTemplate.getForObject(url,Book.class);
    }
    @CacheEvict(value = "book", key = "#id")
    public Book editCount(Long id, Long count) {
        String url = "http://localhost:"+catalogPort+"/info/count/"+id+"?count="+count;
        changeCatalogPort();
        return this.restTemplate.getForObject(url,Book.class);
    }
    @CacheEvict(value = "book", key = "#id")
    public Book purchase(Long id) {
        String url = "http://localhost:"+orderPort+"/purchase/"+id;
        changeOrderPort();
        return this.restTemplate.getForObject(url,Book.class);
    }

    public void changeOrderPort(){
        orderPort=orderPorts[orderNum];
        orderNum=(orderNum+1)%2;
    }
    public void changeCatalogPort(){
        catalogPort=catalogPorts[catalogNum];
        catalogNum=(catalogNum+1)%2;
    }
}
