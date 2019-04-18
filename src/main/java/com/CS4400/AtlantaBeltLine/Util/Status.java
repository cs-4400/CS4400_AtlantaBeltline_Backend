package com.CS4400.AtlantaBeltLine.Util;

public enum Status {
    APPROVED("Approved"),
    PENDING("Pending"),
    DECLINED("Declined");

    public String status;

    Status(final String status) {this.status = status;}
}
