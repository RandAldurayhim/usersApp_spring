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
@Table(name="privilege")
@NoArgsConstructor
public class Privilege implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // Desc
    @Column(name = "description")
    private String description;

    // Name
    @Column(name = "name")
    private String name;

//    @ManyToMany(mappedBy = "privileges")
//    private Collection<Role> roles;

}
