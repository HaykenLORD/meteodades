package md_meteoclimatic.service.model;

import javax.persistence.*;
import md_meteoclimatic.persistence.entity.Stations;

public class MeteoValuesDTO {

    @Id
    @GeneratedValue
    private Long idValues;

    private String dailyPpt;

    private String dailyTempMin;

    private String dailyTempMax;

    private String dailyTempMed;

    private String monthlyPpt;

    private String monthlyTempMin;

    private String monthlyTempMax;

    private String monthlyTempMinMed;

    private String monthlyTempMaxMed;

    private String monthlyTempMed;

    private Stations idStation;

    public Long getIdValues() {
        return idValues;
    }

    public void setIdValues(Long idValues) {
        this.idValues = idValues;
    }

    public String getDailyPpt() {
        return dailyPpt;
    }

    public void setDailyPpt(String dailyPpt) {
        this.dailyPpt = dailyPpt;
    }

    public String getDailyTempMin() {
        return dailyTempMin;
    }

    public void setDailyTempMin(String dailyTempMin) {
        this.dailyTempMin = dailyTempMin;
    }

    public String getDailyTempMax() {
        return dailyTempMax;
    }

    public void setDailyTempMax(String dailyTempMax) {
        this.dailyTempMax = dailyTempMax;
    }

    public String getDailyTempMed() {
        return dailyTempMed;
    }

    public void setDailyTempMed(String dailyTempMed) {
        this.dailyTempMed = dailyTempMed;
    }

    public String getMonthlyPpt() {
        return monthlyPpt;
    }

    public void setMonthlyPpt(String monthlyPpt) {
        this.monthlyPpt = monthlyPpt;
    }

    public String getMonthlyTempMin() {
        return monthlyTempMin;
    }

    public void setMonthlyTempMin(String monthlyTempMin) {
        this.monthlyTempMin = monthlyTempMin;
    }

    public String getMonthlyTempMax() {
        return monthlyTempMax;
    }

    public void setMonthlyTempMax(String monthlyTempMax) {
        this.monthlyTempMax = monthlyTempMax;
    }

    public String getMonthlyTempMinMed() {
        return monthlyTempMinMed;
    }

    public void setMonthlyTempMinMed(String monthlyTempMinMed) {
        this.monthlyTempMinMed = monthlyTempMinMed;
    }

    public String getMonthlyTempMaxMed() {
        return monthlyTempMaxMed;
    }

    public void setMonthlyTempMaxMed(String monthlyTempMaxMed) {
        this.monthlyTempMaxMed = monthlyTempMaxMed;
    }

    public String getMonthlyTempMed() {
        return monthlyTempMed;
    }

    public void setMonthlyTempMed(String monthlyTempMed) {
        this.monthlyTempMed = monthlyTempMed;
    }

    public Stations getIdStation() {
        return idStation;
    }

    public void setIdStation(Stations idStation) {
        this.idStation = idStation;
    }
}
