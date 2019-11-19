package com.jee.tp.shoppingchart.Controllers;

import com.jee.tp.shoppingchart.Models.Bill;
import com.jee.tp.shoppingchart.Models.Panier;
import com.jee.tp.shoppingchart.Models.Product;
import com.jee.tp.shoppingchart.Repositories.billRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/bill")
public class billController {

    @Autowired
    private final billRepository billRepos;

    public billController(billRepository billRepos) {
        this.billRepos = billRepos;
    }
    @GetMapping("/amounttopay")
    public double amountToPay(@PathVariable("id") ObjectId id)
    {
        Bill b1=billRepos.findBy_id(id);
        Panier panier=b1.getPanier();
        List<Product> lstProds=panier.getProducts();
        double amount=0;
        for (Product x:lstProds)
        {
            amount+=x.getPrice()*x.getQuantity();
        }
        return amount;



    }
}
