class Tavern {
}

fun main(args: Array<String>) {

    var beverage = readLine()
 beverage = null
    if (beverage != null) {
        beverage = beverage.capitalize()
    } else {
        println("I can't do that without crashing - beverage was null!")
    }
    println(beverage)
}