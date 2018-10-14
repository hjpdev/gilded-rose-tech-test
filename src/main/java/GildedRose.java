package main.java;

class GildedRose {
  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (int i = 0; i < items.length; i++) {
      if (checkHasSellIn(items[i])) {
        items[i].quality -= 1;
      } else {
        items[i].quality -= 2;
      }
    }
  }

  public boolean checkHasSellIn(Item item) {
    return item.sellIn > 0;
  }
}
