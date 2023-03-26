package ch.addere.keystrokeenumerator.core.domain.model.symbol

import domain.model.symbol.A
import domain.model.symbol.AND
import domain.model.symbol.ANGLE_BRACKETS_CLOSE
import domain.model.symbol.ANGLE_BRACKETS_OPEN
import domain.model.symbol.ASTERISK
import domain.model.symbol.AT
import domain.model.symbol.A_CAPITAL
import domain.model.symbol.B
import domain.model.symbol.BACKSLASH
import domain.model.symbol.BACKTICK
import domain.model.symbol.BLANK
import domain.model.symbol.B_CAPITAL
import domain.model.symbol.C
import domain.model.symbol.CARAT
import domain.model.symbol.COLON
import domain.model.symbol.COMMA
import domain.model.symbol.CURLY_BRACKETS_CLOSE
import domain.model.symbol.CURLY_BRACKETS_OPEN
import domain.model.symbol.C_CAPITAL
import domain.model.symbol.D
import domain.model.symbol.DOLLAR
import domain.model.symbol.DOUBLE_QUOTE
import domain.model.symbol.D_CAPITAL
import domain.model.symbol.E
import domain.model.symbol.EIGHT
import domain.model.symbol.EQUAL
import domain.model.symbol.EXCLAMATION_MARK
import domain.model.symbol.E_CAPITAL
import domain.model.symbol.F
import domain.model.symbol.FIVE
import domain.model.symbol.FOUR
import domain.model.symbol.F_CAPITAL
import domain.model.symbol.G
import domain.model.symbol.G_CAPITAL
import domain.model.symbol.H
import domain.model.symbol.HASH
import domain.model.symbol.HYPHEN
import domain.model.symbol.H_CAPITAL
import domain.model.symbol.I
import domain.model.symbol.I_CAPITAL
import domain.model.symbol.J
import domain.model.symbol.J_CAPITAL
import domain.model.symbol.K
import domain.model.symbol.K_CAPITAL
import domain.model.symbol.L
import domain.model.symbol.LINE_BREAK
import domain.model.symbol.L_CAPITAL
import domain.model.symbol.M
import domain.model.symbol.M_CAPITAL
import domain.model.symbol.N
import domain.model.symbol.NINE
import domain.model.symbol.N_CAPITAL
import domain.model.symbol.O
import domain.model.symbol.ONE
import domain.model.symbol.O_CAPITAL
import domain.model.symbol.P
import domain.model.symbol.PARENTHESIS_CLOSE
import domain.model.symbol.PARENTHESIS_OPEN
import domain.model.symbol.PERCENT
import domain.model.symbol.PERIOD
import domain.model.symbol.PIPE
import domain.model.symbol.PLUS
import domain.model.symbol.P_CAPITAL
import domain.model.symbol.Q
import domain.model.symbol.QUESTION_MARK
import domain.model.symbol.Q_CAPITAL
import domain.model.symbol.R
import domain.model.symbol.R_CAPITAL
import domain.model.symbol.S
import domain.model.symbol.SEMICOLON
import domain.model.symbol.SEVEN
import domain.model.symbol.SINGLE_QUOTE
import domain.model.symbol.SIX
import domain.model.symbol.SLASH
import domain.model.symbol.SQUARE_BRACKETS_CLOSE
import domain.model.symbol.SQUARE_BRACKETS_OPEN
import domain.model.symbol.S_CAPITAL
import domain.model.symbol.T
import domain.model.symbol.TAB
import domain.model.symbol.THREE
import domain.model.symbol.TILDE
import domain.model.symbol.TWO
import domain.model.symbol.T_CAPITAL
import domain.model.symbol.U
import domain.model.symbol.UNDERSCORE
import domain.model.symbol.UNKNOWN
import domain.model.symbol.U_CAPITAL
import domain.model.symbol.V
import domain.model.symbol.V_CAPITAL
import domain.model.symbol.W
import domain.model.symbol.W_CAPITAL
import domain.model.symbol.X
import domain.model.symbol.X_CAPITAL
import domain.model.symbol.Y
import domain.model.symbol.Y_CAPITAL
import domain.model.symbol.Z
import domain.model.symbol.ZERO
import domain.model.symbol.Z_CAPITAL
import domain.model.symbol.from
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class SymbolTest {

    @Test
    fun testSymbolFromStringUnknown() {
        assertThat(from("Foo Bar Baz")).isEqualTo(UNKNOWN)
    }

    @Test
    fun testSymbolFromStringTab() {
        assertThat(from("TAB")).isEqualTo(TAB)
    }

    @Test
    fun testSymbolFromStringReturn() {
        assertThat(from("RETURN")).isEqualTo(LINE_BREAK)
    }

    @Test
    fun testSymbolFromStringSpace() {
        assertThat(from("SPACE")).isEqualTo(BLANK)
    }

    @Test
    fun testSymbolFromStringExclamationMark() {
        assertThat(from("!")).isEqualTo(EXCLAMATION_MARK)
    }

    @Test
    fun testSymbolFromStringQuote() {
        assertThat(from("\"")).isEqualTo(DOUBLE_QUOTE)
    }

    @Test
    fun testSymbolFromStringHash() {
        assertThat(from("#")).isEqualTo(HASH)
    }

    @Test
    fun testSymbolFromStringDollar() {
        assertThat(from("$")).isEqualTo(DOLLAR)
    }

    @Test
    fun testSymbolFromStringPercent() {
        assertThat(from("%")).isEqualTo(PERCENT)
    }

    @Test
    fun testSymbolFromStringAnd() {
        assertThat(from("&")).isEqualTo(AND)
    }

    @Test
    fun testSymbolFromStringSingleQuote() {
        assertThat(from("\'")).isEqualTo(SINGLE_QUOTE)
    }

    @Test
    fun testSymbolFromStringParenthesisOpen() {
        assertThat(from("(")).isEqualTo(PARENTHESIS_OPEN)
    }

    @Test
    fun testSymbolFromStringParenthesisClose() {
        assertThat(from(")")).isEqualTo(PARENTHESIS_CLOSE)
    }

    @Test
    fun testSymbolFromStringAsterisk() {
        assertThat(from("*")).isEqualTo(ASTERISK)
    }

    @Test
    fun testSymbolFromStringPlus() {
        assertThat(from("+")).isEqualTo(PLUS)
    }

    @Test
    fun testSymbolFromStringComma() {
        assertThat(from(",")).isEqualTo(COMMA)
    }

    @Test
    fun testSymbolFromStringHyphen() {
        assertThat(from("-")).isEqualTo(HYPHEN)
    }

    @Test
    fun testSymbolFromStringPeriod() {
        assertThat(from(".")).isEqualTo(PERIOD)
    }

    @Test
    fun testSymbolFromStringSlash() {
        assertThat(from("/")).isEqualTo(SLASH)
    }

    @Test
    fun testSymbolFromStringZero() {
        assertThat(from("0")).isEqualTo(ZERO)
    }

    @Test
    fun testSymbolFromStringOne() {
        assertThat(from("1")).isEqualTo(ONE)
    }

    @Test
    fun testSymbolFromStringTwo() {
        assertThat(from("2")).isEqualTo(TWO)
    }

    @Test
    fun testSymbolFromStringThree() {
        assertThat(from("3")).isEqualTo(THREE)
    }

    @Test
    fun testSymbolFromStringFour() {
        assertThat(from("4")).isEqualTo(FOUR)
    }

    @Test
    fun testSymbolFromStringFive() {
        assertThat(from("5")).isEqualTo(FIVE)
    }

    @Test
    fun testSymbolFromStringSix() {
        assertThat(from("6")).isEqualTo(SIX)
    }

    @Test
    fun testSymbolFromStringSeven() {
        assertThat(from("7")).isEqualTo(SEVEN)
    }

    @Test
    fun testSymbolFromStringEight() {
        assertThat(from("8")).isEqualTo(EIGHT)
    }

    @Test
    fun testSymbolFromStringNine() {
        assertThat(from("9")).isEqualTo(NINE)
    }

    @Test
    fun testSymbolFromStringColon() {
        assertThat(from(":")).isEqualTo(COLON)
    }

    @Test
    fun testSymbolFromStringSemicolon() {
        assertThat(from(";")).isEqualTo(SEMICOLON)
    }

    @Test
    fun testSymbolFromStringAngleBracketsOpen() {
        assertThat(from("<")).isEqualTo(ANGLE_BRACKETS_OPEN)
    }

    @Test
    fun testSymbolFromStringAngleBracketsEqual() {
        assertThat(from("=")).isEqualTo(EQUAL)
    }

    @Test
    fun testSymbolFromStringAngleBracketsClose() {
        assertThat(from(">")).isEqualTo(ANGLE_BRACKETS_CLOSE)
    }

    @Test
    fun testSymbolFromStringQuestionMark() {
        assertThat(from("?")).isEqualTo(QUESTION_MARK)
    }

    @Test
    fun testSymbolFromStringAt() {
        assertThat(from("@")).isEqualTo(AT)
    }

    @Test
    fun testSymbolFromStringACapital() {
        assertThat(from("A")).isEqualTo(A_CAPITAL)
    }

    @Test
    fun testSymbolFromStringBCapital() {
        assertThat(from("B")).isEqualTo(B_CAPITAL)
    }

    @Test
    fun testSymbolFromStringCCapital() {
        assertThat(from("C")).isEqualTo(C_CAPITAL)
    }

    @Test
    fun testSymbolFromStringDCapital() {
        assertThat(from("D")).isEqualTo(D_CAPITAL)
    }

    @Test
    fun testSymbolFromStringECapital() {
        assertThat(from("E")).isEqualTo(E_CAPITAL)
    }

    @Test
    fun testSymbolFromStringFCapital() {
        assertThat(from("F")).isEqualTo(F_CAPITAL)
    }

    @Test
    fun testSymbolFromStringGCapital() {
        assertThat(from("G")).isEqualTo(G_CAPITAL)
    }

    @Test
    fun testSymbolFromStringHCapital() {
        assertThat(from("H")).isEqualTo(H_CAPITAL)
    }

    @Test
    fun testSymbolFromStringICapital() {
        assertThat(from("I")).isEqualTo(I_CAPITAL)
    }

    @Test
    fun testSymbolFromStringJCapital() {
        assertThat(from("J")).isEqualTo(J_CAPITAL)
    }

    @Test
    fun testSymbolFromStringKCapital() {
        assertThat(from("K")).isEqualTo(K_CAPITAL)
    }

    @Test
    fun testSymbolFromStringLCapital() {
        assertThat(from("L")).isEqualTo(L_CAPITAL)
    }

    @Test
    fun testSymbolFromStringMCapital() {
        assertThat(from("M")).isEqualTo(M_CAPITAL)
    }

    @Test
    fun testSymbolFromStringNCapital() {
        assertThat(from("N")).isEqualTo(N_CAPITAL)
    }

    @Test
    fun testSymbolFromStringOCapital() {
        assertThat(from("O")).isEqualTo(O_CAPITAL)
    }

    @Test
    fun testSymbolFromStringPCapital() {
        assertThat(from("P")).isEqualTo(P_CAPITAL)
    }

    @Test
    fun testSymbolFromStringQCapital() {
        assertThat(from("Q")).isEqualTo(Q_CAPITAL)
    }

    @Test
    fun testSymbolFromStringRCapital() {
        assertThat(from("R")).isEqualTo(R_CAPITAL)
    }

    @Test
    fun testSymbolFromStringSCapital() {
        assertThat(from("S")).isEqualTo(S_CAPITAL)
    }

    @Test
    fun testSymbolFromStringTCapital() {
        assertThat(from("T")).isEqualTo(T_CAPITAL)
    }

    @Test
    fun testSymbolFromStringUCapital() {
        assertThat(from("U")).isEqualTo(U_CAPITAL)
    }

    @Test
    fun testSymbolFromStringVCapital() {
        assertThat(from("V")).isEqualTo(V_CAPITAL)
    }

    @Test
    fun testSymbolFromStringWCapital() {
        assertThat(from("W")).isEqualTo(W_CAPITAL)
    }

    @Test
    fun testSymbolFromStringXCapital() {
        assertThat(from("X")).isEqualTo(X_CAPITAL)
    }

    @Test
    fun testSymbolFromStringYCapital() {
        assertThat(from("Y")).isEqualTo(Y_CAPITAL)
    }

    @Test
    fun testSymbolFromStringZCapital() {
        assertThat(from("Z")).isEqualTo(Z_CAPITAL)
    }


    @Test
    fun testSymbolFromStringSquareBracketsOpen() {
        assertThat(from("[")).isEqualTo(SQUARE_BRACKETS_OPEN)
    }

    @Test
    fun testSymbolFromStringBackslash() {
        assertThat(from("\\")).isEqualTo(BACKSLASH)
    }

    @Test
    fun testSymbolFromStringSquareBracketsClose() {
        assertThat(from("]")).isEqualTo(SQUARE_BRACKETS_CLOSE)
    }

    @Test
    fun testSymbolFromStringCarat() {
        assertThat(from("^")).isEqualTo(CARAT)
    }

    @Test
    fun testSymbolFromStringUnderscore() {
        assertThat(from("_")).isEqualTo(UNDERSCORE)
    }

    @Test
    fun testSymbolFromStringBacktick() {
        assertThat(from("`")).isEqualTo(BACKTICK)
    }

    @Test
    fun testSymbolFromStringA() {
        assertThat(from("a")).isEqualTo(A)
    }

    @Test
    fun testSymbolFromStringB() {
        assertThat(from("b")).isEqualTo(B)
    }

    @Test
    fun testSymbolFromStringC() {
        assertThat(from("c")).isEqualTo(C)
    }

    @Test
    fun testSymbolFromStringD() {
        assertThat(from("d")).isEqualTo(D)
    }

    @Test
    fun testSymbolFromStringE() {
        assertThat(from("e")).isEqualTo(E)
    }

    @Test
    fun testSymbolFromStringF() {
        assertThat(from("f")).isEqualTo(F)
    }

    @Test
    fun testSymbolFromStringG() {
        assertThat(from("g")).isEqualTo(G)
    }

    @Test
    fun testSymbolFromStringH() {
        assertThat(from("h")).isEqualTo(H)
    }

    @Test
    fun testSymbolFromStringI() {
        assertThat(from("i")).isEqualTo(I)
    }

    @Test
    fun testSymbolFromStringJ() {
        assertThat(from("j")).isEqualTo(J)
    }

    @Test
    fun testSymbolFromStringK() {
        assertThat(from("k")).isEqualTo(K)
    }

    @Test
    fun testSymbolFromStringL() {
        assertThat(from("l")).isEqualTo(L)
    }

    @Test
    fun testSymbolFromStringM() {
        assertThat(from("m")).isEqualTo(M)
    }

    @Test
    fun testSymbolFromStringN() {
        assertThat(from("n")).isEqualTo(N)
    }

    @Test
    fun testSymbolFromStringO() {
        assertThat(from("o")).isEqualTo(O)
    }

    @Test
    fun testSymbolFromStringP() {
        assertThat(from("p")).isEqualTo(P)
    }

    @Test
    fun testSymbolFromStringQ() {
        assertThat(from("q")).isEqualTo(Q)
    }

    @Test
    fun testSymbolFromStringR() {
        assertThat(from("r")).isEqualTo(R)
    }

    @Test
    fun testSymbolFromStringS() {
        assertThat(from("s")).isEqualTo(S)
    }

    @Test
    fun testSymbolFromStringT() {
        assertThat(from("t")).isEqualTo(T)
    }

    @Test
    fun testSymbolFromStringU() {
        assertThat(from("u")).isEqualTo(U)
    }

    @Test
    fun testSymbolFromStringV() {
        assertThat(from("v")).isEqualTo(V)
    }

    @Test
    fun testSymbolFromStringW() {
        assertThat(from("w")).isEqualTo(W)
    }

    @Test
    fun testSymbolFromStringX() {
        assertThat(from("x")).isEqualTo(X)
    }

    @Test
    fun testSymbolFromStringY() {
        assertThat(from("y")).isEqualTo(Y)
    }

    @Test
    fun testSymbolFromStringZ() {
        assertThat(from("z")).isEqualTo(Z)
    }

    @Test
    fun testSymbolFromStringCurlyBracketsOpen() {
        assertThat(from("{")).isEqualTo(CURLY_BRACKETS_OPEN)
    }

    @Test
    fun testSymbolFromStringPipe() {
        assertThat(from("|")).isEqualTo(PIPE)
    }

    @Test
    fun testSymbolFromStringCurlyBracketsClose() {
        assertThat(from("}")).isEqualTo(CURLY_BRACKETS_CLOSE)
    }

    @Test
    fun testSymbolFromStringTilde() {
        assertThat(from("~")).isEqualTo(TILDE)
    }
}
