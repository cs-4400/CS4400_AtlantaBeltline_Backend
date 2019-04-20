package com.CS4400.AtlantaBeltLine.Util;

public enum User_Type {

    EMPLOYEE("Employee"),
    VISITOR("Visitor"),
    EMPLOYEE_VISITOR("Employee, Visitor"),
    USER("User");

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String type;

    public static User_Type getUserType(String type) {
        for (User_Type t : User_Type.values()) {
            if (type.equals(t.type)) {
                return t;
            }
        }
        return null;
    }

    User_Type(final String type) {
        this.type = type;
    }

}
