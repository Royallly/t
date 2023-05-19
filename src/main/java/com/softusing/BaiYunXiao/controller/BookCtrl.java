package com.softusing.BaiYunXiao.controller;

import com.softusing.BaiYunXiao.entity.Book;
import com.softusing.BaiYunXiao.entity.MyPage;
import com.softusing.BaiYunXiao.exception.BookNotFoundException;
import com.softusing.BaiYunXiao.mapperIterfac.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookCtrl {
    @Autowired
    private BookServiceInterface bookServiceInterface;

    @GetMapping("/book")
    public String list() {
        return "book1";
    }


//    @GetMapping("/books/bookList")
//    public String details(Model model) {
//        List<Book> bookList = bookServiceInterface.findAll();
//        if (bookList == null) {
//            bookList = new ArrayList<>();
//        }
//        model.addAttribute("bookList", bookList);
//        return "books";
//    }

    @GetMapping("/books/{id}")
    public String detail(@PathVariable long id, Model model) {
        Book book = bookServiceInterface.findById(id);
        if (book == null) {
           throw new BookNotFoundException("该书单不存在");
        }
        model.addAttribute("book", book);
        return "book";
    }

    @GetMapping("/books/input")
    public String inputPage(Model model) {
        model.addAttribute("book", new Book());
        return "input";
    }

    @PostMapping("/books")
    public String post(Book book, final RedirectAttributes attributes) {
        if (book.getId() == null) {
            bookServiceInterface.save(book);
            attributes.addFlashAttribute("message", "《" + book.getName() + "》信息提交成功");

        } else {
            bookServiceInterface.update(book);
            attributes.addFlashAttribute("message", "《" + book.getName() + "》信息提交成功");
        }
        return "redirect:/books";
    }

    @GetMapping("/books/{id}/input")
    public String inputEditPage(@PathVariable long id, Model model) {
        Book book = bookServiceInterface.findById(id);
        if (book == null) {
            book = new Book();
        }
        model.addAttribute("book", book);
        return "input";
    }

    @GetMapping("/books")
    public String getBookByArray(@RequestParam(defaultValue = "1") int currPage, @RequestParam(defaultValue = "5") int pageSize, MyPage myPage, Model model) {
        List<Book> bookList = bookServiceInterface.queryBookByArray(currPage, pageSize, myPage);
        model.addAttribute("bookList", bookList);
        myPage.setThisPage(currPage);
        myPage.setPageSize(pageSize);
        model.addAttribute("page", myPage);
        return "books";
    }
}
