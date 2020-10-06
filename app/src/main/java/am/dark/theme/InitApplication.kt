package am.dark.theme

import android.app.Application
import androidx.preference.PreferenceManager


class InitApplication : Application() {
    private var isNightModeEnabled = false

    override fun onCreate() {
        super.onCreate()
        singleton = this
        val mPrefs = PreferenceManager.getDefaultSharedPreferences(this)
        this.isNightModeEnabled = mPrefs.getBoolean(NIGHT_MODE, false)
    }

    fun isNightModeEnabled(): Boolean {
        return isNightModeEnabled
    }

    fun setIsNightModeEnabled(isNightModeEnabled: Boolean) {
        this.isNightModeEnabled = isNightModeEnabled

        val mPrefs = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = mPrefs.edit()
        editor.putBoolean(NIGHT_MODE, isNightModeEnabled)
        editor.apply()
    }


    companion object {
        val NIGHT_MODE = "NIGHT_MODE"
        private var singleton: InitApplication? = null

        val instance: InitApplication
            get() {

                if (singleton == null) {
                    singleton = InitApplication()
                }
                return singleton!!
            }
    }
}