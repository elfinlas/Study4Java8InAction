package com.study.chap05;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;

import com.study.res.Dish;
import static com.study.chap05.MakeListObj4Dish.*;



public class Main4Chap05 {
	public static void main(String [] args) {
		myself02();
	}
	
	
	
	public static void myself02() {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		int sum = 0;
		
		sum = numbers.stream().reduce(0, (Integer a, Integer b) -> a+b ); //형 명시
		sum = numbers.stream().reduce(0, (a, b) -> a+b ); //형 추론
		
		sum = numbers.stream().reduce(0, Integer::sum); //Method Reference
		
		System.out.println("sum = " + sum);		
	}
	
	
	
	public static void exam16() {
		boolean te = getDishList().stream()
			.filter(d -> d.isVegetarian())
			.findAny()
			.isPresent();
		
		System.out.println("te = " + te);
		
		//.ifPresent(d-> { System.out.println(d.getName());});
	}
	
	/*
	 
	//anyMatch
	public static void exam13() {
		if ( getDishList().stream().anyMatch(Dish::isVegetarian) ) {
			System.out.println("This menu (somewhat) vegetarian friendly!");
		}
	}
	 */
	
	
	//156 Quiz 5-2-3  5-2-2의 결과물에서 두 수의 합이 3으로 나눠 떨어지는 것을 구하여라 
	public static void quiz_5_2_3() {
		List<Integer> numberOneList = Arrays.asList(1,2,3);
		List<Integer> numberTwoList = Arrays.asList(3,4);

		List<int []> result = numberOneList.stream()
				.flatMap(n -> 
					numberTwoList.stream().filter(m -> n+m == 6).map(r -> new int[]{n,r})
					)
				.collect(toList());

		for (int[] i : result) {
			for (int j : i) {
				System.out.print("j = " + j + " ");
			}
			System.out.println();
		}
	}
	
	//156 Quiz 5-2-2 두 개의 숫자 리스트가 있을 때 모든 숫자 쌍의 리스트 반환 
	//[1,2,3] 과 [3,4] 제공 시  [(1,3), (1,4, (2,3), (2,4) ...] 를 구하는 문제  
	public static void quiz_5_2_2() {
		List<Integer> numberOneList = Arrays.asList(1,2,3);
		List<Integer> numberTwoList = Arrays.asList(3,4);

		List<int []> resultList =  numberOneList.stream()
				.flatMap(n -> numberTwoList.stream().map(m -> new int[]{n,m} ))
				.collect(toList());

		for (int[] i : resultList) {
			for (int j : i) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	
	//155 Quiz 5-2-1 숫자 리스트가 주어졌을 때 제근으로 이뤄진 리스트 반환 문제
	public static void quiz_5_2_1() {
		List<Integer> examList = Arrays.asList(1,2,3,4,5);
		
		List<Integer> resultList = examList.stream()
		.map(i -> i * i)
		.collect(toList());
		
		for (Integer i : resultList) {
			System.out.println("result = " + i);
		}
	}
	
	
	//noneMatch
	public static void exam15() {
		if ( getDishList().stream().noneMatch(d -> d.getCalories() >= 1000) ) {
			System.out.println("Healthy!!");
		}
		else {
			System.out.println("OMG...");
		}
	}
	
	
	//allMatch
	public static void exam14() {
		if ( getDishList().stream().allMatch(d -> d.getCalories() < 1000) ) {
			System.out.println("Healthy!!");
		}
		else {
			System.out.println("OMG...");
		}
	}
	
	
	//anyMatch
	public static void exam13() {
		if ( getDishList().stream().anyMatch(Dish::isVegetarian) ) {
			System.out.println("This menu (somewhat) vegetarian friendly!");
		}
	}
	
	
	//flatMap 실전 예제
	public static void exam12() {
		List<MemberVo> memberList = Arrays.asList(new MemberVo(1, 27, "남두현"), new MemberVo(2, 20, "유형주"),
                new MemberVo(3, 20, "태재영"), new MemberVo(4, 40, "남궁계홍"));
		List<BoardDetailVo> boardList = Arrays.asList(new BoardDetailVo(1, "람다게시판입니다.", "람다에 관련된 클만 올려주세요."),
                new BoardDetailVo(1, "람다란 무엇이니가?", "함수형 프로그래밍의 꽃?"),
                new BoardDetailVo(2, "물어볼 게 있습니다.", "람다공부는 어떻게 하죠?"));
 
		memberList.stream()
			.flatMap(i -> boardList.stream()
						.filter(j -> j.getSn() == i.getSn().intValue())
						.map(j -> {
							MemberBoardResultVo result = new MemberBoardResultVo();
							result.setSn(i.getSn());
							result.setName(i.getName());
							result.setContents(j.getContents());
							result.setTitle(j.getTitle());
							return result;
						})
					)
			.forEach(ret -> {
                System.out.println(String.format("[%s]%s:%s", 
                    ret.getName(), 
                    ret.getTitle(), 
                    ret.getContents()));
            }
        );
	}
	
	//Arrays stream을 이해하기 위한 stream 확인용 
	public static void exam11() {
		String[] words = {"Hello", "World"};
		Stream<String> streamOfWord = Arrays.stream(words);
		streamOfWord.forEach(System.out::println);
	}
	
	
	//flatMap 적용 부분
	public static void exam10() {
		List<String> words = Arrays.asList("Hello", "World");
		List<String> resultList = words.stream()
				.map(w -> w.split(""))
				.flatMap(Arrays::stream)
				.distinct()
				.collect(toList());
		
		//.flatMap(list -> Arrays.stream(list))  //위의 flatMap의 메서드 레퍼런스는 이런 람다식으로 변경이 가능하다.
		
		for(String str : resultList) {
			System.out.println("str = " + str);
		}
	}
	
	//flat map 을 도출하기 위한 예제
	public static void exam09() {
		List<String> words = Arrays.asList("Hello", "World");
		List<String[]> temp =  words.stream() 
		  .map(word -> word.split(""))
		  .distinct()
		  .collect(toList());
		//위의 temp 앞의 Strea은 words의 단어 하나씩 String[] 형태로 나눠 저장을 한다.
		//즉 결과물은 String 형태가 아닌 String[] 의 형태가 이뤄진다.
		
		for(String[] strs : temp) {
			for (String str : strs ) {
				System.out.print(str + " ");
			}
			System.out.println();
		}
	}
	
	//flat map 을 도출하기 위한 예제
	public static void exam08() {
		List<String> strList = Arrays.asList("Hello", "World");
		
		for(String str : strList) {
			System.out.println("str = " + str.split("") );
		}
		
		for(String str : strList) {
			System.out.println("str = " + str.split("").getClass().getTypeName() );
		}
		
		for(int i =0; i<strList.size(); i++) {
			System.out.println("i = " + strList.get(i).split("")[0] );
		}

	}
	
	public static void exam07() {
		getDishList().stream()
				.map(Dish::getName)
				.map(String::length)
				.forEach(System.out::println);
	}
	
	
	public static void exam06() {
		List<String> words = Arrays.asList("Java", "Lambdas", "In", "Action");
		List<Integer> wordLengths = words.stream()
					.map(String::length)
					.collect(toList());
		
		for(int i : wordLengths) {
			System.out.println("i = " + i);
		}
	}
	
	public static void exam05() {
		List<String> menuStr = getDishList().stream()
				.map(Dish::getName)
				.collect(toList());
		
		for(String name : menuStr) {
			System.out.println("menu = " + name);
		}
	}
	
	public static void exam04() {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);
		numbers.stream()
			.skip(3)
			.forEach(System.out::println);
	}
	
	public static void exam03() {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);
		numbers.stream()
			.limit(3)
			.forEach(System.out::println);
	}
	
	
	public static void exam02() {
		List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
		numbers.stream()
			.filter(i -> i % 2 == 0)
			.distinct()
			.forEach(System.out::println);
	}
	
	/**
	 * Dish에 담긴 음식 중 채식주의 음식을 출력
	 */
	public static void exam01() {
		List<Dish> vegetarianMenu = getDishList().stream()
				.filter(Dish::isVegetarian)
				.collect(toList());
		
		for(Dish d : vegetarianMenu) {
			System.out.println("vegetarianMenu = " + d.getName() );
		}
	}
	
	
	//////////////////// myself
	
	public static void myself01() {
		List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
		Optional<Integer> firstNum = someNumbers.stream()
				.map(x -> x * x)
                .filter(x -> x % 2 == 0)
                .findAny();
		
		//1 4 9 16 25
		
		System.out.println(firstNum.orElse(10));
		//ifPresent
	}
	
	
}


class MemberVo {
	private Integer sn;
    private Integer age;
    private String name;
    
    public MemberVo(Integer sn, Integer age, String name) {
    	super();
    	this.sn = sn;
    	this.age = age;
    	this.name = name;	    			
    }

	public Integer getSn() {
		return sn;
	}

	public void setSn(Integer sn) {
		this.sn = sn;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    
}

class BoardDetailVo {
	private Integer sn;
	private String contents;
	private String title;
	
	public BoardDetailVo(Integer sn, String contents, String title) {
		super();
		this.sn = sn;
		this.contents = contents;
		this.title = title;
	}

	public Integer getSn() {
		return sn;
	}

	public void setSn(Integer sn) {
		this.sn = sn;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}

class MemberBoardResultVo {
	private Integer sn;
	private String name;
	private String contents;
	private String title;
	
//	public MemberBoardResultVo(Integer sn, String name, String contents, String title) {
//		this.sn = sn;
//		this.name = name;
//		this.contents = contents;
//		this.title = title;
//	}
	
	public void setSn(Integer sn) {
		this.sn = sn;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getSn() {
		return sn;
	}
	public String getName() {
		return name;
	}
	public String getContents() {
		return contents;
	}
	public String getTitle() {
		return title;
	}
}
