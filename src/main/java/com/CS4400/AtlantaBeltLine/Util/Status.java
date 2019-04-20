package com.CS4400.AtlantaBeltLine.Util;

public enum Status {
    APPROVED("Approved"),
    PENDING("Pending"),
    DECLINED("Declined");

    public String status;

    public static String getStatusString(Status status) {
        return status.status;
    }

    public static Status getStatusType(String status) {
        for (Status s : Status.values()) {
            if (status.equals(s.status)) {
                return s;
            }
        }
        return null;
    }

    Status(final String status) {this.status = status;}
}
