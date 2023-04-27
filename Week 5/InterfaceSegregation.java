import java.util.ArrayList;
import java.util.List;

interface Payment{
    Object status();
    List<Object> getPayment();
}

interface Bank extends Payment{
    void initiateAllPayemnts();
}

interface Loan extends Payment{
    void initiateLoanPayments();
    void initiateRePayment();
}

class BankPayemnt implements Bank{
    @Override
    public List<Object> getPayment(){
        List<Object> obj = new ArrayList<>();
        return obj;
    }

    @Override
    public Object status(){
        Object obj = new Object();
        return obj;
    }

    @Override
    public void initiateAllPayemnts(){
        System.out.println("Initiating all Payments!");
    }

}

class LoanPayment implements Loan{
    @Override
    public List<Object> getPayment(){
        List<Object> obj = new ArrayList<>();
        return obj;
    }

    @Override
    public Object status(){
        Object obj = new Object();
        return obj;
    }

    @Override
    public void initiateLoanPayments(){
        System.out.println("Initiate all loan payments!");
    }

    @Override
    public void initiateRePayment(){
        System.out.println("Repayments !");
    }
}


public class InterfaceSegregation {
    public static void main(String[] args) {
        // create objs accroding to functionality required
    }
}
