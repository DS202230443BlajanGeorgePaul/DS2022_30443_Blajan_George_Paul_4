//package com.energyconsumptionproducer.producer;
//
//import org.json.simple.JSONValue;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.io.*;
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//public class ProducerJob {
//    private final KafkaTemplate<String, String> kafkaTemplate;
//    private final BufferedReader csvReader = new BufferedReader(new InputStreamReader(new ClassPathResource("sensor.csv").getInputStream()));
//    @Value("${topic}")
//    private String topic;
//
//    public ProducerJob(KafkaTemplate<String, String> kafkaTemplate) throws IOException {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//    @Scheduled(fixedDelay = 60000)
//    public void producerTask() throws IOException {
//        String[] array;
//        String line = csvReader.readLine();
//        if (line != null && !line.trim().isEmpty()) {
//            array = line.split(",");
//            Map<String, String> obj = new HashMap<>();
//            obj.put("energy", array[0]);
//            obj.put("time", String.valueOf(System.currentTimeMillis() / 1000));
//            obj.put("device", array[1]);
//            kafkaTemplate.send(topic, JSONValue.toJSONString(obj));
//        }
//    }
//}
