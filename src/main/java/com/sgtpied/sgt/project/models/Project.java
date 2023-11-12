package com.sgtpied.sgt.project.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Project {
		
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;

	private  String nomProject;

	private String descriptionProject;

	private Date  project_start_date;

	private Date project_end_date;

}
