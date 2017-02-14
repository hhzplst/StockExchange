public class PriceChangedEvent {
  public StockExchange stock;
  public int changeBy, status;

  public PriceChangedEvent(StockExchange stock) {
    stock = stock;
    changeBy = stock.getChangeBy();
    status = stock.getStatus();
  }
}