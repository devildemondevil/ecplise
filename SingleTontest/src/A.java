public class A extends SingleTon{

    int a=1;
    public static A getInstance(){
        return SingleTon.getInstance(A.class);
    }


}
