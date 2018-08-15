package pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.injection.component

import android.content.Context
import android.content.res.Resources
import dagger.Component
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.BaseActivity
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.injection.modules.ApplicationModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(baseActivity: BaseActivity)

    fun context(): Context

    fun resources(): Resources
}