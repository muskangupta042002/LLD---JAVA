package org.muskan.ducks;

public class TurkeyTestDrive {
    public static void main(String[] args) {
        MallardDuck mallardDuck = new MallardDuck();
        Turkey duckAdapter = new DuckAdapter(mallardDuck);
        for(int i=0;i<10;i++) {
            System.out.println("The DuckAdapter says...");
            duckAdapter.gobble();
            duckAdapter.fly();
        }
    }
}
