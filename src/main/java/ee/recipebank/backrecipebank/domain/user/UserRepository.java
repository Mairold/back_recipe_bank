package ee.recipebank.backrecipebank.domain.user;

import ee.recipebank.backrecipebank.business.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.username = ?1 and u.password = ?2")
    Optional<User> findByUsernameAndPassword(String username, String password);

    @Query("select (count(u) > 0) from User u where u.username = ?1")
    boolean existsBy(String username);




    // Meetod, mis otsib andmebaasist ainult username'i järgi


}
