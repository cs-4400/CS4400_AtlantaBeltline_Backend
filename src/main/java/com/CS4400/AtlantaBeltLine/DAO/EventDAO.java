package com.CS4400.AtlantaBeltLine.DAO;

import com.CS4400.AtlantaBeltLine.DTO.EventDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EventDAO {

    public List<EventDAO> getAllEvents();
    public EventDTO getEvent(String eventName);
}
