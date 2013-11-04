package jpa.mapping.collection;

import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class PhoneAsElement {

    String number;

    public PhoneAsElement() {

    }

    public PhoneAsElement(String number) {
        super();
        this.number = number;
    }
}
