package users;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public final class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "hashed_password")
    private String hashedPassword;

    @Column(name = "mail")
    private String mail;

    @Column(name = "mail_notification")
    private Boolean mailNotification;

    @Column(name = "admin")
    private Boolean admin;

    @Column(name = "status")
    private int status;

    @Column(name = "last_login_on")
    private Date lastLoginOn;

    @Column(name = "language")
    private String language;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "updated_on")
    private Date updatedOn;

    @Column(name = "type")
    private String type;

    public User(String firstName, String lastName, String hashedPassword, String mail,
                 Boolean mailNotification, Boolean admin, int status, Date lastLoginOn,
                 String language, Date createdOn, Date updatedOn, String type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hashedPassword = hashedPassword;
        this.mail = mail;
        this.mailNotification = mailNotification;
        this.admin = admin;
        this.status = status;
        this.lastLoginOn = lastLoginOn;
        this.language = language;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.type = type;
    }

    @Deprecated
    User() {}

    public Integer getId() {
        return id;
    }

    void setId(final int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

