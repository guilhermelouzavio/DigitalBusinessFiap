package com.br.fiap.Nac1.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;


@Entity
@SequenceGenerator(name = "pacienteSequence",
        sequenceName = "SQ_PACIENTE",
        allocationSize = 1)
@JsonIgnoreProperties(ignoreUnknown = true)

public class Paciente {

    public Paciente() {
    }

    public Paciente( long codigo, String nome, String cpf, String tipoSanguineo, String genero, String email, int telefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.tipoSanguineo = tipoSanguineo;
        this.genero = genero;
        this.email = email;
        this.telefone = telefone;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "pacienteSequence")
    private long codigo;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "nr_cpf")
    private String cpf;

    @Column(name = "tp_sanguineo")
    private String tipoSanguineo;

    @Column(name = "ds_genero")
    private String genero;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "nr_telefone")
    private int telefone;

    private LocalDate criadaEm = LocalDate.now();

    private LocalDate ultimaAtualizacao = LocalDate.now();

    public LocalDate getCriadaEm() {
        return criadaEm;
    }

    public void setCriadaEm(LocalDate criadaEm) {
        this.criadaEm = criadaEm;
    }

    public LocalDate getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(LocalDate ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
}
