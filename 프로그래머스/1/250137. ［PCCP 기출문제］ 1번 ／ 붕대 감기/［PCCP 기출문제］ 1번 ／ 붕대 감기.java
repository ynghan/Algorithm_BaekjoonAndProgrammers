
// bandage : [시전시간, 초당 회복량, 추가 회복량]
// health : 캐릭터 최대 체력
// attacks : [몬스터 공격 시간, 피해량]
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        // 현재 체력
        int currentHP = health;
        
        // 연속 성공 카운팅 변수
        int count = 0;
        
        // 0초부터 몬스터 마지막 공격 시간까지 반복
        int lastAttack = attacks[attacks.length - 1][0];
        
        // 몬스터의 다음 공격을 가리키는 인덱스 선언
        int idx = 0;
        
        for(int i = 1; i <= lastAttack; i++) {
            // 몬스터 공격 있는지 확인
            if(attacks[idx][0] == i) {
                // 공격하기
                if(currentHP - attacks[idx][1] <= 0) {
                    return -1;
                } else {
                    currentHP -= attacks[idx][1];
                }
                // 다음 공격 인덱스로 이동
                idx++;
                // 연속 카운팅 초기화
                count = 0;
                // 체력 회복하면 안되니까 다음 반복문으로 가기
                continue;
            }
            // 카운팅하기
            count++;
            // 최대 체력 제한
            currentHP = currentHP + bandage[1] <= health ? currentHP + bandage[1] : health;
            // 연속 성공 -> 추가 회복
            if(count == bandage[0]) {
                currentHP = currentHP + bandage[2] <= health ? currentHP + bandage[2] : health;
                // 카운팅 초기화
                count = 0;
            }
        }
        return currentHP;
    }
}