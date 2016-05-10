package pl.mszarlinski.adjectives.license;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author mszarlinski on 2016-05-10.
 */
interface LicenseRepository extends JpaRepository<License, String> {

    Optional<License> findByOwner(String owner);
}
