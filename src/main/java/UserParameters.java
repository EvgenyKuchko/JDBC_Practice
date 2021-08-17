import java.util.Scanner;

public class UserParameters {

public static int number() {
    Scanner sc = new Scanner(System.in);

    while(!sc.hasNext()) {
        sc.next();
    }

    return sc.nextInt();
}

    public static String text() {
        Scanner sc = new Scanner(System.in);

        while(!sc.hasNextLine()) {
            sc.next();
        }

        return sc.nextLine();
    }

}
