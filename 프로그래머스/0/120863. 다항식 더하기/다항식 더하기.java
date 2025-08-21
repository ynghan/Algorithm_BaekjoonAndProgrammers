class Solution {
    public String solution(String polynomial) {
        String answer = "";
        String[] strArr = polynomial.split(" ");
        StringBuilder sb = new StringBuilder();
        
        int coefficient = 0;
        int constant = 0;
        for(int i = 0; i < strArr.length; i++) {
            if(strArr[i].contains("x")) {
                String s = strArr[i].substring(0, strArr[i].length()-1);
                if(s.isEmpty()) {
                    coefficient += 1;
                } else {
                    coefficient += Integer.parseInt(s); 
                }
            } else if(strArr[i].contains("+")) {
                continue;
            } else {
                constant += Integer.parseInt(strArr[i]);
            }
        }
        if(coefficient != 0) {
            if(coefficient == 1) {
                sb.append("x");
            } else {
                sb.append(coefficient + "x");
            }
        }
        if(constant != 0) {
            if(sb.toString().isEmpty()) {
                sb.append(constant);            
            } else {
                sb.append(" + " + constant);
            }
        }
        
        return sb.toString().isEmpty() ? "0" : sb.toString();
    }
}