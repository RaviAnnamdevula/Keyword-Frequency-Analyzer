package org.streams;

import java.io.*;

public class Student implements Serializable{
    // Marker Interface -- A Interface doesn't have any constrains or methods inside it. (doesn't have a body at all)
    // Serializable is an marker Interface. It's just a check which allow an object to be able for serialization or not
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "String { name ="+ name + " , age =" + age +" }";
    }

    //Java Code <-- File/Store  -- InputStream
    //Java Code -->File/Store  -- OutputStream

    public static void writeObject() throws IOException {
        FileOutputStream fileOutputStream =  new FileOutputStream("D:\\GfgBackend\\JBDL-Collections\\demo1.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        String a = "abc";
        Student s = new Student("Ravi" , 21);
       // fileOutputStream.write(a.getBytes());
        objectOutputStream.writeObject(s);
    }
    
    public static Object readObject() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream =  new FileInputStream("D:\\GfgBackend\\JBDL-Collections\\demo1.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        String a = "abc";
        Student s = new Student("Ravi" , 21);
        return objectInputStream.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // writeObject();
         System.out.println(readObject());
    }
}
