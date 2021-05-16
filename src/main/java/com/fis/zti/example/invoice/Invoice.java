package com.fis.zti.example.invoice;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "my_collection_name")
public class Invoice {
    @Id
    String id;
    @Field
    Date date;
    @Field
    Double net;

    public Invoice(Date date, Double net) {
        this.date = date;
        this.net = net;
    }

    public Invoice() {
    }

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Double getNet() {
        return net;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", net=" + net +
                '}';
    }
}
