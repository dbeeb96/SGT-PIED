package com.sgtpied.sgt.taches.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;

public enum TaskStatus {
    @JsonProperty("À FAIRE")
    TODO("À FAIRE"),
    @JsonProperty("EN COURS")

    IN_PROGRESS("EN COURS"),
    @JsonProperty("TERMINEE")

    DONE("TERMINÉE");
    private final  String title;

    TaskStatus(String title) {
        this.title = title;
    }
    public  String getTitle(){
        return this.title;
    }
}
