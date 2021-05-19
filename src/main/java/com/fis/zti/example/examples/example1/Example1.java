package com.fis.zti.example.examples.example1;

import com.fis.zti.example.config.AppConfig;
import com.fis.zti.example.invoice.Invoice;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Date;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

public class Example1 {

    public Example1() {
        /*
         * Example 1.
         * App config and MongoTemplate
         */

        System.out.println("Example 1:");

        AppConfig appConfig = new AppConfig();
        MongoTemplate mongoTemplate = appConfig.mongoTemplate();

        // drop collection in DB
        mongoTemplate.dropCollection(Invoice.class);

        // insert some random data
        mongoTemplate.insert(new Invoice(new Date(), 50.1));
        mongoTemplate.insert(new Invoice(new Date(), 522.1));

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
