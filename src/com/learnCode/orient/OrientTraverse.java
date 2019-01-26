package com.learnCode.orient;

import java.util.List;

import org.codehaus.jettison.json.JSONObject;

import com.orientechnologies.orient.core.db.record.OIdentifiable;
import com.orientechnologies.orient.core.record.impl.ODocument;
import com.orientechnologies.orient.core.sql.OCommandSQL;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;

public class OrientTraverse {

	public static void main(String[] args) 
	{
		
		OrientGraph graph=new OrientGraph("remote:localhost/test", "username", "password");
		try {
		
		
		for (OIdentifiable id : new OSQLSynchQuery<ODocument>("\r\n" + 
				"traverse out() from (select expand(out()) from v where name='RichardSonDaughter')")) {
			  System.out.print(" --> "+graph.getVertex(id).getProperties().get("name"));
			  
			}
		System.out.println();
		for (OIdentifiable id : new OSQLSynchQuery<ODocument>("\r\n" + 
				"traverse in() from (select expand(in()) from v where name='Rich') while name <> 'RichardSonDaughter'")) {
			  System.out.print(" --> "+graph.getVertex(id).getProperties());
			  
		}
		System.out.println();
		
		System.out.println(" --> "+graph.getRawGraph().query(new OSQLSynchQuery("select @rid from v where name='RichardSonSon'")));
		System.out.println(" --> "+graph.getRawGraph().query(new OSQLSynchQuery("select @rid from v where name='Richat'")));	  

		System.out.println();
		System.out.println();
		
		//finding node
		
		String query3="select @rid from v where name='RichardSonSon'";
		List<ODocument> result3 = graph.getRawGraph().query(new OSQLSynchQuery(query3));
		int l=result3.size();
		for(int i=0;i<l;i++)
			System.out.println(result3.get(i));
		
		System.out.println();
		System.out.println();
		
		
		// check
		
		String query1="select @rid from v where name='RichardSonDaughter'";
		List<ODocument> result1 = graph.getRawGraph().query(new OSQLSynchQuery(query1));
		String rid="";
		for (ODocument od : result1) {
			JSONObject jsonProp=new JSONObject(od.toJSON());

			rid=jsonProp.getString("rid");
			System.out.print(" --> "+rid);
			}
		
			System.out.println();
			
			String query2="TRAVERSE outE(), inV() FROM "+rid;
			List<ODocument> result2 = graph.getRawGraph().query(new OSQLSynchQuery(query2));
			for (ODocument od1 : result2) {
				JSONObject jsonProp1=new JSONObject(od1.toJSON());
				System.out.print(" --> "+od1.getSchemaClass());
			}
		System.out.println();
		
		System.out.println(" --> "+graph.getRawGraph().query(new OSQLSynchQuery("select age from SonGrandson where name='RichardSonSon'")));
		
		graph.command(new OCommandSQL("DELETE VERTEX Son where cid=12")).execute();
		
		System.out.println();
		System.out.println();
		
		//for displaying adjacent parent or child node
		for (OIdentifiable id : new OSQLSynchQuery<ODocument>("\r\n" + 
				"select expand(in()) from v where name='Richard'")) {
			  System.out.print(" --> "+graph.getVertex(id).getProperties().get("name"));
			  
		}
		System.out.println();
		System.out.println();
		
		//for displaying root to leaf with shortest path
		for (OIdentifiable id : new OSQLSynchQuery<ODocument>("\r\n" + "select from v where name='RichardSonSon'")) {
			for (OIdentifiable cid : new OSQLSynchQuery<ODocument>("\r\n" + "\r\n" + 
					"SELECT expand(path) FROM (\r\n" + 
					"  SELECT shortestPath($from, $to) AS path \r\n" + 
					"  LET \r\n" + 
					"    $from = (SELECT FROM v WHERE name='Rich'), \r\n" + 
					"    $to = (SELECT FROM v WHERE @rid='"+graph.getVertex(id).getId()+"') \r\n" + 
					"  UNWIND path\r\n" + 
					")")) {
				
			System.out.print("-->"+graph.getVertex(cid).getProperties().get("name"));
		}
			System.out.println();
		}
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
		
		graph.shutdown();
		
		}
	}
	}