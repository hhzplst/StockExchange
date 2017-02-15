public class PriceChangedEvent {
  public StockExchange stock;
  public int status;

  public PriceChangedEvent(StockExchange stock) {
    stock = stock;
    status = stock.getStatus();
  }
}