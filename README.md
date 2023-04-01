# 🅺🅴 Keystroke Enumerator

Count effective keystrokes made to type files based on keyboard layouts.

To type the letter `a` one keystroke is required. Two keystrokes (SHIFT+A) are needed to type the
capital version `A`. The goal of the application is to count exactly how many times one pushes a
keyboard button. This allows comparison of different keyboard layouts.

## Example

A paragraph of lorem ipsum text result in the following output:

```text
java -jar ke.jar Mondnacht.txt 

Scanned 1 files of 341 bytes in 0.047s
Found 41 unique in 323 symbols on 14 lines

Layout  Keystrokes      Redundancy[%]
DE_CH   380             17.647
EN_US   424             31.269

Layout DE_CH requires 44 keystrokes (11.579%) less than layout EN_US

```

* The text contains 323 symbols or characters. Of these 41 symbols are unique, meaning for example
  the letter `a` is used 13 times.

* The input text is a German poem requiring on 380 _Keystrokes_ on a german based _Layout_.

* On an english based _Layout_ 424 _Keystrokes_ are needed to get all the German letters like `ä`.

* The _Redundancy_, measured in percent, describes the deviation of a theoretical perfect keyboard
  layout requiring only 323 keystrokes for a text of 323 symbols.

* Comparing the two layouts the German based layout is more efficient because requires 44 keystrokes
  or 11.6% less than the English based layout.
