//package view;
//
//import java.util.Scanner;
//
//public class Movie_single_game {
//
//	// 싱글게임 기회는 5번 힌트1번 주인공이름 제공 한번에 맞추면 10점 힌트보고 맞추면 5점
//		static boolean gameWon = false; //게임이 종료될때 사용되는 변수 답을 맞추면 true로 바뀌고 틀리면 false로 유지
//		static int attempts = 0; // 총 시도 횟수
//		static final int maxNumber = 3; // 최대 도전횟수 3번
//		static int score = 0; // 시작점수는 0점
//		static int maxScore = 10; // 문제를 힌트없이 맞추면 10점
//		static int hintScore = 5; // 힌트를 보고 맞추면 5점
//		static int WrongTake = -5; // 문제를 틀릴 시 -5점
//		static boolean toggle = true;
//		static boolean hintTaken = false; // 사용자가 힌트를 보았는지 여부를 나타내는 변수
//
//			
//			public static void main(String[] args) {
//				// 게임을 다시 할 것인지 물어봄
//				while (playGame()) {
//					// 게임이 종료되면 변수초기화
//					attempts = 0;
//					hintTaken = false;
//					toggle = true;
//					//WrongTake = false;
//				}
//				System.out.println("게임을 종료합니다");
//			}
//
//			// 게임 플레이하는 메소드
//			private static boolean playGame() {
//
//				// 영화 제목 배열
//				String[] movieTitles = { "변호인", "도둑들", "택시운전사", "기생충", "써니", "7번방의 선물", "국제시장", "명량", "극한직업", "신과함께" };
//
//				// 랜덤으로 영화 선택
//				int randomIndex = (int) (Math.random() * movieTitles.length);
//				String selectedMovie = movieTitles[randomIndex].toUpperCase(); // 대소문자 구분 없이 맞출 수 있도록 대문자로 변환
//				
//				String[][] hintCharacter = { // 2차원배열로 각 영화의 주인공들
//						{"송강호","김영애","오달수","곽도원","임시완"}, // 변호인
//						{"김윤석","김혜수","이정재","전지현","김해숙","김수현"}, // 도둑들
//						{"송강호","유해진","류준열","토마스 크레취만"}, // 택시운전사
//						{"송강호","이정은","최우식","박소담","이선균","조여정"}, // 기생충
//						{"심은경","강소라","김민영","박진주","남보라","민효린"}, // 써니
//						{"류승룡","갈소원","박신혜","오달수","김정태"}, // 7번방의 선물
//						{"황정민","김윤진","오달수","정진영"}, // 국제시장
//						{"최민식","류승룡","조진웅"}, // 명량
//						{"류승룡","이하늬","진선규","이동휘","공명"}, // 극한직업
//						{"차태현","하정우","주지훈","김향기"} // 신과함께
//				};
//				
//				
//				// 게임 시작 메시지
//		        System.out.println("영화 제목 맞추기 게임을 시작합니다!");
//				System.out.println("영화의 제목은 " + selectedMovie.length() + "글자 입니다.");
//
//				// 사용자 입력 받기
//				Scanner scanner = new Scanner(System.in);
//
//				// 사용자에게 영화 제목을 맞추도록 함
//				while ((!gameWon && attempts < maxNumber) && toggle) {
//					int Remaining_Number = maxNumber - attempts; // 남은 도전횟수 보여주기
//					System.out.println("남은 시도 횟수: " + Remaining_Number);
//					System.out.print("영화 제목을 입력하세요: ");
//
//					String userGuess = scanner.nextLine(); // 대소문자 구분 없이 비교하기 위해 대문자로 변환
//					attempts++;
//
//					// while 문을 사용하여 정답 여부 확인
//					while (true) {
//						if (Remaining_Number < 0) {
//							System.out.println("3번 시도 동안 정답을 맞추지 못하였습니다.");
//							break;
//						} else {
//							// 사용자가 정답을 맞춘 경우
//							if (userGuess.equals(selectedMovie)) { // 정답일 경우
//								System.out.println("축하합니다! 영화 제목을 맞추셨습니다.");
//								
//								if(hintTaken) {
//									score += hintScore; // 힌트를 보고 맞추면 5점
//								}else {
//									score += maxScore; // 힌트 없이 맞추면 10점
//								}
//								System.out.println("현재 획득한 점수 : " + score);
//								
//								 // 사용자에게 게임을 다시 할 것인지 물어봄
//			                    System.out.print("게임을 다시 하시겠습니까? (y/n): ");
//		                        String playAgain = scanner.nextLine();
//
//			                    if (playAgain.equals("y")) {
//			                        // 새로운 문제 선택
//			                    	randomIndex = (int)(Math.random()* movieTitles.length);
//			                    	selectedMovie = movieTitles[randomIndex].toUpperCase();
//			                    	
//			                    	// 게임이 종료되면 변수 초기화
//			                        attempts = 0;
//			                        hintTaken = false;
//			                        toggle = true;
//			                        
//			                        // 새로운 문제의 글자 수 출력
//			                        System.out.println("영화의 제목은" + selectedMovie.length() + "글자 입니다.");
//			                    }else {
//			                    	return false;
//			                    }
//			                    break; // 내부 while 루프를 종료하고 외부 while 루프로 돌아감
//			                              
//								} else { // 정답이 아닐 경우
//								System.out.println("틀렸습니다. 다시 시도하세요.");
//								score -= WrongTake;
//								//틀릴 경우
//								score-=5;
//								
//								// 힌트 제공
//								if(attempts == 1) {
//									provideHint(hintCharacter, randomIndex);
//								}
//									
//								System.out.println("총 점수 : " + score);
//								break;
//							}
//
//						}
//
//					}
//				}
//				// 게임이 종료되면 변수 초기화
//				attempts = 0;
//				hintTaken = false;
//				toggle = true;
//				
//				// 다시 플레이할지 물어봄
//				System.out.print("게임을 다시 하시겠습니까? (y/n): ");
//				String playAgain = scanner.nextLine();
//				if (playAgain.equals("y")) {
//					return true;
//				} else
//					return false;
//			}
//				
//				// 힌트를 제공하는 메소드
//			    private static void provideHint(String[][] hintCharacter, int randomIndex) {
//			    	System.out.print("힌트: 주인공 이름은 " ); 
//			    	for(int i = 0; i<hintCharacter[randomIndex].length; i++ ) {  
//			    	System.out.print(hintCharacter[randomIndex][i]+" ");
//			    }
//			        System.out.println("입니다");
//			        
//			        // 사용자가 힌트를 보았음을 표시
//			        hintTaken = true;
//			    }
//}
