package com.learnCode.mongo;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoCAdrop {

	public static void main(String[] args) 
	{
		try {

			MongoClient client=new MongoClient();
			MongoDatabase db=client.getDatabase("mydb");
			System.out.println("Connected to database");
		
			MongoCollection<Document> col=db.getCollection("lecturer");
			System.out.println("Collection found successfully");
			
			col.drop();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
			
	}

}
