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
public class CharacterBean extends Bean {
    
    private int id;
    private String name;
    private int job;
    private int level;
    private int exp;
    private int map;
    private int meso;
    private short fame;
    private short gender;
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getJob() {
        return this.job;
    }
    
    public void setJob(int jobId) {
        this.job = jobId;
    }
    
    public int getLevel() {
        return this.level;
    }
    
    public void setLevel(int level) {
        this.level = level;
    }
    
    public int getExp() {
        return this.exp;
    }
    
    public void setExp(int exp) {
        this.exp = exp;
    }
    
    public int getMap() {
        return this.map;
    }
    
    public void setMap(int map) {
        this.map = map;
    }
    
    public int getMeso() {
        return this.meso;
    }
    
    public void setMeso(int meso) {
        this.meso = meso;
    }
    
    public short getFame() {
        return this.fame;
    }
    
    public void setFame(short fame) {
        this.fame = fame;
    }
    
    public short getGender() {
        return this.gender;
    }
    
    public void setGender(short gender) {
        this.gender = gender;
    }
    
}
