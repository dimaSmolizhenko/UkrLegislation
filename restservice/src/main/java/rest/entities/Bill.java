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
@Table(name = "bill")
public class Bill {

    @Id
    private Integer  id;
    @Column(name = "deputy_id")
    private Integer deputyId ;
    private String name ;
    private String description ;
    @Column(name = "making_date")
    private Date makingDate;

    public Bill() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeputyId() {
        return deputyId;
    }

    public void setDeputyId(Integer deputyId) {
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

    public Date getMakingDate() {
        return makingDate;
    }

    public void setMakingDate(Date makingDate) {
        this.makingDate = makingDate;
    }
}
