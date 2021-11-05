package com.gaokao.main.VO;

import java.util.Objects;

public class UserAnaly {
    private String user_account;
    private int major_id;
    private int institution_id;

    public UserAnaly() {
    }

    public UserAnaly(String user_account, int major_id, int institution_id) {
        this.user_account = user_account;
        this.major_id = major_id;
        this.institution_id = institution_id;
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

    @Override
    public String toString() {
        return "UserAnaly{" +
                "user_account='" + user_account + '\'' +
                ", major_id=" + major_id +
                ", institution_id=" + institution_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAnaly userAnaly = (UserAnaly) o;
        return major_id == userAnaly.major_id &&
                institution_id == userAnaly.institution_id &&
                user_account.equals(userAnaly.user_account);
    }

}
