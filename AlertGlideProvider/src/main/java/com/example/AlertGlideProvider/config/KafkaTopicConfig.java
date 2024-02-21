package com.example.AlertGlideProvider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

   @Bean
    public NewTopic generateTopic(){

       Map<String, String> configurations=new HashMap<>();
       configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE); // borrar mensaje
       configurations.put(TopicConfig.RETENTION_MS_CONFIG, "86400000"); // retencion del mensaje, si no especifica duracion no se borra
       configurations.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824"); // tamaño de los segmentos del topic, para este caso un giga
       configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "10000"); // Tamaño de cada mensaje, 1 megabyte por defecto
       return TopicBuilder.name("AlertGlideProject")
                .partitions(1)
                .replicas(1)
                .configs(configurations)
                .build();
    }
}
