import kotlin.random.Random

class Game {
}

fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 89
    var isBlessed = true
    val isImmortal = true
    var glass = 0

    // Aura
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)
    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

     // Status
    printPlayerStatus(auraColor, isBlessed, name, healthStatus)

    castFireball(Random.nextInt(0,100))
}

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
    when (healthPoints) {
        100 -> " is in excellent condition"
        in 90..99 -> " has few scratches"
        in 75..89 -> if (isBlessed) {
            " has some minor wounds, bit is healing quickly!"
        } else {
            " has some minor wounds."
        }
        in 15..74 -> " looks pretty hurt"
        else -> " is in awful condition"
    }



private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String
) {
    println("(Aura: $auraColor) " + "(Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")
}

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean): String {
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"
    return auraColor
}

private fun castFireball(numFireballs: Int): Int {

    println("A glass of Fireball springs into existence. (x$numFireballs)")
    println("Your status is. (x$)")
    if(numFireballs > 50){
        return 50
    } else {
        return numFireballs
    }
}


