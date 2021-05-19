package com.fis.zti.example.examples.example3;

import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

public class InvoiceMongoId {
    @MongoId(FieldType.OBJECT_ID)
    String id;
    @Field
    Date date;
    @Field
    Double net;

    public InvoiceMongoId(Date date, Double net) {
        this.date = date;
        this.net = net;
    }

    public InvoiceMongoId() {
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
