import java.util.Scanner;

public class recommend {
	
	public static void main(String[] args) {
		
		String answer;
		int recommendValue = 0;
		Scanner sc = new Scanner(System.in);
		QnA myQnA = new QnA();
		
		/* 1�� ���� */
		System.out.print("������ Ž��, ������  �߱�?(y/n)\n");
		answer = sc.next();
		/* answer���� �߸��� �Է����� Ȯ�� */
		while ( !(answer.equals("y") || answer.equals("Y") || answer.equals("n") || answer.equals("N")) ) {
			System.out.println("�߸��� �Է��Դϴ�.");
			answer = sc.next();
		}
		myQnA.setQnA(answer, recommendValue);
		recommendValue = myQnA.processing();
		answer = "n";
		/* recommendValue���� 1 or 0 */
				
		/* 2�� ���� */
		switch(recommendValue) {
		case 0:
			System.out.print("�η��� �����뿡 ������?(y/n)\n");
			answer = sc.next();
			break;
		case 1:
			System.out.print("�ڿ��� ���� Ž���� ������ ���󺸴� ��ȣ?(y/n)\n");
			answer = sc.next();
			break;			
		}
		/* answer���� �߸��� �Է����� Ȯ�� */
		while ( !(answer.equals("y") || answer.equals("Y") || answer.equals("n") || answer.equals("N")) ) {
			System.out.println("�߸��� �Է��Դϴ�.");
			answer = sc.next();
		}
		recommendValue <<= 1;  // ��Ʈ ����Ʈ
		myQnA.setQnA(answer, recommendValue);
		recommendValue = myQnA.processing();
		answer = "n";
		/* recommendValue���� 11, 10(��ȸ����), 01, 00 */
		
		/* 3�� ���� */
		switch(recommendValue) {
		case 0:  // 00
			System.out.print("�׸��̳� ���� ���� ���������� ������?(y/n)\n");
			answer = sc.next();
			break;
		case 1:  // 01
			System.out.print("����� ����?(y/n)\n");
			answer = sc.next();
			break;
		 // 10 (��ȸ����)
		case 3:  // 11
			System.out.print("�̷����ΰͺ��� �ǿ����ΰ��� ��ȣ?(y/n)\n");
			answer = sc.next();
			break;
		}
		/* answer���� �߸��� �Է����� Ȯ�� */
		while ( !(answer.equals("y") || answer.equals("Y") || answer.equals("n") || answer.equals("N")) ) {
			System.out.println("�߸��� �Է��Դϴ�.");
			answer = sc.next();
		}
		recommendValue <<= 1;  // ��Ʈ ����Ʈ
		myQnA.setQnA(answer, recommendValue);
		recommendValue = myQnA.processing();
		answer = "n";
		/* recommendValue���� 111, 110, 100(��ȸ����), 011, 010, 001(����), 000 */

		/* 4�� ���� */
		switch(recommendValue) {
		case 0: // 000
			System.out.print("���к��� ������ ��ȣ?(y/n)\n");
			answer = sc.next();
			break;
		// 001 (����)
		case 2: // 010
			System.out.print("���翡 ����?(y/n)\n");
			answer = sc.next();
			break;
		case 3: // 011
			System.out.print("���� ����?(y/n)\n");
			answer = sc.next();
			break;
		// 100 (��ȸ����)
		// 110 (�ڿ�����)
		// 111 (�������)
		}
		/* answer���� �߸��� �Է����� Ȯ�� */
		while ( !(answer.equals("y") || answer.equals("Y") || answer.equals("n") || answer.equals("N")) ) {
			System.out.println("�߸��� �Է��Դϴ�.");
			answer = sc.next();
		}
		recommendValue <<= 1;  // ��Ʈ ����Ʈ
		myQnA.setQnA(answer, recommendValue);
		recommendValue = myQnA.processing();
		answer = "n";
		/* recommendValue����
		 *  1110(14)(�������), 1100(12)(�ڿ�����), 1000(8)(��ȸ����), 0111(7)(����),
		 *  0110(6)(ö��), 0101(5)(����), 0100(4)(���), 0010(2)(����), 0001(1)(����), 0000(0)(�ѷ�/����) */
		
		/* ���� ��ȣ�帣 ���� */
		myQnA.classification(recommendValue);
		
	}
}
