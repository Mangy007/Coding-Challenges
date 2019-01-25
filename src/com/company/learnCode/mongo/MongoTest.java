package com.company.learnCode.mongo;

import java.util.Date;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoTest {

	public static void main(String[] args) {

			MongoClient client=new MongoClient("localhost",27017);
			@SuppressWarnings("deprecation")
			DB db=client.getDB("mydb");
			System.out.println("Connected to database");
			
			DBCollection col=db.getCollection("student");
			System.out.println("Collection created successfully");
			
			BasicDBObject doc1=new BasicDBObject();
			doc1.put("rollno", 1);
			doc1.put("stname", "Kavya");
			doc1.put("branch", "Science");
			doc1.put("class", 10);
			doc1.put("createddate", new Date());
			col.insert(doc1);
			System.out.println("Document Inserted...");
			
			BasicDBObject doc2=new BasicDBObject();
			doc2.put("rollno", 2);
			doc2.put("stname", "Divya");
			doc2.put("branch", "Commerce");
			doc2.put("class", 11);
			col.insert(doc2);
			System.out.println("Document Inserted...");
			
			BasicDBObject doc3= new BasicDBObject();
			doc3.put("rollno", 3);
			doc3.put("stname", "Ritika");
			doc3.put("branch", "Arts");
			doc3.put("class", 12);
			col.insert(doc3);
			System.out.println("Document Inserted...");
			
			BasicDBObject doc4= new BasicDBObject();
			doc4.put("rollno", 15);
			doc4.put("stname", "Alex");
			doc4.put("branch", "Science");
			doc4.put("class", 11);
			doc4.put("joiningdate", new Date());
			col.insert(doc4);
			System.out.println("Document Inserted...");
	
	}

}
