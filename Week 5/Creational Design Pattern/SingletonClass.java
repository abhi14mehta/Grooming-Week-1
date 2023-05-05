class Singleton {
    private static Singleton single_instance = null;
  
    public String s;
  
    private Singleton()
    {
        s = "Hello I am a string part of Singleton class";
    }
  
    public static synchronized Singleton getInstance()
    {
        if (single_instance == null)
            single_instance = new Singleton();
  
        return single_instance;
    }
}

public class SingletonClass {
    public static void main(String[] args) {
        Singleton x = Singleton.getInstance();
        Singleton y = Singleton.getInstance();
  
        System.out.println("Hashcode of x is "+ x.hashCode());
        System.out.println("Hashcode of y is "+ y.hashCode());

        if(x==y){
            System.out.println("They point to same memory location!!!");
        }else{
            System.out.println("They dont point to same location!");
        }
    }
}
