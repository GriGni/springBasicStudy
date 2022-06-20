package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

/**
 * AppConfig는 객체의 생성과 연결을 담당.
 * refactoring
 * repository를 method로 추출해서 가독성을 높임.
 * 해당 클래스의 역할과 구현 클래스가 한눈에 보인다.
 */
public class AppConfig {

    public MemberService memberService() {
        // 생성자 주입 방식
        return new MemberServiceImpl(memberRepository());
    }
    //repository 역할
    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    //interface 기반 구현체.
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    //repository 역할
    private FixDiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
