class Solution {

    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();

        String start = "";
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                if (start.length() > 0) {
                    stack.add(start);
                }
                start = "";
            } else {
                start = start + c;
            }
        }
        if (start.length() > 0) {
            stack.add(start);
        }

        String ans = "";
        while (!stack.isEmpty()) {
            ans = ans + stack.pop();
            ans = ans + " ";
        }

        return ans.trim();
    }
}
