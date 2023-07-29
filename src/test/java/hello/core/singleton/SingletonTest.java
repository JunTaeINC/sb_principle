package hello.core.singleton;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.config.AppConfig;
import hello.core.member.service.MemberService;

public class SingletonTest {

	@Test
	void pureContainer() {
		AppConfig appConfig = new AppConfig();

		MemberService memberService_1 = appConfig.memberService();
		MemberService memberService_2 = appConfig.memberService();

		assertThat(memberService_1).isNotSameAs(memberService_2);
	}

	@Test
	void singletonServiceTest() {
		SingletonService instance1 = SingletonService.getInstance();
		SingletonService instance2 = SingletonService.getInstance();

		assertThat(instance1).isSameAs(instance2);
	}

	@Test
	void springContainer() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

		MemberService memberService_1 = ac.getBean("memberService", MemberService.class);
		MemberService memberService_2 = ac.getBean("memberService", MemberService.class);

		assertThat(memberService_1).isSameAs(memberService_2);
	}
}