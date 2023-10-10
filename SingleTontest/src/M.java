public class M {

    public static void main(String[] args) {
        A a=A.getInstance();
        A b=A.getInstance();

        System.out.println(a.a);
        System.out.println(b.a);
        a.a=100000;
        System.out.println(b.a);
    }
}