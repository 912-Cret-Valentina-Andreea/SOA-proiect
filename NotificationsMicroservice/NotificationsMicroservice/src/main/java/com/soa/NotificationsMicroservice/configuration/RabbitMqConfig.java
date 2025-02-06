package com.soa.NotificationsMicroservice.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Configuration
@AllArgsConstructor
public class RabbitMqConfig {
    public final static String NOTIFICATION_QUEUE = "NotificationQueue";

    @Bean
    public Queue notificationQueue() {
        return QueueBuilder.durable(NOTIFICATION_QUEUE)
                .quorum()
                .deadLetterExchange(NOTIFICATION_QUEUE + ".dlq")
                .deadLetterRoutingKey("deadLetter")
                .build();
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        final JavaTimeModule module = new JavaTimeModule();
        final LocalDateDeserializer localDateTimeDeserializer = new LocalDateDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        module.addDeserializer(LocalDate.class, localDateTimeDeserializer);
        final ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
                .modules(module)
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .build();

        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
