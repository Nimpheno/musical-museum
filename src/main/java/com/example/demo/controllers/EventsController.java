package com.example.demo.controllers;

import com.example.demo.dto.CreateEvent;
import com.example.demo.entity.EventEntity;
import com.example.demo.services.EventsService;
import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventsController {

    private final EventsService eventsService;

    @PostMapping
    public ResponseEntity<EventEntity> createEvent(@Valid @RequestBody CreateEvent createEvent) {
        EventEntity createdEvent = eventsService.addEvent(createEvent);
        return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Object>> getEvents(){
        // TODO: get the events from the eventsService
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
    }


}
