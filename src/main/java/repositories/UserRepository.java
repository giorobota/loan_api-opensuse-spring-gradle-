package repositories;

import entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository 
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByPrivateId(String privateId);
    void deleteByPrivateId(String privateId);
}
