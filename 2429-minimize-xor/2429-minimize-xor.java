class Solution {

    public int minimizeXor(int num1, int num2) {
        int setbits = 1;
        while (num2 > 1) {
            if ((num2 & 1) > 0) {
                setbits++;
            }
            num2 = num2 >> 1;
        }

        StringBuilder s = new StringBuilder(Integer.toBinaryString(num1));
        int i = 0;
        StringBuilder ans = new StringBuilder();

        for (int j = 0; j < Math.max(s.length(), setbits); j++) {
            ans.append('0');
        }

        while (i < s.length() && setbits > 0) {
            if (s.charAt(i) == '1') {
                setbits--;
                ans.setCharAt(i, '1');
            }
            i++;
        }
        ans.reverse();
        i = 0;
        while (setbits > 0) {
            if (ans.charAt(i) == '0') {
                ans.setCharAt(i, '1');
                setbits--;
            }
            i++;
        }
        ans.reverse();
        int m = 1;
        for (int j = 1; j < ans.length(); j++) {
            m = m << 1;
            if (ans.charAt(j) == '1') {
                m++;
            }
        }
        return m;
    }
}
