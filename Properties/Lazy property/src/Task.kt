class LazyProperty(val initializer: () -> Int) {
    private var lala: Int? = null

    val lazy: Int
        get() {
            if (lala == null) {
                lala = initializer()
            }

            return lala!!
        }
}
