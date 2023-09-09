package com.example.GrowSkill.Repository;

import com.example.GrowSkill.Models.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Integer> {

    @Modifying
    @Transactional
    @Query(value="INSERT INTO certificate (certificateUrl, course) VALUES (:certificate.certificateUrl, :certificate.course)", nativeQuery = true)
    void saveCertificate(Certificate certificate);
}
