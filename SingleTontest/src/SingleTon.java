public class SingleTon {

    private static SingleTon _instance = null;

    protected static <T> T getInstance(Class<T> clazz) {
        if (_instance == null) {
            try {
                _instance = (SingleTon) clazz.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return (T) _instance;
    }
}
