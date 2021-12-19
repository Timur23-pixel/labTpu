package tpu.db.demo.models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product", schema = "catalog")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_pkey")
    @SequenceGenerator(name = "product_id_seq", schema = "catalog",
            sequenceName = "product_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer Id;
    @Column(name = "name")
    private String name;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Categories> categories;

    public Product() {}

    public Product(Product p)
    {
        this.Id = p.Id;
        this.name = p.name;
        this.categories = p.categories;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCategories(Categories categories){
        this.categories.add(categories);
    }

    @Autowired
    public Set<Categories> getCategories()
    {
        return this.categories;
    }
}
