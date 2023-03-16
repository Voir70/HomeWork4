//В калькулятор добавьте возможность отменить последнюю операцию.
//        Пример
//
//        1
//        +
//        2
//        ответ:
//        3
//        +
//        4
//        ответ:
//        7
//        Отмена
//        3
//        *
//        3
//        ответ:
//        9
//        Пример 2
//        Ввод: 1
//        Ввод: +
//        Ввод: 2
//        Вывод: 3
//        Ввод:+
//        Ввод:4
//        Вывод 7
//        Ввод:*
//        Ввод:3
//        Вывод 21
//        Отмена
//        Вывод 7
//        Отмена
//        Вывод 3
//        Ввод:-
//        Ввод:1
//        Вывод 2
//
//        Дополнительно каскадная отмена - отмена нескольких операций

//Как то так,но не то что хотел(((.Тесты тоже оставлю,не уверен надо ли.У меня то они есть.
import java.util.Stack;
public class Calculator {
    private Stack stack; // стек для хранения результатов вычислений
    private Stack operationStack; // стек для хранения операций
    private int result; // текущий результат вычисления

    public Calculator() {
        stack = new Stack<>();
        operationStack = new Stack<>();
        result = 0;
    }

    // метод для выполнения операции
    public void doOperation(char op, int value) {
        switch (op) {
            case '+': result += value; break;
            case '-': result -= value; break;
            case '*': result *= value; break;
            case '/': result /= value; break;
            default: break;
        }
    }

    // метод для добавления числа в вычисление
    public void addNumber(int value) {
        stack.push(result); // сохраняем текущий результат вычисления в стек
        operationStack.push('+'); // добавляем в стек операций знак сложения
        result = value; // обновляем текущий результат вычисления
    }

    // метод для выполнения операции и добавления числа в вычисление
    public void doOperationAndAddNumber(char op, int value) {
        doOperation(op, value);
        stack.push(result); // сохраняем текущий результат вычисления в стек
        operationStack.push(op); // добавляем в стек операций знак текущей операции
        result = 0; // обнуляем текущий результат вычисления
    }

    // метод для вывода результата на экран
    public void printResult() {
        stack.push(result); // сохраняем текущий результат вычисления в стек
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
            if (i < operationStack.size()) {
                sb.append(" ").append(operationStack.get(i)).append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    // метод для отмены последней операции
    public void undo() {
        if (!stack.isEmpty() && !operationStack.isEmpty()) {
            stack.pop(); // удаляем последний элемент из стека результатов вычислений
            char lastOp = (char)operationStack.pop();
            switch (lastOp) {
                case '+': result = (int)stack.pop(); break;
                case '-': result = (int)stack.pop(); break;
                case '*': result = (int)stack.pop(); break;
                case '/': result = (int)stack.pop(); break;
                default: break;
            }
        } else {
            System.out.println("Нет операции для отмены.");
        }
    }

    // метод для каскадной отмены
    public void cascadeUndo(int count) {
        if (!stack.isEmpty() && !operationStack.isEmpty()) {
            for (int i = 0; i < count; i++) {
                undo(); // вызываем метод отмены нужное количество раз
            }
        } else {
            System.out.println("Нет операции для отмены.");
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.addNumber(1);
        calculator.doOperationAndAddNumber('+', 2);
        calculator.printResult(); // 1 + 2 = 3
        calculator.doOperationAndAddNumber('+', 4);
        calculator.printResult(); // 1 + 2 + 4 = 7
        calculator.doOperationAndAddNumber('*', 3);
        calculator.printResult(); // 7 * 3 = 21
        calculator.undo();
        calculator.printResult(); // 1 + 2 + 4 = 7
        calculator.cascadeUndo(2);
        calculator.printResult(); // 1 + 2 = 3
        calculator.doOperationAndAddNumber('-', 1);
        calculator.printResult(); // 1 + 2 - 1 = 2
    }
}

