class DateRange(val start: MyDate, val end: MyDate) : Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {
            var current = start

            override fun hasNext(): Boolean = current <= end

            override fun next(): MyDate {
                // end reached?
                if (!hasNext()) throw NoSuchElementException()

                // set the result to return to the current date in the range
                val result = current

                // advance to the following date (for the next iteration)
                current = current.followingDate()

                // return the previously remembered date
                return result
            }
        }
    }
}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}
