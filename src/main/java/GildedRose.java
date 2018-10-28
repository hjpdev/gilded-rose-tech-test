package main.java;

import java.util.Arrays;

class GildedRose {
  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (int i = 0; i < items.length; i++) {
      if (!isSpecial(items[i]) && !isConjured(items[i])) {
        checkSellIn(items[i]);
      } else if (isConjured(items[i])) {
        updateConjured(items[i]);
      } else {
        updateSpecial(items[i]);
      }
    }
  }

  private boolean isSpecial(Item item) {
    String[] specialNames = { "Aged Brie", "Sulfuras, Hand of Ragnaros", "Backstage passes to a TAFKAL80ETC concert" };
    boolean contains = Arrays.stream(specialNames).anyMatch(item.name::equals);
    return contains;
  }

  boolean isConjured(Item item) {
    return item.name.contains("Conjured");
  }

  private void checkSellIn(Item item) {
    if (item.sellIn > 0) {
      item.quality -= 1;
    } else {
      item.quality -= 2;
    }
    qualityLimitsCheck(item);
    item.sellIn -= 1;
  }

  private void updateConjured(Item item) {
    if (item.sellIn > 0) {
      item.quality -= 2;
    } else {
      item.quality -= 4;
    }
    qualityLimitsCheck(item);
    item.sellIn -= 1;
  }

  private void updateSpecial(Item item) {
    if (item.name == "Aged Brie") {
      updateBrie(item);
    } else if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
      updatePasses(item);
    }
    item.sellIn -= 1;
  }

  private void updateBrie(Item brie) {
    if (brie.sellIn > 0) {
      brie.quality += 1;
    } else {
      brie.quality += 2;
    }
    qualityLimitsCheck(brie);
  }

  private void updatePasses(Item pass) {
    if (pass.sellIn < 1) {
      pass.quality = 0;
    } else if (pass.sellIn < 6) {
      pass.quality += 3;
    } else if (pass.sellIn < 11) {
      pass.quality += 2;
    } else {
      pass.quality += 1;
    }
    qualityLimitsCheck(pass);
  }

  private void qualityLimitsCheck(Item item) {
    if (item.quality > 50) {
      item.quality = 50;
    } else if (item.quality < 0) {
      item.quality = 0;
    }
  }
}
