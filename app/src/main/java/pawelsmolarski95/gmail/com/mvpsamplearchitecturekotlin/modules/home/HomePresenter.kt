package pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.modules.home

import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.BasePresenter
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.PresenterTag
import javax.inject.Inject

class HomePresenter @Inject constructor(val view: HomeContract.View) : BasePresenter(view), HomeContract.Presenter {
    private val TAG: String = PresenterTag.HOME_PRESENTER_TAG.tag

    override fun getPresenterTag(): String {
        return TAG
    }
}