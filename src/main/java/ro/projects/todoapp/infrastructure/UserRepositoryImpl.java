package ro.projects.todoapp.infrastructure;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import ro.projects.todoapp.domain.user.User;
import ro.projects.todoapp.domain.user.UserRepository;

@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private MongoTemplate mongoTemplate;

    @Override
    public User findById(final String id) {
        return this.mongoTemplate.findById(id, User.class);
    }

    @Override
    public void save(final User user) {
        this.mongoTemplate.save(user);
    }
}
