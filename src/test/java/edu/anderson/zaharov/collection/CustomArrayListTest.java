package edu.anderson.zaharov.collection;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        log.info("addOneTestNewElement {}, size before={}, size after={}", cl, size, cl.size());
    }

    @Test
    void testAddOneNewNullElement() {

        int size = cl.size();
        cl.add(null);
        assertEquals(3, cl.size());
        log.info("addOneNewNullElement {}, size before={}, size after={}", cl, size, cl.size());
    }

    @Test
    void testAddOneNewElementCheckResult() {

        int size = cl.size();
        boolean r = cl.add("three");
        log.info("addOneNewElementCheckResult {}, size before={}, size after={}", r, size, cl.size());
        assertTrue(r);
    }

    @Test
    void testInsertOneElementInTheCollectionBegin() {

        cl.add(0, "insert");
        log.info("insertOneElementInTheCollectionBegin {}", cl.toString());
        assertEquals(3, cl.size());
    }

    @Test
    void testInsertOneElementInTheCollectionCenter() {

        cl.add(1, "insert");
        log.info("insertOneElementInTheCollectionCenter {}", cl.toString());
        assertEquals(3, cl.size());
    }

    @Test
    void testInsertAllElementsFromCollection() {

        CustomArrayList<String> nl = new CustomArrayList<>();
        cl.add("one");
        cl.add("two");
        cl.addAll(nl);
        log.info("insertAllElements {}", cl.toString());
        assertEquals(4, cl.size());
    }

    @Test
    void testInsertAllElementsAtTheSpecifiedIndex() {

        CustomArrayList<String> nl = new CustomArrayList<>();
        cl.add("one");
        cl.add("two");
        cl.addAll(1, nl);
        log.info("insertAllElementsAtTheSpecifiedIndex {}", cl.toString());
        assertEquals(4, cl.size());
    }

}