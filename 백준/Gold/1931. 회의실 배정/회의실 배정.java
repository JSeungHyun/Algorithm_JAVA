import java.util.*;
import java.io.*;

class Meeting implements Comparable<Meeting> {
    long start;
    long end;

    public Meeting(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
        // 종료시간이 같다면 시작시간기준 오름차순
        if (this.end == o.end) {
            return Long.compare(this.start, o.start);
        }
        return Long.compare(this.end, o.end);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Meeting> meetings = new ArrayList<>();
        
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long s = Long.parseLong(st.nextToken());
            long e = Long.parseLong(st.nextToken());
            
            meetings.add(new Meeting(s, e));
        }
        
        Collections.sort(meetings);
        int count = 0;
        long lastEndTime = 0;

        for (Meeting m : meetings) {
            if (m.start >= lastEndTime) {
                lastEndTime = m.end;
                count++;
            }
        }

        System.out.println(count);
    }
}