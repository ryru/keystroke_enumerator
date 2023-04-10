[![CI Build](https://github.com/ryru/keystroke_enumerator/actions/workflows/build.yml/badge.svg)](https://github.com/ryru/keystroke_enumerator/actions/workflows/build.yml)

# 🅺🅴 Keystroke Enumerator

Multi-platform tool to count the number of keystrokes needed to write a file or multiple files in a
folder.

This CLI tools can be of value in situations such as:

* Is keyboard layout X more efficient than layout Y?
* In codie golf to count symbols and keystrokes
* Comparing programming languages syntax

## How it works

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

Symbols that are not included in the file are counted as Unicode characters. E.g. the letter `ä` can
be written as `Ctrl`+`Shift`+`u`, `e`, `4`, `Space` requiring 6 keystrokes.

## Example

A German poem result in the following output:

```
$ ke Mondnacht.txt 

Scanned 1 files of 341 bytes in 0.044s
Found 41 unique in 323 symbols on 14 lines

Layout  Keystrokes      Redundancy[%]
DE_DE   368             13.932
FR_FR   368             13.932
DE_CH   383             18.576
FR_CH   392             21.362
EN_US   427             32.198

Layout DE_DE requires 59 keystrokes (16.033%) less than layout EN_US

```

* The text contains 323 symbols or characters. Of these 41 symbols are unique, meaning for example
  the letter `a` is used 13 times.

* The input text is a German poem requiring 368 _Keystrokes_ on a German _Layout_ and 383
  _Keystrokes_ on a German based Swiss German `DE_CH` _Layout_.

* On an english based _Layout_ 427 _Keystrokes_ are needed to get all the German letters like `ä`.
  These letters are assumed to be types as Unicode combinations.

* The _Redundancy_, measured in percent, describes the deviation of a theoretical perfect keyboard
  layout requiring only 323 keystrokes for a text of 323 symbols.

* Comparing the first and last layouts the German based layout is more efficient and requires 59
  keystrokes or 16% less than the English based layout.

## Build and run

Clone to local disk, build with gradle and run the command line tool with the project as input.
This tool runs on any ON that runs Java 19 or newer.

```
git clone https://github.com/ryru/keystroke_enumerator.git
cd keystroke_enumerator/
./gradlew clean installDist
./app/build/install/ke/bin/ke .
```

## Contribution

Pull requests are welcome! Check [CONTRIBUTING.md](CONTRIBUTING.md) before starting any work.
