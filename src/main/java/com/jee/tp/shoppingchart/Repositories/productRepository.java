package com.jee.tp.shoppingchart.Repositories;

import com.jee.tp.shoppingchart.Models.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepository extends MongoRepository<Product, String> {
    Product findBy_id(ObjectId _id);

}
