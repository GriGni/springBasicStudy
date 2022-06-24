package hello.core.scan.filter;

import java.lang.annotation.*;
// type -> class level
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
    
}
