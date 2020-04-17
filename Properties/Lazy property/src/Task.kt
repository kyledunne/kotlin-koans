class LazyProperty(val initializer: () -> Int) {
    var _lazy: Int = 0
    var isLazyInitialized = false
    val lazy: Int
        get() {
            if (!isLazyInitialized) {
                _lazy = initializer()
                isLazyInitialized = true
            }
            return _lazy
        }
}
