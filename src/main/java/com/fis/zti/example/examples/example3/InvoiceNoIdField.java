package com.fis.zti.example.examples.example3;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document
public class InvoiceNoIdField {
    @Field
    Date date;
    @Field
    Double net;

    public InvoiceNoIdField(Date date, Double net) {
        this.date = date;
        this.net = net;
    }

    public InvoiceNoIdField() {
    }

    public Date getDate() {
        return date;
    }

    public Double getNet() {
        return net;
    }
}
