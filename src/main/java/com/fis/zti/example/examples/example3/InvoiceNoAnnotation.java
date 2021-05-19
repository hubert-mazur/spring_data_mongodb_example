package com.fis.zti.example.examples.example3;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

public class InvoiceNoAnnotation {
    String id;
    @Field
    Date date;
    @Field
    Double net;

    public InvoiceNoAnnotation(Date date, Double net) {
        this.date = date;
        this.net = net;
    }

    public InvoiceNoAnnotation() {
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
