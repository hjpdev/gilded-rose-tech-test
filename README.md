# gilded-rose-tech-test

Makers week 10 mock tech test - Gilded Rose Refactoring Kata. The challenge here was to start with existing code - which while functional was messy & generally poorly written - and to refactor this.

Full instructions for this project can be found [here](https://github.com/emilybache/GildedRose-Refactoring-Kata)

First, an introduction to the current system:

    - All items have a SellIn value which denotes the number of days we have to sell the item
    - All items have a Quality value which denotes how valuable the item is
    - At the end of each day our system lowers both values for every item

```
	- Once the sell by date has passed, Quality degrades twice as fast

	- The Quality of an item is never negative

	- "Aged Brie" actually increases in Quality the older it gets

	- The Quality of an item is never more than 50

	- "Sulfuras", being a legendary item, never has to be sold or decreases in Quality

	- "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
	Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
	Quality drops to 0 after the concert

We have recently signed a supplier of conjured items. This requires an update to our system:

	- "Conjured" items degrade in Quality twice as fast as normal items

Feel free to make any changes to the UpdateQuality method and add any new code as long as everything
still works correctly. However, do not alter the Item class or Items property as those belong to the
goblin in the corner who will insta-rage and one-shot you as he doesn't believe in shared code
ownership (you can make the UpdateQuality method and Items property static if you like, we'll cover
for you).
```

## How to Use

Make sure you have Java SE downloaded (& Java 9 or above also required), which can be found [here](https://www.oracle.com/technetwork/java/javase/downloads/index.html)

To copy:

In the command line:

```
  git clone https://github.com/hjpugh/gilded-rose-tech-test.git
  cd D:/gilded-rose-tech-test/src/bin
```

To run the tests:

In the command line:

```
	gradle cleanTest test
```

## Summary

The commit history should make it fairly clear how I worked through this but to summarise, I started by writing the tests to cover all of the fucntionality mentioned in the original README. After this, I deleted the exiting code and started from scratch, using the testing framework to guide me in implementing the required functionality. There still some room for improvement but the code has been refactored in a way that makes it more readable and clear what is going on.
