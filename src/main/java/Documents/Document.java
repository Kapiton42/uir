package Documents;

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

@Entity
@Table(name = "documents")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "description")
    private String description;

    @Column(name = "title")
    private String title;

    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "created_on")
    private Date createdOn;

    @Deprecated
    Document() {}

    public Document(Project project, String description, String title, int categoryId, Date createdOn) {
        this.project = project;
        this.description = description;
        this.title = title;
        this.categoryId = categoryId;
        this.createdOn = createdOn;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
