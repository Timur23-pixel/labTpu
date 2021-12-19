package tpu.db.demo.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tpu.db.demo.DAO.CategoriesDAO;
import tpu.db.demo.DAO.ProductDAO;
import tpu.db.demo.models.Categories;
import tpu.db.demo.models.Product;
import tpu.db.demo.response.ProductResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(value = "Контроллер продукта", description = "Rest API for product", tags = "Контроллер продукта")
public class ProductController {

    @Autowired
    ProductDAO productDAO;
    @RequestMapping(
            value = "/shoes",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Возврат всей продукции", response = JSONPObject.class)
    public List<ProductResponse>  getAllShoes(Model model)
    {
        List<Product> productAll = new ArrayList<Product>();

        productDAO.findAll().forEach(productAll::add);

        return productAll
                .stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(), product.getCategories()))
                .collect(Collectors.toList());
    }

    @RequestMapping(
            value = "/shoes/get",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Возврат продукта по id", response = JSONPObject.class)
    public ProductResponse  getShoeById(@RequestParam(required = false) Integer id, Model model)
    {
        Product prod = productDAO.findById(id).get();
        return new ProductResponse(prod.getId(), prod.getName(), prod.getCategories());
    }

    @PostMapping("/shoe/delete")
    @ApiOperation(value = "Удаление продукта по id", response = JSONPObject.class)
    public HttpStatus deleteProduct(@RequestParam(required = true, defaultValue = "" ) Integer productId,
                                 Model model)
    {
        try
        {
            productDAO.deleteById(productId);
        }
        catch(Exception exc)
        {
        return HttpStatus.NOT_FOUND;
        }
        return HttpStatus.ACCEPTED;
    }

    @Autowired
    CategoriesDAO categoriesDAO;
    @RequestMapping(
            value = "/shoes/addCategory",
            method = RequestMethod.POST
    )
    @ApiOperation(value = "Добавить продукту(id1) категорию(id2)", response = HttpStatus.class)
    public HttpStatus addCategory(@RequestParam(required = false) Integer productId,
                                  @RequestParam(required = false) Integer categoryId,
                                  Model model)
    {
        if(productDAO.findById(productId).isPresent()){
            Product prod = productDAO.findById(productId).get();
            Categories categ = categoriesDAO.getById(categoryId);

            prod.addCategories(categ);
            productDAO.save(prod);
            return HttpStatus.ACCEPTED;
        } else {
            return HttpStatus.NOT_FOUND;
        }
    }

}