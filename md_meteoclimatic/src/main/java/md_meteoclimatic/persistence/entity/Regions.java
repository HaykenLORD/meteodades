package md_meteoclimatic.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "regions")
public class Regions {

    @Id
    @Column(name = "id_region")
    private Long idRegion;

    @Column(name = "region_name")
    private String regionName;

    public Long getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Long idRegion) {
        this.idRegion = idRegion;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}
