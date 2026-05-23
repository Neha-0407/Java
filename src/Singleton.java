public class Singleton {
    private  static Singleton instance = new Singleton();

    Singleton initialize(){
        if(instance == null){
            synchronized(Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
            return new Singleton();
        }
        return instance;
    }
}
