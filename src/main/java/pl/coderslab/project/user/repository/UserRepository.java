package pl.coderslab.project.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.project.user.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String name);

    boolean existsByUsername(String username);
}
