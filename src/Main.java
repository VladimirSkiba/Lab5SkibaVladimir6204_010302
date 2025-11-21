import functions.*;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try {
            demoLab5();
        } catch (Exception e) {
            System.out.println("Ошибка демонстрации lab5: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void demoLab5() {
        System.out.println("\n=== Демонстрация лабораторной работы №5 ===");

        FunctionPoint[] points = { new FunctionPoint(0.0, 1.2), new FunctionPoint(1.0, 3.8), new FunctionPoint(2.0, 15.2) };
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(points);
        LinkedListTabulatedFunction l = new LinkedListTabulatedFunction(points);

        System.out.println("toString Array: " + a.toString());
        System.out.println("toString Linked: " + l.toString());

        ArrayTabulatedFunction aClone = (ArrayTabulatedFunction) a.clone();
        LinkedListTabulatedFunction lClone = (LinkedListTabulatedFunction) l.clone();

        System.out.println("equals(Array,ArrayClone): " + a.equals(aClone));
        System.out.println("equals(Linked,LinkedClone): " + l.equals(lClone));
        System.out.println("equals(Array,Linked): " + a.equals(l));
        System.out.println("equals(Linked,Array): " + l.equals(a));

        int hashA_before = a.hashCode();
        int hashL_before = l.hashCode();
        System.out.println("hashCode Array (before): " + hashA_before);
        System.out.println("hashCode Linked (before): " + hashL_before);

        System.out.println("Клонирование произведено.");
        System.out.println("Изменим исходные — увеличим y первой точки на 0.005");
        a.setPointY(0, a.getPointY(0) + 0.005);
        l.setPointY(0, l.getPointY(0) + 0.005);

        System.out.println("После изменения исходных:");
        System.out.println("Original Array: " + a);
        System.out.println("Clone Array:    " + aClone);
        System.out.println("Original Linked: " + l);
        System.out.println("Clone Linked:    " + lClone);

        int hashA_after = a.hashCode();
        int hashL_after = l.hashCode();
        System.out.println("hashCode Array (after): " + hashA_after + " (diff: " + (hashA_after - hashA_before) + ")");
        System.out.println("hashCode Linked (after): " + hashL_after + " (diff: " + (hashL_after - hashL_before) + ")");
    }

}