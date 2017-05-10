/**
 * 
 */
package streaming.mosaic;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChallengeTests {

	@Test
	public void testUrl2JsonCase1() {
		String url="http://mysite.com/index.php?name=john&id=42&id=67";
		String json = "{\"name\":\"john\", \"id\":[\"42\", \"67\"]}";
		assertTrue(json.equals(Challenge.Url2Json(url)));
	}
	
	@Test
	public void testUrl2JsonCase2() {
		String url="http://mysite.com/index.php?name=john&id=42&id=67&name=william";
		String json = "{\"name\":[\"john\", \"william\"], \"id\":[\"42\", \"67\"]}";
		assertTrue(json.equals(Challenge.Url2Json(url)));	
	}

	@Test
	public void testUrl2JsonCase3() {
		String url="http://mysite.com/index.php?name=john&id=42";
		String json = "{\"name\":\"john\", \"id\":\"42\"}";
		assertTrue(json.equals(Challenge.Url2Json(url)));
	}
	
	@Test
	public void testUrl2JsonEmpty() {
		String url="http://mysite.com";
		org.junit.Assert.assertNull(Challenge.Url2Json(url));
	}
	
	@Test
	public void testUrl2JsonBadUrl() {
		String url="http//mysite.com";
		org.junit.Assert.assertNull(Challenge.Url2Json(url));
	}
	
	@Test
	public void testIsPermutationPositive() {
		assertTrue(Challenge.isPermutation("debit card", "bad credit"));
	}
	
	@Test
	public void testIsPermutationEmpty() {
		assertTrue(Challenge.isPermutation("", ""));
	}

	@Test
	public void testIsPermutationNegative1() {
		assertFalse(Challenge.isPermutation("debit  card", "bad credits"));
	}
	
	@Test
	public void testIsPermutationNegative2() {
		assertFalse(Challenge.isPermutation("debit cards", "bad  credit"));
	}
	
	@Test
	public void testIsPermutationNegative3() {
		assertFalse(Challenge.isPermutation("debit cards", "bad credit"));
	}
	
	@Test
	public void testIsPermutationNull() {
		assertFalse(Challenge.isPermutation(null, "bad credit"));
	}
}
