import java.util.*;

class Solution {
    
    class File {
        char[] HEAD;
        int NUMBER;
        String original;
        
        public File() {}
        
        public File(char[] head, int number, String original) {
            this.HEAD = head;
            this.NUMBER = number;
            this.original = original;
        }
    }
    
    static class FileComparator implements Comparator<File> {
        @Override
        public int compare(File o1, File o2) {
            int cmp = new String(o1.HEAD).compareTo(new String(o2.HEAD));
            if (cmp == 0) return Integer.compare(o1.NUMBER, o2.NUMBER);
            return cmp;
        }
    }
    
    public String[] solution(String[] files) {
        File[] fileEntities = new File[files.length];
        
        for(int i = 0; i < files.length; i++) {
            String file = files[i];
            String lower = file.toLowerCase();
            
            int headEnd = 0;
            while(headEnd < lower.length() && !Character.isDigit(lower.charAt(headEnd))) headEnd++;
            char[] head = lower.substring(0, headEnd).toCharArray();
            int numEnd = headEnd;
            while(numEnd < lower.length() && Character.isDigit(lower.charAt(numEnd))) numEnd++;
            int number = Integer.parseInt(lower.substring(headEnd, numEnd));
            
            fileEntities[i] = new File(head, number, file);
        }
        
        Arrays.sort(fileEntities, new FileComparator());
        
        return Arrays.stream(fileEntities).map(f -> f.original).toArray(String[]::new);
    }
}