package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEvent {
    private String id;
    private String title;
    private String summary;
    private OffsetDateTime date;
    private String location;
}
