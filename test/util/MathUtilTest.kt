package util

import org.junit.Assert.*
import org.junit.Test

class MathUtilTest {
    companion object {
        const val DELTA = .001
    }

    @Test
    fun shiftTest() {
        assertEquals(MathUtil.shift(1.0, 0.0, 2.0, 0.0, 10.0), 5.0, DELTA)
        assertEquals(MathUtil.shift(2.5, 1.5, 3.5, 0.0, 10.0), 5.0, DELTA)
        assertEquals(MathUtil.shift(2.5, 1.5, 3.5, 3.5, 4.5), 4.0, DELTA)
    }
}