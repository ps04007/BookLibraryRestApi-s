package com.library.book.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.library.book.library")
@ComponentScan(basePackages = "com.library.book.library")
@EntityScan("com.library.book.library")
public class BookLibraryApplication {

    public static void main(String[] args) {

        SpringApplication.run(BookLibraryApplication.class, args);
    }


}
