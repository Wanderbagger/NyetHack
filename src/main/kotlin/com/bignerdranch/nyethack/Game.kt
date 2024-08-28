package com.bignerdranch.nyethack

class Game {
}

fun main(args: Array<String>) {
    val player = Player("Madrigal")
    player.castFireball()
    val auraColor = player.auraColor()
    printPlayerStatus(player, auraColor)

}


private fun printPlayerStatus(player: Player, auraColor: String){
    println("(Aura: ${player.auraColor()}) " +
            "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()}")
}




