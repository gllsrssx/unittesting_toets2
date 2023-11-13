package vraag1;

public class ExpensiveServerConnection {

    private static ExpensiveServerConnection expensiveServerConnection;

    public static ExpensiveServerConnection getInstance() {
        if (expensiveServerConnection == null) {
            expensiveServerConnection = new ExpensiveServerConnection();
        }

        return expensiveServerConnection;
    }

    private ExpensiveServerConnection() {
        // Connection initialization
    }

    public void sendDataToServer(String data) {
        // ...
    }
}
