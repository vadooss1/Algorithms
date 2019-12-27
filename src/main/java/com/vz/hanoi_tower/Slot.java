package com.vz.hanoi_tower;

public class Slot {
    protected int[] stack;
    protected int end;

    public Slot(int capacity) {
        if (capacity<=0){
            System.out.println("Error! Start from the 1");
        }else{
        stack = new int[capacity];
        end = 0;}
    }

    public void push(int plate){
        stack[end]=plate;
    end++;

    }
    public int pull(){
        end--;
        return stack[end];

    }
    public void loadSlot(int capacity){
        for (int i = 0; i < capacity; i++) {
            push(capacity-i);
        }
    }
    public int getlastPlate(){
        if(end>0){
        return stack[end-1];}else{
            return 0;
        }
    }

}
