
public class QnA {
	String ans;
	int value;
	
	public QnA() {	}
	
	public void setQnA(String ans, int value) {
		this.ans = ans;
		this.value = value;
	}
	
	public int processing() {
		if (ans.equals("y") || ans.equals("Y")) {
			value++;
		}
		
		return value;
	}
	
	 /* 1110(14)(기술과학), 1100(12)(자연과학), 1000(8)(사회과학), 0111(7)(종교),
	  * 0110(6)(철학), 0101(5)(역사), 0100(4)(언어), 0010(2)(예술), 0001(1)(문학), 0000(0)(총류/비문학) */
	public void classification(int value) {
		switch (value) {
		case 0:  // 0000
			System.out.print("가장 추천하는 분야는 총류(비문학) 입니다.\n그 다음으로 추천하는 분야는 문학입니다.");
			break;
		case 1:  // 0001
			System.out.print("가장 추천하는 분야는 문학 입니다.\n그 다음으로 추천하는 분야는 총류(비문학) 입니다.");
			break;
		case 2:  // 0010
			System.out.print("가장 추천하는 분야는 예술 입니다.\n그 다음으로 추천하는 분야는 문학 입니다.");
			break;
		case 4:  // 0100
			System.out.print("가장 추천하는 분야는 언어 입니다.\n그 다음으로 추천하는 분야는 역사 입니다.");
			break;
		case 5:  // 0101
			System.out.print("가장 추천하는 분야는 역사 입니다.\n그 다음으로 추천하는 분야는 언어 입니다.");
			break;
		case 6:  // 0110
			System.out.print("가장 추천하는 분야는 철학 입니다.\n그 다음으로 추천하는 분야는 종교 입니다.");
			break;
		case 7:  // 0111
			System.out.print("가장 추천하는 분야는 종교 입니다.\n그 다음으로 추천하는 분야는 철학 입니다.");
			break;
		case 8:  // 1000
			System.out.print("가장 추천하는 분야는 사회과학 입니다.\n그 다음으로 추천하는 분야는 기술과학 입니다.");
			break;
		case 12:  // 1100
			System.out.print("가장 추천하는 분야는 자연과학 입니다.\n그 다음으로 추천하는 분야는 기술과학 입니다.");
			break;
		case 14:  // 1110
			System.out.print("가장 추천하는 분야는 기술과학 입니다.\n그 다음으로 추천하는 분야는 자연과학 입니다.");
			break;
		}
	}
	
}
