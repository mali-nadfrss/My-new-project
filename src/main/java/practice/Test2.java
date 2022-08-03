package practice;

public class Test2 extends Test1{

    public void add(){
        super.add();
        System.out.println(10-5+10);
    }

    public static void main(String[] args)  {
        Test2 hj = new Test2();
        hj.add();
    }
}
