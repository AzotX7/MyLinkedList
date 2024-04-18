import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.relex.Test_1.TwoWayList;

import static org.junit.jupiter.api.Assertions.*;

public class TwoWayListTest {
    TwoWayList twoWayList;

    @BeforeEach
    void prepareData(){
        twoWayList = new TwoWayList();
    }

    @Test
    public void testAddByIndMethod(){

        int infoToAdd1 = 10;
        int infoToAdd2 = 20;
        int infoToAdd3 = 30;
        twoWayList.add(infoToAdd1);
        twoWayList.add(infoToAdd2);
        twoWayList.add(infoToAdd3);

        twoWayList.addByInd(25,1);

        int index25 = twoWayList.contains(25);
        assertTrue(index25 != -1, "Элемент 25 должен быть в списке");
        assertEquals(1, index25, "Элемент 25 должен быть по индексу 1");
    }
    @Test
    public void testRemoveLastMethod(){

        twoWayList.add(10);
        twoWayList.add(20);
        twoWayList.add(30);

        twoWayList.removeLast();

        assertNull(twoWayList.tail.next,"Последний элемент должен быть удален");
    }
    @Test
    public void testRemoveFirstMethod(){

        twoWayList.add(10);
        twoWayList.add(20);
        twoWayList.add(30);

        twoWayList.remove();

        assertNull(twoWayList.head.prev,"Первый элемент должен быть удален");

    }
}
