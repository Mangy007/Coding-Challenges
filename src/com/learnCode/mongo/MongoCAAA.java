package com.learnCode.mongo;

import java.util.List;
import java.util.Scanner;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoCAAA {
	
	public static Scanner in=new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		System.out.println("Enter no. of members you want to include:");
		int n=in.nextInt();
		
		try {
			MongoClient client=new MongoClient();
			MongoDatabase db=client.getDatabase("mydb");
			System.out.println("Database created");
			
			MongoCollection<Document> col=db.getCollection("Members");
			System.out.println("Collection created");
			
			Document[] doc=new Document[n];
			
			for(int i=0;i<n;i++)
			{
				doc[i]=new Document("mname", "Dumbledore").append("type", "senior").append("dept","Principal");
				col.insertOne(doc[i]);
			}
			
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
		
	}

}
