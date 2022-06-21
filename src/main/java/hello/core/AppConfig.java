package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AppConfig는 객체의 생성과 연결을 담당.
 * refactoring
 * repository를 method로 추출해서 가독성을 높임.
 * 해당 클래스의 역할과 구현 클래스가 한눈에 보인다.
 */
@Configuration
public class AppConfig {
    // Bean 에너테이션을 사용하면 스프링 컨테이너에 등록된다.
    @Bean
    public MemberService memberService() {
        // 생성자 주입 방식
        return new MemberServiceImpl(memberRepository());
    }

    //repository 역할
    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    //interface 기반 구현체.
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    //repository 역할
    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
//        할인 정책 변경.
        return new RateDiscountPolicy();
    }
}
