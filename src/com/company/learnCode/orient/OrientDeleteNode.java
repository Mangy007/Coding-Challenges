package com.company.learnCode.orient;

import java.util.List;

import org.bson.Document;

import com.google.gson.Gson;
import com.orientechnologies.orient.core.db.record.OIdentifiable;
import com.orientechnologies.orient.core.record.impl.ODocument;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;

public class OrientDeleteNode {

	public static void main(String[] args)
	{
		OrientGraph graph=new OrientGraph("remote:localhost/test", "username", "password");
		
//		for (OIdentifiable id : new OSQLSynchQuery<ODocument>("\r\n" + 
//				"traverse out() from (delete vertex Son where name='RichardSon')")) {
//			  System.out.print(" --> "+graph.getVertex(id).getProperties().get("name"));
//			  
//			}
		
//		List<ODocument> result = graph.getRawGraph().query(
//                new OSQLSynchQuery("traverse * from v"));
//		System.out.println(result);
//        
//		for(ODocument doc:result)
//		{
//			System.out.println("json doc = " + doc.toJSON());
//		}
		
		
		//JSON of child node
		String childNode="";
		int i=0;
		for (OIdentifiable id : new OSQLSynchQuery<ODocument>("\r\n" + 
				"select expand(in()) from v where name='RichardDaughter'")) {
			  
			 // child = (String) graph.getVertex(id).getProperties().get("name");
			  //child += (String) graph.getVertex(id).getProperties().get("age");
				if(i>0)
					childNode += ",";
			  Gson gson= new Gson();
			  String json= gson.toJson(graph.getVertex(id).getProperties());
			  System.out.println(json);
			  childNode += json;
			  i++;
	}
		System.out.println(childNode);
//		String[] arr = childNode.split(",");
//		for(String s:arr)
//			System.out.println(s);

}
}
