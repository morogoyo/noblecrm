package com.nobledigitalservice.noblecrm.asset_admin.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminURLs implements Serializable {




    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column(unique = true)
    private String url;

    @Column
    private String adminUrl;


}
