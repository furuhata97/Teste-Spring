package com.saude.clinica.com.saude.clinica.repository;

import com.saude.clinica.com.saude.clinica.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;



public interface Pacientes extends JpaRepository<Paciente, String> {

}
