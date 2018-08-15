package pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.modules.examplefragment.injection

import dagger.Component
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.injection.PerFragment
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.injection.component.ApplicationComponent
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.injection.component.FragmentComponent
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.injection.modules.FragmentModule
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.modules.examplefragment.ExampleContract
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.modules.examplefragment.ExampleFragment
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.modules.examplefragment.ExampleModel

@PerFragment
@Component(dependencies = [ApplicationComponent::class], modules = [FragmentModule::class, ExampleModule::class])
interface ExampleComponent : FragmentComponent{
    fun inject(exampleFragment: ExampleFragment)

    fun providePresenter(): ExampleContract.Presenter

    fun provideModel(): ExampleModel
}