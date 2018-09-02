package info.lazycompiler.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class DemoUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(
            name = "first_name",
            nullable = false)
    @Setter
    @Getter
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false
    )
    @Setter
    @Getter
    private String lastName;

    @Column(
            name = "username",
            nullable = false
    )
    @Setter
    @Getter
    private String username;

    @Column(
            name = "password",
            nullable = false
    )
    @Setter
    @Getter
    private String password;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
