class Solution {

    public String reverseParentheses(String s) {
        int len = s.length();
        int begin = 0;
        int end = 0;

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') begin = i;
            if (s.charAt(i) == ')') {
                end = i;
                StringBuilder sb = new StringBuilder();
                return reverseParentheses(s.substring(0, begin) 
                                          + sb.append(s, begin + 1, end).reverse() 
                                          + s.substring(end + 1, len));
            }
        }
        return s;
    }
}
