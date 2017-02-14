import java.util.ArrayList;

public class StockExchange {
  private ArrayList<StockCustomer> registerList = new ArrayList<>();

  public void addObserver(StockCustomer sc) {
    if (registerList.contains(sc))
      System.out.println("You've already registered!");
    else {
      registerList.add(sc);
      printMessage(1, sc);
    }
  }

  public void removeObserver(StockCustomer sc) {
    if (!registerList.contains(sc))
      System.out.println("Can't remove before register!");
    else {
      registerList.remove(sc);
      printMessage(0, sc);
    }
  }

  private static void printMessage(int mode, StockCustomer sc) {
    if (mode == 1)
      System.out.printf("\nWelcome, %s. You are now registered.\n", sc.getName());
    else if (mode == 0)
      System.out.printf("\nBye, %s. You are now unregistered.\n", sc.getName());
  }
}