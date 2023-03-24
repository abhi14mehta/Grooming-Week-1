// 2.5 String some sample examples for String builder and String buffer.

public class StringBuilderAndBufferMethods{
    public static void main(String[] args) {
        System.out.println("***STRING BUILDER***");
        StringBuilder sb = new StringBuilder();
        sb.append("Abhishek ");
        sb.append("Mehta");
        System.out.println(sb.toString());

        sb = new StringBuilder("Initial Value string");
        System.out.println(sb.toString());

        sb.insert(20," builder");
        System.out.println(sb.toString());

        System.out.println(sb.reverse().toString());

        sb.reverse();
        sb.replace(3,8,"TIAL ");
        System.out.println(sb.toString());

        sb.delete(7, 13);
        System.out.println(sb.toString());
        System.out.println();

        System.out.println("***STRING BUFFER***");
        StringBuffer strb = new StringBuffer();
        strb.append("Raju ");
        strb.append("Shyam");
        System.out.println(strb.toString());

        strb = new StringBuffer("Raju hits Shyam");
        System.out.println(strb.toString());

        strb.insert(15," hardly");
        System.out.println(strb.toString());

        System.out.println(strb.reverse().toString());

        strb.reverse();
        strb.replace(0,4,"RAJU");
        System.out.println(strb.toString());

        strb.delete(9, 15);
        System.out.println(strb.toString());
    }
}