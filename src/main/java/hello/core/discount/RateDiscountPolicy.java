package hello.core.discount;

import org.springframework.stereotype.Component;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.domain.Grade;
import hello.core.member.domain.Member;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {
	private final int rate = 10;

	@Override
	public int discount(Member member, int price) {
		if (member.getGrade() == Grade.VIP) {
			return price * rate / 100;
		} else {
			return 0;
		}
	}
}
