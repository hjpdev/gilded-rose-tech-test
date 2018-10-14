
package main.java;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

  private GildedRose generateApp(String name, int days, int quality) {
    Item[] items = new Item[] { new Item(name, days, quality) };
    GildedRose app = new GildedRose(items);
    return app;
  };

  @Test
  public void notPastSellIn() {
    GildedRose app = generateApp("foo", 1, 10);

    app.updateQuality();

    assertEquals(9, app.items[0].quality);
  }

  @Test
  public void pastSellIn() {
    GildedRose app = generateApp("foo", 0, 10);

    app.updateQuality();

    assertEquals(8, app.items[0].quality);
  }

  @Test
  public void noNegativeQuality() {
    GildedRose app = generateApp("foo", 0, 0);

    app.updateQuality();

    assertFalse(app.items[0].quality < 0);
  }

  @Test
  public void noQualityOver50() {
    GildedRose app = generateApp("Aged Brie", 0, 50);

    app.updateQuality();

    assertFalse(app.items[0].quality > 50);
  }

  @Test
  public void agedBrieQualityWithoutSellIn() {
    GildedRose app = generateApp("Aged Brie", 0, 10);

    app.updateQuality();

    assertEquals(12, app.items[0].quality);
  }

  @Test
  public void agedBrieQualityWithSellIn() {
    GildedRose app = generateApp("Aged Brie", 10, 10);

    app.updateQuality();

    assertEquals(11, app.items[0].quality);
  }

  @Test
  public void sulfurasTest() {
    GildedRose app = generateApp("Sulfuras, Hand of Ragnaros", 0, 50);

    app.updateQuality();

    assertEquals(50, app.items[0].quality);
  }

  @Test
  public void backstagePasses() {
    GildedRose app = generateApp("Backstage passes to a TAFKAL80ETC concert", 12, 10);

    app.updateQuality();

    assertEquals(11, app.items[0].quality);
  }

  @Test
  public void backstagePassesTenDays() {
    GildedRose app = generateApp("Backstage passes to a TAFKAL80ETC concert", 9, 10);

    app.updateQuality();

    assertEquals(12, app.items[0].quality);
  }

  @Test
  public void backstagePassesFiveDays() {
    GildedRose app = generateApp("Backstage passes to a TAFKAL80ETC concert", 4, 10);

    app.updateQuality();

    assertEquals(13, app.items[0].quality);
  }

  @Test
  public void backstagePassesAfterConcert() {
    GildedRose app = generateApp("Backstage passes to a TAFKAL80ETC concert", 0, 10);

    app.updateQuality();

    assertEquals(0, app.items[0].quality);
  }
}
