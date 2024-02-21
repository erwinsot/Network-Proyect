package com.example.AlertGlideConsumer.models;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PruebaTabla {

    @Id
    @SequenceGenerator(name = "Alert_Early_Generator", sequenceName = "public.alert_id_alert_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Alert_Early_Generator")
    private Integer idAlert;

    private String message;


}
