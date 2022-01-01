package fr.lernejo.prediction.controller;
import fr.lernejo.prediction.service.TemperatureService;
import fr.lernejo.prediction.controller.record.PredictionTemperatureCountry;
import fr.lernejo.prediction.controller.record.TemperatureDate;
import fr.lernejo.prediction.service.TemperatureService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@RestController
@RequestMapping(value="/api")
public class PredictionTemperatureCountryController {
    private final ArrayList<TemperatureDate> liste = new ArrayList<>();
    private final ArrayList<PredictionTemperatureCountry> FinalListe = new ArrayList<>();
    private final TemperatureService temperatureService;

    public PredictionTemperatureCountryController(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }
    @GetMapping("/temperature")
    public PredictionTemperatureCountry AddList(@RequestParam String country) {
        liste.clear();
        double temperature1=temperatureService.getTemperature(country);
        double temperature2=temperatureService.getTemperature(country);
        LocalDate today = LocalDate.now();
        String date1 = (today.minusDays(1)).format(DateTimeFormatter.ISO_DATE);
        String date2 = (today.minusDays(2)).format(DateTimeFormatter.ISO_DATE);
        liste.add(new TemperatureDate(date1,temperature1));
        liste.add(new TemperatureDate(date2,temperature2));
        return new PredictionTemperatureCountry(country,liste);
    }

}
