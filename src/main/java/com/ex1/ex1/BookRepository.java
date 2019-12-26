package com.ex1.ex1;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
public interface BookRepository extends CrudRepository <Book, Integer> {

    //public Book finydByName(String name);
    public Book findByAuthor(String author);
    public List<Book> findByNameIgnoreCaseContaining(String name);
}

