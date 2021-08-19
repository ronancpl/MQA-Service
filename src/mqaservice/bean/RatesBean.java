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

/**
 *
 * @author RonanLana
 */
public class RatesBean extends Bean {
    
    private float exp;
    private float meso;
    private float drop;
    
    public float getExpRate() {
        return this.exp;
    }
    
    public void setExpRate(float expR) {
        this.exp = expR;
    }
    
    public float getMesoRate() {
        return this.meso;
    }
    
    public void setMesoRate(float mesoR) {
        this.meso = mesoR;
    }
    
    public float getDropRate() {
        return this.drop;
    }
    
    public void setDropRate(float dropR) {
        this.drop = dropR;
    }
    
}
