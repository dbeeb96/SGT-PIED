package com.sgtpied.sgt.taches.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TaskAssignment")
public class TaskAssignment {

    @Id
    private  int idTaskAssignment;

}
