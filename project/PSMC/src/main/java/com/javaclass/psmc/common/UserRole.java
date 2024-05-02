package com.javaclass.psmc.common;

public enum UserRole {

    d("d"),
    t("t");

    private String role;

    UserRole(String role){
        this.role=role;
    }

    public String getRole(){
        return this.role;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "role='" + role + '\'' +
                '}';
    }
}
