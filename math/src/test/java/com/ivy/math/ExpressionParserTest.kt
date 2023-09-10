package com.ivy.math

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.ivy.parser.Parser
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class ExpressionParserTest {


    private lateinit var parser: Parser<TreeNode>


    @BeforeEach
    fun setUp() {
        parser = expressionParser()
    }

    @ParameterizedTest
    @CsvSource(
        "6*(3+6), 54.0",
        "9+6, 15.0",
        "9-2, 7.0",
        "9/3+2, 5.0",
    )
    fun `Test evaluating expression`(expression: String, expected: Double) {
        val evaluation = parser(expression).first()

        val actual = evaluation.value.eval()

        assertThat(actual).isEqualTo(expected)
    }



}

