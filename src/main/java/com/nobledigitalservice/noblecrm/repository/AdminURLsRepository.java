package com.nobledigitalservice.noblecrm.repository;

import com.nobledigitalservice.noblecrm.asset_admin.model.AdminURLs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminURLsRepository extends JpaRepository<AdminURLs, String> {
}
