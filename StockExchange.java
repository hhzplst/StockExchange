import java.util.ArrayList;
import java.util.Random;

public class StockExchange {
  private ArrayList<StockCustomer> registerList = new ArrayList<>();
  private int changeBy, status;

  public StockExchange(int changeBy) {
    changeBy = changeBy;
  }

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

  //should this be public?
  public void stockChange() {
    Random rd = new Random();
    status = (rd.nextDouble() < 0.5)? 0 : 1;
  }

  private static void printMessage(int mode, StockCustomer sc) {
    if (mode == 1)
      System.out.printf("\nWelcome, %s. You are now registered.\n", sc.getName());
    else if (mode == 0)
      System.out.printf("\nBye, %s. You are now unregistered.\n", sc.getName());
  }
}