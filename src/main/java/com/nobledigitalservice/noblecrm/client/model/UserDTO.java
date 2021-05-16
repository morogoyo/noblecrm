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

    @Column(name = "id")
    private String id;


    @Column(name="username")
    private String userName;

    @Column(name ="password")
    private String password;

    @Column(name ="role")
    private String role;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "email")
    private UserInfo userInfo;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email")
    private ClientAssets clientAssets;


}
