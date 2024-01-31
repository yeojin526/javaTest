package Test1_CLI;

public class Message {
	private int empno; // 사원명
	private String changeAfter; // 변경 후
	private String menu; // 추가, 삭제, 변경
	private int result;

	void menuFail() {
		System.out.println("\n" + "[알림]존재하지 않는 메뉴입니다. 메뉴를 다시 선택하세요." + "\n");
	}

	void returnToMain() {
		System.out.println("\n" + "[알림]메인 메뉴로 돌아갑니다." + "\n");
	}

	void coiceMenu() {
		System.out.println("\n" + "원하시는 메뉴를 선택하세요. (계속하기: 1, 메인 메뉴로: 2)");
	}

	void mainMenu() {
		System.out.println("[메인 메뉴]");
		System.out.println("1. 추가 | 2. 삭제 | 3. 변경 | 4. 조회 | 5. 종료 ");
		System.out.println("------------------------------------------");
		inputChoice();
	}

	void inputField() {
		System.out.print("☞ 입력: " + "\t");
	}

	void inputChoice() {
		System.out.print("☞ 메뉴 선택: ");
	}
	
	void insertMenu() {
		System.out.println("\n" + "[추가 메뉴]");
		System.out.println("추가할 사원의 정보를 입력하세요.");
	}

	void updateMenu() {
		System.out.println("\n" + "[변경 메뉴]");
		System.out.println("1. 사원명 | 2. 직업 | 3. 관리자번호(네자리수) | 4. 연봉 | 5. 성과금 | 6. 부서번호(두자리수) ");
		System.out.println("---------------------------------------------------------------------------");
		inputChoice();
	}

	void selectMenu() {
		System.out.println("\n" + "[조회 메뉴]");
		System.out.println("1. 전체 조회 | 2. 사원별 조회 ");
		System.out.println("------------------------------------------");
		inputChoice();
	}

	void dataFail(String menu) {
		System.out.println("\n" + "[알림]데이터 " + menu + "에 실패하였습니다.");
	}

	void dataSuccess(int empno, String menu) {
		System.out.println("\n" + "[알림]'" + empno + "'번 사원의 정보가 성공적으로 " + menu + "되었습니다. ");
	}

	void updateMessage(int result, String changeAfter) {
		System.out.println("(" + result + "개의 정보가 '" + changeAfter + "'로 변경됨)");
	}
}
