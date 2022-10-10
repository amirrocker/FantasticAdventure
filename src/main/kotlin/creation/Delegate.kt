package creation

import kotlin.reflect.KProperty

interface AquireDataBehavior {
    fun aquireData()
}

class OfflineBehavior() : AquireDataBehavior {
    override fun aquireData() =
        println("aquireData offline")
}

class OnlineBehavior() : AquireDataBehavior {
    override fun aquireData() =
        println("aquireData online")
}

class OfflineContractService : AquireDataBehavior by OfflineBehavior()
class OnlineContractService : AquireDataBehavior by OnlineBehavior()

private const val isOnline = true



fun repo() {
    val service: AquireDataBehavior
    if (isOnline) {
        service = OnlineContractService()
    } else {
        service = OfflineContractService()
    }
    service.aquireData()
}

// property delegation
class PropertyDelegation {

    var property: String by Delegate()

    override fun toString(): String = "PropertyDelegation.property"


}

class Delegate {
    operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {
        return "$thisRef, is delegating ${prop.name}"
    }
    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: String ) {
        println("Delegation has assigned $value to ${prop.name} in $thisRef")
    }
}

fun main() {
    repo()

    val propertyDelegation = PropertyDelegation()
    println(propertyDelegation.property)
    propertyDelegation.property = "New Value to Delegate"

}