package practice;

public interface Car {

    void getCar();

    public static void main(String[] args) {
        Car c ;

        c = new Tata();
        c.getCar();
        //c.getTata();

        c = new Hyudndai();
        c.getCar();

    }

}

class Tata implements Car {

final public void hi(){
    System.out.println("tata");
}

    String j = "10";
    int f = Integer.parseInt(j);
    int h = Integer.parseInt(j)*20;


    public void getCar(){
        System.out.println("this is from tata");
    }

    void getTata(){
        System.out.println("this is from getTata");
    }
}

class Hyudndai implements Car{

    public void hi(){
        System.out.println("tata");
    }
    public void getCar(){
        System.out.println("this is from Hyudndai");
    }
}