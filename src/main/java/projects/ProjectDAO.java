package projects;

import java.util.List;
import java.util.Optional;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static java.util.Objects.requireNonNull;

@Repository("dao")
public class ProjectDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public ProjectDAO(final SessionFactory sessionFactory) {
        this.sessionFactory = requireNonNull(sessionFactory);
    }

    @Deprecated
    ProjectDAO() {}

    public void insert(final Project project) {
        if (project.getId() != null) {
            throw new IllegalArgumentException("can not insert " + project + " with assigned id");
        }
        session().save(project);
    }

    public Optional<Project> get(final int projectId) {
        final Project project = (Project) session().get(Project.class, projectId);
        return Optional.ofNullable(project);
    }

    @SuppressWarnings("unchecked")
    public List<Project> getAll() {
        final Criteria criteria = session().createCriteria(Project.class);
        return criteria.list();
    }

    public void update(final Project project) {
        session().update(project);
    }

    public void delete(final int projectId) {
        session().createQuery("DELETE Project WHERE id = :id")
                .setInteger("id", projectId)
                .executeUpdate();
    }

    private Session session() {
        return sessionFactory.getCurrentSession();
    }
}
