package md_meteoclimatic.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "cities")
public class Cities {

    @Id
    @Column(name = "id_city")
    private Long idCity;

    @Column(name = "city_name")
    private String cityName;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_region")
    private Regions idRegion;

    public Long getIdCity() {
        return idCity;
    }

    public void setIdCity(Long idCity) {
        this.idCity = idCity;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Regions getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Regions idRegion) {
        this.idRegion = idRegion;
    }
}
