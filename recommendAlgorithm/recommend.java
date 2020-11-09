import java.util.Scanner;

public class recommend {
	
	public static void main(String[] args) {
		
		String answer;
		int recommendValue = 0;
		Scanner sc = new Scanner(System.in);
		QnA myQnA = new QnA();
		
		/* 1번 질의 */
		System.out.print("현상의 탐구, 진리의  추구?(y/n)\n");
		answer = sc.next();
		/* answer값이 잘못된 입력인지 확인 */
		while ( !(answer.equals("y") || answer.equals("Y") || answer.equals("n") || answer.equals("N")) ) {
			System.out.println("잘못된 입력입니다.");
			answer = sc.next();
		}
		myQnA.setQnA(answer, recommendValue);
		recommendValue = myQnA.processing();
		answer = "n";
		/* recommendValue값은 1 or 0 */
				
		/* 2번 질의 */
		switch(recommendValue) {
		case 0:
			System.out.print("인류의 발자취에 관심이?(y/n)\n");
			answer = sc.next();
			break;
		case 1:
			System.out.print("자연의 현상 탐구를 군중의 현상보다 선호?(y/n)\n");
			answer = sc.next();
			break;			
		}
		/* answer값이 잘못된 입력인지 확인 */
		while ( !(answer.equals("y") || answer.equals("Y") || answer.equals("n") || answer.equals("N")) ) {
			System.out.println("잘못된 입력입니다.");
			answer = sc.next();
		}
		recommendValue <<= 1;  // 비트 쉬프트
		myQnA.setQnA(answer, recommendValue);
		recommendValue = myQnA.processing();
		answer = "n";
		/* recommendValue값은 11, 10(사회과학), 01, 00 */
		
		/* 3번 질의 */
		switch(recommendValue) {
		case 0:  // 00
			System.out.print("그림이나 조각 등의 예술행위에 관심이?(y/n)\n");
			answer = sc.next();
			break;
		case 1:  // 01
			System.out.print("사색을 많이?(y/n)\n");
			answer = sc.next();
			break;
		 // 10 (사회과학)
		case 3:  // 11
			System.out.print("이론적인것보다 실용적인것을 선호?(y/n)\n");
			answer = sc.next();
			break;
		}
		/* answer값이 잘못된 입력인지 확인 */
		while ( !(answer.equals("y") || answer.equals("Y") || answer.equals("n") || answer.equals("N")) ) {
			System.out.println("잘못된 입력입니다.");
			answer = sc.next();
		}
		recommendValue <<= 1;  // 비트 쉬프트
		myQnA.setQnA(answer, recommendValue);
		recommendValue = myQnA.processing();
		answer = "n";
		/* recommendValue값은 111, 110, 100(사회과학), 011, 010, 001(예술), 000 */

		/* 4번 질의 */
		switch(recommendValue) {
		case 0: // 000
			System.out.print("비문학보다 문학을 선호?(y/n)\n");
			answer = sc.next();
			break;
		// 001 (예술)
		case 2: // 010
			System.out.print("역사에 관심?(y/n)\n");
			answer = sc.next();
			break;
		case 3: // 011
			System.out.print("신을 믿음?(y/n)\n");
			answer = sc.next();
			break;
		// 100 (사회과학)
		// 110 (자연과학)
		// 111 (기술과학)
		}
		/* answer값이 잘못된 입력인지 확인 */
		while ( !(answer.equals("y") || answer.equals("Y") || answer.equals("n") || answer.equals("N")) ) {
			System.out.println("잘못된 입력입니다.");
			answer = sc.next();
		}
		recommendValue <<= 1;  // 비트 쉬프트
		myQnA.setQnA(answer, recommendValue);
		recommendValue = myQnA.processing();
		answer = "n";
		/* recommendValue값은
		 *  1110(14)(기술과학), 1100(12)(자연과학), 1000(8)(사회과학), 0111(7)(종교),
		 *  0110(6)(철학), 0101(5)(역사), 0100(4)(언어), 0010(2)(예술), 0001(1)(문학), 0000(0)(총류/비문학) */
		
		/* 최종 선호장르 구분 */
		myQnA.classification(recommendValue);
		
	}
}
