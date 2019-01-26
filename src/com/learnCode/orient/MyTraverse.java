package com.learnCode.orient;

import com.google.gson.Gson;
import com.orientechnologies.orient.core.db.record.OIdentifiable;
import com.orientechnologies.orient.core.record.impl.ODocument;
import com.orientechnologies.orient.core.sql.OCommandSQL;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;

public class MyTraverse {

	public static void main(String[] args) 
	{
		
		OrientGraph graph=new OrientGraph("remote:localhost/test", "username", "password");
		String cid="";
		System.out.println(" --> "+graph.getRawGraph().query(new OSQLSynchQuery("select @rid from v where name='RichardSonDaughter'")));
		
		for (OIdentifiable id : new OSQLSynchQuery<ODocument>("\r\n" + 
				"select from v where name='Rich'")) {
			cid=""+ graph.getVertex(id).getId();
			System.out.println("id : "+id);
		}
		System.out.println("cid: "+cid);
		
		// change class name
		/*String query2 = "ALTER CLASS currentClass NAME newClass";
		graph.command(new OCommandSQL(query2)).execute();*/
		
		for (OIdentifiable id : new OSQLSynchQuery<ODocument>("\r\n" + 
				"select expand(in()) from v where @rid='"+cid+"'")) {
			cid="";
			  System.out.print(" --> "+graph.getVertex(id).getProperties().get("name"));
			  cid += graph.getVertex(id).getId();
			  
		}
		System.out.println();
		for (OIdentifiable id : new OSQLSynchQuery<ODocument>("\r\n" + 
				"traverse in() from (select expand(in()) from v where name='RichardSon')")) {
			  System.out.print(" --> "+graph.getVertex(id).getProperties().get("name"));
			 
			  Gson gson= new Gson();
			  String json= gson.toJson(graph.getVertex(id).getProperties());
			  System.out.println(json);
			  
			}
		
		graph.shutdown();
	}

}
