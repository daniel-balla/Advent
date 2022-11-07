package Day_7;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import Day_7.AssignmentOperations.AssignmentOperation;
import Day_7.AssignmentOperations.DoubleSorceOp.AND;
import Day_7.AssignmentOperations.DoubleSorceOp.LSHIFT;
import Day_7.AssignmentOperations.DoubleSorceOp.OR;
import Day_7.AssignmentOperations.DoubleSorceOp.RSHIFT;
import Day_7.AssignmentOperations.SingleSourceOp.Assign;
import Day_7.AssignmentOperations.SingleSourceOp.NOT;
import Day_7.References.LiteralReference;
import Day_7.References.VariableReference;

class Tests {

	String a = "src/resources/day_7_input";
	String line = "123 -> x";
	String file = "src/resources/testFile";
	String[] strArr = { "123", "->", "x" };

	@Test
	void testAssign1() {
		String[] tokens1 = { "12", "->", "x" };
		AssignmentOperation expected = new Assign(new LiteralReference(12), new VariableReference("x"));
		List<AssignmentOperation> operations = new LinkedList<>();
		operations.add(Parser.parse(tokens1));
		AssignmentOperation actual = operations.get(0);
		Assert.assertEquals(expected, actual);
	}

	@Test
	void testAssign2() {
		String[] tokens1 = { "a", "->", "x" };
		AssignmentOperation expected = new Assign(new VariableReference("a"), new VariableReference("x"));
		List<AssignmentOperation> operations = new LinkedList<>();
		operations.add(Parser.parse(tokens1));
		AssignmentOperation actual = operations.get(0);
		Assert.assertEquals(expected, actual);
	}

	@Test
	void testNot() {
		String[] tokens1 = { "NOT", "i", "->", "x" };
		AssignmentOperation expected = new NOT(new VariableReference("i"), new VariableReference("x"));
		List<AssignmentOperation> operations = new LinkedList<>();
		operations.add(Parser.parse(tokens1));
		AssignmentOperation actual = operations.get(0);
		Assert.assertEquals(expected, actual);
	}

	@Test
	void testOr() {
		String[] tokens1 = { "x", "OR", "y", "->", "z" };
		AssignmentOperation expected = new OR(new VariableReference("x"), new VariableReference("y"),
				new VariableReference("z"));
		List<AssignmentOperation> operations = new LinkedList<>();
		operations.add(Parser.parse(tokens1));
		AssignmentOperation actual = operations.get(0);
		Assert.assertEquals(expected, actual);
	}

	@Test
	void testLshift() {
		String[] tokens1 = { "x", "LSHIFT", "3", "->", "o" };
		AssignmentOperation expected = new LSHIFT(new VariableReference("x"), new LiteralReference(3),
				new VariableReference("o"));
		List<AssignmentOperation> operations = new LinkedList<>();
		operations.add(Parser.parse(tokens1));
		AssignmentOperation actual = operations.get(0);
		Assert.assertEquals(expected, actual);
	}

	@Test
	void testRshift() {
		String[] tokens1 = { "x", "RSHIFT", "3", "->", "o" };
		AssignmentOperation expected = new RSHIFT(new VariableReference("x"), new LiteralReference(3),
				new VariableReference("o"));
		List<AssignmentOperation> operations = new LinkedList<>();
		operations.add(Parser.parse(tokens1));
		AssignmentOperation actual = operations.get(0);
		Assert.assertEquals(expected, actual);
	}

	@Test
	void testAnd1() {
		String[] tokens1 = { "a", "AND", "b", "->", "c" };
		AssignmentOperation expected = new AND(new VariableReference("a"), new VariableReference("b"),
				new VariableReference("c"));
		List<AssignmentOperation> operations = new LinkedList<>();
		operations.add(Parser.parse(tokens1));
		AssignmentOperation actual = operations.get(0);
		Assert.assertEquals(expected, actual);
	}

	@Test
	void testAnd2() {
		String[] tokens1 = { "1", "AND", "b", "->", "c" };
		AssignmentOperation expected = new AND(new LiteralReference(1), new VariableReference("b"),
				new VariableReference("c"));
		List<AssignmentOperation> operations = new LinkedList<>();
		operations.add(Parser.parse(tokens1));
		AssignmentOperation actual = operations.get(0);
		Assert.assertEquals(expected, actual);
	}

	@Test
	void testInterpretAssign1() throws IOException {
		VariableReference x = new VariableReference("x");
		AssignmentOperation aO = new Assign(new LiteralReference(12), x);
		List<AssignmentOperation> a = new LinkedList<>();
		a.add(aO);
		Map<String, VariableReference> map = new HashMap<>();
		map.put("x", x);
		Map<String, VariableReference> map2 = Interpreter.interpret(a, map);
		int c = map2.get("x").signal;
		int d = 12;
		Assert.assertEquals(d, c);
	}

	@Test
	void testInterpretAssign2() throws IOException {
		VariableReference x = new VariableReference("x");
		VariableReference ag = new VariableReference("a");
		AssignmentOperation aO1 = new Assign(new LiteralReference(12), x);
		AssignmentOperation aO = new Assign(x, ag);
		List<AssignmentOperation> a = new LinkedList<>();
		a.add(aO);
		a.add(aO1);
		Map<String, VariableReference> map = new HashMap<>();
		map.put("x", x);
		map.put("a", ag);
		Map<String, VariableReference> map2 = Interpreter.interpret(a, map);
		int c = map2.get("a").signal;
		int d = 12;
		Assert.assertEquals(d, c);
	}

	@Test
	void testInterpretOr() throws IOException {
		VariableReference x = new VariableReference("x");
		VariableReference ag = new VariableReference("a");
		VariableReference z = new VariableReference("z");
		AssignmentOperation aO1 = new Assign(new LiteralReference(12), x);
		AssignmentOperation aO2 = new Assign(new LiteralReference(12), ag);
		AssignmentOperation aO = new OR(ag, x, z);
		List<AssignmentOperation> a = new LinkedList<>();
		a.add(aO2);
		a.add(aO1);
		a.add(aO);
		Map<String, VariableReference> map = new HashMap<>();
		map.put("x", x);
		map.put("a", ag);
		map.put("z", z);
		Map<String, VariableReference> map2 = Interpreter.interpret(a, map);
		int c = map2.get("z").signal;
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
		Map<String, VariableReference> map = new HashMap<>();
		map.put("a", a);
		map.put("b", b);
		map.put("c", c);
		Map<String, VariableReference> map2 = Interpreter.interpret(b1, map);
		int d1 = map2.get("c").signal;
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
		Map<String, VariableReference> map = new HashMap<>();
		map.put("a", a);
		map.put("b", b);
		map.put("c", c);
		Map<String, VariableReference> map2 = Interpreter.interpret(b1, map);
		int d1 = map2.get("c").signal;
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
		Map<String, VariableReference> map = new HashMap<>();
		map.put("a", a);
		map.put("c", c);
		Map<String, VariableReference> map2 = Interpreter.interpret(b1, map);
		int d1 = map2.get("c").signal;
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
		Map<String, VariableReference> map = new HashMap<>();
		map.put("a", a);
		map.put("c", c);
		Map<String, VariableReference> map2 = Interpreter.interpret(b1, map);
		int d1 = map2.get("c").signal;
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
		Map<String, VariableReference> map = new HashMap<>();
		map.put("a", a);
		map.put("c", c);
		Map<String, VariableReference> map2 = Interpreter.interpret(b1, map);
		int d1 = map2.get("c").signal;
		int e1 = 12;
		char e2 = (char) ~e1;
		e1 = (int) e2;
		Assert.assertEquals(d1, e1);
	}

	@Test
	void testIsExecutable1() {
		Map<String, VariableReference> map = new HashMap<>();
		VariableReference a = new VariableReference("a");
		VariableReference c = new VariableReference("c");
		map.put("a", a);
		map.put("c", c);
		AssignmentOperation a0 = new Assign(a, c);
		Assert.assertEquals(false, a0.isExecutable(map));
	}

	@Test
	void testIsExecutable2() {
		Map<String, VariableReference> map = new HashMap<>();
		VariableReference a = new VariableReference("a");
		LiteralReference c = new LiteralReference(12);
		map.put("a", a);
		AssignmentOperation a0 = new Assign(c, a);
		Assert.assertEquals(true, a0.isExecutable(map));
	}

	@Test
	void testAndCalculate1() {
		VariableReference a = new VariableReference("a");
		VariableReference b = new VariableReference("b");
		VariableReference c = new VariableReference("c");
		a.signal = 12;
		b.signal = 11;
		Map<String, VariableReference> map = new HashMap<>();
		map.put("a", a);
		map.put("b", b);
		map.put("c", c);
		AssignmentOperation ao = new AND(a, b, c);
		ao.calculate(map);

		int i = 12 & 11;
		int j = c.signal;
		Assert.assertEquals(i, j);
	}

	@Test
	void testAndCalculate2() {
		LiteralReference a = new LiteralReference(1);
		VariableReference b = new VariableReference("b");
		VariableReference c = new VariableReference("c");
		a.signal = 12;
		b.signal = 11;
		Map<String, VariableReference> map = new HashMap<>();
		map.put("b", b);
		map.put("c", c);
		AssignmentOperation ao = new AND(a, b, c);
		ao.calculate(map);

		int i = 12 & 11;
		int j = c.signal;
		Assert.assertEquals(i, j);
	}

	@Test
	void testLshiftCalculate() {
		LiteralReference a = new LiteralReference(12);
		VariableReference b = new VariableReference("b");
		VariableReference c = new VariableReference("c");
		b.signal = 11;
		Map<String, VariableReference> map = new HashMap<>();
		map.put("b", b);
		map.put("c", c);
		AssignmentOperation ao = new LSHIFT(b, a, c);
		ao.calculate(map);

		int i = 11 << 12;
		int j = c.signal;
		Assert.assertEquals(i, j);
	}

	@Test
	void testRshiftCalculate() {
		LiteralReference a = new LiteralReference(12);
		VariableReference b = new VariableReference("b");
		VariableReference c = new VariableReference("c");
		b.signal = 11;
		Map<String, VariableReference> map = new HashMap<>();
		map.put("b", b);
		map.put("c", c);
		AssignmentOperation ao = new RSHIFT(b, a, c);
		ao.calculate(map);

		int i = 11 >> 12;
		int j = c.signal;
		Assert.assertEquals(i, j);
	}

	@Test
	void testOrCalculate() {
		VariableReference a = new VariableReference("a");
		VariableReference b = new VariableReference("b");
		VariableReference c = new VariableReference("c");
		a.signal = 12;
		b.signal = 11;
		Map<String, VariableReference> map = new HashMap<>();
		map.put("a", a);
		map.put("b", b);
		map.put("c", c);
		AssignmentOperation ao = new OR(a, b, c);
		ao.calculate(map);

		int i = 12 | 11;
		int j = c.signal;
		Assert.assertEquals(i, j);
	}

	@Test
	void testNotCalculate() {
		VariableReference a = new VariableReference("a");
		VariableReference c = new VariableReference("c");
		a.signal = 12;
		Map<String, VariableReference> map = new HashMap<>();
		map.put("a", a);
		map.put("c", c);
		AssignmentOperation ao = new NOT(a, c);
		ao.calculate(map);

		int i = 12;
		char h = (char) ~i;
		i = (int) h;
		int j = c.signal;
		Assert.assertEquals(i, j);
	}

	@Test
	void testAssignCalculate1() {
		VariableReference a = new VariableReference("a");
		VariableReference c = new VariableReference("c");
		a.signal = 12;
		Map<String, VariableReference> map = new HashMap<>();
		map.put("a", a);
		map.put("c", c);
		AssignmentOperation ao = new Assign(a, c);
		ao.calculate(map);

		int i = 12;
		int j = c.signal;
		Assert.assertEquals(i, j);
	}

	@Test
	void testAssignCalculate2() {
		LiteralReference a = new LiteralReference(12);
		VariableReference c = new VariableReference("c");
		Map<String, VariableReference> map = new HashMap<>();
		map.put("c", c);
		AssignmentOperation ao = new Assign(a, c);
		ao.calculate(map);

		int i = 12;
		int j = c.signal;
		Assert.assertEquals(i, j);
	}

	@Test
	void testOps() throws IOException {
		VariableReference a = new VariableReference("a");
		VariableReference b = new VariableReference("b");
		VariableReference c = new VariableReference("c");
		VariableReference e = new VariableReference("e");
		LiteralReference d = new LiteralReference(12);
		Map<String, VariableReference> map = new HashMap<>();
		map.put("a", a);
		map.put("b", b);
		map.put("c", c);
		map.put("e", e);

		AssignmentOperation a1 = new Assign(a, b);
		AssignmentOperation a2 = new Assign(d, a);
		AssignmentOperation a3 = new AND(a, b, c);
		AssignmentOperation a4 = new LSHIFT(c, d, e);
		List<AssignmentOperation> operations = new LinkedList<>();
		operations.add(a1);
		operations.add(a2);
		operations.add(a3);
		operations.add(a4);
		Map<String, VariableReference> map2 = Interpreter.interpret(operations, map);
		int i = map2.get("e").signal;
		int j = (12 & 12) << 12;
		Assert.assertEquals(j, i);
	}
}
