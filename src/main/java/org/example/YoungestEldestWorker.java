package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class YoungestEldestWorker {
    private String type;
    private String workerName;
    private LocalDate birthday;
}
