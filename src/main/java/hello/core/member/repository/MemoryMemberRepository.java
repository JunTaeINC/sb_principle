package hello.core.member.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import hello.core.member.domain.Member;

@Component
public class MemoryMemberRepository implements MemberRepository {
	private static final Map<Long, Member> store = new HashMap<>();

	@Override
	public void save(Member member) {
		store.put(member.getId(), member);
	}

	@Override
	public Member findById(Long memberId) {
		return store.get(memberId);
	}
}
