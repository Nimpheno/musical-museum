package com.example.demo.entity;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.OffsetDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventEntity {
    @Id
    private String id;

    @NotNull
    private String title;

    @NotNull
    private String summary;

    @NotNull
    private OffsetDateTime date;

    @NotNull
    private String location;
}
