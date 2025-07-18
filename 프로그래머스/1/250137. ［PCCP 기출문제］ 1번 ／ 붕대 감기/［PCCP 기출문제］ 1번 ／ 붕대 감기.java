public class Solution {
    public int solution(int[] bandage, int health, int[][] attack) {
        int t = bandage[0]; // 시전 시간
        int x = bandage[1]; // 시간당 회복량
        int y = bandage[2]; // 추가 회복량

        int currentHealth = health;

        int length = attack.length;
        int count = attack[length - 1][0];
        int[] game = new int[count+1];

        for (int[] a : attack) {
          game[a[0]] = a[1];
        }
        int stack = 0;
        for(int i = 1; i < game.length; i++) {
          // 공격 당함
          if(game[i] != 0) {
            currentHealth -= game[i];
            if(currentHealth < 0) {
              return -1;
            }
            stack = 0;
          }
          // 회복할 수 있음
          else {
            currentHealth += x;
            stack++;
            if(stack == t) {
              currentHealth += y;
              stack = 0;
            }
            currentHealth = Math.min(currentHealth, health);
          }
        }

        return currentHealth <= 0 ? -1 : currentHealth;
    }
}
