package com.my.challenge.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order_detail")
@Data
public class Order {
    @Id
    @SequenceGenerator( name = "order_detail_id_seq", sequenceName = "order_detail_id_seq", allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.AUTO, generator = "order_detail_id_seq" )
    private int id;

    private String invoiceNumber;

    @Column(name =  "total_price")
    private Double totalPrice;

    @Column(name =  "payment_method")
    private String paymentMethod;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( referencedColumnName = "id", nullable = false )
    private User user;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( referencedColumnName = "id", nullable = false )
    private Product product;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( referencedColumnName = "id", nullable = false )
    private Promo promo;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( referencedColumnName = "id", nullable = false )
    private FlashSale flashSale;
}
