class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
    int[] answer = new int[progresses.length];

    int totalCount = 0;
    int idx = 0;
    int ans_idx = 0;
    int count = 0;
    int length = 0;

    while(totalCount < progresses.length) {
      int quotient = (100 - progresses[idx]) / speeds[idx];
      int remainder = (100 - progresses[idx]) % speeds[idx];

      if(remainder > 0) {
        quotient++;
      }

      for(int i = idx; i < progresses.length; i++) {
        progresses[i] += quotient * speeds[i];
      }

      for(int i = idx; i < progresses.length; i++) {
        if(progresses[i] >= 100) {
          count++;
        }
        else {
          break;
        }
      }

      idx += count;
      totalCount += count;
      answer[ans_idx++] = count;
      count = 0;
      length++;

    }

    int[] answer2 = new int[length];
    for (int i = 0; i < answer2.length ; i++) {
      answer2[i] = answer[i];
    } 
        
        return answer2;
    }
}