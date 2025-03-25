package meu.curso.microservicos.springboot_microservices.repository;

import meu.curso.microservicos.springboot_microservices.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {

}
