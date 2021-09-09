package com.gaokao.main.VO;

public class LoginForm {
    private String user_account;
    private String user_password;

    public LoginForm() {
    }

    public LoginForm(String user_account, String user_password) {
        this.user_account = user_account;
        this.user_password = user_password;
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

    @Override
    public String toString() {
        return "LoginForm{" +
                "user_account='" + user_account + '\'' +
                ", user_password='" + user_password + '\'' +
                '}';
    }
}
