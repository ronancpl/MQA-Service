/*
    This file is part of the MapleQuestAdvisor planning tool    
    Copyleft (L) 2020 - 2021 RonanLana

    GNU General Public License v3.0

    Permissions of this strong copyleft license are conditioned on making available complete
    source code of licensed works and modifications, which include larger works using a licensed
    work, under the same license. Copyright and license notices must be preserved. Contributors
    provide an express grant of patent rights.
 */
package mqaservice;

import java.sql.Connection;
import java.sql.SQLException;

import mqaservice.bean.*;
import mqaservice.csv.*;
import mqaservice.dao.*;
import mqaservice.manipulator.*;
import tools.DBConnection;

/**
 *
 * @author RonanLana
 */
public class MQAService {
    
    private static String csvOutputDir = "../MapleQuestAdvisor/lib/userdata/";

    public static String csvRates() {
        String res = "";
        try {
            Connection con = DBConnection.getConnection();
            try {
                RatesDAOImpl di = new RatesDAOImpl();
                RatesBean bean = di.prepare(con);

                Object[] csvHdr = RatesManipulator.getCsvHeader();
                Object[] csvRws = RatesManipulator.toCsv(bean);

                res = CsvFileWriter.buildCsv(csvHdr, new Object[][]{csvRws});
            } finally {
                con.close();
            }    
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        
        return res;
    }
    
    public static String csvCharacter(int cid) {
        String res = "";
        try {
            Connection con = DBConnection.getConnection();
            try {
                CharacterDAOImpl di = new CharacterDAOImpl();
                CharacterBean bean = di.prepare(con, cid);

                Object[] csvHdr = CharacterManipulator.getCsvHeader();
                Object[] csvRws = CharacterManipulator.toCsv(bean);

                res = CsvFileWriter.buildCsv(csvHdr, new Object[][]{csvRws});
            } finally {
                con.close();
            }    
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        
        return res;
    }
    
    public static String csvInventory(int cid) {
        String res = "";
        try {
            Connection con = DBConnection.getConnection();
            try {
                InventoryDAOImpl di = new InventoryDAOImpl();
        
                Object[] csvHdr = InventoryManipulator.getCsvHeaderItems();
                InventoryBean bean = di.prepare(con, "inventoryitems", (String[])csvHdr, cid);

                Object[][] csvRws = InventoryManipulator.toCsv(bean);

                res = CsvFileWriter.buildCsv(csvHdr, csvRws);
            } finally {
                con.close();
            }    
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        
        return res;
    }
    
    public static String csvQuests(int cid) {
        String res = "";
        try {
            Connection con = DBConnection.getConnection();
            try {
                InventoryDAOImpl di = new InventoryDAOImpl();
        
                Object[] csvHdr = InventoryManipulator.getCsvHeaderQuests();
                InventoryBean bean = di.prepare(con, "queststatus", (String[])csvHdr, cid);

                Object[][] csvRws = InventoryManipulator.toCsv(bean);

                res = CsvFileWriter.buildCsv(new Object[]{"questid", "state"}, csvRws);
            } finally {
                con.close();
            }    
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int cid;
        try {
            cid = Integer.valueOf(args[0]);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            cid = 1;
        }
        
        csvRates();
        csvCharacter(cid);
        csvInventory(cid);
        csvQuests(cid);
    }
    
}
