package com.learnCode.orient;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;

public class OrientHierarchy
{
	public static void main(String[] args) 
	{
		OrientGraph graph=new OrientGraph("remote:localhost/test", "username", "password");
		
		try {
				Vertex v1=graph.addVertex("class:GrandFather");
				v1.setProperty("name", "Rich");
				v1.setProperty("age", 85);
				
				Vertex v2=graph.addVertex("class:Father");
				v2.setProperty("name", "Richard");
				v2.setProperty("age", 60);
				
				Vertex v3=graph.addVertex("class:Son");
				v3.setProperty("name", "RichardSon");
				v3.setProperty("age", 35);
				
				Vertex v4=graph.addVertex("class:Daughter");
				v4.setProperty("name", "RichardDaughter");
				v4.setProperty("age", 33);
				
				Vertex v5=graph.addVertex("class:SonGrandson");
				v5.setProperty("name", "RichardSonSon");
				v5.setProperty("age", 7);
				
				Vertex v6=graph.addVertex("class:SonGranddaughter");
				v6.setProperty("name", "RichardSonDaughter");
				v6.setProperty("age", 5);
				
				Vertex v7=graph.addVertex("class:DaughterGrandson");
				v7.setProperty("name", "RichardDaughterSon");
				v7.setProperty("age", 5);
				
				Vertex v8=graph.addVertex("class:DaughterGranddaughter");
				v8.setProperty("name", "RichardDaughterDaughter");
				v8.setProperty("age", 6);
				
				Vertex v9=graph.addVertex("class:DaughterGrandson1");
				v9.setProperty("name", "RichardSonSon");
				v9.setProperty("age", 9);
				
				Edge e1=graph.addEdge(null, v8, v4, "E");
				Edge e2=graph.addEdge(null, v7, v4, "E");
				Edge e3=graph.addEdge(null, v6, v3, "E");
				Edge e4=graph.addEdge(null, v5, v3, "E");
				Edge e5=graph.addEdge("class: E", v4, v2, null);
				Edge e6=graph.addEdge("class: E", v3, v2, null);
				Edge e7=graph.addEdge("class: E", v2, v1, null);
				Edge e8=graph.addEdge(null, v9, v4, "E");
				
		}catch(Exception e)
		{
			graph.rollback();
		}
		finally {
			graph.shutdown();
		}
	}

}
