package edu.anderson.zaharov.collection;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@ToString
class CustomArrayListTest {

    private List<String> cl;

    @BeforeEach
    void init() {

        cl = null;
        cl = new CustomArrayList<>();
        cl.add("one");
        cl.add("two");
    }

    @Test
    void testSize() {

        log.info("testSize = {}", cl.size());
        assertEquals(2, cl.size());
    }


    @Test
    void testAddOneNewElement() {

        int size = cl.size();
        cl.add("three");
        assertEquals(3, cl.size());
        log.info("testAddOneNewElement {}, size before={}, size after={}", cl, size, cl.size());
    }

    @Test
    void testAddOneNewNullElement() {

        int size = cl.size();
        cl.add(null);
        assertEquals(3, cl.size());
        log.info("testAddOneNewNullElement {}, size before={}, size after={}", cl, size, cl.size());
    }

    @Test
    void testAddOneNewElementCheckResult() {

        int size = cl.size();
        boolean r = cl.add("three");
        log.info("testAddOneNewElementCheckResult {}, size before={}, size after={}", r, size, cl.size());
        assertTrue(r);
    }

    @Test
    void testInsertOneElementInTheCollectionBegin() {

        cl.add(0, "insert");
        log.info("testInsertOneElementInTheCollectionBegin {}", cl.toString());
        assertEquals(3, cl.size());
    }

    @Test
    void testInsertOneElementInTheCollectionCenter() {

        cl.add(1, "insert");
        log.info("testInsertOneElementInTheCollectionCenter {}", cl.toString());
        assertEquals(3, cl.size());
    }

    @Test
    void testInsertAllElementsFromCollection() {

        CustomArrayList<String> nl = new CustomArrayList<>();
        nl.add("one");
        nl.add("two");
        cl.addAll(nl);
        log.info("testInsertAllElementsFromCollection {}", cl.toString());
        assertEquals(4, cl.size());
    }

    @Test
    void testInsertAllElementsAtTheSpecifiedIndex() {

        CustomArrayList<String> nl = new CustomArrayList<>();
        nl.add("one");
        nl.add("two");
        cl.addAll(1, nl);
        log.info("testInsertAllElementsAtTheSpecifiedIndex {}", cl.toString());
        assertEquals(4, cl.size());
    }

    @Test
    void testContainsAll() {

        CustomArrayList<String> nl = new CustomArrayList<>();
        nl.add("one");
        nl.add("two");
        boolean r = cl.containsAll(nl);
        log.info("testContainsAll {}", r);
        assertTrue(r);
    }

    @Test
    void testContainElement() {

        boolean r = cl.contains("one");
        assertTrue(r);
        log.info("testContainElement {}", r);
    }

   @Test
    void testClearAllElements(){

       int size = cl.size();
       cl.clear();
       assertEquals(0, cl.size());
       log.info("testClearAllElements {}, size before={}, size after={}", cl, size, cl.size());
   }

    @Test
    void getElementByIndex(){

        int index = 0;
        String e = cl.get(index);
        assertEquals("one", e);
        log.info("getElementByIndex {}, index = {}, element = {}", cl, index, e);
    }

    @Test
    void getUnExistElementByIndex(){

        int index = 10;
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> cl.get(10));
        log.info("getElementByIndex {}, index = {}, element = non exist", cl, index);
    }
}