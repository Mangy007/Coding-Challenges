package com.company.learnCode.mongo;

import java.util.*;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDelete {

	public static void main(String[] args) 
	{
		MongoClient client=new MongoClient();
		MongoDatabase db=client.getDatabase("mydb");
		System.out.println("Database Connected");
		MongoCollection<Document> col=db.getCollection("faculty");
		System.out.println("Collection found");
		
		Document doc=new Document();
		doc.append("fname", "Penny");
		col.deleteOne(doc);
		
		Document doc1=new Document();
		doc1.append("fname", "Leonard").append("fno", 209).append("job", "Researcher");
		col.insertOne(doc1);
		
		List<Document> docs=col.find().into(new ArrayList<Document>());
		for(Document docum:docs)
			System.out.println(docum);
		
	}

}
