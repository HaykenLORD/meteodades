package md_meteoclimatic.persistence.entity;

import javax.persistence.*;
@Entity
@Table(name = "stations")
public class Stations {
    @Id
    @Column(name = "id_station")
    private Long idStation;

    @Column(name = "station_name")
    private String stationName;

    @Column(name = "station_x")
    private String stationX;

    @Column(name = "station_y")
    private String stationY;

    @Column(name = "station_z")
    private String stationZ;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_city")
    private Cities idCity;

    @Column(name = "url")
    private String url;

    @Column(name = "range")
    private String range;

    public Long getIdStation() {
        return idStation;
    }

    public void setIdStation(Long idStation) {
        this.idStation = idStation;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationX() {
        return stationX;
    }

    public void setStationX(String stationX) {
        this.stationX = stationX;
    }

    public String getStationY() {
        return stationY;
    }

    public void setStationY(String stationY) {
        this.stationY = stationY;
    }

    public String getStationZ() {
        return stationZ;
    }

    public void setStationZ(String stationZ) {
        this.stationZ = stationZ;
    }

    public Cities getIdCity() {
        return idCity;
    }

    public void setIdCity(Cities idCity) {
        this.idCity = idCity;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }
}

