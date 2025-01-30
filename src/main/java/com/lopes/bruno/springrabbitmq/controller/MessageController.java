package com.lopes.bruno.springrabbitmq.controller;

import com.lopes.bruno.springrabbitmq.dto.UserDTO;
import com.lopes.bruno.springrabbitmq.publisher.RabbitMQJsonProducer;
import com.lopes.bruno.springrabbitmq.publisher.RabbitMQProducer;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MessageController {
    private RabbitMQProducer producer;
    private RabbitMQJsonProducer jsonProducer;

    public MessageController(RabbitMQProducer producer, RabbitMQJsonProducer jsonProducer) {
        this.producer = producer;
        this.jsonProducer = jsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestBody String message){
        producer.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ");
    }

    @PostMapping("jsonPublish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody UserDTO user){
        jsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Json Message sent to RabbitMQ");
    }
}
