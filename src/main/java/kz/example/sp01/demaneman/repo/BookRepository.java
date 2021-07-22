package kz.example.sp01.demaneman.repo;

import kz.example.sp01.demaneman.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Integer> {

}
