package tpu.db.demo.DAO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tpu.db.demo.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
