package pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.modules.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.R
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.BaseFragment
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.modules.home.injection.HomeComponent
import javax.inject.Inject
import kotlinx.android.synthetic.main.fragment_home.*
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.navigator.Navigator
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.modules.examplefragment.ExampleFragment
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.modules.examplefragment.ExampleModel
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.modules.examplefragment.injection.ExampleModule

class HomeFragment : BaseFragment(), HomeContract.View {
    @Inject
    lateinit var presenter: HomeContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val fragmentView: View = inflater.inflate(R.layout.fragment_home, container, false)

        return fragmentView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initializeViews()
    }

    private fun initializeViews() {
        btnGoSecond.setOnClickListener {
            Navigator.INSTANCE.navigateView(ExampleFragment(), null, true, false)
        }
    }

    @Throws(IllegalStateException::class)
    override fun onInjectView(): Boolean {
        getComponent(HomeComponent::class.java).inject(this)
        return true
    }

    override fun initializeInjector() {
        //does nothing
    }

}