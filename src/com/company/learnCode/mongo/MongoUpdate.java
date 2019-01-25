package com.company.learnCode.mongo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoUpdate {

	public static void main(String[] args) 
	{
		MongoClient client=new MongoClient();
		MongoDatabase db=client.getDatabase("mydb");
		System.out.println("Connected to database");
		MongoCollection<Document> col=db.getCollection("faculty");
		
		Document newDoc=new Document();
		newDoc.append("$set", new Document().append("job", "Junior Scientist"));
		Document search= new Document().append("fname", "Raj");
		col.updateMany(search, newDoc);
		
		Document newD=new Document();
		newD.append("$set", new Document("fno", 205));
		Document search1=new Document().append("fname", "Sheldon");
		col.updateMany(search1, newD);
		
		List<Document> docs=col.find().into(new ArrayList<Document>());
		for(Document doc:docs)
			System.out.println(doc);
	}

}
