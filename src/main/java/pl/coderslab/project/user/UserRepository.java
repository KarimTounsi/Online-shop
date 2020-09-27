package pl.coderslab.project.user;

import org.springframework.data.jpa.repository.JpaRepository;




public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String name);
}
