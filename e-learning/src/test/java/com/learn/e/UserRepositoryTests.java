package com.learn.e;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		BCryptPasswordEncoder encoder =  new BCryptPasswordEncoder();
		User user = new User();
		user.setEmail("sainp7@gmail.com");
		user.setPassword(encoder.encode("password"));
		user.setName("Paras sain");
		user.setAddress("MBD");
		user.setPhone_number("+918899869994");
		user.setProfile_photo("---path to file---");
		user.setRegistration_date("08-August-2020");
		
		User savedUser= repo.save(user);
		
		User exixtUser = entityManager.find(User.class, savedUser.getUser_id());
		assertThat(exixtUser.getEmail()).isEqualTo(user.getEmail());
		
	}
	
	@Test
	public void testFindUserByEmail() {
		String email = "sainp7@gmail.com";
		
		User user = repo.findByEmail(email);
		
		assertThat(user).isNotNull();
		
		
		
	}

}
