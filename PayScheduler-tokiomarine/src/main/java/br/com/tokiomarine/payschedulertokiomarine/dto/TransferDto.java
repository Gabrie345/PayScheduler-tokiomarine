package br.com.tokiomarine.payschedulertokiomarine.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransferDto {

    @JsonProperty("conta_origem")
    @NotNull(message = "a conta origem é obrigatório")
    @Size(min = 10, max = 10, message = "A conta origem deve ter exatamente 10 caracteres")
    private String OriginAccount;

    @NotNull(message = "a conta destino é obrigatório ")
    @JsonProperty("conta_destino")
    @Size(min = 10, max = 10, message = "A conta origem deve ter exatamente 10 caracteres")
    private String destinationAccount;

    @Positive(message = "O valor deve ser maior que 0")
    @JsonProperty("valor")
    @NotNull(message = "o valor é obrigatório")
    private double value;

    @JsonProperty("data_Agendamento")
    @NotNull(message = "a data de agendamento é obrigatório")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate appointmentDate;


    public String getOriginAccount() {
        return OriginAccount;
    }

    public void setOriginAccount(String originAccount) {
        OriginAccount = originAccount;
    }

    public String getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(String destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
}
