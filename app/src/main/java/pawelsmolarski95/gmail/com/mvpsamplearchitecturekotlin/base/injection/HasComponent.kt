package pawelsmolarski95.gmail.com.mvpsamplearchitecturekotlin.base.injection

interface HasComponent<out C> {
    fun getComponent(): C
}