package com.sebastianwrobel;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

public class EncodingTest {

	@Test
	public void encrypt_password() {
	  
	  System.out.println("ADMIN password: " + PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("admin"));
	  System.out.println("EMPLOYEE password: " + PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("employee"));
	  System.out.println("CLIENT password: " + PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("client"));
	}
	
}
