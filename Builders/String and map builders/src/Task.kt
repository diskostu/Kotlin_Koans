/* TODO */

fun usage(): Map<Int, String> {
    return buildMutableMap {
        put(0, "0")
        println("size = $size")
        for (i in 1..10) {
            put(i, "$i")
            println("size = $size")
        }
    }
}

fun <K, V> buildMutableMap(build: HashMap<K, V>.() -> Unit): Map<K, V> {
    val myHashMap = HashMap<K, V>()
    myHashMap.build()
    return myHashMap
}


fun main() {
    println("usage() = ${usage()}")
}
