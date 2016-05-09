package pl.noiseapps.loggr

import android.content.Context
import android.util.Log

object Loggr {
    private var context: Context? = null
    private var tag: String = "Loggr"
    private var isDebug: Boolean = true

    @JvmOverloads fun init(context: Context, tag: String = "Loggr", isDebug: Boolean = true) {
        this.context = context
        this.tag = tag
        this.isDebug = isDebug
    }


    @JvmStatic fun setTag(tag : String) {
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
    }

    @JvmOverloads @JvmStatic fun v(tag: String = Loggr.tag, obj: Any) {
        checkInstance()
    }

    // DEBUG
    @JvmOverloads @JvmStatic fun d(tag: String = Loggr.tag, message: String) {
        checkInstance()
    }

    @JvmOverloads @JvmStatic fun d(tag: String = Loggr.tag, obj: Any) {
        checkInstance()
    }
    // INFO
    @JvmOverloads @JvmStatic fun i(tag: String = Loggr.tag, message: String) {
        checkInstance()
    }

    @JvmOverloads @JvmStatic fun i(tag: String = Loggr.tag, obj: Any) {
        checkInstance()
    }
    // WARN
    @JvmOverloads @JvmStatic fun w(tag: String = Loggr.tag, message: String) {
        checkInstance()
    }

    @JvmOverloads @JvmStatic fun w(tag: String = Loggr.tag, obj: Any) {
        checkInstance()
    }
    // ERROR
    @JvmOverloads @JvmStatic fun e(tag: String = Loggr.tag, message: String) {
        checkInstance()
    }

    @JvmOverloads @JvmStatic fun e(tag: String = Loggr.tag, obj: Any) {
        checkInstance()
    }
    // OTHERS
    @JvmStatic fun json(jsonString: String) {
        checkInstance()
    }

}
