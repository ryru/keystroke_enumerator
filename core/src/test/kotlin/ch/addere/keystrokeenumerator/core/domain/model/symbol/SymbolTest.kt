package ch.addere.keystrokeenumerator.core.domain.model.symbol

import ch.addere.keystrokeenumerator.domain.model.symbol.A
import ch.addere.keystrokeenumerator.domain.model.symbol.AND
import ch.addere.keystrokeenumerator.domain.model.symbol.ANGLE_BRACKETS_CLOSE
import ch.addere.keystrokeenumerator.domain.model.symbol.ANGLE_BRACKETS_OPEN
import ch.addere.keystrokeenumerator.domain.model.symbol.ASTERISK
import ch.addere.keystrokeenumerator.domain.model.symbol.AT
import ch.addere.keystrokeenumerator.domain.model.symbol.A_CAPITAL
import ch.addere.keystrokeenumerator.domain.model.symbol.B
import ch.addere.keystrokeenumerator.domain.model.symbol.BACKSLASH
import ch.addere.keystrokeenumerator.domain.model.symbol.BACKTICK
import ch.addere.keystrokeenumerator.domain.model.symbol.BLANK
import ch.addere.keystrokeenumerator.domain.model.symbol.B_CAPITAL
import ch.addere.keystrokeenumerator.domain.model.symbol.C
import ch.addere.keystrokeenumerator.domain.model.symbol.CARAT
import ch.addere.keystrokeenumerator.domain.model.symbol.COLON
import ch.addere.keystrokeenumerator.domain.model.symbol.COMMA
import ch.addere.keystrokeenumerator.domain.model.symbol.CURLY_BRACKETS_CLOSE
import ch.addere.keystrokeenumerator.domain.model.symbol.CURLY_BRACKETS_OPEN
import ch.addere.keystrokeenumerator.domain.model.symbol.C_CAPITAL
import ch.addere.keystrokeenumerator.domain.model.symbol.D
import ch.addere.keystrokeenumerator.domain.model.symbol.DOLLAR
import ch.addere.keystrokeenumerator.domain.model.symbol.DOUBLE_QUOTE
import ch.addere.keystrokeenumerator.domain.model.symbol.D_CAPITAL
import ch.addere.keystrokeenumerator.domain.model.symbol.E
import ch.addere.keystrokeenumerator.domain.model.symbol.EIGHT
import ch.addere.keystrokeenumerator.domain.model.symbol.EQUAL
import ch.addere.keystrokeenumerator.domain.model.symbol.EXCLAMATION_MARK
import ch.addere.keystrokeenumerator.domain.model.symbol.E_CAPITAL
import ch.addere.keystrokeenumerator.domain.model.symbol.F
import ch.addere.keystrokeenumerator.domain.model.symbol.FIVE
import ch.addere.keystrokeenumerator.domain.model.symbol.FOUR
import ch.addere.keystrokeenumerator.domain.model.symbol.F_CAPITAL
import ch.addere.keystrokeenumerator.domain.model.symbol.G
import ch.addere.keystrokeenumerator.domain.model.symbol.G_CAPITAL
import ch.addere.keystrokeenumerator.domain.model.symbol.H
import ch.addere.keystrokeenumerator.domain.model.symbol.HASH
import ch.addere.keystrokeenumerator.domain.model.symbol.HYPHEN
import ch.addere.keystrokeenumerator.domain.model.symbol.H_CAPITAL
import ch.addere.keystrokeenumerator.domain.model.symbol.I
import ch.addere.keystrokeenumerator.domain.model.symbol.I_CAPITAL
import ch.addere.keystrokeenumerator.domain.model.symbol.J
import ch.addere.keystrokeenumerator.domain.model.symbol.J_CAPITAL
import ch.addere.keystrokeenumerator.domain.model.symbol.K
import ch.addere.keystrokeenumerator.domain.model.symbol.K_CAPITAL
import ch.addere.keystrokeenumerator.domain.model.symbol.L
import ch.addere.keystrokeenumerator.domain.model.symbol.LINE_BREAK
import ch.addere.keystrokeenumerator.domain.model.symbol.L_CAPITAL
import ch.addere.keystrokeenumerator.domain.model.symbol.M
import ch.addere.keystrokeenumerator.domain.model.symbol.M_CAPITAL
import ch.addere.keystrokeenumerator.domain.model.symbol.N
import ch.addere.keystrokeenumerator.domain.model.symbol.NINE
import ch.addere.keystrokeenumerator.domain.model.symbol.N_CAPITAL
import ch.addere.keystrokeenumerator.domain.model.symbol.O
import ch.addere.keystrokeenumerator.domain.model.symbol.ONE
import ch.addere.keystrokeenumerator.domain.model.symbol.O_CAPITAL
import ch.addere.keystrokeenumerator.domain.model.symbol.P
import ch.addere.keystrokeenumerator.domain.model.symbol.PARENTHESIS_CLOSE
import ch.addere.keystrokeenumerator.domain.model.symbol.PARENTHESIS_OPEN
import ch.addere.keystrokeenumerator.domain.model.symbol.PERCENT
import ch.addere.keystrokeenumerator.domain.model.symbol.PERIOD
import ch.addere.keystrokeenumerator.domain.model.symbol.PIPE
import ch.addere.keystrokeenumerator.domain.model.symbol.PLUS
import ch.addere.keystrokeenumerator.domain.model.symbol.P_CAPITAL
import ch.addere.keystrokeenumerator.domain.model.symbol.Q
import ch.addere.keystrokeenumerator.domain.model.symbol.QUESTION_MARK
import ch.addere.keystrokeenumerator.domain.model.symbol.Q_CAPITAL
import ch.addere.keystrokeenumerator.domain.model.symbol.R
import ch.addere.keystrokeenumerator.domain.model.symbol.R_CAPITAL
import ch.addere.keystrokeenumerator.domain.model.symbol.S
import ch.addere.keystrokeenumerator.domain.model.symbol.SEMICOLON
import ch.addere.keystrokeenumerator.domain.model.symbol.SEVEN
import ch.addere.keystrokeenumerator.domain.model.symbol.SINGLE_QUOTE
import ch.addere.keystrokeenumerator.domain.model.symbol.SIX
import ch.addere.keystrokeenumerator.domain.model.symbol.SLASH
import ch.addere.keystrokeenumerator.domain.model.symbol.SQUARE_BRACKETS_CLOSE
import ch.addere.keystrokeenumerator.domain.model.symbol.SQUARE_BRACKETS_OPEN
import ch.addere.keystrokeenumerator.domain.model.symbol.S_CAPITAL
import ch.addere.keystrokeenumerator.domain.model.symbol.T
import ch.addere.keystrokeenumerator.domain.model.symbol.TAB
import ch.addere.keystrokeenumerator.domain.model.symbol.THREE
import ch.addere.keystrokeenumerator.domain.model.symbol.TILDE
import ch.addere.keystrokeenumerator.domain.model.symbol.TWO
import ch.addere.keystrokeenumerator.domain.model.symbol.T_CAPITAL
import ch.addere.keystrokeenumerator.domain.model.symbol.U
import ch.addere.keystrokeenumerator.domain.model.symbol.UNDERSCORE
import ch.addere.keystrokeenumerator.domain.model.symbol.U_CAPITAL
import ch.addere.keystrokeenumerator.domain.model.symbol.V
import ch.addere.keystrokeenumerator.domain.model.symbol.V_CAPITAL
import ch.addere.keystrokeenumerator.domain.model.symbol.W
import ch.addere.keystrokeenumerator.domain.model.symbol.W_CAPITAL
import ch.addere.keystrokeenumerator.domain.model.symbol.X
import ch.addere.keystrokeenumerator.domain.model.symbol.X_CAPITAL
import ch.addere.keystrokeenumerator.domain.model.symbol.Y
import ch.addere.keystrokeenumerator.domain.model.symbol.Y_CAPITAL
import ch.addere.keystrokeenumerator.domain.model.symbol.Z
import ch.addere.keystrokeenumerator.domain.model.symbol.ZERO
import ch.addere.keystrokeenumerator.domain.model.symbol.Z_CAPITAL
import ch.addere.keystrokeenumerator.domain.model.symbol.from
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class SymbolTest {

    @Test
    fun testSymbolFromStringUseFirstLetterInString() {
        assertThat(from("Foo Bar Baz")).isEqualTo(F_CAPITAL)
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
