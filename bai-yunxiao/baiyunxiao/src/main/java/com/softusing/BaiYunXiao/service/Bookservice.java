package com.softusing.BaiYunXiao.service;

import com.softusing.BaiYunXiao.entity.Book;
import com.softusing.BaiYunXiao.entity.BookExample;
import com.softusing.BaiYunXiao.mapperIterfac.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Bookservice {
    @Autowired
    private BookMapper bookMapper;

    public int save(Book book) {
        return bookMapper.insert(book);
    }


    public int delete(long id) {
       return bookMapper.deleteByExample(new BookExample());
    }

    public Book findById(long id) {
        return bookMapper.selectByPrimaryKey(id);
    }

    public List<Book> findAll() {
        return bookMapper.selectByExample(new BookExample());
    }


//    @Autowired
//    private BookRepository bookRepository;
//
//    public List<Book> findAll(){
//        return bookRepository.findAll();
//    }
//
//    public Book save(Book book){
//        return bookRepository.save(book);
//    }
//
//   public Book findOne(long id){
//        return bookRepository.findById(id).get();
//   }
//   public void delete(Long id){
//        bookRepository.deleteById(id);
//   }
//   //根据author查询
//   public List<Book> findByAuthor(String author){
//        return bookRepository.findByAuthor(author);
//   }
//
//   public List<Book> findByAuthorAndStatus(String author,int status){
//        return bookRepository.findByAuthorAndStatus(author,status);
//   }


}
