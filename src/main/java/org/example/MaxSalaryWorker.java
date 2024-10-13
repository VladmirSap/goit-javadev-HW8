package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MaxSalaryWorker {
    private String workerName;
    private int salary;
}
