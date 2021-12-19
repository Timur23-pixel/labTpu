package tpu.db.demo.response;

import tpu.db.demo.models.Categories;

import java.util.Set;

public class ProductResponse
{
    private Integer id;
    private String name;
    private Set<Categories> categories;

    public ProductResponse(Integer id, String name, Set<Categories> categories)
    {
        this.id = id;
        this.name = name;
        this.categories = categories;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Categories> getCategories() {
        return categories;
    }

    public void setCategories(Set<Categories> categories) {
        this.categories = categories;
    }
}
