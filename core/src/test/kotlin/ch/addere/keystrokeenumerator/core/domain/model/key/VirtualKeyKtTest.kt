package ch.addere.keystrokeenumerator.core.domain.model.key

import ch.addere.keystrokeenumerator.core.domain.model.key.VirtualKey.N
import ch.addere.keystrokeenumerator.core.domain.model.key.VirtualKey.OEM_3
import ch.addere.keystrokeenumerator.core.domain.model.key.VirtualKey.OEM_6
import ch.addere.keystrokeenumerator.core.domain.model.key.VirtualKey.SHIFT
import ch.addere.keystrokeenumerator.core.domain.model.key.VirtualKey.SPACE
import ch.addere.keystrokeenumerator.core.domain.model.key.VirtualKey.TAB
import ch.addere.keystrokeenumerator.core.domain.model.key.VirtualKey.TWO
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
