package hello.core.beanfind;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.core.member.repository.MemberRepository;
import hello.core.member.repository.MemoryMemberRepository;

public class ApplicationContextSameBeanFindTest {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

	@Test
	void findBeanByTypeDuplicate() {
		assertThrows(NoUniqueBeanDefinitionException.class,
			() -> ac.getBean(MemberRepository.class));
	}

	@Test
	void findAllBeanByType() {
		Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);

		for (String key : beansOfType.keySet()) {
			System.out.println("key = " + key + " / " + "value = " + beansOfType.get(key));
		}

		assertThat(beansOfType.size()).isEqualTo(2);
	}

	@Configuration
	static class SameBeanConfig {

		@Bean
		public MemberRepository memberRepository_1() {
			return new MemoryMemberRepository();
		}

		@Bean
		public MemberRepository memberRepository_2() {
			return new MemoryMemberRepository();
		}
	}
}