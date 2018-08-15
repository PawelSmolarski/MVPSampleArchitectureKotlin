package pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base

interface BaseContract {
    interface BaseView {
        fun errorNotification(messageId: Int)

        fun errorNotification(message: String)

        fun successNotification(messageId: Int)

        fun successNotification(message: String)

        fun showLoadingBar(messageId: Int)

        fun hideLoadingBar()

        fun isAvailable(): Boolean
    }

    interface BasePresenter {
        fun onError(messageId: Int)

        fun onError(message: String)

        fun onSuccess(messageId: Int)

        fun onSuccess(message: String)

        fun onDataReceiving(messageId: Int)

        fun onDataReceived()

        fun isViewAvailable(): Boolean
    }
}