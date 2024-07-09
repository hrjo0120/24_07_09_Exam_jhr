package org.koreait;

import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lastId = 0;
        List<Motivation> motivations = new ArrayList<>();
        System.out.println("== 명언 앱 실행 ==");

        while (true) {
            System.out.print("명령어) ");
            String cmd = sc.nextLine().trim();

            if (cmd.equals("exit")) {
                System.out.println("== 프로그램 종료 ==");
                break;
            } else if (cmd.length() == 0) {
                System.out.println("명령어를 입력하세요");
                continue;
            }

            if (cmd.equals("등록")) {
                int id = lastId + 1;
                LocalDateTime regDate = LocalDateTime.now();
                System.out.print("명언 : ");
                String content = sc.nextLine(); //명언
                System.out.print("작가 : ");
                String author = sc.nextLine();

                Motivation motivation = new Motivation(id, regDate, content, author);

                motivations.add(motivation);

                System.out.println(id + "번 명언이 등록되었습니다.");
                lastId++;
            } else if (cmd.equals("목록")) {
                System.out.println("번호  /  작가  /  명언");
                System.out.println("=".repeat(30));

                for (int i = motivations.size() - 1; i >= 0; i--) {
                    Motivation motivation = motivations.get(i);
                    System.out.printf("%d  /  %s  /  %s\n", motivation.getId(), motivation.getAuthor(), motivation.getContent());
                }
            } else if (cmd.startsWith("삭제")) {
                String[] cmdBits = cmd.split("\\?", 2);
                String actinoMethod = cmdBits[0];
                String[] paramBits = cmdBits[1].split("=", 2);

                int id = Integer.parseInt(paramBits[1]);

                Motivation foundMotivation = null;

                for (Motivation motivation : motivations) {
                    if (motivation.getId() == id) {
                        foundMotivation = motivation;
                        break;
                    }
                }
                if (foundMotivation == null) {
                    System.out.println(id + "번 명언은 존재하지 않습니다.");
                    continue;
                }

                motivations.remove(foundMotivation);
                System.out.println(id + "번 명언이 삭제되었습니다.");

            } else if (cmd.startsWith("상세보기")) {
                String[] cmdBits = cmd.split("\\?", 2);
                String actinoMethod = cmdBits[0];
                String[] paramBits = cmdBits[1].split("=", 2);

                int id = Integer.parseInt(paramBits[1]);

                Motivation foundMotivation = null;

                for (Motivation motivation : motivations) {
                    if (motivation.getId() == id) {
                        foundMotivation = motivation;
                        break;
                    }
                }
                if (foundMotivation == null) {
                    System.out.println(id + "번 명언은 존재하지 않습니다.");
                    continue;
                }

                System.out.println("번호 : " + foundMotivation.getId());
                System.out.println("날짜 : " + foundMotivation.getRegDate());
                System.out.println("작가 : " + foundMotivation.getAuthor());
                System.out.println("내용: " + foundMotivation.getContent());

            } else if (cmd.startsWith("수정")) {
                String[] cmdBits = cmd.split("\\?", 2);
                String actinoMethod = cmdBits[0];
                String[] paramBits = cmdBits[1].split("=", 2);

                int id = Integer.parseInt(paramBits[1]);

                Motivation foundMotivation = null;

                for (Motivation motivation : motivations) {
                    if (motivation.getId() == id) {
                        foundMotivation = motivation;
                        break;
                    }
                }
                if (foundMotivation == null) {
                    System.out.println(id + "번 명언은 존재하지 않습니다.");
                    continue;
                }

                System.out.println("명언(기존) : " + foundMotivation.getContent());
                System.out.println("작가(기존) : " + foundMotivation.getAuthor());

                System.out.print("명언 : ");
                String content = sc.nextLine(); //명언
                System.out.print("작가 : ");
                String author = sc.nextLine();

                foundMotivation.setContent(content);
                foundMotivation.setAuthor(author);
            }
        }
    }
}