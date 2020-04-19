package com.my.challenge.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "role")
@Data
public class Role {
    @Id
    @SequenceGenerator( name = "role_id_seq", sequenceName = "role_id_seq", allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.AUTO, generator = "role_id_seq" )
    private int id;

    private String position;
}
