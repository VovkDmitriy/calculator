package com.gmail.dimavovk688.kalkulator;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.Observer;

public class Calculator implements Parcelable {
    private StringBuilder inNum;
    private StringBuilder task;
    private double firstNum;
    private double secondNum;
    private double result;
    private char nextOperation = 'a';

    public Calculator() {
        this.inNum = new StringBuilder("0");
        this.task = new StringBuilder("0");
        this.result = 0;
        this.firstNum = 0;
        this.secondNum = 0;
    }

    protected Calculator(Parcel in) {
        firstNum = in.readDouble();
        secondNum = in.readDouble();
        result = in.readDouble();
        nextOperation = (char) in.readInt();
    }

    public static final Creator<Calculator> CREATOR = new Creator<Calculator>() {
        @Override
        public Calculator createFromParcel(Parcel in) {
            return new Calculator(in);
        }

        @Override
        public Calculator[] newArray(int size) {
            return new Calculator[size];
        }
    };

    public void addNum(String num){
        inNum.append(num);
        addNumToTask(num);
    }

    public void setFirstNum(String num){
        inNum.deleteCharAt(0);
        inNum.append(num);
        addNumToTask(num);
    }

    public void addNumToTask(String num){
            if (task.toString().equals("0") && !num.equals(".0") && !num.equals(".")) {
                task.deleteCharAt(0);
                //task.append(num);
            }
            else if (!task.toString().equals("0")){
                if (num.equals(".0") || num.equals(".")){
                    task.append(0);
                }
            }

            if (num.equals("+") || num.equals("-") || num.equals("/") || num.equals("*")) {
                if (task.charAt(task.length() - 1) != '+' && task.charAt(task.length() - 1) != '-' && task.charAt(task.length() - 1) != '&' && task.charAt(task.length() - 1) != '+' && task.charAt(task.length() - 1) != '.') {
                    task.append(num);
                    inNum.replace(0, inNum.length(), "0");
                }
            }
            else task.append(num);

    }

    public void deleteNum() {
        if (task.charAt(task.length() - 1) != '+' && task.charAt(task.length() - 1) != '-' && task.charAt(task.length() - 1) != '*' && task.charAt(task.length() - 1) != '/') {
            if (task.length() == 1) {
                inNum.replace(0, inNum.length(), "0");
                task.replace(0, task.length(), "0");
            }
            if (!task.toString().equals("0")) {
                task.deleteCharAt(task.length() - 1);
                inNum.deleteCharAt(inNum.length() - 1);
            }
        }
        else {
            task.deleteCharAt(task.length() - 1);
            int[] numsIndex = {-1, -1, -1, -1}; // 0 - "+", 1 - "-", 2 - "*", 3 - "/"
            numsIndex[0] = task.lastIndexOf("+");
            numsIndex[1] = task.lastIndexOf("-");
            numsIndex[2] = task.lastIndexOf("*");
            numsIndex[3] = task.lastIndexOf("/");
            int maxIndex = 0;
            for (int i:
                 numsIndex) {
                if (i > maxIndex){
                    maxIndex = i;
                }
            }
            if (maxIndex != 0) inNum.replace(0, inNum.length(), task.substring(maxIndex + 1));
            else inNum.replace(0, inNum.length(), task.substring(maxIndex));
        }


//        if (inNum.length() == 1)
//            inNum.replace(0, inNum.length(), "0");
//        if (!inNum.toString().equals("0"))
//            inNum.deleteCharAt(inNum.length() - 1);

    }

    public void clear(){
        inNum.replace(0, inNum.length(), "0");
        task.replace(0, task.length(), "0");
    }

    public String getInNum(){
        return inNum.toString();
    }

    public String getTask(){
        return task.toString();
    }

    public String equals() {
        StringBuilder str = task;
        while (true) {
            int[] numsIndex = {-1, -1, -1, -1}; // 0 - "+", 1 - "-", 2 - "*", 3 - "/"
            numsIndex[0] = str.indexOf("+");
            numsIndex[1] = str.indexOf("-");
            numsIndex[2] = str.indexOf("*");
            numsIndex[3] = str.indexOf("/");
            int firstIndex = numsIndex[0];
            for (int i :
                    numsIndex) {
                if (i != -1) {
                    firstIndex = i;
                }
            }
            for (int i :
                    numsIndex) {
                if (i != -1){
                    if (firstIndex > i) {
                        firstIndex = i;
                    }
                }
            }
            if (firstIndex == -1 && str.toString().equals("")){
                nextOperation = 'a';
                break;
            }
            else if (!str.toString().equals("") && firstIndex == -1){
                firstIndex = str.length() - 1;
                if (nextOperation == '+') {
                    secondNum = Double.parseDouble(str.toString());
                    str.delete(0, str.length());
                    addition();
                } else if (nextOperation == '-') {
                    secondNum = Double.parseDouble(str.toString());
                    str.delete(0, str.length());
                    subtraction();
                } else if (nextOperation == '*') {
                    secondNum = Double.parseDouble(str.toString());
                    str.delete(0, str.length());
                    multiplication();
                } else if (nextOperation == '/') {
                    secondNum = Double.parseDouble(str.toString());
                    str.delete(0, str.length());
                    division();
                }
                else {
                    firstNum = Double.parseDouble(str.toString());
                    str.delete(0, str.length());
                }
            }
            else {
                if (nextOperation == '+') {
                    setNums(str, firstIndex, str.charAt(firstIndex));
                    addition();
                } else if (nextOperation == '-') {
                    setNums(str, firstIndex, str.charAt(firstIndex));
                    subtraction();
                } else if (nextOperation == '*') {
                    setNums(str, firstIndex, str.charAt(firstIndex));
                    multiplication();
                } else if (nextOperation == '/') {
                    setNums(str, firstIndex, str.charAt(firstIndex));
                    division();
                }
                else {
                    setNums(str, firstIndex, str.charAt(firstIndex));
                }
            }
            
//            else {
//
//            }
        }
        
        Log.e("MyLog", "Final Result: " + firstNum);
        result = firstNum;
        inNum.replace(0, inNum.length(), String.valueOf(firstNum));
        task.replace(0, inNum.length(), String.valueOf(firstNum));
        firstNum = 0;
        secondNum = 0;

        return String.valueOf(result);
    }

    private void setNums(StringBuilder str, int firstIndex, char c){

        if (firstNum == 0){
            try {
                firstNum = Double.parseDouble(str.substring(0, firstIndex));
            }
            catch (NumberFormatException e){
                firstNum = 0;
            }

            if (c == '+' || c == '-'){
                secondNum = 0;
            }
            else secondNum = 1;
            str.delete(0, firstIndex + 1);
        }
        else {
            secondNum = Double.parseDouble(str.substring(0, firstIndex));
            str.delete(0, firstIndex + 1);
        }
        nextOperation = c;
    }

    public  void addition(){
        firstNum = firstNum + secondNum;
        secondNum = 0;
        Log.e("MyLog", "Result" + firstNum);
    }

    public  void subtraction(){
        firstNum = firstNum - secondNum;
        secondNum = 0;
        Log.e("MyLog", "Result" + firstNum);
    }

    public  void multiplication(){
        firstNum = firstNum * secondNum;
        secondNum = 0;
        Log.e("MyLog", "Result" + firstNum);
    }

    public  void division(){
        try {
            firstNum = firstNum / secondNum;
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }

        secondNum = 0;
        Log.e("MyLog", "Result" + firstNum);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(firstNum);
        dest.writeDouble(secondNum);
        dest.writeDouble(result);
        dest.writeInt((int) nextOperation);
    }
}
