package rest.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by dima on 7/18/15.
 */
@Entity
@Table(name = "law")
public class Law {

    @Id
    @Column(name = "lawId")
    private int lawId;
    @Column(name = "deputy_id")
    private int deputyId;
    private String name;
    private String description;
    private Date approvalDate;


    public Law() {

    }

    public int getLawId() {
        return lawId;
    }

    public void setLawId(int lawId) {
        this.lawId = lawId;
    }

    public int getDeputyId() {
        return deputyId;
    }

    public void setDeputyId(int deputyId) {
        this.deputyId = deputyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }
}
