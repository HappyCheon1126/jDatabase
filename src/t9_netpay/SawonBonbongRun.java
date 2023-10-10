package t9_netpay;

import java.util.Scanner;

/*
 * 2. 급여계산하기
▶ 본봉테이블(bonbong)을 만든다. 필요한 필드로는, 직급(jikkub)필드와 본봉(bonbong)필드이다.
- 본봉테이블에 직급과 본봉을 '입력/수정/전체조회/삭제'할수있도록 만들어준다.
▶ 사원테이블(sawon)을 만든다.  필요한 필드로는, 사번(sabun), 성명(name), 직급(jikkub), 야근시간(night) 필드이다.
사원테이블에 자료를 '입력/수정/삭제/전체조회/개별조회' 할 수 있도록 프로그래밍하시오.
자료 입력시는 직급코드를 '숫자 or 문자'로 받아서 DB에는 한글로 입력처리하시오.(예:S 는 '사원', D는 '대리', 'K'는 '과장', 'B'는 부장...등.... 직급은 더 넣어도 상관없음. 단 동일 직급은 있을수 없다. 또한 야근 시간을 입력받는다.
  :  야근수당은 야근시간당 25000원으로 한다.
  :  공제액 = (본봉 + 수당)의 10%로 한다.
  :  실수령액 = (본봉 + 수당 ) - 공제액
  
 출력내용중, '전체조회/개별조회'시, 각 사원의 '수당'과 '공제액'과 '실수령액'을 함께 출력하시오.
 */
public class SawonBonbongRun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SBService service = new SBService();
        
        boolean run=true;
        System.out.println("\n\t\t * * * 급 여 계 산 기 * * *");
        while(run) {
            System.out.println("=".repeat(60));
            System.out.print("1> 급여관리 \t\t2> 사원관리 \t\t3> 작업종료 => ");
            int no=scanner.nextInt();
            switch (no) {
                case 1:
                    service.BonbongService();
                    break;
                case 2:
                    service.SawonService();
                    break;
                default:
                    run=false;
            }
        }
        System.out.println("\n 작업을 종료합니다. . . ");
        scanner.close();
        
    }
}