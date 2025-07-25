package org.openjdk.jmc.flightrecorder.testutils.parser;

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.io.ByteArrayInputStream
import kotlin.experimental.or

class RecordingStreamTest {

    @Test
    fun shouldParse6164InTwoBytes() {
        val input = ByteArrayInputStream(byteArrayOf(-108, 48))

        val output = RecordingStream(input).readVarlong()

        assertThat(output).isEqualTo(6164)
    }

    @Test
    fun shouldParse6164InFiveBytes() {
        val leadingZeros = 0b10000000.toByte()
        val input = ByteArrayInputStream(
            byteArrayOf(
                -108,
                leadingZeros or 48,
                leadingZeros,
                leadingZeros,
                0b0000000
            )
        )

        val output = RecordingStream(input).readVarlong()

        assertThat(output).isEqualTo(6164)
    }

    @Test
    fun shouldParseStartTime() {
        val input = ByteArrayInputStream(byteArrayOf(-22, -90, -45, -116, -84, 16, 0))

        val output = RecordingStream(input).readVarlong()

        assertThat(output).isEqualTo(561593504618L)
    }

}
