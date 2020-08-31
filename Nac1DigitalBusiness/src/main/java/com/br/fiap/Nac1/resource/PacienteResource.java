package com.br.fiap.Nac1.resource;


import com.br.fiap.Nac1.domain.Dto.PacienteDto;
import com.br.fiap.Nac1.domain.Paciente;
import com.br.fiap.Nac1.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("pacientes")
public class PacienteResource {

    @Autowired
    IPacienteRepository pacienteRepository;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<PacienteDto> lista(String nome) {
        List<Paciente> pacientes = nome == null ?
                pacienteRepository.findAll() :
                pacienteRepository.findByNome(nome);
        return PacienteDto.converter(pacientes);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PacienteDto> salva(
            @RequestBody @Valid Paciente paciente,
            UriComponentsBuilder uriBuilder
    ) {
        pacienteRepository.save(paciente);

        URI uri = uriBuilder
                .path("/pacientes/{codigo}")
                .buildAndExpand(paciente.getCodigo())
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(new PacienteDto(paciente));
    }

    @GetMapping("{codigo}")
    public ResponseEntity<PacienteDto> findPacienteById(@PathVariable("codigo") Long codigo) {

        Optional<Paciente> paciente = pacienteRepository.findById(codigo);
        return paciente
                .map(t -> ResponseEntity.ok(new PacienteDto(t)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<PacienteDto> atualizaPaciente(
            @PathVariable long id,
            @RequestBody @Valid Paciente pacienteAtualizado
    ) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        return paciente
                .map(t -> {
                    t.setCpf(pacienteAtualizado.getCpf());
                    t.setNome(pacienteAtualizado.getNome());
                    t.setEmail(pacienteAtualizado.getEmail());
                    t.setTelefone(pacienteAtualizado.getTelefone());
                    t.setTipoSanguineo(pacienteAtualizado.getTipoSanguineo());
                    t.setUltimaAtualizacao(LocalDate.now());
                    pacienteRepository.save(t);
                    return ResponseEntity.ok(new PacienteDto(t));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<?> remove(@PathVariable Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        return paciente
                .map(t -> {
                    pacienteRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
