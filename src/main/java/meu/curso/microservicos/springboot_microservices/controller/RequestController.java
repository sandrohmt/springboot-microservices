package meu.curso.microservicos.springboot_microservices.controller;

import meu.curso.microservicos.springboot_microservices.model.Request;
import meu.curso.microservicos.springboot_microservices.service.RequestService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requests")
public class RequestController {

    private final RabbitTemplate rabbitTemplate;
    private final RequestService requestService;

    public RequestController(RabbitTemplate rabbitTemplate, RequestService requestService) {
        this.rabbitTemplate = rabbitTemplate;
        this.requestService = requestService;
    }

    @Value("${broker.queue.processing.name}")
    private String routingKey;

    @PostMapping
    public String createRequest(@RequestBody Request request) {
        Request savedRequest = requestService.saveRequest(request);
        rabbitTemplate.convertAndSend("", routingKey, savedRequest);
        return "Pedido salvo e enviado para processaomento: " + request.getDescription();
    }

    @GetMapping
    public List<Request> listRequests() {
        return requestService.listRequests();
    }
}
