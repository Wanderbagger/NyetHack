import kotlin.math.roundToInt
class Tavern {
}
const val TAVERN_NAME = "Taernyl's Folly"
var playerGold = 10
var playerSilver = 10
val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
fun main(args: Array<String>) {
    placeOrder("shandy,Dragon's Breath,5.91")
    patronList.remove("Eli")
    patronList.add("Alex")
    println(patronList)
}

fun performPurchase(price : Double){
    displayBalance()
    val totalPurse = playerGold + (playerSilver/100.0)
    println("Total purse: $totalPurse")
    println("Purchasing item for $price")
    val remainingBalance = totalPurse - price
    println("Remaining balance: ${"%.2f".format(remainingBalance)}")
    val remainingGold = remainingBalance.toInt()
    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
    playerGold = remainingGold
    playerSilver = remainingSilver
    displayBalance()
}
private fun displayBalance(){
    println("Player's purse balance: Gold: $playerGold, Silver: $playerSilver")
}
private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiouAEIOU]")) {
        when (it.value){
            "a", "A" -> "4"
            "e", "E" -> "3"
            "i", "I" -> "1"
            "o", "O" -> "0"
            "u", "U" -> "|_|"
            else -> it.value
        }
    }

private fun placeOrder(menuData: String){
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")
    val (type, name, price) = menuData.split(',')
    val totalPurse = playerGold + (playerSilver/100.0)

    if(totalPurse > price.toDouble()) {
        val message = "Madrigal buys a $name ($type) for $price"
        println(message)
        performPurchase(price.toDouble())
        val phrase = if (name == "Dragon's Breath") {
            "Madrigal exclaims ${toDragonSpeak("Ah, delicious $name")}"
        } else {
            "Madrigal says: Thanks for the $name"
        }
        println(phrase)
    } else {
        print("Taernyl says: You've goy not enough money, milord!")
    }
}
