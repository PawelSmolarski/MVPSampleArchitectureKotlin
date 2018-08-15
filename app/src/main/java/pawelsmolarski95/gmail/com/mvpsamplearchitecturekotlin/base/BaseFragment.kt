package pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base

import android.app.Activity
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.AndroidApplication
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.injection.HasComponent
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.injection.component.ApplicationComponent
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.injection.modules.FragmentModule
import pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.navigator.Navigator

abstract class BaseFragment : Fragment(), BaseContract.BaseView {
    private var isInjected: Boolean = false

    protected abstract fun initializeInjector()

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeInjector()
        retainInstance = true

        try {
            isInjected = onInjectView()
        } catch (e: IllegalStateException) {
            Log.e("Injection Error", e.message)
            isInjected  = false
        }
    }

    protected fun getApplicationComponent(): ApplicationComponent? {
        if(activity == null)
            throw IllegalStateException("Lack of component")

        return (((activity as Activity).application) as AndroidApplication).applicationComponent
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Navigator.INSTANCE.setCurrentFragment(this)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if(!isInjected)
            isInjected = onInjectView()
    }

    @Throws(IllegalStateException::class)
    protected fun <C> getComponent(componentType: Class<C>): C {

        if (activity == null)
            throw IllegalStateException("Activity is null")

        return componentType.cast((activity as HasComponent<*>).getComponent())
                ?: throw IllegalStateException(componentType.simpleName + " has not been initialized yet.")
    }

    @Throws(IllegalStateException::class)
    protected open fun onInjectView(): Boolean {
        return false
    }

    protected fun getFragmentModule(): FragmentModule {
        return FragmentModule(this)
    }

    override fun errorNotification(messageId: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun errorNotification(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun successNotification(messageId: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoadingBar(messageId: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoadingBar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun successNotification(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isAvailable(): Boolean {
        return activity != null && isAdded && ((activity as BaseActivity)).isAvailable()
    }
}