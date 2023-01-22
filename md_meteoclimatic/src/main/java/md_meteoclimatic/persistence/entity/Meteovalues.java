package md_meteoclimatic.persistence.entity;


import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "meteovalues")
public class Meteovalues {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idValues;

    @Column(name = "daily_ppt")
    private String dailyPpt;

    @Column(name = "daily_temp_min")
    private String dailyTempMin;

    @Column(name = "daily_temp_max")
    private String dailyTempMax;

    @Column(name = "daily_temp_med")
    private String dailyTempMed;

    @Column(name = "monthly_ppt")
    private String monthlyPpt;

    @Column(name = "monthly_temp_min")
    private String monthlyTempMin;

    @Column(name = "monthly_temp_max")
    private String monthlyTempMax;

    @Column(name = "monthly_temp_min_med")
    private String monthlyTempMinMed;

    @Column(name = "monthly_temp_max_med")
    private String monthlyTempMaxMed;

    @Column(name = "monthly_temp_med")
    private String monthlyTempMed;

    @Column(name = "date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date;

    @ManyToOne(cascade = CascadeType.PERSIST,  fetch = FetchType.LAZY)
    @JoinColumn(name = "id_station")
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Stations getIdStation() {
        return idStation;
    }

    public void setIdStation(Stations idStation) {
        this.idStation = idStation;
    }

    public Meteovalues() {
    }

    public Meteovalues(String dailyPpt, String dailyTempMin, String dailyTempMax, String dailyTempMed, String monthlyPpt, String monthlyTempMin, String monthlyTempMax, String monthlyTempMinMed, String monthlyTempMaxMed, String monthlyTempMed, Date date, Stations idStation) {
        this.dailyPpt = dailyPpt;
        this.dailyTempMin = dailyTempMin;
        this.dailyTempMax = dailyTempMax;
        this.dailyTempMed = dailyTempMed;
        this.monthlyPpt = monthlyPpt;
        this.monthlyTempMin = monthlyTempMin;
        this.monthlyTempMax = monthlyTempMax;
        this.monthlyTempMinMed = monthlyTempMinMed;
        this.monthlyTempMaxMed = monthlyTempMaxMed;
        this.monthlyTempMed = monthlyTempMed;
        this.date = date;
        this.idStation = idStation;
    }
}
