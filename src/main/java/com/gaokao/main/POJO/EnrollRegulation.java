package com.gaokao.main.POJO;

public class EnrollRegulation {
    private String institution_name;
    private String enroll_regulation_content;

    public EnrollRegulation() {
    }

    public EnrollRegulation(String institution_name, String enroll_regulation_content) {
        this.institution_name = institution_name;
        this.enroll_regulation_content = enroll_regulation_content;
    }

    public String getInstitution_name() {
        return institution_name;
    }

    public void setInstitution_name(String institution_name) {
        this.institution_name = institution_name;
    }

    public String getEnroll_regulation_content() {
        return enroll_regulation_content;
    }

    public void setEnroll_regulation_content(String enroll_regulation_content) {
        this.enroll_regulation_content = enroll_regulation_content;
    }

    @Override
    public String toString() {
        return "EnrollRegulation{" +
                "institution_name='" + institution_name + '\'' +
                ", enroll_regulation_content='" + enroll_regulation_content + '\'' +
                '}';
    }
}
