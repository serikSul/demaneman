package kz.example.sp01.demaneman.controller;

import kz.example.sp01.demaneman.model.Book;
import kz.example.sp01.demaneman.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public String index(Model model){

        model.addAttribute("books",bookRepository.findAll());
        model.addAttribute("newbook",new Book());
        return "index";
    }

    @PostMapping
    public String createBook(Book book){
        bookRepository.save(book);
        return "redirect:/";

    }
}
