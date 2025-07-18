
class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 시간을 초 단위로 변환
        int videoTotalSeconds = timeToSeconds(video_len);
        int currentSeconds = timeToSeconds(pos);
        int opStartSeconds = timeToSeconds(op_start);
        int opEndSeconds = timeToSeconds(op_end);
        
        // 현재 위치가 오프닝 구간인지 확인
        if (currentSeconds >= opStartSeconds && currentSeconds < opEndSeconds) {
            currentSeconds = opEndSeconds;
        }
        
        for (String command : commands) {
            // next 또는 prev 명령 처리
            if (command.equals("next")) {
                currentSeconds += 10;
            } else if (command.equals("prev")) {
                currentSeconds -= 10;
            }
            
            // 범위 체크 (0초 ~ 비디오 길이)
            if (currentSeconds < 0) {
                currentSeconds = 0;
            } else if (currentSeconds > videoTotalSeconds) {
                currentSeconds = videoTotalSeconds;
            }
            
            // 오프닝 구간 스킵
            if (currentSeconds >= opStartSeconds && currentSeconds < opEndSeconds) {
                currentSeconds = opEndSeconds;
            }
            
            // 다시 범위 체크 (오프닝 스킵 후)
            if (currentSeconds > videoTotalSeconds) {
                currentSeconds = videoTotalSeconds;
            }
        }
        
        return secondsToTime(currentSeconds);
    }
    
    // 시간 문자열을 초 단위로 변환
    private int timeToSeconds(String timeStr) {
        String[] parts = timeStr.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return minutes * 60 + seconds;
    }
    
    // 초 단위를 시간 문자열로 변환
    private String secondsToTime(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}