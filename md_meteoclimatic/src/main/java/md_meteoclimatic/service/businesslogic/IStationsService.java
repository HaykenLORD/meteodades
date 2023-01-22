package md_meteoclimatic.service.businesslogic;


import md_meteoclimatic.service.model.*;

import java.io.IOException;
import java.util.List;

public interface IStationsService {
    public List<MeteoValuesDTO> returnAll() throws IOException;

}
