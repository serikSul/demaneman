package kz.example.sp01.demaneman.services;

import kz.example.sp01.demaneman.model.Book;
import kz.example.sp01.demaneman.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Iterable<Book> getAllBook(){
       return bookRepository.findAll();
    }

    public ResponseEntity<Book> getBookById(int id){
        Optional<Book> bookOptional= bookRepository.findById(id);
        if (bookOptional.isPresent()){
            return    new ResponseEntity<>(bookOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    public Book postBook(Book book){
        return bookRepository.save(book);
    }

    public void deleteBookById(int id){
        bookRepository.deleteById(id);
    }

    public Book putBook(Book book){
        return bookRepository.save(book);
    }

    public Book patchBook(int id, Book book){
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
