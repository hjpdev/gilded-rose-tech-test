
package main.java;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

  @Test
  public void foo() {
    Item[] items = new Item[] { new Item("foo", 0, 0) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals("foo", app.items[0].name);
  }

  @Test
  public void notPassedSellIn() {
    Item[] items = new Item[] { new Item("foo", 1, 10) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(9, app.items[0].quality);
  }

  @Test
  public void passedSellIn() {
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
}
