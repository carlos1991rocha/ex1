package com.ex1.ex1;

import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.servlet.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping({"/book"})
public class BookController{
    @Autowired
    private BookRepository bookRepository;
    @PostMapping()
    public @ResponseBody Book create(@RequestBody final Book book){
        return bookRepository.save(book);
    }
    @GetMapping()
    public @ResponseBody Iterable <Book> getAll(){
        return bookRepository.findAll();
    }
    @GetMapping({"/{id}"})
    public @ResponseBody Optional <Book> getById(@PathVariable Integer id){
        return bookRepository.findById(id);
    }
    @DeleteMapping({"/{id}"})
    public @ResponseBody Optional <Book> deleteById (@PathVariable Integer id){
        Optional <Book> book=bookRepository.findById(id);
        bookRepository.deleteById(id);
        return book;
    }
    // @GetMapping({"/name/{name}"})
    // public @ResponseBody Book findByName(@PathVariable String name)
    // {
    //     return bookRepository.findByName(name);
    // }
    @GetMapping({"/author/{author}"})
    public @ResponseBody Book findByAuthor(@PathVariable String author)
    {
        return bookRepository.findByAuthor(author);
    }
    @GetMapping({"/name/{name}"})
    public @ResponseBody List<Book> findByPlaceIgnoreCaseContaining(@PathVariable String name)
    {
        return bookRepository.findByNameIgnoreCaseContaining(name);
    }

    // @Repository("BookRepository")
    // public interface RegisterUserRepository extends JpaRepository<Registration,Long>{

    // List<Registration> findByPlaceIgnoreCaseContaining(String place);

    // }
    
    
    
    
    
    
}