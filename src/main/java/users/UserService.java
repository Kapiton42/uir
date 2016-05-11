package users;

import java.util.List;
import java.util.Optional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static java.util.Objects.requireNonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("UserService")
public class UserService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(final SessionFactory sessionFactory,
                             final UserDAO userDAO, final UserService userService) {
        this.userService = requireNonNull(userService);
        this.userDAO = requireNonNull(userDAO);
    }

    @Deprecated
    UserService() {}

    public UserService getUserService() {
        return userService;
    }

    @Transactional
    public void save(final User user) {
        userDAO.insert(user);
    }

    @Transactional
    public Optional<User> get(final int userId) {
        return userDAO.get(userId);
    }

    @Transactional
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Transactional
    public void update(final User user) {
        userDAO.update(user);
    }

    @Transactional
    public void delete(final int userId) {
        userDAO.delete(userId);
    }
}

