package com.gaokao.main.POJO;

/**
 * 对应数据库中的institution_intro表
 */
public class Introduction {
    private String institution_name;
    private String institution_introduction;

    public Introduction() {
    }

    public Introduction(String institution_name, String institution_introduction) {
        this.institution_name = institution_name;
        this.institution_introduction = institution_introduction;
    }

    public String getInstitution_name() {
        return institution_name;
    }

    public void setInstitution_name(String institution_name) {
        this.institution_name = institution_name;
    }

    public String getInstitution_introduction() {
        return institution_introduction;
    }

    public void setInstitution_introduction(String institution_introduction) {
        this.institution_introduction = institution_introduction;
    }

    @Override
    public String toString() {
        return "Introduction{" +
                "institution_name='" + institution_name + '\'' +
                ", institution_introduction='" + institution_introduction + '\'' +
                '}';
    }
}
