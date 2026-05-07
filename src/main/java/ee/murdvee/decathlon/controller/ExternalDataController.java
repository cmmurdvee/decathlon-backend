package ee.murdvee.decathlon.controller;

import ee.murdvee.decathlon.dto.CompetitionLocation;
import ee.murdvee.decathlon.dto.Judge;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ExternalDataController {

    private RestTemplate restTemplate = new RestTemplate();

    private static final String MOCKAPI_BASE = "https://69fcfb3130ad0a6fd1c05fab.mockapi.io";

    @GetMapping("judges")
    public List<Judge> getJudges() {
        String url = MOCKAPI_BASE + "/judges";
        Judge[] response = restTemplate.exchange(url, HttpMethod.GET, null, Judge[].class).getBody();
        return Arrays.asList(response);
    }

    @GetMapping("locations")
    public List<CompetitionLocation> getLocations() {
        String url = MOCKAPI_BASE + "/locations";
        CompetitionLocation[] response = restTemplate.exchange(url, HttpMethod.GET, null, CompetitionLocation[].class).getBody();
        return Arrays.asList(response);
    }
}
