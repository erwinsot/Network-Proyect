package com.example.AlertGlideConsumer.listeners;

import com.example.AlertGlideConsumer.services.AlertService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class ConsumerListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    private AlertService alertService;

    @KafkaListener(topics = {"AlertGlideProject"},groupId = "my-group-id")
    public void  listener(String message) throws JsonProcessingException {
        LOGGER.info("Mensaje Recibido," + message );
        alertService.saveData(message);

    }
}

