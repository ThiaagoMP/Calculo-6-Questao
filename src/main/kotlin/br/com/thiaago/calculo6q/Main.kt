package br.com.thiaago.calculo6q

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.pow

data class Result(val result: Double, val month: Int, val monthExtensive: String)

fun main() {
    // Formula: E(t) = t² - 8t + 210

    val results = emptyList<Result>().toMutableList()

    for (t in 0..11) {
        val tPow = t.toDouble().pow(2)
        val tMultiplied = t.toDouble() * 8

        val result = tPow - tMultiplied + 210

        val resultObject = Result(result, t, getMonth(t))

        results.add(resultObject)

        println("E($t) = ${resultObject.result} ${resultObject.monthExtensive}")
        println("")
    }

    println("Meses que o consumo foi de 195.00:")
    results.filter { it.result == 195.00 }.forEach {
        println("E(${it.month}) = ${it.result} ${it.monthExtensive}")
        println("")
    }

    results.sortBy { it.result }
    println("Lista ordenada: ")
    results.forEach {
        println("E(${it.month}) = ${it.result} ${it.monthExtensive}")
        println("")
    }

}

fun getMonth(t: Int): String {
    val local = Locale("pt", "BR")
    val format: DateFormat = SimpleDateFormat("MMMM", local)
    return format.format(Date(0, t + 1, 0))
}