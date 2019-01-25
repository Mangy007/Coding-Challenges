package com.company.learnCode.orient;

import com.orientechnologies.orient.core.db.record.OIdentifiable;
import com.orientechnologies.orient.core.record.impl.ODocument;
import com.orientechnologies.orient.core.sql.OCommandSQL;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;

public class OrientHierarchy1 {

	public static void main(String[] args) 
	{
OrientGraph graph=new OrientGraph("remote:localhost/test", "username", "password");
		
		try {
				Vertex v1=graph.addVertex("class:Son");
				v1.setProperty("name", "RichardSon");
				v1.setProperty("age", 35);
				
				Vertex v2=graph.getVertex("class:Daughter");
				System.out.println("start");
				System.out.println(graph.getVertices("Son.name", "RichardSon"));
				System.out.println(v2);
				System.out.println("end");
				
		}catch(Exception e)
		{
			graph.rollback();
		}
		finally {
			graph.shutdown();
		}
		
		
	}

}
