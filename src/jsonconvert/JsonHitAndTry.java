package jsonconvert;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonHitAndTry {

	public static void main(String[] args) {
		JSONObject object=new JSONObject();
		
		
		JSONObject o=new JSONObject();
		o.put("name", "akash");
		o.put("surname", "jain");
		

	
		JSONArray jarr = new JSONArray();
		
		JSONObject jobj1 = new JSONObject();		
		JSONArray jarr1 = new JSONArray();

		for (int i = 1; i < 5; i++) {
			JSONObject json = new JSONObject();
			json.put("label", "Q" + i);
			jarr1.put(json);
		}

		jobj1.put("category", jarr1);
		jarr.put(jobj1);

			
		
		JSONArray jarr2 = new JSONArray();
		
		JSONObject jsubO1 = new JSONObject();
		jsubO1.put("seriesname","passtest");
		JSONArray jsubA1 = new JSONArray();
		for (int i = 1; i < 5; i++) {
			JSONObject json = new JSONObject();
			json.put("value", "5" + i);
			jsubA1.put(json);
		}

		jsubO1.put("data", jsubA1);
		
		JSONObject jsubO2 = new JSONObject();
		jsubO2.put("seriesname","failtest");
		JSONArray jsubA2 = new JSONArray();
		for (int i = 1; i < 5; i++) {
			JSONObject json = new JSONObject();
			json.put("value", "4" + i);
			jsubA2.put(json);
		}

		jsubO2.put("data", jsubA2);
		
		jarr2.put(jsubO1);
		jarr2.put(jsubO2);
		
		
		
		object.put("chart", o);
		object.put("categories", jarr);
		object.put("dataset", jarr2);		
		
		
		System.out.println(object);
	}

}
