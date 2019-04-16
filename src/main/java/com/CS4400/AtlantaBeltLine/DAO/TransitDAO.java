package com.CS4400.AtlantaBeltLine.DAO;

import com.CS4400.AtlantaBeltLine.DTO.TransitDTO;

import java.util.List;

public interface TransitDAO {

    public void saveTransit(TransitDTO transitDTO);
    public TransitDTO getTransitByName(String name);
    public void updateTransit(TransitDTO transitDTO);
    public void deleteTransit(String name);
    public List<TransitDTO> getAllTransits();
}
