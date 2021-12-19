package tpu.db.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tpu.db.demo.models.Categories;
import tpu.db.demo.models.Product;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface ProductDAO extends JpaRepository<Product, Integer>
{
    List<Product> findAll();
    Optional<Product> findById(Integer id);
}
