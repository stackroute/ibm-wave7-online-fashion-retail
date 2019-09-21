package com.stackroute.neo4j.Configuration;

import com.stackroute.neo4j.entity.ConsumerOrder;
import com.stackroute.neo4j.entity.Manufacturer;
import com.stackroute.neo4j.entity.Supplier;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;


import java.util.HashMap;
import java.util.Map;
@EnableKafka
public class KafkaConfig {
    @Bean
    public ConsumerFactory<String, Supplier> consumerFactory1() {
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
      //  config.put(ConsumerConfig.GROUP_ID_CONFIG, "recommendsupplier");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(config);
    }
    @Bean
    public ConsumerFactory<String, ConsumerOrder> consumerFactory2() {
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        config.put(ConsumerConfig.GROUP_ID_CONFIG, "recommendconsumer");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(config);
    }
    @Bean
    public ConsumerFactory<String, Manufacturer> consumerFactory3() {
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        config.put(ConsumerConfig.GROUP_ID_CONFIG, "recommendmanufacturer");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(config);
    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Supplier> kafkaListenerContainerFactory1() {
        ConcurrentKafkaListenerContainerFactory<String,Supplier>  factory= new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerFactory1());
        return factory;
    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, ConsumerOrder> kafkaListenerContainerFactory2() {
        ConcurrentKafkaListenerContainerFactory<String,ConsumerOrder> factory = new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerFactory2());
        return factory;
    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Manufacturer> kafkaListenerContainerFactory3() {
        ConcurrentKafkaListenerContainerFactory<String,Manufacturer> factory = new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerFactory3());
        return factory;
    }
}
