package entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
@Table(name = "users")
public class User {
    @GeneratedValue
    @Id
    private int id;
    @NotNull
    @Size(max = 40)
    private String fName;
    @NotNull
    @Size(max = 40)
    private String lName;
    @NotNull
    private Date birthDate;

    @Column(unique = true)
    private String privateId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPrivateId() {
        return privateId;
    }

    public void setPrivateId(String privateId) {
        this.privateId = privateId;
    }
}
