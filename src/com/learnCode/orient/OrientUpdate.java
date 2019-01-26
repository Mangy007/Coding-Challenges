package com.learnCode.orient;

import com.orientechnologies.orient.core.db.record.OIdentifiable;
import com.orientechnologies.orient.core.record.impl.ODocument;
import com.orientechnologies.orient.core.sql.OCommandSQL;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;

public class OrientUpdate {

	public static void main(String[] args) 
	{
		OrientGraph graph=new OrientGraph("remote:localhost/test", "username", "password");
	
		for (OIdentifiable id : new OSQLSynchQuery<ODocument>("\r\n" + 
				"traverse outE() from (select expand(outE()) from v where age='9')")) {
			  System.out.println(" --> "+graph.getEdge(id));
		}
		System.out.println();
//		String query = "delete edge where @rid in (select outE() from v where age='9')";
//		graph.command(new OCommandSQL(query)).execute();
		
		for (OIdentifiable id : new OSQLSynchQuery<ODocument>("select from v where name='RichardDaughter'")) {
			for (OIdentifiable rid : new OSQLSynchQuery<ODocument>("select from v where age='9'")) {
					
				Vertex pid = graph.getVertex(id);
				Vertex cid = graph.getVertex(rid);
				
				Edge linkEdge = cid.addEdge("E", pid);
				graph.commit();
			}
		}
	}
}
