package hello.core.beanfind;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;
import hello.core.member.service.MemberService;
import hello.core.member.service.MemberServiceImpl;

public class ApplicationContextBasicFindTest {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

	@Test
	void findBeanByName_1() {
		MemberService memberService = ac.getBean("memberService", MemberService.class);

		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}

	@Test
	void findBeanByName_2() {
		MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);

		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}

	@Test
	void findBeanByName_Fail() {
		assertThrows(NoSuchBeanDefinitionException.class,
			() -> ac.getBean("O_O", MemberService.class));
	}

	@Test
	void findBeanByType() {
		MemberService memberService = ac.getBean(MemberService.class);

		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}
}