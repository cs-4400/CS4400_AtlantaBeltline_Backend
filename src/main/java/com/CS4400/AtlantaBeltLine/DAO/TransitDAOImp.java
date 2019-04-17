package com.CS4400.AtlantaBeltLine.DAO;

import com.CS4400.AtlantaBeltLine.DTO.TransitDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class TransitDAOImp implements TransitDAO {
    private static final Logger LOGGER = LogManager.getLogger(TransitDAO.class);

    private static final String SELECT_TRANSIT = "SELECT * FROM transit";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void saveTransit(TransitDTO transitDTO) {

    }

    @Override
    public TransitDTO getTransitByName(String name) {
        return null;
    }

    @Override
    public void updateTransit(TransitDTO transitDTO) {

    }

    @Override
    public void deleteTransit(String name) {

    }

    @Override
    public List<TransitDTO> getAllTransits() {

        return jdbcTemplate.query(SELECT_TRANSIT, (rs, i) -> {
            TransitDTO transitDTO = new TransitDTO();
            transitDTO.setRoute(rs.getString("route"));
            transitDTO.setType(rs.getString("type"));
            transitDTO.setPrice(rs.getInt("price"));
            return transitDTO;
        });
    }

    //        String sql = "SELECT * from TransitDTO";
//
//        List<TransitDTO> transitList = jdbcTemplate.query(sql, new ResultSetExtractor<List<TransitDTO>>() {
//            @Override
//            public List<TransitDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
//                List<TransitDTO> list = new ArrayList<>();
//                while(rs.next()) {
//                    TransitDTO transit = new TransitDTO();
//                    transit.setRoute(rs.getString(1));
//                    transit.setType(rs.getString(2));
//                    transit.setPrice(rs.getInt(3));
//                }
//                return list;
//            }
//        });
//        return transitList;
}
