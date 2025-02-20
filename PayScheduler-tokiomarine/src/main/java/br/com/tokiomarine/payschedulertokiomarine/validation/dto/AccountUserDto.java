package br.com.tokiomarine.payschedulertokiomarine.validation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)

public class AccountUserDto implements Serializable {


    @NotNull(message = "O nome é obrigatório.")
    @JsonProperty("name")
    @ApiModelProperty(value = "Nome do usuário", example = "João Silva")
    private String name;

    @NotNull(message = "O CPF é obrigatório.")
    @JsonProperty("cpf")
    @Size(min = 11, max = 11, message = "O CPF deve conter exatamente 11 dígitos.")
    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter apenas números.")
    @ApiModelProperty(value = "CPF do usuário", example = "12345678909")
    private String cpf;

    @NotNull(message = "A senha é obrigatória.")
    @Size(min = 8, max = 20, message = "A senha deve ter entre 8 e 20 caracteres.")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).+$",
            message = "A senha deve conter pelo menos uma letra maiúscula, uma letra minúscula e um número.")
    @JsonProperty("password")
    @ApiModelProperty(value = "Senha do usuário", example = "SenhaForte123")
    private String password;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountUserDto(String name, String cpf, String password) {
        this.name = name;
        this.cpf = cpf;
        this.password = password;
    }
}
