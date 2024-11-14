package CarRentalWeb.repository;

import CarRentalWeb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserNameFi(String userNameFi);
    User findByUserNameEn(String userNameEn);
    User findByUserNameFr(String userNameFr);
    User findByUserNameJp(String userNameJp);
    User findByUserNameZh(String userNameZh);
}