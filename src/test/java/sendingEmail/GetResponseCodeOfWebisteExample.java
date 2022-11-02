package sendingEmail;

import org.apache.http.client.fluent.Request;
import org.testng.annotations.Test;

public class GetResponseCodeOfWebisteExample {
	
	@Test
	public void f1() throws Exception{
		String url="https://mail.rediff.com/cgi-bin/login.cgi";	
		int responseCode=Request.Get(url).execute().returnResponse().getStatusLine().getStatusCode();
		System.out.println("Response code to the URL is: "+ responseCode);
	
	}

}
