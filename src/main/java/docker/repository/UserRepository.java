package docker.repository;


import docker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * It will find users
     * on the basis of email
     * @param email
     * @return
     */
    @Query("SELECT user FROM User user WHERE user.email = ?1")
    public User findByEmail(String email);

}
