package hello.core.scope;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class PrototypeTest {

	@Test
	void prototypeBeanFind() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);

		System.out.println("Find PrototypeBean_1");
		PrototypeBean prototypeBean_1 = ac.getBean(PrototypeBean.class);

		System.out.println("Find PrototypeBean_2");
		PrototypeBean prototypeBean_2 = ac.getBean(PrototypeBean.class);

		ac.close();

		assertThat(prototypeBean_1).isNotSameAs(prototypeBean_2);
	}

	@Scope("prototype")
	static class PrototypeBean {
		@PostConstruct
		public void init() {
			System.out.println("PrototypeBean.init");
		}

		@PreDestroy
		public void destroy() {
			System.out.println("PrototypeBean.destroy");
		}
	}
}