package com.example.androidtechnicalexamination

import com.example.androidtechnicalexamination.extension.toUiPreview
import junit.framework.TestCase.assertEquals
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class BirthDateTest {

    @Test
    fun test0WrongDateFormat() {
        val birthDate = "01-22-1957T06:56:10.393Z".toUiPreview()
        val expectedOutput = ""
        assertEquals(expectedOutput, birthDate)
    }

    @Test
    fun test1CorrectDateFormat() {
        val birthDate = "1957-01-22T06:56:10.393Z".toUiPreview()
        val expectedOutput = "January 22, 1957"
        assertEquals(expectedOutput, birthDate)
    }
}