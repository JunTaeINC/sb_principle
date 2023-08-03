package hello.core.scope;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Provider;

public class SingletonWithPrototypeTest_1 {

	@Test
	void prototypeFine() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
		PrototypeBean prototypeBean_1 = ac.getBean(PrototypeBean.class);
		prototypeBean_1.addCount();
		assertThat(prototypeBean_1.getCount()).isEqualTo(1);

		PrototypeBean prototypeBean_2 = ac.getBean(PrototypeBean.class);
		prototypeBean_2.addCount();
		assertThat(prototypeBean_2.getCount()).isEqualTo(1);
	}

	@Test
	void singletonClientUserPrototype() {
		AnnotationConfigApplicationContext ac =
			new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);

		ClientBean clientBean_1 = ac.getBean(ClientBean.class);
		int count_1 = clientBean_1.logic();
		assertThat(count_1).isEqualTo(1);

		ClientBean clientBean_2 = ac.getBean(ClientBean.class);
		int count_2 = clientBean_2.logic();
		assertThat(count_2).isEqualTo(1);
	}

	static class ClientBean {
		@Autowired
		private Provider<PrototypeBean> provider;

		public int logic() {
			PrototypeBean prototypeBean = provider.get();
			prototypeBean.addCount();
			return prototypeBean.getCount();
		}
	}

	@Scope("prototype")
	static class PrototypeBean {
		private int count = 0;

		public void addCount() {
			count++;
		}

		public int getCount() {
			return count;
		}

		@PostConstruct
		public void init() {
			System.out.println("PrototypeBean.init" + this);
		}

		@PreDestroy
		public void destroy() {
			System.out.println("PrototypeBean.destroy");
		}
	}
}