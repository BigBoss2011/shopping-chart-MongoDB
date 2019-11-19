package com.jee.tp.shoppingchart.Repositories;

import com.jee.tp.shoppingchart.Models.Panier;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface panierRepository extends MongoRepository<Panier, Long> {
    Panier findBy_id(ObjectId _id);

}
