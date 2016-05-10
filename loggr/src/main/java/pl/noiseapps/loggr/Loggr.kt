package pl.noiseapps.loggr

import android.content.Context
import android.util.Log

object Loggr {
    private var context: Context? = null
    private var tag: String = "Loggr"
    private var isDebug: Boolean = true
    private var stackTraceCount: Int = 0

    @JvmStatic fun init(config: LoggrConfig) {
        this.context = config.context
        this.tag = config.tag
        this.isDebug = config.isDebug
        this.stackTraceCount = config.stackTraceEntriesCount
        LogPrinter.stackTraceCount = config.stackTraceEntriesCount
    }

    @JvmStatic fun setStackTraceCount(count: Int) {
        this.stackTraceCount = count
        LogPrinter.stackTraceCount = count
    }

    @JvmStatic fun setTag(tag: String) {
        this.tag = tag
    }

    private fun checkInstance() {
        if (context == null) {
            throw IllegalStateException("Must call Loggr#init before using the library")
        }
    }

    // VERBOSE

    @JvmOverloads @JvmStatic fun v(tag: String = Loggr.tag, message: String) {
        checkInstance()
        LogPrinter.print(Log.VERBOSE, tag, message)
    }

    @JvmOverloads @JvmStatic fun v(tag: String = Loggr.tag, message: String, vararg format: String) {
        checkInstance()
        LogPrinter.print(Log.VERBOSE, tag, message, *format)
    }

    @JvmOverloads @JvmStatic fun v(tag: String = Loggr.tag, obj: Any) {
        checkInstance()
        LogPrinter.print(Log.VERBOSE, tag, obj)
    }

    // DEBUG
    @JvmOverloads @JvmStatic fun d(tag: String = Loggr.tag, message: String) {
        checkInstance()
        LogPrinter.print(Log.DEBUG, tag, message)
    }

    @JvmOverloads @JvmStatic fun d(tag: String = Loggr.tag, obj: Any) {
        checkInstance()
        LogPrinter.print(Log.DEBUG, tag, obj)
    }

    // INFO
    @JvmOverloads @JvmStatic fun i(tag: String = Loggr.tag, message: String) {
        checkInstance()
        LogPrinter.print(Log.INFO, tag, message)
    }

    @JvmOverloads @JvmStatic fun i(tag: String = Loggr.tag, obj: Any) {
        checkInstance()
        LogPrinter.print(Log.INFO, tag, obj)
    }

    // WARN
    @JvmOverloads @JvmStatic fun w(tag: String = Loggr.tag, message: String) {
        checkInstance()
        LogPrinter.print(Log.WARN, tag, message)
    }

    @JvmOverloads @JvmStatic fun w(tag: String = Loggr.tag, obj: Any) {
        checkInstance()
        LogPrinter.print(Log.WARN, tag, obj)
    }

    // ERROR
    @JvmOverloads @JvmStatic fun e(tag: String = Loggr.tag, message: String) {
        checkInstance()
        LogPrinter.print(Log.ERROR, tag, message)
    }

    @JvmOverloads @JvmStatic fun e(tag: String = Loggr.tag, obj: Any) {
        checkInstance()
        LogPrinter.print(Log.ERROR, tag, obj)
    }

    @JvmOverloads @JvmStatic fun e(tag: String = Loggr.tag, error: Throwable) {
        checkInstance()
        LogPrinter.print(Log.ERROR, tag, error.message ?: "")
    }

    // OTHERS
    @JvmOverloads @JvmStatic fun json(tag: String = Loggr.tag, jsonString: String) {
        checkInstance()
        LogPrinter.printJson(tag, jsonString)
    }

}
