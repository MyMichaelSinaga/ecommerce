package com.my.challenge.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction_history")
@Data
public class TransactionHistory {
    @Id
    @SequenceGenerator( name = "transaction_history_id_seq", sequenceName = "transaction_history_id_seq", allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.AUTO, generator = "transaction_history_id_seq" )
    private int id;

    @Column(name =  "payment_status")
    private String paymentStatus;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( referencedColumnName = "id", nullable = false )
    private Order order;
}
