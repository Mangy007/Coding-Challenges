package com.learnCode.mongo;

import java.util.*;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoCreate {

	public static void main(String[] args)
	{
		MongoClient client=new MongoClient();
		
		try 
		{	
		MongoDatabase db=client.getDatabase("mydb");
		System.out.println("Connected to database");
		MongoCollection<Document> col=db.getCollection("faculty");
		System.out.println("Collection made");
		
		Document doc1=new Document("fname", "Raj");
		doc1.append("fno", 201).append("job", "Sweeper");
		col.insertOne(doc1);
		System.out.println("Data inserted");
		
		Document doc2=new Document("fname", "Sheldon");
		doc2.append("fno", 202).append("job", "Scientist");
		col.insertOne(doc2);
		System.out.println("Data Inserted");
		
		Document doc3=new Document("fname", "Penny");
		doc3.append("fno", 209).append("job","Bartender");
		col.insertOne(doc3);
		System.out.println("Data Inserted");
		
		Document docu=new Document();
		docu.append("fno", 201);
		
		List<Document> docs=col.find().into(new ArrayList<Document>());
		for(Document doc:docs)
			System.out.println(doc);
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}