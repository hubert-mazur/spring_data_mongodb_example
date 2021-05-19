package com.fis.zti.example.examples.example2;

import com.fis.zti.example.invoice.Invoice;
import com.mongodb.client.MongoClients;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Date;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

public class Example2 {
    public Example2() {
        /*
         * Example 2.
         * XML based config and MongoTemplate
         */

        System.out.println("Example 2:");

        MongoTemplate mongoTemplate = new MongoTemplate(MongoClients.create(), "ZTI");

        // drop collection in DB
        mongoTemplate.dropCollection(Invoice.class);

        // insert some random data
        mongoTemplate.insert(new Invoice(new Date(), 666.6));
        mongoTemplate.insert(new Invoice(new Date(), 100.88));

        List<Invoice> invoices =  mongoTemplate.findAll(Invoice.class);
        for (var i:invoices) {
            System.out.println(i);
        }

        // get one Invoice
        List<Invoice> inv = mongoTemplate.find(new Query(where("net").gt(100.0)), Invoice.class);

        System.out.println("List of documents, where net was greater than 100");
        for (var i:inv) {
            System.out.println(i);
        }
    }
}
