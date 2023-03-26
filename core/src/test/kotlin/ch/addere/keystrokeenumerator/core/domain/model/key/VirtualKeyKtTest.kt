package ch.addere.keystrokeenumerator.core.domain.model.key

import domain.model.key.VirtualKey.N
import domain.model.key.VirtualKey.OEM_3
import domain.model.key.VirtualKey.OEM_6
import domain.model.key.VirtualKey.SHIFT
import domain.model.key.VirtualKey.SPACE
import domain.model.key.VirtualKey.TAB
import domain.model.key.VirtualKey.TWO
import domain.model.key.parse
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class VirtualKeyKtTest {

    @Test
    fun testSingleSpecialCharacterValidInput() {
        val result = parse("TAB")
        assertThat(result).containsExactly(TAB)
    }

    @Test
    fun testSingleNumberValidInput() {
        val result = parse("TWO")
        assertThat(result).containsExactly(TWO)
    }

    @Test
    fun testSingleLetterValidInput() {
        val result = parse("N")
        assertThat(result).containsExactly(N)
    }

    @Test
    fun testDoubleValidInput() {
        val result = parse("SHIFT+OEM_3")
        assertThat(result).containsExactly(SHIFT, OEM_3)
    }

    @Test
    fun testTripleValidInput() {
        val result = parse("SHIFT+OEM_6+SPACE")
        assertThat(result).containsExactly(SHIFT, OEM_6, SPACE)
    }
}
