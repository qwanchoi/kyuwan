package com.prod;

public class BookExample {
	public static void main(String[] args) {
		// 책 (책 제목, 저자, 출판사, 가격)
		Book book1 = new Book();
		book1.title = "혼공자";
		book1.author = "신용권";
		book1.publisher = "한빛미디어";
		book1.price = 24000;
		
		Book book2 = new Book();
		book2.title = "PowerJava";
		book2.author = "천인국";
		book2.publisher = "인피니티";
		book2.price = 35000;
		
		Book book3 = new Book();
		book3.title = "재밌는 Java";
		book3.author = "이호준";
		book3.publisher = "인피니티";
		book3.price = 20000;
		
		Book[] books = { book1, book2, book3 };
		
		for(int i = 0; i < books.length; i++) {
//			if(books[i].publisher.equals("인피니티")) {				
//				System.out.println("제목: " + books[i].title);
//				System.out.println("저자: " + books[i].author);
//				System.out.println("가격: " + books[i].price);
//				System.out.println("======================================");
//			}
			if(books[i].author == "신용권" ) {
				System.out.println("제목: "+books[i].title);
				System.out.println("======================================");
			}
		}
		
		System.out.println("end of prog");
	}
}
