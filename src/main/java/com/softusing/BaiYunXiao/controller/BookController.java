package com.softusing.BaiYunXiao.controller;

import com.softusing.BaiYunXiao.entity.Book;
import com.softusing.BaiYunXiao.service.Bookservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookController {
    @Autowired
    private Bookservice bookservice;

    @GetMapping("/list")
    public List<Book> Ha() {
        return bookservice.findAll();

    }

    @PostMapping("/addBooks")
    public int post(@RequestParam String name,
                    @RequestParam String author,
                    @RequestParam String description,
                    @RequestParam int status) {
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setDescription(description);
        book.setStatus(status);
        return bookservice.save(book);
    }

    @GetMapping("/books/{id}")
    public Book getOne(@PathVariable long id) {
        return bookservice.findById(id);
    }

    //@PutMapping("/books")
//public  book update(@RequestParam String name,@RequestParam long id,
//                    @RequestParam String author,
//                    @RequestParam String description,
//                    @RequestParam int status){
//    book book=new book();
//    book.setId(id);
//    book.setName(name);
//    book.setAuthor(author);
//    book.setDescription(description);
//    book.setStatus(status);
//    return bookservice.save(book);
//}
    @DeleteMapping("/books/{id}")
    public void delete(@PathVariable long id) {
        bookservice.delete(id);
    }


//@PostMapping("/books/by")
//public List<Book> findBy(String author){
//        return bookservice.findByAuthor(author);
//}
//@PostMapping("/book/by")
//public List<Book> findBy(@RequestParam String author,@RequestParam int status){
//        return bookservice.findByAuthorAndStatus(author,status);
//}
}
