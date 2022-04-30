
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
// File generated at: 2020/12/1 -- 16:40:50
// Seed: {1606,837248,579485}
//
//////////////////////////////////////////////////////////////////////

package individual6;

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
public class TesterInd6 {

	@BeforeAll
	public static void init() {
		TestUtils.reportPid();
		ResultsHandler.init();
		ResultsHandler.setNumTestsRemaining(31, 60);
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
		ResultsHandler.add_result(new String("sumVertices"), resultIs);
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
					DirectedAdjacencyListGraph<Integer, Integer> graph = new DirectedAdjacencyListGraph<Integer, Integer>();
					Vertex<Integer> v_0 = graph.insertVertex(1);
					ok_sofar = new SumVertices(graph).doCall().checkResult(
							new es.upm.aedlib.positionlist.NodePositionList<es.upm.aedlib.Entry<Vertex<Integer>, Integer>>(
									TestUtils.toGenericArray(TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_0, 1))));
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
		ResultsHandler.add_result(new String("sumVertices"), resultIs);
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
					DirectedAdjacencyListGraph<Integer, Integer> graph = new DirectedAdjacencyListGraph<Integer, Integer>();
					Vertex<Integer> v_0 = graph.insertVertex(2);
					ok_sofar = new SumVertices(graph).doCall().checkResult(
							new es.upm.aedlib.positionlist.NodePositionList<es.upm.aedlib.Entry<Vertex<Integer>, Integer>>(
									TestUtils.toGenericArray(TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_0, 2))));
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
		ResultsHandler.add_result(new String("sumVertices"), resultIs);
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
					DirectedAdjacencyListGraph<Integer, Integer> graph = new DirectedAdjacencyListGraph<Integer, Integer>();
					Vertex<Integer> v_0 = graph.insertVertex(3);
					ok_sofar = new SumVertices(graph).doCall().checkResult(
							new es.upm.aedlib.positionlist.NodePositionList<es.upm.aedlib.Entry<Vertex<Integer>, Integer>>(
									TestUtils.toGenericArray(TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_0, 3))));
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
		ResultsHandler.add_result(new String("sumVertices"), resultIs);
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
					DirectedAdjacencyListGraph<Integer, Integer> graph = new DirectedAdjacencyListGraph<Integer, Integer>();
					Vertex<Integer> v_0 = graph.insertVertex(6);
					ok_sofar = new SumVertices(graph).doCall().checkResult(
							new es.upm.aedlib.positionlist.NodePositionList<es.upm.aedlib.Entry<Vertex<Integer>, Integer>>(
									TestUtils.toGenericArray(TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_0, 6))));
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
		ResultsHandler.add_result(new String("sumVertices"), resultIs);
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
					DirectedAdjacencyListGraph<Integer, Integer> graph = new DirectedAdjacencyListGraph<Integer, Integer>();
					Vertex<Integer> v_0 = graph.insertVertex(1);
					Vertex<Integer> v_1 = graph.insertVertex(2);
					Vertex<Integer> v_2 = graph.insertVertex(1);
					graph.insertDirectedEdge(v_2, v_0, null);
					graph.insertDirectedEdge(v_1, v_0, null);
					graph.insertDirectedEdge(v_0, v_0, null);
					ok_sofar = new SumVertices(graph).doCall().checkResult(
							new es.upm.aedlib.positionlist.NodePositionList<es.upm.aedlib.Entry<Vertex<Integer>, Integer>>(
									TestUtils.toGenericArray(TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_0, 1),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_1, 3),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_2, 2))));
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
		ResultsHandler.add_result(new String("sumVertices"), resultIs);
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
					DirectedAdjacencyListGraph<Integer, Integer> graph = new DirectedAdjacencyListGraph<Integer, Integer>();
					Vertex<Integer> v_0 = graph.insertVertex(2);
					Vertex<Integer> v_1 = graph.insertVertex(2);
					Vertex<Integer> v_2 = graph.insertVertex(1);
					Vertex<Integer> v_3 = graph.insertVertex(4);
					graph.insertDirectedEdge(v_3, v_0, null);
					graph.insertDirectedEdge(v_3, v_2, null);
					graph.insertDirectedEdge(v_2, v_2, null);
					graph.insertDirectedEdge(v_1, v_2, null);
					graph.insertDirectedEdge(v_0, v_0, null);
					ok_sofar = new SumVertices(graph).doCall().checkResult(
							new es.upm.aedlib.positionlist.NodePositionList<es.upm.aedlib.Entry<Vertex<Integer>, Integer>>(
									TestUtils.toGenericArray(TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_0, 2),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_1, 3),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_2, 1),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_3, 7))));
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
		ResultsHandler.add_result(new String("sumVertices"), resultIs);
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
					DirectedAdjacencyListGraph<Integer, Integer> graph = new DirectedAdjacencyListGraph<Integer, Integer>();
					Vertex<Integer> v_0 = graph.insertVertex(2);
					Vertex<Integer> v_1 = graph.insertVertex(4);
					Vertex<Integer> v_2 = graph.insertVertex(2);
					Vertex<Integer> v_3 = graph.insertVertex(2);
					Vertex<Integer> v_4 = graph.insertVertex(3);
					graph.insertDirectedEdge(v_4, v_1, null);
					graph.insertDirectedEdge(v_4, v_2, null);
					graph.insertDirectedEdge(v_3, v_0, null);
					graph.insertDirectedEdge(v_2, v_1, null);
					graph.insertDirectedEdge(v_2, v_2, null);
					graph.insertDirectedEdge(v_1, v_3, null);
					graph.insertDirectedEdge(v_0, v_2, null);
					ok_sofar = new SumVertices(graph).doCall().checkResult(
							new es.upm.aedlib.positionlist.NodePositionList<es.upm.aedlib.Entry<Vertex<Integer>, Integer>>(
									TestUtils.toGenericArray(TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_0, 10),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_1, 10),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_2, 10),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_3, 10),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_4, 13))));
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
		ResultsHandler.add_result(new String("sumVertices"), resultIs);
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
					DirectedAdjacencyListGraph<Integer, Integer> graph = new DirectedAdjacencyListGraph<Integer, Integer>();
					Vertex<Integer> v_0 = graph.insertVertex(2);
					Vertex<Integer> v_1 = graph.insertVertex(2);
					Vertex<Integer> v_2 = graph.insertVertex(3);
					Vertex<Integer> v_3 = graph.insertVertex(3);
					Vertex<Integer> v_4 = graph.insertVertex(1);
					graph.insertDirectedEdge(v_4, v_2, null);
					graph.insertDirectedEdge(v_3, v_4, null);
					graph.insertDirectedEdge(v_2, v_1, null);
					graph.insertDirectedEdge(v_2, v_2, null);
					graph.insertDirectedEdge(v_1, v_0, null);
					graph.insertDirectedEdge(v_1, v_1, null);
					graph.insertDirectedEdge(v_0, v_0, null);
					graph.insertDirectedEdge(v_0, v_1, null);
					ok_sofar = new SumVertices(graph).doCall().checkResult(
							new es.upm.aedlib.positionlist.NodePositionList<es.upm.aedlib.Entry<Vertex<Integer>, Integer>>(
									TestUtils.toGenericArray(TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_0, 4),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_1, 4),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_2, 7),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_3, 11),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_4, 8))));
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
		ResultsHandler.add_result(new String("sumVertices"), resultIs);
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
					DirectedAdjacencyListGraph<Integer, Integer> graph = new DirectedAdjacencyListGraph<Integer, Integer>();
					Vertex<Integer> v_0 = graph.insertVertex(3);
					Vertex<Integer> v_1 = graph.insertVertex(2);
					Vertex<Integer> v_2 = graph.insertVertex(3);
					Vertex<Integer> v_3 = graph.insertVertex(2);
					Vertex<Integer> v_4 = graph.insertVertex(1);
					Vertex<Integer> v_5 = graph.insertVertex(1);
					graph.insertDirectedEdge(v_5, v_1, null);
					graph.insertDirectedEdge(v_4, v_4, null);
					graph.insertDirectedEdge(v_4, v_5, null);
					graph.insertDirectedEdge(v_3, v_1, null);
					graph.insertDirectedEdge(v_2, v_2, null);
					graph.insertDirectedEdge(v_1, v_2, null);
					graph.insertDirectedEdge(v_0, v_2, null);
					ok_sofar = new SumVertices(graph).doCall().checkResult(
							new es.upm.aedlib.positionlist.NodePositionList<es.upm.aedlib.Entry<Vertex<Integer>, Integer>>(
									TestUtils.toGenericArray(TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_0, 6),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_1, 5),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_2, 3),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_3, 7),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_4, 7),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_5, 6))));
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
		ResultsHandler.add_result(new String("sumVertices"), resultIs);
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
					DirectedAdjacencyListGraph<Integer, Integer> graph = new DirectedAdjacencyListGraph<Integer, Integer>();
					Vertex<Integer> v_0 = graph.insertVertex(2);
					Vertex<Integer> v_1 = graph.insertVertex(7);
					Vertex<Integer> v_2 = graph.insertVertex(9);
					Vertex<Integer> v_3 = graph.insertVertex(2);
					Vertex<Integer> v_4 = graph.insertVertex(6);
					Vertex<Integer> v_5 = graph.insertVertex(6);
					graph.insertDirectedEdge(v_5, v_1, null);
					graph.insertDirectedEdge(v_4, v_1, null);
					graph.insertDirectedEdge(v_3, v_2, null);
					graph.insertDirectedEdge(v_2, v_0, null);
					graph.insertDirectedEdge(v_2, v_3, null);
					graph.insertDirectedEdge(v_1, v_0, null);
					graph.insertDirectedEdge(v_1, v_1, null);
					graph.insertDirectedEdge(v_0, v_3, null);
					ok_sofar = new SumVertices(graph).doCall().checkResult(
							new es.upm.aedlib.positionlist.NodePositionList<es.upm.aedlib.Entry<Vertex<Integer>, Integer>>(
									TestUtils.toGenericArray(TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_0, 13),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_1, 20),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_2, 13),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_3, 13),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_4, 26),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_5, 26))));
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
		ResultsHandler.add_result(new String("sumVertices"), resultIs);
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
					DirectedAdjacencyListGraph<Integer, Integer> graph = new DirectedAdjacencyListGraph<Integer, Integer>();
					Vertex<Integer> v_0 = graph.insertVertex(7);
					Vertex<Integer> v_1 = graph.insertVertex(3);
					Vertex<Integer> v_2 = graph.insertVertex(7);
					Vertex<Integer> v_3 = graph.insertVertex(1);
					Vertex<Integer> v_4 = graph.insertVertex(9);
					Vertex<Integer> v_5 = graph.insertVertex(9);
					graph.insertDirectedEdge(v_5, v_0, null);
					graph.insertDirectedEdge(v_5, v_4, null);
					graph.insertDirectedEdge(v_5, v_5, null);
					graph.insertDirectedEdge(v_4, v_1, null);
					graph.insertDirectedEdge(v_3, v_3, null);
					graph.insertDirectedEdge(v_2, v_1, null);
					graph.insertDirectedEdge(v_1, v_1, null);
					graph.insertDirectedEdge(v_1, v_1, null);
					graph.insertDirectedEdge(v_1, v_4, null);
					graph.insertDirectedEdge(v_0, v_0, null);
					graph.insertDirectedEdge(v_0, v_5, null);
					ok_sofar = new SumVertices(graph).doCall().checkResult(
							new es.upm.aedlib.positionlist.NodePositionList<es.upm.aedlib.Entry<Vertex<Integer>, Integer>>(
									TestUtils.toGenericArray(TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_0, 28),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_1, 12),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_2, 19),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_3, 1),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_4, 12),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_5, 28))));
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
		ResultsHandler.add_result(new String("sumVertices"), resultIs);
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
					DirectedAdjacencyListGraph<Integer, Integer> graph = new DirectedAdjacencyListGraph<Integer, Integer>();
					Vertex<Integer> v_0 = graph.insertVertex(1);
					Vertex<Integer> v_1 = graph.insertVertex(1);
					Vertex<Integer> v_2 = graph.insertVertex(2);
					Vertex<Integer> v_3 = graph.insertVertex(3);
					Vertex<Integer> v_4 = graph.insertVertex(2);
					Vertex<Integer> v_5 = graph.insertVertex(1);
					Vertex<Integer> v_6 = graph.insertVertex(1);
					graph.insertDirectedEdge(v_6, v_4, null);
					graph.insertDirectedEdge(v_5, v_2, null);
					graph.insertDirectedEdge(v_4, v_4, null);
					graph.insertDirectedEdge(v_3, v_1, null);
					graph.insertDirectedEdge(v_2, v_4, null);
					graph.insertDirectedEdge(v_2, v_6, null);
					graph.insertDirectedEdge(v_1, v_3, null);
					graph.insertDirectedEdge(v_0, v_3, null);
					graph.insertDirectedEdge(v_0, v_5, null);
					graph.insertDirectedEdge(v_0, v_6, null);
					ok_sofar = new SumVertices(graph).doCall().checkResult(
							new es.upm.aedlib.positionlist.NodePositionList<es.upm.aedlib.Entry<Vertex<Integer>, Integer>>(
									TestUtils.toGenericArray(TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_0, 11),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_1, 4),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_2, 5),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_3, 4),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_4, 2),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_5, 6),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_6, 3))));
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
		ResultsHandler.add_result(new String("sumVertices"), resultIs);
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
					DirectedAdjacencyListGraph<Integer, Integer> graph = new DirectedAdjacencyListGraph<Integer, Integer>();
					Vertex<Integer> v_0 = graph.insertVertex(2);
					Vertex<Integer> v_1 = graph.insertVertex(2);
					Vertex<Integer> v_2 = graph.insertVertex(1);
					Vertex<Integer> v_3 = graph.insertVertex(1);
					Vertex<Integer> v_4 = graph.insertVertex(1);
					Vertex<Integer> v_5 = graph.insertVertex(1);
					Vertex<Integer> v_6 = graph.insertVertex(1);
					Vertex<Integer> v_7 = graph.insertVertex(1);
					Vertex<Integer> v_8 = graph.insertVertex(1);
					graph.insertDirectedEdge(v_8, v_4, null);
					graph.insertDirectedEdge(v_8, v_5, null);
					graph.insertDirectedEdge(v_7, v_0, null);
					graph.insertDirectedEdge(v_7, v_1, null);
					graph.insertDirectedEdge(v_6, v_0, null);
					graph.insertDirectedEdge(v_6, v_3, null);
					graph.insertDirectedEdge(v_5, v_6, null);
					graph.insertDirectedEdge(v_4, v_3, null);
					graph.insertDirectedEdge(v_4, v_6, null);
					graph.insertDirectedEdge(v_3, v_6, null);
					graph.insertDirectedEdge(v_2, v_0, null);
					graph.insertDirectedEdge(v_2, v_2, null);
					graph.insertDirectedEdge(v_2, v_7, null);
					graph.insertDirectedEdge(v_1, v_4, null);
					graph.insertDirectedEdge(v_1, v_7, null);
					graph.insertDirectedEdge(v_0, v_0, null);
					graph.insertDirectedEdge(v_0, v_2, null);
					ok_sofar = new SumVertices(graph).doCall().checkResult(
							new es.upm.aedlib.positionlist.NodePositionList<es.upm.aedlib.Entry<Vertex<Integer>, Integer>>(
									TestUtils.toGenericArray(TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_0, 9),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_1, 9),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_2, 9),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_3, 9),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_4, 9),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_5, 10),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_6, 9),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_7, 9),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_8, 11))));
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
		ResultsHandler.add_result(new String("sumVertices"), resultIs);
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
					DirectedAdjacencyListGraph<Integer, Integer> graph = new DirectedAdjacencyListGraph<Integer, Integer>();
					Vertex<Integer> v_0 = graph.insertVertex(1);
					Vertex<Integer> v_1 = graph.insertVertex(4);
					Vertex<Integer> v_2 = graph.insertVertex(5);
					Vertex<Integer> v_3 = graph.insertVertex(1);
					Vertex<Integer> v_4 = graph.insertVertex(4);
					Vertex<Integer> v_5 = graph.insertVertex(4);
					Vertex<Integer> v_6 = graph.insertVertex(2);
					Vertex<Integer> v_7 = graph.insertVertex(1);
					Vertex<Integer> v_8 = graph.insertVertex(4);
					Vertex<Integer> v_9 = graph.insertVertex(1);
					graph.insertDirectedEdge(v_9, v_3, null);
					graph.insertDirectedEdge(v_9, v_7, null);
					graph.insertDirectedEdge(v_9, v_9, null);
					graph.insertDirectedEdge(v_8, v_4, null);
					graph.insertDirectedEdge(v_8, v_5, null);
					graph.insertDirectedEdge(v_7, v_2, null);
					graph.insertDirectedEdge(v_7, v_7, null);
					graph.insertDirectedEdge(v_6, v_1, null);
					graph.insertDirectedEdge(v_6, v_3, null);
					graph.insertDirectedEdge(v_5, v_2, null);
					graph.insertDirectedEdge(v_5, v_7, null);
					graph.insertDirectedEdge(v_5, v_8, null);
					graph.insertDirectedEdge(v_4, v_4, null);
					graph.insertDirectedEdge(v_4, v_9, null);
					graph.insertDirectedEdge(v_4, v_9, null);
					graph.insertDirectedEdge(v_3, v_8, null);
					graph.insertDirectedEdge(v_3, v_9, null);
					graph.insertDirectedEdge(v_2, v_6, null);
					graph.insertDirectedEdge(v_2, v_7, null);
					graph.insertDirectedEdge(v_1, v_3, null);
					graph.insertDirectedEdge(v_0, v_0, null);
					ok_sofar = new SumVertices(graph).doCall().checkResult(
							new es.upm.aedlib.positionlist.NodePositionList<es.upm.aedlib.Entry<Vertex<Integer>, Integer>>(
									TestUtils.toGenericArray(TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_0, 1),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_1, 26),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_2, 26),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_3, 26),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_4, 26),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_5, 26),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_6, 26),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_7, 26),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_8, 26),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_9, 26))));
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
		ResultsHandler.add_result(new String("sumVertices"), resultIs);
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
					DirectedAdjacencyListGraph<Integer, Integer> graph = new DirectedAdjacencyListGraph<Integer, Integer>();
					Vertex<Integer> v_0 = graph.insertVertex(2);
					Vertex<Integer> v_1 = graph.insertVertex(3);
					Vertex<Integer> v_2 = graph.insertVertex(1);
					Vertex<Integer> v_3 = graph.insertVertex(2);
					Vertex<Integer> v_4 = graph.insertVertex(3);
					Vertex<Integer> v_5 = graph.insertVertex(1);
					Vertex<Integer> v_6 = graph.insertVertex(2);
					Vertex<Integer> v_7 = graph.insertVertex(1);
					Vertex<Integer> v_8 = graph.insertVertex(1);
					Vertex<Integer> v_9 = graph.insertVertex(2);
					Vertex<Integer> v_10 = graph.insertVertex(2);
					graph.insertDirectedEdge(v_10, v_9, null);
					graph.insertDirectedEdge(v_9, v_10, null);
					graph.insertDirectedEdge(v_8, v_0, null);
					graph.insertDirectedEdge(v_7, v_8, null);
					graph.insertDirectedEdge(v_6, v_5, null);
					graph.insertDirectedEdge(v_6, v_9, null);
					graph.insertDirectedEdge(v_5, v_0, null);
					graph.insertDirectedEdge(v_5, v_5, null);
					graph.insertDirectedEdge(v_5, v_8, null);
					graph.insertDirectedEdge(v_4, v_2, null);
					graph.insertDirectedEdge(v_4, v_3, null);
					graph.insertDirectedEdge(v_3, v_7, null);
					graph.insertDirectedEdge(v_2, v_0, null);
					graph.insertDirectedEdge(v_1, v_1, null);
					graph.insertDirectedEdge(v_1, v_4, null);
					graph.insertDirectedEdge(v_0, v_1, null);
					graph.insertDirectedEdge(v_0, v_10, null);
					ok_sofar = new SumVertices(graph).doCall().checkResult(
							new es.upm.aedlib.positionlist.NodePositionList<es.upm.aedlib.Entry<Vertex<Integer>, Integer>>(
									TestUtils.toGenericArray(TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_0, 17),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_1, 17),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_2, 17),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_3, 17),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_4, 17),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_5, 18),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_6, 20),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_7, 17),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_8, 17),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_9, 4),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_10, 4))));
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
		ResultsHandler.add_result(new String("sumVertices"), resultIs);
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
					DirectedAdjacencyListGraph<Integer, Integer> graph = new DirectedAdjacencyListGraph<Integer, Integer>();
					Vertex<Integer> v_0 = graph.insertVertex(1);
					Vertex<Integer> v_1 = graph.insertVertex(2);
					Vertex<Integer> v_2 = graph.insertVertex(5);
					Vertex<Integer> v_3 = graph.insertVertex(3);
					Vertex<Integer> v_4 = graph.insertVertex(4);
					Vertex<Integer> v_5 = graph.insertVertex(2);
					Vertex<Integer> v_6 = graph.insertVertex(1);
					Vertex<Integer> v_7 = graph.insertVertex(5);
					Vertex<Integer> v_8 = graph.insertVertex(4);
					Vertex<Integer> v_9 = graph.insertVertex(3);
					Vertex<Integer> v_10 = graph.insertVertex(1);
					graph.insertDirectedEdge(v_10, v_0, null);
					graph.insertDirectedEdge(v_10, v_8, null);
					graph.insertDirectedEdge(v_9, v_7, null);
					graph.insertDirectedEdge(v_8, v_1, null);
					graph.insertDirectedEdge(v_8, v_3, null);
					graph.insertDirectedEdge(v_7, v_1, null);
					graph.insertDirectedEdge(v_7, v_10, null);
					graph.insertDirectedEdge(v_6, v_1, null);
					graph.insertDirectedEdge(v_6, v_2, null);
					graph.insertDirectedEdge(v_6, v_9, null);
					graph.insertDirectedEdge(v_5, v_4, null);
					graph.insertDirectedEdge(v_5, v_5, null);
					graph.insertDirectedEdge(v_4, v_1, null);
					graph.insertDirectedEdge(v_3, v_2, null);
					graph.insertDirectedEdge(v_2, v_3, null);
					graph.insertDirectedEdge(v_1, v_0, null);
					graph.insertDirectedEdge(v_1, v_3, null);
					graph.insertDirectedEdge(v_1, v_6, null);
					graph.insertDirectedEdge(v_0, v_6, null);
					ok_sofar = new SumVertices(graph).doCall().checkResult(
							new es.upm.aedlib.positionlist.NodePositionList<es.upm.aedlib.Entry<Vertex<Integer>, Integer>>(
									TestUtils.toGenericArray(TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_0, 25),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_1, 25),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_2, 8),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_3, 8),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_4, 29),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_5, 31),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_6, 25),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_7, 25),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_8, 25),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_9, 25),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_10, 25))));
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
		ResultsHandler.add_result(new String("sumVertices"), resultIs);
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
					DirectedAdjacencyListGraph<Integer, Integer> graph = new DirectedAdjacencyListGraph<Integer, Integer>();
					Vertex<Integer> v_0 = graph.insertVertex(3);
					Vertex<Integer> v_1 = graph.insertVertex(3);
					Vertex<Integer> v_2 = graph.insertVertex(3);
					Vertex<Integer> v_3 = graph.insertVertex(3);
					Vertex<Integer> v_4 = graph.insertVertex(3);
					Vertex<Integer> v_5 = graph.insertVertex(1);
					Vertex<Integer> v_6 = graph.insertVertex(5);
					Vertex<Integer> v_7 = graph.insertVertex(4);
					Vertex<Integer> v_8 = graph.insertVertex(2);
					Vertex<Integer> v_9 = graph.insertVertex(2);
					Vertex<Integer> v_10 = graph.insertVertex(2);
					graph.insertDirectedEdge(v_10, v_9, null);
					graph.insertDirectedEdge(v_10, v_9, null);
					graph.insertDirectedEdge(v_9, v_10, null);
					graph.insertDirectedEdge(v_9, v_10, null);
					graph.insertDirectedEdge(v_8, v_2, null);
					graph.insertDirectedEdge(v_7, v_3, null);
					graph.insertDirectedEdge(v_7, v_6, null);
					graph.insertDirectedEdge(v_6, v_0, null);
					graph.insertDirectedEdge(v_6, v_3, null);
					graph.insertDirectedEdge(v_6, v_3, null);
					graph.insertDirectedEdge(v_6, v_10, null);
					graph.insertDirectedEdge(v_5, v_0, null);
					graph.insertDirectedEdge(v_4, v_6, null);
					graph.insertDirectedEdge(v_4, v_7, null);
					graph.insertDirectedEdge(v_3, v_1, null);
					graph.insertDirectedEdge(v_3, v_10, null);
					graph.insertDirectedEdge(v_2, v_5, null);
					graph.insertDirectedEdge(v_2, v_10, null);
					graph.insertDirectedEdge(v_1, v_3, null);
					graph.insertDirectedEdge(v_1, v_7, null);
					graph.insertDirectedEdge(v_0, v_2, null);
					graph.insertDirectedEdge(v_0, v_8, null);
					ok_sofar = new SumVertices(graph).doCall().checkResult(
							new es.upm.aedlib.positionlist.NodePositionList<es.upm.aedlib.Entry<Vertex<Integer>, Integer>>(
									TestUtils.toGenericArray(TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_0, 13),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_1, 28),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_2, 13),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_3, 28),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_4, 31),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_5, 13),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_6, 28),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_7, 28),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_8, 13),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_9, 4),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_10, 4))));
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
		ResultsHandler.add_result(new String("sumVertices"), resultIs);
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
					DirectedAdjacencyListGraph<Integer, Integer> graph = new DirectedAdjacencyListGraph<Integer, Integer>();
					Vertex<Integer> v_0 = graph.insertVertex(5);
					Vertex<Integer> v_1 = graph.insertVertex(3);
					Vertex<Integer> v_2 = graph.insertVertex(6);
					Vertex<Integer> v_3 = graph.insertVertex(5);
					Vertex<Integer> v_4 = graph.insertVertex(7);
					Vertex<Integer> v_5 = graph.insertVertex(4);
					Vertex<Integer> v_6 = graph.insertVertex(2);
					Vertex<Integer> v_7 = graph.insertVertex(1);
					Vertex<Integer> v_8 = graph.insertVertex(1);
					Vertex<Integer> v_9 = graph.insertVertex(2);
					Vertex<Integer> v_10 = graph.insertVertex(6);
					graph.insertDirectedEdge(v_10, v_4, null);
					graph.insertDirectedEdge(v_10, v_5, null);
					graph.insertDirectedEdge(v_10, v_8, null);
					graph.insertDirectedEdge(v_9, v_0, null);
					graph.insertDirectedEdge(v_9, v_4, null);
					graph.insertDirectedEdge(v_9, v_5, null);
					graph.insertDirectedEdge(v_8, v_6, null);
					graph.insertDirectedEdge(v_7, v_2, null);
					graph.insertDirectedEdge(v_7, v_3, null);
					graph.insertDirectedEdge(v_6, v_4, null);
					graph.insertDirectedEdge(v_6, v_5, null);
					graph.insertDirectedEdge(v_5, v_2, null);
					graph.insertDirectedEdge(v_5, v_7, null);
					graph.insertDirectedEdge(v_4, v_4, null);
					graph.insertDirectedEdge(v_4, v_6, null);
					graph.insertDirectedEdge(v_3, v_1, null);
					graph.insertDirectedEdge(v_3, v_8, null);
					graph.insertDirectedEdge(v_2, v_4, null);
					graph.insertDirectedEdge(v_2, v_7, null);
					graph.insertDirectedEdge(v_1, v_0, null);
					graph.insertDirectedEdge(v_1, v_5, null);
					graph.insertDirectedEdge(v_1, v_8, null);
					graph.insertDirectedEdge(v_0, v_10, null);
					ok_sofar = new SumVertices(graph).doCall().checkResult(
							new es.upm.aedlib.positionlist.NodePositionList<es.upm.aedlib.Entry<Vertex<Integer>, Integer>>(
									TestUtils.toGenericArray(TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_0, 40),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_1, 40),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_2, 40),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_3, 40),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_4, 40),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_5, 40),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_6, 40),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_7, 40),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_8, 40),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_9, 42),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_10, 40))));
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
		ResultsHandler.add_result(new String("sumVertices"), resultIs);
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
					DirectedAdjacencyListGraph<Integer, Integer> graph = new DirectedAdjacencyListGraph<Integer, Integer>();
					Vertex<Integer> v_0 = graph.insertVertex(4);
					Vertex<Integer> v_1 = graph.insertVertex(2);
					Vertex<Integer> v_2 = graph.insertVertex(1);
					Vertex<Integer> v_3 = graph.insertVertex(4);
					Vertex<Integer> v_4 = graph.insertVertex(3);
					Vertex<Integer> v_5 = graph.insertVertex(2);
					Vertex<Integer> v_6 = graph.insertVertex(4);
					Vertex<Integer> v_7 = graph.insertVertex(2);
					Vertex<Integer> v_8 = graph.insertVertex(2);
					Vertex<Integer> v_9 = graph.insertVertex(6);
					Vertex<Integer> v_10 = graph.insertVertex(3);
					graph.insertDirectedEdge(v_10, v_3, null);
					graph.insertDirectedEdge(v_10, v_4, null);
					graph.insertDirectedEdge(v_9, v_0, null);
					graph.insertDirectedEdge(v_9, v_4, null);
					graph.insertDirectedEdge(v_8, v_5, null);
					graph.insertDirectedEdge(v_8, v_9, null);
					graph.insertDirectedEdge(v_7, v_6, null);
					graph.insertDirectedEdge(v_6, v_2, null);
					graph.insertDirectedEdge(v_6, v_4, null);
					graph.insertDirectedEdge(v_6, v_7, null);
					graph.insertDirectedEdge(v_5, v_5, null);
					graph.insertDirectedEdge(v_5, v_6, null);
					graph.insertDirectedEdge(v_5, v_9, null);
					graph.insertDirectedEdge(v_5, v_9, null);
					graph.insertDirectedEdge(v_4, v_7, null);
					graph.insertDirectedEdge(v_4, v_9, null);
					graph.insertDirectedEdge(v_4, v_10, null);
					graph.insertDirectedEdge(v_3, v_4, null);
					graph.insertDirectedEdge(v_2, v_0, null);
					graph.insertDirectedEdge(v_2, v_3, null);
					graph.insertDirectedEdge(v_2, v_3, null);
					graph.insertDirectedEdge(v_2, v_7, null);
					graph.insertDirectedEdge(v_1, v_0, null);
					graph.insertDirectedEdge(v_0, v_5, null);
					ok_sofar = new SumVertices(graph).doCall().checkResult(
							new es.upm.aedlib.positionlist.NodePositionList<es.upm.aedlib.Entry<Vertex<Integer>, Integer>>(
									TestUtils.toGenericArray(TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_0, 29),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_1, 31),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_2, 29),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_3, 29),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_4, 29),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_5, 29),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_6, 29),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_7, 29),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_8, 31),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_9, 29),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_10, 29))));
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
		ResultsHandler.add_result(new String("sumVertices"), resultIs);
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
					DirectedAdjacencyListGraph<Integer, Integer> graph = new DirectedAdjacencyListGraph<Integer, Integer>();
					Vertex<Integer> v_0 = graph.insertVertex(3);
					Vertex<Integer> v_1 = graph.insertVertex(1);
					Vertex<Integer> v_2 = graph.insertVertex(2);
					Vertex<Integer> v_3 = graph.insertVertex(1);
					Vertex<Integer> v_4 = graph.insertVertex(4);
					Vertex<Integer> v_5 = graph.insertVertex(3);
					Vertex<Integer> v_6 = graph.insertVertex(5);
					Vertex<Integer> v_7 = graph.insertVertex(4);
					Vertex<Integer> v_8 = graph.insertVertex(6);
					Vertex<Integer> v_9 = graph.insertVertex(6);
					Vertex<Integer> v_10 = graph.insertVertex(2);
					Vertex<Integer> v_11 = graph.insertVertex(4);
					Vertex<Integer> v_12 = graph.insertVertex(6);
					Vertex<Integer> v_13 = graph.insertVertex(2);
					graph.insertDirectedEdge(v_13, v_2, null);
					graph.insertDirectedEdge(v_13, v_4, null);
					graph.insertDirectedEdge(v_13, v_5, null);
					graph.insertDirectedEdge(v_12, v_6, null);
					graph.insertDirectedEdge(v_11, v_7, null);
					graph.insertDirectedEdge(v_10, v_10, null);
					graph.insertDirectedEdge(v_10, v_11, null);
					graph.insertDirectedEdge(v_9, v_8, null);
					graph.insertDirectedEdge(v_9, v_13, null);
					graph.insertDirectedEdge(v_8, v_2, null);
					graph.insertDirectedEdge(v_8, v_3, null);
					graph.insertDirectedEdge(v_8, v_6, null);
					graph.insertDirectedEdge(v_7, v_1, null);
					graph.insertDirectedEdge(v_7, v_9, null);
					graph.insertDirectedEdge(v_6, v_2, null);
					graph.insertDirectedEdge(v_6, v_9, null);
					graph.insertDirectedEdge(v_6, v_9, null);
					graph.insertDirectedEdge(v_5, v_5, null);
					graph.insertDirectedEdge(v_5, v_5, null);
					graph.insertDirectedEdge(v_4, v_0, null);
					graph.insertDirectedEdge(v_4, v_7, null);
					graph.insertDirectedEdge(v_4, v_11, null);
					graph.insertDirectedEdge(v_3, v_1, null);
					graph.insertDirectedEdge(v_3, v_5, null);
					graph.insertDirectedEdge(v_3, v_8, null);
					graph.insertDirectedEdge(v_2, v_0, null);
					graph.insertDirectedEdge(v_2, v_1, null);
					graph.insertDirectedEdge(v_2, v_6, null);
					graph.insertDirectedEdge(v_1, v_0, null);
					graph.insertDirectedEdge(v_0, v_0, null);
					graph.insertDirectedEdge(v_0, v_6, null);
					graph.insertDirectedEdge(v_0, v_12, null);
					ok_sofar = new SumVertices(graph).doCall().checkResult(
							new es.upm.aedlib.positionlist.NodePositionList<es.upm.aedlib.Entry<Vertex<Integer>, Integer>>(
									TestUtils.toGenericArray(TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_0, 47),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_1, 47),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_2, 47),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_3, 47),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_4, 47),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_5, 3),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_6, 47),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_7, 47),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_8, 47),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_9, 47),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_10, 49),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_11, 47),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_12, 47),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_13, 47))));
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
		ResultsHandler.add_result(new String("sumVertices"), resultIs);
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
					DirectedAdjacencyListGraph<Integer, Integer> graph = new DirectedAdjacencyListGraph<Integer, Integer>();
					Vertex<Integer> v_0 = graph.insertVertex(1);
					Vertex<Integer> v_1 = graph.insertVertex(2);
					Vertex<Integer> v_2 = graph.insertVertex(1);
					Vertex<Integer> v_3 = graph.insertVertex(1);
					Vertex<Integer> v_4 = graph.insertVertex(3);
					Vertex<Integer> v_5 = graph.insertVertex(1);
					Vertex<Integer> v_6 = graph.insertVertex(1);
					Vertex<Integer> v_7 = graph.insertVertex(1);
					Vertex<Integer> v_8 = graph.insertVertex(1);
					Vertex<Integer> v_9 = graph.insertVertex(2);
					Vertex<Integer> v_10 = graph.insertVertex(1);
					Vertex<Integer> v_11 = graph.insertVertex(1);
					Vertex<Integer> v_12 = graph.insertVertex(1);
					Vertex<Integer> v_13 = graph.insertVertex(1);
					Vertex<Integer> v_14 = graph.insertVertex(3);
					graph.insertDirectedEdge(v_14, v_3, null);
					graph.insertDirectedEdge(v_13, v_7, null);
					graph.insertDirectedEdge(v_12, v_1, null);
					graph.insertDirectedEdge(v_12, v_7, null);
					graph.insertDirectedEdge(v_12, v_8, null);
					graph.insertDirectedEdge(v_11, v_6, null);
					graph.insertDirectedEdge(v_10, v_3, null);
					graph.insertDirectedEdge(v_9, v_2, null);
					graph.insertDirectedEdge(v_8, v_5, null);
					graph.insertDirectedEdge(v_7, v_1, null);
					graph.insertDirectedEdge(v_6, v_10, null);
					graph.insertDirectedEdge(v_6, v_14, null);
					graph.insertDirectedEdge(v_5, v_14, null);
					graph.insertDirectedEdge(v_4, v_0, null);
					graph.insertDirectedEdge(v_4, v_11, null);
					graph.insertDirectedEdge(v_3, v_14, null);
					graph.insertDirectedEdge(v_2, v_12, null);
					graph.insertDirectedEdge(v_1, v_4, null);
					graph.insertDirectedEdge(v_0, v_4, null);
					ok_sofar = new SumVertices(graph).doCall().checkResult(
							new es.upm.aedlib.positionlist.NodePositionList<es.upm.aedlib.Entry<Vertex<Integer>, Integer>>(
									TestUtils.toGenericArray(TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_0, 11),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_1, 13),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_2, 18),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_3, 4),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_4, 11),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_5, 5),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_6, 6),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_7, 14),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_8, 6),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_9, 20),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_10, 5),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_11, 7),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_12, 17),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_13, 15),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_14, 4))));
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
		ResultsHandler.add_result(new String("sumVertices"), resultIs);
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
					DirectedAdjacencyListGraph<Integer, Integer> graph = new DirectedAdjacencyListGraph<Integer, Integer>();
					Vertex<Integer> v_0 = graph.insertVertex(1);
					Vertex<Integer> v_1 = graph.insertVertex(2);
					Vertex<Integer> v_2 = graph.insertVertex(1);
					Vertex<Integer> v_3 = graph.insertVertex(3);
					Vertex<Integer> v_4 = graph.insertVertex(1);
					Vertex<Integer> v_5 = graph.insertVertex(1);
					Vertex<Integer> v_6 = graph.insertVertex(2);
					Vertex<Integer> v_7 = graph.insertVertex(1);
					Vertex<Integer> v_8 = graph.insertVertex(1);
					Vertex<Integer> v_9 = graph.insertVertex(2);
					Vertex<Integer> v_10 = graph.insertVertex(1);
					Vertex<Integer> v_11 = graph.insertVertex(3);
					Vertex<Integer> v_12 = graph.insertVertex(1);
					Vertex<Integer> v_13 = graph.insertVertex(2);
					Vertex<Integer> v_14 = graph.insertVertex(1);
					graph.insertDirectedEdge(v_14, v_12, null);
					graph.insertDirectedEdge(v_13, v_0, null);
					graph.insertDirectedEdge(v_13, v_13, null);
					graph.insertDirectedEdge(v_12, v_6, null);
					graph.insertDirectedEdge(v_12, v_13, null);
					graph.insertDirectedEdge(v_11, v_14, null);
					graph.insertDirectedEdge(v_10, v_0, null);
					graph.insertDirectedEdge(v_10, v_6, null);
					graph.insertDirectedEdge(v_9, v_4, null);
					graph.insertDirectedEdge(v_9, v_7, null);
					graph.insertDirectedEdge(v_9, v_9, null);
					graph.insertDirectedEdge(v_8, v_9, null);
					graph.insertDirectedEdge(v_7, v_0, null);
					graph.insertDirectedEdge(v_7, v_8, null);
					graph.insertDirectedEdge(v_7, v_14, null);
					graph.insertDirectedEdge(v_6, v_8, null);
					graph.insertDirectedEdge(v_6, v_8, null);
					graph.insertDirectedEdge(v_6, v_9, null);
					graph.insertDirectedEdge(v_6, v_12, null);
					graph.insertDirectedEdge(v_5, v_13, null);
					graph.insertDirectedEdge(v_4, v_2, null);
					graph.insertDirectedEdge(v_3, v_10, null);
					graph.insertDirectedEdge(v_3, v_14, null);
					graph.insertDirectedEdge(v_2, v_2, null);
					graph.insertDirectedEdge(v_2, v_13, null);
					graph.insertDirectedEdge(v_1, v_14, null);
					graph.insertDirectedEdge(v_0, v_6, null);
					graph.insertDirectedEdge(v_0, v_12, null);
					ok_sofar = new SumVertices(graph).doCall().checkResult(
							new es.upm.aedlib.positionlist.NodePositionList<es.upm.aedlib.Entry<Vertex<Integer>, Integer>>(
									TestUtils.toGenericArray(TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_0, 13),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_1, 15),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_2, 13),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_3, 17),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_4, 13),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_5, 14),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_6, 13),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_7, 13),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_8, 13),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_9, 13),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_10, 14),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_11, 16),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_12, 13),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_13, 13),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_14, 13))));
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
		ResultsHandler.add_result(new String("sumVertices"), resultIs);
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
					DirectedAdjacencyListGraph<Integer, Integer> graph = new DirectedAdjacencyListGraph<Integer, Integer>();
					Vertex<Integer> v_0 = graph.insertVertex(3);
					Vertex<Integer> v_1 = graph.insertVertex(2);
					Vertex<Integer> v_2 = graph.insertVertex(2);
					Vertex<Integer> v_3 = graph.insertVertex(5);
					Vertex<Integer> v_4 = graph.insertVertex(3);
					Vertex<Integer> v_5 = graph.insertVertex(2);
					Vertex<Integer> v_6 = graph.insertVertex(1);
					Vertex<Integer> v_7 = graph.insertVertex(1);
					Vertex<Integer> v_8 = graph.insertVertex(5);
					Vertex<Integer> v_9 = graph.insertVertex(1);
					Vertex<Integer> v_10 = graph.insertVertex(3);
					Vertex<Integer> v_11 = graph.insertVertex(3);
					Vertex<Integer> v_12 = graph.insertVertex(1);
					Vertex<Integer> v_13 = graph.insertVertex(5);
					Vertex<Integer> v_14 = graph.insertVertex(5);
					graph.insertDirectedEdge(v_14, v_6, null);
					graph.insertDirectedEdge(v_13, v_0, null);
					graph.insertDirectedEdge(v_13, v_0, null);
					graph.insertDirectedEdge(v_13, v_4, null);
					graph.insertDirectedEdge(v_13, v_5, null);
					graph.insertDirectedEdge(v_12, v_9, null);
					graph.insertDirectedEdge(v_11, v_10, null);
					graph.insertDirectedEdge(v_11, v_12, null);
					graph.insertDirectedEdge(v_10, v_1, null);
					graph.insertDirectedEdge(v_9, v_1, null);
					graph.insertDirectedEdge(v_9, v_14, null);
					graph.insertDirectedEdge(v_8, v_6, null);
					graph.insertDirectedEdge(v_8, v_7, null);
					graph.insertDirectedEdge(v_8, v_7, null);
					graph.insertDirectedEdge(v_8, v_10, null);
					graph.insertDirectedEdge(v_7, v_9, null);
					graph.insertDirectedEdge(v_6, v_1, null);
					graph.insertDirectedEdge(v_6, v_3, null);
					graph.insertDirectedEdge(v_6, v_8, null);
					graph.insertDirectedEdge(v_5, v_7, null);
					graph.insertDirectedEdge(v_5, v_8, null);
					graph.insertDirectedEdge(v_4, v_1, null);
					graph.insertDirectedEdge(v_4, v_3, null);
					graph.insertDirectedEdge(v_3, v_0, null);
					graph.insertDirectedEdge(v_3, v_7, null);
					graph.insertDirectedEdge(v_2, v_7, null);
					graph.insertDirectedEdge(v_1, v_5, null);
					graph.insertDirectedEdge(v_1, v_14, null);
					graph.insertDirectedEdge(v_0, v_5, null);
					graph.insertDirectedEdge(v_0, v_12, null);
					graph.insertDirectedEdge(v_0, v_13, null);
					ok_sofar = new SumVertices(graph).doCall().checkResult(
							new es.upm.aedlib.positionlist.NodePositionList<es.upm.aedlib.Entry<Vertex<Integer>, Integer>>(
									TestUtils.toGenericArray(TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_0, 37),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_1, 37),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_2, 39),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_3, 37),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_4, 37),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_5, 37),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_6, 37),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_7, 37),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_8, 37),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_9, 37),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_10, 37),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_11, 40),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_12, 37),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_13, 37),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_14, 37))));
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
		ResultsHandler.add_result(new String("sumVertices"), resultIs);
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
					DirectedAdjacencyListGraph<Integer, Integer> graph = new DirectedAdjacencyListGraph<Integer, Integer>();
					Vertex<Integer> v_0 = graph.insertVertex(7);
					Vertex<Integer> v_1 = graph.insertVertex(1);
					Vertex<Integer> v_2 = graph.insertVertex(2);
					Vertex<Integer> v_3 = graph.insertVertex(4);
					Vertex<Integer> v_4 = graph.insertVertex(7);
					Vertex<Integer> v_5 = graph.insertVertex(1);
					Vertex<Integer> v_6 = graph.insertVertex(2);
					Vertex<Integer> v_7 = graph.insertVertex(4);
					Vertex<Integer> v_8 = graph.insertVertex(3);
					Vertex<Integer> v_9 = graph.insertVertex(6);
					Vertex<Integer> v_10 = graph.insertVertex(7);
					Vertex<Integer> v_11 = graph.insertVertex(5);
					Vertex<Integer> v_12 = graph.insertVertex(8);
					Vertex<Integer> v_13 = graph.insertVertex(4);
					Vertex<Integer> v_14 = graph.insertVertex(5);
					Vertex<Integer> v_15 = graph.insertVertex(2);
					graph.insertDirectedEdge(v_15, v_11, null);
					graph.insertDirectedEdge(v_14, v_3, null);
					graph.insertDirectedEdge(v_14, v_11, null);
					graph.insertDirectedEdge(v_13, v_10, null);
					graph.insertDirectedEdge(v_12, v_6, null);
					graph.insertDirectedEdge(v_12, v_8, null);
					graph.insertDirectedEdge(v_12, v_13, null);
					graph.insertDirectedEdge(v_11, v_0, null);
					graph.insertDirectedEdge(v_11, v_3, null);
					graph.insertDirectedEdge(v_11, v_6, null);
					graph.insertDirectedEdge(v_10, v_7, null);
					graph.insertDirectedEdge(v_9, v_1, null);
					graph.insertDirectedEdge(v_9, v_12, null);
					graph.insertDirectedEdge(v_8, v_2, null);
					graph.insertDirectedEdge(v_8, v_5, null);
					graph.insertDirectedEdge(v_8, v_7, null);
					graph.insertDirectedEdge(v_7, v_3, null);
					graph.insertDirectedEdge(v_7, v_7, null);
					graph.insertDirectedEdge(v_7, v_8, null);
					graph.insertDirectedEdge(v_6, v_0, null);
					graph.insertDirectedEdge(v_6, v_11, null);
					graph.insertDirectedEdge(v_5, v_1, null);
					graph.insertDirectedEdge(v_5, v_7, null);
					graph.insertDirectedEdge(v_5, v_9, null);
					graph.insertDirectedEdge(v_4, v_10, null);
					graph.insertDirectedEdge(v_4, v_11, null);
					graph.insertDirectedEdge(v_4, v_13, null);
					graph.insertDirectedEdge(v_3, v_2, null);
					graph.insertDirectedEdge(v_3, v_7, null);
					graph.insertDirectedEdge(v_2, v_1, null);
					graph.insertDirectedEdge(v_2, v_2, null);
					graph.insertDirectedEdge(v_2, v_4, null);
					graph.insertDirectedEdge(v_1, v_3, null);
					graph.insertDirectedEdge(v_0, v_7, null);
					graph.insertDirectedEdge(v_0, v_9, null);
					graph.insertDirectedEdge(v_0, v_15, null);
					ok_sofar = new SumVertices(graph).doCall().checkResult(
							new es.upm.aedlib.positionlist.NodePositionList<es.upm.aedlib.Entry<Vertex<Integer>, Integer>>(
									TestUtils.toGenericArray(TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_0, 63),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_1, 63),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_2, 63),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_3, 63),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_4, 63),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_5, 63),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_6, 63),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_7, 63),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_8, 63),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_9, 63),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_10, 63),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_11, 63),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_12, 63),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_13, 63),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_14, 68),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_15, 63))));
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
		ResultsHandler.add_result(new String("sumVertices"), resultIs);
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
					DirectedAdjacencyListGraph<Integer, Integer> graph = new DirectedAdjacencyListGraph<Integer, Integer>();
					Vertex<Integer> v_0 = graph.insertVertex(7);
					Vertex<Integer> v_1 = graph.insertVertex(1);
					Vertex<Integer> v_2 = graph.insertVertex(5);
					Vertex<Integer> v_3 = graph.insertVertex(8);
					Vertex<Integer> v_4 = graph.insertVertex(7);
					Vertex<Integer> v_5 = graph.insertVertex(8);
					Vertex<Integer> v_6 = graph.insertVertex(2);
					Vertex<Integer> v_7 = graph.insertVertex(9);
					Vertex<Integer> v_8 = graph.insertVertex(2);
					Vertex<Integer> v_9 = graph.insertVertex(1);
					Vertex<Integer> v_10 = graph.insertVertex(1);
					Vertex<Integer> v_11 = graph.insertVertex(2);
					Vertex<Integer> v_12 = graph.insertVertex(6);
					Vertex<Integer> v_13 = graph.insertVertex(2);
					Vertex<Integer> v_14 = graph.insertVertex(4);
					Vertex<Integer> v_15 = graph.insertVertex(9);
					Vertex<Integer> v_16 = graph.insertVertex(6);
					graph.insertDirectedEdge(v_16, v_4, null);
					graph.insertDirectedEdge(v_16, v_6, null);
					graph.insertDirectedEdge(v_15, v_4, null);
					graph.insertDirectedEdge(v_15, v_13, null);
					graph.insertDirectedEdge(v_15, v_14, null);
					graph.insertDirectedEdge(v_14, v_5, null);
					graph.insertDirectedEdge(v_14, v_9, null);
					graph.insertDirectedEdge(v_14, v_12, null);
					graph.insertDirectedEdge(v_13, v_6, null);
					graph.insertDirectedEdge(v_13, v_9, null);
					graph.insertDirectedEdge(v_13, v_13, null);
					graph.insertDirectedEdge(v_13, v_13, null);
					graph.insertDirectedEdge(v_12, v_2, null);
					graph.insertDirectedEdge(v_12, v_12, null);
					graph.insertDirectedEdge(v_12, v_15, null);
					graph.insertDirectedEdge(v_11, v_2, null);
					graph.insertDirectedEdge(v_11, v_8, null);
					graph.insertDirectedEdge(v_11, v_13, null);
					graph.insertDirectedEdge(v_10, v_7, null);
					graph.insertDirectedEdge(v_10, v_9, null);
					graph.insertDirectedEdge(v_9, v_2, null);
					graph.insertDirectedEdge(v_9, v_3, null);
					graph.insertDirectedEdge(v_9, v_4, null);
					graph.insertDirectedEdge(v_8, v_3, null);
					graph.insertDirectedEdge(v_8, v_4, null);
					graph.insertDirectedEdge(v_7, v_0, null);
					graph.insertDirectedEdge(v_6, v_4, null);
					graph.insertDirectedEdge(v_6, v_5, null);
					graph.insertDirectedEdge(v_5, v_10, null);
					graph.insertDirectedEdge(v_5, v_15, null);
					graph.insertDirectedEdge(v_4, v_8, null);
					graph.insertDirectedEdge(v_4, v_12, null);
					graph.insertDirectedEdge(v_3, v_10, null);
					graph.insertDirectedEdge(v_2, v_0, null);
					graph.insertDirectedEdge(v_2, v_3, null);
					graph.insertDirectedEdge(v_2, v_6, null);
					graph.insertDirectedEdge(v_1, v_1, null);
					graph.insertDirectedEdge(v_1, v_4, null);
					graph.insertDirectedEdge(v_1, v_15, null);
					graph.insertDirectedEdge(v_0, v_11, null);
					ok_sofar = new SumVertices(graph).doCall().checkResult(
							new es.upm.aedlib.positionlist.NodePositionList<es.upm.aedlib.Entry<Vertex<Integer>, Integer>>(
									TestUtils.toGenericArray(TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_0, 73),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_1, 74),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_2, 73),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_3, 73),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_4, 73),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_5, 73),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_6, 73),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_7, 73),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_8, 73),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_9, 73),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_10, 73),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_11, 73),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_12, 73),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_13, 73),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_14, 73),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_15, 73),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_16, 79))));
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
		ResultsHandler.add_result(new String("sumVertices"), resultIs);
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
					DirectedAdjacencyListGraph<Integer, Integer> graph = new DirectedAdjacencyListGraph<Integer, Integer>();
					Vertex<Integer> v_0 = graph.insertVertex(7);
					Vertex<Integer> v_1 = graph.insertVertex(7);
					Vertex<Integer> v_2 = graph.insertVertex(5);
					Vertex<Integer> v_3 = graph.insertVertex(5);
					Vertex<Integer> v_4 = graph.insertVertex(4);
					Vertex<Integer> v_5 = graph.insertVertex(8);
					Vertex<Integer> v_6 = graph.insertVertex(5);
					Vertex<Integer> v_7 = graph.insertVertex(4);
					Vertex<Integer> v_8 = graph.insertVertex(1);
					Vertex<Integer> v_9 = graph.insertVertex(3);
					Vertex<Integer> v_10 = graph.insertVertex(7);
					Vertex<Integer> v_11 = graph.insertVertex(3);
					Vertex<Integer> v_12 = graph.insertVertex(6);
					Vertex<Integer> v_13 = graph.insertVertex(7);
					Vertex<Integer> v_14 = graph.insertVertex(1);
					Vertex<Integer> v_15 = graph.insertVertex(3);
					Vertex<Integer> v_16 = graph.insertVertex(8);
					Vertex<Integer> v_17 = graph.insertVertex(6);
					graph.insertDirectedEdge(v_17, v_1, null);
					graph.insertDirectedEdge(v_17, v_3, null);
					graph.insertDirectedEdge(v_16, v_8, null);
					graph.insertDirectedEdge(v_16, v_14, null);
					graph.insertDirectedEdge(v_15, v_15, null);
					graph.insertDirectedEdge(v_14, v_5, null);
					graph.insertDirectedEdge(v_13, v_3, null);
					graph.insertDirectedEdge(v_13, v_11, null);
					graph.insertDirectedEdge(v_13, v_14, null);
					graph.insertDirectedEdge(v_12, v_12, null);
					graph.insertDirectedEdge(v_11, v_9, null);
					graph.insertDirectedEdge(v_11, v_10, null);
					graph.insertDirectedEdge(v_11, v_13, null);
					graph.insertDirectedEdge(v_10, v_15, null);
					graph.insertDirectedEdge(v_9, v_5, null);
					graph.insertDirectedEdge(v_8, v_6, null);
					graph.insertDirectedEdge(v_8, v_15, null);
					graph.insertDirectedEdge(v_7, v_7, null);
					graph.insertDirectedEdge(v_7, v_12, null);
					graph.insertDirectedEdge(v_7, v_14, null);
					graph.insertDirectedEdge(v_6, v_8, null);
					graph.insertDirectedEdge(v_6, v_13, null);
					graph.insertDirectedEdge(v_6, v_16, null);
					graph.insertDirectedEdge(v_5, v_5, null);
					graph.insertDirectedEdge(v_5, v_9, null);
					graph.insertDirectedEdge(v_5, v_17, null);
					graph.insertDirectedEdge(v_4, v_5, null);
					graph.insertDirectedEdge(v_4, v_12, null);
					graph.insertDirectedEdge(v_4, v_16, null);
					graph.insertDirectedEdge(v_3, v_3, null);
					graph.insertDirectedEdge(v_3, v_3, null);
					graph.insertDirectedEdge(v_2, v_9, null);
					graph.insertDirectedEdge(v_2, v_17, null);
					graph.insertDirectedEdge(v_1, v_6, null);
					graph.insertDirectedEdge(v_1, v_7, null);
					graph.insertDirectedEdge(v_0, v_7, null);
					ok_sofar = new SumVertices(graph).doCall().checkResult(
							new es.upm.aedlib.positionlist.NodePositionList<es.upm.aedlib.Entry<Vertex<Integer>, Integer>>(
									TestUtils.toGenericArray(TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_0, 81),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_1, 74),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_2, 79),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_3, 5),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_4, 78),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_5, 74),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_6, 74),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_7, 74),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_8, 74),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_9, 74),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_10, 10),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_11, 74),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_12, 6),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_13, 74),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_14, 74),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_15, 3),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_16, 74),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_17, 74))));
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
		ResultsHandler.add_result(new String("sumVertices"), resultIs);
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
					DirectedAdjacencyListGraph<Integer, Integer> graph = new DirectedAdjacencyListGraph<Integer, Integer>();
					Vertex<Integer> v_0 = graph.insertVertex(4);
					Vertex<Integer> v_1 = graph.insertVertex(2);
					Vertex<Integer> v_2 = graph.insertVertex(7);
					Vertex<Integer> v_3 = graph.insertVertex(1);
					Vertex<Integer> v_4 = graph.insertVertex(7);
					Vertex<Integer> v_5 = graph.insertVertex(1);
					Vertex<Integer> v_6 = graph.insertVertex(1);
					Vertex<Integer> v_7 = graph.insertVertex(2);
					Vertex<Integer> v_8 = graph.insertVertex(3);
					Vertex<Integer> v_9 = graph.insertVertex(6);
					Vertex<Integer> v_10 = graph.insertVertex(2);
					Vertex<Integer> v_11 = graph.insertVertex(6);
					Vertex<Integer> v_12 = graph.insertVertex(1);
					Vertex<Integer> v_13 = graph.insertVertex(7);
					Vertex<Integer> v_14 = graph.insertVertex(2);
					Vertex<Integer> v_15 = graph.insertVertex(5);
					Vertex<Integer> v_16 = graph.insertVertex(2);
					Vertex<Integer> v_17 = graph.insertVertex(5);
					graph.insertDirectedEdge(v_17, v_2, null);
					graph.insertDirectedEdge(v_17, v_14, null);
					graph.insertDirectedEdge(v_16, v_0, null);
					graph.insertDirectedEdge(v_16, v_6, null);
					graph.insertDirectedEdge(v_16, v_10, null);
					graph.insertDirectedEdge(v_15, v_13, null);
					graph.insertDirectedEdge(v_14, v_4, null);
					graph.insertDirectedEdge(v_14, v_4, null);
					graph.insertDirectedEdge(v_13, v_9, null);
					graph.insertDirectedEdge(v_12, v_3, null);
					graph.insertDirectedEdge(v_12, v_4, null);
					graph.insertDirectedEdge(v_12, v_16, null);
					graph.insertDirectedEdge(v_11, v_8, null);
					graph.insertDirectedEdge(v_11, v_10, null);
					graph.insertDirectedEdge(v_10, v_1, null);
					graph.insertDirectedEdge(v_10, v_2, null);
					graph.insertDirectedEdge(v_10, v_9, null);
					graph.insertDirectedEdge(v_9, v_5, null);
					graph.insertDirectedEdge(v_8, v_8, null);
					graph.insertDirectedEdge(v_8, v_11, null);
					graph.insertDirectedEdge(v_8, v_13, null);
					graph.insertDirectedEdge(v_7, v_13, null);
					graph.insertDirectedEdge(v_7, v_16, null);
					graph.insertDirectedEdge(v_6, v_3, null);
					graph.insertDirectedEdge(v_6, v_9, null);
					graph.insertDirectedEdge(v_6, v_15, null);
					graph.insertDirectedEdge(v_5, v_6, null);
					graph.insertDirectedEdge(v_4, v_12, null);
					graph.insertDirectedEdge(v_4, v_16, null);
					graph.insertDirectedEdge(v_3, v_8, null);
					graph.insertDirectedEdge(v_3, v_11, null);
					graph.insertDirectedEdge(v_2, v_4, null);
					graph.insertDirectedEdge(v_2, v_8, null);
					graph.insertDirectedEdge(v_2, v_16, null);
					graph.insertDirectedEdge(v_2, v_16, null);
					graph.insertDirectedEdge(v_1, v_5, null);
					graph.insertDirectedEdge(v_1, v_9, null);
					graph.insertDirectedEdge(v_1, v_15, null);
					graph.insertDirectedEdge(v_1, v_15, null);
					graph.insertDirectedEdge(v_0, v_3, null);
					graph.insertDirectedEdge(v_0, v_5, null);
					ok_sofar = new SumVertices(graph).doCall().checkResult(
							new es.upm.aedlib.positionlist.NodePositionList<es.upm.aedlib.Entry<Vertex<Integer>, Integer>>(
									TestUtils.toGenericArray(TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_0, 55),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_1, 55),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_2, 55),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_3, 55),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_4, 55),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_5, 55),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_6, 55),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_7, 57),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_8, 55),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_9, 55),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_10, 55),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_11, 55),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_12, 55),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_13, 55),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_14, 57),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_15, 55),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_16, 55),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_17, 62))));
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
		ResultsHandler.add_result(new String("sumVertices"), resultIs);
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
					DirectedAdjacencyListGraph<Integer, Integer> graph = new DirectedAdjacencyListGraph<Integer, Integer>();
					Vertex<Integer> v_0 = graph.insertVertex(1);
					Vertex<Integer> v_1 = graph.insertVertex(3);
					Vertex<Integer> v_2 = graph.insertVertex(2);
					Vertex<Integer> v_3 = graph.insertVertex(2);
					Vertex<Integer> v_4 = graph.insertVertex(1);
					Vertex<Integer> v_5 = graph.insertVertex(2);
					Vertex<Integer> v_6 = graph.insertVertex(1);
					Vertex<Integer> v_7 = graph.insertVertex(3);
					Vertex<Integer> v_8 = graph.insertVertex(1);
					Vertex<Integer> v_9 = graph.insertVertex(1);
					Vertex<Integer> v_10 = graph.insertVertex(3);
					Vertex<Integer> v_11 = graph.insertVertex(1);
					Vertex<Integer> v_12 = graph.insertVertex(3);
					Vertex<Integer> v_13 = graph.insertVertex(1);
					Vertex<Integer> v_14 = graph.insertVertex(1);
					Vertex<Integer> v_15 = graph.insertVertex(2);
					Vertex<Integer> v_16 = graph.insertVertex(2);
					Vertex<Integer> v_17 = graph.insertVertex(2);
					Vertex<Integer> v_18 = graph.insertVertex(1);
					Vertex<Integer> v_19 = graph.insertVertex(2);
					graph.insertDirectedEdge(v_19, v_1, null);
					graph.insertDirectedEdge(v_19, v_5, null);
					graph.insertDirectedEdge(v_19, v_19, null);
					graph.insertDirectedEdge(v_18, v_2, null);
					graph.insertDirectedEdge(v_17, v_5, null);
					graph.insertDirectedEdge(v_17, v_11, null);
					graph.insertDirectedEdge(v_17, v_17, null);
					graph.insertDirectedEdge(v_16, v_13, null);
					graph.insertDirectedEdge(v_16, v_15, null);
					graph.insertDirectedEdge(v_15, v_8, null);
					graph.insertDirectedEdge(v_15, v_17, null);
					graph.insertDirectedEdge(v_15, v_19, null);
					graph.insertDirectedEdge(v_14, v_11, null);
					graph.insertDirectedEdge(v_13, v_19, null);
					graph.insertDirectedEdge(v_12, v_2, null);
					graph.insertDirectedEdge(v_11, v_1, null);
					graph.insertDirectedEdge(v_11, v_2, null);
					graph.insertDirectedEdge(v_10, v_7, null);
					graph.insertDirectedEdge(v_10, v_18, null);
					graph.insertDirectedEdge(v_9, v_6, null);
					graph.insertDirectedEdge(v_9, v_13, null);
					graph.insertDirectedEdge(v_8, v_6, null);
					graph.insertDirectedEdge(v_8, v_10, null);
					graph.insertDirectedEdge(v_8, v_15, null);
					graph.insertDirectedEdge(v_7, v_6, null);
					graph.insertDirectedEdge(v_7, v_6, null);
					graph.insertDirectedEdge(v_6, v_6, null);
					graph.insertDirectedEdge(v_6, v_10, null);
					graph.insertDirectedEdge(v_6, v_16, null);
					graph.insertDirectedEdge(v_5, v_5, null);
					graph.insertDirectedEdge(v_4, v_0, null);
					graph.insertDirectedEdge(v_4, v_16, null);
					graph.insertDirectedEdge(v_3, v_8, null);
					graph.insertDirectedEdge(v_3, v_16, null);
					graph.insertDirectedEdge(v_2, v_12, null);
					graph.insertDirectedEdge(v_1, v_5, null);
					graph.insertDirectedEdge(v_1, v_5, null);
					graph.insertDirectedEdge(v_0, v_9, null);
					graph.insertDirectedEdge(v_0, v_12, null);
					ok_sofar = new SumVertices(graph).doCall().checkResult(
							new es.upm.aedlib.positionlist.NodePositionList<es.upm.aedlib.Entry<Vertex<Integer>, Integer>>(
									TestUtils.toGenericArray(TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_0, 31),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_1, 5),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_2, 5),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_3, 31),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_4, 32),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_5, 2),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_6, 29),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_7, 29),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_8, 29),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_9, 30),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_10, 29),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_11, 11),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_12, 5),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_13, 8),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_14, 12),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_15, 29),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_16, 29),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_17, 13),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_18, 6),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_19, 7))));
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
		ResultsHandler.add_result(new String("sumVertices"), resultIs);
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
					DirectedAdjacencyListGraph<Integer, Integer> graph = new DirectedAdjacencyListGraph<Integer, Integer>();
					Vertex<Integer> v_0 = graph.insertVertex(2);
					Vertex<Integer> v_1 = graph.insertVertex(1);
					Vertex<Integer> v_2 = graph.insertVertex(3);
					Vertex<Integer> v_3 = graph.insertVertex(2);
					Vertex<Integer> v_4 = graph.insertVertex(1);
					Vertex<Integer> v_5 = graph.insertVertex(3);
					Vertex<Integer> v_6 = graph.insertVertex(1);
					Vertex<Integer> v_7 = graph.insertVertex(2);
					Vertex<Integer> v_8 = graph.insertVertex(4);
					Vertex<Integer> v_9 = graph.insertVertex(3);
					Vertex<Integer> v_10 = graph.insertVertex(1);
					Vertex<Integer> v_11 = graph.insertVertex(3);
					Vertex<Integer> v_12 = graph.insertVertex(2);
					Vertex<Integer> v_13 = graph.insertVertex(2);
					Vertex<Integer> v_14 = graph.insertVertex(6);
					Vertex<Integer> v_15 = graph.insertVertex(4);
					Vertex<Integer> v_16 = graph.insertVertex(4);
					Vertex<Integer> v_17 = graph.insertVertex(1);
					Vertex<Integer> v_18 = graph.insertVertex(2);
					Vertex<Integer> v_19 = graph.insertVertex(5);
					graph.insertDirectedEdge(v_19, v_2, null);
					graph.insertDirectedEdge(v_19, v_6, null);
					graph.insertDirectedEdge(v_18, v_6, null);
					graph.insertDirectedEdge(v_18, v_13, null);
					graph.insertDirectedEdge(v_18, v_14, null);
					graph.insertDirectedEdge(v_17, v_17, null);
					graph.insertDirectedEdge(v_16, v_8, null);
					graph.insertDirectedEdge(v_16, v_10, null);
					graph.insertDirectedEdge(v_16, v_16, null);
					graph.insertDirectedEdge(v_15, v_7, null);
					graph.insertDirectedEdge(v_14, v_0, null);
					graph.insertDirectedEdge(v_14, v_7, null);
					graph.insertDirectedEdge(v_13, v_19, null);
					graph.insertDirectedEdge(v_12, v_0, null);
					graph.insertDirectedEdge(v_11, v_5, null);
					graph.insertDirectedEdge(v_11, v_14, null);
					graph.insertDirectedEdge(v_11, v_16, null);
					graph.insertDirectedEdge(v_10, v_5, null);
					graph.insertDirectedEdge(v_10, v_11, null);
					graph.insertDirectedEdge(v_10, v_16, null);
					graph.insertDirectedEdge(v_9, v_5, null);
					graph.insertDirectedEdge(v_9, v_18, null);
					graph.insertDirectedEdge(v_8, v_1, null);
					graph.insertDirectedEdge(v_8, v_3, null);
					graph.insertDirectedEdge(v_7, v_12, null);
					graph.insertDirectedEdge(v_7, v_14, null);
					graph.insertDirectedEdge(v_6, v_6, null);
					graph.insertDirectedEdge(v_6, v_13, null);
					graph.insertDirectedEdge(v_6, v_16, null);
					graph.insertDirectedEdge(v_5, v_6, null);
					graph.insertDirectedEdge(v_5, v_13, null);
					graph.insertDirectedEdge(v_5, v_17, null);
					graph.insertDirectedEdge(v_4, v_6, null);
					graph.insertDirectedEdge(v_4, v_14, null);
					graph.insertDirectedEdge(v_4, v_18, null);
					graph.insertDirectedEdge(v_3, v_11, null);
					graph.insertDirectedEdge(v_3, v_12, null);
					graph.insertDirectedEdge(v_3, v_12, null);
					graph.insertDirectedEdge(v_3, v_13, null);
					graph.insertDirectedEdge(v_2, v_1, null);
					graph.insertDirectedEdge(v_1, v_2, null);
					graph.insertDirectedEdge(v_0, v_3, null);
					graph.insertDirectedEdge(v_0, v_7, null);
					graph.insertDirectedEdge(v_0, v_7, null);
					graph.insertDirectedEdge(v_0, v_18, null);
					ok_sofar = new SumVertices(graph).doCall().checkResult(
							new es.upm.aedlib.positionlist.NodePositionList<es.upm.aedlib.Entry<Vertex<Integer>, Integer>>(
									TestUtils.toGenericArray(TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_0, 44),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_1, 4),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_2, 4),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_3, 44),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_4, 45),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_5, 44),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_6, 44),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_7, 44),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_8, 44),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_9, 47),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_10, 44),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_11, 44),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_12, 44),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_13, 44),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_14, 44),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_15, 48),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_16, 44),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_17, 1),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_18, 44),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_19, 44))));
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
		ResultsHandler.add_result(new String("sumVertices"), resultIs);
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
					DirectedAdjacencyListGraph<Integer, Integer> graph = new DirectedAdjacencyListGraph<Integer, Integer>();
					Vertex<Integer> v_0 = graph.insertVertex(4);
					Vertex<Integer> v_1 = graph.insertVertex(6);
					Vertex<Integer> v_2 = graph.insertVertex(5);
					Vertex<Integer> v_3 = graph.insertVertex(6);
					Vertex<Integer> v_4 = graph.insertVertex(1);
					Vertex<Integer> v_5 = graph.insertVertex(8);
					Vertex<Integer> v_6 = graph.insertVertex(4);
					Vertex<Integer> v_7 = graph.insertVertex(6);
					Vertex<Integer> v_8 = graph.insertVertex(1);
					Vertex<Integer> v_9 = graph.insertVertex(1);
					Vertex<Integer> v_10 = graph.insertVertex(7);
					Vertex<Integer> v_11 = graph.insertVertex(4);
					Vertex<Integer> v_12 = graph.insertVertex(3);
					Vertex<Integer> v_13 = graph.insertVertex(3);
					Vertex<Integer> v_14 = graph.insertVertex(2);
					Vertex<Integer> v_15 = graph.insertVertex(7);
					Vertex<Integer> v_16 = graph.insertVertex(7);
					Vertex<Integer> v_17 = graph.insertVertex(1);
					Vertex<Integer> v_18 = graph.insertVertex(4);
					Vertex<Integer> v_19 = graph.insertVertex(8);
					graph.insertDirectedEdge(v_19, v_11, null);
					graph.insertDirectedEdge(v_18, v_10, null);
					graph.insertDirectedEdge(v_18, v_12, null);
					graph.insertDirectedEdge(v_18, v_19, null);
					graph.insertDirectedEdge(v_17, v_10, null);
					graph.insertDirectedEdge(v_17, v_17, null);
					graph.insertDirectedEdge(v_17, v_18, null);
					graph.insertDirectedEdge(v_16, v_5, null);
					graph.insertDirectedEdge(v_16, v_10, null);
					graph.insertDirectedEdge(v_15, v_9, null);
					graph.insertDirectedEdge(v_15, v_12, null);
					graph.insertDirectedEdge(v_15, v_14, null);
					graph.insertDirectedEdge(v_14, v_6, null);
					graph.insertDirectedEdge(v_13, v_6, null);
					graph.insertDirectedEdge(v_13, v_18, null);
					graph.insertDirectedEdge(v_12, v_16, null);
					graph.insertDirectedEdge(v_11, v_18, null);
					graph.insertDirectedEdge(v_11, v_19, null);
					graph.insertDirectedEdge(v_10, v_7, null);
					graph.insertDirectedEdge(v_10, v_16, null);
					graph.insertDirectedEdge(v_9, v_0, null);
					graph.insertDirectedEdge(v_9, v_11, null);
					graph.insertDirectedEdge(v_8, v_1, null);
					graph.insertDirectedEdge(v_8, v_11, null);
					graph.insertDirectedEdge(v_7, v_6, null);
					graph.insertDirectedEdge(v_7, v_6, null);
					graph.insertDirectedEdge(v_7, v_10, null);
					graph.insertDirectedEdge(v_7, v_19, null);
					graph.insertDirectedEdge(v_6, v_2, null);
					graph.insertDirectedEdge(v_6, v_14, null);
					graph.insertDirectedEdge(v_6, v_17, null);
					graph.insertDirectedEdge(v_6, v_17, null);
					graph.insertDirectedEdge(v_5, v_1, null);
					graph.insertDirectedEdge(v_4, v_14, null);
					graph.insertDirectedEdge(v_4, v_17, null);
					graph.insertDirectedEdge(v_3, v_6, null);
					graph.insertDirectedEdge(v_3, v_15, null);
					graph.insertDirectedEdge(v_3, v_19, null);
					graph.insertDirectedEdge(v_2, v_0, null);
					graph.insertDirectedEdge(v_2, v_5, null);
					graph.insertDirectedEdge(v_2, v_14, null);
					graph.insertDirectedEdge(v_2, v_14, null);
					graph.insertDirectedEdge(v_1, v_1, null);
					graph.insertDirectedEdge(v_0, v_11, null);
					graph.insertDirectedEdge(v_0, v_12, null);
					ok_sofar = new SumVertices(graph).doCall().checkResult(
							new es.upm.aedlib.positionlist.NodePositionList<es.upm.aedlib.Entry<Vertex<Integer>, Integer>>(
									TestUtils.toGenericArray(TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_0, 69),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_1, 6),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_2, 69),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_3, 83),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_4, 70),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_5, 14),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_6, 69),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_7, 69),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_8, 70),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_9, 70),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_10, 69),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_11, 69),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_12, 69),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_13, 72),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_14, 69),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_15, 77),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_16, 69),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_17, 69),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_18, 69),
											TestUtils.es_upm_aedlib_map_Entry_refl_cnstr(v_19, 69))));
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
		ResultsHandler.add_result(new String("sumVertices"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	static class Tests {
		static String tester = "TesterInd6";
	}

	static class SumGrafosUtils {
		static public String toString(DirectedAdjacencyListGraph<Integer, Integer> g, String Op, String Module) {
			return "sumVertices(g) where the graph g is\n" + g;
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

		// Checks that results, which are basic arrays, are equal
		static <E, F> boolean eqArrays(TestCall<int[], int[]> call, TestResult<int[], int[]> result, int[] expected) {
			if (!call.noException())
				return false;
			if (!call.nonNull())
				return false;

			return eqArrays(call, result.getValue(), expected);
		}

		static boolean eqArrays(TestCall<int[], int[]> call, int[] value, int[] expected) {
			boolean ok_sofar = value.length == expected.length;

			if (ok_sofar) {
				for (int i = 0; i < value.length && ok_sofar; i++) {
					ok_sofar = ok_sofar && (value[i] == expected[i]);
				}
			}

			if (!ok_sofar) {
				printError(ExecutionTime.DURING, "the call " + call.toString() + " returned an array "
						+ printArray(value) + " which differs from the expected array " + printArray(expected));
			}
			return ok_sofar;
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

		static <E> boolean wellSorted(TestCall<?, ?> call, PositionList<E> value, PositionList<E> expected,
				Function<Pair<E, E>, Boolean> isSame) {

			PositionList<E> expectedCopy = new NodePositionList<E>(expected);

			if (value.size() != expected.size()) {
				printError(ExecutionTime.DURING,
						"the call " + call.toString() + " returned a list:\n  " + value
								+ "\nwhich contains the wrong number of elements.\n"
								+ "The correct list (modulo order of equal elements) is\n  " + expectedCopy);
				return false;
			}

			Position<E> valuePos = value.first();

			while (valuePos != null) {
				E valueE = valuePos.element();

				if (valueE == null) {
					if (value.size() != expected.size()) {
						printError(ExecutionTime.DURING,
								"the call " + call.toString() + " returned a list:\n  " + value
										+ "\nwhich contains a null element.\n"
										+ "The correct list (modulo order of equal elements) is\n  " + expectedCopy);
						return false;
					}
				}

				Position<E> expectedPos = expected.first();
				boolean found = false;
				boolean equals = true;

				while (expectedPos != null && !found && equals) {
					E expectedE = expectedPos.element();
					if (valueE.equals(expectedE)) {
						found = true;
						expected.remove(expectedPos);
					} else if (!isSame.apply(new Pair<E, E>(valueE, expectedE)))
						equals = false;

					if (!found && equals) {
						expectedPos = expected.next(expectedPos);
					}
				}

				if (!found) {
					printError(ExecutionTime.DURING, "the call " + call.toString() + " returned a list:\n  " + value
							+ "\nwhich contains elements either incorrect elements or elements in the wrong order."
							+ "\nThe correct list (modulo order of equal elements) is\n  " + expectedCopy);
					return false;
				}

				valuePos = value.next(valuePos);
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

		static String printArray(char[] arr) {
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

		boolean unchanged_array(char[] original, char[] newer) {
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

	static class SumVertices extends
			TestCall<es.upm.aedlib.map.Map<Vertex<Integer>, Integer>, es.upm.aedlib.positionlist.NodePositionList<es.upm.aedlib.Entry<Vertex<Integer>, Integer>>> {
		DirectedAdjacencyListGraph<Integer, Integer> x_1;
		DirectedAdjacencyListGraph<Integer, Integer> x_1_orig;

		public SumVertices(DirectedAdjacencyListGraph<Integer, Integer> x_1) {
			this.x_1 = x_1;
			if (x_1 == null)
				x_1_orig = null;
			else
				x_1_orig = new DirectedAdjacencyListGraph<Integer, Integer>(x_1);
		}

		public String toString() {
			return SumGrafosUtils.toString(x_1_orig, new String("Suma"), new String("sumVertices"));
		}

		public es.upm.aedlib.map.Map<Vertex<Integer>, Integer> call() {
			return Suma.sumVertices(x_1);
		}

		public boolean checkResult(
				es.upm.aedlib.positionlist.NodePositionList<es.upm.aedlib.Entry<Vertex<Integer>, Integer>> expected) {
			if (!noException())
				return false;
			if (!nonNull())
				return false;
			if (!(result.isException() || fresh(result.getValue(), x_1)))
				return false;
			if (!report_unchanged(es.upm.aedlib.graph.DirectedAdjacencyListGraph.equalGraphs(x_1, x_1_orig), x_1,
					x_1_orig))
				return false;
			if (!TestUtils.sameElements(this, result, expected))
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
		}

		public static String printer(Object obj) {
			return TestUtils.standardPrinter(obj);
		}

	}

}
