package com.learnCode.orient;

import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientEdge;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;

public class OrientTest
{
	public static void main(String[] args) 
	{
		OrientGraph graph= new OrientGraph("remote:localhost/test", "username", "password");
		
		try{
			graph.createVertexType("Person");
			graph.createVertexType("Address");
			graph.createVertexType("School");
		
			Vertex vPerson = graph.addVertex("class:Person");
			vPerson.setProperty("firstName", "John");
			vPerson.setProperty("lastName", "Smith");

			Vertex vAddress = graph.addVertex("class:Address");
			vAddress.setProperty("street", "Van Ness Ave.");
			vAddress.setProperty("city", "San Francisco");
			vAddress.setProperty("state", "California");
			
			Vertex vSchool = graph.addVertex("class:School");
			vSchool.setProperty("schoolname", "Pitts Modern School");
			vSchool.setProperty("board", "CBSE");
			vSchool.setProperty("type", "Private");
			
			OrientEdge eLives = graph.addEdge(null,vPerson, vAddress, "lives");
			OrientEdge eContain = graph.addEdge("class: contains", vAddress, vPerson, null);
			OrientEdge eStudy = graph.addEdge("class: studies", vPerson, vSchool, null);
			OrientEdge eHas = graph.addEdge(null, vSchool, vPerson, "has");
			
		}catch(Exception e)
		{
			graph.rollback();
		}
		finally 
		{
			graph.shutdown();
		}
	}

}
