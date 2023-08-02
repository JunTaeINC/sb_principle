package hello.core.lifeCycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

	@Test
	void lifeCycleTest() {
		ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
		NetworkClient networkClient = ac.getBean(NetworkClient.class);
		ac.close();
	}

	@Configuration
	static class LifeCycleConfig {

		@Bean(initMethod = "init", destroyMethod = "close")
		// destroyMethod 추론기능에 의해 close, shutdown 메소드 명을 찾아서 실행 그래서 메소드 명이 close, shutdown 일 경우 생략가능
		public NetworkClient networkClient() {
			NetworkClient networkClient = new NetworkClient();
			networkClient.setUrl("https://www.naver.com");
			return networkClient;
		}
	}
}