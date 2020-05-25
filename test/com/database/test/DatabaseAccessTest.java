package com.database.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import com.MockitoExtension;
import com.database.Credentials;
import com.database.Database;

@ExtendWith(MockitoExtension.class)
public class DatabaseAccessTest {

	@Mock
	private Database database;
	
	private Credentials credentials=new Credentials("user","password");
	
	@Test
	void testUserSuccessFullLogin() {
		when(database.login(credentials)).thenReturn(true);
		Credentials sameCredentials=new Credentials("user","password");
		
		assertTrue(database.login(sameCredentials));
	}
	
	@Test
	void testUserLoginFailed() {
		when(database.login(credentials)).thenReturn(true);
		Credentials otherCred=new Credentials("user","password");
		otherCred.setUsername("otherUser");
		otherCred.setPassword("otherPassword");
		
		assertNotEquals(credentials.getUsername(), otherCred.getUsername());
		assertNotEquals(credentials.getPassword(),otherCred.getPassword());
		assertNotEquals(credentials.hashCode(),otherCred.hashCode());
		assertFalse(database.login(otherCred));
		
	}
	
}
