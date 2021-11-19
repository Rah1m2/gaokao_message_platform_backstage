package com.gaokao.main.DTO;

/**
 * 对应数据库中的institution_type_info表
 */
public class InstType {
    private int institution_type_id;
    private String institution_type;

    public InstType() {
    }

    public InstType(int institution_type_id, String institution_type) {
        this.institution_type_id = institution_type_id;
        this.institution_type = institution_type;
    }

    public int getInstitution_type_id() {
        return institution_type_id;
    }

    public void setInstitution_type_id(int institution_type_id) {
        this.institution_type_id = institution_type_id;
    }

    public String getInstitution_type() {
        return institution_type;
    }

    public void setInstitution_type(String institution_type) {
        this.institution_type = institution_type;
    }

    @Override
    public String toString() {
        return "InstType{" +
                "institution_type_id=" + institution_type_id +
                ", institution_type='" + institution_type + '\'' +
                '}';
    }
}
