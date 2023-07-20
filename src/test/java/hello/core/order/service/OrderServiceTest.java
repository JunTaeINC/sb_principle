package hello.core.order.service;

import hello.core.member.domain.Grade;
import hello.core.member.domain.Member;
import hello.core.member.service.MemberService;
import hello.core.member.service.MemberServiceImpl;
import hello.core.order.domain.Order;
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