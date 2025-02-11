package br.com.tokiomarine.payschedulertokiomarine.service.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "Transfer")
@Entity
public class TransferModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column(name="date_Transfer")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dateTransfer;

    @Column(name="appointment_Date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate appointmentDate;

    //@ManyToOne
    //@JoinColumn(name = "tax_id")

    @Column(name="value")
    private double value;

    @Column(name="origin_Account")
    private String OriginAccount;

    @Column(name="destinationAccount")
    private String destinationAccount;

}
