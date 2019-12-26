package com.ex1.ex1;


import org.springframework.data.repository.CrudRepository;
public interface BookRepository extends CrudRepository <Book, Integer> {

    public Book findByName(String name);
    public Book findByAuthor(String author);
}

