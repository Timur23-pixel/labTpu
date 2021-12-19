package tpu.db.demo.models;

import org.hibernate.service.Service;
import springfox.documentation.service.Server;

import javax.persistence.*;
import java.security.Provider;

@Entity
@Table(name = "categories", schema = "catalog")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categories_id_seq")
    @SequenceGenerator(name = "categories_id_seq", schema = "catalog",
    sequenceName = "categories_id_seq", allocationSize = 1)
    @Column(name = "id") private Integer id;
    @Column(name = "type") private String type;

    public Categories() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
