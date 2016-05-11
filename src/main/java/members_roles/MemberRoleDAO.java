package members_roles;

import java.util.List;
import java.util.Optional;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


import static java.util.Objects.requireNonNull;

public class MemberRoleDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public MemberRoleDAO(final SessionFactory sessionFactory) {
        this.sessionFactory = requireNonNull(sessionFactory);
    }

    @Deprecated
    MemberRoleDAO() {}

    public void insert(final MemberRole memberRole) {
        if (memberRole.getId() != null) {
            throw new IllegalArgumentException("can not insert " + memberRole + " with assigned id");
        }
        session().save(memberRole);
    }

    public Optional<MemberRole> get(final int memberRoleId) {
        final MemberRole memberRole = (MemberRole) session().get(MemberRole.class, memberRoleId);
        return Optional.ofNullable(memberRole);
    }

    @SuppressWarnings("unchecked")
    public List<MemberRole> getAll() {
        final Criteria criteria = session().createCriteria(MemberRole.class);
        return criteria.list();
    }

    public void update(final MemberRole memberRole) {
        session().update(memberRole);
    }

    public void delete(final int memberRoleId) {
        session().createQuery("DELETE MemberRole WHERE id = :id")
                .setInteger("id", memberRoleId)
                .executeUpdate();
    }

    private Session session() {
        return sessionFactory.getCurrentSession();
    }
}
