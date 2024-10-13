package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LongestProject {
    private String projectName;
    private int longestDuration;
}
