package com.gaokao.main.POJO;

public class UserMajorAgency {
    private int user_major_id;
    private String user_account;
    private String major_sort;
    private int sort_preference;

    public UserMajorAgency() {
    }

    public UserMajorAgency(int user_major_id, String user_account, String major_sort, int sort_preference) {
        this.user_major_id = user_major_id;
        this.user_account = user_account;
        this.major_sort = major_sort;
        this.sort_preference = sort_preference;
    }

    public int getUser_major_id() {
        return user_major_id;
    }

    public void setUser_major_id(int user_major_id) {
        this.user_major_id = user_major_id;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getMajor_sort() {
        return major_sort;
    }

    public void setMajor_sort(String major_sort) {
        this.major_sort = major_sort;
    }

    public int getSort_preference() {
        return sort_preference;
    }

    public void setSort_preference(int sort_preference) {
        this.sort_preference = sort_preference;
    }

    @Override
    public String toString() {
        return "UserMajorAgency{" +
                "user_major_id=" + user_major_id +
                ", user_account='" + user_account + '\'' +
                ", major_sort='" + major_sort + '\'' +
                ", sort_preference=" + sort_preference +
                '}';
    }
}
