class Solution {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> list = new ArrayList<>();

        for (int i = 0; i < l.length; i++) {
            int[] arr = new int[r[i] - l[i] + 1];

            if (arr.length < 3) {
                list.add(true);
                continue;
            }
            for (int j = 0; j < arr.length; j++) {
                arr[j] = nums[j+l[i]];
            }
            Arrays.sort(arr);
            int diff = arr[1] - arr[0];
            boolean add = true;
            for (int k = 2; k < arr.length; k++) {
                if (arr[k] - arr[k - 1] != diff) {
                    add = false;
                    break;
                }
            }
            list.add(add);
        }

        return list;
    }
}
