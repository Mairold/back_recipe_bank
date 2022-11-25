package ee.recipebank.backrecipebank.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.username = ?1 and u.password = ?2")
    Optional<User> findByUsernameAndPassword(String username, String password);

    @Query("select u from User u where u.username = ?1")
    Optional<User> findByUsername(String username);
    //Optional<NewUser> findByUsername(String username); // Meetod, mis otsib ainult username'i järgi

}
