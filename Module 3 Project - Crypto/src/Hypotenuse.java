public class Hypotenuse {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        double asq = Math.pow(a, 2);
        double bsq = Math.pow(b, 2);
        double c = Math.sqrt(asq + bsq);
        System.out.println("c = " + c);

    }
}
