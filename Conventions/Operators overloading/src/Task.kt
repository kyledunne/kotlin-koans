import TimeInterval.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

// Supported intervals that might be added to dates:
enum class TimeInterval { DAY, WEEK, YEAR }

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate =
        addTimeIntervals(timeInterval, 1)

fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}

class RepeatedTimeInterval(val timeInterval: TimeInterval, val repetitions: Int)

operator fun TimeInterval.times(repetitions: Int): RepeatedTimeInterval =
        RepeatedTimeInterval(this, repetitions)

operator fun MyDate.plus(repeatedTimeInterval: RepeatedTimeInterval): MyDate =
        addTimeIntervals(repeatedTimeInterval.timeInterval, repeatedTimeInterval.repetitions)
