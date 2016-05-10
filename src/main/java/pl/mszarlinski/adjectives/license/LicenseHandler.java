package pl.mszarlinski.adjectives.license;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author mszarlinski on 2016-05-10.
 */
@Component
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
class LicenseHandler {

    private final LicenseRepository licenseRepository;

    Optional<License> acquireLicense(final String owner) {
        return licenseRepository.findByOwner(owner);
    }

    License grantLicense(final String owner) {
        final License license = License.createForOwner(owner);
        log.info("License {} granted to owner {}", license.getUuid(), owner);

        return licenseRepository.save(license);
    }

    void revokeLicense(@PathVariable final String owner) {
        licenseRepository.findByOwner(owner).ifPresent(license -> {
            licenseRepository.delete(license);
            log.info("License {} revoked for owner {}", license.getUuid(), owner);
        });
    }
}
