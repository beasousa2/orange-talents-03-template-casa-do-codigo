package br.com.zupacademy.beatriz.casadocodigo.states;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StateRepository extends JpaRepository<State, Long> {

    List<State> findByCountry_Id(Long id);

    Boolean existsCountry_IdById(Long id);
}
