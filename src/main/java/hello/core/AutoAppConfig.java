package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // default - 해당 클래스의 패키지 경로 부터 스캔을 한다. hello.core부터
        // 해당 패키지 경로만 컴포넌트를 스캔한다. 라이브러리까지 스캔을 한다. 그러므로 해당  경로만 스캔하도록 만드는 것.
        basePackages = "hello.core",
        // Configuration annotation을 사용하는 곳의 컴포넌트 스캔에서 제외 하는 로직
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}
