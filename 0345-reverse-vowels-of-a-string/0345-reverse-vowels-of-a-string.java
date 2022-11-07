class Solution {
    public String reverseVowels(String s) {
        
        Set<Character> set = new HashSet();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
       int start = 0;
        int end = s.length()-1;
        while(start < end){
            
            if(!set.contains(s.charAt(start))){
                start++;
            }
            if(!set.contains(s.charAt(end))){
                end--;
            }
            if(set.contains(s.charAt(start)) && set.contains(s.charAt(end))){
                char k = s.charAt(end);
                StringBuilder sb = new StringBuilder(s);
                sb.setCharAt(end, s.charAt(start));
                sb.setCharAt(start, k);
                s = sb.toString();
                start++;
                end--;
            }
            
        }
        
        return s;
        
    }
}