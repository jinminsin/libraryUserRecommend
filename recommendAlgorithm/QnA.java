
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
	
	 /* 1110(14)(�������), 1100(12)(�ڿ�����), 1000(8)(��ȸ����), 0111(7)(����),
	  * 0110(6)(ö��), 0101(5)(����), 0100(4)(���), 0010(2)(����), 0001(1)(����), 0000(0)(�ѷ�/����) */
	public void classification(int value) {
		switch (value) {
		case 0:  // 0000
			System.out.print("���� ��õ�ϴ� �оߴ� �ѷ�(����) �Դϴ�.\n�� �������� ��õ�ϴ� �оߴ� �����Դϴ�.");
			break;
		case 1:  // 0001
			System.out.print("���� ��õ�ϴ� �оߴ� ���� �Դϴ�.\n�� �������� ��õ�ϴ� �оߴ� �ѷ�(����) �Դϴ�.");
			break;
		case 2:  // 0010
			System.out.print("���� ��õ�ϴ� �оߴ� ���� �Դϴ�.\n�� �������� ��õ�ϴ� �оߴ� ���� �Դϴ�.");
			break;
		case 4:  // 0100
			System.out.print("���� ��õ�ϴ� �оߴ� ��� �Դϴ�.\n�� �������� ��õ�ϴ� �оߴ� ���� �Դϴ�.");
			break;
		case 5:  // 0101
			System.out.print("���� ��õ�ϴ� �оߴ� ���� �Դϴ�.\n�� �������� ��õ�ϴ� �оߴ� ��� �Դϴ�.");
			break;
		case 6:  // 0110
			System.out.print("���� ��õ�ϴ� �оߴ� ö�� �Դϴ�.\n�� �������� ��õ�ϴ� �оߴ� ���� �Դϴ�.");
			break;
		case 7:  // 0111
			System.out.print("���� ��õ�ϴ� �оߴ� ���� �Դϴ�.\n�� �������� ��õ�ϴ� �оߴ� ö�� �Դϴ�.");
			break;
		case 8:  // 1000
			System.out.print("���� ��õ�ϴ� �оߴ� ��ȸ���� �Դϴ�.\n�� �������� ��õ�ϴ� �оߴ� ������� �Դϴ�.");
			break;
		case 12:  // 1100
			System.out.print("���� ��õ�ϴ� �оߴ� �ڿ����� �Դϴ�.\n�� �������� ��õ�ϴ� �оߴ� ������� �Դϴ�.");
			break;
		case 14:  // 1110
			System.out.print("���� ��õ�ϴ� �оߴ� ������� �Դϴ�.\n�� �������� ��õ�ϴ� �оߴ� �ڿ����� �Դϴ�.");
			break;
		}
	}
	
}
