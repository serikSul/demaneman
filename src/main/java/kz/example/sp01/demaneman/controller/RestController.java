package kz.example.sp01.demaneman.controller;


import kz.example.sp01.demaneman.model.Book;
import kz.example.sp01.demaneman.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@org.springframework.web.bind.annotation.RestController
@RequestMapping(value ={ "/api"},produces = "application/json")
public class RestController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public Iterable<Book> getAllBook(){
        return bookService.getAllBook();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id){
      return bookService.getBookById(id);
    }

    @PostMapping(consumes = "application/json")
    public Book postBook(@RequestBody Book book){
        return bookService.postBook(book);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteBookById(@PathVariable("id")int id){
        bookService.deleteBookById(id);
    }

    @PutMapping("/{id}")
    public Book putBook(@RequestBody Book book){
        return bookService.putBook(book);
    }

    @PatchMapping(path = "/{id}",consumes = "application/json")
    public Book patchBook(@PathVariable("id") int id,@RequestBody Book book){
       return bookService.patchBook(id, book);
    }
}
