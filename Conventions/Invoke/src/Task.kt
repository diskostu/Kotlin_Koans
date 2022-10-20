class Invokable {
    var numberOfInvocations: Int = 0
        private set

    operator fun invoke(): Invokable {
        numberOfInvocations++
        println("numberOfInvocations = $numberOfInvocations")
        return this
    }
}

fun invokeTwice(invokable: Invokable) = invokable()()
