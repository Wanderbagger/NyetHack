package com.bignerdranch.nyethack

fun main(args: Array<String>) {
    Game.play()
}

object Game {
    val player = Player("Madrigal")
    var currentRoom = TownSquare()
    init {
        println("Welcome, adventurer.")
        player.castFireball()
    }
    fun play() {
        while (true) {
            println(currentRoom.description())
            println(currentRoom.load())
            printPlayerStatus(player)
        }
    }

    private fun printPlayerStatus(player: Player){
        println("(Aura: ${player.auraColor()}) " +
                "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
        println("${player.name} ${player.formatHealthStatus()}")
    }
}




