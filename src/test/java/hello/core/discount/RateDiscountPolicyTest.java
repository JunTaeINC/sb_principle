package hello.core.discount;

import hello.core.member.domain.Grade;
import hello.core.member.domain.Member;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {

    private final RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    void vip_S() {
        Member member = new Member(1L, "vipUser", Grade.VIP);

        int discount = rateDiscountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(1000);
    }

    @Test
    void vip_F() {
        Member member = new Member(2L, "basicUser", Grade.BASIC);

        int discount = rateDiscountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(0);
    }
}