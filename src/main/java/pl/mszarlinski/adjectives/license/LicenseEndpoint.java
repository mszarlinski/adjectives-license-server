package pl.mszarlinski.adjectives.license;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mszarlinski on 2016-05-10.
 */
@RestController
@RequestMapping("/license")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LicenseEndpoint {

    private final LicenseHandler licenseHandler;

    @RequestMapping
    public Optional<License> acquireLicense(final HttpServletRequest request) {
        return licenseHandler.acquireLicense(request.getRemoteAddr());
    }

    @RequestMapping(value = "/{owner}", method = RequestMethod.POST)
    public License grantLicense(@PathVariable final String owner) {
        return licenseHandler.grantLicense(owner);
    }

    @RequestMapping(value = "/{owner}", method = RequestMethod.DELETE)
    public void revokeLicense(@PathVariable final String owner) {
        licenseHandler.revokeLicense(owner);
    }
}
