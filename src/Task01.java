//1.Пусть дан LinkedList с несколькими элементами. Реализуйте метод(не void), который вернет “перевернутый” список.
import java.util.*;
import java.util.LinkedList;
public class Task01 {

    public static void main(String[] args) {
        // Объявление связанного списка без начального размера
//        LinkedList<Integer> linkedli = new LinkedList<Integer>();
//
//        // Добавление элементов в конец списка
//        linkedli.add(new Integer(1));
//        linkedli.add(new Integer(2));
//        linkedli.add(new Integer(3));
//        linkedli.add(new Integer(4));
//        linkedli.add(new Integer(5));
//        System.out.print("Elements before reversing: " + linkedli);
//
//        // Метод Collections.reverse принимает список как
//        // параметр и возвращает обратный список
//        Collections.reverse(linkedli);
//
//        System.out.print("\nElements after reversing: " + linkedli);
//    }
//}


        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            ll.add(getRandomNumber());
        }
        System.out.println(ll);

        for (int i = 0; i < 10; i++) {
            System.out.print(ll.getLast() + ", ");
            ll.removeLast();

        }
    }

    public static int getRandomNumber() { // генерирует случайное число
        double x = (Math.random() * 99);
        int num = (int) x;
        return num;
    }
}