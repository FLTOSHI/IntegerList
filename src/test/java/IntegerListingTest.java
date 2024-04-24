import edu.fltoshi.IntegerList.IntegerListing;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class IntegerListingTest {

    @Test
    @DisplayName("Создание массива.")
    public void arrayCreation() {
        final IntegerListing[] trup = new IntegerListing[1];

        // Исключение на создание массива строк с ёмкостью 0 (ну и дела)
        assertThrows(IllegalArgumentException.class, () -> trup[0] = new IntegerListing(0));
    }

    @Test
    @DisplayName("Добавление в массив элемента без индекса.")
    public void addElementWithoutIndexInArray() {
        IntegerListing list = new IntegerListing(1);
        assertEquals(1, list.add(1));

        assertThrows(IllegalArgumentException.class, () -> list.add(null));
    }

    @Test
    @DisplayName("Добавление в массив элемента с индексом.")
    public void addElementWithIndexInArray() {
        IntegerListing list = new IntegerListing(1);
        assertEquals(1, list.add(0, 1));

        assertThrows(IllegalArgumentException.class, () -> list.add(0, null));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.add(-999, 999));
    }

    @Test
    @DisplayName("Получение элемента в массиве по его индексу.")
    public void getElementInArrayByIndex() {
        IntegerListing list = new IntegerListing(3);
        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);

        assertEquals(3, list.get(2));
        // Исключение на получение элемента с индексом -999
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(-999));
    }

    @Test
    @DisplayName("Добавление элемента в массив на место уже существующего.")
    public void setElementReplacingInitialElement() {
        IntegerListing list = new IntegerListing(3);
        list.add(1);
        list.add(2);

        assertEquals(2, list.set(1, 2));

        assertThrows(IllegalArgumentException.class, () -> list.set(3, null));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.set(4, 5));
    }

    @Test
    @DisplayName("Удаление из массива элемента без индекса.")
    public void removeElementWithoutIndexFromArray() {
        IntegerListing list = new IntegerListing(1);
        list.add(0);

        assertEquals(list.get(0), list.remove(0));
        assertThrows(IllegalArgumentException.class, () -> list.remove(null));
    }

    @Test
    @DisplayName("Удаление из массива элемента с индексом.")
    public void removeElementWithIndexFromArray() {
        IntegerListing list = new IntegerListing(1);
        list.add(0);

        assertEquals(0, list.remove(0));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.remove(-1));
    }

    @Test
    @DisplayName("Поиск элемента в массиве с его начала.")
    public void indexOf() {
        IntegerListing list = new IntegerListing(5);
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(list.indexOf(2), 1);
        assertEquals(-1, list.indexOf(5));
    }


    @Test
    @DisplayName("Поиск элемента в массиве с его конца.")
    public void lastIndexOf() {
        IntegerListing list = new IntegerListing(3);
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(2, list.lastIndexOf(3));
        assertEquals(-1, list.lastIndexOf(0));
    }

    @Test
    @DisplayName("Проверка на равенство двух массивов по размеру.")
    public void isEquals() {
        IntegerListing list = new IntegerListing(3);
        IntegerListing list2 = new IntegerListing(3);

        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);

        list2.add(0, 4);
        list2.add(1, 5);
        list2.add(1, 5);

        assertTrue(list.equals(list)); // Проверка на равенство двух списков
        assertThrows(IllegalArgumentException.class, () -> list.equals(null)); // Исключение на пустой сравниваемый список
    }

    @Test
    @DisplayName("Проверка на неравенство двух массивов по размеру.")
    public void notEquals() {
        IntegerListing list = new IntegerListing(3);
        IntegerListing list2 = new IntegerListing(3);
        list.add(1);

        list2.add(5);
        list2.add(2);

        assertFalse(list.equals(list2)); // Проверка на неравенство двух списков
    }

    @Test
    @DisplayName("Проверка на существование элемента в массиве.")
    public void contains() {
        IntegerListing list = new IntegerListing(5);
        list.add(0, 0);

//        assertEquals(list.get(0), list.contains(0[], 0));
    }

    @Test
    @DisplayName("Проверка на несуществование элемента в массиве")
    public void notContains() {
        IntegerListing list = new IntegerListing(5);
        list.add(1);
        list.add(2);
        list.add(3);

        assertFalse(list.contains(5));
    }

    @Test
    @DisplayName("Быстрая сортировка")
    public void quickSortTest(){
    }

    @Test
    @DisplayName("Получить фактический размер массива")
    public void size() {
        IntegerListing list = new IntegerListing(1);
        list.add(1);

        assertEquals(1, list.size());
    }

    @Test
    @DisplayName("Проверка очищения массива.")
    public void clear() {
        IntegerListing list = new IntegerListing(5);
        list.add(1);
        list.add(2);
        list.add(3);

        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    @DisplayName("Проверка создания нового массива.")
    public void toArray() {
        IntegerListing list = new IntegerListing(3);
        list.add(0);
        list.add(1);
        list.add(2);

        list.toArray();
        assertEquals(list.size(), 3);
    }

    @Test
    @DisplayName("Проверка на увеличение места при заполнении")
    public void grow() {
        IntegerListing list = new IntegerListing(1);
        list.add(0);
    }
}