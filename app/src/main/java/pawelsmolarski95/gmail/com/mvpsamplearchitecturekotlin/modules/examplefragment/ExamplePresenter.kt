package pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.modules.examplefragment

import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.BasePresenter
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.PresenterTag
import javax.inject.Inject

class ExamplePresenter @Inject constructor(val view: ExampleContract.View, val model: ExampleModel) : BasePresenter(view), ExampleContract.Presenter {
    override fun getPresenterTag(): String {
        return PresenterTag.EXAMPLE_PRESENTER_TAG.tag
    }
}