package Model;


import java.util.ArrayList;
import java.util.Arrays;

public class Adapter {


     LinkList array; // включение сервисного класса структуры данных

    public Adapter() {


        array = new LinkList();//полустатический массив - особенность реализации  OrArray


    }

// метод для получения списка строк для View

    public ArrayList<String> display() {

        String[] subStr;
        String delimeter = " ";//разделитель
        subStr = array.display().split(delimeter);//разделение на подстроки

        ArrayList<String> arr = new ArrayList<>(Arrays.asList(subStr));//создание динамического массива и перенос в него подстрок

        return arr;
    }
    public boolean add(int i,double d){
        array.insertFirst(i,d);
        return true;
    }
    public boolean del(){
        array.deleteFirst();
        return true;
    }
    public boolean delAll(){
        while (!array.isEmpty())
        array.deleteFirst();
        return true;
    }
    public ArrayList<Integer> find(String s) {

        String[] subStr;
        String delimeter = " ";//разделитель
        subStr = array.display().split(delimeter);//разделение на подстроки
        ArrayList<Integer> i=new ArrayList<Integer>();
        int temp=0;
        for (String ss:subStr)
        {
            temp++;
            if(ss.equals(s)){
                i.add(temp);}
        }
        return i;
    }
}