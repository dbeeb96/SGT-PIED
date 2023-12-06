package com.sgtpied.sgt.taches.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDetailsDTO {
    private String title;
    private String description;
}
