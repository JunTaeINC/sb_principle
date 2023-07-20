package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceTest {

    private final MemberService memberService = new MemberServiceImpl();
    private final OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "member_A", Grade.VIP);

        memberService.join(member);

        Order order = orderService.createOrder(memberId, "item_A", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}