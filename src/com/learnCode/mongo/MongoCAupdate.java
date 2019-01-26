package com.learnCode.mongo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoCAupdate {

	public static void main(String[] args)
	{
		try {
			
			MongoClient client=new MongoClient();
			MongoDatabase db=client.getDatabase("mydb");
			System.out.println("Connected to database");
			
			MongoCollection<Document> col=db.getCollection("lecturer");
			System.out.println("Collection found successfully");
			
			Document doc=new Document();
			doc.append("$set", new Document().append("dept", "Villain"));
			
			Document search=new Document();
			search.append("lname", "Moriarty");
			col.updateOne(search, doc);
			
			Document mydoc=new Document("$set", new Document("dept", "Private Detective"));
			Document search1=new Document("lname", "Sherlock");
			col.updateOne(search1, mydoc);
			
			List<Document> docs=col.find().into(new ArrayList<Document>());
			for(Document d:docs)
				System.out.println(d);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
