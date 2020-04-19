package com.my.challenge.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "flash_sale")
@Data
public class FlashSale {
    @Id
    @SequenceGenerator( name = "flash_sale_id_seq", sequenceName = "flash_sale_id_seq", allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.AUTO, generator = "flash_sale_id_seq" )
    private int id;

    private String name;

    private String description;

    private int quantity;

    private Double price;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( referencedColumnName = "id", nullable = false )
    private Product product;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( referencedColumnName = "id", nullable = false )
    private Promo promo;
}
