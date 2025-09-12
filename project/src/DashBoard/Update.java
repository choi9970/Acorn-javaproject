package DashBoard;


import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Update {

    private Scanner sc;

    public Update(Scanner sc) {
        this.sc = sc;
    }

    // 게시글 수정하기
    public void postUpdate() {
        List<Board> list = FileManager.loadData(); 

        if (list.isEmpty()) {
            System.out.println("[ 등록된 게시글이 없습니다 ]");
            return;
        }

        // 전체 목록
        postShowAll(list);

        System.out.print("☑ 수정할 게시글 번호 입력: ");
        String strId = sc.nextLine();
        int updateId = Integer.parseInt(strId);

        try {
            updateId = Integer.parseInt(strId);
            
        } catch (NumberFormatException e) {
        	
            System.out.println("[ ❌ 숫자를 입력해야 합니다. ]");
            return;
        }

        // 게시글 찾기
        Board boardToUpdate = null;
        for (Board board : list) {
            if (board.getId() == updateId) {
                boardToUpdate = board;
                break;
            }
        }

        if (boardToUpdate == null) {
            System.out.println("[ 해당 번호의 게시글이 존재하지 않습니다 ]");
            return;
        }

        System.out.println("\n───────────────────────────────");
        System.out.print("📝 새 제목 입력: ");
        String newTitle = sc.nextLine();

        System.out.print("💬 새 내용 입력: ");
        String newContent = sc.nextLine();
        System.out.println("\n───────────────────────────────");

        // 업데이트
        boardToUpdate.setTitle(newTitle);
        boardToUpdate.setContent(newContent);
        boardToUpdate.setRegDate(new Date());
    

        // 변경 후 저장
        FileManager.saveData(list);
        FileManager.saveData(list);
        System.out.println("[ ✏ 게시글 " + updateId + "번이 수정되었습니다. ]");
    }

    // 게시글 출력
    private void postShowAll(List<Board> list) {
        Board.printHeader();
        for (Board board : list) {
            System.out.println(board);
        }
        Board.printFooter();
    }
}
