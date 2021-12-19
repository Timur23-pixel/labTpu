package tpu.db.demo.DAO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tpu.db.demo.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}