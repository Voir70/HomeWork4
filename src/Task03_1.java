//import java.util.Scanner;
//import java.util.Vector;
//public class Task03_1 {
//    private final Scanner userInput = new Scanner(System.in);
//    private boolean keepOn = true;
//    private String yesOrNo;
//    public Vector<Double> calculations = new Vector<>();
//
//    public void start() {
//        System.out.println("Добро пожаловать в калькулятор!");
//        while (keepOn) {
//            calculate();
//        }
//    }
//
//    public String chooseOperator() {
//        System.out.println("Что делать?" +
//                "\n + сложить" +
//                "\n - вычесть" +
//                "\n * умножить" +
//                "\n / делить");
//
//        String operator = userInput.next();
//
//        return operator;
//    }
//
//    public double getFirstNumber() {
//        System.out.println("Введите первое число");
//        return userInput.nextDouble();
//    }
//
//    public double getSecondNumber() {
//        System.out.println("Введите второе число");
//        return userInput.nextDouble();
//    }
//
//    public void addition(double a, double b) {
//        calculations.addElement(a + b);
//        System.out.println("Число: " + (a + b));
//    }
//
//    public void division(double a, double b) {
//        calculations.addElement(a / b);
//        System.out.println("Число: " + (a / b));
//    }
//
//    public void mult(double a, double b) {
//        calculations.addElement(a * b);
//        System.out.println("Число: " + (a * b));
//    }
//
//    public void sub(double a, double b) {
//        calculations.addElement(a - b);
//        System.out.println("Число: " + (a - b));
//    }
//
//    public void showMenu() {
//        int z = 0;
//        while (z != 1) {
//            System.out.println("Пожалуйста, нажмите соответствующую цифру для операции, которую вы хотите выполнить.");
//            System.out.println("1. Еще одна операция?");
//            System.out.println("2. История?");
//            System.out.println("3. Выйти?");
//
//            yesOrNo = userInput.next();
//
//            if (yesOrNo.equals("1")) {
//                z = 1;
//                calculate();
//            } else if (yesOrNo.equals("3")) {
//                z = 1;
//                keepOn = false;
//                exitMessage();
//            } else if (yesOrNo.equals("2")) {
//                loadHistory();
//            }
//        }
//    }
//
//    public void loadHistory() {
//        System.out.println("Вот ваши расчеты: ");
//
//        for (int i = 0; i < calculations.size(); i++) {
//            System.out.println(calculations.get(i));
//        }
//    }
//
//    public void exitMessage() {
//        System.out.println("Вот результаты ваших вычислений: ");
//
//        for (int i = 0; i < calculations.size(); i++) {
//            System.out.println(calculations.get(i));
//        }
//
//        System.out.println("Спасибо за использование программы! Надеюсь, вам понравилось!");
//    }
//
//    public void calculate() {
//        int x = 0;
//        int y = 0;
//        String operation;
//
//        while (x < 1) {
//            operation = chooseOperator();
//            if(operation.equals("+")){
//                double num1 = getFirstNumber();
//                double num2 = getSecondNumber();
//                addition(num1, num2);
//                x = 1;
//            }
//            else if (operation.equals("-")) {
//                double num1 = getFirstNumber();
//                double num2 = getSecondNumber();
//                sub(num1, num2);
//                x = 1;
//            }
//            else if (operation.equals("/")) {
//                double num1 = getFirstNumber();
//                double num2 = getSecondNumber();
//                division(num1, num2);
//                x = 1;
//            }
//            // не работает, надо исправить
//            else if (operation.equals("*")) {
//                double num1 = getFirstNumber();
//                double num2 = getSecondNumber();
//                mult(num1, num2);
//                x = 1;
//            } // конец умножения
//        }
//        if (x == 1) {
//            showMenu();
//        }
//    }
//
//}
