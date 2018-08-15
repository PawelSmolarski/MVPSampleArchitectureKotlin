package pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base

import android.util.Log

abstract class BasePresenter protected constructor(val baseView: BaseContract.BaseView) : BaseContract.BasePresenter {
    protected abstract fun getPresenterTag(): String

    override fun onError(messageId: Int) {
        baseView.errorNotification(messageId)
    }

    override fun onError(message: String) {
        Log.d(getPresenterTag(), message)
        baseView.errorNotification(message)
    }

    override fun onSuccess(messageId: Int) {
        baseView.successNotification(messageId)
    }

    override fun onSuccess(message: String) {
        baseView.successNotification(message)
    }

    override fun onDataReceiving(messageId: Int) {
        baseView.showLoadingBar(messageId)
    }

    override fun isViewAvailable(): Boolean {
        return baseView.isAvailable()
    }

    override fun onDataReceived() {
        baseView.hideLoadingBar()
    }
}