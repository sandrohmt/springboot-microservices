package meu.curso.microservicos.springboot_microservices.service;

import meu.curso.microservicos.springboot_microservices.model.ItemRequest;
import meu.curso.microservicos.springboot_microservices.model.Request;
import meu.curso.microservicos.springboot_microservices.repository.RequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    private final RequestRepository requestRepository;

    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public Request saveRequest(Request request) {
        if (request.getItems() != null) {
            for (ItemRequest item : request.getItems()) {
                item.setRequest(request);
            }
        }
        return requestRepository.save(request);
    }

    public List<Request> listRequests() {
        return requestRepository.findAll();
    }
}
