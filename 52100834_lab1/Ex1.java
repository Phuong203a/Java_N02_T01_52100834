
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Ex1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // String s = "java Program 15 / 2";
        // s = s.replace("java Program", "");
        // String a = "";
        // int x = Integer.parseInt(a);
        // double y = Double.parseDouble("23.4");
        // System.out.println(x + " +" + y);
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        // "java Program 15 / 2"
        s = s.replace("java Program", "").trim();
        String[] arrStr = s.split("\\s+");
        if (arrStr.length < 3) {
            System.out.println("Invalid arguments");
            return;
        }
        double result;
        double a = Double.parseDouble(arrStr[0]);
        double b = Double.parseDouble(arrStr[2]);
        switch (arrStr[1]) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "x":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            case "^":
                result = Math.pow(a, b);
                break;
            default:
                System.out.println("Unsupported");
                return;
        }
        System.out.println(result);

    }

}
