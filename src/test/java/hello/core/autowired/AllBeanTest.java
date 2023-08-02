package hello.core.autowired;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AutoAppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.domain.Grade;
import hello.core.member.domain.Member;

public class AllBeanTest {

	@Test
	void findAllBean() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

		DiscountService discountService = ac.getBean(DiscountService.class);
		Member userA = new Member(1L, "user_A", Grade.VIP);
		int discountPrice_A = discountService.discount(userA, 10000, "fixDiscountPolicy");
		assertThat(discountPrice_A).isEqualTo(1000);

		int discountPrice_B = discountService.discount(userA, 20000, "rateDiscountPolicy");
		assertThat(discountPrice_B).isEqualTo(2000);

	}

	static class DiscountService {
		private final Map<String, DiscountPolicy> discountPolicyMap;

		public DiscountService(Map<String, DiscountPolicy> discountPolicyMap) {
			this.discountPolicyMap = discountPolicyMap;
		}

		public int discount(Member member, int price, String discountCode) {
			DiscountPolicy discountPolicy = discountPolicyMap.get(discountCode);
			return discountPolicy.discount(member, price);
		}
	}
}
