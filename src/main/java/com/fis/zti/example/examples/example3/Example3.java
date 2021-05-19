package com.fis.zti.example.examples.example3;

import com.fis.zti.example.invoice.Invoice;
import com.mongodb.client.MongoClients;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Date;
public class Example3 {

    public Example3() {
        System.out.println("Example 3:");

        Invoice invoice = new Invoice(new Date(), 100.6);
        InvoiceNoAnnotation invoiceNoAnnotation = new InvoiceNoAnnotation(new Date(), 200.5);
        InvoiceStringBigIntegerType invoiceStringBigIntegerType = new InvoiceStringBigIntegerType(new Date(), 300.0);
        InvoiceNoIdField invoiceNoIdField = new InvoiceNoIdField(new Date(), 400.5);
        InvoiceMongoId invoiceMongoId = new InvoiceMongoId(new Date(), 500.5);

        System.out.println("Before pushing to database: ");
        System.out.println("Invoice class -> ObjectId: " + invoice.hashCode() + ", id: " + invoice.getId());
        System.out.println("Invoice class -> ObjectId: " + invoiceNoAnnotation.hashCode() + ", id: " + invoiceNoAnnotation.getId());
        System.out.println("Invoice class -> ObjectId: " + invoiceStringBigIntegerType.hashCode() + ", id: " + invoiceStringBigIntegerType.getId());
        System.out.println("Invoice class -> ObjectId: " + invoiceNoIdField.hashCode() + ", id: " + null);
        System.out.println("Invoice class -> ObjectId: " + invoiceMongoId.hashCode() + ", id: " + invoiceMongoId.getId());

        MongoOperations mongoTemplate = new MongoTemplate(MongoClients.create(), "ZTI");


        mongoTemplate.dropCollection(Invoice.class);
        mongoTemplate.dropCollection(InvoiceNoAnnotation.class);
        mongoTemplate.dropCollection(InvoiceStringBigIntegerType.class);
        mongoTemplate.dropCollection(InvoiceNoIdField.class);

        mongoTemplate.save(invoice);
        mongoTemplate.save(invoiceNoAnnotation);
        mongoTemplate.save(invoiceStringBigIntegerType);
        mongoTemplate.save(invoiceNoIdField);
        mongoTemplate.save(invoiceMongoId);

        System.out.println("After pushing to database: ");
        System.out.println("Invoice class -> ObjectId: " + invoice.hashCode() + ", id: " + invoice.getId());
        System.out.println("Invoice class -> ObjectId: " + invoiceNoAnnotation.hashCode() + ", id: " + invoiceNoAnnotation.getId());
        System.out.println("Invoice class -> ObjectId: " + invoiceStringBigIntegerType.hashCode() + ", id: " + invoiceStringBigIntegerType.getId());
        System.out.println("Invoice class -> ObjectId: " + invoiceNoIdField.hashCode() + ", id: " + null);
        System.out.println("Invoice class -> ObjectId: " + invoiceMongoId.hashCode() + ", id: " + invoiceMongoId.getId());
        // Exception
//        mongoTemplate.remove(invoiceNoIdField);


        // Try to read some data
        Invoice readData = mongoTemplate.findById(invoice.getId(), Invoice.class);
        System.out.println("From database: " + readData);

        // Compare results with MongoDB  shell
    }

}
