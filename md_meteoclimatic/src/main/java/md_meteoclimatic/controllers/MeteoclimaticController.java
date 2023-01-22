package md_meteoclimatic.controllers;



import md_meteoclimatic.service.businesslogic.IStationsService;
import md_meteoclimatic.service.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("")
public class MeteoclimaticController {

    private static Logger logger = LoggerFactory.getLogger(MeteoclimaticController.class);

    @Autowired
    private IStationsService iStationsService;

    @GetMapping("/hola")
    public List<MeteoValuesDTO> getAll() throws IOException {
        return iStationsService.returnAll();

    }



}
