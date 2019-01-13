package apitests;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import api.GitClient;

public class GitClientTests {
	public static GitClient client;
	
	@BeforeClass
	public static void createClient() {
		client = GitClient.getClient();
	}
	
	@Test
	public void testGetUser() {
		String result = client.getUser("RodgerRG");
		System.out.println(result);
		
		Assert.assertTrue(result != null);
	}
	
	@Test
	public void testKeepAlive() {
		
	}
	
}
