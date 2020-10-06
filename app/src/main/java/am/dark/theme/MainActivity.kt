package am.dark.theme

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkMode()
        setStatusBarColor(this)

        setContentView(R.layout.activity_main)
        //Dark Mode
        swTest.isChecked = InitApplication.instance.isNightModeEnabled()
        swTest.setOnCheckedChangeListener { p0, p1 ->
            if (p1) {
                InitApplication.instance.setIsNightModeEnabled(true)
            } else {
                InitApplication.instance.setIsNightModeEnabled(false)
            }
            this.recreate()
        }
    }
}