package com.br.fiap.Nac1.domain.Dto;

import com.br.fiap.Nac1.domain.Paciente;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class PacienteDto {

    private long codigo;
    private String nome;
    private String cpf;
    private String tipoSanguineo;
    private String genero;
    private String email;
    private int telefone;

    public PacienteDto() {
    }

    public PacienteDto(Paciente paciente) {
        this.codigo = paciente.getCodigo();
        this.nome = paciente.getNome();
        this.cpf = paciente.getCpf();
        this.tipoSanguineo = paciente.getTipoSanguineo();
        this.genero = paciente.getGenero();
        this.email = paciente.getEmail();
        this.telefone = paciente.getTelefone();
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String emasil) {
        this.email = email;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public static List<PacienteDto> converter(List<Paciente> pacientes) {
        return pacientes.stream()
                .map(PacienteDto::new)
                .collect(Collectors.toList());
    }
}
