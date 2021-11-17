package com.gaokao.main.DTO;

public class MajorClass {
    private int major_class_id;
    private int major_category_id;
    private String major_class;

    public MajorClass() {
    }

    public MajorClass(int major_class_id, int major_category_id, String major_class) {
        this.major_class_id = major_class_id;
        this.major_category_id = major_category_id;
        this.major_class = major_class;
    }

    public int getMajor_class_id() {
        return major_class_id;
    }

    public void setMajor_class_id(int major_class_id) {
        this.major_class_id = major_class_id;
    }

    public int getMajor_category_id() {
        return major_category_id;
    }

    public void setMajor_category_id(int major_category_id) {
        this.major_category_id = major_category_id;
    }

    public String getMajor_class() {
        return major_class;
    }

    public void setMajor_class(String major_class) {
        this.major_class = major_class;
    }

    @Override
    public String toString() {
        return "MajorClass{" +
                "major_class_id=" + major_class_id +
                ", major_category_id=" + major_category_id +
                ", major_class='" + major_class + '\'' +
                '}';
    }
}
