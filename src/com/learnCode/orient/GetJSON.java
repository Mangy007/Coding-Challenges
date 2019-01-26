package com.learnCode.orient;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.orientechnologies.orient.core.db.record.OIdentifiable;
import com.orientechnologies.orient.core.record.impl.ODocument;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;

public class GetJSON {
	
	 public static class Entry {

	      private String name;

	      public Entry(String name) {
	         this.name = name;
	      }

	      private List<Entry> children;

	      public void add(Entry node){
	         if (children == null)
	            children = new ArrayList<Entry>();
	         children.add(node);
	      }

	   }

	public static void main(String[] args)
	{
		OrientGraph graph=new OrientGraph("remote:localhost/test", "username", "password");
		
		try {
				String childID = "";
			
				for (OIdentifiable id : new OSQLSynchQuery<ODocument>("\r\n" + "select from v where name='RichardSon'")) {
					for (OIdentifiable cid : new OSQLSynchQuery<ODocument>("\r\n" + "\r\n" + 
							"SELECT expand(path) FROM (\r\n" + 
							"  SELECT shortestPath($from, $to) AS path \r\n" + 
							"  LET \r\n" + 
							"    $from = (SELECT FROM v WHERE name='Rich'), \r\n" + 
							"    $to = (SELECT FROM v WHERE @rid='"+graph.getVertex(id).getId()+"') \r\n" + 
							"  UNWIND path\r\n" + 
							")")) {
						
					System.out.print("-->"+graph.getVertex(cid).getProperties().get("name"));
					childID = graph.getVertex(cid).getId().toString();
					System.out.println(" -- "+childID);
				}
					System.out.println();
				}
		
			}finally {
				graph.shutdown();
			}
		
	}

}
