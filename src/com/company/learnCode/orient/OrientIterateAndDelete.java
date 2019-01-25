package com.company.learnCode.orient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.orientechnologies.orient.core.db.record.OIdentifiable;
import com.orientechnologies.orient.core.record.impl.ODocument;
import com.orientechnologies.orient.core.sql.OCommandSQL;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;

public class OrientIterateAndDelete {

	public static void main(String[] args) {

		OrientGraph graph=new OrientGraph("remote:localhost/test", "username", "password");
		//iterate and delete
	/*	
		for(OIdentifiable id : new OSQLSynchQuery<ODocument>("SELECT FROM (TRAVERSE in() FROM (SELECT expand(in()) FROM v WHERE name='Rich'))"))	{
			
			String recordID = graph.getVertex(id).getId().toString();
			String query = "DELETE VERTEX "+recordID+"";
			graph.command(new OCommandSQL(query)).execute();
			
		}
	*/
		//iterate through child nodes
		
		List<String> getAllChild = new ArrayList<>();
		try {
			
			for(OIdentifiable id : new OSQLSynchQuery<ODocument>("SELECT FROM (TRAVERSE in() FROM (SELECT expand(in()) FROM v WHERE name='RichardSonSon'))"))	{
				
				String cid = graph.getVertex(id).getProperties().get("name").toString();
				getAllChild.add(cid);
			}
		}finally {
			
			graph.shutdown();
		}
		Iterator<String> itr = getAllChild.iterator();
		if(getAllChild.size() == 0) {
			System.out.println("Yo man You got it");
		}else{
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		}
	/*
		
		for(OIdentifiable id : new OSQLSynchQuery<ODocument>("SELECT FROM v WHERE name='Richard'"))	{
			
			String rid = graph.getVertex(id).getId().toString();
			System.out.println(rid);
		}
		*/
	}
}
