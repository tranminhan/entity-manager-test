package jpa.mapping.collection;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class VacationEntry {

    @Temporal(TemporalType.DATE)
    Date startDate;

    @Column(name = "DAYS")
    int  daysTaken;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getDaysTaken() {
        return daysTaken;
    }

    public VacationEntry() {
        super();
    }

    public VacationEntry(Date startDate, int daysTaken) {
        super();
        this.startDate = startDate;
        this.daysTaken = daysTaken;
    }

    public void setDaysTaken(int daysTaken) {
        this.daysTaken = daysTaken;
    }

}
