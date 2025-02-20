package br.com.tokiomarine.payschedulertokiomarine.validation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AuthenticationDto {

    @NotNull(message = "Password cannot be null")
    private String password;

    @NotNull(message = "O CPF é obrigatório.")
    @JsonProperty("cpf")
    @Size(min = 11, max = 11, message = "O CPF deve conter exatamente 11 dígitos.")
    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter apenas números.")
    @ApiModelProperty(value = "CPF do usuário", example = "12345678909")
    private String cpf;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public AuthenticationDto() {
    }

    public AuthenticationDto(String password, String cpf) {
        this.password = password;
        this.cpf = cpf;
    }
}
