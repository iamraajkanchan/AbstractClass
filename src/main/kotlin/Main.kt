fun main(args: Array<String>) {
    val roundHut: Dwellings = RoundHut(3)
    val squareCabin: Dwellings = SquareCabin(4)
    val roundTower: Dwellings = RoundTower(12)

    operation(roundHut)
    operation(squareCabin)
    operation(roundTower)
}
fun operation(instance: Dwellings) {
    println("...................................................")
    with(instance) {
        println(name)
        println("Building Material : $buildingMaterial")
        println("Capacity          : $capacity")
        println("Has Room          : ${hasRoom()}")
        getRoom()
    }
    println("...................................................")
}

abstract class Dwellings(private val resident: Int) {
    abstract val buildingMaterial: String
    abstract val capacity: Int
    abstract val name: String

    fun hasRoom(): Boolean {
        return capacity > resident
    }

    fun getRoom() {
        if (hasRoom()) {
            println("Congratulations!!! We have a room for you.")
        } else {
            println("Sorry!!! We don't have a room for you.")
        }
    }
}

open class RoundHut(private val resident: Int) : Dwellings(resident) {
    override val buildingMaterial: String = "Straw"
    override val capacity: Int = 6
    override val name: String = "Round Hut"
}

class SquareCabin(private val resident: Int) : Dwellings(resident) {
    override val buildingMaterial: String = "Wood"
    override val capacity: Int = 4
    override val name: String = "Square Cabin"
}

class RoundTower(private val resident: Int, private val floors: Int = 6) : RoundHut(resident) {
    override val buildingMaterial: String = "Concrete"
    override val capacity: Int = floors * 4
    override val name: String = "Round Tower"
}