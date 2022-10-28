package Day_7;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class tests {

	String a = "src/resources/day_7_input";
	String line = "123 -> x";
	String file = "src/resources/testFile";
	String[] strArr = { "123", "->", "x" };
	Tokenizer tokenizer = new Tokenizer();
	static Parser parser = new Parser();
	static Lexer lexer = new Lexer();

	@Test
	void testAssign1() {
		String[] tokens1 = { "12", "->", "x" };

		AssignmentOperation expected = new Assign(new LiteralReference(12), new VariableReference("x"));
		AssignmentOperation actual = parser.parse(tokens1);
		Assert.assertEquals(expected, actual);
	}

	@Test
	void testAssign2() {
		String[] tokens1 = { "a", "->", "x" };

		AssignmentOperation expected = new Assign(new VariableReference("a"), new VariableReference("x"));
		AssignmentOperation actual = parser.parse(tokens1);
		Assert.assertEquals(expected, actual);
	}

	@Test
	void testNot() {
		String[] tokens = { "NOT", "i", "->", "x" };

		AssignmentOperation expected = new NOT(new VariableReference("i"), new VariableReference("x"));
		AssignmentOperation actual = parser.parse(tokens);
		Assert.assertEquals(expected, actual);
	}

	@Test
	void testOr() {
		String[] tokens = { "x", "OR", "y", "->", "z" };

		AssignmentOperation expected = new OR(new VariableReference("x"), new VariableReference("y"),
				new VariableReference("z"));
		AssignmentOperation actual = parser.parse(tokens);
		Assert.assertEquals(expected, actual);
	}

	@Test
	void testLshift() {
		String[] tokens = { "x", "LSHIFT", "3", "->", "o" };

		AssignmentOperation expected = new LSHIFT(new VariableReference("x"), new LiteralReference(3),
				new VariableReference("o"));
		AssignmentOperation actual = parser.parse(tokens);
		Assert.assertEquals(expected, actual);
	}

	@Test
	void testRshift() {
		String[] tokens = { "x", "RSHIFT", "3", "->", "o" };

		AssignmentOperation expected = new RSHIFT(new VariableReference("x"), new LiteralReference(3),
				new VariableReference("o"));
		AssignmentOperation actual = parser.parse(tokens);
		Assert.assertEquals(expected, actual);
	}

	@Test
	void testAnd1() {
		String[] tokens = { "a", "AND", "b", "->", "c" };

		AssignmentOperation expected = new AND(new VariableReference("a"), new VariableReference("b"),
				new VariableReference("c"));
		AssignmentOperation actual = parser.parse(tokens);
		Assert.assertEquals(expected, actual);
	}

	@Test
	void testAnd2() {
		String[] tokens = { "1", "AND", "b", "->", "c" };

		AssignmentOperation expected = new AND(new LiteralReference(1), new VariableReference("b"),
				new VariableReference("c"));
		AssignmentOperation actual = parser.parse(tokens);
		Assert.assertEquals(expected, actual);
	}

	@Test
	void testInterpretAssign1() throws IOException {
		AssignmentOperation aO = new Assign(new LiteralReference(12), new VariableReference("x"));
		List<AssignmentOperation> a = new LinkedList<>();
		a.add(aO);

		Reference b = Interpretierer.interpret(a, new VariableReference("x"));
		int c = b.signal;
		int d = 12;
		Assert.assertEquals(d, c);
	}

	@Test
	void testInterpretAssign2() throws IOException {
		AssignmentOperation aO1 = new Assign(new LiteralReference(12), new VariableReference("x"));
		AssignmentOperation aO = new Assign(new VariableReference("x"), new VariableReference("a"));
		List<AssignmentOperation> a = new LinkedList<>();
		a.add(aO);
		a.add(aO1);

		Reference b = Interpretierer.interpret(a, new VariableReference("a"));
		int c = b.signal;
		int d = 12;
		Assert.assertEquals(d, c);
	}

	@Test
	void testInterpretOr() throws IOException {
		AssignmentOperation aO1 = new Assign(new LiteralReference(12), new VariableReference("x"));
		AssignmentOperation aO2 = new Assign(new LiteralReference(12), new VariableReference("a"));
		AssignmentOperation aO = new OR(new VariableReference("a"), new VariableReference("x"),
				new VariableReference("z"));
		List<AssignmentOperation> a = new LinkedList<>();
		a.add(aO2);
		a.add(aO1);
		a.add(aO);
		Reference b = Interpretierer.interpret(a, new VariableReference("z"));
		int c = b.signal;
		int d = 12 | 12;
		Assert.assertEquals(c, d);
	}

	@Test
	void testInterpretAnd1() throws IOException {
		VariableReference a = new VariableReference("a");
		VariableReference b = new VariableReference("b");
		VariableReference c = new VariableReference("c");
		LiteralReference d = new LiteralReference(1);
		LiteralReference e = new LiteralReference(12);
		AssignmentOperation a1 = new AND(a, b, c);
		AssignmentOperation a2 = new Assign(e, a);
		AssignmentOperation a3 = new Assign(d, b);
		List<AssignmentOperation> b1 = new LinkedList<>();
		b1.add(a1);
		b1.add(a2);
		b1.add(a3);
		Reference c1 = Interpretierer.interpret(b1, c);
		int d1 = c1.signal;
		int e1 = 12 & 1;
		Assert.assertEquals(d1, e1);
	}
	
	@Test
	void testInterpretAnd2() throws IOException {
		VariableReference a = new VariableReference("a");
		VariableReference b = new VariableReference("b");
		VariableReference c = new VariableReference("c");
		LiteralReference d = new LiteralReference(1);
		LiteralReference e = new LiteralReference(12);
		AssignmentOperation a1 = new AND(e, b, c);
		AssignmentOperation a2 = new Assign(e, a);
		AssignmentOperation a3 = new Assign(d, b);
		List<AssignmentOperation> b1 = new LinkedList<>();
		b1.add(a1);
		b1.add(a2);
		b1.add(a3);
		Reference c1 = Interpretierer.interpret(b1, c);
		int d1 = c1.signal;
		int e1 = 12 & 1;
		Assert.assertEquals(d1, e1);
	}
	
	@Test
	void testInterpretLshift() throws IOException {
		VariableReference a = new VariableReference("a");
		VariableReference c = new VariableReference("c");
		LiteralReference d = new LiteralReference(1);
		LiteralReference e = new LiteralReference(12);
		AssignmentOperation a1 = new LSHIFT(a, d, c);
		AssignmentOperation a2 = new Assign(e, a);
		List<AssignmentOperation> b1 = new LinkedList<>();
		b1.add(a1);
		b1.add(a2);
		Reference c1 = Interpretierer.interpret(b1, c);
		int d1 = c1.signal;
		int e1 = 12 << 1;
		Assert.assertEquals(d1, e1);
	}
	
	@Test
	void testInterpretRshift() throws IOException {
		VariableReference a = new VariableReference("a");
		VariableReference c = new VariableReference("c");
		LiteralReference d = new LiteralReference(1);
		LiteralReference e = new LiteralReference(12);
		AssignmentOperation a1 = new RSHIFT(a, d, c);
		AssignmentOperation a2 = new Assign(e, a);
		List<AssignmentOperation> b1 = new LinkedList<>();
		b1.add(a1);
		b1.add(a2);
		Reference c1 = Interpretierer.interpret(b1, c);
		int d1 = c1.signal;
		int e1 = 12 >> 1;
		Assert.assertEquals(d1, e1);
	}
	
	@Test
	void testInterpretNot() throws IOException {
		VariableReference a = new VariableReference("a");
		VariableReference c = new VariableReference("c");
		LiteralReference e = new LiteralReference(12);
		AssignmentOperation a1 = new NOT(a, c);
		AssignmentOperation a2 = new Assign(e, a);
		List<AssignmentOperation> b1 = new LinkedList<>();
		b1.add(a1);
		b1.add(a2);
		Reference c1 = Interpretierer.interpret(b1, c);
		int d1 = c1.signal;
		int e1 = 12;
		char e2 = (char) ~e1;
		e1 = (int) e2;
		Assert.assertEquals(d1, e1);
	}
	
	@Test
	void testIsExecutable1() {
		VariableReference a = new VariableReference("a");
		VariableReference c = new VariableReference("c");
		AssignmentOperation a0 = new Assign(a, c);
		Assert.assertEquals(false, a0.isExecutable());
	}
	
	@Test
	void testIsExecutable2() {
		VariableReference a = new VariableReference("a");
		LiteralReference c = new LiteralReference(12);
		AssignmentOperation a0 = new Assign(c, a);
		Assert.assertEquals(true, a0.isExecutable());
	}
}
















