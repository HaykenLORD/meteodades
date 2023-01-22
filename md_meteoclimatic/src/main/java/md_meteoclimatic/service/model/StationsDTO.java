package md_meteoclimatic.service.model;



public class StationsDTO {

    private Long idStation;
    private String stationName;
    private String stationX;
    private String stationY;
    private String stationZ;
    private String idCity;

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

    public String getIdCity() {
        return idCity;
    }

    public void setIdCity(String stationCity) {
        this.idCity = stationCity;
    }
}
