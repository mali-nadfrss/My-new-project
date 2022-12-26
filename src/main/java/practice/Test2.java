package practice;

public  class Test2 {

    public void add(Test2 t){
        System.out.println("T2");
       // System.out.println(10-5+10);
    }

    public void add(){
        System.out.println("parent empty");
    }

    public static void main(String[] args)  {
        Test2 a =new Test2();
        Test2 b = new T1();
        a.add();
        b.add();
        b.add(b);
        b.add(a);
    }
}

class T1 extends  Test2{
    public void add(Test1 t){
        System.out.println("T1");
        System.out.println(10-5+10);
    }

    public void add(){
        System.out.println("sub empty");
    }
}
