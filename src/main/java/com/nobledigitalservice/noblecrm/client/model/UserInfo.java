package com.nobledigitalservice.noblecrm.client.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table
public class UserInfo implements Serializable {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    @Column
    private String email;

    @Column
    private String address;

    @Column
    private int zip;

    @Column
    private String city;

    @Column
    private String state;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column
    private String birthDay;

    @Column
    private String jobTitle;

    @Column
    private String demographicInfo;

    @Column
    private String companyName;

    @Column
    private String leadSource;

    @Column
    private String maritalStatus;

    @Column
    private String numberOfChildren;

}
