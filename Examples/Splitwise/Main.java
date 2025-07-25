package Examples.Splitwise;

import Examples.Splitwise.ExceptionHandling.InvalidExpenseException;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            new SplitwiseApplication().start();
        } catch (InvalidExpenseException exception) {
            System.out.println("Invalid Expense Exception!");
        } catch (Exception exception) {
            System.out.println("Exception Occured : " + exception);
        }
    }
}
