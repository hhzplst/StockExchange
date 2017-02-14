public class StockPricePrinter extends StockCustomer {
  public StockPricePrinter(String name) {
    super(name);
  }

  public void priceChanged(PriceChangedEvent e) {
    //Printer's way of handling the event
  }
}