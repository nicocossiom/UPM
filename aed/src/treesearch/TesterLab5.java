
/*
 * Teachers: WARNING - this file is generated automatically, please do not
 * make changes directly in this file, instead communicate needed changes
 * to the person responsable for the Tester.
 *
 * Students: you are welcome to make changes to this file if it helps
 * you to better debug your programs. Just REMEMBER that any changes made
 * by you will not change the Tester program used for the 'entrega system'.
 *
 */

//////////////////////////////////////////////////////////////////////
//
// File generated at: 2020/11/13 -- 0:0:14
// Seed: {1605,222013,343000}
//
//////////////////////////////////////////////////////////////////////

package treesearch;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.CountDownLatch;
import java.lang.reflect.*;
import es.upm.aedlib.Entry;
import es.upm.aedlib.Pair;
import es.upm.aedlib.Position;
import es.upm.aedlib.graph.*;
import es.upm.aedlib.indexedlist.*;
import es.upm.aedlib.map.*;
import es.upm.aedlib.positionlist.*;
import es.upm.aedlib.set.*;
import es.upm.aedlib.tree.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.*;
import java.lang.management.ManagementFactory;
import java.lang.reflect.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.function.*;
import java.util.function.Function;

/**
 * The main tester class which contains JUnit5 tests.
 */
@SuppressWarnings({ "unused", "deprecation" })
public class TesterLab5 {

	@BeforeAll
	public static void init() {
		TestUtils.reportPid();
		ResultsHandler.init();
		ResultsHandler.setNumTestsRemaining(82, 60);
		TestData.setTesterType(true);
		TestUtils.ensureAedlibVersion(2, 8, 1);
	}

	@AfterAll
	public static void reportResults() {
		ResultsHandler.report_results();
	}

	@Test
	public void test_01() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_01");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_01"));
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_01"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_02() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_02");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_02"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Alejandro"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("Alejandro") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray(
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] {}))));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_02"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_03() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_03");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_03"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Alejandro"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Laura"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("Alejandro"), new String("Laura") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray(
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] { new Integer(1) }))));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_03"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_04() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_04");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_04"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Alicia"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("Alicia") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray(
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] {}))));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_04"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_05() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_05");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_05"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Ander"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("Ander") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray(
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] {}))));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_05"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_06() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_06");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_06"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Ander"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Mireia"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(pos_0, new String("Antonio"));
					es.upm.aedlib.Position<String> pos_2 = tree.addChildLast(pos_0, new String("Jordi"));
					es.upm.aedlib.Position<String> pos_3 = tree.addChildLast(pos_0, new String("Pablo"));
					es.upm.aedlib.Position<String> pos_4 = tree.addChildLast(pos_0, new String("Isabel"));
					es.upm.aedlib.Position<String> pos_5 = tree.addChildLast(root, new String("Teresa"));
					es.upm.aedlib.Position<String> pos_6 = tree.addChildLast(pos_5, new String("Pablo"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("Mireia") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray()));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_06"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_07() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_07");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_07"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Andreu"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Mireia"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("*") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray(
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] {}))));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_07"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_08() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_08");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_08"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Ane"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("*"), new String("*") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray()));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_08"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_09() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_09");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_09"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Antonio"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Antonio"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(pos_0, new String("Francisco"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(new String[] {
							new String("Antonio"), new String("Antonio"), new String("*") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray(
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] { new Integer(1), new Integer(1) }))));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_09"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_10() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_10");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_10"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Antonio"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Francesca"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(pos_0, new String("Ander"));
					es.upm.aedlib.Position<String> pos_2 = tree.addChildLast(pos_1, new String("Susana"));
					es.upm.aedlib.Position<String> pos_3 = tree.addChildLast(pos_0, new String("Francesca"));
					es.upm.aedlib.Position<String> pos_4 = tree.addChildLast(pos_3, new String("Antonio"));
					es.upm.aedlib.Position<String> pos_5 = tree.addChildLast(pos_3, new String("Noa"));
					es.upm.aedlib.Position<String> pos_6 = tree.addChildLast(pos_3, new String("Paloma"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("*") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray(
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] {}))));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_10"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_11() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_11");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_11"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Antonio"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Francesca"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(pos_0, new String("Laura"));
					es.upm.aedlib.Position<String> pos_2 = tree.addChildLast(pos_0, new String("Teresa"));
					es.upm.aedlib.Position<String> pos_3 = tree.addChildLast(pos_0, new String("Jordi"));
					es.upm.aedlib.Position<String> pos_4 = tree.addChildLast(pos_0, new String("Manuel"));
					es.upm.aedlib.Position<String> pos_5 = tree.addChildLast(root, new String("Teresa"));
					es.upm.aedlib.Position<String> pos_6 = tree.addChildLast(pos_5, new String("Iker"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("Laura"), new String("*"), new String("*"), new String("*") }))
									.doCall().checkResult(
											new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
													TestUtils.toGenericArray()));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_11"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_12() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_12");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_12"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Carmen"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Noa"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("Carmen") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray(
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] {}))));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_12"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_13() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_13");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_13"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Francesca"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Ane"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(root, new String("Mireia"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("*") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray(
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] {}))));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_13"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_14() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_14");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_14"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Francesca"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Paula"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(pos_0, new String("Unai"));
					es.upm.aedlib.Position<String> pos_2 = tree.addChildLast(pos_0, new String("Jordi"));
					es.upm.aedlib.Position<String> pos_3 = tree.addChildLast(pos_0, new String("Lucia"));
					es.upm.aedlib.Position<String> pos_4 = tree.addChildLast(pos_0, new String("Joana"));
					es.upm.aedlib.Position<String> pos_5 = tree.addChildLast(root, new String("Teresa"));
					es.upm.aedlib.Position<String> pos_6 = tree.addChildLast(root, new String("Ane"));
					es.upm.aedlib.Position<String> pos_7 = tree.addChildLast(pos_6, new String("Iker"));
					es.upm.aedlib.Position<String> pos_8 = tree.addChildLast(pos_6, new String("Maria"));
					es.upm.aedlib.Position<String> pos_9 = tree.addChildLast(pos_6, new String("Susana"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("*"), new String("*") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray(
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] { new Integer(2) }),
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] { new Integer(3) }),
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] { new Integer(1) }))));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_14"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_15() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_15");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_15"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Guillem"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("*") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray(
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] {}))));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_15"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_16() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_16");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_16"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Guillem"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Mireia"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(pos_0, new String("Guillem"));
					es.upm.aedlib.Position<String> pos_2 = tree.addChildLast(pos_0, new String("Francesca"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("*"), new String("*"), new String("*") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray(
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] { new Integer(1), new Integer(1) }),
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] { new Integer(1), new Integer(2) }))));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_16"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_17() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_17");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_17"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Guillem"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Paloma"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(pos_0, new String("Laia"));
					es.upm.aedlib.Position<String> pos_2 = tree.addChildLast(root, new String("Noa"));
					es.upm.aedlib.Position<String> pos_3 = tree.addChildLast(pos_2, new String("Pablo"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("Paloma"), new String("*") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray()));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_17"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_18() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_18");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_18"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Ibai"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Alicia"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(root, new String("Guillem"));
					es.upm.aedlib.Position<String> pos_2 = tree.addChildLast(root, new String("Pedro"));
					es.upm.aedlib.Position<String> pos_3 = tree.addChildLast(pos_2, new String("Jordi"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("*") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray(
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] {}))));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_18"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_19() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_19");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_19"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Joana"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Teresa"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(root, new String("Pedro"));
					es.upm.aedlib.Position<String> pos_2 = tree.addChildLast(pos_1, new String("Alicia"));
					es.upm.aedlib.Position<String> pos_3 = tree.addChildLast(pos_1, new String("Manuel"));
					es.upm.aedlib.Position<String> pos_4 = tree.addChildLast(pos_3, new String("Sara"));
					es.upm.aedlib.Position<String> pos_5 = tree.addChildLast(pos_4, new String("Isabel"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("Joana"), new String("*") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray(
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] { new Integer(2) }),
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] { new Integer(1) }))));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_19"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_20() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_20");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_20"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Jordi"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Alicia"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(root, new String("Teresa"));
					es.upm.aedlib.Position<String> pos_2 = tree.addChildLast(pos_1, new String("Francesca"));
					es.upm.aedlib.Position<String> pos_3 = tree.addChildLast(pos_2, new String("Juan"));
					es.upm.aedlib.Position<String> pos_4 = tree.addChildLast(pos_3, new String("Maria"));
					es.upm.aedlib.Position<String> pos_5 = tree.addChildLast(pos_3, new String("Isabel"));
					es.upm.aedlib.Position<String> pos_6 = tree.addChildLast(pos_2, new String("Lucia"));
					es.upm.aedlib.Position<String> pos_7 = tree.addChildLast(pos_6, new String("Alicia"));
					es.upm.aedlib.Position<String> pos_8 = tree.addChildLast(pos_6, new String("Teresa"));
					es.upm.aedlib.Position<String> pos_9 = tree.addChildLast(pos_2, new String("Iker"));
					es.upm.aedlib.Position<String> pos_10 = tree.addChildLast(pos_9, new String("Mireia"));
					es.upm.aedlib.Position<String> pos_11 = tree.addChildLast(root, new String("Paula"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("*"), new String("*") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray(
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] { new Integer(2) }),
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] { new Integer(3) }),
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] { new Integer(1) }))));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_20"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_21() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_21");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_21"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Jose"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("*") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray(
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] {}))));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_21"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_22() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_22");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_22"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Juan"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Mireia"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(root, new String("Laura"));
					es.upm.aedlib.Position<String> pos_2 = tree.addChildLast(root, new String("Paula"));
					es.upm.aedlib.Position<String> pos_3 = tree.addChildLast(pos_2, new String("Oier"));
					es.upm.aedlib.Position<String> pos_4 = tree.addChildLast(pos_2, new String("Alicia"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("Juan"), new String("Paula") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray(
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] { new Integer(3) }))));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_22"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_23() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_23");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_23"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Julia"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("Julia"), new String("Julia") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray()));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_23"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_24() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_24");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_24"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Laia"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Jordi"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(root, new String("Francesca"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("*") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray(
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] {}))));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_24"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_25() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_25");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_25"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Laura"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Antonio"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(pos_0, new String("Ibai"));
					es.upm.aedlib.Position<String> pos_2 = tree.addChildLast(pos_0, new String("Noa"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("Laura"), new String("Antonio") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray(
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] { new Integer(1) }))));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_25"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_26() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_26");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_26"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Leire"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Mireia"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(pos_0, new String("Alejandro"));
					es.upm.aedlib.Position<String> pos_2 = tree.addChildLast(pos_0, new String("Joana"));
					es.upm.aedlib.Position<String> pos_3 = tree.addChildLast(root, new String("Unai"));
					es.upm.aedlib.Position<String> pos_4 = tree.addChildLast(root, new String("Jose"));
					es.upm.aedlib.Position<String> pos_5 = tree.addChildLast(pos_4, new String("Irati"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("*"), new String("*") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray(
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] { new Integer(2) }),
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] { new Integer(3) }),
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] { new Integer(1) }))));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_26"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_27() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_27");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_27"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Lucia"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("Lucia") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray(
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] {}))));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_27"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_28() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_28");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_28"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Lucia"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Ander"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(root, new String("Pablo"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("*") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray(
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] {}))));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_28"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_29() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_29");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_29"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Manuel"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Sara"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("*") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray(
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] {}))));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_29"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_30() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_30");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_30"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Manuel"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Sara"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(pos_0, new String("Noa"));
					es.upm.aedlib.Position<String> pos_2 = tree.addChildLast(pos_0, new String("Carmen"));
					es.upm.aedlib.Position<String> pos_3 = tree.addChildLast(pos_0, new String("Carmen"));
					es.upm.aedlib.Position<String> pos_4 = tree.addChildLast(pos_0, new String("Marc"));
					es.upm.aedlib.Position<String> pos_5 = tree.addChildLast(root, new String("Leire"));
					es.upm.aedlib.Position<String> pos_6 = tree.addChildLast(pos_5, new String("Ibai"));
					es.upm.aedlib.Position<String> pos_7 = tree.addChildLast(pos_5, new String("Isabel"));
					es.upm.aedlib.Position<String> pos_8 = tree.addChildLast(pos_5, new String("Jordi"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("*"), new String("*") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray(
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] { new Integer(2) }),
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] { new Integer(1) }))));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_30"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_31() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_31");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_31"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Maria"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Francesca"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(pos_0, new String("Marc"));
					es.upm.aedlib.Position<String> pos_2 = tree.addChildLast(pos_0, new String("Joana"));
					es.upm.aedlib.Position<String> pos_3 = tree.addChildLast(pos_0, new String("Isabel"));
					es.upm.aedlib.Position<String> pos_4 = tree.addChildLast(pos_0, new String("Laia"));
					es.upm.aedlib.Position<String> pos_5 = tree.addChildLast(root, new String("Maria"));
					es.upm.aedlib.Position<String> pos_6 = tree.addChildLast(root, new String("Antonio"));
					es.upm.aedlib.Position<String> pos_7 = tree.addChildLast(pos_6, new String("Francesca"));
					es.upm.aedlib.Position<String> pos_8 = tree.addChildLast(pos_6, new String("Julia"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("Maria") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray(
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] {}))));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_31"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_32() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_32");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_32"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Mikel"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Jose"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(root, new String("Paula"));
					es.upm.aedlib.Position<String> pos_2 = tree.addChildLast(pos_1, new String("Maria"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("Mikel") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray(
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] {}))));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_32"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_33() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_33");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_33"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Mireia"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("Mireia") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray(
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] {}))));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_33"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_34() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_34");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_34"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Noa"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("*") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray(
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] {}))));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_34"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_35() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_35");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_35"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Oier"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("*") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray(
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] {}))));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_35"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_36() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_36");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_36"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Oier"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Mikel"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(pos_0, new String("Alicia"));
					es.upm.aedlib.Position<String> pos_2 = tree.addChildLast(pos_0, new String("Miguel"));
					es.upm.aedlib.Position<String> pos_3 = tree.addChildLast(pos_0, new String("Ibai"));
					es.upm.aedlib.Position<String> pos_4 = tree.addChildLast(root, new String("Laia"));
					es.upm.aedlib.Position<String> pos_5 = tree.addChildLast(pos_4, new String("Teresa"));
					es.upm.aedlib.Position<String> pos_6 = tree.addChildLast(pos_4, new String("Irati"));
					es.upm.aedlib.Position<String> pos_7 = tree.addChildLast(root, new String("Pedro"));
					es.upm.aedlib.Position<String> pos_8 = tree.addChildLast(root, new String("Juan"));
					es.upm.aedlib.Position<String> pos_9 = tree.addChildLast(pos_8, new String("Sara"));
					es.upm.aedlib.Position<String> pos_10 = tree.addChildLast(pos_8, new String("Julia"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(new String[] {
							new String("*"), new String("*"), new String("Sara") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray(
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] { new Integer(4), new Integer(1) }))));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_36"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_37() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_37");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_37"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Pablo"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Paloma"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(pos_0, new String("Andreu"));
					es.upm.aedlib.Position<String> pos_2 = tree.addChildLast(root, new String("Andreu"));
					es.upm.aedlib.Position<String> pos_3 = tree.addChildLast(pos_2, new String("Francesca"));
					es.upm.aedlib.Position<String> pos_4 = tree.addChildLast(pos_2, new String("Pablo"));
					es.upm.aedlib.Position<String> pos_5 = tree.addChildLast(root, new String("Irati"));
					es.upm.aedlib.Position<String> pos_6 = tree.addChildLast(pos_5, new String("Jordi"));
					es.upm.aedlib.Position<String> pos_7 = tree.addChildLast(pos_5, new String("Susana"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("Pablo") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray(
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] {}))));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_37"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_38() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_38");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_38"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Paula"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("*") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray(
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] {}))));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_38"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_39() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_39");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_39"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Paula"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Unai"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(root, new String("Antonio"));
					es.upm.aedlib.Position<String> pos_2 = tree.addChildLast(root, new String("Unai"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("Paula") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray(
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] {}))));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_39"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_40() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_40");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_40"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Pedro"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("*") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray(
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] {}))));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_40"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_41() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_41");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_41"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Teresa"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Laura"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(pos_0, new String("Maria"));
					es.upm.aedlib.Position<String> pos_2 = tree.addChildLast(root, new String("Iker"));
					ok_sofar = new Search(tree, new es.upm.aedlib.positionlist.NodePositionList<String>(
							new String[] { new String("Teresa"), new String("Laura") })).doCall().checkResult(
									new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>(
											TestUtils.toGenericArray(
													new es.upm.aedlib.positionlist.NodePositionList<Integer>(
															new Integer[] { new Integer(1) }))));
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_41"));
		ResultsHandler.add_result(new String("search"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_42() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_42");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_42"));
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_42"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_43() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_43");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_43"));
				if (ok_sofar)
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray())).doCall()
											.checkResult(new es.upm.aedlib.tree.LinkedGeneralTree<String>());
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_43"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_44() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_44");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_44"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Alicia"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(new es.upm.aedlib.positionlist.NodePositionList<String>(
											new String[] { new String("Alicia") })))).doCall().checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_44"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_45() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_45");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_45"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Alicia"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Antonio"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(root, new String("Guillem"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Alicia"), new String("Antonio") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Alicia"), new String("Guillem") }))))
															.doCall().checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_45"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_46() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_46");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_46"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Carmen"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(new es.upm.aedlib.positionlist.NodePositionList<String>(
											new String[] { new String("Carmen") })))).doCall().checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_46"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_47() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_47");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_47"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Francesca"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(new es.upm.aedlib.positionlist.NodePositionList<String>(
											new String[] { new String("Francesca") })))).doCall().checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_47"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_48() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_48");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_48"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Guillem"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(new es.upm.aedlib.positionlist.NodePositionList<String>(
											new String[] { new String("Guillem") })))).doCall().checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_48"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_49() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_49");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_49"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Guillem"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Ibai"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(pos_0, new String("Isabel"));
					es.upm.aedlib.Position<String> pos_2 = tree.addChildLast(root, new String("Paloma"));
					es.upm.aedlib.Position<String> pos_3 = tree.addChildLast(pos_2, new String("Guillem"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Guillem"), new String("Paloma"),
															new String("Guillem") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Guillem"), new String("Ibai"),
															new String("Isabel") })))).doCall().checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_49"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_50() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_50");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_50"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Guillem"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Oier"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(pos_0, new String("Marc"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(
											new es.upm.aedlib.positionlist.NodePositionList<String>(new String[] {
													new String("Guillem"), new String("Oier"), new String("Marc") }))))
															.doCall().checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_50"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_51() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_51");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_51"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Ibai"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Leire"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(root, new String("Marc"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Ibai"), new String("Leire") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Ibai"), new String("Marc") })))).doCall()
															.checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_51"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_52() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_52");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_52"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Iker"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(new es.upm.aedlib.positionlist.NodePositionList<String>(
											new String[] { new String("Iker") })))).doCall().checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_52"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_53() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_53");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_53"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Iker"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Antonio"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(pos_0, new String("Lucia"));
					es.upm.aedlib.Position<String> pos_2 = tree.addChildLast(root, new String("Carmen"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(
											new es.upm.aedlib.positionlist.NodePositionList<String>(new String[] {
													new String("Iker"), new String("Antonio"), new String("Lucia") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Iker"), new String("Carmen") }))))
															.doCall().checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_53"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_54() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_54");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_54"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Irati"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(new es.upm.aedlib.positionlist.NodePositionList<String>(
											new String[] { new String("Irati") })))).doCall().checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_54"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_55() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_55");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_55"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Isabel"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Jordi"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(pos_0, new String("Iker"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(
											new es.upm.aedlib.positionlist.NodePositionList<String>(new String[] {
													new String("Isabel"), new String("Jordi"), new String("Iker") }))))
															.doCall().checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_55"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_56() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_56");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_56"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Joana"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Carmen"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Joana") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Joana"), new String("Carmen") }))))
															.doCall().checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_56"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_57() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_57");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_57"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Joana"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Isabel"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(new es.upm.aedlib.positionlist.NodePositionList<String>(
											new String[] { new String("Joana"), new String("Isabel") })))).doCall()
													.checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_57"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_58() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_58");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_58"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Jordi"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(new es.upm.aedlib.positionlist.NodePositionList<String>(
											new String[] { new String("Jordi") })))).doCall().checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_58"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_59() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_59");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_59"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Jordi"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Antonio"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(pos_0, new String("Jordi"));
					es.upm.aedlib.Position<String> pos_2 = tree.addChildLast(pos_0, new String("Guillem"));
					es.upm.aedlib.Position<String> pos_3 = tree.addChildLast(root, new String("Pablo"));
					es.upm.aedlib.Position<String> pos_4 = tree.addChildLast(pos_3, new String("Ander"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(
											new es.upm.aedlib.positionlist.NodePositionList<String>(new String[] {
													new String("Jordi"), new String("Antonio"), new String("Jordi") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Jordi"), new String("Pablo") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Jordi") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Jordi"), new String("Antonio"),
															new String("Guillem") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(new String[] {
													new String("Jordi"), new String("Pablo"), new String("Ander") }))))
															.doCall().checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_59"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_60() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_60");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_60"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Jose"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Paula"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(root, new String("Leire"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Jose"), new String("Paula") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Jose") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Jose"), new String("Leire") }))))
															.doCall().checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_60"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_61() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_61");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_61"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Juan"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(new es.upm.aedlib.positionlist.NodePositionList<String>(
											new String[] { new String("Juan") })))).doCall().checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_61"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_62() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_62");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_62"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Julia"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Maria"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(pos_0, new String("Leire"));
					es.upm.aedlib.Position<String> pos_2 = tree.addChildLast(pos_0, new String("Isabel"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(
											new es.upm.aedlib.positionlist.NodePositionList<String>(new String[] {
													new String("Julia"), new String("Maria"), new String("Isabel") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(new String[] {
													new String("Julia"), new String("Maria"), new String("Leire") }))))
															.doCall().checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_62"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_63() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_63");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_63"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Laia"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Carmen"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(pos_0, new String("Manuel"));
					es.upm.aedlib.Position<String> pos_2 = tree.addChildLast(root, new String("Pedro"));
					es.upm.aedlib.Position<String> pos_3 = tree.addChildLast(pos_2, new String("Carmen"));
					es.upm.aedlib.Position<String> pos_4 = tree.addChildLast(pos_2, new String("Noa"));
					es.upm.aedlib.Position<String> pos_5 = tree.addChildLast(pos_2, new String("Leire"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(
											new es.upm.aedlib.positionlist.NodePositionList<String>(new String[] {
													new String("Laia"), new String("Carmen"), new String("Manuel") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(new String[] {
													new String("Laia"), new String("Pedro"), new String("Carmen") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(new String[] {
													new String("Laia"), new String("Pedro"), new String("Leire") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(new String[] {
													new String("Laia"), new String("Pedro"), new String("Noa") }))))
															.doCall().checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_63"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_64() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_64");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_64"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Laura"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Francisco"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(root, new String("Irati"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Laura"), new String("Irati") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Laura"), new String("Francisco") }))))
															.doCall().checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_64"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_65() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_65");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_65"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Lucia"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(new es.upm.aedlib.positionlist.NodePositionList<String>(
											new String[] { new String("Lucia") })))).doCall().checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_65"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_66() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_66");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_66"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Lucia"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Francisco"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(pos_0, new String("Joana"));
					es.upm.aedlib.Position<String> pos_2 = tree.addChildLast(pos_0, new String("Jordi"));
					es.upm.aedlib.Position<String> pos_3 = tree.addChildLast(root, new String("Julia"));
					es.upm.aedlib.Position<String> pos_4 = tree.addChildLast(pos_3, new String("Paula"));
					es.upm.aedlib.Position<String> pos_5 = tree.addChildLast(pos_3, new String("Andreu"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Lucia"), new String("Francisco"),
															new String("Jordi") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(new String[] {
													new String("Lucia"), new String("Julia"), new String("Andreu") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Lucia"), new String("Julia") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(new String[] {
													new String("Lucia"), new String("Julia"), new String("Paula") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Lucia"), new String("Francisco"),
															new String("Joana") })))).doCall().checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_66"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_67() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_67");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_67"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Manuel"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Irati"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(root, new String("Maria"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Manuel"), new String("Maria") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Manuel"), new String("Irati") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Manuel") })))).doCall()
															.checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_67"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_68() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_68");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_68"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Marc"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(new es.upm.aedlib.positionlist.NodePositionList<String>(
											new String[] { new String("Marc") })))).doCall().checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_68"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_69() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_69");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_69"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Marc"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Antonio"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(root, new String("Teresa"));
					es.upm.aedlib.Position<String> pos_2 = tree.addChildLast(root, new String("Joana"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Marc"), new String("Antonio") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Marc"), new String("Joana") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Marc"), new String("Teresa") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Marc") })))).doCall().checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_69"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_70() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_70");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_70"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Marc"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Pedro"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(pos_0, new String("Isabel"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(
											new es.upm.aedlib.positionlist.NodePositionList<String>(new String[] {
													new String("Marc"), new String("Pedro"), new String("Isabel") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Marc") })))).doCall().checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_70"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_71() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_71");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_71"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Maria"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Laura"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(root, new String("Francesca"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Maria") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Maria"), new String("Laura") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Maria"), new String("Francesca") }))))
															.doCall().checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_71"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_72() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_72");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_72"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Miguel"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(new es.upm.aedlib.positionlist.NodePositionList<String>(
											new String[] { new String("Miguel") })))).doCall().checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_72"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_73() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_73");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_73"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Miguel"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Irati"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(pos_0, new String("Laura"));
					es.upm.aedlib.Position<String> pos_2 = tree.addChildLast(root, new String("Ander"));
					es.upm.aedlib.Position<String> pos_3 = tree.addChildLast(pos_2, new String("Leire"));
					es.upm.aedlib.Position<String> pos_4 = tree.addChildLast(root, new String("Alejandro"));
					es.upm.aedlib.Position<String> pos_5 = tree.addChildLast(pos_4, new String("Laia"));
					es.upm.aedlib.Position<String> pos_6 = tree.addChildLast(pos_4, new String("Ander"));
					es.upm.aedlib.Position<String> pos_7 = tree.addChildLast(pos_4, new String("Ane"));
					es.upm.aedlib.Position<String> pos_8 = tree.addChildLast(pos_7, new String("Guillem"));
					es.upm.aedlib.Position<String> pos_9 = tree.addChildLast(pos_7, new String("Francesca"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(
											new es.upm.aedlib.positionlist.NodePositionList<String>(new String[] {
													new String("Miguel"), new String("Ander"), new String("Leire") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Miguel"), new String("Alejandro"),
															new String("Ane"), new String("Francesca") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Miguel"), new String("Alejandro"),
															new String("Ane"), new String("Guillem") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Miguel"), new String("Alejandro"),
															new String("Laia") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Miguel"), new String("Alejandro"),
															new String("Ander") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(new String[] {
													new String("Miguel"), new String("Irati"), new String("Laura") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(new String[] {
													new String("Miguel"), new String("Alejandro"), new String("Ane") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Miguel") })))).doCall()
															.checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_73"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_74() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_74");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_74"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Noa"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(new es.upm.aedlib.positionlist.NodePositionList<String>(
											new String[] { new String("Noa") })))).doCall().checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_74"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_75() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_75");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_75"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Noa"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Francisco"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(pos_0, new String("Maria"));
					es.upm.aedlib.Position<String> pos_2 = tree.addChildLast(pos_0, new String("Oier"));
					es.upm.aedlib.Position<String> pos_3 = tree.addChildLast(root, new String("Maria"));
					es.upm.aedlib.Position<String> pos_4 = tree.addChildLast(pos_3, new String("Noa"));
					es.upm.aedlib.Position<String> pos_5 = tree.addChildLast(pos_3, new String("Andreu"));
					es.upm.aedlib.Position<String> pos_6 = tree.addChildLast(root, new String("Paula"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Noa") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(new String[] {
													new String("Noa"), new String("Francisco"), new String("Oier") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Noa"), new String("Paula") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(new String[] {
													new String("Noa"), new String("Francisco"), new String("Maria") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Noa"), new String("Francisco") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(new String[] {
													new String("Noa"), new String("Maria"), new String("Noa") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(new String[] {
													new String("Noa"), new String("Maria"), new String("Andreu") }))))
															.doCall().checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_75"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_76() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_76");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_76"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Oier"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Leire"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(new es.upm.aedlib.positionlist.NodePositionList<String>(
											new String[] { new String("Oier"), new String("Leire") })))).doCall()
													.checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_76"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_77() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_77");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_77"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Paloma"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(new es.upm.aedlib.positionlist.NodePositionList<String>(
											new String[] { new String("Paloma") })))).doCall().checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_77"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_78() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_78");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_78"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Paula"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Isabel"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(pos_0, new String("Alicia"));
					es.upm.aedlib.Position<String> pos_2 = tree.addChildLast(root, new String("Mikel"));
					es.upm.aedlib.Position<String> pos_3 = tree.addChildLast(pos_2, new String("Ibai"));
					es.upm.aedlib.Position<String> pos_4 = tree.addChildLast(pos_2, new String("Ander"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(
											new es.upm.aedlib.positionlist.NodePositionList<String>(new String[] {
													new String("Paula"), new String("Mikel"), new String("Ander") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(new String[] {
													new String("Paula"), new String("Mikel"), new String("Ibai") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(new String[] {
													new String("Paula"), new String("Isabel"), new String("Alicia") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Paula") })))).doCall().checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_78"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_79() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_79");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_79"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Paula"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Paula"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(pos_0, new String("Irati"));
					es.upm.aedlib.Position<String> pos_2 = tree.addChildLast(pos_0, new String("Susana"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(
											new es.upm.aedlib.positionlist.NodePositionList<String>(new String[] {
													new String("Paula"), new String("Paula"), new String("Susana") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Paula"), new String("Paula") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(new String[] {
													new String("Paula"), new String("Paula"), new String("Irati") }))))
															.doCall().checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_79"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_80() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_80");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_80"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Paula"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Teresa"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(new es.upm.aedlib.positionlist.NodePositionList<String>(
											new String[] { new String("Paula"), new String("Teresa") })))).doCall()
													.checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_80"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_81() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_81");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_81"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Sara"));
					es.upm.aedlib.Position<String> pos_0 = tree.addChildLast(root, new String("Teresa"));
					es.upm.aedlib.Position<String> pos_1 = tree.addChildLast(pos_0, new String("Antonio"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Sara") }),
											new es.upm.aedlib.positionlist.NodePositionList<String>(
													new String[] { new String("Sara"), new String("Teresa"),
															new String("Antonio") })))).doCall().checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_81"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	@Test
	public void test_82() {
		if (ResultsHandler.isTimedout()) {
			Assertions.assertTrue(false, new String("Testing stopped due to global timeout -- too slow execution"));
		}
		boolean resultIs = true;
		try {
			resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_82");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_82"));
				if (ok_sofar) {
					es.upm.aedlib.tree.GeneralTree<String> tree = new es.upm.aedlib.tree.LinkedGeneralTree<String>();
					es.upm.aedlib.Position<String> root = tree.addRoot(new String("Unai"));
					ok_sofar = new ConstructDeterministicTree(
							new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(
									TestUtils.toGenericArray(new es.upm.aedlib.positionlist.NodePositionList<String>(
											new String[] { new String("Unai") })))).doCall().checkResult(tree);
				}
				return ok_sofar;
			});
		} catch (org.opentest4j.AssertionFailedError exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.DURING,
					new String("*** TIMEOUT! *** Very slow or non-terminating execution"), exc);
			resultIs = false;
		} catch (Throwable exc) {
			TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,
					new String("Internal testing error; please report this to teachers"), exc);
			resultIs = false;
		}
		String messages = TestData.getMessages();
		ResultsHandler.stopTest(new String("test_82"));
		ResultsHandler.add_result(new String("constructDeterministicTree"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	static class Tests {
		static String tester = "TesterLab5";
	}

	static class TreeSearchUtils {

		static boolean checkSearch(Search call,
				TestResult<es.upm.aedlib.set.Set<Position<String>>, PositionListSet<NodePositionList<Integer>>> result,
				PositionListSet<NodePositionList<Integer>> expected) {
			String callString = call.toString();
			Tree<String> t = call.tree;

			if (!call.noException(() -> "\nThe tree was\n" + t)) {
				return false;
			}

			if (!call.nonNull(() -> "\nThe tree was\n" + t)) {
				return false;
			}

			es.upm.aedlib.set.Set<Position<String>> expectedSet = new PositionListSet<Position<String>>();
			for (PositionList<Integer> path : expected) {
				expectedSet.add(findPosition(path, path.first(), t, t.root()));
			}

			es.upm.aedlib.set.Set<Position<String>> resultSet = result.getValue();

			if (!resultSet.equals(expectedSet)) {
				TestUtils.printError(TestUtils.ExecutionTime.DURING,
						"the call " + callString + "\nwith the tree\n" + t + "\nreturned a set of positions\n"
								+ resultSet + "\n" + "which is different from the expected set of positions\n"
								+ expectedSet);
				return false;
			} else
				return true;
		}

		static <E> Position<E> findPosition(PositionList<Integer> path, Position<Integer> cursor, Tree<E> t,
				Position<E> pos) {
			if (cursor == null)
				return pos;
			else {
				int childNo = cursor.element();
				for (Position<E> child : t.children(pos)) {
					if (childNo == 1)
						return findPosition(path, path.next(cursor), t, child);
					else
						--childNo;
				}
			}
			return null;
		}

		static <E> boolean checkConstructDeterministicTree(ConstructDeterministicTree call,
				TestResult<Tree<E>, Tree<E>> result, Tree<E> expected) {
			String callString = call.toString();

			if (!call.noException()) {
				return false;
			}

			if (!call.nonNull()) {
				return false;
			}

			return deterministicTreeEq(() -> call.toString(), result.getValue(), expected);
		}

		static <E> boolean deterministicTreeEq(Supplier<String> callString, Tree<E> result, Tree<E> expected) {
			if (result.size() != expected.size()) {
				TestUtils.printError(TestUtils.ExecutionTime.DURING,
						"the call " + callString.get() + " return a tree\n\n" + result + "\n"
								+ "which has a different number of nodes compared to the expected tree\n\n" + expected);
				return false;
			}

			if (result.isEmpty())
				return true;
			else if (!eqNodes(callString, result, expected, result.root(), expected.root())) {
				TestUtils.printError(TestUtils.ExecutionTime.DURING,
						"the call " + callString.get() + " return a tree\n\n" + result + "\n"
								+ "which is different to the expected tree\n\n" + expected);
				return false;
			} else
				return true;
		}

		static <E> boolean eqNodes(Supplier<String> callString, Tree<E> result, Tree<E> expected, Position<E> resultPos,
				Position<E> expectedPos) {

			if (resultPos == null)
				throw new IllegalArgumentException("Internal error: resultPos == null");
			if (expectedPos == null)
				throw new IllegalArgumentException("Internal error: expectedPos == null");

			if (!equalElements(resultPos, expectedPos)) {
				return false;
			}

			// Check if deterministic children
			{
				PositionList<Position<E>> resultChildren = new NodePositionList<Position<E>>();
				for (Position<E> resultChild : result.children(resultPos))
					resultChildren.addLast(resultChild);
				PositionList<Position<E>> expectedChildren = new NodePositionList<Position<E>>();
				for (Position<E> expectedChild : expected.children(expectedPos))
					expectedChildren.addLast(expectedChild);

				if (resultChildren.size() != expectedChildren.size()) {
					return false;
				}

				Position<Position<E>> resultChildrenCursor = resultChildren.first();
				while (resultChildrenCursor != null) {
					Position<Position<E>> restChildrenCursor = resultChildren.next(resultChildrenCursor);
					while (restChildrenCursor != null) {
						if (equalElements(resultChildrenCursor.element(), restChildrenCursor.element())) {
							TestUtils.printError(TestUtils.ExecutionTime.DURING, "the call " + callString.get()
									+ " return a tree\n\n" + result + "\n" + "which is not deterministic.\n");
							return false;
						}
						restChildrenCursor = resultChildren.next(restChildrenCursor);
					}
					resultChildrenCursor = resultChildren.next(resultChildrenCursor);
				}
			}

			boolean foundChildren = true;
			for (Position<E> expectedChild : expected.children(expectedPos)) {
				boolean foundChild = false;
				for (Position<E> resultChild : result.children(resultPos)) {
					if (foundChildren && !foundChild) {
						if (equalElements(expectedChild, resultChild)) {
							if (!eqNodes(callString, result, expected, resultChild, expectedChild))
								return false;
							foundChild = true;
						}
					}
				}
				foundChildren = foundChildren && foundChild;
			}
			return foundChildren;
		}

		static <E> boolean equalElements(Position<E> p1, Position<E> p2) {
			E e1 = p1.element();
			E e2 = p2.element();
			return e1 == null ? e2 == null : e1.equals(e2);
		}

		public static void resetPrinter() {
		}

		public static String printer(Object obj) {
			if (obj instanceof Tree<?>) {
				return "tree";
			} else
				return TestUtils.printer(obj, x -> printer(x));
		}

	}

	static class TestUtils {
		enum ExecutionTime {
			AFTER, LAST, DURING, UNRELATED
		}

		static String print(Object obj) {
			return TesterCode.printer(obj);
		}

		static String standardPrinter(Object obj) {
			return printer(obj, x -> standardPrinter(x));
		}

		static String printer(Object obj, Function<Object, String> print) {
			if (obj == null)
				return "null";
			else if (obj instanceof String) {
				return ("\"" + obj.toString() + "\"");
			} else if (obj instanceof Pair<?, ?>) {
				Pair<?, ?> p = (Pair<?, ?>) obj;
				return "Pair(" + print.apply(p.getLeft()) + "," + print.apply(p.getRight()) + ")";
			} else if (obj instanceof java.util.Set<?>) {
				Iterable<?> l = (Iterable<?>) obj;
				StringBuffer buf = new StringBuffer();
				buf.append("{");
				boolean first = true;
				for (Object lobj : l) {
					if (first)
						first = false;
					else
						buf.append(",");
					buf.append(print.apply(lobj));
				}
				buf.append("}");
				return buf.toString();
			} else if (obj instanceof Iterable<?>) {
				Iterable<?> l = (Iterable<?>) obj;
				StringBuffer buf = new StringBuffer();
				buf.append("[");
				boolean first = true;
				for (Object lobj : l) {
					if (first)
						first = false;
					else
						buf.append(",");
					buf.append(print.apply(lobj));
				}
				buf.append("]");
				return buf.toString();
			} else if (obj instanceof Map<?, ?>) {
				Map<?, ?> m = (Map<?, ?>) obj;
				StringBuffer buf = new StringBuffer();
				buf.append("[");
				boolean first = true;
				for (Entry<?, ?> lobj : m.entries()) {
					if (first)
						first = false;
					else
						buf.append(",");
					buf.append("(" + print.apply(lobj.getKey()) + "," + print.apply(lobj.getValue()) + ")");
				}
				buf.append("]");
				return buf.toString();
			} else if (obj instanceof Object[]) {
				Object[] arr = (Object[]) obj;
				StringBuffer buf = new StringBuffer();
				buf.append("[");
				boolean first = true;
				for (int i = 0; i < arr.length; i++) {
					Object aobj = arr[i];
					if (first)
						first = false;
					else
						buf.append(",");
					buf.append(print.apply(aobj));
				}
				buf.append("]");
				return buf.toString();
			} else if (obj instanceof int[]) {
				int[] arr = (int[]) obj;
				StringBuffer buf = new StringBuffer();
				buf.append("[");
				boolean first = true;
				for (int i = 0; i < arr.length; i++) {
					int aobj = arr[i];
					if (first)
						first = false;
					else
						buf.append(",");
					buf.append(print.apply(aobj));
				}
				buf.append("]");
				return buf.toString();
			} else
				return obj.toString();
		}

		static void printWarning(String TestName) {
			TestData.message("\n*** Warning in " + (TestName == null ? "" : TestName) + ":");
		}

		static void printError(String TestName) {
			TestData.message("\n\n***********************************************");
			TestData.message("*** Error in " + (TestName == null ? "" : TestName) + ":");
		}

		static void terminateErrorPrint() {
			TestData.message("\n***********************************************\n\n");
		}

		static boolean compare(Object o1, Object o2) {
			if (o1 == null)
				return o2 == null;
			else
				return o1.equals(o2);
		}

		static void printCallException(ExecutionTime time, String msg, Throwable exc) {
			printError(TestData.testName);

			int traceLength = TestData.numCommands();

			if (traceLength > 0) {
				TestData.message("\n" + callSeqString(traceLength, time) + "\n");
				TestData.message(TestData.getTrace());
			}

			switch (time) {
			case AFTER:
				TestData.message(
						"the call to " + msg + " raised the exception " + exc + " although it should not have");
				break;
			default:
				TestData.message(
						" -- the exception " + exc + " was raised although it " + "should not have been\n" + msg);
				break;
			}
			TestData.message(getStackTrace(exc));
			terminateErrorPrint();
		}

		static String getStackTrace(Throwable throwable) {
			filterStackTrace(throwable);
			StringWriter errors = new StringWriter();
			throwable.printStackTrace(new PrintWriter(errors));
			return errors.toString();
		}

		static void filterStackTrace(Throwable throwable) {
			StackTraceElement[] stackTrace = throwable.getStackTrace();
			ArrayList<StackTraceElement> l = new ArrayList<StackTraceElement>();
			for (int i = 0; i < stackTrace.length; i++) {
				String className = stackTrace[i].getClassName();
				if (className.startsWith("jdk.internal") || className.startsWith("org.junit"))
					break;
				l.add(stackTrace[i]);
			}
			StackTraceElement[] cutStackTrace = new StackTraceElement[l.size()];
			throwable.setStackTrace(l.toArray(cutStackTrace));
		}

		static void printCallException(String msg, Throwable exc) {
			printCallException(ExecutionTime.AFTER, msg, exc);
		}

		static void printCallException(Throwable exc) {
			printCallException(ExecutionTime.LAST, "", exc);
		}

		static void printCallException(Throwable exc, Supplier<String> msg) {
			printCallException(ExecutionTime.LAST, msg.get(), exc);
		}

		static void printWarning(ExecutionTime time, String msg) {
			TestData.message("\n\n***********************************************");
			if (TestData.testName != "") {
				TestData.message("\n*** Warning for " + TestData.testName + ": ");
			} else
				TestData.message("\n*** Warning:");

			if (time != TestUtils.ExecutionTime.UNRELATED) {
				int traceLength = TestData.numCommands();

				if (traceLength > 0) {
					TestData.message(callSeqString(traceLength, time));
					TestData.message(TestData.getTrace());
				}
			}
			TestData.message(msg);
			terminateErrorPrint();
		}

		static void printError(ExecutionTime time, String msg) {
			printError(TestData.testName);

			if (time != TestUtils.ExecutionTime.UNRELATED) {
				int traceLength = TestData.numCommands();

				if (traceLength > 0) {
					TestData.message("\n" + callSeqString(traceLength, time));
					TestData.message(TestData.getTrace());
				}
			}

			TestData.message(msg);
			terminateErrorPrint();
		}

		static String callSeqString(int traceLength, ExecutionTime time) {
			if (traceLength < 2)
				return "while executing the call ";
			else {
				switch (time) {
				case AFTER:
					return "after executing the call sequence ";
				case LAST:
					return "while executing the last statement of call sequence ";
				case DURING:
					return "while executing the call sequence ";
				case UNRELATED:
					return "";
				}
				return "";
			}
		}

		// Checks that results, which may not be an exception nor null
		// (needs prior checks), which are iterables, return the same
		// set of elements.
		// *********************************************
		// WARNING: this relies on a sane definition of
		// hashCode and equals which does not fail upon finding
		// null values...
		static <E extends Iterable<?>, F extends Iterable<?>> boolean sameSet(TestCall<E, F> call,
				TestResult<E, F> result, F expected) {
			return sameSet(call, result.getValue(), expected);
		}

		// *********************************************
		// WARNING: this relies on a sane definition of
		// hashCode and equals which does not fail upon finding
		// null values...
		static <E extends Iterable<?>, F extends Iterable<?>> boolean sameSet(TestCall<?, ?> call, E value,
				F expected) {

			HashSet<Object> s1 = new HashSet<Object>();
			HashSet<Object> s2 = new HashSet<Object>();
			for (Object e : value)
				s1.add(e);
			for (Object f : expected)
				s2.add(f);
			if (!s1.equals(s2)) {
				printError(ExecutionTime.DURING,
						"the call " + call.toString() + " returned a value which contained the elements\n  "
								+ TestUtils.print(s1) + "\nwhich differs from the expected elements\n  "
								+ TestUtils.print(s2));
				return false;
			}
			return true;
		}

		// Checks that results, which are iterables, return the same
		// elements, regardless of the order.
		static <E, F> boolean sameElements(TestCall<E, F> call, TestResult<E, F> result, F expected) {
			if (!call.noException())
				return false;
			if (!call.nonNull())
				return false;

			return sameElements(call, result.getValue(), expected);
		}

		// *********************************************
		// WARNING: this relies on a sane definition of
		// hashCode and equals which does not fail upon finding
		// null values...

		static <E, F> boolean sameElements(TestCall<E, F> call, E value, F expected) {

			if (!sameElements(value, expected)) {
				printError(ExecutionTime.DURING,
						"the call " + call.toString() + " returned a value which contained the elements\n  "
								+ TestUtils.print(value) + "\nwhich differs from the expected elements\n  "
								+ TestUtils.print(expected));
				return false;
			}
			return true;
		}

		// *********************************************
		// WARNING: this relies on a sane definition of
		// hashCode and equals which does not fail upon finding
		// null values...
		static <E, F> boolean sameElements(E valueP, F expectedP) {
			if ((valueP instanceof Iterable<?>) && (expectedP instanceof Iterable<?>)) {
				Iterable<?> value = (Iterable<?>) valueP;
				Iterable<?> expected = (Iterable<?>) expectedP;

				HashMap<Object, Integer> s1 = new HashMap<Object, Integer>();
				HashMap<Object, Integer> s2 = new HashMap<Object, Integer>();
				for (Object e : value) {
					Integer si = s1.get(e);
					if (si == null)
						si = 0;
					s1.put(e, si + 1);
				}
				for (Object f : expected) {
					Integer si = s2.get(f);
					if (si == null)
						si = 0;
					s2.put(f, si + 1);
				}
				if (!s1.equals(s2))
					return false;
				else
					return true;
			} else {
				if (!(valueP instanceof Iterable<?>))
					System.out
							.println("*** Error: result of type " + valueP.getClass() + " does not implement Iterable");
				if (!(expectedP instanceof Iterable<?>))
					System.out.println(
							"*** Error: expected of type " + expectedP.getClass() + " does not implement Iterable");
				throw new RuntimeException();
			}
		}

		// *********************************************
		// WARNING: this relies on a sane definition of
		// equals which does not fail upon finding
		// null values...
		static <E> boolean wellSorted(TestCall<?, ?> call, IndexedList<E> value,
				ArrayIndexedList<ArrayIndexedList<E>> expected) {

			int i = 0;
			IndexedList<E> eqClass = null;
			for (E e : value) {
				if (eqClass == null) {
					if (i < expected.size())
						eqClass = new ArrayIndexedList<E>(expected.get(i));
					else {
						printError(ExecutionTime.DURING, "the call " + call.toString() + " returned a list: " + value
								+ " which isn't sorted correctly. The correct sort order is " + expected);
						return false;
					}
				}
				if (!eqClass.remove(e)) {
					printError(ExecutionTime.DURING, "the call " + call.toString() + " returned a list: " + value
							+ " which isn't sorted correctly. The correct sort order is " + expected);
					return false;
				}
				if (eqClass.size() == 0) {
					eqClass = null;
					i++;
				}
			}
			if (eqClass != null || i < expected.size()) {
				printError(ExecutionTime.DURING, "the call " + call.toString() + " returned a list: " + value
						+ " which isn't sorted correctly. The correct sort order is " + expected);
				return false;
			}
			return true;
		}

		static <E> PositionList<E> extractElementsFromIterable(String callString, Iterable<E> i) {
			if (i == null) {
				printError(ExecutionTime.DURING, "the call " + callString + " returned an null iterable");
				return null;
			}

			PositionList<E> l = null;

			try {
				java.util.Iterator<E> it = i.iterator();
				l = extractElementsFromIterator(it);
			} catch (Throwable exc) {
				printError(ExecutionTime.DURING,
						"the call " + callString + " returned an iterable which when used raised the exception " + exc
								+ "\n" + getStackTrace(exc));
				return null;
			}
			return l;
		}

		static <E> PositionList<E> extractElementsFromIterator(java.util.Iterator<E> it) {
			PositionList<E> l = new NodePositionList<E>();
			while (it.hasNext()) {
				l.addLast(it.next());
			}
			return l;
		}

		static <E, F> boolean unorderedIterableCorrect(TestCall<Iterable<E>, F[]> call,
				TestResult<Iterable<E>, F[]> result, F[] expected) {
			java.util.Iterator<E> it = null;

			try {
				it = result.getValue().iterator();
				if (it == null) {
					printError(ExecutionTime.DURING,
							"the call " + call.toString() + " returned an iterable which returned a null iterator");
					return false;
				} else
					return unorderedIteratorCorrect(() -> call.toString(), it, expected);
			} catch (Throwable exc) {
				printError(ExecutionTime.DURING,
						"the call " + call.toString() + " returned an iterable which when used raised the exception "
								+ exc + "\n" + getStackTrace(exc));
				return false;
			}
		}

		static <E, F> boolean unorderedIteratorCorrect(TestCall<java.util.Iterator<E>, F[]> call,
				TestResult<java.util.Iterator<E>, F[]> result, F[] expected) {
			java.util.Iterator<E> it = result.getValue();
			return unorderedIteratorCorrect(() -> call.toString(), it, expected);
		}

		static <E, F> boolean unorderedIteratorCorrect(Supplier<String> callString, java.util.Iterator<E> it,
				F[] expected) {

			PositionList<E> l = null;

			try {
				l = extractElementsFromIterator(it);
			} catch (Throwable exc) {
				TestUtils.printCallException(exc);
				return false;
			}

			if (l == null)
				return false;

			boolean correct = (expected.length == l.size());

			if (correct) {
				PositionList<F> expectedList = new NodePositionList<F>();
				for (int j = 0; j < expected.length; j++) {
					expectedList.addLast(expected[j]);
				}
				HashSet<Object> s1 = new HashSet<Object>();
				HashSet<Object> s2 = new HashSet<Object>();
				for (Object e : l)
					s1.add(e);
				for (Object f : expectedList)
					s2.add(f);
				if (!s1.equals(s2)) {
					printError(ExecutionTime.DURING,
							"the call " + callString.get() + " returned an iterator which returned the elements "
									+ TestUtils.print(s1) + " which differs from the expected elements "
									+ TestUtils.print(s2));
					return false;
				}
			}

			if (!correct) {
				printError(ExecutionTime.DURING,
						"the call " + callString.get() + " returned an iterable with the elements " + TestUtils.print(l)
								+ " but should have returned the elements " + TestUtils.print(expected));
				return false;
			} else
				return true;
		}

		static <E, F> boolean iterableCorrect(String callString, E[] original, Iterable<E> i) {
			PositionList<E> l = extractElementsFromIterable(callString, i);
			if (l == null)
				return false;

			boolean correct = (original.length == l.size());

			if (correct) {
				Position<E> cursor = l.first();
				for (int j = 0; j < original.length; j++) {
					if (original[j] == null) {
						correct = correct && (cursor.element() == null);
					}
					correct = correct && original[j].equals(cursor.element());
					if (!correct)
						break;
					cursor = l.next(cursor);
				}
			}

			if (!correct) {
				printError(ExecutionTime.DURING, "the call " + callString + " returned an iterable with the elements "
						+ TestUtils.print(l) + " but should have returned the elements " + TestUtils.print(original));
				return false;
			} else
				return true;
		}

		static <E> boolean unchanged(String callString, E[] original, PositionList<E> l) {
			boolean ok_sofar = true;

			if (l.size() != original.length) {
				ok_sofar = false;
			}

			Position<E> lPos = l.first();
			int i = 0;
			while (ok_sofar && lPos != null) {
				E elem = lPos.element();

				if (elem == null)
					ok_sofar = (original[i] == null);
				else
					ok_sofar = elem.equals(original[i]);

				lPos = l.next(lPos);
				++i;
			}

			if (!ok_sofar) {
				printError(ExecutionTime.DURING, "the call " + callString + " has modified the input list "
						+ TestUtils.print(original) + "; it has now the elements " + TestUtils.print(l));
				return ok_sofar;
			}
			return ok_sofar;
		}

		static <E> boolean unchanged(String callString, E[] original, E[] newer) {
			boolean ok_sofar = true;

			if (newer.length != original.length) {
				ok_sofar = false;
			}

			for (int i = 0; i < newer.length; i++) {
				if (newer[i] == null)
					ok_sofar = (original[i] == null);
				else
					ok_sofar = newer[i].equals(original[i]);
			}

			if (!ok_sofar) {
				printError(ExecutionTime.DURING, "the call " + callString + " has modified the input array "
						+ TestUtils.print(original) + "; it has now the elements " + TestUtils.print(newer));
				return ok_sofar;
			}
			return ok_sofar;
		}

		static String printArray(Object[] arr) {
			if (arr == null)
				return "null";
			else {
				StringBuilder arrString = new StringBuilder("[");

				for (int i = 0; i < arr.length; i++) {
					arrString.append(arr[i]);
					if (i < arr.length - 1)
						arrString.append(", ");
				}
				arrString.append("]");
				return arrString.toString();
			}
		}

		static String printArray(int[] arr) {
			if (arr == null)
				return "null";
			else {
				StringBuilder arrString = new StringBuilder("[");

				for (int i = 0; i < arr.length; i++) {
					arrString.append(arr[i]);
					if (i < arr.length - 1)
						arrString.append(", ");
				}
				arrString.append("]");
				return arrString.toString();
			}
		}

		public static <T> PositionList<T> toPositionList(T[] arr) {
			NodePositionList<T> l = new NodePositionList<T>();
			for (int i = 0; i < arr.length; i++)
				l.addLast(arr[i]);
			return l;
		}

		public static <T> IndexedList<T> toIndexedList(T[] arr) {
			ArrayIndexedList<T> l = new ArrayIndexedList<T>();
			for (int i = 0; i < arr.length; i++)
				l.add(0, arr[i]);
			return l;
		}

		public static Object accessAttribute(String fieldName, Object obj) {
			try {
				Field field;
				field = obj.getClass().getDeclaredField(fieldName);
				field.setAccessible(true);
				return field.get(obj);
			} catch (Throwable exc) {
				TestUtils.printCallException(TestUtils.ExecutionTime.LAST,
						"cannot access the field " + fieldName + ": ", exc);
				return null;
			}
		}

		public static void reportPid() {
			try {
				String[] ids = ManagementFactory.getRuntimeMXBean().getName().split("@");
				BufferedWriter bw = new BufferedWriter(new FileWriter("pid"));
				bw.write(ids[0]);
				bw.close();
			} catch (Exception e) {
				System.out.println("Avisa al profesor de fallo sacando el PID");
			}
		}

		@SafeVarargs
		@SuppressWarnings("varargs")
		public static <T> T[] toGenericArray(T... elems) {
			return elems;
		}

		public static boolean ensureAedlibVersion(int major, int minor, int patchlevel) {
			boolean isOk = true;
			int aedlibMajor = 0, aedlibMinor = 0, aedlibPatchlevel = 0;

			try {
				Class<?> aedlibVersion = Class.forName("es.upm.aedlib.Version");
				Method majorMethod = aedlibVersion.getDeclaredMethod("major");
				Method minorMethod = aedlibVersion.getDeclaredMethod("minor");
				Method patchlevelMethod = aedlibVersion.getDeclaredMethod("patchlevel");

				aedlibMajor = (Integer) majorMethod.invoke(null);
				aedlibMinor = (Integer) minorMethod.invoke(null);
				aedlibPatchlevel = (Integer) patchlevelMethod.invoke(null);

				isOk = ((aedlibMajor > major) || ((aedlibMajor == major)
						&& ((aedlibMinor > minor) || ((aedlibMinor == minor) && (aedlibPatchlevel >= patchlevel)))));
			} catch (Throwable exc) {
				System.out.println("*** WARNING: cannot check aedlib version number due to " + exc);
				exc.printStackTrace();
			}

			if (!isOk) {
				String errorMessage = "*** ERROR: aedlib is too old. Minimum version needed is " + major + "." + minor
						+ "." + patchlevel + "; your version is " + aedlibMajor + "." + aedlibMinor + "."
						+ aedlibPatchlevel + ". Please download a new version of aedlib from moodle\n";
				System.out.println(errorMessage);
				throw new RuntimeException(errorMessage);
			} else
				return true;
		}

		@SuppressWarnings("unchecked")
		public static es.upm.aedlib.Entry<es.upm.aedlib.graph.Vertex<Integer>, Integer> es_upm_aedlib_map_Entry_refl_cnstr(
				Object... params) {
			return (es.upm.aedlib.Entry<es.upm.aedlib.graph.Vertex<Integer>, Integer>) reflectionNew(
					"es.upm.aedlib.map.HashEntry", params);
		}

		public static Object reflectionNew(String className, Object... params) {
			try {
				Class<?> cl = Class.forName(className);
				for (java.lang.reflect.Constructor<?> cnstr : cl.getConstructors()) {
					Class<?>[] parameterTypes = cnstr.getParameterTypes();
					if (parameterTypes.length == params.length) {
						boolean equals = true;
						for (int i = 0; i < parameterTypes.length && equals; i++) {
							if (!parameterTypes[i].isInstance(params[i]))
								equals = false;
						}
						if (equals) {
							cnstr.setAccessible(true);
							return cnstr.newInstance(params);
						}
					}
				}
			} catch (ClassNotFoundException exc) {
				System.out.println("*** Warning: could not access class " + className);
				throw new RuntimeException();
			} catch (InstantiationException exc) {
				System.out.println("*** Warning: could not instantiate " + className);
				throw new RuntimeException();
			} catch (IllegalAccessException exc) {
				System.out.println("*** Warning: could not access " + className);
				throw new RuntimeException();
			} catch (InvocationTargetException exc) {
				System.out.println("*** Warning: constructor " + className + " raised an exception");
				throw new RuntimeException();
			}
			throw new RuntimeException();
		}
	}

	interface TestResult<E, F> {
		boolean isException();

		Throwable getException();

		E getValue();

		boolean checkResult(F expected);
	}

	static class Result<E, F> implements TestResult<E, F> {
		private boolean isException;
		private Throwable exception;
		private E value;
		Call<E, F> call;

		public static <E, F> Result<E, F> result(E e, Call<E, F> call) {
			Result<E, F> result = new Result<E, F>();
			result.isException = false;
			result.value = e;
			result.call = call;
			return result;
		}

		public static <E, F> Result<E, F> exception(Throwable exception, Call<E, F> call) {
			Result<E, F> result = new Result<E, F>();
			result.isException = true;
			result.exception = exception;
			result.call = call;
			return result;
		}

		public boolean isException() {
			return isException;
		}

		public Throwable getException() {
			if (!isException()) {
				TestData.message("*** Internal model error: calling getException() without exception");
				throw new RuntimeException();
			}
			return exception;
		}

		public E getValue() {
			if (isException())
				throw new RuntimeException();
			return value;
		}

		Call<E, F> getCall() {
			return call;
		}

		public boolean checkResult(F expected) {
			try {
				return getCall().checkResult(expected);
			} catch (Throwable exc) {
				System.out.println(
						"\n\n\n*** Internal testing error: checkResult(" + expected + ") raised exception " + exc);
				exc.printStackTrace();
				TestData.message(
						"\n\n\n*** Internal testing error: checkResult(" + expected + ") raised exception " + exc);
				TestUtils.printCallException(exc);
				TestData.message("\n");
				throw new RuntimeException();
			}
		}

		public String toString() {
			String callString = getCall().toString();
			if (!callString.equals("")) {
				if (isException())
					return callString + "  =>  " + getException();
				else
					return callString + "  =>  " + TesterCode.printer(getValue());
			} else
				return callString;
		}
	}

	interface Call<E, F> {
		TestResult<E, F> doCall();

		String toString();

		boolean checkResult(F expected);
	}

	static abstract class TestCall<E, F> implements Call<E, F> {
		TestResult<E, F> result;
		boolean hasCalled;
		boolean voidReturn = false;

		public TestResult<E, F> doCall() {
			if (hasCalled())
				throw new RuntimeException();

			hasCalled = true;
			TestData.addCallToTrace(this.toString());

			try {
				E e = call();
				result = Result.result(e, this);
			} catch (Throwable exception) {
				result = Result.exception(exception, this);
			}

			if (result.isException() || !voidReturn)
				TestData.modifyLastCallInTrace(TesterCode.printer(result));
			return result;
		}

		abstract E call() throws Exception;

		boolean hasCalled() {
			return hasCalled;
		}

		boolean noException() {
			if (result.isException()) {
				Throwable throwable = result.getException();
				TestUtils.printCallException(throwable);
				return false;
			}
			return true;
		}

		boolean noException(Supplier<String> msg) {
			if (result.isException()) {
				Throwable throwable = result.getException();
				TestUtils.printCallException(throwable, msg);
				return false;
			}
			return true;
		}

		boolean throwsException(String expectedName) {
			if (!result.isException()) {
				TestUtils.printError(TestUtils.ExecutionTime.LAST,
						"\nthe call to " + this + " should have thrown an exception " + expectedName + " but did not.");
				return false;
			}

			Throwable exception = result.getException();
			if (!expectedName.equals(exception.getClass().getCanonicalName())) {
				TestUtils.printError(TestUtils.ExecutionTime.LAST,
						"\nthe call to " + this + " should have thrown the exception " + expectedName
								+ ", but throwed the exception " + exception + "\n"
								+ TestUtils.getStackTrace(exception));
				return false;
			}

			return true;
		}

		boolean nonNull() {
			if (!noException())
				return false;
			if (result.getValue() == null) {
				TestUtils.printError(TestUtils.ExecutionTime.LAST,
						"\nthe call to " + this + " returned null but it should not have\n");
				return false;
			} else
				return true;
		}

		boolean nonNull(Supplier<String> msg) {
			if (!noException())
				return false;
			if (result.getValue() == null) {
				TestUtils.printError(TestUtils.ExecutionTime.LAST,
						"\nthe call to " + this + " returned null but it should not have\n" + msg.get());
				return false;
			} else
				return true;
		}

		boolean fresh(Object obj) {
			return fresh(result.getValue(), obj);
		}

		boolean fresh(Object obj1, Object obj2) {
			if (obj1 != null && obj1 == obj2) {
				TestUtils.printError(TestUtils.ExecutionTime.LAST,
						"\nthe call to " + this + " returned an object\n  " + TestUtils.print(obj1)
								+ "\nwhich is the same REFERENCE as an argument object; "
								+ "a NEW object should have been returned\n");
				return false;
			} else
				return true;
		}

		boolean unchanged(Object obj1, Object obj2) {
			return report_unchanged(obj1.equals(obj2), obj1, obj2);
		}

		boolean report_unchanged(boolean result, Object obj1, Object obj2) {
			if (!result) {
				TestUtils.printError(TestUtils.ExecutionTime.LAST,
						"\nthe call to " + this + "\nchanged a method parameter into\n  " + TestUtils.print(obj1)
								+ "\nwhich used to be\n  " + TestUtils.print(obj2)
								+ ".\nIt should not have been changed.\n");
			}
			return result;
		}

		boolean unchanged_array(Object[] original, Object[] newer) {
			boolean ok_sofar = true;

			if (newer.length != original.length) {
				ok_sofar = false;
			}

			for (int i = 0; i < newer.length; i++) {
				if (newer[i] == null)
					ok_sofar = (original[i] == null);
				else
					ok_sofar = newer[i].equals(original[i]);
			}

			if (!ok_sofar) {
				TestUtils.printError(TestUtils.ExecutionTime.LAST,
						"the call to " + this + " has modified the input array " + TestUtils.printArray(original)
								+ "; it has now the elements " + TestUtils.printArray(newer));
				return ok_sofar;
			}
			return ok_sofar;
		}

		boolean unchanged_array(int[] original, int[] newer) {
			boolean ok_sofar = true;

			if (newer.length != original.length) {
				ok_sofar = false;
			}

			for (int i = 0; i < newer.length; i++) {
				ok_sofar = newer[i] == original[i];
			}

			if (!ok_sofar) {
				TestUtils.printError(TestUtils.ExecutionTime.LAST,
						"the call to " + this + " has modified the input array " + TestUtils.printArray(original)
								+ "; it has now the elements " + TestUtils.printArray(newer));
				return ok_sofar;
			}
			return ok_sofar;
		}

		boolean setsMatch(Object expected) {
			if (!noException())
				return false;

			if (!(expected instanceof Iterable<?>)) {
				TestData.message("Cannot iterate over expected value " + TestUtils.print(expected));
				throw new RuntimeException();
			}
			Iterable<?> ev = (Iterable<?>) expected;

			E value = result.getValue();
			if (!(value instanceof Iterable<?>)) {
				TestData.message("Cannot iterate over result value " + TestUtils.print(value));
				throw new RuntimeException();
			}
			Iterable<?> iv = (Iterable<?>) value;

			HashSet<Object> ts1 = new HashSet<Object>();
			HashSet<Object> ts2 = new HashSet<Object>();

			for (Object s1 : iv)
				ts1.add(s1);
			for (Object s2 : ev)
				ts2.add(s2);

			if (!ts1.equals(ts2)) {
				TestUtils.printError(TestUtils.ExecutionTime.LAST,
						"\nthe call to " + this + " returned a value\n" + TestUtils.print(value)
								+ "\nwhich does not contain the same elements as the expected answer" + "\n"
								+ expected);
				return false;
			}

			return true;
		}

		// For use in invariant checking code only -- does not report failure
		boolean silentCheckTrueResult() {
			if (result.isException()) {
				TestUtils.printError(TestUtils.ExecutionTime.LAST,
						"\n*** INTERNAL ERROR in tester: an invariant raised an exception\n");
				Throwable throwable = result.getException();
				TestUtils.printCallException(throwable);
				return false;
			}

			E value = result.getValue();

			if (value == null) {
				TestUtils.printError(TestUtils.ExecutionTime.LAST,
						"\n*** INTERNAL ERROR in tester: an invariant returned a null object\n");
				return false;
			}

			return value.equals(true);
		}

		boolean valuesMatch(Object expected) {
			if (result.isException()) {
				noException();
				return false;
			} else {
				E value = result.getValue();

				if (value == null) {
					if (expected != null) {
						TestUtils.printError(TestUtils.ExecutionTime.LAST, "\nthe call to " + this + " returned null, "
								+ "but should have returned " + TestUtils.print(expected));
						return false;
					} else
						return true;
				}

				if (!value.equals(expected)) {
					TestUtils.printError(TestUtils.ExecutionTime.LAST, "\nthe call to " + this + " returned\n  "
							+ TestUtils.print(value) + "\n\nbut should have returned\n  " + TestUtils.print(expected));
					return false;
				}
				return true;
			}
		}

		public boolean checkResult(F expected) {
			if (!hasCalled())
				throw new RuntimeException();

			return valuesMatch(expected);
		}
	}

	static class ConstructDeterministicTree
			extends TestCall<es.upm.aedlib.tree.Tree<String>, es.upm.aedlib.tree.Tree<String>> {
		es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>> x_1;
		es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>> x_1_orig;

		public ConstructDeterministicTree(
				es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>> x_1) {
			this.x_1 = x_1;
			if (x_1 == null)
				x_1_orig = null;
			else
				x_1_orig = new es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.PositionList<String>>(x_1);
		}

		public String toString() {
			StringBuilder output = new StringBuilder();
			output.append(new String("TreeSearch.constructDeterministicTree"));
			output.append(new String("("));
			output.append(TesterCode.printer(x_1_orig));
			output.append(new String(")"));
			return output.toString();
		}

		public es.upm.aedlib.tree.Tree<String> call() {
			return TreeSearch.constructDeterministicTree(x_1);
		}

		public boolean checkResult(es.upm.aedlib.tree.Tree<String> expected) {
			if (!(result.isException() || fresh(result.getValue(), x_1)))
				return false;
			if (!unchanged(x_1, x_1_orig))
				return false;
			if (!TreeSearchUtils.checkConstructDeterministicTree(this, result, expected))
				return false;
			return true;
		}

	}

	static class Search extends
			TestCall<es.upm.aedlib.set.Set<es.upm.aedlib.Position<String>>, es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>>> {
		es.upm.aedlib.tree.Tree<String> tree;
		es.upm.aedlib.positionlist.NodePositionList<String> x_1;
		es.upm.aedlib.positionlist.NodePositionList<String> x_1_orig;

		public Search(es.upm.aedlib.tree.Tree<String> tree, es.upm.aedlib.positionlist.NodePositionList<String> x_1) {
			this.tree = tree;
			this.x_1 = x_1;
			if (x_1 == null)
				x_1_orig = null;
			else
				x_1_orig = new es.upm.aedlib.positionlist.NodePositionList<String>(x_1);
		}

		public String toString() {
			StringBuilder output = new StringBuilder();
			output.append(new String("TreeSearch.search"));
			output.append(new String("("));
			output.append(TesterCode.printer(tree));
			output.append(new String(", "));
			output.append(TesterCode.printer(x_1_orig));
			output.append(new String(")"));
			return output.toString();
		}

		public es.upm.aedlib.set.Set<es.upm.aedlib.Position<String>> call() {
			return TreeSearch.search(tree, x_1);
		}

		public boolean checkResult(
				es.upm.aedlib.set.PositionListSet<es.upm.aedlib.positionlist.NodePositionList<Integer>> expected) {
			if (!(result.isException() || fresh(result.getValue(), x_1)))
				return false;
			if (!unchanged(x_1, x_1_orig))
				return false;
			if (!TreeSearchUtils.checkSearch(this, result, expected))
				return false;
			return true;
		}

	}

	public static class TestData {
		static String testName = "";
		static ArrayList<String> trace;
		static ArrayList<String> messages;
		static boolean isJunitTester;

		public static void initTrace() {
			trace = new ArrayList<String>();
			messages = new ArrayList<String>();
		}

		public static void setTesterType(boolean junitTesting) {
			isJunitTester = junitTesting;
		}

		public static boolean isJunitTester() {
			return isJunitTester;
		}

		public static void addCallToTrace(String callString) {
			if (!callString.equals(""))
				trace.add("  " + callString);
			else
				trace.add(callString);
		}

		public static void modifyLastCallInTrace(String callString) {
			if (trace.size() > 0) {
				trace.remove(trace.size() - 1);
				if (!callString.equals(""))
					trace.add("  " + callString);
				else
					trace.add(callString);
			}
		}

		public static void message(String message) {
			messages.add(message);
		}

		public static int numCommands() {
			return trace.size();
		}

		private static String arrayToString(ArrayList<String> arr) {
			StringBuffer sb = new StringBuffer();

			for (int i = 0; i < arr.size(); i++) {
				String item = arr.get(i);
				if (!item.equals("")) {
					sb.append(item + "\n");
				}
			}
			return sb.toString();
		}

		public static String getTrace() {
			return arrayToString(trace);
		}

		public static String getMessages() {
			return arrayToString(messages);
		}

		public static String getTestName() {
			return testName;
		}

		public static ArrayList<String> getRawTrace() {
			return trace;
		}

		public static void setTrace(ArrayList<String> setTrace) {
			trace = setTrace;
		}

		public static void setTestName(String setTestName) {
			testName = setTestName;
		}

		public static void setContext(String setTestName, ArrayList<String> setTrace) {
			setTestName(setTestName);
			setTrace(setTrace);
		}
	}

	static class ResultsHandler {
		public static volatile CountDownLatch waitForThreads = null;
		static LinkedHashMap<String, Boolean> results_sofar;
		static HashSet<String> runningTests;
		static int numTestsRemaining = 1000;
		static long endTime = 0;

		static void init() {
			results_sofar = new LinkedHashMap<String, Boolean>();
			runningTests = new HashSet<String>();
		}

		static void setNumTestsRemaining(int numTestsToRun, int GlobalTimeoutInSeconds) {
			numTestsRemaining = numTestsToRun;
			endTime = System.currentTimeMillis() + GlobalTimeoutInSeconds * 1000;
		}

		static boolean isTimedout() {
			return System.currentTimeMillis() > endTime;
		}

		static void startTest(String testName) {
			runningTests.add(testName);
		}

		static void stopTest(String testName) {
			runningTests.remove(testName);
			--numTestsRemaining;
		}

		static boolean results_ok_sofar() {
			for (String key : results_sofar.keySet())
				if (!results_sofar.get(key))
					return false;
			return true;
		}

		static boolean local_results_ok_sofar(String test_type) {
			Boolean result = results_sofar.get(test_type);
			return (result == null) || result;
		}

		static void add_result(String test_type, boolean result) {
			Boolean old_result = results_sofar.get(test_type);
			if ((old_result == null) || old_result)
				results_sofar.put(test_type, result);
		}

		static boolean results_ok() {
			if (results_sofar.size() == 0) {
				System.out.println("\n*** Error: no tests were run");
				return false;
			}

			if (runningTests.size() > 0) {
				System.out.println("\n*** Error: some tests (" + runningTests.size() + ") are still running\n");
				return false;
			}

			for (String key : results_sofar.keySet())
				if (!results_sofar.get(key))
					return false;

			if (numTestsRemaining > 0) {
				System.out.println("\n*** Error: some tests (" + numTestsRemaining + ") did not run\n");
				return false;
			}

			return true;
		}

		static int get_nota() {
			if (results_ok())
				return 10;
			else
				return 0;
		}

		static void report_results() {
			System.out.println("\n\n++++++++++++++++++++++++++++++++++++++++++\n");

			for (String testName : results_sofar.keySet()) {
				System.out.print("Testing results for " + testName + ": ");
				if (results_sofar.get(testName))
					System.out.println("succeeded");
				else
					System.out.println("failed");
			}

			System.out.println("\n------------------------------------------");
			if (results_ok())
				System.out.println("\n" + Tests.tester + ": Test finalizado correctamente.\n");
			else
				System.out.println("\n" + Tests.tester + ": errores detectados.\n\n");
		}
	}

	static class TesterCode {

		public static void resetPrinter() {
			TreeSearchUtils.resetPrinter();
		}

		public static String printer(Object obj) {
			return TreeSearchUtils.printer(obj);
		}

	}

}
