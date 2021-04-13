package br.com.zupacademy.beatriz.casadocodigo.custormers;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
