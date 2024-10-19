package com.baraa.runnerz.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record Run(
        @Id
        Integer id,

        @NotEmpty
        String title,

        LocalDateTime startedOn,

        LocalDateTime completedOn,

        @Positive
        Integer miles,

        Location location

) {
    public Run {
        if(!completedOn.isAfter(startedOn)){
            throw new IllegalArgumentException("Completed O Must after Started on");
        }

    }

}
