package com.CS4400.AtlantaBeltLine.Util;

public enum User_Type {

    EMPLOYEE("Employee"),
    VISITOR("Visitor"),
    EMPLOYEE_VISITOR("Employee, Visitor");

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String type;

    User_Type(final String type) {
        this.type = type;
    }

}
