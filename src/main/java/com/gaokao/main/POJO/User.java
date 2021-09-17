package com.gaokao.main.POJO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Transient;
import java.util.Arrays;

/**
 * 对应数据库中的user_info表
 */
public class User {
    private String user_account;
    private String user_password;
    private String user_grade;
    private String user_address;
    private String user_sex;
    private String user_degree;
    @Transient
    private String[] user_interest;

    public User() {
    }

    public User(String user_account, String user_password, String user_grade, String user_address, String user_sex, String user_degree, String[] user_interest) {
        this.user_account = user_account;
        this.user_password = user_password;
        this.user_grade = user_grade;
        this.user_address = user_address;
        this.user_sex = user_sex;
        this.user_degree = user_degree;
        this.user_interest = user_interest;
    }


    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_grade() {
        return user_grade;
    }

    public void setUser_grade(String user_grade) {
        this.user_grade = user_grade;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public String getuser_degree() {
        return user_degree;
    }

    public void setuser_degree(String user_degree) {
        this.user_degree = user_degree;
    }

    @Transient
    public String[] getUser_interest() {
        return user_interest;
    }

    @Transient
    public void setUser_interest(String[] user_interest) {
        this.user_interest = user_interest;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_account='" + user_account + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_grade='" + user_grade + '\'' +
                ", user_address='" + user_address + '\'' +
                ", user_sex='" + user_sex + '\'' +
                ", user_degree='" + user_degree + '\'' +
                ", user_interest=" + Arrays.toString(user_interest) +
                '}';
    }
}
