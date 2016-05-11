package users;

import java.util.List;
import java.util.Optional;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static java.util.Objects.requireNonNull;

@Repository("dao")
public class UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public UserDAO(final SessionFactory sessionFactory) {
        this.sessionFactory = requireNonNull(sessionFactory);
    }

    @Deprecated
    UserDAO() {}

    public void insert(final User user) {
        if (user.getId() != null) {
            throw new IllegalArgumentException("can not insert " + user + " with assigned id");
        }
        session().save(user);
    }

    public Optional<User> get(final int userId) {
        final User user = (User) session().get(User.class, userId);
        return Optional.ofNullable(user);
    }

    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        final Criteria criteria = session().createCriteria(User.class);
        return criteria.list();
    }

    public void update(final User user) {
        session().update(user);
    }

    public void delete(final int userId) {
        session().createQuery("DELETE User WHERE id = :id")
                .setInteger("id", userId)
                .executeUpdate();
    }

    private Session session() {
        return sessionFactory.getCurrentSession();
    }
}
