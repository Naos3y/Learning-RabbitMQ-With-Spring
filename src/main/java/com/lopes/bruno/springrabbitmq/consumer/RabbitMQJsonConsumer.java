package com.lopes.bruno.springrabbitmq.consumer;

import com.lopes.bruno.springrabbitmq.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.json_queue.name}"})
    public void consume(UserDTO userDTO){
        LOGGER.info("Message received -> {} ", userDTO.toString());
    }
}
