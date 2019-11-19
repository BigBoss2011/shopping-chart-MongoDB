package com.jee.tp.shoppingchart.Controllers;

import com.jee.tp.shoppingchart.Models.Panier;
import com.jee.tp.shoppingchart.Models.Product;
import com.jee.tp.shoppingchart.Repositories.panierRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/panier")
public class panierController {

    @Autowired
    private final panierRepository panierRepos;

    public panierController(panierRepository panierRepos) {
        this.panierRepos = panierRepos;
    }

    @PostMapping("/create")
    public Panier createNewPanier(@Valid @RequestBody Panier panier)
    {
        panier.set_id(ObjectId.get());
        panierRepos.save(panier);
        return panier;
    }
    @PostMapping("/addproduct/{id}")
    public Product addProduct(@PathVariable("id") ObjectId id, @Valid @RequestBody Product product)
    {
        Panier p1=panierRepos.findBy_id(id);
        p1.getProducts().add(product);
        return product;
    }
}
