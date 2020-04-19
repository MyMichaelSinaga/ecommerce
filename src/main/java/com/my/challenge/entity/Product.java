package com.my.challenge.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @SequenceGenerator( name = "product_id_seq", sequenceName = "product_id_seq", allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.AUTO, generator = "product_id_seq" )
    private int id;

    private String name;

    private String description;

    private int quantity;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "created_by")
    private String createdBy;
}
