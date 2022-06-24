package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
// 빈이름 직접 지정하고 싶은 경우
//@Component("memberService2")
@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    // 생성자 생성
    // autowired를 사용하여 자동 의존관계 주입이 필요하다. MemberRepository 타입을 찾아와서 의존관계를 자동으로 연결하여 주입한다.
    // Component annotation을 사용하면 autowired를 사용한다.
    @Autowired  // (ac.getBean(MemberRepository.class))
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository () {
        return memberRepository;
    }
}
