package com.github.ajalt.clikt.parameters.types

import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.testing.TestCommand
import io.kotlintest.matchers.types.shouldBeInstanceOf
import org.junit.Test
import java.io.File

class FileTypeTest {
    @Test
    fun `file option with default args`() {
        class C : TestCommand() {
            val x by option("-x", "--xx").file()
            override fun run_() {
                x!!.shouldBeInstanceOf<File>()
            }
        }

        C().parse("-x.")
    }

    @Test
    fun `file argument with default args`() {
        class C : TestCommand() {
            val x by argument().file()
            override fun run_() {
                x.shouldBeInstanceOf<File>()
            }
        }

        C().parse(".")
    }
}
