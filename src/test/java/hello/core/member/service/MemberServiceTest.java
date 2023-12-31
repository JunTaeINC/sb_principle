package hello.core.member.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig;
import hello.core.member.domain.Grade;
import hello.core.member.domain.Member;

class MemberServiceTest {
	MemberService memberService;

	@BeforeEach
	public void beforeEach() {
		AppConfig appConfig = new AppConfig();
		memberService = appConfig.memberService();
	}

	@Test
	void join() {
		// given
		Member member = new Member(1L, "member_A", Grade.BASIC);

		// when
		memberService.join(member);
		Member findMember = memberService.findMember(1L);

		// then
		assertThat(member).isEqualTo(findMember);
	}
}