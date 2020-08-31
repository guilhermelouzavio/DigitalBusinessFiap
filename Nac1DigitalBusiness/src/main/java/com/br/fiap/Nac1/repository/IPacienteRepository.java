package com.br.fiap.Nac1.repository;

import com.br.fiap.Nac1.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPacienteRepository extends JpaRepository<Paciente, Long> {
    // List<Paciente> findById(int codigo);
    List<Paciente> findByNome(String nome);

}
