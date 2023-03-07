package ro.projects.todoapp.domain.user;

public interface UserRepository {
    void save(final User user);

    User findById(final String id);
}
