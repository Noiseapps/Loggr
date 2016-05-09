package pl.noiseapps.loggr

import android.content.Context

data class LoggrConfig @JvmOverloads constructor(val context: Context,
                                                 val tag: String = "Loggr",
                                                 val isDebug: Boolean = true,
                                                 val stackTraceEntriesCount: Int = 5)
