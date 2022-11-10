fun task(): List<Boolean> {
    val isEven: Int.() -> Boolean = {
        val isEven = this % 2 == 0
        println("Is $this even? -> $isEven")
        
        isEven
    }
    val isOdd: Int.() -> Boolean = {
        !this.isEven()
    }

    return listOf(42.isOdd(), 239.isOdd(), 294823098.isEven())
}


fun main() {
    println("task() = ${task()}")
}
