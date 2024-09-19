package com.bignerdranch.nyethack

import java.io.File
class Tavern {
}
const val TAVERN_NAME = "Taernyl's Folly"

val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
val lastName = listOf("Ironfoot", "Fernsvorth", "Baggins")
val uniquePatrons = mutableSetOf<String>()
val menuList = File("data/tavern-menu-items.txt")
    .readText()
    .split("\n")
val patronGold = mutableMapOf<String, Double>()

fun main(args: Array<String>) {

    (0..9).forEach{
        val first = patronList.random()
        val last = lastName.random()
        val  name = "$first $last"
        uniquePatrons += name
    }
    uniquePatrons.forEach {
        patronGold[it] = 6.0
    }
    var orderCount = 0
    while (orderCount <= 9){
        placeOrder(uniquePatrons.random(), menuList.random())
        orderCount++
    }
    displayPatronBalances()
}

private fun displayPatronBalances() {
    patronGold.forEach { patron, balance ->
        println("$patron, balance: ${"%.2f".format(balance)}")
    }
}

fun performPurchase(price : Double, patronName: String) {

    val totalPurse = patronGold.getValue(patronName)
    patronGold[patronName] = totalPurse - price
}
private fun String.toDragonSpeak() =
    this.replace(Regex("[aeiouAEIOU]")) {
        when (it.value){
            "a", "A" -> "4"
            "e", "E" -> "3"
            "i", "I" -> "1"
            "o", "O" -> "0"
            "u", "U" -> "|_|"
            else -> it.value
        }
    }

private fun placeOrder(patronName: String, menuData: String){
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName speaks with $tavernMaster about their order.")
    val (type, name, price) = menuData.split(',')
    val totalPurse = patronGold.getValue(patronName)

    if(totalPurse > price.toDouble()) {
        val message = "$patronName buys a $name ($type) for $price"
        println(message)
        performPurchase(price.toDouble(), patronName)
        val phrase = if (name == "Dragon's Breath") {
            "$patronName exclaims ${("Ah, delicious $name".toDragonSpeak())}!"
        } else {
            "$patronName says: Thanks for the $name"
        }
        println(phrase)
    } else {
        println("Taernyl says: You've goy not enough money, milord!")
    }
}

private fun printMenu(){
    val firstLine = "*** Welcome to Taernyl's Folly ***"
    println(firstLine)
    println()

    for(menuItem in menuList){
        for(word in menuItem.split(' ')){
            if(!word.equals("of") || !word.equals("la")){

            }
        }
        var (type, name, price) = menuItem.split(',')
        var words = name.split(' ')
        name = ""
        for(word in words){
            if(!word.equals("of")){
                name += ( word.capitalize() + ' ')
            } else {
                name += (word + ' ')
            }
        }
        var dots = "."
        while (firstLine.length > (name.length + price.length + dots.length)){
            dots +=  "."
        }
    println("~[ $type ]~")
    println(name + dots + price)
    }



}
