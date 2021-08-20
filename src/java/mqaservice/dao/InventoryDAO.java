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
import java.sql.SQLException;

import mqaservice.bean.InventoryBean;

/**
 *
 * @author RonanLana
 */
public interface InventoryDAO {
    
    public InventoryBean prepare(Connection con, String tableName, String[] colNames, int cid) throws SQLException;
    
}
