package Roles;


import Roles.Role;
import java.util.List;
import java.util.Optional;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import static java.util.Objects.requireNonNull;

@Repository("dao")
public class RoleDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public RoleDAO(final SessionFactory sessionFactory) {
        this.sessionFactory = requireNonNull(sessionFactory);
    }

    @Deprecated
    RoleDAO() {}

    public void insert(final Role role) {
        if (role.getId() != null) {
            throw new IllegalArgumentException("can not insert " + role + " with assigned id");
        }
        session().save(role);
    }

    public Optional<Role> get(final int roleId) {
        final Role role = (Role) session().get(Role.class, roleId);
        return Optional.ofNullable(role);
    }

    @SuppressWarnings("unchecked")
    public List<Role> getAll() {
        final Criteria criteria = session().createCriteria(Role.class);
        return criteria.list();
    }

    public void update(final Role role) {
        session().update(role);
    }

    public void delete(final int roleId) {
        session().createQuery("DELETE Role WHERE id = :id")
                .setInteger("id", roleId)
                .executeUpdate();
    }

    private Session session() {
        return sessionFactory.getCurrentSession();
    }
}
