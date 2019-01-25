package com.company.learnCode.orient;

import com.orientechnologies.orient.core.db.record.OIdentifiable;
import com.orientechnologies.orient.core.record.impl.ODocument;
import com.orientechnologies.orient.core.sql.OCommandSQL;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;

public class OrientDeleteParChild {

	public static void main(String[] args) 
	{
		OrientGraph graph=new OrientGraph("remote:localhost/test", "username", "password");

		//for delete node
//		for (OIdentifiable id : new OSQLSynchQuery<ODocument>("\r\n" + 
//				"traverse in() from (select expand(in()) from v where name='RichardDaughter')")) {
//			  graph.command(new OCommandSQL("DELETE VERTEX "+graph.getVertex(id).getId())).execute();
//		}
//		graph.command(new OCommandSQL("delete vertex Daughter where name='RichardDaughter'")).execute();
//		System.out.println();
//		
		
		
		//for result output
		for (OIdentifiable id : new OSQLSynchQuery<ODocument>("\r\n" + 
					"traverse in() from (select expand(in()) from v where name='Rich')")) {
				  System.out.print(" --> "+graph.getVertex(id).getProperties().get("name"));
			}
		System.out.println();
		System.out.println();
		//for child node
		for (OIdentifiable id : new OSQLSynchQuery<ODocument>("\r\n" + 
				"select expand(in()) from v where name='Richard'")) {
			  System.out.print(" --> "+graph.getVertex(id).getProperties().get("name"));
		}
		
	}

}
