package com.sgtpied.sgt.admin.models;

import com.sgtpied.sgt.taches.models.Task;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends Auditable<String> {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String firstname;
    private String lastname;
	private String username;
	private String password;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(
                name = "user_role",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") }
    )
    Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "assignedUser", cascade = CascadeType.ALL)
    private List<Task> assignedTasks;

}
