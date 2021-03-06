package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void allowsVisitorsOver145cmAge12() {
        Visitor visitor = new Visitor(12, 145.0, 5.0);
        assertEquals(true, rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void doesNotAllowVisitorsUnder12() {
        Visitor visitor = new Visitor(11, 145.0, 5.0);
        assertEquals(false, rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void doesNotAllowVisitorsUnder145cm() {
        Visitor visitor = new Visitor(12, 144.0, 5.0);
        assertEquals(false, rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void canGetDefaultPrice() {
        assertEquals(8.40, rollerCoaster.defaultPrice(), 2);
    }

    @Test
    public void canGetPriceForVisitor() {
        Visitor visitor = new Visitor(12, 144.0, 5.0);
        assertEquals(8.40, rollerCoaster.priceFor(visitor), 2);
    }

    @Test
    public void twicePriceIfVisitorOver200cm() {
        Visitor visitor = new Visitor(18, 201.0, 55.0);
        assertEquals(16.80, rollerCoaster.priceFor(visitor), 2);
    }
}
