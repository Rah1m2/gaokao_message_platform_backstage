package com.gaokao.main.POJO;

/**
 * 对应数据库中的institution_admission_rule表
 */
public class AdmissionRule {
    private String institution_name;
    private String enroll_sequence;
    private String art_sort_enroll;
    private String bonus_policy;
    private String minority_policy;
    private String former_stu_policy;
    private String transfer_major_policy;
    private String other_info;

    public AdmissionRule() {
    }

    public AdmissionRule(String institution_name, String enroll_sequence, String art_sort_enroll, String bonus_policy, String minority_policy, String former_stu_policy, String transfer_major_policy, String other_info) {
        this.institution_name = institution_name;
        this.enroll_sequence = enroll_sequence;
        this.art_sort_enroll = art_sort_enroll;
        this.bonus_policy = bonus_policy;
        this.minority_policy = minority_policy;
        this.former_stu_policy = former_stu_policy;
        this.transfer_major_policy = transfer_major_policy;
        this.other_info = other_info;
    }

    public String getInstitution_name() {
        return institution_name;
    }

    public void setInstitution_name(String institution_name) {
        this.institution_name = institution_name;
    }

    public String getEnroll_sequence() {
        return enroll_sequence;
    }

    public void setEnroll_sequence(String enroll_sequence) {
        this.enroll_sequence = enroll_sequence;
    }

    public String getArt_sort_enroll() {
        return art_sort_enroll;
    }

    public void setArt_sort_enroll(String art_sort_enroll) {
        this.art_sort_enroll = art_sort_enroll;
    }

    public String getBonus_policy() {
        return bonus_policy;
    }

    public void setBonus_policy(String bonus_policy) {
        this.bonus_policy = bonus_policy;
    }

    public String getMinority_policy() {
        return minority_policy;
    }

    public void setMinority_policy(String minority_policy) {
        this.minority_policy = minority_policy;
    }

    public String getFormer_stu_policy() {
        return former_stu_policy;
    }

    public void setFormer_stu_policy(String former_stu_policy) {
        this.former_stu_policy = former_stu_policy;
    }

    public String getTransfer_major_policy() {
        return transfer_major_policy;
    }

    public void setTransfer_major_policy(String transfer_major_policy) {
        this.transfer_major_policy = transfer_major_policy;
    }

    public String getOther_info() {
        return other_info;
    }

    public void setOther_info(String other_info) {
        this.other_info = other_info;
    }

    @Override
    public String toString() {
        return "AdmissionRule{" +
                "institution_name='" + institution_name + '\'' +
                ", enroll_sequence='" + enroll_sequence + '\'' +
                ", art_sort_enroll='" + art_sort_enroll + '\'' +
                ", bonus_policy='" + bonus_policy + '\'' +
                ", minority_policy='" + minority_policy + '\'' +
                ", former_stu_policy='" + former_stu_policy + '\'' +
                ", transfer_major_policy='" + transfer_major_policy + '\'' +
                ", other_info='" + other_info + '\'' +
                '}';
    }
}
