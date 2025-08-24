class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] success = new int[N];
        int[] current = new int[N+1];
        for(int i = 0; i < stages.length; i++) {
            stages[i] -= 1;
            for(int j = 0; j <= stages[i]; j++) {
                if(j < stages[i]) {
                    success[j] += 1;
                } else {
                    current[j] += 1;
                }
            }
        }
        
        double[] fail = new double[N];
        for(int i = 0; i < success.length; i++) {
            if(success[i] + current[i] == 0) {
                fail[i] = 0;
            } else {
                fail[i] = (double) current[i] / (success[i] + current[i]);
            }
            
        }
        // System.out.println();
        int answerIdx = 0;
        boolean[] check = new boolean[N];
        
        while(answerIdx < N) {
            double maxValue = -1;
            int maxIdx = -1;
            for(int i = 0; i < N; i++) {
                if(maxValue < fail[i] && !check[i]) {
                    maxValue = fail[i];
                    maxIdx = i;
                }
            }
            // System.out.println("maxIdx : " + (maxIdx+1) + ", maxValue : " + maxValue);
            answer[answerIdx] = maxIdx+1;
            check[maxIdx] = true;
            answerIdx++;
        }
        return answer;
    }
}