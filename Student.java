/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package iofile;

/**
 *
 * @author mjnht_000
 */
import java.io.Serializable;

public class Student implements Serializable{
    private String name;
    private int age;
    private int mark;
    
        
    public Student(){
    }
    
    public Student(String name , int age, int mark){
        this.name = name;
        this.mark = mark;
        this.age = age;
    }
    
    public String setName(String name){
        return this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int setAge(int age){
        return this.age = age;
    }
    
    public int getAge(){
        return this.age;
    }
    
    public int setMark(int mark){
        return this.mark = mark;
    }
    
    public int getmark(){
        return this.mark;
    }
    
    public String toString(){
        return ("Name : " + this.name + "\n" + "Age : " + this.age + "\n" + "Mark : " + this.mark + "\n"  +  "--------------------" + "\n");
    }
}
