package ru.spbu.apcyb.svp.tasks;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QueueTest {


  @Test
  void addObjectTest() {
    Queue Queue = new Queue();
    Queue.add("string");
    Assertions.assertEquals("string", Queue.peek());
  }

  @Test
  void sizeEmptyTest() {
    Queue Queue = new Queue();
    Assertions.assertEquals(0, Queue.size());
  }

  @Test
  void sizeSeveralTest() {
    Queue Queue = new Queue();
    Queue.add(5);
    Queue.remove();
    Assertions.assertEquals(0, Queue.size());
  }

  @Test
  void pollTest() {
    Queue Queue = new Queue();
    Queue.add("string");
    Queue.add(5);
    Object element = Queue.poll();
    assertAll(
        () -> Assertions.assertEquals("string", element),
        () -> Assertions.assertArrayEquals(new Object[]{5}, Queue.toArray())
    );
  }

  @Test
  void pollNullTest() {
    Queue Queue = new Queue();
    Assertions.assertNull(Queue.poll());
  }

  @Test
  void elementTest() {
    Queue Queue = new Queue();
    Queue.add("string");
    Queue.add(5);
    Object element = Queue.element();
    assertAll(
        () -> Assertions.assertEquals("string", element),
        () -> Assertions.assertArrayEquals(new Object[]{"string", 5}, Queue.toArray())
    );
  }

  @Test
  void elementExceptionTest() {
    Queue Queue = new Queue();
    Assertions.assertThrows(NoSuchElementException.class, Queue::element);
  }

  @Test
  void removeTest() {
    Queue Queue = new Queue();
    Queue.add("string");
    Queue.add(5);
    Object element = Queue.remove();
    assertAll(
        () -> Assertions.assertEquals("string", element),
        () -> Assertions.assertArrayEquals(new Object[]{5}, Queue.toArray())
    );
  }

  @Test
  void removeExceptionTest() {
    Queue Queue = new Queue();
    Assertions.assertThrows(NoSuchElementException.class, Queue::remove);
  }

  @Test
  void removeSeveralTest() {
    Queue Queue = new Queue();
    Queue.add("a");
    Queue.add("b");
    Queue.remove("b");
    assertArrayEquals(new Object[]{"a"}, Queue.toArray());
  }

  @Test
  void peekTest() {
    Queue Queue = new Queue();
    Queue.add("string");
    Queue.add(5);
    Object element = Queue.peek();
    assertAll(
        () -> Assertions.assertEquals("string", element),
        () -> Assertions.assertArrayEquals(new Object[]{"string", 5}, Queue.toArray())
    );
  }

  @Test
  void peekNullTest() {
    Queue Queue = new Queue();
    Assertions.assertNull(Queue.peek());
  }

  @Test
  void isEmptyTest() {
    Queue Queue = new Queue();
    assertTrue(Queue.isEmpty());
  }

  @Test
  void isEmptyFalseTest() {
    Queue Queue = new Queue();
    Queue.add(5);
    assertFalse(Queue.isEmpty());
  }

  @Test
  void clearTest() {
    Queue Queue = new Queue();
    Assertions.assertThrows(UnsupportedOperationException.class, Queue::clear);
  }

  @Test
  void offerTest() {
    Queue Queue = new Queue();
    Assertions.assertThrows(UnsupportedOperationException.class, () -> Queue.offer(5));
  }

  @Test
  void iteratorTest() {
    Queue Queue = new Queue();
    Assertions.assertThrows(UnsupportedOperationException.class, Queue::iterator);
  }

  @Test
  void containsTest() {
    Queue Queue = new Queue();
    Assertions.assertThrows(UnsupportedOperationException.class, () -> Queue.contains(0));
  }
}