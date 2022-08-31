import kotlin.reflect.KProperty

const val value=10

class A{
    var a by ClassForPropertyDelegation()
    override fun toString(): String {
        return "Object of Class A"
    }


}
class ClassForPropertyDelegation {
    operator fun getValue(thisRef: A, property: KProperty<*>): Int {
        return value
    }
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        println("Assigned value is : $value")
    }
}

fun main(){
    val p=A()
    p.a=5
    println(p.a)
}