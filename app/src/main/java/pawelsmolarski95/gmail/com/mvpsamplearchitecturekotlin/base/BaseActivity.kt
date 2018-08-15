package pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v7.app.AppCompatActivity
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.AndroidApplication
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.injection.component.ApplicationComponent
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.injection.modules.ActivityModule

abstract class BaseActivity : AppCompatActivity() {
    private var isAvailable: Boolean = false

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectActivity()
    }

    @CallSuper
    override fun onResume() {
        super.onResume()
        isAvailable = true
    }

    @CallSuper
    override fun onPause() {
        super.onPause()
        isAvailable = false
    }

    private fun injectActivity() {
        getApplicationComponent()?.inject(this)
    }

    protected fun getApplicationComponent(): ApplicationComponent? {
        return (application as AndroidApplication).applicationComponent
    }

    protected fun getActivityModule(): ActivityModule {
        return ActivityModule(this)
    }

    fun isAvailable(): Boolean {
        return isAvailable
    }
}