package com.company.learnCode.mongo;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class FetchDocumentWithCondition
{

	public static void main(String[] args)
	{
		MongoClient client=new MongoClient();
		/*MongoDatabase db=client.getDatabase("myTestDB");
		System.out.println("Connected to Database");
		MongoCollection<Document> col=db.getCollection("qPatternConversion");
		System.out.println("Collection found");
		
		List<Document> docs = col.find(eq( "originalQuestion.0.typeID", "Kindly ID" )).into(new ArrayList<Document>());
		
		JSONArray result = new JSONArray();
		result.put(docs);
		System.out.println(result.getJSONArray(0).toString(4));*/
		List<String> list = new ArrayList<>();
		list.add("Kindly ID");
		DB database = client.getDB("myTestDB");
		DBCollection collection = database.getCollection("qPatternConversion");
		BasicDBObject query = new BasicDBObject();
		query.put("originalQuestion.0.typeID", new BasicDBObject("$in", list));
		DBCursor document = collection.find(query);
		System.out.println(document.size());
		while(document.hasNext()) {
			//
			DBObject currentDoc = document.next();
			JSONObject obj = new JSONObject(JSON.serialize(currentDoc));
			String actionData = obj.toString(4);
			System.out.println(actionData);
		}
		client.close();
	}

}
