package com.softusing.BaiYunXiao.controller;

import com.softusing.BaiYunXiao.entity.Book;
import com.softusing.BaiYunXiao.service.Bookservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Controller
public class BookCtrl {
    @Autowired
    private Bookservice bookservice;

    @GetMapping("/books")
    public String list() {
        return "books";
    }

    @GetMapping("/books/{id}")
    public String detail(@PathVariable long id, Model model) {
        Book book = bookservice.findById(id);
        if (book == null) {
            book = new Book();
        }
        model.addAttribute("book", book);
        return "book";
    }

}
