package vraag1;

public class ClientApplication {
    public static void main(String[] args) {
        ExpensiveServerConnection expensiveServerConnection = ExpensiveServerConnection.getInstance();
        expensiveServerConnection.sendDataToServer("MY DATA");

        ExpensiveServerConnection expensiveServerConnection2 = ExpensiveServerConnection.getInstance();
        expensiveServerConnection2.sendDataToServer("MORE DATA");

        if (expensiveServerConnection != expensiveServerConnection2) {
            throw new RuntimeException("Should be the same object!");
        }
        else {
            System.out.println("It works!");
        }
    }
}
