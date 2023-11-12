package com.sgtpied.sgt.taches.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "TaskListStatus")
public class TaskListStatus {

    @Id
    private int idTaskListStatus;

    private String StatusDescription;

}
