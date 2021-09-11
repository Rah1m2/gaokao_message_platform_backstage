package com.gaokao.main.POJO;

/**
 * 对应数据库中的institution_info表
 */
public class Institution {
    private int institution_id;
    private String institution_name;
    private String institution_location;
    private String institution_type;
    private String institution_degree;
    private String institution_feature;
    private String institution_url;
    private String contact_number;

    public Institution() {
    }

    public Institution(int institution_id, String institution_name, String institution_location, String institution_type, String institution_degree, String institution_feature, String institution_url, String contact_number) {
        this.institution_id = institution_id;
        this.institution_name = institution_name;
        this.institution_location = institution_location;
        this.institution_type = institution_type;
        this.institution_degree = institution_degree;
        this.institution_feature = institution_feature;
        this.institution_url = institution_url;
        this.contact_number = contact_number;
    }

    public int getInstitution_id() {
        return institution_id;
    }

    public void setInstitution_id(int institution_id) {
        this.institution_id = institution_id;
    }

    public String getInstitution_name() {
        return institution_name;
    }

    public void setInstitution_name(String institution_name) {
        this.institution_name = institution_name;
    }

    public String getInstitution_location() {
        return institution_location;
    }

    public void setInstitution_location(String institution_location) {
        this.institution_location = institution_location;
    }

    public String getInstitution_type() {
        return institution_type;
    }

    public void setInstitution_type(String institution_type) {
        this.institution_type = institution_type;
    }

    public String getInstitution_degree() {
        return institution_degree;
    }

    public void setInstitution_degree(String institution_degree) {
        this.institution_degree = institution_degree;
    }

    public String getInstitution_feature() {
        return institution_feature;
    }

    public void setInstitution_feature(String institution_feature) {
        this.institution_feature = institution_feature;
    }

    public String getInstitution_url() {
        return institution_url;
    }

    public void setInstitution_url(String institution_url) {
        this.institution_url = institution_url;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    @Override
    public String toString() {
        return "Institution{" +
                "institution_id=" + institution_id +
                ", institution_name='" + institution_name + '\'' +
                ", institution_location='" + institution_location + '\'' +
                ", institution_type='" + institution_type + '\'' +
                ", institution_degree='" + institution_degree + '\'' +
                ", institution_feature='" + institution_feature + '\'' +
                ", institution_url='" + institution_url + '\'' +
                ", contact_number='" + contact_number + '\'' +
                '}';
    }
}
