package com.gerard.barbershop.userservice.infrastructure.adapters.aws;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gerard.barbershop.userservice.domain.events.UserCreatedEvent;
import com.gerard.barbershop.userservice.domain.ports.out.events.UserCreatedEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;

@Component
@RequiredArgsConstructor
public class SnsUserCreatedEventPublisher implements UserCreatedEventPublisher {

    private final SnsClient snsClient;
    private final ObjectMapper objectMapper;

    @Value("${aws.sns.topicArn}")
    private String topicArn;

    @Override
    public void publish(UserCreatedEvent event) {
        try {
            String message = objectMapper.writeValueAsString(event);
            PublishRequest request = PublishRequest.builder()
                    .topicArn(topicArn)
                    .message(message)
                    .build();
            snsClient.publish(request);
        } catch (Exception e) {
            throw new RuntimeException("Error publishing SNS message", e);
        }
    }
}
