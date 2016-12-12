package net.vikesh.ssm.model;

import javax.persistence.*;

/**
 * Created by Vikesh on 13-Dec-16.
 */
@Entity
@Table(name = "ARTICLE")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;
}
