package com.softusing.BaiYunXiao.controller;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api")
public class UserController {

//@Autowired
//private Book book;



    @GetMapping("/books")
    public Object aaa(){
        HashMap<String,Object> map=new HashMap<>();
        map.put("name","age");
        map.put("John","18");
        return map;
    }

    @GetMapping("/apple")
    public Object bbb(@RequestParam("page") int page,@RequestParam("size") int size){
        HashMap<String,Object> map=new HashMap<>();
        map.put("name","书");
        map.put("isbn","897987878");
        map.put("author","John");
        HashMap<String,Object> map1=new HashMap<>();
        map1.put("name","书2");
        map1.put("isbn","897978");
        map1.put("author","Tom");
        List<Map> contect=new ArrayList<>();
        contect.add(map);
        contect.add(map1);
        HashMap<String,Object> ccc=new HashMap<>();
        ccc.put("page",page);
        ccc.put("size",size);
        ccc.put("contect",contect);
        return ccc;
    }



    @GetMapping("/hello")
    public String sayHello() {
        return "Hello!";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getAllUser() {
        return "Hello Spring Boot";
    }



    @GetMapping("/books/{id}/{username}")
    public Object getone(@PathVariable long id,@PathVariable String username){
        System.out.println("....id :"+id+"username"+username);
        Map<String,Object> book=new HashMap<>();
        book.put("name","age");
        book.put("author","0987");
        book.put("tom","jjjjj");
        book.put("username",username);

        return book;
    }
    @PostMapping("/book")
    public Object post(@RequestParam("name") String name,@RequestParam("author") String author,@RequestParam("isbn") String isbn){
        Map<String,Object> book=new HashMap<>();
        book.put("name",name);
        book.put("author",author);
        book.put("isbn",isbn);
        return book;
    }


}