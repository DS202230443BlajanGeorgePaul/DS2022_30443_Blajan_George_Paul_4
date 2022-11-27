package com.energyconsumptionproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class EnergyConsumptionProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnergyConsumptionProducerApplication.class, args);
    }

}
