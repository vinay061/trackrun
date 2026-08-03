package com.project.domain

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class UserDataValidatorTest {
//    @Test
//    fun `2 plus 2 equals 4`() {
//        val result = 2 + 2
//        assertEquals(4, result)
//    }
    private lateinit var userDataValidator: UserDataValidator
    @Test
    fun anotherTest() {
        assertThat(2 + 2).isEqualTo(4)
    }

    @BeforeEach
    fun setUp() {
        userDataValidator = UserDataValidator(
            patternValidator = object: PatternValidator {
                override fun matches(value: String): Boolean {
                    return true
                }
            }
        )
    }

    @Test
    fun validPasswordTest() {
        val result = userDataValidator.validatePassword("Test12345")
        assertTrue(result.hasMinLen)
        assertTrue(result.hasDigit)
        assertTrue(result.hasLowerCase)
        assertTrue(result.hasUpperCase)
    }

    @ParameterizedTest
    @CsvSource(
        "Test12345, true",
        "test7894, false",
        "TEST7894, false",
        "text_457, false")
    fun validateMultiplePasswordTest(password: String, expectedValue: Boolean) {
        val result = userDataValidator.validatePassword(password)
        assertThat(result.isValid).isEqualTo(expectedValue)
    }
}