package pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin

import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.FrameLayout
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.BaseActivity
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.injection.HasComponent
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.navigator.Navigator
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.modules.home.HomeContract
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.modules.home.HomeFragment
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.modules.home.injection.DaggerHomeComponent
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.modules.home.injection.HomeComponent
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.modules.home.injection.HomeModule

class MainActivity : BaseActivity(), HasComponent<HomeComponent>, HomeContract.Presenter.HomeListener {
    private lateinit var homeComponent: HomeComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment: HomeContract.View = HomeFragment()
        Navigator.INSTANCE.initializeHomeFragment(homeFragment as Fragment, findViewById<FrameLayout>(R.id.flMainFragmentContainer), this)
        this.initializeInjector(homeFragment)
    }

    private fun initializeInjector(homeFragment: HomeContract.View) {
        homeComponent = DaggerHomeComponent
                .builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .homeModule(HomeModule(homeFragment))
                .build()
    }

    override fun getComponent(): HomeComponent {
        return homeComponent
    }

    override fun onBackPressed() {
        if (!Navigator.INSTANCE.onBackPressed())
            super.onBackPressed()
    }
}