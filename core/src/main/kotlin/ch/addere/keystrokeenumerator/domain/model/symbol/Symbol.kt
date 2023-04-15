package ch.addere.keystrokeenumerator.domain.model.symbol

/**
 * Represents any type sign that changes a document. A symbol can be any regular character or number
 * such as 'a' or '2' as well as a whitespace or a tabulator. Even emojis are symbols.
 *
 * A symbol is independent of different encodings such as UTF-8 or UTF-16. Line breaks are treated
 * as symbols as well.
 */
data class Symbol(val value: Int)

/**
 * Translate a symbol string into a symbol domain object.
 */
fun from(symbolString: String): Symbol {


    return when (symbolString) {
        "TAB" -> TAB
        "RETURN" -> LINE_BREAK
        "SPACE" -> BLANK
        "!" -> EXCLAMATION_MARK
        "\"" -> DOUBLE_QUOTE
        "#" -> HASH
        "$" -> DOLLAR
        "%" -> PERCENT
        "&" -> AND
        "'" -> SINGLE_QUOTE
        "(" -> PARENTHESIS_OPEN
        ")" -> PARENTHESIS_CLOSE
        "*" -> ASTERISK
        "+" -> PLUS
        "," -> COMMA
        "-" -> HYPHEN
        "." -> PERIOD
        "/" -> SLASH
        "0" -> ZERO
        "1" -> ONE
        "2" -> TWO
        "3" -> THREE
        "4" -> FOUR
        "5" -> FIVE
        "6" -> SIX
        "7" -> SEVEN
        "8" -> EIGHT
        "9" -> NINE
        ":" -> COLON
        ";" -> SEMICOLON
        "<" -> ANGLE_BRACKETS_OPEN
        "=" -> EQUAL
        ">" -> ANGLE_BRACKETS_CLOSE
        "?" -> QUESTION_MARK
        "@" -> AT
        "A" -> A_CAPITAL
        "B" -> B_CAPITAL
        "C" -> C_CAPITAL
        "D" -> D_CAPITAL
        "E" -> E_CAPITAL
        "F" -> F_CAPITAL
        "G" -> G_CAPITAL
        "H" -> H_CAPITAL
        "I" -> I_CAPITAL
        "J" -> J_CAPITAL
        "K" -> K_CAPITAL
        "L" -> L_CAPITAL
        "M" -> M_CAPITAL
        "N" -> N_CAPITAL
        "O" -> O_CAPITAL
        "P" -> P_CAPITAL
        "Q" -> Q_CAPITAL
        "R" -> R_CAPITAL
        "S" -> S_CAPITAL
        "T" -> T_CAPITAL
        "U" -> U_CAPITAL
        "V" -> V_CAPITAL
        "W" -> W_CAPITAL
        "X" -> X_CAPITAL
        "Y" -> Y_CAPITAL
        "Z" -> Z_CAPITAL
        "[" -> SQUARE_BRACKETS_OPEN
        "\\" -> BACKSLASH
        "]" -> SQUARE_BRACKETS_CLOSE
        "^" -> CARAT
        "_" -> UNDERSCORE
        "`" -> BACKTICK
        "a" -> A
        "b" -> B
        "c" -> C
        "d" -> D
        "e" -> E
        "f" -> F
        "g" -> G
        "h" -> H
        "i" -> I
        "j" -> J
        "k" -> K
        "l" -> L
        "m" -> M
        "n" -> N
        "o" -> O
        "p" -> P
        "q" -> Q
        "r" -> R
        "s" -> S
        "t" -> T
        "u" -> U
        "v" -> V
        "w" -> W
        "x" -> X
        "y" -> Y
        "z" -> Z
        "{" -> CURLY_BRACKETS_OPEN
        "|" -> PIPE
        "}" -> CURLY_BRACKETS_CLOSE
        "~" -> TILDE
        else -> Symbol(symbolString.codePointAt(0))
    }
}

val TAB: Symbol = Symbol('\t'.code)
val LINE_BREAK: Symbol = Symbol('\n'.code)
val BLANK: Symbol = Symbol(' '.code)
val EXCLAMATION_MARK = Symbol('!'.code)
val DOUBLE_QUOTE = Symbol('"'.code)
val HASH = Symbol('#'.code)
val DOLLAR = Symbol('$'.code)
val PERCENT = Symbol('%'.code)
val AND = Symbol('&'.code)
val SINGLE_QUOTE = Symbol('\''.code)
val PARENTHESIS_OPEN = Symbol('('.code)
val PARENTHESIS_CLOSE = Symbol(')'.code)
val ASTERISK = Symbol('*'.code)
val PLUS = Symbol('+'.code)
val COMMA = Symbol(','.code)
val HYPHEN = Symbol('-'.code)
val PERIOD = Symbol('.'.code)
val SLASH = Symbol('/'.code)

val ZERO = Symbol('0'.code)
val ONE = Symbol('1'.code)
val TWO = Symbol('2'.code)
val THREE = Symbol('3'.code)
val FOUR = Symbol('4'.code)
val FIVE = Symbol('5'.code)
val SIX = Symbol('6'.code)
val SEVEN = Symbol('7'.code)
val EIGHT = Symbol('8'.code)
val NINE = Symbol('9'.code)

val COLON = Symbol(':'.code)
val SEMICOLON = Symbol(';'.code)
val ANGLE_BRACKETS_OPEN = Symbol('<'.code)
val EQUAL = Symbol('='.code)
val ANGLE_BRACKETS_CLOSE = Symbol('>'.code)
val QUESTION_MARK = Symbol('?'.code)
val AT = Symbol('@'.code)

val A_CAPITAL: Symbol = Symbol('A'.code)
val B_CAPITAL: Symbol = Symbol('B'.code)
val C_CAPITAL: Symbol = Symbol('C'.code)
val D_CAPITAL: Symbol = Symbol('D'.code)
val E_CAPITAL: Symbol = Symbol('E'.code)
val F_CAPITAL: Symbol = Symbol('F'.code)
val G_CAPITAL: Symbol = Symbol('G'.code)
val H_CAPITAL: Symbol = Symbol('H'.code)
val I_CAPITAL: Symbol = Symbol('I'.code)
val J_CAPITAL: Symbol = Symbol('J'.code)
val K_CAPITAL: Symbol = Symbol('K'.code)
val L_CAPITAL: Symbol = Symbol('L'.code)
val M_CAPITAL: Symbol = Symbol('M'.code)
val N_CAPITAL: Symbol = Symbol('N'.code)
val O_CAPITAL: Symbol = Symbol('O'.code)
val P_CAPITAL: Symbol = Symbol('P'.code)
val Q_CAPITAL: Symbol = Symbol('Q'.code)
val R_CAPITAL: Symbol = Symbol('R'.code)
val S_CAPITAL: Symbol = Symbol('S'.code)
val T_CAPITAL: Symbol = Symbol('T'.code)
val U_CAPITAL: Symbol = Symbol('U'.code)
val V_CAPITAL: Symbol = Symbol('V'.code)
val W_CAPITAL: Symbol = Symbol('W'.code)
val X_CAPITAL: Symbol = Symbol('X'.code)
val Y_CAPITAL: Symbol = Symbol('Y'.code)
val Z_CAPITAL: Symbol = Symbol('Z'.code)

val SQUARE_BRACKETS_OPEN = Symbol('['.code)
val BACKSLASH = Symbol('\\'.code)
val SQUARE_BRACKETS_CLOSE = Symbol(']'.code)
val CARAT = Symbol('^'.code)
val UNDERSCORE = Symbol('_'.code)
val BACKTICK = Symbol('`'.code)

val A: Symbol = Symbol('a'.code)
val B: Symbol = Symbol('b'.code)
val C: Symbol = Symbol('c'.code)
val D: Symbol = Symbol('d'.code)
val E: Symbol = Symbol('e'.code)
val F: Symbol = Symbol('f'.code)
val G: Symbol = Symbol('g'.code)
val H: Symbol = Symbol('h'.code)
val I: Symbol = Symbol('i'.code)
val J: Symbol = Symbol('j'.code)
val K: Symbol = Symbol('k'.code)
val L: Symbol = Symbol('l'.code)
val M: Symbol = Symbol('m'.code)
val N: Symbol = Symbol('n'.code)
val O: Symbol = Symbol('o'.code)
val P: Symbol = Symbol('p'.code)
val Q: Symbol = Symbol('q'.code)
val R: Symbol = Symbol('r'.code)
val S: Symbol = Symbol('s'.code)
val T: Symbol = Symbol('t'.code)
val U: Symbol = Symbol('u'.code)
val V: Symbol = Symbol('v'.code)
val W: Symbol = Symbol('w'.code)
val X: Symbol = Symbol('x'.code)
val Y: Symbol = Symbol('y'.code)
val Z: Symbol = Symbol('z'.code)

val CURLY_BRACKETS_OPEN = Symbol('{'.code)
val PIPE = Symbol('|'.code)
val CURLY_BRACKETS_CLOSE = Symbol('}'.code)
val TILDE = Symbol('~'.code)
