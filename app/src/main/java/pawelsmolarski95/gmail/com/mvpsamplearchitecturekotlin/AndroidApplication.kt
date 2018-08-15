package pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin

import android.app.Application
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.injection.component.ApplicationComponent
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.injection.component.DaggerApplicationComponent
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.injection.modules.ApplicationModule

class AndroidApplication : Application() {
    var applicationComponent: ApplicationComponent? = null
        get() = field
        private set

    override fun onCreate() {
        super.onCreate()
        this.initializeInjector()
    }

    private fun initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }
}