package pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.injection.component

import android.support.v4.app.Fragment
import dagger.Component
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.injection.PerFragment
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.injection.modules.FragmentModule

@PerFragment
@Component(dependencies = [ApplicationComponent::class], modules = [FragmentModule::class])
interface FragmentComponent {
    fun fragment(): Fragment
}