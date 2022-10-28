package netmanagement.database.vo;

import java.util.Date;

public class Device {
    private Integer id;

    private String physicaladdress;

    private String ipaddress;

    private String label;

    private Boolean trust;

    private Boolean remove;

    private Date updatedat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhysicaladdress() {
        return physicaladdress;
    }

    public void setPhysicaladdress(String physicaladdress) {
        this.physicaladdress = physicaladdress;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Boolean getTrust() {
        return trust;
    }

    public void setTrust(Boolean trust) {
        this.trust = trust;
    }

    public Boolean getRemove() {
        return remove;
    }

    public void setRemove(Boolean remove) {
        this.remove = remove;
    }

    public Date getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(Date updatedat) {
        this.updatedat = updatedat;
    }
}