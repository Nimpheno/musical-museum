package com.example.demo.controllers;

import com.example.demo.dto.Event;
import com.example.demo.services.EventsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/events")
@AllArgsConstructor
public class EventsController {

    private final EventsService eventsService;

    @GetMapping
    public ResponseEntity<?> getEvents(){
        // TODO: get the events from the eventsService
        //        List<Event> events = eventsService
        return null;
    }


}
