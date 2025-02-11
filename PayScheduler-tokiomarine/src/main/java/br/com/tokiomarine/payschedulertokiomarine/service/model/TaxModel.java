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



}
