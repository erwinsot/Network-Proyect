package com.example.AlertGlideConsumer.services;


import com.example.AlertGlideConsumer.DTO.DataDTO;
import com.example.AlertGlideConsumer.models.AlertDataModel;
import com.example.AlertGlideConsumer.repositories.AlertDataRespository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AlertService {

    @Autowired
    private AlertDataRespository alertDataRespository;


    @Autowired
    private ObjectMapper objectMapper;

    public void saveData(String jsonData) {
        try {
            // Convertir la cadena JSON a un objeto Java
            DataDTO dataDTO = objectMapper.readValue(jsonData, DataDTO.class);

            int valorInclinacion = Integer.parseInt(dataDTO.getInclinacion());
            if (valorInclinacion > 200) {
                System.out.println("Inclinacion mayor a 200");

            } else {
                System.out.println("Inclinacion menor a 10");
            }

            // Guardar los datos en la base de datos
            saveDataToDatabase(dataDTO);
        } catch (IOException e) {
            // Manejar errores de deserialización de JSON
            e.printStackTrace();
            // Puedes lanzar una excepción personalizada o manejar el error de otra manera
        }
    }

    private void saveDataToDatabase(DataDTO dataDTO) {
        // Crear un objeto AlertDataModel y asignar los valores de DataDTO
        AlertDataModel dataAlert = new AlertDataModel();
        dataAlert.setDSuelo(dataDTO.getDsuelo());
        dataAlert.setHSuelo(dataDTO.getHsuelo());
        dataAlert.setMovimiento(dataDTO.getMovimiento());
        dataAlert.setInclinacion(dataDTO.getInclinacion());
        dataAlert.setPAgua(dataDTO.getAgua());
        dataAlert.setNFreatico(dataDTO.getNfreatico());
        dataAlert.setTsuelo(dataDTO.getTsuelo());

        // Guardar en la base de datos
        alertDataRespository.save(dataAlert);




    }
}

