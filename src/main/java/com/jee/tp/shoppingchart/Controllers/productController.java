package com.jee.tp.shoppingchart.Controllers;

import com.jee.tp.shoppingchart.Models.Product;
import com.jee.tp.shoppingchart.Repositories.productRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class productController {
    @Autowired
    private final productRepository productRepos;

    public productController(productRepository productRepos) {
        this.productRepos = productRepos;
    }

    //@RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public List<Product> getAllProduct() {
        return productRepos.findAll();
    }

    //@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") ObjectId id) {
        return productRepos.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyProductById(@PathVariable("id") ObjectId id, @Valid @RequestBody Product product) {
        product.set_id(id);
        productRepos.save(product);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Product createProduct(@Valid @RequestBody Product product) {
        product.set_id(ObjectId.get());
        productRepos.save(product);
        return product;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable ObjectId id) {
        productRepos.delete(productRepos.findBy_id(id));
    }
}
