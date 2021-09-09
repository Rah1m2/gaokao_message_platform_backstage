package com.gaokao.main.POJO;

import javax.persistence.Transient;
import java.util.Arrays;

public class User {
    private int user_id;
    private String user_account;
    private String user_password;
    private String user_grade;
    private String user_address;
    private String user_sex;
    private String user_rank;
    private String[] user_interest;

    public User() {
    }

    public User(int user_id, String user_account, String user_password, String user_grade, String user_address, String user_sex, String user_rank, String[] user_interest) {
        this.user_id = user_id;
        this.user_account = user_account;
        this.user_password = user_password;
        this.user_grade = user_grade;
        this.user_address = user_address;
        this.user_sex = user_sex;
        this.user_rank = user_rank;
        this.user_interest = user_interest;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public String getUser_rank() {
        return user_rank;
    }

    public void setUser_rank(String user_rank) {
        this.user_rank = user_rank;
    }

    public String[] getUser_interest() {
        return user_interest;
    }

    public void setUser_interest(String[] user_interest) {
        this.user_interest = user_interest;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_account='" + user_account + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_grade='" + user_grade + '\'' +
                ", user_address='" + user_address + '\'' +
                ", user_sex='" + user_sex + '\'' +
                ", user_rank='" + user_rank + '\'' +
                ", user_interest='" + Arrays.toString(user_interest) + '\'' +
                '}';
    }
}
