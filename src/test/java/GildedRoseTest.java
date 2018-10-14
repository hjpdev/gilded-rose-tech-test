
package main.java;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

  @Test
  public void notPastSellIn() {
    Item[] items = new Item[] { new Item("foo", 1, 10) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(9, app.items[0].quality);
  }

  @Test
  public void pastSellIn() {
    Item[] items = new Item[] { new Item("foo", 0, 10) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(8, app.items[0].quality);
  }

  @Test
  public void noNegativeQuality() {
    Item[] items = new Item[] { new Item("foo", 0, 0) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertFalse(app.items[0].quality < 0);
  }

  @Test
  public void noQualityOver50() {
    Item[] items = new Item[] { new Item("Aged Brie", 0, 50) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertFalse(app.items[0].quality > 50);
  }

  @Test
  public void agedBrieQualityWithoutSellIn() {
    Item[] items = new Item[] { new Item("Aged Brie", 0, 10) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(12, app.items[0].quality);
  }

  @Test
  public void agedBrieQualityWithSellIn() {
    Item[] items = new Item[] { new Item("Aged Brie", 10, 10) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(11, app.items[0].quality);
  }

  @Test
  public void sulfurasTest() {
    Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 50) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(50, app.items[0].quality);
  }

  @Test
  public void backstagePasses() {
    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 12, 10) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(11, app.items[0].quality);
  }

  @Test
  public void backstagePassesTenDays() {
    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 9, 10) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(12, app.items[0].quality);
  }

  @Test
  public void backstagePassesFiveDays() {
    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 10) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(13, app.items[0].quality);
  }

  @Test
  public void backstagePassesAfterConcert() {
    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(0, app.items[0].quality);
  }
}
