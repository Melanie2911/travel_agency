package fr.lernejo.prediction.controller.record;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record PredictionTemperatureCountry(String country, ArrayList<TemperatureDate> temperatures) {
}
