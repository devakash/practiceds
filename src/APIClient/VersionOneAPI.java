package APIClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.codec.binary.Base64;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class VersionOneAPI {

	public static void main(String[] args) {

		try {
			URL url = new URL(
					"https://www3.v1host.com/YodleeInc/rest-1.v1/Data/Test/25919?sel=Description,ExpectedResults,Steps");
			String user = "ajain5" + ":" + "Yodlee@123";
			String encoding = Base64.encodeBase64String(user.getBytes());
			System.out.println(encoding);

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setDoOutput(true);
			connection.setRequestProperty("Authorization", "Basic " + encoding);
			InputStream content = (InputStream) connection.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(content));
			String line;
			String out = "";
			while ((line = in.readLine()) != null) {
				out = out + line;
			}
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource src = new InputSource();
			src.setCharacterStream(new StringReader(out));

			Document doc = builder.parse(src);
			String age = doc.getElementsByTagName("Attribute").item(0).getTextContent();
			String age2 = doc.getElementsByTagName("Attribute").item(1).getTextContent();
			String age3 = doc.getElementsByTagName("Attribute").item(2).getTextContent();
			System.out.println(age);
			System.out.println(age2);
			System.out.println(age3);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
