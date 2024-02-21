package com.example.AlertGlideConsumer.repositories;

import com.example.AlertGlideConsumer.models.AlertDataModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AlertDataRespository extends JpaRepository<AlertDataModel, Integer> {

}
