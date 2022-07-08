package com.example.stremchatsdk.activity

import android.widget.Toast

fun main() {
    val string = "DhausM"

    if (string.toSet().size.equals(string.length)) {
         println(string.reversed())
    } else {
      println(" $string is  does not have Unique characters")
    }


    val zippedList = listOf(1 to "one", 2 to "two", 3 to "three", 4 to "four", 5 to "five")
    val unzippedList = zippedList.unzip();
    var map = mapOf(1 to "hello", 2 to "peace", 3 to "ochuko")
   /* println(map.keys)
    println(map.values)*/


  /*  println(zippedList.unzip().first)
    println(zippedList.unzip().second)*/

    val firstArray = intArrayOf(1, 2, 3, 4, 5)
    val secondArray = arrayOf("one", "two", "three", "four", "five")
    val thirdArray = arrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j')



   /* println(firstArray.zip(secondArray) { a, b -> "$a to $b" })
    println(zippedList)
    println(secondArray.zip(thirdArray) { a, b -> "$a:$b" })*/


}