public abstract class StockCustomer implements StockObserver {
  private String name;
  protected PriceChangedEvent event;
  public abstract void priceChanged(PriceChangedEvent e);

  public StockCustomer(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  protected void setName(String newName) {
    name = newName;
  }
}