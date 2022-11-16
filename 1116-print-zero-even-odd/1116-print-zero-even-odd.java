class ZeroEvenOdd {
    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    Semaphore zero = new Semaphore(1);
    Semaphore odd = new Semaphore(0);
    Semaphore even = new Semaphore(0);
  

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
         boolean bol = false;
        for (int i = 0; i < n ; i++) {
            zero.acquire();
            printNumber.accept(0);
            if (bol) {
                even.release();
            } else {
                odd.release();
            }
            bol = !bol;
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n ; i = i + 2) {
            even.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n ; i = i + 2) {
            odd.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }
}
