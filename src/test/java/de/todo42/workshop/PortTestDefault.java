package de.todo42.workshop;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
// @ActiveProfiles("default")
public class PortTestDefault {

	@Autowired
	private Environment env;
	
	@Test
	public void contextLoads() {
		assertEquals("8088", env.getProperty("server.port"));
	}

}
