package fr.lernejo.prediction.exceptions;

public class UnknownCountryException extends RuntimeException {
    public UnknownCountryException(String country) {
        super("Unknown country: " + country);
    }
}
