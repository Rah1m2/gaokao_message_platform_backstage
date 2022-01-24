package com.gaokao.main.VO;

public class QueryForm {
    private int major_id;
    private String institution_name;
    private String institution_location;
    private String institution_type;
    private String institution_feature;
    private String token;
    private int PageNum;
    private int PageSize;
    private int nextRequestBlock;

    public QueryForm() {
    }

    public QueryForm(int major_id, String institution_name, String institution_location, String institution_type, String institution_feature, String token, int pageNum, int pageSize, int nextRequestBlock) {
        this.major_id = major_id;
        this.institution_name = institution_name;
        this.institution_location = institution_location;
        this.institution_type = institution_type;
        this.institution_feature = institution_feature;
        this.token = token;
        PageNum = pageNum;
        PageSize = pageSize;
        this.nextRequestBlock = nextRequestBlock;
    }

    public int getMajor_id() {
        return major_id;
    }

    public void setMajor_id(int major_id) {
        this.major_id = major_id;
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

    public String getInstitution_feature() {
        return institution_feature;
    }

    public void setInstitution_feature(String institution_feature) {
        this.institution_feature = institution_feature;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getPageNum() {
        return PageNum;
    }

    public void setPageNum(int pageNum) {
        PageNum = pageNum;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }

    public int getNextRequestBlock() {
        return nextRequestBlock;
    }

    public void setNextRequestBlock(int nextRequestBlock) {
        this.nextRequestBlock = nextRequestBlock;
    }

    @Override
    public String toString() {
        return "QueryForm{" +
                "major_id=" + major_id +
                ", institution_name='" + institution_name + '\'' +
                ", institution_location='" + institution_location + '\'' +
                ", institution_type='" + institution_type + '\'' +
                ", institution_feature='" + institution_feature + '\'' +
                ", token='" + token + '\'' +
                ", PageNum=" + PageNum +
                ", PageSize=" + PageSize +
                ", nextRequestBlock=" + nextRequestBlock +
                '}';
    }
}
