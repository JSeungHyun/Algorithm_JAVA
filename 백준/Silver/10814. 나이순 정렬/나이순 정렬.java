import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Member> memberList = new ArrayList<>();
        int index = 0;
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            memberList.add(new Member(age, name, index++));
        }
        memberList.sort(Member::compareMember);
        for (Member member : memberList) {
            System.out.println(member.age + " " + member.name);
        }
    }

    public static class Member {
        int age;
        String name;
        int index;
        public Member(int age, String name, int index) {
            this.age = age;
            this.name = name;
            this.index = index;
        }

        public static int compareMember(Member a, Member b) {
            if (a.age != b.age) return a.age - b.age;
            return a.index - b.index;
        }
    }
}