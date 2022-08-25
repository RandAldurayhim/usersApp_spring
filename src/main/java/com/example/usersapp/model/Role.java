package com.example.usersapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@ToString
@Table(name="role")
@NoArgsConstructor
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    // Desc
    @Column(name = "description")
    private String description;

    // Name
    @Column(name = "name")
    private String name;

//    @ManyToMany(mappedBy = "roles")
//    private Collection<User> users;

    @ManyToMany(fetch=FetchType.EAGER,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="role_privilege",
            joinColumns=@JoinColumn(name="role_id"),
            inverseJoinColumns=@JoinColumn(name="privilege_id")
    )
    private Collection<Privilege> privileges;

    public Role(String name){
        this.name=name;
    }


}
