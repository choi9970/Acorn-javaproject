package DashBoard;

public class Main {

<<<<<<< Updated upstream
	public static void main(String[] args) {
		System.out.println("test");
=======
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		//2. 게시글 조회 테스트
		BoardRead br = new BoardRead();
		BoardManager bm = new BoardManager();
		br.loadData("DataBase/data.csv");
		
		while(true) {
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
			String strChoice = sc.next();				//숫자열로 받기
			
			try {
				int intChoice = Integer.parseInt(strChoice);				
				
				switch(intChoice) {
				//1. 게시글 작성 (정문)
				case 1:
					bm.postCreate();
					br.postShowAll();		// 전체 글 목록 리스트 표시
					break;
					
				//2. 게시글 조회 (혜린)
				case 2:
					br.postShowChoice();
					break;
					
				//3. 게시글 수정 (태민)
				case 3:
					
					br.postShowAll();		// 전체 글 목록 리스트 표시
					break;
					
				//4. 게시글 삭제 (동규)
				case 4:
					//삭제 메서드 호출
					//bm.postDelete();
					br.postShowAll();		// 전체 글 목록 리스트 표시
					break;
					
				//5. 프로그램 종료
				case 5:
					System.out.println("\n   😊프로그램을 종료합니다. 감사합니다!😊");
					sc.close();
					return;
				
				default:
					System.out.println("\n\n⚠️ 메뉴는 1 ~ 5번까지입니다. 다시 선택해주세요.\n");
				}
				
			}catch(NumberFormatException e) {
				System.out.println("\n⚠️숫자가 아닌 값을 입력했습니다.");
			}
			
		}
		
>>>>>>> Stashed changes

	}

}
