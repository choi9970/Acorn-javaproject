package DashBoard;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
/**
 * 작성자 : 이혜린 내용 : 게시글 리스트 조회 및 상세보기
 */
public class BoardRead {
	Scanner sc = new Scanner(System.in);
	private List<Board> boardList = new ArrayList<Board>();

	//게시글 목록 불러오기
	public void loadData(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));

		String line;
		while ((line = br.readLine()) != null) {
			String[] parts = line.split(",");
			int id = Integer.parseInt(parts[0].trim());
			String title = parts[1].trim();
			String content = parts[2].trim();
			String writer = parts[3].trim();
			Date regDate = parseDate(parts[4].trim());

			Board board = new Board(id, title, content, writer, regDate);
			boardList.add(board);
		}
		br.close();
	}
	
	//게시글 조회 (사용자 입력 부분)
	public void postShowChoice() {
		System.out.println("\n┌───────────────────────────────┐");
	    System.out.println("│                         📖 게시글 조회 메뉴                          │");
	    System.out.println("├───────────────────────────────┤");
	    System.out.println("│                          [1] 전체 목록 조회                             │");
	    System.out.println("│                          [2] 게시글 상세보기                          │");
	    System.out.println("└───────────────────────────────┘");
	    System.out.print("👉 번호를 입력하세요: ");
		String  strListChoice = sc.next();
		
		try {
			int intListChoice = Integer.parseInt(strListChoice);
		
			if(intListChoice == 1) {
				System.out.println("\n📋 전체 게시글 목록\n");
				postShowAll();
				
			}else if(intListChoice == 2) {
				System.out.println("\n🔍 게시글 상세 조회");
		        System.out.print("👉 조회할 게시글 번호 입력: ");
				int num = sc.nextInt();
				postShowDetail(num);
			}else {
				System.out.println("\n\n⚠ 1, 2번만 선택할 수 있습니다. 다시 선택해주세요.\n");
			}
					
		}catch(NumberFormatException e) {
			System.out.println("\n⚠️숫자가 아닌 값을 입력했습니다.");
		}
		
	}

	//전체 목록 조회
	public void postShowAll() {
		if (boardList.isEmpty()) {
			System.out.println("\n\n⚠ 등록된 게시글이 없습니다.\n");
			return;
		}
		for (Board board : boardList) {
			System.out.println(board);
		}
	}

	//상세보기
	public void postShowDetail(int id) {
		for (Board board : boardList) {
			if (board.getId() == id) {
				System.out.println("\n┌───────────────────────────────┐");
	            System.out.println("│                          📌 게시글 상세보기                          │");
	            System.out.println("└───────────────────────────────┘");
				System.out.println("글번호: " + board.getId());
				System.out.println("제목: " + board.getTitle());
				System.out.println("작성자: " + board.getWriter());
				System.out.println("작성일: " + board.getRegDate());
				System.out.println("내용: " + board.getContent());
				return;
			}
		}
		System.out.println("해당 번호의 게시글이 존재하지 않습니다.");
	}
    public  Date parseDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            return sdf.parse(dateStr.trim());
        } catch (ParseException e) {
            e.printStackTrace();
            return null; // 변환 실패 시 null 반환
        }
    }

	
}
