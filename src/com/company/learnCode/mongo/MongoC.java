package com.company.learnCode.mongo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoC {

	public static void main(String[] args) 
	{
		try {

			MongoClient client=new MongoClient();
			MongoDatabase db=client.getDatabase("mydb");
			System.out.println("Connected to database");
			
			MongoCollection<Document> col=db.getCollection("Student");
			System.out.println("Collection created");
			
			Document doc1=new Document("stname", "Kumar");
			doc1.append("rollno", "16").append("branch", "Science").append("School","Pitts Modern School");
			col.insertOne(doc1);
			System.out.println("Document Inserted");
			
			Document doc2=new Document();
			doc2.append("stname", "Kumar Mangalam").append("rollno", "48").append("branch", "Electrical Engineering").append("dob", "11-Feb-1999").append("college", "CIEM");
			col.insertOne(doc2);
			System.out.println("Document Inserted");
			
			Document doc3=new Document("stname", "Mangy").append("rollno", "12").append("branch", "Commerce");
			col.insertOne(doc3);
			System.out.println("Document Inserted");
			
			Document doc4=new Document().append("stname", "Mangu").append("rollno", "18").append("dob", "11/12/1999").append("branch","Arts");
			col.insertOne(doc4);
			System.out.println("Document Inserted");
			
			List<Document> docs=col.find().into(new ArrayList<Document>());
			for(Document doc:docs)
				System.out.println(doc);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
