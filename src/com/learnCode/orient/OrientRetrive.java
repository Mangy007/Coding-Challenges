package com.learnCode.orient;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONString;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.orientechnologies.orient.core.db.record.OIdentifiable;
import com.orientechnologies.orient.core.record.impl.ODocument;
import com.orientechnologies.orient.core.sql.OCommandSQL;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;

public class OrientRetrive {

	public static void main(String[] args) 
	{
		OrientGraph graph=new OrientGraph("remote:localhost/test", "username", "password");
		
		for (OIdentifiable id : new OSQLSynchQuery<ODocument>("\r\n" + "traverse in from v")) {
	
			System.out.println(" --> "+graph.getVertex(id).getProperties());
			System.out.println();
			System.out.println(graph.getVertex(id).getId());
			//get JSON of vertex
			Gson gson= new Gson();
			String json= gson.toJson(graph.getVertex(id).getProperties());
			System.out.println("json--->"+json);
			System.out.println();
			Gson gsonO= new GsonBuilder().setPrettyPrinting().create();
			String string=gsonO.toJson(graph.getVertex(id).getProperties());
			System.out.println("prettyJson--->"+string); 
			
		
		}
		System.out.println();	
		//for displaying adjacent parent or child node
				for (OIdentifiable id : new OSQLSynchQuery<ODocument>("\r\n" + 
						"select expand(in()) from v where name='Richard'")) {
					  System.out.println(" --> "+graph.getVertex(id).getProperties().get("name"));
					  
				}
		graph.command(new OCommandSQL("UPDATE SonGranddaughter SET name = 'RichardSonDaughter' WHERE name='Lucas'")).execute();
		System.out.println();
		
		for (OIdentifiable id : new OSQLSynchQuery<ODocument>("\r\n" + "traverse in from v")) {
			
			System.out.print(" --> "+graph.getVertex(id).getProperties().get("name"));
			System.out.println("___"+graph.getVertex(id).toString());
			//get JSON of vertex
			Gson gson= new Gson();
			String json= gson.toJson(graph.getVertex(id).getProperties());
			System.out.println(json);
			
			
	}
		graph.shutdown();
	}
}
