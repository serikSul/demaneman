package kz.example.sp01.demaneman.controller;


import kz.example.sp01.demaneman.model.Book;
import kz.example.sp01.demaneman.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value ={ "/api"},produces = "application/json")
public class RestController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public Iterable<Book> getAllBook(){
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id){
        Optional<Book> bookOptional= bookRepository.findById(id);
        if (bookOptional.isPresent()){
         return    new ResponseEntity<>(bookOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json")
    public Book postBook(@RequestBody Book book){
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteBookById(@PathVariable("id")int id){
        bookRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Book putBook(@RequestBody Book book){
        return bookRepository.save(book);
    }

    @PatchMapping(path = "/{id}",consumes = "application/json")
    public Book patchBook(@PathVariable("id") int id,@RequestBody Book book){
        Book bookUpdate=bookRepository.findById(id).get();
        if (book.getAuthor()!=null){
            bookUpdate.setAuthor(book.getAuthor());
        }
        if (book.getName()!=null){
            bookUpdate.setName(book.getName());
        }
        return bookRepository.save(bookUpdate);
    }
}
