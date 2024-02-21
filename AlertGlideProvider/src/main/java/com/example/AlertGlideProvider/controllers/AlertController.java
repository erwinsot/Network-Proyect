package com.example.AlertGlideProvider.controllers;


import com.example.AlertGlideProvider.DTO.AlertDataDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class AlertController {

    private KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    private static final Logger logger = LoggerFactory.getLogger(AlertController.class);

    public AlertController(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/Data")
    public ResponseEntity<?> sendMessage(@RequestBody AlertDataDTO alertDataDto) {

        try {

            // Serializar el objeto AlertDataDTO a una cadena JSON
            String jsonMessage = objectMapper.writeValueAsString(alertDataDto);

            // Enviar la cadena JSON a Kafka
            kafkaTemplate.send("AlertGlideProject", jsonMessage);

            // Registra la cadena JSON y el objeto real en los logs
            logger.info("Mensaje JSON recibido desde Postman: {}", jsonMessage);


            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al enviar el mensaje a Kafka: " + e.getMessage());
        }
    }
}