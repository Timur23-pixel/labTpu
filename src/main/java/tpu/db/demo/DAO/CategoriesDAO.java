package tpu.db.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import tpu.db.demo.models.Categories;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public interface CategoriesDAO extends JpaRepository<Categories, Integer>
{
    List<Categories> findAll();
    Optional<Categories> findById(Integer id);

}
