package com.jee.tp.shoppingchart.Repositories;

import com.jee.tp.shoppingchart.Models.Bill;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface billRepository extends MongoRepository<Bill, ObjectId> {
    Bill findBy_id(ObjectId _id);

}
