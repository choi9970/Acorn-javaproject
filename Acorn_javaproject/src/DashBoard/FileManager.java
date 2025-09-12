package DashBoard;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FileManager {

    private static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String FILE_DATA="DataBase/data.csv";

    // 데이터 저장 (덮어쓰기 모드)
    public static void saveData(List<Board> boardList) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_DATA))) {
            for (Board board : boardList) {
                bw.write(board.toCSV());
                bw.newLine();
            }
            System.out.println("데이터 저장 완료: " + FILE_DATA);
        } catch (IOException e) {
            System.out.println("파일 저장 오류: " + e.getMessage());
        }
    }

    // 데이터 불러오기
    public static List<Board> loadData() {
        List<Board> list = new ArrayList<>();
        File file = new File(FILE_DATA);

        if (!file.exists()) {
            return list; // 파일이 없으면 빈 리스트 반환
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0].trim());
                String title = parts[1].trim();
                String content = parts[2].trim();
                String writer = parts[3].trim();
                Date regDate = null;

                try {
                    regDate = sdf.parse(parts[4].trim());
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                list.add(new Board(id, title, content, writer, regDate));
            }
        } catch (IOException e) {
            System.out.println("파일 읽기 오류: " + e.getMessage());
        }
        return list;
    }
    
    
    public static void initFile() {
        try {
            // 폴더 생성
            File folder = new File("DataBase");
            if (!folder.exists()) {
                folder.mkdirs();
                System.out.println("폴더 생성됨: " + folder.getAbsolutePath());
            }

            // 파일 생성
            File file = new File(FILE_DATA);
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("파일 생성됨: " + file.getAbsolutePath());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
