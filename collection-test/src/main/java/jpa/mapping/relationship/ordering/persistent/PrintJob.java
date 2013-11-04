package jpa.mapping.relationship.ordering.persistent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class PrintJob {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer    id;

    String     name;

    @ManyToOne
    @JoinColumn(name="queue_id", insertable = false, updatable = false, nullable = false)
    PrintQueue printQueue;

    public PrintJob() {
        super();
    }

    public PrintJob(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PrintQueue getPrintQueue() {
        return printQueue;
    }

    public void setPrintQueue(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    // @PrePersist
    // @PreUpdate
    // void prepareOrder() {
    // printOrder = printQueue.getJobs().indexOf(this);
    // }
}
