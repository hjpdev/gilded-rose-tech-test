package main.java;

import java.util.Arrays;

class GildedRose {
  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (int i = 0; i < items.length; i++) {
      if (!isSpecial(items[i])) {
        checkSellIn(items[i]);
      } else {
        checkSpecial(items[i]);
      }
    }
  }

  private boolean isSpecial(Item item) {
    String[] specialNames = { "Aged Brie", "Sulfuras, Hand of Ragnaros", "Backstage passes to a TAFKAL80ETC concert" };
    boolean contains = Arrays.stream(specialNames).anyMatch(item.name::equals);
    return contains;
  }

  private void checkSellIn(Item item) {
    if (item.sellIn > 0) {
      item.quality -= 1;
    } else {
      item.quality -= 2;
    }
  }

  private void checkSpecial(Item item) {
    if (item.name == "Aged Brie") {
      updateBrie(item);
    } else if (item.name == "Sulfuras, Hand of Ragnaros") {
      updateSulfuras(item);
    } else if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
      updatePasses(item);
    }
  }

  private void updateBrie(Item brie) {
    if (brie.sellIn > 0) {
      brie.quality += 1;
    } else {
      brie.quality += 2;
    }
  }

  private void updateSulfuras(Item sulf) {

  }

  private void updatePasses(Item pass) {

  }
}
