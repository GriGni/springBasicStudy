package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA : 사용자A 10000원 주문
//        statefulService1.order("userA", 10000);
        int userAPrice = statefulService1.order("userA", 10000);

        //ThreadB : 사용자B 20000원 주문
//        statefulService2.order("userb", 20000);
        int userBPrice = statefulService2.order("userB", 20000);

        // ThreadA : 사용자A가 주문 금액 조회
//        int price = statefulService1.getPrice();
        // 20000원이 조회 될 것.
        // 이유 : 스프링 컨터이너를 사용하여 싱글톤 패턴이 구현된 상태이므로 서로 상태를 공유하는 상태.
        // statefulService2가 20000원으로 주문함으로써 가져오는 값도 20000원으로 변한다.
        System.out.println("price = " + userAPrice);

//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);

    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }


}
