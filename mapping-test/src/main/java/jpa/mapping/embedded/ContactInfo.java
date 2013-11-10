package jpa.mapping.embedded;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Embeddable
public class ContactInfo {

    @Embedded
    EmbeddedAddress residence;

    @ManyToOne(cascade = { CascadeType.PERSIST })
    @JoinColumn(name = "PRI_NUMBER")
    EmbeddedPhone   primaryPhone;

    public EmbeddedAddress getResidence() {
        return residence;
    }

    public void setResidence(EmbeddedAddress residence) {
        this.residence = residence;
    }

    public EmbeddedPhone getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(EmbeddedPhone primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    // @ManyToMany
    // Map<String, EmbeddedPhone> phones;
}
