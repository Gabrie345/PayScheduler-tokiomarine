package br.com.tokiomarine.payschedulertokiomarine.service.model;


import javax.persistence.*;

@Table(name = "TaxRate")
@Entity
public class TaxModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;

    @Column(name ="min_days")
    private int minDays;

    @Column (name ="max_days")
    private int maxDays;

    @Column (name ="valor")
    private double value;

    @Column(name ="taxa")
    private double tax;

    public TaxModel(int id, int minDays, int maxDays, double value, double tax) {
        this.id = id;
        this.minDays = minDays;
        this.maxDays = maxDays;
        this.value = value;
        this.tax = tax;
    }

    public TaxModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMinDays() {
        return minDays;
    }

    public void setMinDays(int minDays) {
        this.minDays = minDays;
    }

    public int getMaxDays() {
        return maxDays;
    }

    public void setMaxDays(int maxDays) {
        this.maxDays = maxDays;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
}
