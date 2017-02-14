public abstract class StockCustomer implements StockObserver {
  abstract void priceChanged(PriceChangedEvent e);
}