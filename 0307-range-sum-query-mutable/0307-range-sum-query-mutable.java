class NumArray {
    int[] search;
    int[] nums;

    public NumArray(int[] nums) {
        search = new int[4 * nums.length + 1];
        this.nums = nums;
        insert(0, 0, nums.length - 1);
    }

    int insert(int pos, int start, int end) {
        if (start == end) {
            search[pos] = nums[start];
            return search[pos];
        }
        int mid = start + (end - start) / 2;

        search[pos] = insert(2 * pos + 1, start, mid) + insert(2 * pos + 2, mid + 1, end);
        return search[pos];
    }

    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        update(0, nums.length - 1, index, 0, diff);
    }

    void update(int start, int end, int index, int pos, int diff) {
        if (start > index || end < index) return;
        search[pos] = search[pos] + diff;
        int mid = start + (end - start) / 2;
        if (start != end) {
            update(start, mid, index, 2 * pos + 1, diff);
            update(mid + 1, end, index, 2 * pos + 2, diff);
        }
    }

    public int query(int left, int right, int ss, int se, int pos) {
        if (ss >= left && se <= right) {
            return search[pos];
        }
        if (ss > right || se < left) return 0;
        int mid = ss + (se - ss) / 2;

        return query(left, right, ss, mid, 2 * pos + 1) + query(left, right, mid + 1, se, 2 * pos + 2);
    }

    public int sumRange(int left, int right) {
        if (left < 0 || right > nums.length - 1 || left > right) return -1;
        return query(left, right, 0, nums.length - 1, 0);
    }
}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
