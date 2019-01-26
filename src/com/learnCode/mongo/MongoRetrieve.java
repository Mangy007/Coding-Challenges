package com.learnCode.mongo;

import java.util.*;

import org.bson.Document;

import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

public class MongoRetrieve {

	public static void main(String[] args) 
	{
		MongoClient client=new MongoClient();
		MongoDatabase db=client.getDatabase("mydb");
		System.out.println("Connected to Database");
		MongoCollection<Document> col=db.getCollection("faculty");
		System.out.println("Collection found");
		
		List<Document> docs=col.find().into(new ArrayList<Document>());
		for(Document doc:docs)
			{
				System.out.println(doc.get("fname"));
				System.out.println(doc);
				String set = doc.toJson();
				System.out.println("------");
				System.out.println(set);
				System.out.println("------");
			}
		
	}

}
