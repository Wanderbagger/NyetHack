package com.bignerdranch.nyethack

class Game {
}

fun main(args: Array<String>) {
    val player = Player("Madrigal")
    player.castFireball()
    var currentRoom = TownSquare()
    println(currentRoom.description())
    println(currentRoom.load())

    printPlayerStatus(player)

}


private fun printPlayerStatus(player: Player){
    println("(Aura: ${player.auraColor()}) " +
            "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()}")
}




