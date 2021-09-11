package com.gaokao.main.VO;

public class QueryForm {
    private String institution_name;
    private String institution_location;
    private String institution_type;
    private String institution_feature;
    private int PageNum;
    private int PageSize;

    public QueryForm() {
    }

    public QueryForm(String institution_name, String institution_location, String institution_type, String institution_feature, int pageNum, int pageSize) {
        this.institution_name = institution_name;
        this.institution_location = institution_location;
        this.institution_type = institution_type;
        this.institution_feature = institution_feature;
        PageNum = pageNum;
        PageSize = pageSize;
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

    @Override
    public String toString() {
        return "QueryForm{" +
                "institution_name='" + institution_name + '\'' +
                ", institution_location='" + institution_location + '\'' +
                ", institution_type='" + institution_type + '\'' +
                ", institution_feature='" + institution_feature + '\'' +
                ", PageNum=" + PageNum +
                ", PageSize=" + PageSize +
                '}';
    }
}
