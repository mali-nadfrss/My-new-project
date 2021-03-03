package com.mali;
/*
public class Test extends Max{

        public static void main(String [] args)
        {
            *//*int x = 0x80000000;
            System.out.print(x + " and ");
            x = x >>> 31;
            System.out.println(x);*//*

 *//*String __$1____str="These Variables!";
            String $s=__$1___str;
            int a=31,b=a++;
            int @q=12;
            if ($s=="These Variables")
                System.out.println("True");
            else
                System.out.println("False");*//*
 *//*int A1[] = {1, 2, 3};
            int A2[] = {1, 2, 3};
            if (A1.equals(A2))
                System.out.println("Same");
            else
                System.out.println("Not same");*//*

            Test test = new Test();
            String Push = null;
            if(Push!="null")
                System.out.print("Passed");
            else
                System.out.print("Failed");
            test.Pass(Push);
            System.out.print(Push);
        }

    public void Pass(String arg)
    {
        arg = "You've got it in you!!";
    }
    public static int method()
    {
        try
        {
            System.out.println("try");
            int x =33/0;
            System.out.println(11);
            return 11;
        }
        catch(Exception e)
        {
            System.out.println("catch");
            System.out.println(17);
            return 17;
        }
        finally
        {
            System.out.println("finally");
            System.out.println(88);
            return 88;
        }
    }

        99
  13       18
8    56
   12

}*/

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}

class Test {

    public static void main(String[] args) {
        //int[] arr = {4, 5, 6, 8};
        // System.out.print(subArraySum(arr, 7));
        Node root = new Node(99);
        root.right = new Node(108);
        root.left = new Node(13);
        root.left.right = new Node(7);
        root.left.left = new Node(8);
        System.out.print(isBST(root));
    }

    static boolean isBST(Node root) {
        return checkBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    /*
            99
   13
        78
8    56
        64
99,78,56
    * */
    static boolean checkBST(Node root, int max, int min) {
        if (root == null) {
            return true;
        }
        if (root.data > max || root.data < min) {
            return false;
        }
        boolean left = checkBST(root.left, root.data, min);
        boolean right = checkBST(root.right, max, root.data);
        return left && right;
    }


    /* 1, 2, 3 target 2 */
    static boolean subArraySum(int[] arr, int target) {
        int start = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum == target) {
                return true;
            }
            sum = sum + arr[i];
            if (sum > target) {
                while (sum > target && start < i) {
                    sum = sum - arr[start];
                    start++;
                }
            }
        }
        return sum == target;

    }


}
