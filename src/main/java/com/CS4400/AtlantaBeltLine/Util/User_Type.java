package com.CS4400.AtlantaBeltLine.Util;

public enum User_Type {

    EMPLOYEE("employee"),
    VISITOR("visitor"),
    EMPLOYEE_VISITOR("employee, visitor");

    public String type;

    User_Type(final String type) {this.type = type;}

}
