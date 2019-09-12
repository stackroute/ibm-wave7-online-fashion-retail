package com.stackroute.onlinefashionretail.supplier.config;

//import com.fasterxml.jackson.databind.JsonDeserializer;
import com.stackroute.onlinefashionretail.supplier.domain.Mapping;
import com.stackroute.onlinefashionretail.supplier.domain.Supplier;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class ConsumerConfig {

  @Bean
  public ConsumerFactory<String, Mapping> consumerFactory() {
    Map<String, Object> config = new HashMap<>();
    config.put(org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    config.put(org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG, "group_id");
    config.put(org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    config.put(org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
    config.put(JsonDeserializer.TRUSTED_PACKAGES, "com.stackroute.onlinefashionretail.supplier.domain");
    return new DefaultKafkaConsumerFactory<>(config);
  }
  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, Mapping> kafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, Mapping> factory = new ConcurrentKafkaListenerContainerFactory();
    factory.setConsumerFactory(consumerFactory());
    return factory;
  }


}
