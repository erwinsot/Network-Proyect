package com.example.AlertGlideConsumer.models;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Alert_Data")
@Data
public class AlertDataModel {
    @Id
    @SequenceGenerator(name = "Alert_Early_Generator", sequenceName = "public.alert_id_alert_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Alert_Early_Generator")
    private Integer idAlert;

    @Column(name = "Inclinacion")
    private String inclinacion;

    @Column(name = "Movimiento")
    private String movimiento;

    @Column(name = "Presion_Agua")
    private String pAgua;

    @Column(name = "Deformacion_Suelo")
    private String dSuelo;

    @Column(name = "Nivel_Freatico")
    private String nFreatico;

    @Column(name = "Humendad_Suelo")
    private String hSuelo;

    @Column(name = "Temperatura_Suelo")
    private String Tsuelo;


}
