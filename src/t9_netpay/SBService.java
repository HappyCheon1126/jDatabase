package t9_netpay;

import java.util.ArrayList;
import java.util.Scanner;
 
/*
▶ 본봉테이블(bonbong)을 만든다. 필요한 필드로는, 직급(jikkub)필드와 본봉(bonbong)필드이다.
- 본봉테이블에 직급과 본봉을 '입력/수정/전체조회/삭제'할수있도록 만들어준다.
 */
public class SBService {
    Scanner scanner =new Scanner(System.in);
    SBDAO dao = new SBDAO();
    BonbongVO voB=null;
    SawonVO voS=null;
    
    int no;
    int res;
    String name="";
    String ans="N";
    String jikkub="";
    
		public void BonbongService() {

			System.out.println("\n\t\t* * * 급 여 관 리 자 * * *");
			System.out.println("=".repeat(60));
			System.out.print("1> 직급정보입력  2> 직급정보수정  3> 직급전체조회  4> 정보삭제   0>나가기 => ");
			no = scanner.nextInt();

			switch (no) {
				case 1:
					System.out.println("** 직급,급여 입력 처리 **");
		
					// 같은 직급 추가 불가처리 해야함
					System.out.print("직급 (직급의 이니셜 1단어) : ");
					jikkub = scanner.next().toUpperCase();

					/// 같은 이름의 직급있으면 걸러내기
					voB = dao.getSearchB(jikkub);
					if (voB.getJikkub() != null) {
						System.out.println("이미 존재하는 직급입니다. \n* * 등록 실패 * *");
						return;
					}

					voB.setJikkub(jikkub);

					System.out.print("해당 직급( " + jikkub + " )의 급여 : ");
					voB.setBonbong(scanner.nextInt());
					res = dao.setInputB(voB);
					if (res == 0)
						System.out.println("등록에 실패했습니다.");
					else
						System.out.println("정상적으로 등록을 완료했습니다.");

					break;
				case 2:
					// 수정하려면 먼저 찾아야함
					System.out.print("수정하고자 하는 직급을 입력하세요 : ");
					jikkub = scanner.next().toUpperCase();
					voB = dao.getSearchB(jikkub);
					if (voB.getJikkub() == null) {
						System.out.println("\n " + jikkub + " 는 잘못된 직급 입니다. . .");
						break;
					} else {
						System.out.println("해당직급의 새 직급명 > ");
						String newJikkub = scanner.next();
						System.out.println(newJikkub + " 의 본봉 입력 > ");
						int bonbong = scanner.nextInt();

						res = dao.setUpdateB(jikkub, newJikkub, bonbong);
						if (res == 0)
							System.out.println("직급의 수정에 실패했습니다.");
						else
							System.out.println("작업이 완료되었습니다.");
					}

					break;
				case 3:
					// 직급표일람
					ArrayList<BonbongVO> vos = dao.getListB();
					System.out.println("\n\t\t * * 직 급 표 일 람 * * ");
					System.out.println("=".repeat(60));
					System.out.println("\t직급명\t\t\t   본봉");
					System.out.println("=".repeat(60));

					for (int i = 0; i < vos.size(); i++) {
						voB = vos.get(i);
						System.out.print("\t  " + voB.getJikkub() + "\t");
						System.out.print("\t\t  " + voB.getBonbong() + "\n");
					}
					System.out.println("-".repeat(60));
					System.out.println("\t\t\t\t총 " + vos.size() + " 개의 직급이 있습니다.\n");

					break;
				case 4:
					// 삭제
					System.out.println("삭제하고자 하는 직급을 입력하세요 : ");
					jikkub = scanner.next().toUpperCase();
					voB = dao.getSearchB(jikkub);
					if (voB.getJikkub() == null) {
						System.out.println("\n " + jikkub + " 는 잘못된 직급 입니다. . .");
						break;
					} else {
						res = dao.setDeleteB(jikkub);
						System.out.println("해당 직급을 삭제했습니다.");
					}

					break;

				default:
					// 나가기
					break;
			}

		}
    
    public void SawonService() {
      System.out.println("\n\t\t* * * 사 원 관 리 자 * * *");
      System.out.println("=".repeat(60));
      System.out.print("1>정보입력  2>정보수정  3>정보삭제  4>전체조회  5>개별조회 \t0>나가기 => ");
      no=scanner.nextInt();
      
      switch (no) {
          case 1://입력
              
              while(true) {
                  
                  System.out.println("\n\t* * 사원 정보 신규 입력 * *");
                  //***동명이인, 본봉테이블에 없는 직급은 입력 안받을것임***
                  System.out.print("성명 : ");
                  name=scanner.next();
                  ////////////동명이인 비교(같은이름안받음)////////
                  voS=dao.getSearchS(name);
                  if(voS.getName()!=null) {
                      System.out.println("이미 같은 이름이 존재합니다.\n작업을 종료합니다.");
                      return;
                  }else voS.setName(name);
                  
                  //////////////이름입력끝////////////////
                  //////////직급비교(없는직급 안받음)//////////////////////
                  
                  System.out.print("직급 : ");
                  jikkub=scanner.next();
                  
                  voB=dao.getSearchB(jikkub);
                  //본봉테이블에 있는 직급이랑 비교해야함//
                  if(voB.getJikkub()==null) {
                      System.out.println("존재하지 않는 직급입니다.\n작업을 종료합니다.");
                      return;
                  }
                  voS.setJikkub(jikkub);
                  ///////////////////직급입력끝////////////////
                  System.out.print("특근시간 : ");
                  voS.setNight(scanner.nextInt());
                  
                  //////////////////입력완료/////////
                  int res=dao.setInputS(voS);
                  if(res==0)System.out.println("정상 등록 실패");
                  else System.out.println("정상 등록 되었습니다.");
                  System.out.print("계속 입력 하시겠습니까? (y/n) =>");
                  ans=scanner.next();
                  if(ans.toUpperCase().equals("N"))break;
              }
              break;
              
              
          case 2://수정
              System.out.println("\n\t* * 사원 정보 수정 * *");
              System.out.print("수정하고자 하는 사원의 이름을 입력하세요 =>");
              name = scanner.next();
              voS=dao.getSearchS(name);
              if(voS.getName()==null) {
                  System.out.println(name+" 님은 사원이 아닙니다. . .\n작업을 종료합니다.");
                  return;
              }else {
                  System.out.println("-".repeat(60));
                  System.out.println("사  번\t: "+voS.getSabun());
                  System.out.println("이  름\t: "+voS.getName());
                  System.out.println("직  급\t: "+voS.getJikkub());
                  System.out.println("특근시간\t: "+voS.getNight()+" 시간");
              }
              boolean run=true;
              String newName = voS.getName();
              jikkub = voS.getJikkub();
              int night = voS.getNight();
              
              re:while(run) {
                  System.out.println("-".repeat(60));
                  System.out.println("수정할 정보를 선택하세요");
                  System.out.print("1> 이름  2> 직급  3> 특근시간  0> 종료   => ");
                  no=scanner.nextInt();
                  
                  
                  ///수정할때도 이름 중복 허용안할것임
                  ///직급도 없는 직급은 안받을것임!!
                  
                  switch (no) {
                      case 1:
                          System.out.print("\n이름 수정 => ");
                          newName=scanner.next();
                          
                          voS=dao.getSearchS(newName);
                          if(voS.getName()!=null) {
                              System.out.println("이미 같은 이름이 존재합니다.\n작업을 종료합니다.");
                              continue re;
                          }
                          break;
                          
                      case 2:
                          System.out.print("\n직급 수정 => ");
                          jikkub=scanner.next();
                          voB=dao.getSearchB(jikkub);
                          //본봉테이블에 있는 직급이랑 비교해야함//
                          if(voB.getJikkub()==null) {
                              System.out.println("존재하지 않는 직급입니다.\n작업을 종료합니다.");
                              continue re;
                          }
                          break;
                      case 3:
                          System.out.print("\n특근시간 => ");
                          night=scanner.nextInt();
                          break;
                          
                      default:
                          run=false;
                  }
                  ////////정보 수정하는 메소드////////
                  int res=dao.setUpdateS(newName,jikkub,night,name);
                  if(res==0)System.out.println("점수 수정에 실패했습니다. . .");
                  else System.out.println("작업 완료 . . .");
              }
              
              
              
              break;
          case 3://삭제
              System.out.println("자료를 삭제할 사원의 이름을 입력하세요 =>");
              name = scanner.next();
              voS=dao.getSearchS(name);
              if(voS.getName()==null) {
                  System.out.println(name+" 님은 사원이 아닙니다. . .\n작업을 종료합니다.");
                  return;
              }else {
                  System.out.println(name+"님의 자료를 정말 삭제할까요? (y/n) =>");
                  ans=scanner.next();
                  if(ans.toUpperCase().equals("Y")) {
                      System.out.println(name+"님의 자료를 삭제합니다.");
                      dao.setDeleteS(name);
                  }else System.out.println("자료의 삭제를 취소합니다. \n작업을 종료합니다.");
              }
              break;
              
              
              
          case 4://전체조회
              ArrayList<SawonVO> vosS = dao.getListS();
              ArrayList<BonbongVO> vosB =dao.getListB();
               //사원직급<=>본봉직급 비교로 해당직급의 본봉을 출력
              System.out.println("\n\t\t* * * 사 원 명 단 * * *");
              System.out.println("=".repeat(60));
              System.out.println("사번\t이름\t직급명\t특근\t 본봉\t 공제액\t 실수령액");
              System.out.println("-".repeat(60));
              
              for(int i=0; i<vosS.size(); i++){
                  voS=vosS.get(i);
                  System.out.print(voS.getSabun()+"\t");
                  System.out.print(voS.getName()+"\t");
                  System.out.print(voS.getJikkub()+"\t");
                  System.out.print(voS.getNight()+" 시간\t");
                  /////사원의 직급과 비교하고 해당직급의 본봉 출력하기/////////
                  for(int j=0; j<vosB.size(); j++) {
                      voB=vosB.get(j);
                      if(voS.getJikkub().equals(voB.getJikkub())) {
                          calc(voS, voB.getBonbong());
                          //계산용..
                          System.out.print(voB.getBonbong()+"\t");
                      }
                  }
                  //////////////////////////////////////////////
                  System.out.print(voS.getTax()+"\t");
                  System.out.print(voS.getSalary()+"\n");
                  
              }
              
              System.out.println("-".repeat(60));
              System.out.println("\t\t\t\t\t 총원 "+vosS.size()+" 명");
              System.out.println("=".repeat(60));
              break;
              
              
          case 5://개별조회
              vosB=dao.getListB();
              //사원 본봉 볼때마다 본봉리스트 불러와서 비교해야함...
              
              System.out.println("\n\t\t* * * 사 원 조 회 * * *");
              while(true) {
                  System.out.print("\n 조회하고자 하는 사원의 이름을 입력 하세요 =>");
                  name=scanner.next();
                  
                  voS=dao.getSearchS(name);
                  if(voS!=null) {
                      System.out.println("사  번\t: "+voS.getSabun());
                      System.out.println("이  름\t: "+voS.getName());
                      System.out.println("직  급\t: "+voS.getJikkub());
                      System.out.println("특근시간\t: "+voS.getNight()+" 시간");
                      //////////본봉출력용;///////
                      for(int i=0; i<vosB.size(); i++) {
                          voB=vosB.get(i);
                          if(voS.getJikkub().equals(voB.getJikkub())) {
                              calc(voS, voB.getBonbong());
                              //계산용..
                              System.out.print("본  봉\t:"+voB.getBonbong());
                          }
                      }
                      /////////////////////////////
                      System.out.println("공제액\t:"+voS.getTax()+"\t");
                      System.out.println("실수령액\t:"+voS.getSalary()+"\n");
                  } else System.out.println(name+"님의 자료가 없습니다. . .");
                  System.out.print("계속 검색 하시겠습니까? (y/n) =>");
                  ans=scanner.next();
                  if(ans.toUpperCase().equals("N"))break;
                  
              }
              break;

          default:
              break;
      }
      
  }
    
  // 급여 계산 처리..
  private void calc(SawonVO voS, int bonbong) {
      int sudang=(voS.getNight()*25000);
      //voS.setBonbong(voB.getBonbong());
      voS.setBonbong(bonbong);
      voS.setTax((int)( (voS.getBonbong()+sudang)*0.1) );
      voS.setSalary(voS.getBonbong()+sudang-voS.getTax());
  }
}