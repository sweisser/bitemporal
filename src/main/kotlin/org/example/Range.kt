package org.example

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Range(start: String, end: String) {
    val start: LocalDate = LocalDate.parse(start, DateTimeFormatter.ISO_LOCAL_DATE)
    val end: LocalDate = LocalDate.parse(end, DateTimeFormatter.ISO_LOCAL_DATE)
}
