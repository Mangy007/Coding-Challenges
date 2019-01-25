package com.company.learnCode.mongo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoCAA {

	public static void main(String[] args)
	{
		try {
			
			MongoClient client=new MongoClient();
			MongoDatabase db=client.getDatabase("mydb");
			System.out.println("Connected to database");
			
			MongoCollection<Document> col=db.getCollection("Staff");
			
			Document doc1=new Document("sname", "John").append("sno", "451").append("work", "Sweeper");
			col.insertOne(doc1);
			System.out.println("Document Inserted succussfully");
			
			Document doc2=new Document("sname", "Marie").append("sno", "696").append("work","Maid");
			col.insertOne(doc2);
			System.out.println("Document Inserted succussfully");
			
			Document doc3=new Document("sname", "Smith").append("sno", "156").append("work", "Gardener");
			col.insertOne(doc3);
			System.out.println("Document Inserted succussfully");
			
			List<Document> docs=col.find().into(new ArrayList<Document>());
			for(Document doc:docs)
				System.out.println(doc);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}
