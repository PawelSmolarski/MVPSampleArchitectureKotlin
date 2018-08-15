package pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.modules.examplefragment.injection

import dagger.Module
import dagger.Provides
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.injection.PerFragment
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.modules.examplefragment.ExampleContract
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.modules.examplefragment.ExampleModel
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.modules.examplefragment.ExamplePresenter

@Module
class ExampleModule(val view: ExampleContract.View) {
    @Provides
    @PerFragment
    fun providePresenter(model: ExampleModel): ExampleContract.Presenter {
        return ExamplePresenter(view, model)
    }

    @Provides
    @PerFragment
    fun provideModel(): ExampleModel {
        return ExampleModel()
    }
}