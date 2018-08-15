package pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.modules.home.injection

import dagger.Component
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.injection.PerActivity
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.injection.component.ActivityComponent
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.injection.component.ApplicationComponent
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.injection.modules.ActivityModule
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.modules.home.HomeContract
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.modules.home.HomeFragment

@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class, HomeModule::class])
interface HomeComponent : ActivityComponent {
    fun inject(homeFragment: HomeFragment)

    fun presenter(): HomeContract.Presenter
}