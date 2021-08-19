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
import tools.Pair;

import mqaservice.bean.InventoryBean;

/**
 *
 * @author RonanLana
 */
public class InventoryDAOImpl implements InventoryDAO {
    
    @Override
    public InventoryBean prepare(Connection con, String tableName, String[] colNames, int cid) throws SQLException {
        InventoryBean bean = new InventoryBean();
        
        String s = "";
        for (String tr : colNames) {
            s += tr + ",";
        }
        s = s.substring(0, s.length() - 1);
        
        PreparedStatement ps = con.prepareStatement("SELECT " + s + " FROM " + tableName + " WHERE characterid=?;");
        ps.setInt(1, cid);
        
        ResultSet rs = ps.executeQuery();
        try {
            while (rs.next()) {
                Integer[] ir = new Integer[colNames.length];
                for (int i = 0; i < colNames.length; i++) {
                    ir[i] = rs.getInt(colNames[i]);
                }
                
                bean.add(new Pair<>(ir[0], ir[1]));
            }    
        } finally {
            rs.close();
            ps.close();
        }
        
        return bean;
    }
    
}
