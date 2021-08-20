/*
    This file is part of the MapleQuestAdvisor planning tool    
    Copyleft (L) 2020 - 2021 RonanLana

    GNU General Public License v3.0

    Permissions of this strong copyleft license are conditioned on making available complete
    source code of licensed works and modifications, which include larger works using a licensed
    work, under the same license. Copyright and license notices must be preserved. Contributors
    provide an express grant of patent rights.
 */
package mqaservice.bean;

import java.util.ArrayList;
import java.util.List;
import tools.Pair;

/**
 *
 * @author RonanLana
 */
public class InventoryBean extends Bean {
    
    private List<Pair<Integer, Integer>> list = new ArrayList<>();
    
    public void add(Pair<Integer, Integer> p) {
        this.list.add(p);
    }
    
    public List<Pair<Integer, Integer>> get() {
        return this.list;
    }
    
}
