package pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.injection.modules

import android.support.v4.app.Fragment
import dagger.Module
import dagger.Provides
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.injection.PerFragment

@Module
class FragmentModule(val fragment: Fragment) {
    @Provides
    @PerFragment
    fun fragment(): Fragment {
        return fragment
    }
}