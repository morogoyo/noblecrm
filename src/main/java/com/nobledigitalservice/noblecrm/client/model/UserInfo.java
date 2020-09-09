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

    @Id
    private Long id;

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
    private String JobTitle;

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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private UserDTO userDto;
}
