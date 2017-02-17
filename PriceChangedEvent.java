public class PriceChangedEvent {
  private StockExchange stock;
  private int status;

  public PriceChangedEvent(StockExchange stock) {
    this.stock = stock;
    status = stock.getStatus();
  }

  public int getStatus() {
    return status;
  }

  public StockExchange getStock() {
    return stock;
  }
}