//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Thread t1 = new cooking("Cooking");
        Thread t2 = new cooking("Washing");
        Thread t3 = new Thread(new cookingRunnable("Grooming"));
        t1.start();
        t2.start();
        t3.start();
    }
}
