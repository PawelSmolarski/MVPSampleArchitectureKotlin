package pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.injection.component

import android.app.Activity
import dagger.Component
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.injection.PerActivity
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.injection.modules.ActivityModule

@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    fun activity(): Activity
}