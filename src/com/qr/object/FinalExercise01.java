package com.qr.object;

public class FinalExercise01 {

    public static void main(String[] args) {
        System.out.println(new FinalExercise().radius);
    }


}

class FinalExercise {
    public double radius;
    public final double PI = 3.14;

    {
        radius = 15;
    }
    FinalExercise(){
        radius = 16;
    }

    public  double calculate(){
        radius = 17;
        return radius * radius * PI;
    }
}
