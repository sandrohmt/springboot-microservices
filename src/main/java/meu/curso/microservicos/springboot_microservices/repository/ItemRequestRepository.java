package meu.curso.microservicos.springboot_microservices.repository;

import meu.curso.microservicos.springboot_microservices.model.ItemRequest;
import meu.curso.microservicos.springboot_microservices.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRequestRepository extends JpaRepository<ItemRequest, Long> {
}
