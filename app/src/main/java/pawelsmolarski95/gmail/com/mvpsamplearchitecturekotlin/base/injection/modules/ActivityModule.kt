package pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.injection.modules

import android.app.Activity
import dagger.Module
import dagger.Provides
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.injection.PerActivity

@Module
class ActivityModule(val activity: Activity) {
    @Provides
    @PerActivity
    fun activity(): Activity {
        return activity
    }
}