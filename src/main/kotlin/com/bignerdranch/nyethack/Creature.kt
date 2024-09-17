package com.bignerdranch.nyethack

interface Fightable {
    var healthPoints: Int
    var diceCount: Int
    var diceSides: Int
    var damageRoll: Int

    fun attack(opponent: Fightable): Int
}