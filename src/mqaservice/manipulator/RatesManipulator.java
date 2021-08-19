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

import mqaservice.bean.RatesBean;

/**
 *
 * @author RonanLana
 */
public class RatesManipulator {
    
    public static Object[] getCsvHeader() {
        Object[] csvHeaders = new String[]{"exp", "meso", "drop"};
        return csvHeaders;
    }
    
    public static Object[] toCsv(RatesBean bean) {
        Object[] csvFields = new Object[3];
        csvFields[0] = bean.getExpRate();
        csvFields[1] = bean.getMesoRate();
        csvFields[2] = bean.getDropRate();
        
        return csvFields;
    }
    
}
