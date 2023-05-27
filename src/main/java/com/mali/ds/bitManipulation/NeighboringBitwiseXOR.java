package com.mali.ds.bitManipulation;


public class NeighboringBitwiseXOR {

    public static boolean doesValidArrayExist(int[] derived) {

        int len = derived.length;
        int[] in = new int[len];

        in[0] = 1;

        for(int i = 0; i < len-1 ; i++ ){
            if(derived[i] == 1){
                if(in[i] == 1){
                    in[i+1] = 0;
                } else{
                    in[i+1] = 1;
                }
            } else{
                if(in[i] == 1){
                    in[i+1] = 1;
                }else{
                    in[i+1] = 0;
                }
            }
        }

        boolean val1 = true;
        if(derived[len-1] == 1 && (in[len-1] == 1 && in[0]== 1 || in[len-1] == 0 && in[0]==0) ){
            val1= false;
        }

        if(derived[len-1] == 0 && (in[len-1] == 1 && in[0]== 0 || in[len-1] == 0 && in[0] == 1) ){
            val1= false;
        }
        in= new int[len];

        in[0] = 0;

        for(int i = 0; i < len-1 ; i++ ){
            if(derived[i] == 1){
                if(in[i] == 1){
                    in[i+1] = 0;
                }else{
                    in[i+1] = 1;
                }
            } else{
                if(in[i] == 1){
                    in[i+1] = 1;
                }else{
                    in[i+1] = 0;
                }

            }
        }
        boolean val2 = true;
        if(derived[len-1] == 1 && (in[len-1] == 1 && in[0]== 1 || in[len-1] == 0 && in[0]==0) ){
            val2= false;
        }

        if(derived[len-1] == 0 && (in[len-1] == 1 && in[0]== 0 || in[len-1] == 0 && in[0] == 1) ){
            val2= false;
        }

        return val1 || val2;


    }

  public static void main(String[] args) {
    doesValidArrayExist(new int[] {0, 1});
  }
}
