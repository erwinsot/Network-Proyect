package com.example.AlertGlideConsumer.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AlertMessage {
    String message;
    String alertType;
    String alertLevel;
}
