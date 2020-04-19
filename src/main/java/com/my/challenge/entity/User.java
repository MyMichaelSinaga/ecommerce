package com.my.challenge.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @SequenceGenerator( name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.AUTO, generator = "user_id_seq" )
    private int id;

    private String name;

    private String email;

    private String address;

    private String username;

    private String password;

    @OneToOne( fetch = FetchType.LAZY )
    @JoinColumn( referencedColumnName = "id", nullable = false )
    private Role role;
}