package MainApp.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import MainApp.Model.User.User;

public interface UserRepository extends JpaRepository<User, Long>
{
    Optional<User> findByUsername(final String username);
    Optional<User> findByUsernameAndPassword(final String username, final String password);
}