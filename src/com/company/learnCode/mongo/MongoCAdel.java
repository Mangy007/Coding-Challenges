package com.company.learnCode.mongo;

import java.util.LinkedList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoCAdel {

	public static void main(String[] args)
	{
		try {
			MongoClient client=new MongoClient();
			MongoDatabase db=client.getDatabase("mydb");
			System.out.println("Connected to database");
			
			MongoCollection<Document> col=db.getCollection("lecturer");
			System.out.println("Connected to collection");
			
			Document doc=new Document().append("lname", "Watson");
			col.deleteOne(doc);
			
			List<Document> docs=col.find().into(new LinkedList<Document>());
			for(Document docum:docs)
				System.out.println(docum);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
