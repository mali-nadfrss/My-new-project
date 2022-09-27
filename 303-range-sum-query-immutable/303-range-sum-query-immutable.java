class NumArray {

    int[] n;
    int len;
    public NumArray(int[] nums) {
        n = new int[nums.length*4];
        len = nums.length;
        update(0, nums.length-1, 0, nums);
        
    }
    
    void update(int low, int high, int index, int[] nums){
     
        if(low == high){
            n[index] = nums[low];
            return;
        }
        
        int mid = (low+high)/2;
        update(low, mid, 2*index+1, nums);
        update(mid+1,high, 2*index+2, nums);
        n[index] = n[2*index+1]+n[2*index+2];
        
    }
    
    int query(int low, int high, int qleft , int qright, int index){
        if(qleft > high || qright < low) return 0;
        
        if(low >= qleft && high <= qright){
            return n[index];
        }
        int mid = (high-low)/2 +low;
        
        if(qright <= mid){
            return query(low, mid, qleft, qright, 2*index+1);
        } else if(qleft > mid){
            return query(mid+1, high, qleft, qright, 2*index+2);
        }
        
        return query(mid+1, high, qleft, qright, 2*index+2)+
            query(low, mid, qleft, qright, 2*index+1);
        
        
    }
    
    public int sumRange(int left, int right) {
        return query(0, len-1, left, right, 0);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */