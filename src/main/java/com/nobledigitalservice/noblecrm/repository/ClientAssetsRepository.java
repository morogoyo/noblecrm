package com.nobledigitalservice.noblecrm.repository;

import com.nobledigitalservice.noblecrm.client.model.ClientAssets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientAssetsRepository extends JpaRepository<ClientAssets, String> {


}
