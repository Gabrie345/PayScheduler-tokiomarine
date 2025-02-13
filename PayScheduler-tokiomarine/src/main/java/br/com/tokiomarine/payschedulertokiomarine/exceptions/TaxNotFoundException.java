package br.com.tokiomarine.payschedulertokiomarine.exceptions;

public class TaxNotFoundException extends RuntimeException {
    public TaxNotFoundException(String message) {
        super(message);
    }
}