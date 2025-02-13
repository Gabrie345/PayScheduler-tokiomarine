package br.com.tokiomarine.payschedulertokiomarine.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaxDto {

    @NotNull(message = "o min days é obrigatório ")
    @JsonProperty("min_days")
    private int minDays;

    @NotNull(message = "o max days é obrigatório ")
    @JsonProperty ("max_days")
    private int maxDays;

    @NotNull(message = "o valor é obrigatório ")
    @Positive(message = "O valor deve ser maior que 0")
    @JsonProperty ("valor")
    private double value;

    @NotNull(message = "a taxa é obrigatório ")
    @JsonProperty("taxa")
    private double tax;

    public TaxDto(int minDays, int maxDays, double value, double tax) {
        this.minDays = minDays;
        this.maxDays = maxDays;
        this.value = value;
        this.tax = tax;
    }

    public TaxDto() {
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getMaxDays() {
        return maxDays;
    }

    public void setMaxDays(int maxDays) {
        this.maxDays = maxDays;
    }

    public int getMinDays() {
        return minDays;
    }

    public void setMinDays(int minDays) {
        this.minDays = minDays;
    }
}
