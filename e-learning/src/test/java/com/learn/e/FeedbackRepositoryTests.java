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
public class FeedbackRepositoryTests {
	
	@Autowired
	private FeedbackRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		BCryptPasswordEncoder encoder =  new BCryptPasswordEncoder();
		Feedback feedback = new Feedback();
		feedback.setEmail("sainp7@gmail.com");
		feedback.setName("Paras sain");
		feedback.setFeedback_data("All good");
		feedback.setUser_id((long) 1);	
		
		Feedback savedFeedback = repo.save(feedback);
		
		Feedback existFeedback = entityManager.find(Feedback.class, savedFeedback.getFeedback_id());
		assertThat(existFeedback.getFeedback_id()).isEqualTo(feedback.getFeedback_id());
	
		
	}
}
