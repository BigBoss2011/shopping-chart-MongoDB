package com.jee.tp.shoppingchart.Models;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

//@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Product {
    @Id
    public ObjectId _id;
    @NonNull
    private String product_name;
    private String type;
    @NonNull
    private double price;
    @Builder.Default
    private int stock=1;
    @NonNull
    private int quantity;//sold quantity
    // ObjectId needs to be converted to string
    public String get_id() { return _id.toHexString(); }
    public void set_id(ObjectId _id) { this._id = _id; }

    public Product(String product_name, String type, double price, int stock, int quantity) {
        this.product_name = product_name;
        this.type = type;
        this.price = price;
        this.stock = stock;
        this.quantity = quantity;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
