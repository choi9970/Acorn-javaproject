package DashBoard;


import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 2. 게시글 조회 인스턴스 선언
        BoardManager bm = new BoardManager();
        
        //데이터 베이스 경로 폴더 및 파일 확인
        FileManager.initFile();

        while (true) {
            System.out.println("\n┌───────────────────────────────┐");
            System.out.println("│                         📌 Main Menu                                 │");
            System.out.println("├───────────────────────────────┤");
            System.out.println("│                          [1] 게시글 작성                                  │");
            System.out.println("│                          [2] 게시글 조회                                  │");
            System.out.println("│                          [3] 게시글 수정                                  │");
            System.out.println("│                          [4] 게시글 삭제                                  │");
            System.out.println("│                          [5] 종료                                              │");
            System.out.println("└───────────────────────────────┘");
            System.out.print("👉 원하시는 메뉴 번호를 입력하세요: ");

            String strChoice = sc.nextLine(); // 숫자열로 받기

            try {
                int intChoice = Integer.parseInt(strChoice);

                switch (intChoice) {
                    // 1. 게시글 작성 (정문)
                    case 1:
                    	System.out.println();
                        System.out.println("\n┌───────────────────────────────┐");
                        System.out.println("                           📌 게시글 작성                                  ");
                        System.out.println("└───────────────────────────────┘");
                    	System.out.print("  [1] 글쓴이 : ");
            	        String writer=sc.nextLine();
                    	System.out.print("  [2]  제목 : ");
            	        String title=sc.nextLine();
            	        System.out.println(" ────────────────────────────────");
            	        System.out.print("  [3] 내용 : ");
            	        String content=sc.nextLine();
            	        System.out.println();
            	        System.out.println("└───────────────────────────────┘");
            	        System.out.println();
            	        
                        bm.postCreate(writer,title,content);
                        bm.postShowAll(); // 전체 글 목록 리스트 표시
                        break;

                    // 2. 게시글 조회 (혜린)
                    case 2:
                    	bm.postShowChoice();
                        break;

                    // 3. 게시글 수정 (태민)
                    case 3:
                    	
                    	bm.postUpdate(sc);
                    	break;

                    // 4. 게시글 삭제 (동규)
                    case 4:
                    	if (bm.postShowAll() == 1) {
                    		System.out.println();
                    		System.out.print("👉 삭제 게시글 번호 : ");
                    		int deleteNum = Integer.parseInt(sc.next());
                    		System.out.println();
                    		
                    		
                            bm.postDelete(deleteNum);
                            bm.postShowAll(); // 전체 글 목록 리스트 표시
						}
                        
                        break;

                    // 5. 프로그램 종료
                    case 5:
                        System.out.println("\n   😊프로그램을 종료합니다. 감사합니다!😊");
                        sc.close();
                        return;

                    default:
                        System.out.println("\n\n⚠️ 메뉴는 1 ~ 5번까지입니다. 다시 선택해주세요.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("\n⚠️ 숫자가 아닌 값을 입력했습니다.");
            }
        }
    }

    
}
