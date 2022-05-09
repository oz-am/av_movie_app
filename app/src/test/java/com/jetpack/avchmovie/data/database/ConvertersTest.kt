package com.jetpack.avchmovie.data.database

import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test

class ConvertersTest {

    private lateinit var converter: Converters

    @Before
    fun setUp() {
        converter = Converters()
    }

    @Test
    fun fromSource() {
        val input = listOf("a", "b", "c", "d")
        val result = converter.fromSource(input)
        Truth.assertThat(result).contains("<>")
        Truth.assertThat(result).isEqualTo("a<>b<>c<>d")
    }

    @Test
    fun toSource() {
        val input = "a<>b<>c<>d"
        val result = converter.toSource(input)
        Truth.assertThat(result).doesNotContain("<>")
        Truth.assertThat(result.size).isEqualTo(4)
        Truth.assertThat(result[0]).isEqualTo("a")
    }

    @Test
    fun fromIntSource() {
        val input = listOf(1, 2, 3, 4)
        val result = converter.fromIntSource(input)
        Truth.assertThat(result).contains("<>")
        Truth.assertThat(result).isEqualTo("1<>2<>3<>4")
    }

    @Test
    fun toIntSource() {
        val input = "4<>3<>2<>1"
        val result = converter.toIntSource(input)
        Truth.assertThat(result).doesNotContain("<>")
        Truth.assertThat(result.size).isEqualTo(4)
        Truth.assertThat(result[0]).isEqualTo(4)
    }
}
