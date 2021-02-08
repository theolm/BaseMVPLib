package com.theomota.basemvplib.extensions

import java.text.SimpleDateFormat
import java.time.Instant
import java.util.*

private const val ISO_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"

fun String.toIsoDate() : Date {
    val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
    formatter.timeZone = TimeZone.getTimeZone("UTC")
    return formatter.parse(this)!!
}

fun Long.toIsoDate() : Date = Date(this)

fun Int.toIsoDate() : Date = Date(this.toLong())

fun Date.toIsoString(): String = SimpleDateFormat(ISO_DATE_FORMAT, Locale("pt","BR")).format(this)

fun Date.toFormat(pattern: String) : String = SimpleDateFormat(pattern, Locale.getDefault()).format(this)

fun Date.intervalFromNow() : String {
    val now = Date()
    val interval = now.time - this.time

    return when {
        interval < 60000 -> "menos de um minuto"
        interval < 3600000 -> "1h atrás"
        interval < 3600000 * 2 -> "2h atrás"
        interval < 3600000 * 3 -> "3h atrás"
        interval < 3600000 * 4 -> "4h atrás"
        interval < 3600000 * 5 -> "5h atrás"
        interval < 3600000 * 6 -> "6h atrás"
        interval < 3600000 * 7 -> "7h atrás"
        interval < 3600000 * 8 -> "8h atrás"
        interval < 3600000 * 9 -> "9h atrás"
        interval < 3600000 * 10 -> "10h atrás"
        interval < 3600000 * 11 -> "11h atrás"
        interval < 3600000 * 12 -> "12h atrás"
        interval < 3600000 * 13 -> "13h atrás"
        interval < 3600000 * 14 -> "14h atrás"
        interval < 3600000 * 15 -> "15h atrás"
        interval < 3600000 * 16 -> "16h atrás"
        interval < 3600000 * 17 -> "17h atrás"
        interval < 3600000 * 18 -> "18h atrás"
        interval < 3600000 * 19 -> "19h atrás"
        interval < 3600000 * 20 -> "20h atrás"
        interval < 3600000 * 21 -> "21h atrás"
        interval < 3600000 * 22 -> "22h atrás"
        interval < 3600000 * 23 -> "23h atrás"
        interval < 3600000 * 24 -> "24h atrás"
        else -> this.toFormat("dd MMM à's' HH:mm")
    }
}