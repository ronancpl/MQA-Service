/*
    This file is part of the MapleQuestAdvisor planning tool    
    Copyleft (L) 2020 - 2021 RonanLana

    GNU General Public License v3.0

    Permissions of this strong copyleft license are conditioned on making available complete
    source code of licensed works and modifications, which include larger works using a licensed
    work, under the same license. Copyright and license notices must be preserved. Contributors
    provide an express grant of patent rights.
 */
package mqaservice.manipulator;

import tools.Pair;

import mqaservice.bean.InventoryBean;

/**
 *
 * @author RonanLana
 */
public class InventoryManipulator {
    
    public static Object[] getCsvHeaderItems() {
        Object[] csvHeaders = new String[]{"itemid", "quantity"};
        return csvHeaders;
    }
    
    public static Object[] getCsvHeaderQuests() {
        Object[] csvHeaders = new String[]{"quest", "status"};
        return csvHeaders;
    }
    
    public static Object[][] toCsv(InventoryBean bean) {
        Object[][] csvFields = new Object[bean.get().size()][];
        
        int i = 0;
        for (Pair<Integer, Integer> p : bean.get()) {
            csvFields[i] = new Object[]{p.getLeft(), p.getRight()};
            i++;
        }
        
        return csvFields;
    }
    
}
