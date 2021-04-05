package br.com.zupacademy.beatriz.casadocodigo.autor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    Autor findByEmail(String email);


}
