package jpa.mapping.basic;

import java.io.Serializable;

public class EmployeeNotes implements Serializable {

    private static final long serialVersionUID = -6881795556845274673L;
    String                    note1;
    String                    note2;

    public String getNote1() {
        return note1;
    }

    public void setNote1(String note1) {
        this.note1 = note1;
    }

    public String getNote2() {
        return note2;
    }

    public void setNote2(String note2) {
        this.note2 = note2;
    }

}
