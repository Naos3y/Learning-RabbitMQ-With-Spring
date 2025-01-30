package com.lopes.bruno.springrabbitmq.publisher;

import com.lopes.bruno.springrabbitmq.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonProducer {
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.json_routing.key}")
    private String routingKey;

    private RabbitTemplate rabbitTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonProducer.class);

    public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonMessage(UserDTO userDTO){
        LOGGER.info("JsonMessage sent -> {} ", userDTO.toString());
        rabbitTemplate.convertAndSend(exchange, routingKey, userDTO);
    }
}
