package com.company.learnCode.mongo;

import java.util.*;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDrop {

	public static void main(String[] args) 
	{
		MongoClient client=new MongoClient();
		MongoDatabase db=client.getDatabase("mydb");
		System.out.println("Database Connected");
		
		MongoCollection<Document> col=db.getCollection("faculty");
		System.out.println("Collection found");
		
		col.drop();
		System.out.println("Collection droped");
		
		List<Document> docs=col.find().into(new ArrayList<Document>());
		for(Document doc:docs)
			System.out.println(doc);
		
	}

}
