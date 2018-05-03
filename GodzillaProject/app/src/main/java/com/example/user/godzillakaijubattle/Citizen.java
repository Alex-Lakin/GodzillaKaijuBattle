package com.example.user.godzillakaijubattle;

import java.util.Random;

public class Citizen {
    private int nutritionalValue;
    private int groupSize;
    private int pos;

    public Citizen(int hp, int size, int pos){
        this.nutritionalValue = hp;
        this.groupSize = size;
        this.pos = pos;
    }

    public int getNutritionalValue() {
        return nutritionalValue;
    }

    public int getGroupSize(){
        return  groupSize;
    }

    public int getPos() {
        return pos;
    }

    public void moveToNewPosition(City city){
        Random rand = new Random();
        if (pos == 1){
            city.citizenEsacpes(this);
        } else if (pos == 2){
            int choice = rand.nextInt((3-1)+1)-1;
            if (choice == 1){pos = 1;}
            else if (choice == 2){pos = 17;}
            else {pos = 3;}
        } else if (pos == 3){
            int choice = rand.nextInt((3-1)+1)-1;
            if (choice == 1){pos = 2;}
            else if (choice == 2){pos = 20;}
            else {pos = 4;}
        } else if (pos == 4){
            int choice = rand.nextInt((3-1)+1)-1;
            if (choice == 1){pos = 21;}
            else if (choice == 2){pos = 5;}
            else {pos = 3;}
        } else if (pos == 5){
            city.citizenEsacpes(this);
        } else if (pos == 6){
            int choice = rand.nextInt((3-1)+1)-1;
            if (choice == 1){pos = 5;}
            else if (choice == 2){pos = 21;}
            else {pos = 7;}
        } else if (pos == 7){
            int choice = rand.nextInt((3-1)+1)-1;
            if (choice == 1){pos = 6;}
            else if (choice == 2){pos = 22;}
            else {pos = 8;}
        } else if (pos == 8){
            int choice = rand.nextInt((2-1)+1)-1;
            if (choice == 1){pos = 6;}
            else {pos = 9;}
        } else if (pos == 9){
            city.citizenEsacpes(this);
        } else if (pos == 10){
            city.citizenEsacpes(this);
        } else if (pos == 11){
            int choice = rand.nextInt((3-1)+1)-1;
            if (choice == 1){pos = 10;}
            else if (choice == 2){pos = 23;}
            else {pos = 12;}
        } else if (pos == 12){
            city.citizenEsacpes(this);
        } else if (pos == 13){
            int choice = rand.nextInt((4-1)+1)-1;
            if (choice == 1){pos = 12;}
            else if (choice == 2){pos = 23;}
            else if (choice == 3){pos = 18;}
            else {pos = 14;}
        } else if (pos == 14){
            city.citizenEsacpes(this);
        } else if (pos == 15){
            city.citizenEsacpes(this);
        } else if (pos == 16){
            int choice = rand.nextInt((3-1)+1)-1;
            if (choice == 1){pos = 15;}
            else if (choice == 2){pos = 17;}
            else {pos = 1;}
        } else if (pos == 17){
            int choice = rand.nextInt((3-1)+1)-1;
            if (choice == 1){pos = 2;}
            else if (choice == 2){pos = 16;}
            else {pos = 18;}
        } else if (pos == 18){
            int choice = rand.nextInt((3-1)+1)-1;
            if (choice == 1){pos = 17;}
            else if (choice == 2){pos = 19;}
            else {pos = 13;}
        } else if (pos == 19){
            int choice = rand.nextInt((4-1)+1)-1;
            if (choice == 1){pos = 18;}
            else if (choice == 2){pos = 20;}
            else if (choice == 3){pos = 22;}
            else {pos = 23;}
        } else if (pos == 20){
            int choice = rand.nextInt((3-1)+1)-1;
            if (choice == 1){pos = 19;}
            else if (choice == 2){pos = 21;}
            else {pos = 3;}
        } else if (pos == 21){
            int choice = rand.nextInt((4-1)+1)-1;
            if (choice == 1){pos = 20;}
            else if (choice == 2){pos = 4;}
            else if (choice == 3){pos = 6;}
            else {pos = 22;}
        } else if (pos == 22){
            int choice = rand.nextInt((3-1)+1)-1;
            if (choice == 1){pos = 19;}
            else if (choice == 2){pos = 21;}
            else {pos = 7;}
        } else{ //pos==23
            int choice = rand.nextInt((3-1)+1)-1;
            if (choice == 1){pos = 11;}
            else if (choice == 2){pos = 13;}
            else {pos = 19;}
        }
    }
}
