package org.apache.commons.mail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.Header;
import javax.mail.Session;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmailTest {
	
	private static final String[] TEST_EMAILS = { "ab@bc.com", "a.b@c.org", "abcdefghijklmnopqrst@abcdefghijklmnopqrst.com.bd" };
	private static final String testStr = "Test";
	private static final String testVal = "Val";
	private static final String testEmail = "abc@d.com";
	
	/* Concrete Email Class for Testing */
	private EmailConcrete email;
	
	@Before
	public void setUpEmailtest() throws Exception {
		
		email = new EmailConcrete();
		
	}
	
	@After
	public void tearDownEmailtest() throws Exception {
		
	}
	
	/*
	 * Test addBcc(String email) function
	 */
	@Test
	public void testAddBcc() throws Exception{
		email.addBcc(TEST_EMAILS);
	
		assertEquals(3, email.getBccAddresses().size());
	}
	
	/*
	 * Test addCc(String email) function
	 */
	@Test
	public void testAddCc() throws Exception{
		email.addCc(TEST_EMAILS);
	
		assertEquals(3, email.getCcAddresses().size());
	}
	
	/*
	 * Test addHeader(String name, String value) function
	 */
	@Test
	public void testAddHeader() throws Exception{
		email.addHeader(testStr, testVal);
		boolean k = email.headers.containsKey(testStr);
		boolean v = email.headers.containsValue(testVal);
			
		assertTrue(k);
		assertTrue(v);
	}
	
	/*
	 * Test addReplyTo(String email, String name) function
	 */
	@Test
	public void testAddReplyTo() throws Exception{
		email.addReplyTo(testEmail, testStr);
	
		assertEquals(1, email.getReplyToAddresses().size());
	}
	
	/*
	 * Test buildMimeMessage() function
	 */
	@Test
	public void testBuildMimeMessage() throws Exception{
		email.message = "test";
		String expectedMessage = "The MimeMessage is already built.";
		String actualMessage = email.buildMimeMessage();
		assertEquals(expectedMessage, actualMessage);
	}
	
	/*
	 * Test getHostName() function
	 */
	@Test
	public void testGetHostname() throws Exception{
		email.hostName = "Test";
		assertEquals("Test", email.getHostName());
		
		email.hostName = null;
		assertNull(email.getHostName());
	}
	
	/*
	 * Test getMailSession() function
	 */
	@Test
	public void testGetMailSession() throws Exception{
		Session aSession = null;
		email.setMailSession(aSession);
		
		assertNull(email.getMailSession());
	}
	
	/*
	 * Test getSentDate() function
	 */
	@Test
	public void testGetSentDate() throws Exception{
		Date date = new Date();
		email.sentDate = new Date(date.getTime());
			
		assertNotNull(email.getSentDate());
	}
	
	/*
	 * Test getSocketConnectionTimeout() function
	 */
	@Test
	public void testGetSocketConnectionTimeout() throws Exception{
		email.socketConnectionTimeout = 4;
	
		assertEquals(4, email.getSocketConnectionTimeout());
	}
	
	/*
	 * Test setFrom(String email) function
	 */
	@Test
	public void testSetFrom() throws Exception{
		email.setFrom(testEmail);
	
		assertEquals(testEmail, email.fromAddress);
	}
	
}
