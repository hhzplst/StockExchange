public class PriceChangedEvent {
  public StockExchange stock;
  public int status;

  public PriceChangedEvent(StockExchange stock) {
    this.stock = stock;
    status = stock.getStatus();
  }
}