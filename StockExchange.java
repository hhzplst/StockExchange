import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Random;

public class StockExchange implements Runnable {
  private CopyOnWriteArrayList<StockCustomer> registerList = new CopyOnWriteArrayList<>();
  private int status;
  private boolean stopRequested = false;

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

  private void stockChange() {
    Random rd = new Random();
    status = (rd.nextDouble() < 0.5)? -1 : 1;
  }

  public void run() {
    while (!stopRequested && (registerList.size() != 1)) {
      try {
        stockChange();
        notifyObservers();
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        System.out.println("The thread has been interrupted.");
      }
    }
  }

  public void requestStop() {
    stopRequested = true;
  }

  public int getStatus() {
    return status;
  }

  private void notifyObservers() {
    PriceChangedEvent e = new PriceChangedEvent(this);
    for (StockCustomer sc : registerList)
      sc.priceChanged(e);
  }

  private static void printMessage(int mode, StockCustomer sc) {
    if (mode == 1)
      System.out.printf("\nWelcome, %s. You are now registered.\n", sc.getName());
    else if (mode == 0)
      System.out.printf("\nBye, %s. You are now unregistered.\n", sc.getName());
  }
}