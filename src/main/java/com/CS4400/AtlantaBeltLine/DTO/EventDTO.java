package com.CS4400.AtlantaBeltLine.DTO;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "event")
public class EventDTO {

   private String event_name;
   private Date event_start;
   private String site_name;
   private Date end_date;
   private int event_price;
   private int capacity;
   private int min_staff;
   private String description;

}
