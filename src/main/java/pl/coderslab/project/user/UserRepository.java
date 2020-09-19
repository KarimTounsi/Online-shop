package pl.honestit.spring.demo.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.honestit.spring.demo.model.domain.Advert;
import pl.honestit.spring.demo.model.domain.User;

import java.util.List;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Query(value = " select description, posted, title from adverts join users_observed_adverts uoa on adverts.id = uoa.observed_adverts_id where uoa.user_id=?1" , nativeQuery = true )
    Set<Advert> ListOfFollowedAdverts (Long userId);
}
