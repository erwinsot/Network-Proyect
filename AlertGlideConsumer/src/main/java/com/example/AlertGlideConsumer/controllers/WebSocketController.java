package com.example.AlertGlideConsumer.controllers;

import com.example.AlertGlideConsumer.DTO.AlertMessage;
import com.example.AlertGlideConsumer.DTO.HelloMessage;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketController {
    private final static Logger LOG = org.slf4j.LoggerFactory.getLogger(WebSocketController.class);

    @MessageMapping("/alert")
    @SendTo("/topic/alerts")
    public AlertMessage alertMessage(HelloMessage message) throws Exception {
        LOG.info("Mensaje recibido: {}", message.getName());
        Thread.sleep(1000); // simulated delay
        return new AlertMessage("Alerta de prueba", "Inundación", "Alto");
    }

    @GetMapping("/ejem")
    public ResponseEntity<?> ejemplo() {
        return ResponseEntity.ok("Hola mundo");
    }
}
