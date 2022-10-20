import TimeInterval.*
import java.time.Year

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

// Supported intervals that might be added to dates:
enum class TimeInterval { DAY, WEEK, YEAR }

class RepeatedTimeInterval(val timeInterval: TimeInterval, val number: Int)

// override operator "plus" (+) to take a TimeInterval
operator fun MyDate.plus(timeInterval: TimeInterval): MyDate =
    addTimeIntervals(timeInterval, 1)

// override operator "plus" (+) to take a RepeastedTimeInterval
operator fun MyDate.plus(timeIntervals: RepeatedTimeInterval) =
    addTimeIntervals(timeIntervals.timeInterval, timeIntervals.number)

// not required, just for my practice
operator fun MyDate.minus(timeInterval: TimeInterval) =
    addTimeIntervals(timeInterval, -1)

// override operator "times" (*)
operator fun TimeInterval.times(number: Int) =
    RepeatedTimeInterval(this, number)




fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}

fun task3(today: MyDate): MyDate {
    return today - YEAR
}





