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
public class UserDTO  implements Serializable {

    @Id
    @Column(unique = true, name ="email")
    private String email;


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(unique = true, name= "username")
    private String userName;

    @Column(name ="password")
    private String password;

    @Column(name ="role")
    private String role;




}
