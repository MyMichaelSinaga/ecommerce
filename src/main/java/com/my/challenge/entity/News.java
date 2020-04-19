package com.my.challenge.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "news")
@Data
public class News {
    @Id
    @SequenceGenerator( name = "news_id_seq", sequenceName = "news_id_seq", allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.AUTO, generator = "news_id_seq" )
    private int id;

    private String title;

    private String content;

    private String status;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "created_by")
    private String createdBy;
}
