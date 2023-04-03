public class FinalizeMethodDemo {
    public static void main(String[] args) {
        FinalizeMethodDemo fm = new FinalizeMethodDemo();
        fm = null; 
        System.gc(); 
        System.out.println("fm is destroyed successfully!");
    }
    @Override
    protected void finalize(){
        System.out.println("Inside finalize method!");
        System.out.println("Here connections are closed!");
    }
}
