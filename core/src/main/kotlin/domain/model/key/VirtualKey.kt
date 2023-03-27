package domain.model.key

import kotlin.IllegalArgumentException

/**
 * Parse a CSV input string of concatenated keystrokes to a list of virtual keys.
 */
fun parse(input: String): List<VirtualKey> {
    try {
        return input.split("+")
            .map { VirtualKey.valueOf(it) }
            .toList()
    } catch (e: IllegalArgumentException) {
        throw IllegalArgumentException("No virtual key $input found.")
    }
}

enum class VirtualKey {
    A,
    B,
    C,
    D,
    E,
    F,
    G,
    H,
    I,
    J,
    K,
    L,
    M,
    N,
    O,
    P,
    Q,
    R,
    S,
    T,
    U,
    V,
    W,
    X,
    Y,
    Z,

    ZERO,
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,

    TAB,
    CAPITAL,
    SHIFT, // when it is unimportant whether left or right shift is used.
    LSHIFT,
    RSHIFT,
    CONTROL, // when it is unimportant whether left or right control is used.
    LCONTROL,
    RCONTROL,
    WIN, // when it s unimportant whether left or right win is used.
    LWIN,
    RWIN,
    MENU, // when it s unimportant whether left or right menu is used.
    LMENU,
    RMENU,
    SPACE,
    APPS,
    RETURN,
    BACK,

    OEM_MINUS,
    OEM_PLUS,
    OEM_COMMA,
    OEM_PERIOD,

    OEM_1,
    OEM_2,
    OEM_3,
    OEM_4,
    OEM_5,
    OEM_6,
    OEM_7,
    OEM_8,
    OEM_9,
    OEM_102,
}
