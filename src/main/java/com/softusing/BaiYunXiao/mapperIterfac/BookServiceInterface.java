package com.softusing.BaiYunXiao.mapperIterfac;

import com.softusing.BaiYunXiao.entity.Book;
import com.softusing.BaiYunXiao.entity.MyPage;

import java.util.List;

public interface BookServiceInterface {
    List<Book> findAll();

    Book findById(long id);

    int save(Book book);

    int update(Book book);

    List<Book> queryBookByArray(int currPage, int pageSize, MyPage myPage);
}
