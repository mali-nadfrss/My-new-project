class Solution {
    public long makeSimilar(int[] nums, int[] target) {
    Arrays.sort(nums);
    Arrays.sort(target);

    long ans = 0;
    List<Integer> oddNum = new ArrayList<>();
    List<Integer> evenNum = new ArrayList<>();
    List<Integer> oddTar = new ArrayList<>();
    List<Integer> evenTar = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] % 2 == 0) {
        oddNum.add(nums[i]);
      } else {
        evenNum.add(nums[i]);
      }
      if (target[i] % 2 == 0) {
        oddTar.add(target[i]);
      } else {
        evenTar.add(target[i]);
      }
    }

    for (int i = 0; i < oddNum.size(); i++) {
      ans += Math.abs((oddTar.get(i) - oddNum.get(i)) / 2);
    }

    for (int i = 0; i < evenNum.size(); i++) {
      ans += Math.abs((evenTar.get(i) - evenNum.get(i)) / 2);
    }
    return ans / 2;
    }
}