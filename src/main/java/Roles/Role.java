package Roles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "position")
    private Integer position;

    @Column(name = "assignable")
    private Boolean assignable;

    @Column(name = "permissions")
    private Boolean permissions;

    @Deprecated
    Role() {}

    public Role(String name, Integer position, Boolean assignable, Boolean permissions) {
        this.name = name;
        this.position = position;
        this.assignable = assignable;
        this.permissions = permissions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Boolean getAssignable() {
        return assignable;
    }

    public void setAssignable(Boolean assignable) {
        this.assignable = assignable;
    }

    public Boolean getPermissions() {
        return permissions;
    }

    public void setPermissions(Boolean permissions) {
        this.permissions = permissions;
    }
}
