package pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.modules.examplefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.R
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.BaseFragment
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.modules.examplefragment.injection.DaggerExampleComponent
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.modules.examplefragment.injection.ExampleModule
import javax.inject.Inject

class ExampleFragment : BaseFragment(), ExampleContract.View {
    @Inject
    lateinit var presenter: ExampleContract.Presenter

    override fun initializeInjector() {
        DaggerExampleComponent
                .builder()
                .applicationComponent(getApplicationComponent())
                .exampleModule(ExampleModule(this))
                .fragmentModule(getFragmentModule())
                .build()
                .inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val fragmentView: View = inflater.inflate(R.layout.fragment_example, container, false)

        return fragmentView
    }
}