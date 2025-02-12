package br.com.tokiomarine.payschedulertokiomarine.service.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "transfer")
@Entity
public class TransferModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column(name="date_transfer")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dateTransfer;

    @Column(name="appointment_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate appointmentDate;

    @ManyToOne
    @JoinColumn(name = "tax_id")
    private TaxModel taxModel;

    @Column(name="`value`")
    private double value;

    @Column(name="origin_account")
    private String originAccount;

    @Column(name="destination_account")
    private String destinationAccount;

    public TransferModel() {
    }

    public TransferModel(Long id, LocalDate dateTransfer, LocalDate appointmentDate, TaxModel taxModel, double value, String originAccount, String destinationAccount) {
        this.id = id;
        this.dateTransfer = dateTransfer;
        this.appointmentDate = appointmentDate;
        this.taxModel = taxModel;
        this.value = value;
        this.originAccount = originAccount;
        this.destinationAccount = destinationAccount;
    }

    public String getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(String destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public String getOriginAccount() {
        return originAccount;
    }

    public void setOriginAccount(String originAccount) {
        this.originAccount = originAccount;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public TaxModel getTaxModel() {
        return taxModel;
    }

    public void setTaxModel(TaxModel taxModel) {
        this.taxModel = taxModel;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalDate getDateTransfer() {
        return dateTransfer;
    }

    public void setDateTransfer(LocalDate dateTransfer) {
        this.dateTransfer = dateTransfer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
