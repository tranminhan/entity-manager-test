package jpa.mapping.relationship.ordering.persistent;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity
public class PrintQueue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer        id;

    @OneToMany(mappedBy = "printQueue", cascade = { CascadeType.PERSIST })
    @OrderColumn(name = "PRINT_ORDER")
    List<PrintJob> jobs;

    public void addJob(String name) {
        if (jobs == null) {
            jobs = new ArrayList<PrintJob>();
        }
        PrintJob printJob = new PrintJob(name);
        printJob.setPrintQueue(this);
        jobs.add(printJob);
    }

    public List<PrintJob> getJobs() {
        return jobs;
    }

    public void setJobs(List<PrintJob> jobs) {
        this.jobs = jobs;
    }

    public PrintQueue() {
        super();
    }

    public Integer getId() {
        return id;
    }

}
