fun doSomethingWithCollection(collection: Collection<String>): Collection<String>? {

    val groupsByLength = collection.groupBy { it.length }

    val maximumSizeOfGroup = groupsByLength.values.maxOfOrNull { it.size }

    return groupsByLength.values.firstOrNull { it.isNotEmpty() }
}


fun main() {
    val collection = listOf("one", "two", "three", "four", "five")

    val groupsByLength = collection.groupBy { it.length }
    println("groupsByLength = $groupsByLength")

    val maximumSizeOfGroup = groupsByLength.values.maxOfOrNull { it.size }
    println("maximumSizeOfGroup = $maximumSizeOfGroup")

    val firstOrNull = groupsByLength.values.firstOrNull { it.isNotEmpty() }
    println("firstOrNull = $firstOrNull")
}

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
