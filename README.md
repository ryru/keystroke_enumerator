# 🅺🅴 Keystroke Enumerator

Count effective keystrokes made to type files based on keyboard layouts.

To type the letter `a` one keystroke is required. Two keystrokes (SHIFT+A) are needed to type the
capital version `A`. The goal of the application is to count exactly how many times one pushes a
keyboard button. This allows comparison of different keyboard layouts.

## Example

A paragraph of lorem ipsum text result in the following output:

```text
java -jar app/build/libs/ke.jar ~/IdeaProjects/KeystrokeEnumerator/core/src/test/resources/singleFiles/lorem.txt 

Scanned 1 files of 977 bytes in 0.045s
Found 34 unique in 977 symbols on 1 lines

Layout  Keystrokes      Redundancy[%]
DE_CH   992             1.535
EN_US   992             1.535

First and last layout provide the same efficiency.

```

* The text contains 977 symbols or characters. Of these only 34 symbols are unique, meaning for
  example the letter `a` is used 62 times.

* For the keyboard _Layout_ DE_CH and EN_US the text can be written in 992
  _Keystrokes_. The theoretical ideal or perfect keyboard layout would require exactly the amount of
  keystrokes as letters are typed, meaning the given layouts have some kind of redundancy (e.g. `A`
  requires two keystrokes). _Redundancy_ for both layouts is 1.5%.
