public class IdGenerator {

    private static long currentID = 100000L;

    public static synchronized long nextID(){
        return ++currentID;
    }
}
