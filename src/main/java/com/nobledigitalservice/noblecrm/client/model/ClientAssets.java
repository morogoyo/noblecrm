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
public class ClientAssets implements Serializable {

    @Id
    @Column(unique = true, name ="email")
    private String email;

    @Column(name = "id")
    private Long id;

    @Column
    private String adminURL;

    @Column
    private String siteURL;

    @Column
    private String services;

}
