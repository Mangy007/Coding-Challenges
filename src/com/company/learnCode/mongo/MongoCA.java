package com.company.learnCode.mongo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoCA {

	public static void main(String[] args) 
	{
		try {
			MongoClient client=new MongoClient();
			MongoDatabase db=client.getDatabase("mydb");
			System.out.println("Connected to Database");
			
			MongoCollection<Document> col=db.getCollection("lecturer");
			System.out.println("Collection made successfully");
			
			Document doc1=new Document();
			doc1.append("lname", "Sherlock").append("lno", "I-201").append("dept", "Investigation");
			col.insertOne(doc1);
			System.out.println("Document inserted successfully");
			
			Document doc2=new Document();
			doc2.append("lname", "Watson").append("lno", "D-198").append("dept", "Doctor");
			col.insertOne(doc2);
			System.out.println("Document inserted successfully");
			
			Document doc3=new Document();
			doc3.append("lname", "Moriarty").append("lno", "T-775").append("dept", "Trick Master");
			col.insertOne(doc3);
			System.out.println("Document inserted successfully");
			
			List<Document> docs=col.find().into(new ArrayList<Document>());
			for(Document doc:docs)
				System.out.println(doc);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
