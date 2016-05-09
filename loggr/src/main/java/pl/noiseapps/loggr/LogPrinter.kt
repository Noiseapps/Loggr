package pl.noiseapps.loggr

import android.util.Log

object LogPrinter {

    private val DIVIDER: String = "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"
    private val EMPTY_LINE: String = "+"
    private val SPACING: String = ""
    var stackTraceCount: Int = 2

    internal fun print(priority: Int, tag: String, message: String) {
        printString(priority, tag, message)
    }

    internal fun print(priority: Int, tag: String, `object`: Any) {
        val objectStringRepresentation = ObjectLogger.getObjectRepresentation(`object`)
        printString(priority, tag, objectStringRepresentation)
    }

    private fun printString(priority: Int, tag: String, message: String) {
        Log.println(priority, tag, SPACING)
        if(stackTraceCount > 0) {
            printCallingMethod(priority, tag)
        }
        printMessage(message, priority, tag)
        Log.println(priority, tag, DIVIDER)
    }

    private fun printMessage(message: String, priority: Int, tag: String) {
        Log.println(priority, tag, EMPTY_LINE)
        val lines = message.split(System.getProperty("line.separator"))
        lines.forEach { line ->
            val formattedMessage = String.format("+\t%s", line)
            Log.println(priority, tag, formattedMessage)
        }
        Log.println(priority, tag, EMPTY_LINE)
    }

    private fun printCallingMethod(priority: Int, tag: String) {
        Log.println(priority, tag, DIVIDER)
        Log.println(priority, tag, EMPTY_LINE)
        val throwable = Throwable("")
        val stackTraceElements = throwable.stackTrace.sliceArray(6..throwable.stackTrace.size)
        val size = Math.min(stackTraceCount, stackTraceElements.size)-1
        var indents = "\t"
        for (i in 0..size) {
            val callable = stackTraceElements[i]
            val call = String.format("+%s%s.%s (%s:%d)", indents, callable.className, callable.methodName, callable.fileName, callable.lineNumber)
            Log.println(priority, tag, call)
            indents += "\t"
        }
        Log.println(priority, tag, EMPTY_LINE)
        Log.println(priority, tag, DIVIDER)
    }
}
