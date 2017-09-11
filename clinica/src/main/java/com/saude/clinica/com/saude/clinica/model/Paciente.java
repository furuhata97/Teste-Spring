package com.saude.clinica.com.saude.clinica.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Paciente {

    @Id
    @NotEmpty(message = "Digite o CPF")
    @Size(max = 14, message = "CPF inválido")
    private String cpf;

    @NotEmpty(message = "Digite o nome")
    @Size(max = 60, message = "Nome não deve conter mais de 60 caracteres")
    private String nome;

    @NotNull(message = "Data de nascimento é obrigatória")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @NotEmpty(message = "Digite o endereço")
    @Size(max = 90, message = "Endereço não deve conter mais de 90 caracteres")
    private String endereco;

    @Size(max = 50, message = "Complemento não deve conter mais de 50 caracteres")
    private String complemento;

    @Size(max = 50, message = "Não deve conter mais de 50 caracteres")
    private String telefone;

    @Size(max = 50, message = "Não deve conter mais de 50 caracteres")
    private String email;

    @Enumerated(EnumType.STRING)
    private Estados estado;

    @NotEmpty(message = "Digite a cidade")
    @Size(max = 50, message = "Não deve conter mais de 50 caracteres")
    private String cidade;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
