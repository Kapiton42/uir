package Members;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import projects.Project;
import users.User;

@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "mail_notification")
    private Boolean mailNotification;

    @Deprecated
    Member() {}

    public Member(Project project, User user, Date createdOn, Boolean mailNotification) {
        this.project = project;
        this.user = user;
        this.createdOn = createdOn;
        this.mailNotification = mailNotification;
    }

    public Integer getId() {
        return id;
    }

    void setId(Integer id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Boolean getMailNotification() {
        return mailNotification;
    }

    public void setMailNotification(Boolean mailNotification) {
        this.mailNotification = mailNotification;
    }
}
