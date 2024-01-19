package com.example.demo.services;

import com.example.demo.dto.CreateEvent;
import com.example.demo.entity.EventEntity;
import com.example.demo.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventsService {

    private final EventRepository eventRepository;

    public EventEntity addEvent(CreateEvent createEvent) {
        EventEntity newEvent = new EventEntity(
                createEvent.getId(),
                createEvent.getTitle(),
                createEvent.getSummary(),
                createEvent.getDate().toString(),
                createEvent.getLocation()
        );
        return eventRepository.save(newEvent);
    }

    public List<CreateEvent> getEvents() {
        // TODO: get events from the DB and return them
        return null;
    }

}
