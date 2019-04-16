package com.CS4400.AtlantaBeltLine.DTO;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "event")
public class Event {

    private String event_name;
    private Date event_start;
    private String site_name;
    private Date end_date;
    private int event_price;
    private int capacity;
    private int min_staff;
    private String description;


    public Event() {
    }

    public Event(String event_name, Date event_start, String site_name, Date end_date, int event_price, int capacity, int min_staff, String description) {
        this.event_name = event_name;
        this.event_start = event_start;
        this.site_name = site_name;
        this.end_date = end_date;
        this.event_price = event_price;
        this.capacity = capacity;
        this.min_staff = min_staff;
        this.description = description;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public Date getEvent_start() {
        return event_start;
    }

    public void setEvent_start(Date event_start) {
        this.event_start = event_start;
    }

    public String getSite_name() {
        return site_name;
    }

    public void setSite_name(String site_name) {
        this.site_name = site_name;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public int getEvent_price() {
        return event_price;
    }

    public void setEvent_price(int event_price) {
        this.event_price = event_price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getMin_staff() {
        return min_staff;
    }

    public void setMin_staff(int min_staff) {
        this.min_staff = min_staff;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
