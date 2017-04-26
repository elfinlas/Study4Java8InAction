package com.study.chap05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


public class Quiz01 {
    
    public static void main(String [] args) {
    	exam06();
    }
    
    
    // 심화 버전 : 최저가 상품을 출력
    public static void exam06() {
    	makeList4Toy().stream().sorted(Comparator.comparing(Toys::getPrice))
    	.findFirst().ifPresent(t -> {System.out.println(t.getName() + " : " + t.getPrice());});
    }
    
    // 심화 버전 : 최고가 상품을 출력
    public static void exam05() {
    	makeList4Toy().stream().sorted(Comparator.comparing(Toys::getPrice).reversed())
    	.findFirst().ifPresent(t -> {System.out.println(t.getName() + " : " + t.getPrice());});
    }
    
    
    // 최저가 금액 출력
    public static void exam04() {
    	makeList4Toy().stream()
    	.map(t -> t.getPrice())
    	.reduce(Long::min) //이쪽에서 초기값을 주면 0이 무조건 나오기 때문에 이렇게 연산을 진행한다.
    	.ifPresent( v -> { System.out.println("Min Value = " + v); });
    	
    	Optional<Long> numOut = makeList4Toy().stream()
    	    	.map(t -> t.getPrice())
    	    	.reduce(Long::min); //이쪽에서 초기값을 주면 0이 무조건 나오기 때문에 이렇게 연산을 진행한다.
    	System.out.println("Min Value = " + numOut.get());
    }
    
    // 최고가 금액 출력
    public static void exam03() {
    	System.out.println("[Unorder Value]");
    	makeList4Toy().stream()
    	.map(t -> t.getPrice()).forEach(v -> { System.out.print(v + " ");});
    	System.out.println();
    	
    	System.out.println("[Reverse Order Value]");
    	makeList4Toy().stream()
    	.map(t -> t.getPrice()).sorted(Comparator.reverseOrder())
    	.forEach(v -> {System.out.print(v+" ");});
    	System.out.println();
    	
    	makeList4Toy().stream()
		.map(t -> t.getPrice())
		.reduce(Long::max)
		.ifPresent(v -> { System.out.println("Max Value = " + v);});
    }
    
    
    // 3만원 이상 이면서 인형인 상품들 출력
    public static void exam02() {
    	makeList4Toy().stream()
    	.filter(t -> t.getPrice() > 30000)
    	.filter(t -> t.getName().split(" ")[1].equals("인형"))
    	.forEach( t -> {
    		System.out.println("result = " + t.getName());
    	});
    }
    
    // 3만원 이하인 장난감의 합계 출력
    public static void exam01() {
    	makeList4Toy().stream()
    	.filter(t -> t.getPrice() < 30000)
    	.map(t -> t.getPrice())
    	.reduce((t1, t2) -> t1+ t2)
    	.ifPresent(System.out::println);
    }
    
    
    public static List<Toys> makeList4Toy() {
    	List<Toys> toys = Arrays.asList(
                new Toys(1, "뽀로로 인형", 31000),
                new Toys(2, "콩순이 인형", 35000),
                new Toys(3, "알록달록 카페놀이", 50000),
                new Toys(4, "콩셰프 레스토랑", 42000),
                new Toys(5, "보글보글 라면가게", 13000),
                new Toys(6, "123 마트가게", 58000),
                new Toys(7, "콩순이 꼬마샤워기", 60000),
                new Toys(8, "꼬마버스 타요", 5000),
                new Toys(9, "파워레인저", 2000),
                new Toys(10, "콩콩이 인형", 12000)
            );
    	return toys;
    }
}


class Toys {
    private long id;
    private String name;
    private long price;

    public Toys(long id, String name, long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Toys{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}