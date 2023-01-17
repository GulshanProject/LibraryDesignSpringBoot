package com.example.LMSbackend.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name="student")
@Getter
@Setter
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(nullable = false)
    private String name;


 // @Column(name = "school_email",unique = true,nullable = false)
    private String email;

    private  int age;

    @Column(columnDefinition="varchar(255) default  'India' ")
    private String country;

    @CreationTimestamp
    private Date createdOn;

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    private Card card;



    @UpdateTimestamp
    private Date updatedOn;

    Student(int id,String name, int age, String country){
        this.id=id;
        this.name=name;
        this.age=age;
        this.country=country;
    }

}
