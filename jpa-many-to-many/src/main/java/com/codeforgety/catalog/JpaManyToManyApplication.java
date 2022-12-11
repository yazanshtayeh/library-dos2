package com.codeforgety.catalog;

import com.codeforgety.catalog.model.Book;
import com.codeforgety.catalog.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JpaManyToManyApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext=
				SpringApplication.run(JpaManyToManyApplication.class, args);

		BookRepository bRepository =
				configurableApplicationContext.getBean(BookRepository.class);


//		Book book1=new Book("How to get a good grade in DOS in 40 minutes a day"," distributed systems",10,10.0);
//		Book book2=new Book("RPCs for Noobs"," distributed systems",10,10.0);
//		Book book3=new Book("Xen and the Art of Surviving Undergraduate School"," undergraduate school",10,10.0);
//		Book book4=new Book("Cooking for the Impatient Undergrad"," undergraduate school",10,10.0);
//		Book book5=new Book("How to finish Project 3 on time"," distributed systems",6,10.0);
//		Book book6=new Book("Why theory classes are so hard."," undergraduate school",2,10.0);
//		Book book7=new Book("Spring in the Pioneer Valley"," undergraduate school",5,10.0);
//
//		bRepository.save(book1);
//		bRepository.save(book2);
//		bRepository.save(book3);
//		bRepository.save(book4);
//		bRepository.save(book5);
//		bRepository.save(book6);
//		bRepository.save(book7);





	}

}
