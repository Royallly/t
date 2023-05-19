package com.softusing.BaiYunXiao.form;

import com.softusing.BaiYunXiao.entity.User;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UserForm {
//    private Integer id;
//    public static final String PHONE_REG = "^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$";
//    @NotBlank(message = "不能为空")
//    private String userName;
//    @Pattern(regexp = PHONE_REG, message = "请输入正确手机号")
//    private String phoneNumber;
//    @Length(min = 6,message = "密码至少为6位")
//    private String password;
//    @Email
//    private String email;
//    @NotBlank(message = "不能为空")
//    private String confirmPassword;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getConfirmPassword() {
//        return confirmPassword;
//    }
//
//    public boolean confirmPassword() {
//        if (this.password.equals(this.confirmPassword)) {
//            return true;
//        }
//        return false;
//    }
//
//
//    public void setConfirmPassword(String confirmPassword) {
//        this.confirmPassword = confirmPassword;
//    }
//
//    public User convertToUser() {
//        User user = new UserFormConvert().convert(this);
//        return user;
//    }
//
//    private class UserFormConvert implements FormConvert<UserForm, User> {
//        public User convert(UserForm userForm) {
//            User user = new User();
//            BeanUtils.copyProperties(userForm, user);
//            return user;
//        }
//    }

    //用户名不能为空，密码至少为6位，确认密码不能为空，email格式，手机号的正确匹配[
    public static final String PHONE_REG = "^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$";
    private Integer id;
    @NotBlank(message = "用户名不能为空")
    private String userName;
    @Length(min = 6, message = "密码至少是6位")
    private String password;
    @NotBlank(message = "验证密码不能为空")
    private String confirmPassword;
    @Email
    private String email;
    @Pattern(regexp = PHONE_REG, message = "请输入正确手机号")
    private String phoneNumber;

    public UserForm() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean confirmPassword() {
        if (this.password.equals(this.confirmPassword)) {
            return true;
        } else {
            return false;
        }
    }

    private class UserFormConvert implements FormConvert<UserForm, User> {
        public User convert(UserForm userForm) {
            User user = new User();
            BeanUtils.copyProperties(userForm, user);
            return user;
        }
    }

    public User convertToUser() {
        User user = new UserFormConvert().convert(this);
        return user;
    }
}
