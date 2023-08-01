package hello.core.autowired;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import hello.core.member.domain.Member;

public class AutowiredTest {

	@Test
	void AutowiredOption() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
	}

	static class TestConfig {

		@Autowired(required = false)
		public void setNoBean_1(Member member) {
			System.out.println("member = " + member);
		}

		@Autowired
		public void setNoBean_2(@Nullable Member member) {
			System.out.println("member = " + member);
		}

		@Autowired
		public void setNoBean_3(Optional<Member> member) {
			System.out.println("member = " + member);
		}
	}
}