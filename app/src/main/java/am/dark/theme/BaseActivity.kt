package am.dark.theme

import android.app.Activity
import android.os.Build
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat


abstract class BaseActivity : AppCompatActivity() {

    fun setStatusBarColor(activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = activity.window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            if (InitApplication.instance.isNightModeEnabled()){
                window.statusBarColor = ContextCompat.getColor(activity, R.color.colorLightPurple)
            } else {
                window.statusBarColor = ContextCompat.getColor(activity, R.color.colorPrimary)
            }
        }
    }

    fun checkMode() {
        if (InitApplication.instance.isNightModeEnabled()){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }


}