package com.fis.zti.example.examples.example4;


import com.fis.zti.example.invoice.Invoice;
import com.mongodb.client.MongoClients;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Example4 {

    public Example4() {
        System.out.println("Example 4:");

        Invoice invoice = new Invoice(new Date(), 201.50);
        Invoice invoice2 = new Invoice(new Date(), 371.50);

        MongoOperations mongoOperations = new MongoTemplate(MongoClients.create(), "ZTI");

        mongoOperations.dropCollection(invoice.getClass());

//        mongoOperations.save(invoice);

        List<Invoice> list = new ArrayList<>();
        list.add(invoice);
        list.add(invoice2);

        // We can insert many documents at once, by passing a collection
        mongoOperations.insert(list, Invoice.class);

        // lets see what kind of documents we already have in DB
        System.out.println("Before incrementing net price");
        List<Invoice> listOfInvoices = mongoOperations.findAll(Invoice.class);

        for (Invoice i:listOfInvoices) {
            System.out.println(i);
        }

        // Example usage of $inc, lets increment net price in invoice
        mongoOperations.updateFirst(new Query(Criteria.where("net").lt(250)), new Update().inc("net", 50.0), Invoice.class);

        listOfInvoices = mongoOperations.findAll(Invoice.class);
        System.out.println("After incrementing net price");
        for (Invoice i:listOfInvoices) {
            System.out.println(i);
        }

        // Waiting to notice time difference
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Use $currentDate to change the date of given invoice
        mongoOperations.updateFirst(new Query(Criteria.where("id").is(invoice2.getId())), new Update().currentDate("date"), Invoice.class);

        listOfInvoices = mongoOperations.findAll(Invoice.class);
        System.out.println("After changing the date to current");
        for (Invoice i:listOfInvoices) {
            System.out.println(i);
        }


    }


}
