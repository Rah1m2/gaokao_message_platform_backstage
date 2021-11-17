package com.gaokao.main.DTO;

/**
 * 对应数据库中的major_category表
 */
public class MajorCategory {
    private String major_category_id;
    private String major_category;

    public MajorCategory() {
    }

    public MajorCategory(String major_category_id, String major_category) {
        this.major_category_id = major_category_id;
        this.major_category = major_category;
    }

    public String getMajor_category_id() {
        return major_category_id;
    }

    public void setMajor_category_id(String major_category_id) {
        this.major_category_id = major_category_id;
    }

    public String getMajor_category() {
        return major_category;
    }

    public void setMajor_category(String major_category) {
        this.major_category = major_category;
    }

    @Override
    public String toString() {
        return "MajorCategory{" +
                "major_category_id='" + major_category_id + '\'' +
                ", major_category='" + major_category + '\'' +
                '}';
    }
}
