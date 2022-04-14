package ru.heavyproject.groupfinder.server.entities;

import javax.persistence.*;

@Entity
@Table(name = "group_t")
public class Group {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long group_id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;


}
