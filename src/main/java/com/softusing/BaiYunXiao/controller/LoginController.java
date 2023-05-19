package com.softusing.BaiYunXiao.controller;

import com.softusing.BaiYunXiao.entity.User;
//import com.softusing.BaiYunXiao.form.UserForm;
import com.softusing.BaiYunXiao.mapperIterfac.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

//@Controller
@Controller
public class LoginController {
    //    @Autowired
//    private UserServiceInterface userServiceInterface;
//
//
//    @GetMapping("/register")
//    public String registerPage(Model model) {
//        model.addAttribute("userForm",new UserForm());
//        return "register";
//    }
//
//    @GetMapping("/login")
//    public String loginPage() {
//        return "login";
//    }
//
//    @PostMapping("/register")
//    public String register(@Valid UserForm userForm, BindingResult result) {
//        if (!userForm.confirmPassword()){
//            result.rejectValue("confirmPassword", "confirmError","两次密码不一致");
//        }
//        if (result.hasErrors()){
//            return "register";
//        }
////        boolean boo = true;
////        if (!userForm.confirmPassword()) {
////            result.rejectValue("confirmPassword", "两次密码不一致", "confirmError");
////            boo = false;
////        }
////        if (result.hasErrors()) {
////            List<FieldError> fieldErrors = result.getFieldErrors();
////            for (FieldError error : fieldErrors) {
////                System.out.println(error.getField() + " : " + error.getDefaultMessage() + " : " + error.getCode());
////            }
////            boo = false;
////        }
////        if (!boo) {
////            return "register";
////        }
//        User user = userForm.convertToUser();
//        userServiceInterface.save(user);
//        return "redirect:/login";
//    }
    @GetMapping("/exception")
    public String exception() {
        throw new RuntimeException();
    }

    @Autowired
    private UserServiceInterface userServiceInterface;

    //登陆界面
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/result")
    public String result(HttpServletRequest req) {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        boolean flag = userServiceInterface.login(user);
        if (flag == true) {
            return "redirect:/user-list";
        } else {
            return "Middle";
        }
    }
    @GetMapping("/middle")
    public String middle() {
        return "middle";
    }

    //注册界面如果注册成功返回登陆界面
    //1.Get 注解 需要注册界面（用户名，密码，确认密钥，邮件，电话号）  2.Post 注解 注册界面里面传值，储存进数据库；3.判断密码
    @GetMapping("/register")
    public String LoginPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    // BindingResult前端页面检查，省去大量逻辑判断
    public String returnLoginPage(@Valid User user, BindingResult result) {
//        if (!userForm.confirmPassword()) {
//            result.rejectValue("confirmPassword", "error", "两次密码不一致");
//        }
        if (result.hasErrors()) {
            return "register";
        }
        User user1 = new User();
        userServiceInterface.save(user1);
        return "redirect:/login";
    }

    @GetMapping("/user-list")
    public String userList(Model model){
        List<User> userList = userServiceInterface.findAll();
        model.addAttribute("userList",userList);
        return "userList";
    }
}
