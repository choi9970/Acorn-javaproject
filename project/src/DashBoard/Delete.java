package DashBoard;

import java.util.List;

public class Delete {
    public void delete(List<Board> boardList, int id, String fileName) {
        
        boolean removed = boardList.removeIf(board -> board.getId() == id);   //id값 비교 후 삭제

        if (removed) {
            System.out.println("게시글 " + id + "번이 삭제되었습니다.");
            // 삭제 후 CSV 파일 저장
           
        } else {
            System.out.println("해당 번호의 게시글이 존재하지 않습니다.");
        }
    }
}


//Delete delete = new Delete();
//int deleteId = 3;
//
////삭제 실행
//delete.deletePost(boardList, deleteId, "src/DataBase/data.csv");
//
////삭제 후 전체 목록 출력
//br.postShowAll();