/*
    This file is part of the MapleQuestAdvisor planning tool    
    Copyleft (L) 2020 - 2021 RonanLana

    GNU General Public License v3.0

    Permissions of this strong copyleft license are conditioned on making available complete
    source code of licensed works and modifications, which include larger works using a licensed
    work, under the same license. Copyright and license notices must be preserved. Contributors
    provide an express grant of patent rights.
 */
package mqaservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mqaservice.bean.CharacterBean;

/**
 *
 * @author RonanLana
 */
public class CharacterDAOImpl implements CharacterDAO {
    
    @Override
    public CharacterBean prepare(Connection con, int id) throws SQLException {
        CharacterBean bean = new CharacterBean();
        
        PreparedStatement ps = con.prepareStatement("SELECT id, name, job, level, exp, map, meso, fame, gender FROM characters WHERE id=?;");
        ps.setInt(1, id);
        
        ResultSet rs = ps.executeQuery();
        try {
            if (rs.next()) {
                bean.setId(rs.getInt("id"));
                bean.setName(rs.getString("name"));
                bean.setJob(rs.getInt("job"));
                bean.setLevel(rs.getInt("level"));
                bean.setExp(rs.getInt("exp"));
                bean.setMap(rs.getInt("map"));
                bean.setMeso(rs.getInt("meso"));
                bean.setFame(rs.getShort("fame"));
                bean.setGender(rs.getShort("gender"));
            } else {
                throw new SQLException("NO DATA");
            }    
        } finally {
            rs.close();
            ps.close();
        }
        
        return bean;
    }
    
}
