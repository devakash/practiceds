package APIClient;

import java.util.Iterator;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonParsing {

	public static void main(String[] args) {
		String source = "{\"name\": \"Test User\",\"cities\": [\"Bangalore\", \"delhi\", \"Chennai\"],\"user\": {\"age\": 12,\"Ids\": [\"123\", \"234\", \"324\"]}}";
		JSONObject j = new JSONObject(source);
		jsonp(j);

	}

	public static void jsonp(JSONObject j) {
		Set<String> keySet = j.keySet();
		Iterator<String> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			String next = iterator.next();
			Object object = j.get(next);
			if (object instanceof String || object instanceof Integer) {
				System.out.println("\"" + next + "\":\"" + object.toString() + "\"");
			} else if (object instanceof JSONObject) {
				jsonp((JSONObject)object);
			}
			else
				if(object instanceof JSONArray)
				{
					JSONArray ja=(JSONArray)object;
					for(int i=0; i<ja.length();i++)
					{
						String op="\""+next+"["+i+"]";
						System.out.println(op+":\""+ja.get(i)+"\"");
					}
				}
		}
	}

}
