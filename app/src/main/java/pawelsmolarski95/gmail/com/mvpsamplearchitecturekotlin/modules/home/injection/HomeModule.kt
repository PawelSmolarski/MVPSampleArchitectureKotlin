package pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.modules.home.injection

import dagger.Module
import dagger.Provides
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.injection.PerActivity
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.modules.home.HomeContract
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.modules.home.HomePresenter

@Module
class HomeModule(val view: HomeContract.View) {
    @Provides
    @PerActivity
    fun presenter(): HomeContract.Presenter {
        return HomePresenter(view)
    }
}