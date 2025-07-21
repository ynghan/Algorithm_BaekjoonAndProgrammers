import java.util.*;

class Solution {
    public String[] solution(String[] names) {
        int length = names.length;
        List<String> firstName = new ArrayList<>();
        int i = 0;
        while(i < length) {
            firstName.add(names[i]);
            i += 5;
        }
        return firstName.toArray(new String[0]);
    }
}