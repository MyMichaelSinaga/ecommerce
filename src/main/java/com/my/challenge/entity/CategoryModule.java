package com.my.challenge.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "category_module")
@Data
public class CategoryModule {
    @Id
    @SequenceGenerator( name = "category_module_id_seq", sequenceName = "category_module_id_seq", allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.AUTO, generator = "category_module_id_seq" )
    private int id;

    @Column(name = "module_name")
    private String moduleName;

    @Column(name = "module_order")
    private int moduleOrder;

    private String description;

    private boolean active = true;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( referencedColumnName = "id", nullable = false )
    private Role role;
}
