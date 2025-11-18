import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> parking_map = new HashMap<>();
        Map<String, Integer> answer_map = new TreeMap<>();
        
        for (String record : records) {
            String[] rec = record.split(" ");
            int time = getTime(rec[0]);
            String car_number = rec[1];
            String type = rec[2];
            
            if ("IN".equals(type)) {
                parking_map.put(car_number, time);
            } else {
                int existing_answer = answer_map.getOrDefault(car_number, 0);
                answer_map.put(car_number, existing_answer + time - parking_map.get(car_number));
                parking_map.remove(car_number);
            }
        }
        
        // 출차 안된 차량 처리
        for (Map.Entry<String, Integer> map : parking_map.entrySet()) {
            String car_number = map.getKey();
            int existing_answer = answer_map.getOrDefault(car_number, 0);
            answer_map.put(car_number, existing_answer + 1439 - parking_map.get(car_number));
        }
        
        // 정답 배열
        int[] answer = new int[answer_map.size()];
        int i = 0;
        for (Map.Entry<String, Integer> map : answer_map.entrySet()) {
            answer[i++] = getPay(fees, map.getValue());
        }
        return answer;
    }
    
    public int getTime(String time) {
        return Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]);
    }
    
    public int getPay(int[] fees, int during) {
        int pay = 0;
        during = Math.max(0, during - fees[0]);
        pay += fees[1];
        
        if (during > 0) {
            pay += (int) (Math.ceil((double) during / fees[2])) * fees[3];
        }
        
        return pay;
    }
}