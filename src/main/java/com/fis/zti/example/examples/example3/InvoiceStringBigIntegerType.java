package com.fis.zti.example.examples.example3;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigInteger;
import java.util.Date;

@Document
public class InvoiceStringBigIntegerType {
    BigInteger id;
    @Field
    Date date;
    @Field
    Double net;

    public InvoiceStringBigIntegerType(Date date, Double net) {
        this.date = date;
        this.net = net;
    }

    public InvoiceStringBigIntegerType() {
    }

    public BigInteger getId() {
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
