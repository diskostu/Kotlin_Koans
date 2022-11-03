fun main() {
    doSomethingWithCollectionOldStyle(listOf("one", "two", "three", "four", "five"))
}


//fun doSomethingWithCollection(collection: Collection<String>): Collection<String>? {
//
//    val groupsByLength = collection.groupBy { s -> TODO() }
//
//    val maximumSizeOfGroup = groupsByLength.values.map { group -> TODO() }.maxOrNull()
//
//    return groupsByLength.values.firstOrNull { group -> TODO() }
//}

fun doSomethingWithCollectionOldStyle(
    collection: Collection<String>,
): Collection<String>? {
    val groupsByLength = mutableMapOf<Int, MutableList<String>>()
    for (s in collection) {
        var strings: MutableList<String>? = groupsByLength[s.length]
        if (strings == null) {
            strings = mutableListOf()
            groupsByLength[s.length] = strings
        }
        strings.add(s)
    }

    var maximumSizeOfGroup = 0
    for (group in groupsByLength.values) {
        if (group.size > maximumSizeOfGroup) {
            maximumSizeOfGroup = group.size
        }
    }

    for (group in groupsByLength.values) {
        if (group.size == maximumSizeOfGroup) {
            return group
        }
    }
    return null
}
