package com.gaokao.main.DTO;

public class Major {
    private int major_id;
    private String major_name;
    private String major_code;
    private String major_degree;
    private String major_class;
    private String major_category;
    private String major_introduction;

    public Major() {
    }

    public Major(int major_id, String major_name, String major_code, String major_degree, String major_class, String major_category, String major_introduction) {
        this.major_id = major_id;
        this.major_name = major_name;
        this.major_code = major_code;
        this.major_degree = major_degree;
        this.major_class = major_class;
        this.major_category = major_category;
        this.major_introduction = major_introduction;
    }

    public int getMajor_id() {
        return major_id;
    }

    public void setMajor_id(int major_id) {
        this.major_id = major_id;
    }

    public String getMajor_name() {
        return major_name;
    }

    public void setMajor_name(String major_name) {
        this.major_name = major_name;
    }

    public String getMajor_code() {
        return major_code;
    }

    public void setMajor_code(String major_code) {
        this.major_code = major_code;
    }

    public String getMajor_degree() {
        return major_degree;
    }

    public void setMajor_degree(String major_degree) {
        this.major_degree = major_degree;
    }

    public String getMajor_class() {
        return major_class;
    }

    public void setMajor_class(String major_class) {
        this.major_class = major_class;
    }

    public String getMajor_category() {
        return major_category;
    }

    public void setMajor_category(String major_category) {
        this.major_category = major_category;
    }

    public String getMajor_introduction() {
        return major_introduction;
    }

    public void setMajor_introduction(String major_introduction) {
        this.major_introduction = major_introduction;
    }

    @Override
    public String toString() {
        return "Major{" +
                "major_id=" + major_id +
                ", major_name='" + major_name + '\'' +
                ", major_code='" + major_code + '\'' +
                ", major_degree='" + major_degree + '\'' +
                ", major_class='" + major_class + '\'' +
                ", major_category='" + major_category + '\'' +
                ", major_introduction='" + major_introduction + '\'' +
                '}';
    }
}
