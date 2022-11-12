class MedianFinder {
    PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> max = new PriorityQueue<>();

    public MedianFinder() {}

    public void addNum(int num) {
        min.offer(num);
        max.offer(min.poll());
        if (min.size() < max.size()) {
            min.offer(max.poll());
        }
    }

    public double findMedian() {
        if (min.size() == max.size()) {
            return (double) (min.peek() + max.peek()) / 2;
        }
        return min.peek();
    }
}
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
