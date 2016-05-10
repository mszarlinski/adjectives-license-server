package pl.mszarlinski.adjectives.license;

import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author mszarlinski on 2016-05-10.
 */
@Data
@Entity
class License {

    @Id
    private String uuid;

    private String owner;

    static License createForOwner(@NonNull final String owner) {
        final License license = new License();
        license.setUuid(UUID.randomUUID().toString());
        license.setOwner(owner);
        return license;
    }
}
