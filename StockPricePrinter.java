import java.util.ArrayList;

public class StockPricePrinter extends StockCustomer {

  private ArrayList<String> plot = new ArrayList<>();

  public StockPricePrinter(String name) {
    super(name);
  }

  public void priceChanged(PriceChangedEvent e) {
    event = e;
    if (event.status == -1) plot.add("\u2193");
    else plot.add("\u2191");
    plot();
  }

  private void plot() {
    for (String c : plot)
      System.out.print(c);
  }
}