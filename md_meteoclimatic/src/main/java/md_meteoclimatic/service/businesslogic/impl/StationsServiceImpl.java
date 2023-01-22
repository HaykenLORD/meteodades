package md_meteoclimatic.service.businesslogic.impl;

import md_meteoclimatic.controllers.MeteoclimaticController;
import md_meteoclimatic.persistence.entity.*;
import md_meteoclimatic.persistence.repository.*;
import md_meteoclimatic.service.businesslogic.IStationsService;
import md_meteoclimatic.service.model.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class StationsServiceImpl implements IStationsService {

    private static Logger logger = LoggerFactory.getLogger(StationsServiceImpl.class);

    @Autowired
    private StationsRepository stationsRepository;

    @Autowired
    private MeteovaluesRepository meteoValuesRepository;


    public List<MeteoValuesDTO> returnAll() throws IOException {


        //Return all values of repository and mapping to list of type.
       /* List<StationsDTO> listReturn = stationsRepository.findAll()
                .stream()
                .map(StationsServiceImpl::mapper)
                .collect(Collectors.toList());*/




        /*ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);*/

      /*  System.setProperty("webdriver.chrome.driver","C:\\Users\\david\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.wunderground.com/dashboard/pws/IABRER1?cm_ven=localwx_pwsdash");
                    https://www.wunderground.com/dashboard/pws/ICASTE126?cm_ven=localwx_pwsdash
        String words = driver.findElement(By.xpath("/html/body/app-root/app-dashboard/one-column-layout/wu-header/sidenav/mat-sidenav-container/mat-sidenav-content/div/section/section[1]/div[1]/div/section/div/div/div/lib-history/lib-history-summary/div/div[2]/table/tbody/tr[4]/td[1]/lib-display-unit/span/span[1]")).getText();
        System.out.println(words);*/

        Date init = Calendar.getInstance().getTime();

        logger.info("TIEMPO INICIAL " + init);


        List<Stations> listReturn = stationsRepository.findAll();
        List<Meteovalues> meteovaluesToSave = new ArrayList<>();
        listReturn.forEach(stations -> {
            try {
                Document doc = Jsoup.connect(stations.getUrl()).get();
                Elements ePpt = doc.getElementsByClass("actual");
                Elements eTempMax = doc.getElementsByClass("vermell");
                Elements eTempMin = doc.getElementsByClass("blau");
                Elements eTempAct = doc.getElementsByClass("dadesactuals");
                String dailyPP, monthlyPP, tempMax, tempMin, tempAct, tempMed;

                // System.out.println(eTempMin);

                //TODO ARREGLAR LA SOLUCIÓN SI VIENE NULL HABLAR CON ALAN

                if (!ePpt.isEmpty() || ePpt != null) {
                    if (stations.getRange().equals("4")) {
                        if (!ePpt.get(5).text().equals("") && ePpt.get(5).text() != null) {
                            dailyPP = ePpt.get(5).text();
                        } else {
                            dailyPP = "NULL";
                        }
                        if (!ePpt.get(9).text().equals("") && ePpt.get(9).text() != null) {
                            monthlyPP = ePpt.get(9).text();
                        } else {
                            monthlyPP = "NULL";
                        }
                    } else if (stations.getRange().equals("5")) {
                        if (!ePpt.get(6).text().equals("") && ePpt.get(6).text() != null) {
                            dailyPP = ePpt.get(6).text();
                        } else {
                            dailyPP = "NULL";
                        }
                        if (!ePpt.get(10).text().equals("") && ePpt.get(10).text() != null) {
                            monthlyPP = ePpt.get(10).text();
                        } else {
                            monthlyPP = "NULL";
                        }
                    } else {
                        if (!ePpt.get(7).text().equals("") && ePpt.get(7).text() != null) {
                            dailyPP = ePpt.get(7).text();
                        } else {
                            dailyPP = "NULL";
                        }
                        if (!ePpt.get(12).text().equals("") && ePpt.get(12).text() != null) {
                            monthlyPP = ePpt.get(12).text();
                        } else {
                            monthlyPP = "NULL";
                        }
                    }
                } else {
                    dailyPP = "NULL";
                    monthlyPP = "NULL";
                }

                //Temperatura mínima
                if (!eTempMin.get(0).text().equals("") && eTempMin.get(0) != null) {
                    tempMin = eTempMin.get(0).text();
                } else {
                    tempMin = "NULL";
                }
                //Temperatura máxima
                if (!eTempMax.get(0).text().equals("") && eTempMax.get(0) != null) {
                    tempMax = eTempMax.get(0).text();
                } else {
                    tempMax = "NULL";
                }
                //Temperatura actual
                if (!eTempAct.get(0).text().equals("") && eTempAct.get(0) != null) {
                    tempAct = eTempAct.get(0).text();
                } else {
                    tempAct = "NULL";
                }


                DecimalFormat df = new DecimalFormat("#.##");
                df.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ENGLISH));
                df.setRoundingMode(RoundingMode.FLOOR);

                if ((!tempMin.equals("NULL") && tempMin != null) && (!tempMax.equals("NULL") && tempMax != null)) {
                    tempMed = String.valueOf(df.format((Float.parseFloat(tempMin) +
                            Float.parseFloat(tempMax)) / 2));
                } else {
                    tempMed = "NULL";
                }


                Meteovalues meteoValues = new Meteovalues(dailyPP, tempMin, tempMax, tempMed, monthlyPP, "0", "0",
                        "0", "0", "0", new Date(), stations);

                meteoValuesRepository.save(meteoValues);

                System.out.println(stations.getStationName() + "\nppt diaria: " + dailyPP + "\nppt mensual: " + monthlyPP + "\ntemp min: " + tempMin
                        + "\ntemp max: " + tempMax + "\ntemp actual: " + tempAct.substring(0, tempAct.length() - 3) + "\n");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        });




















        /* List<DailyPP> listReturn2 = dailyPpRepository.findAll();
        List<DailyTxTn> listReturn3 = dailyTxTnRepository.findAll();
        List<MonthlyPP> listReturn4 = monthlyPpRepository.findAll();
        List<MonthlyTxTn> listReturn5 = monthlyTxTnRepository.findAll();

        listReturn.forEach(x -> {
            driver.get(x.getUrl());
            String mm  = driver.findElements(By.ByClassName("actual")).getText();
            System.out.println(mm);
        });

*/

        Date fin = Calendar.getInstance().getTime();


        logger.info("TIEMPO FINAL " + fin);

        return null;

    }

    public static StationsDTO mapper(Stations stations) {
        StationsDTO stationsDTO = new StationsDTO();
        stationsDTO.setStationName(stations.getStationName().substring(0, stations.getStationName().length() - 5));
        stationsDTO.setIdCity(stations.getIdCity().getIdRegion().getRegionName());
        stationsDTO.setStationZ(stations.getStationZ());

        return stationsDTO;
    }



    }
