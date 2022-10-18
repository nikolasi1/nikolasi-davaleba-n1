import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val point1 = Point(5.0, 4.9)
    val point2 = Point(6.0, 4.9)
    println(point1.toString())
    println(point1.equals(point2))
    println(point1.symmetric())
    println(point1.distance(point2))

    val fraction1 = Fraction(2,5)
    val fraction2 = Fraction(3,7)

}

class Point(val x:Double, val y:Double){
    override fun toString(): String {
        return "$x , $y"
    }

    fun equals(pt: Point): Boolean {
        return this.toString() == pt.toString()
    }

    fun symmetric ():String{
        val negativeX = -x
        val negativeY = -y
        return "$negativeX , $negativeY"
    }

    fun distance(obj:Point):Double {
        val a = this.x - obj.x
        val b = this.y - obj.y
        return sqrt(a.pow(2.0) + b.pow(2.0))
    }
}

class Fraction(var numerator: Int, var denominator: Int){
    fun cut():String{
        var num:Int = numerator
        var den:Int = denominator
        for (i in 2 .. num){
            while (num%i==0 && den%i==0){
                num /= i
                den /= i
            }
        }
        return "$num / $den"
    }

    fun mult(frc:Fraction):String{
        val a : Int = numerator*frc.numerator
        val b : Int = denominator*frc.denominator
        return  "$a / $b"
    }

    fun add(frc:Fraction):String{
        var a1:Int = numerator
        var b1:Int = denominator
        var a2:Int = frc.numerator
        var b2:Int = frc.denominator
        val tmp:Int = denominator
        if (denominator!=frc.denominator){
            a1 *= b2
            b1*=b2
            a2*=tmp
            b2*=tmp
        }
        var sm :Int = a1+a2
        var ct = Fraction(sm, b2)
        return ct.cut()
    }
}