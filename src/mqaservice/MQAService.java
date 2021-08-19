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

    private static void postRates() {
        try {
            Connection con = DBConnection.getConnection();
            try {
                RatesDAOImpl di = new RatesDAOImpl();
                RatesBean bean = di.prepare(con);

                Object[] csvHdr = RatesManipulator.getCsvHeader();
                Object[] csvRws = RatesManipulator.toCsv(bean);

                CsvFileWriter.writeCsv(csvOutputDir + "rates.csv", csvHdr, new Object[][]{csvRws});
            } finally {
                con.close();
            }    
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    
    private static void postCharacter(int cid) {
        try {
            Connection con = DBConnection.getConnection();
            try {
                CharacterDAOImpl di = new CharacterDAOImpl();
                CharacterBean bean = di.prepare(con, cid);

                Object[] csvHdr = CharacterManipulator.getCsvHeader();
                Object[] csvRws = CharacterManipulator.toCsv(bean);

                CsvFileWriter.writeCsv(csvOutputDir + "character.csv", csvHdr, new Object[][]{csvRws});
            } finally {
                con.close();
            }    
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    
    private static void postInventory(int cid) {
        try {
            Connection con = DBConnection.getConnection();
            try {
                InventoryDAOImpl di = new InventoryDAOImpl();
        
                Object[] csvHdr = InventoryManipulator.getCsvHeaderItems();
                InventoryBean bean = di.prepare(con, "inventoryitems", (String[])csvHdr, cid);

                Object[][] csvRws = InventoryManipulator.toCsv(bean);

                CsvFileWriter.writeCsv(csvOutputDir + "inventory.csv", csvHdr, csvRws);
            } finally {
                con.close();
            }    
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    
    private static void postQuests(int cid) {
        try {
            Connection con = DBConnection.getConnection();
            try {
                InventoryDAOImpl di = new InventoryDAOImpl();
        
                Object[] csvHdr = InventoryManipulator.getCsvHeaderQuests();
                InventoryBean bean = di.prepare(con, "queststatus", (String[])csvHdr, cid);

                Object[][] csvRws = InventoryManipulator.toCsv(bean);

                CsvFileWriter.writeCsv(csvOutputDir + "quests.csv", new Object[]{"questid", "state"}, csvRws);
            } finally {
                con.close();
            }    
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        int cid;
        try {
            cid = Integer.valueOf(args[0]);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            cid = 1;
        }
        
        postRates();
        postCharacter(cid);
        postInventory(cid);
        postQuests(cid);
    }
    
}
