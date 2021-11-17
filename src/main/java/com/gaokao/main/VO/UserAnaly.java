package com.gaokao.main.VO;


public class UserAnaly {
    private String user_account;
    private int major_id;
    private int institution_id;
    private int institution_degree_num;
    private int institution_type_id;
    private int institution_feature_num;
    private int province_id;


    public UserAnaly() {
    }

    public UserAnaly(String user_account, int major_id, int institution_id, int institution_degree_num, int institution_type_id, int institution_feature_num, int province_id) {
        this.user_account = user_account;
        this.major_id = major_id;
        this.institution_id = institution_id;
        this.institution_degree_num = institution_degree_num;
        this.institution_type_id = institution_type_id;
        this.institution_feature_num = institution_feature_num;
        this.province_id = province_id;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public int getMajor_id() {
        return major_id;
    }

    public void setMajor_id(int major_id) {
        this.major_id = major_id;
    }

    public int getInstitution_id() {
        return institution_id;
    }

    public void setInstitution_id(int institution_id) {
        this.institution_id = institution_id;
    }

    public int getInstitution_degree_num() {
        return institution_degree_num;
    }

    public void setInstitution_degree_num(int institution_degree_num) {
        this.institution_degree_num = institution_degree_num;
    }

    public int getInstitution_type_id() {
        return institution_type_id;
    }

    public void setInstitution_type_id(int institution_type_id) {
        this.institution_type_id = institution_type_id;
    }

    public int getInstitution_feature_num() {
        return institution_feature_num;
    }

    public void setInstitution_feature_num(int institution_feature_num) {
        this.institution_feature_num = institution_feature_num;
    }

    public int getProvince_id() {
        return province_id;
    }

    public void setProvince_id(int province_id) {
        this.province_id = province_id;
    }

    @Override
    public String toString() {
        return "UserAnaly{" +
                "user_account='" + user_account + '\'' +
                ", major_id=" + major_id +
                ", institution_id=" + institution_id +
                ", institution_degree_num=" + institution_degree_num +
                ", institution_type_id=" + institution_type_id +
                ", institution_feature_num=" + institution_feature_num +
                ", province_id=" + province_id +
                '}';
    }
}
