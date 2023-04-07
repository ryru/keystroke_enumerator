[![CI Build](https://github.com/ryru/keystroke_enumerator/actions/workflows/build.yml/badge.svg)](https://github.com/ryru/keystroke_enumerator/actions/workflows/build.yml)

# 🅺🅴 Keystroke Enumerator

Count effective keystrokes made to type files based on keyboard layouts.

To type the letter `a` one keystroke is required. Two keystrokes (SHIFT+A) are needed to type the
capital version `A`. The goal of the application is to count exactly how many times one pushes a
keyboard button. This allows comparison of different keyboard layouts.

The [keyboard layouts](core/src/main/resources/layouts) are defined in CSV files. Currently, the
following layouts are implemented:

* `de-CH`
* `de-DE`
* `en-US`
* `fr-CH`
* `fr-FR`

## Example

A German poem result in the following output:

```
$ ke Mondnacht.txt 

Scanned 1 files of 341 bytes in 0.039s
Found 41 unique in 323 symbols on 14 lines

Layout  Keystrokes      Redundancy[%]
DE_DE   365             13.003
FR_FR   368             13.932
DE_CH   380             17.647
FR_CH   389             20.433
EN_US   424             31.269

Layout DE_DE requires 59 keystrokes (16.164%) less than layout EN_US

```

* The text contains 323 symbols or characters. Of these 41 symbols are unique, meaning for example
  the letter `a` is used 13 times.

* The input text is a German poem requiring 365 _Keystrokes_ on a German _Layout_ and 380
  _Keystrokes_ on a German based _Layout_ such as the Swiss German `DE_CH`.

* On an english based _Layout_ 424 _Keystrokes_ are needed to get all the German letters like `ä`.

* The _Redundancy_, measured in percent, describes the deviation of a theoretical perfect keyboard
  layout requiring only 323 keystrokes for a text of 323 symbols.

* Comparing the first and last layouts the German based layout is more efficient and requires 59
  keystrokes or 16.2% less than the English based layout.

## Build and run

Clone to local disk, build with gradle and run the command line tool with the project as input.
Requires Java 19 or newer.

```
git clone https://github.com/ryru/keystroke_enumerator.git
cd keystroke_enumerator/
./gradlew clean installDist
./app/build/install/ke/bin/ke .
```

## Contribution

Pull requests are welcome! Check [CONTRIBUTING.md](CONTRIBUTING.md) before starting any work.
