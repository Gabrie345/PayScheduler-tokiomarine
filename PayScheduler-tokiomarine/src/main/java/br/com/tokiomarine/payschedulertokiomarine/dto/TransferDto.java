package br.com.tokiomarine.payschedulertokiomarine.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import io.swagger.annotations.ApiModelProperty;


import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransferDto {

    @JsonProperty("conta_origem")
    @NotNull(message = "a conta origem é obrigatório")
    @Size(min = 10, max = 10, message = "A conta origem deve ter exatamente 10 caracteres")
    @ApiModelProperty(value = "Número da conta de origem", example = "1234567890")
    private String OriginAccount;

    @NotNull(message = "a conta destino é obrigatório ")
    @JsonProperty("conta_destino")
    @Size(min = 10, max = 10, message = "A conta origem deve ter exatamente 10 caracteres")
    @ApiModelProperty(value = "Número da conta de destino alfanumérico", example = "A987654321")
    private String destinationAccount;

    @Positive(message = "O valor deve ser maior que 0")
    @JsonProperty("valor")
    @NotNull(message = "o valor é obrigatório")
    @ApiModelProperty(value = "Valor da transferência", example = "1500.00")
    private double value;

    @JsonProperty("data_Agendamento")
    @NotNull(message = "a data de agendamento é obrigatório")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @ApiModelProperty(value = "Data da transferência", example = "20/02/2025")
    private LocalDate appointmentDate;


    public TransferDto(String originAccount, String destinationAccount, double value, LocalDate appointmentDate) {
        OriginAccount = originAccount;
        this.destinationAccount = destinationAccount;
        this.value = value;
        this.appointmentDate = appointmentDate;
    }

    public TransferDto() {
    }

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
