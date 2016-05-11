package Documents;

import java.util.List;
import java.util.Optional;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import static java.util.Objects.requireNonNull;

@Repository("dao")
public class DocumentDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public DocumentDAO(final SessionFactory sessionFactory) {
        this.sessionFactory = requireNonNull(sessionFactory);
    }

    @Deprecated
    DocumentDAO() {}

    public void insert(final Document document) {
        if (document.getId() != null) {
            throw new IllegalArgumentException("can not insert " + document + " with assigned id");
        }
        session().save(document);
    }

    public Optional<Document> get(final int documentId) {
        final Document document = (Document) session().get(Document.class, documentId);
        return Optional.ofNullable(document);
    }

    @SuppressWarnings("unchecked")
    public List<Document> getAll() {
        final Criteria criteria = session().createCriteria(Document.class);
        return criteria.list();
    }

    public void update(final Document document) {
        session().update(document);
    }

    public void delete(final int documentId) {
        session().createQuery("DELETE Document WHERE id = :id")
                .setInteger("id", documentId)
                .executeUpdate();
    }

    private Session session() {
        return sessionFactory.getCurrentSession();
    }
}
