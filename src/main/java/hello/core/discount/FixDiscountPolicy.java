package hello.core.discount;

import org.springframework.stereotype.Component;

import hello.core.member.domain.Grade;
import hello.core.member.domain.Member;

@Component
public class FixDiscountPolicy implements DiscountPolicy {
	private final int disCountFixAmount = 1000;

	@Override
	public int discount(Member member, int price) {
		if (member.getGrade() == Grade.VIP) {
			return disCountFixAmount;
		} else {
			return 0;
		}
	}
}
