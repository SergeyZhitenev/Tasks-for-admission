package Model;

import java.util.ArrayList;
//Стратегия тут не заходит
public class DSort implements Strateg{
    class Numb{
        double d;
        int i;
    }
    @Override
    public ArrayList<String> sort(ArrayList<String> arr) {
        ArrayList<Numb> numbs=new ArrayList<Numb>();
        for (int i = 0; i < arr.size(); i++) {
            var a=arr.get(i).split(":");
            Numb C=new Numb();
            C.i=Integer.parseInt(a[0]);
            C.d=Double.parseDouble(a[1]);
           numbs.add(C);
        }
        ArrayList<Numb> RezNumb= filtr(numbs);
        arr.clear();
        for (int i = 0; i < RezNumb.size(); i++) {
            arr.add(RezNumb.get(i).i+":"+RezNumb.get(i).d);
        }
        return arr;
    }
        public ArrayList<Numb> filtr(ArrayList<Numb> numbers) {
            int i, j, first;
            Numb temp;
            for (i = numbers.size() - 1; i > 0; i--) {
                first = 0;
                for (j = 1; j <= i; j++) {
                    if (compare(numbers.get(j).d,numbers.get(first).d))
                        first = j;  }
                temp = numbers.get(first);
                numbers.set(first,numbers.get(i)) ;
                numbers.set(i,temp);
            }
            return numbers;
        }

    private boolean compare(double number, double number1) {
        return number>number1;
    }
}
