package Members;

import java.util.List;
import java.util.Optional;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import static java.util.Objects.requireNonNull;

@Repository("dao")
public class MemberDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public MemberDAO(final SessionFactory sessionFactory) {
        this.sessionFactory = requireNonNull(sessionFactory);
    }

    @Deprecated
    MemberDAO() {}

    public void insert(final Member member) {
        if (member.getId() != null) {
            throw new IllegalArgumentException("can not insert " + member + " with assigned id");
        }
        session().save(member);
    }

    public Optional<Member> get(final int memberId) {
        final Member member = (Member) session().get(Member.class, memberId);
        return Optional.ofNullable(member);
    }

    @SuppressWarnings("unchecked")
    public List<Member> getAll() {
        final Criteria criteria = session().createCriteria(Member.class);
        return criteria.list();
    }

    public void update(final Member member) {
        session().update(member);
    }

    public void delete(final int memberId) {
        session().createQuery("DELETE Member WHERE id = :id")
                .setInteger("id", memberId)
                .executeUpdate();
    }

    private Session session() {
        return sessionFactory.getCurrentSession();
    }
}
