package projects;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "homepage")
    private String homepage;

    @Column(name = "is_public")
    private Boolean isPublic;

    @Column(name = "admin")
    private Boolean admin;

    @Column(name = "parent_id")
    private int parentId;

    @Column(name = "last_login_on")
    private Date lastLoginOn;

    @Column(name = "identifier")
    private String identifier;

    @Column(name = "status")
    private int status;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "updated_on")
    private Date updatedOn;

    @Column(name = "type")
    private String type;

    @Deprecated
    Project() {}

    public Project(String type, String name, String description, String homepage, Boolean isPublic, Boolean admin,
                   int parentId, Date lastLoginOn, String identifier, int status, Date createdOn, Date updatedOn) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.homepage = homepage;
        this.isPublic = isPublic;
        this.admin = admin;
        this.parentId = parentId;
        this.lastLoginOn = lastLoginOn;
        this.identifier = identifier;
        this.status = status;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public Integer getId() {
        return id;
    }

    void setId(Integer id) {
        this.id = id;
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

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public Date getLastLoginOn() {
        return lastLoginOn;
    }

    public void setLastLoginOn(Date lastLoginOn) {
        this.lastLoginOn = lastLoginOn;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
