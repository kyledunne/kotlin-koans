class DateRange(val start: MyDate, val end: MyDate) : Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {
            var currentDate = start

            override fun hasNext(): Boolean {
                return currentDate <= end
            }

            override fun next(): MyDate {
                if (!hasNext()) throw NoSuchElementException()
                var returnVal = currentDate
                currentDate = currentDate.followingDate()
                return returnVal
            }
        }
    }
}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}