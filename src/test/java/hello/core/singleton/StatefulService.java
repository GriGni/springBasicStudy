package hello.core.singleton;

public class StatefulService {
    // 공유되는 값을 지운다.
//    private int price; // 상태를 유지하는 필드

    public int order(String name, int price) {
        System.out.println("name = " + name);
        System.out.println("price = " + price);
        return price;
//        this.price = price;
    }
//    public int getPrice () {
//        return price;
//    }

}
