package stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


public class OOStackTest{

  private static String Second = "Second";
  private static String First = "First";
  private static String Something = "Something";

@Test public void test01StackShouldBeEmptyWhenCreated() {
    assertTrue( newStack().isEmpty());
  }

  @Test public void test02PushAddElementsToTheStack() {
    assertFalse( newStack().push( Something ).isEmpty() );
  }

  @Test public void test03PopRemovesElementsFromTheStack() {
	assertTrue( newStackWithSomethignPopped().isEmpty() );
	  }
  
  @Test public void test04PopReturnsLastPushedObject() {
    assertEquals( newStackWithSomething().pop(), Something );
  }

  @Test public void test05StackBehavesLIFO() {
    OOStack stack = newStack();
    stack.push( First );
    stack.push( Second );
    assertPoppedElementIsCorrect(stack, Second);
    assertPoppedElementIsCorrect(stack, First);
    
    assertTrue( stack.isEmpty() );
  }

  @Test public void test06TopReturnsLastPushedObject() {
    assertEquals( newStack().push( Something ).top(), Something );
  }

  @Test public void test07TopDoesNotRemoveObjectFromStack() {
    OOStack stack = newStackWithSomething();
    assertStackSizeIsCorrect(stack);
    stack.top();
    assertStackSizeIsCorrect(stack);
  }

  @Test public void test08CanNotPopWhenThereAreNoObjectsInTheStack() {
	  assertThrowsLike(OOStack.stackEmptyErrorDescription,()->newStack().pop());
  }

  @Test public void test09CanNotPopWhenThereAreNoObjectsInTheStackAndTheStackHadObjects() {
	  assertThrowsLike(OOStack.stackEmptyErrorDescription,()->newStackWithSomethignPopped().pop());
  }

  @Test public void test10CanNotTopWhenThereAreNoObjectsInTheStack() {
	  assertThrowsLike(OOStack.stackEmptyErrorDescription,()->newStack().top());
  }
  
  
  private OOStack newStack() {
		return new OOStack();
	}
  
  private OOStack newStackWithSomething() {
		OOStack stack = newStack();
		stack.push( Something );
		return stack;
	}
  
  private OOStack newStackWithSomethignPopped() {
		OOStack stack = newStackWithSomething();
	    stack.pop();
		return stack;
	}
  
  private void assertPoppedElementIsCorrect(OOStack stack, String string) {
		assertEquals( stack.pop(), string );
	}
  
  private void assertStackSizeIsCorrect(OOStack stack) {
		assertEquals( stack.size(), 1 );
	}
  
  private void assertThrowsLike(String msg, Executable codeToRun) {
		assertEquals(msg, assertThrows(Error.class, codeToRun).getMessage());
	}
}