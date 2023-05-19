package com.softusing.BaiYunXiao.service;

import com.softusing.BaiYunXiao.entity.Book;
import com.softusing.BaiYunXiao.entity.BookExample;
import com.softusing.BaiYunXiao.entity.MyPage;
import com.softusing.BaiYunXiao.mapperIterfac.BookMapper;
import com.softusing.BaiYunXiao.mapperIterfac.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Bookservice implements BookServiceInterface {
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

    public int update(Book book) {
        return bookMapper.updateByPrimaryKey(book);
    }

    public List<Book> queryBookByArray(int currPage, int pageSize, MyPage myPage) {
        //查询全部数据.
        List<Book> books = bookMapper.queryBookByArray();

        myPage.setTotalPage((int) Math.ceil(books.size() * 1.0 / pageSize));
        //从第几条数据开始
        int firstIndex = (currPage - 1) * pageSize;
        //到第几条数据结束
        int lastIndex;
        if (currPage < myPage.getTotalPage()){
                lastIndex = currPage * pageSize;
        }else {
            lastIndex = books.size();
        }
        return books.subList(firstIndex, lastIndex); //直接在list中截取
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
