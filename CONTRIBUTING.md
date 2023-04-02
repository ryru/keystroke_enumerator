# Contributing to Keystroke Enumerator

Pull requests (PR) are welcome. Here are some tips to consider to land new PR in the main branch.

## Ways to contribute

You can help make Keystroke Enumerator a better tool by:

* Add additional [keyboard layouts](#keyboard-layout)
* Raise an issue if you discover a bug.
* Contribute bug fixes, new features or enhancements.

## Before opening a PR

When proposing new features or enhancements, we strongly recommend opening an issue first so that
the problem being solved and the implementation design can be discussed. This helps to avoid time
being invested in code that is never eventually merged, and also promotes better designs by
involving the community more widely.

For straightforward bug fixes where the issue is clear and can be illustrated via a failing unit or
acceptance test, please just open a PR.

## Keyboard Layout

The whole idea of this project revolves around different keyboard layouts. Here some guidelines when
adding new layouts.

* Layouts are defined in CVS files (e.g. de-CH.csv or en-US.csv).
* A layout should contain a mapping of every printed symbol key to a keystroke symbol.
* The website [kbdlayout.info](https://kbdlayout.info) is a very helpful resource for a broad set of
  keyboard layouts.

## Miscellaneous

This file is inspired by
the [WireMock](https://github.com/wiremock/wiremock/blob/master/CONTRIBUTING.md) contributing file.
