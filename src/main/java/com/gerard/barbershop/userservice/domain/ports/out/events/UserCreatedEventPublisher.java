package com.gerard.barbershop.userservice.domain.ports.out.events;

import com.gerard.barbershop.userservice.domain.events.UserCreatedEvent;

public interface UserCreatedEventPublisher {
    void publish(UserCreatedEvent userCreatedEvent);
}
