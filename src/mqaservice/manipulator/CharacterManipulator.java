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

import mqaservice.bean.CharacterBean;

/**
 *
 * @author RonanLana
 */
public class CharacterManipulator {
    
    public static Object[] getCsvHeader() {
        Object[] csvHeaders = new String[]{"id", "name", "job", "level", "exp", "map", "meso", "fame", "gender"};
        return csvHeaders;
    }
    
    public static Object[] toCsv(CharacterBean bean) {
        Object[] csvFields = new Object[9];
        csvFields[0] = bean.getId();
        csvFields[1] = bean.getName();
        csvFields[2] = bean.getJob();
        csvFields[3] = bean.getLevel();
        csvFields[4] = bean.getExp();
        csvFields[5] = bean.getMap();
        csvFields[6] = bean.getMeso();
        csvFields[7] = bean.getFame();
        csvFields[8] = bean.getGender();
        
        return csvFields;
    }
    
}
