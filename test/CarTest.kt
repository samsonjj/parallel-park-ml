import physics.Car
import org.junit.Test
import kotlin.test.assertEquals

class CarTest {
    @Test
    fun carConstructor() {
        val car = Car(0.0, 0.0)
        assertEquals(car.w, Car.DEFAULT_WIDTH)
        assertEquals(car.l, Car.DEFAULT_LENGTH)
        assertEquals(car.a, 0.0)
    }
}