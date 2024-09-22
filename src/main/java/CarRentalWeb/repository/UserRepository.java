package CarRentalWeb.repository;

import CarRentalWeb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserNameAndUserPassword(String userName, String userPassword);
}