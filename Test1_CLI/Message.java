package Test1_CLI;

import java.util.Scanner;

public class Message { //메뉴 안내 & 각종 알림메세지
	Scanner sc = new Scanner(System.in);
	boolean run;

	void menuFail() { //메뉴 선택 실패
		System.out.println("\n" + "[알림]존재하지 않는 메뉴입니다. 메뉴를 다시 선택하세요." + "\n");
	}

	void returnToMain() { //메인메뉴로 돌아가기
		System.out.println("\n" + "[알림]메인 메뉴로 돌아갑니다." + "\n");
	}

	void mainMenu() { //메인 메뉴 안내
		System.out.println("[메인 메뉴]");
		System.out.println("1. 추가 | 2. 삭제 | 3. 변경 | 4. 조회 | 5. 종료 ");
		System.out.println("------------------------------------------");
		inputChoice();
	}

	void inputField() { //입력창 안내
		System.out.print("☞ 입력: " + "\t");
	}

	void inputChoice() { //입력창 안내2
		System.out.print("☞ 메뉴 선택: ");
	}
	
	void insertMenu() { //추가 메뉴 안내
		System.out.println("\n" + "[추가 메뉴]");
		System.out.println("추가할 사원의 정보를 입력하세요.");
	}

	void updateMenu() { //변경 메뉴 안내
		System.out.println("\n" + "[변경 메뉴]");
		System.out.println("1. 사원명 | 2. 직업 | 3. 관리자번호(네자리수) | 4. 연봉 | 5. 성과금 | 6. 부서번호(두자리수) ");
		System.out.println("---------------------------------------------------------------------------");
		inputChoice();
	}

	void selectMenu() { //조회 메뉴 안내
		System.out.println("\n" + "[조회 메뉴]");
		System.out.println("1. 전체 조회 | 2. 사원별 조회 ");
		System.out.println("------------------------------------------");
		inputChoice();
	}

	void dataFail(String menu) { //쿼리 실행 결과 '실패' 메세지
		System.out.println("\n" + "[알림]데이터 " + menu + "에 실패하였습니다.");
	}

	void dataSuccess(String empno, String menu) { //쿼리 실행 결과 '성공' 메세지
		System.out.println("\n" + "[알림]'" + empno + "'번 사원의 정보가 성공적으로 " + menu + "되었습니다. ");
	}

	void updateMessage(int result, String changeAfter) { //변경 쿼리 결과 안내 메세지
		System.out.println("(" + result + "개의 정보가 '" + changeAfter + "'로 변경됨)");
	}
}
