package com.nobledigitalservice.noblecrm.asset_admin.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminURLs {

    @Id
    @Column
    private String email;

    @Column
    private String url;


    @Column
    private Long id;


}
