package tpu.db.demo.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tpu.db.demo.DAO.CategoriesDAO;
import tpu.db.demo.models.Categories;
import tpu.db.demo.response.CategoriesResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



@RestController
@Api(value = "Контроллер категорий", description = "Rest API for categories", tags = "Контроллер категорий")
public class CategoriesController
{
    @Autowired
    CategoriesDAO categoriesDAO;


    @RequestMapping(value = "/categories/add", method = RequestMethod.POST)
    @ApiOperation(value = "Возврат всех категорий", response = HttpStatus.class)
    public HttpStatus addCategories(@RequestParam(required = false) String Type, Model model)
    {
        Categories categ = new Categories();
        categ.setType(Type);
        categoriesDAO.save(categ);
        return HttpStatus.ACCEPTED;
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Возврат всех категорий", response = JSONPObject.class)
    public List<CategoriesResponse> getAllCategories(Model model)
    {
        List<Categories> categoriesAll = new ArrayList<Categories>();

        categoriesDAO.findAll().forEach(categoriesAll::add);

        return categoriesAll.stream().map(categ -> new CategoriesResponse(categ.getId(), categ.getType())).
                collect(Collectors.toList());
    }
}
