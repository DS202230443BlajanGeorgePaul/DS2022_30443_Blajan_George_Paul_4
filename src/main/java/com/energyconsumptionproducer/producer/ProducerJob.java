package com.energyconsumptionproducer.producer;

import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ProducerJob {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String[] data = {"3.01,2", " 2,2", "3,2", " 1.45,2", " 1.2,2", "1.7,2", " 3.4,2", "2.2,2", "4.5,2", "6.7,2", "10.9,2"};
    private int count = 0;
    @Value("${topic}")
    private String topic;

    public ProducerJob(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Scheduled(fixedDelay = 6000)
    public void producerTask() {
        String[] array;
        if (count < data.length) {
            String line = data[count];
            array = line.split(",");
            Map<String, String> obj = new HashMap<>();
            obj.put("energy", array[0]);
            obj.put("time", String.valueOf(System.currentTimeMillis()));
            obj.put("device", array[1]);
            kafkaTemplate.send(topic, JSONValue.toJSONString(obj));
            count++;
        }
    }
}
