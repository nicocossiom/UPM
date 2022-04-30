
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
// File generated at: 2020/9/23 -- 17:5:49
// Seed: {1600,873548,162358}
//
//////////////////////////////////////////////////////////////////////

package bancofiel;

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
public class TesterLab1 {

	@BeforeAll
	public static void init() {
		TestUtils.reportPid();
		ResultsHandler.init();
		ResultsHandler.setNumTestsRemaining(51, 60);
		TestData.setTesterType(true);
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_02");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_02"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("111"), 0).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar)
					ok_sofar = new BorrarCuenta(v_1, v_3).doCall().checkResult(null);
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_03");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_03"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("111"), 100).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar)
					ok_sofar = new BorrarCuenta(v_1, v_3).doCall().checkResult(new CuentaNoVaciaExc());
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_04");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_04"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("111"), 100).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar)
					ok_sofar = new BorrarCuenta(v_1, v_3).doCall().checkResult(new CuentaNoVaciaExc());
				if (ok_sofar)
					ok_sofar = new BorrarCuenta(v_1, v_3).doCall().checkResult(new CuentaNoVaciaExc());
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_05");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_05"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("111"), 100).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar)
					ok_sofar = new BorrarCuenta(v_1, v_3).doCall().checkResult(new CuentaNoVaciaExc());
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(100));
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_06");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_06"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("111"), 100).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, new String("222")).doCall().checkResult(new CuentaNoExisteExc());
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TestResult<String, Void> v_4 = null;
				String v_5 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_07");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_07"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("111"), 100).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar) {
					v_4 = new CrearCuenta(v_1, new String("111"), 20).doCall();
					ok_sofar = v_4.checkResult(null);
				}
				if (ok_sofar)
					v_5 = v_4.getValue();
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_3, v_5, new Integer(50)).doCall().checkResult(null);
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TestResult<String, Void> v_4 = null;
				String v_5 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_08");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_08"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("111"), 100).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar) {
					v_4 = new CrearCuenta(v_1, new String("111"), 20).doCall();
					ok_sofar = v_4.checkResult(null);
				}
				if (ok_sofar)
					v_5 = v_4.getValue();
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_3, v_5, new Integer(100)).doCall().checkResult(null);
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TestResult<String, Void> v_4 = null;
				String v_5 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_09");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_09"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("111"), 100).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar) {
					v_4 = new CrearCuenta(v_1, new String("111"), 20).doCall();
					ok_sofar = v_4.checkResult(null);
				}
				if (ok_sofar)
					v_5 = v_4.getValue();
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_3, v_5, new Integer(150)).doCall()
							.checkResult(new InsuficienteSaldoExc());
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TestResult<String, Void> v_4 = null;
				String v_5 = null;
				TestResult<String, Void> v_6 = null;
				String v_7 = null;
				TestResult<String, Void> v_8 = null;
				String v_9 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_10");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_10"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("111"), 100).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar) {
					v_4 = new CrearCuenta(v_1, new String("111"), 150).doCall();
					ok_sofar = v_4.checkResult(null);
				}
				if (ok_sofar)
					v_5 = v_4.getValue();
				if (ok_sofar) {
					v_6 = new CrearCuenta(v_1, new String("111"), 50).doCall();
					ok_sofar = v_6.checkResult(null);
				}
				if (ok_sofar)
					v_7 = v_6.getValue();
				if (ok_sofar) {
					v_8 = new CrearCuenta(v_1, new String("111"), 200).doCall();
					ok_sofar = v_8.checkResult(null);
				}
				if (ok_sofar)
					v_9 = v_8.getValue();
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_5).doCall().checkResult(new Integer(150));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_7).doCall().checkResult(new Integer(50));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(100));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_9).doCall().checkResult(new Integer(200));
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TestResult<String, Void> v_4 = null;
				String v_5 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_11");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_11"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("111"), 100).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar) {
					v_4 = new CrearCuenta(v_1, new String("222"), 100).doCall();
					ok_sofar = v_4.checkResult(null);
				}
				if (ok_sofar)
					v_5 = v_4.getValue();
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_3, v_5, new Integer(50)).doCall().checkResult(null);
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(50));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_5).doCall().checkResult(new Integer(150));
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_12");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_12"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("111"), 100).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_3, v_3, new Integer(50)).doCall().checkResult(null);
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(100));
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_13");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_13"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("111"), 100).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_3, new Integer(100)).doCall().checkResult(new Integer(0));
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_14");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_14"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("111"), 100).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_3, new Integer(100)).doCall().checkResult(new Integer(0));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(0));
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_15");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_15"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("111"), 100).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_3, new Integer(150)).doCall()
							.checkResult(new InsuficienteSaldoExc());
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_16");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_16"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("111"), 100).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(100));
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_17");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_17"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("111"), 100).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(100));
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_3, new Integer(50)).doCall().checkResult(new Integer(150));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(150));
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_18");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_18"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("111"), 100).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(100));
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_3, new Integer(50)).doCall().checkResult(new Integer(50));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(50));
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TestResult<String, Void> v_4 = null;
				String v_5 = null;
				TestResult<String, Void> v_6 = null;
				String v_7 = null;
				TestResult<String, Void> v_8 = null;
				String v_9 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_19");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_19"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("111"), 10).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar) {
					v_4 = new CrearCuenta(v_1, new String("222"), 1000).doCall();
					ok_sofar = v_4.checkResult(null);
				}
				if (ok_sofar)
					v_5 = v_4.getValue();
				if (ok_sofar) {
					v_6 = new CrearCuenta(v_1, new String("111"), 100).doCall();
					ok_sofar = v_6.checkResult(null);
				}
				if (ok_sofar)
					v_7 = v_6.getValue();
				if (ok_sofar) {
					v_8 = new CrearCuenta(v_1, new String("222"), 200).doCall();
					ok_sofar = v_8.checkResult(null);
				}
				if (ok_sofar)
					v_9 = v_8.getValue();
				if (ok_sofar)
					ok_sofar = new GetCuentasOrdenadas(v_1).doCall()
							.checkResult(new String[][] { { v_3 }, { v_7 }, { v_9 }, { v_5 } });
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TestResult<String, Void> v_4 = null;
				String v_5 = null;
				TestResult<String, Void> v_6 = null;
				String v_7 = null;
				TestResult<String, Void> v_8 = null;
				String v_9 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_20");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_20"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("111"), 10).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar) {
					v_4 = new CrearCuenta(v_1, new String("222"), 1000).doCall();
					ok_sofar = v_4.checkResult(null);
				}
				if (ok_sofar)
					v_5 = v_4.getValue();
				if (ok_sofar) {
					v_6 = new CrearCuenta(v_1, new String("222"), 100).doCall();
					ok_sofar = v_6.checkResult(null);
				}
				if (ok_sofar)
					v_7 = v_6.getValue();
				if (ok_sofar) {
					v_8 = new CrearCuenta(v_1, new String("222"), 200).doCall();
					ok_sofar = v_8.checkResult(null);
				}
				if (ok_sofar)
					v_9 = v_8.getValue();
				if (ok_sofar)
					ok_sofar = new GetSaldoCuentas(v_1, new String("222")).doCall().checkResult(new Integer(1300));
				if (ok_sofar)
					ok_sofar = new GetSaldoCuentas(v_1, new String("111")).doCall().checkResult(new Integer(10));
				if (ok_sofar)
					ok_sofar = new GetSaldoCuentas(v_1, new String("333")).doCall().checkResult(new Integer(0));
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TestResult<String, Void> v_4 = null;
				String v_5 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_21");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_21"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("111"), 100).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar) {
					v_4 = new CrearCuenta(v_1, new String("222"), 100).doCall();
					ok_sofar = v_4.checkResult(null);
				}
				if (ok_sofar)
					v_5 = v_4.getValue();
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("111")).doCall()
							.checkResult(new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] { v_3 }));
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("222")).doCall()
							.checkResult(new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] { v_5 }));
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TestResult<String, Void> v_4 = null;
				String v_5 = null;
				TestResult<String, Void> v_6 = null;
				String v_7 = null;
				TestResult<String, Void> v_8 = null;
				String v_9 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_22");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_22"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("111"), 100).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar) {
					v_4 = new CrearCuenta(v_1, new String("222"), 100).doCall();
					ok_sofar = v_4.checkResult(null);
				}
				if (ok_sofar)
					v_5 = v_4.getValue();
				if (ok_sofar) {
					v_6 = new CrearCuenta(v_1, new String("111"), 100).doCall();
					ok_sofar = v_6.checkResult(null);
				}
				if (ok_sofar)
					v_7 = v_6.getValue();
				if (ok_sofar) {
					v_8 = new CrearCuenta(v_1, new String("222"), 100).doCall();
					ok_sofar = v_8.checkResult(null);
				}
				if (ok_sofar)
					v_9 = v_8.getValue();
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("111")).doCall().checkResult(
							new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] { v_3, v_7 }));
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("222")).doCall().checkResult(
							new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] { v_5, v_9 }));
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_23");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_23"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TestResult<String, Void> v_4 = null;
				String v_5 = null;
				TestResult<String, Void> v_6 = null;
				String v_7 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_24");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_24"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar)
					ok_sofar = new BorrarCuenta(v_1, new String("xxxx_dineroB")).doCall()
							.checkResult(new CuentaNoExisteExc());
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("1111111"), 100).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(100));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(100));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(100));
				if (ok_sofar) {
					v_4 = new CrearCuenta(v_1, new String("1111111"), 0).doCall();
					ok_sofar = v_4.checkResult(null);
				}
				if (ok_sofar)
					v_5 = v_4.getValue();
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_5, new Integer(100)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar) {
					v_6 = new CrearCuenta(v_1, new String("1111111"), 100).doCall();
					ok_sofar = v_6.checkResult(null);
				}
				if (ok_sofar)
					v_7 = v_6.getValue();
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_5, new Integer(100)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new GetCuentasOrdenadas(v_1).doCall()
							.checkResult(new String[][] { { v_5 }, { v_7, v_3 } });
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_5, v_7, new Integer(76)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_7, new Integer(1000)).doCall().checkResult(new Integer(1100));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(100));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_5).doCall().checkResult(new Integer(0));
				if (ok_sofar)
					ok_sofar = new GetSaldoCuentas(v_1, new String("2222222")).doCall().checkResult(new Integer(0));
				if (ok_sofar)
					ok_sofar = new GetCuentasOrdenadas(v_1).doCall()
							.checkResult(new String[][] { { v_5 }, { v_3 }, { v_7 } });
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_7, v_3, new Integer(326)).doCall().checkResult(null);
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TestResult<String, Void> v_4 = null;
				String v_5 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_25");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_25"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar)
					ok_sofar = new BorrarCuenta(v_1, new String("xxxx_dineroB")).doCall()
							.checkResult(new CuentaNoExisteExc());
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("1111111"), 100).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar) {
					v_4 = new CrearCuenta(v_1, new String("2222222"), 100).doCall();
					ok_sofar = v_4.checkResult(null);
				}
				if (ok_sofar)
					v_5 = v_4.getValue();
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("2222222")).doCall()
							.checkResult(new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] { v_5 }));
				if (ok_sofar)
					ok_sofar = new GetCuentasOrdenadas(v_1).doCall().checkResult(new String[][] { { v_5, v_3 } });
				if (ok_sofar)
					ok_sofar = new GetCuentasOrdenadas(v_1).doCall().checkResult(new String[][] { { v_5, v_3 } });
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_26");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_26"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("1111111"), 0).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TestResult<String, Void> v_4 = null;
				String v_5 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_27");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_27"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("1111111"), 0).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar) {
					v_4 = new CrearCuenta(v_1, new String("1111111"), 1000).doCall();
					ok_sofar = v_4.checkResult(null);
				}
				if (ok_sofar)
					v_5 = v_4.getValue();
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_5).doCall().checkResult(new Integer(1000));
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TestResult<String, Void> v_4 = null;
				String v_5 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_28");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_28"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("1111111"), 0).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar) {
					v_4 = new CrearCuenta(v_1, new String("2222222"), 1000).doCall();
					ok_sofar = v_4.checkResult(null);
				}
				if (ok_sofar)
					v_5 = v_4.getValue();
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(0));
				if (ok_sofar)
					ok_sofar = new GetCuentasOrdenadas(v_1).doCall().checkResult(new String[][] { { v_3 }, { v_5 } });
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_5).doCall().checkResult(new Integer(1000));
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_5, new Integer(100)).doCall().checkResult(new Integer(900));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_3, v_5, new Integer(656)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_3, new Integer(100)).doCall().checkResult(new Integer(100));
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TestResult<String, Void> v_4 = null;
				String v_5 = null;
				TestResult<String, Void> v_6 = null;
				String v_7 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_29");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_29"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("1111111"), 100).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar) {
					v_4 = new CrearCuenta(v_1, new String("2222222"), 1000).doCall();
					ok_sofar = v_4.checkResult(null);
				}
				if (ok_sofar)
					v_5 = v_4.getValue();
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, new String("xxxx_dineroB"), v_5, new Integer(558)).doCall()
							.checkResult(new CuentaNoExisteExc());
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_5, v_3, new Integer(11)).doCall().checkResult(null);
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_3, new String("xxxx_dineroB"), new Integer(827)).doCall()
							.checkResult(new CuentaNoExisteExc());
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_5, new Integer(1000)).doCall().checkResult(new Integer(1989));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(111));
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("1111111")).doCall()
							.checkResult(new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] { v_3 }));
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_5, new Integer(100)).doCall().checkResult(new Integer(1889));
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_5, new Integer(1000)).doCall().checkResult(new Integer(2889));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_5).doCall().checkResult(new Integer(2889));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_3, v_3, new Integer(622)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_5, v_5, new Integer(283)).doCall().checkResult(null);
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_5).doCall().checkResult(new Integer(2889));
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_3, new Integer(100)).doCall().checkResult(new Integer(11));
				if (ok_sofar)
					ok_sofar = new BorrarCuenta(v_1, v_3).doCall().checkResult(new CuentaNoVaciaExc());
				if (ok_sofar) {
					v_6 = new CrearCuenta(v_1, new String("2222222"), 100).doCall();
					ok_sofar = v_6.checkResult(null);
				}
				if (ok_sofar)
					v_7 = v_6.getValue();
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_3, new Integer(100)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_3, v_5, new Integer(957)).doCall()
							.checkResult(new InsuficienteSaldoExc());
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TestResult<String, Void> v_4 = null;
				String v_5 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_30");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_30"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("1111111"), 100).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("2222222")).doCall()
							.checkResult(new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] {}));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(100));
				if (ok_sofar) {
					v_4 = new CrearCuenta(v_1, new String("2222222"), 1000).doCall();
					ok_sofar = v_4.checkResult(null);
				}
				if (ok_sofar)
					v_5 = v_4.getValue();
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_5, v_5, new Integer(521)).doCall().checkResult(null);
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, new String("xxxx_dineroB")).doCall()
							.checkResult(new CuentaNoExisteExc());
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(100));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_5, v_3, new Integer(824)).doCall().checkResult(null);
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_5, new Integer(100)).doCall().checkResult(new Integer(76));
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, new String("xxxx_dineroB"), new Integer(100)).doCall()
							.checkResult(new CuentaNoExisteExc());
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(924));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_5, v_3, new Integer(230)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("2222222")).doCall()
							.checkResult(new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] { v_5 }));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_5).doCall().checkResult(new Integer(76));
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_3, new Integer(100)).doCall().checkResult(new Integer(824));
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TestResult<String, Void> v_4 = null;
				String v_5 = null;
				TestResult<String, Void> v_6 = null;
				String v_7 = null;
				TestResult<String, Void> v_8 = null;
				String v_9 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_31");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_31"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("1111111"), 100).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_3, new Integer(100)).doCall().checkResult(new Integer(200));
				if (ok_sofar) {
					v_4 = new CrearCuenta(v_1, new String("2222222"), 1000).doCall();
					ok_sofar = v_4.checkResult(null);
				}
				if (ok_sofar)
					v_5 = v_4.getValue();
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("2222222")).doCall()
							.checkResult(new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] { v_5 }));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_3, v_5, new Integer(344)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_3, v_5, new Integer(25)).doCall().checkResult(null);
				if (ok_sofar) {
					v_6 = new CrearCuenta(v_1, new String("1111111"), 100).doCall();
					ok_sofar = v_6.checkResult(null);
				}
				if (ok_sofar)
					v_7 = v_6.getValue();
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("1111111")).doCall().checkResult(
							new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] { v_3, v_7 }));
				if (ok_sofar) {
					v_8 = new CrearCuenta(v_1, new String("1111111"), 0).doCall();
					ok_sofar = v_8.checkResult(null);
				}
				if (ok_sofar)
					v_9 = v_8.getValue();
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_9).doCall().checkResult(new Integer(0));
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("1111111")).doCall().checkResult(
							new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] { v_3, v_7, v_9 }));
				if (ok_sofar)
					ok_sofar = new GetCuentasOrdenadas(v_1).doCall()
							.checkResult(new String[][] { { v_9 }, { v_7 }, { v_3 }, { v_5 } });
				if (ok_sofar)
					ok_sofar = new GetCuentasOrdenadas(v_1).doCall()
							.checkResult(new String[][] { { v_9 }, { v_7 }, { v_3 }, { v_5 } });
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_7, v_3, new Integer(733)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("2222222")).doCall()
							.checkResult(new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] { v_5 }));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_7, v_7, new Integer(132)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_3, new Integer(0)).doCall().checkResult(new Integer(175));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_7, v_7, new Integer(641)).doCall()
							.checkResult(new InsuficienteSaldoExc());
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_32");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_32"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("1111111"), 100).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_3, new Integer(100)).doCall().checkResult(new Integer(0));
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TestResult<String, Void> v_4 = null;
				String v_5 = null;
				TestResult<String, Void> v_6 = null;
				String v_7 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_33");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_33"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("1111111"), 1000).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar)
					ok_sofar = new BorrarCuenta(v_1, v_3).doCall().checkResult(new CuentaNoVaciaExc());
				if (ok_sofar) {
					v_4 = new CrearCuenta(v_1, new String("1111111"), 100).doCall();
					ok_sofar = v_4.checkResult(null);
				}
				if (ok_sofar)
					v_5 = v_4.getValue();
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_3, new Integer(0)).doCall().checkResult(new Integer(1000));
				if (ok_sofar) {
					v_6 = new CrearCuenta(v_1, new String("1111111"), 0).doCall();
					ok_sofar = v_6.checkResult(null);
				}
				if (ok_sofar)
					v_7 = v_6.getValue();
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_3, new Integer(100)).doCall().checkResult(new Integer(900));
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("1111111")).doCall().checkResult(
							new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] { v_3, v_5, v_7 }));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_7).doCall().checkResult(new Integer(0));
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_7, new Integer(100)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_5, new Integer(100)).doCall().checkResult(new Integer(0));
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_3, new Integer(1000)).doCall().checkResult(new Integer(1900));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_5, v_3, new Integer(825)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_5, v_7, new Integer(677)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(1900));
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_3, new Integer(100)).doCall().checkResult(new Integer(2000));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_3, v_5, new Integer(170)).doCall().checkResult(null);
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_3, v_3, new Integer(39)).doCall().checkResult(null);
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_3, new Integer(100)).doCall().checkResult(new Integer(1730));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_5, v_3, new Integer(501)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_5, new Integer(100)).doCall().checkResult(new Integer(70));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_3, v_7, new Integer(714)).doCall().checkResult(null);
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_7).doCall().checkResult(new Integer(714));
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("2222222")).doCall()
							.checkResult(new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] {}));
				if (ok_sofar)
					ok_sofar = new GetSaldoCuentas(v_1, new String("2222222")).doCall().checkResult(new Integer(0));
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_7, new Integer(1000)).doCall().checkResult(new Integer(1714));
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TestResult<String, Void> v_4 = null;
				String v_5 = null;
				TestResult<String, Void> v_6 = null;
				String v_7 = null;
				TestResult<String, Void> v_8 = null;
				String v_9 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_34");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_34"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("1111111"), 1000).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(1000));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(1000));
				if (ok_sofar) {
					v_4 = new CrearCuenta(v_1, new String("2222222"), 100).doCall();
					ok_sofar = v_4.checkResult(null);
				}
				if (ok_sofar)
					v_5 = v_4.getValue();
				if (ok_sofar) {
					v_6 = new CrearCuenta(v_1, new String("1111111"), 1000).doCall();
					ok_sofar = v_6.checkResult(null);
				}
				if (ok_sofar)
					v_7 = v_6.getValue();
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_3, new Integer(100)).doCall().checkResult(new Integer(900));
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_7, new Integer(0)).doCall().checkResult(new Integer(1000));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_5).doCall().checkResult(new Integer(100));
				if (ok_sofar)
					ok_sofar = new GetCuentasOrdenadas(v_1).doCall()
							.checkResult(new String[][] { { v_5 }, { v_3 }, { v_7 } });
				if (ok_sofar)
					ok_sofar = new GetSaldoCuentas(v_1, new String("1111111")).doCall().checkResult(new Integer(1900));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_3, v_3, new Integer(454)).doCall().checkResult(null);
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_7).doCall().checkResult(new Integer(1000));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_5).doCall().checkResult(new Integer(100));
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("1111111")).doCall().checkResult(
							new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] { v_3, v_7 }));
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_5, new Integer(100)).doCall().checkResult(new Integer(0));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_5, v_7, new Integer(35)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(900));
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("1111111")).doCall().checkResult(
							new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] { v_3, v_7 }));
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_7, new Integer(0)).doCall().checkResult(new Integer(1000));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(900));
				if (ok_sofar) {
					v_8 = new CrearCuenta(v_1, new String("1111111"), 0).doCall();
					ok_sofar = v_8.checkResult(null);
				}
				if (ok_sofar)
					v_9 = v_8.getValue();
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_5, new Integer(0)).doCall().checkResult(new Integer(0));
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_5, new Integer(1000)).doCall().checkResult(new Integer(1000));
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_9, new Integer(100)).doCall()
							.checkResult(new InsuficienteSaldoExc());
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TestResult<String, Void> v_4 = null;
				String v_5 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_35");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_35"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("1111111"), 1000).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar) {
					v_4 = new CrearCuenta(v_1, new String("2222222"), 100).doCall();
					ok_sofar = v_4.checkResult(null);
				}
				if (ok_sofar)
					v_5 = v_4.getValue();
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("2222222")).doCall()
							.checkResult(new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] { v_5 }));
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TestResult<String, Void> v_4 = null;
				String v_5 = null;
				TestResult<String, Void> v_6 = null;
				String v_7 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_36");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_36"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("2222222"), 0).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar) {
					v_4 = new CrearCuenta(v_1, new String("1111111"), 100).doCall();
					ok_sofar = v_4.checkResult(null);
				}
				if (ok_sofar)
					v_5 = v_4.getValue();
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(0));
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_3, new Integer(1000)).doCall().checkResult(new Integer(1000));
				if (ok_sofar) {
					v_6 = new CrearCuenta(v_1, new String("1111111"), 1000).doCall();
					ok_sofar = v_6.checkResult(null);
				}
				if (ok_sofar)
					v_7 = v_6.getValue();
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("1111111")).doCall().checkResult(
							new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] { v_5, v_7 }));
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TestResult<String, Void> v_4 = null;
				String v_5 = null;
				TestResult<String, Void> v_6 = null;
				String v_7 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_37");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_37"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("2222222"), 0).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_3, new Integer(100)).doCall().checkResult(new Integer(100));
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_3, new Integer(100)).doCall().checkResult(new Integer(0));
				if (ok_sofar) {
					v_4 = new CrearCuenta(v_1, new String("2222222"), 0).doCall();
					ok_sofar = v_4.checkResult(null);
				}
				if (ok_sofar)
					v_5 = v_4.getValue();
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_5).doCall().checkResult(new Integer(0));
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_5, new Integer(0)).doCall().checkResult(new Integer(0));
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("1111111")).doCall()
							.checkResult(new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] {}));
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_5, new Integer(100)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_3, new Integer(100)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_5, new String("xxxx_dineroB"), new Integer(701)).doCall()
							.checkResult(new CuentaNoExisteExc());
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_5, new Integer(1000)).doCall().checkResult(new Integer(1000));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_5, v_3, new Integer(891)).doCall().checkResult(null);
				if (ok_sofar) {
					v_6 = new CrearCuenta(v_1, new String("1111111"), 1000).doCall();
					ok_sofar = v_6.checkResult(null);
				}
				if (ok_sofar)
					v_7 = v_6.getValue();
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_7, v_3, new Integer(728)).doCall().checkResult(null);
				if (ok_sofar)
					ok_sofar = new GetSaldoCuentas(v_1, new String("2222222")).doCall().checkResult(new Integer(1728));
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_5, new Integer(100)).doCall().checkResult(new Integer(9));
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_3, new Integer(1000)).doCall().checkResult(new Integer(2619));
				if (ok_sofar)
					ok_sofar = new GetSaldoCuentas(v_1, new String("1111111")).doCall().checkResult(new Integer(272));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(2619));
				if (ok_sofar)
					ok_sofar = new GetCuentasOrdenadas(v_1).doCall()
							.checkResult(new String[][] { { v_5 }, { v_7 }, { v_3 } });
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_7).doCall().checkResult(new Integer(272));
				if (ok_sofar)
					ok_sofar = new GetCuentasOrdenadas(v_1).doCall()
							.checkResult(new String[][] { { v_5 }, { v_7 }, { v_3 } });
				if (ok_sofar)
					ok_sofar = new BorrarCuenta(v_1, v_3).doCall().checkResult(new CuentaNoVaciaExc());
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("2222222")).doCall().checkResult(
							new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] { v_3, v_5 }));
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("2222222")).doCall().checkResult(
							new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] { v_3, v_5 }));
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TestResult<String, Void> v_4 = null;
				String v_5 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_38");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_38"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("2222222"), 100).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(100));
				if (ok_sofar) {
					v_4 = new CrearCuenta(v_1, new String("2222222"), 1000).doCall();
					ok_sofar = v_4.checkResult(null);
				}
				if (ok_sofar)
					v_5 = v_4.getValue();
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_5).doCall().checkResult(new Integer(1000));
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("1111111")).doCall()
							.checkResult(new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] {}));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(100));
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("1111111")).doCall()
							.checkResult(new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] {}));
				if (ok_sofar)
					ok_sofar = new GetCuentasOrdenadas(v_1).doCall().checkResult(new String[][] { { v_3 }, { v_5 } });
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TestResult<String, Void> v_4 = null;
				String v_5 = null;
				TestResult<String, Void> v_6 = null;
				String v_7 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_39");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_39"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("2222222"), 100).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar) {
					v_4 = new CrearCuenta(v_1, new String("1111111"), 1000).doCall();
					ok_sofar = v_4.checkResult(null);
				}
				if (ok_sofar)
					v_5 = v_4.getValue();
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_5, v_5, new Integer(821)).doCall().checkResult(null);
				if (ok_sofar)
					ok_sofar = new BorrarCuenta(v_1, v_3).doCall().checkResult(new CuentaNoVaciaExc());
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_3, new Integer(100)).doCall().checkResult(new Integer(0));
				if (ok_sofar)
					ok_sofar = new GetCuentasOrdenadas(v_1).doCall().checkResult(new String[][] { { v_3 }, { v_5 } });
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_3, v_5, new Integer(175)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_3, new Integer(100)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("2222222")).doCall()
							.checkResult(new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] { v_3 }));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(0));
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_3, new Integer(100)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar) {
					v_6 = new CrearCuenta(v_1, new String("1111111"), 100).doCall();
					ok_sofar = v_6.checkResult(null);
				}
				if (ok_sofar)
					v_7 = v_6.getValue();
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TestResult<String, Void> v_4 = null;
				String v_5 = null;
				TestResult<String, Void> v_6 = null;
				String v_7 = null;
				TestResult<String, Void> v_8 = null;
				String v_9 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_40");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_40"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("2222222"), 100).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar) {
					v_4 = new CrearCuenta(v_1, new String("2222222"), 1000).doCall();
					ok_sofar = v_4.checkResult(null);
				}
				if (ok_sofar)
					v_5 = v_4.getValue();
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_5, new Integer(0)).doCall().checkResult(new Integer(1000));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_3, v_3, new Integer(146)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_3, new Integer(0)).doCall().checkResult(new Integer(100));
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_3, new Integer(100)).doCall().checkResult(new Integer(200));
				if (ok_sofar) {
					v_6 = new CrearCuenta(v_1, new String("2222222"), 100).doCall();
					ok_sofar = v_6.checkResult(null);
				}
				if (ok_sofar)
					v_7 = v_6.getValue();
				if (ok_sofar)
					ok_sofar = new GetCuentasOrdenadas(v_1).doCall()
							.checkResult(new String[][] { { v_7 }, { v_3 }, { v_5 } });
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(200));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_3, v_5, new Integer(704)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_7, new Integer(1000)).doCall().checkResult(new Integer(1100));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_7).doCall().checkResult(new Integer(1100));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_7).doCall().checkResult(new Integer(1100));
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("2222222")).doCall().checkResult(
							new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] { v_3, v_5, v_7 }));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_7, v_7, new Integer(879)).doCall().checkResult(null);
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_3, new Integer(100)).doCall().checkResult(new Integer(100));
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_3, new Integer(100)).doCall().checkResult(new Integer(0));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_7, v_7, new Integer(913)).doCall().checkResult(null);
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_3, v_7, new Integer(955)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_5, v_3, new Integer(625)).doCall().checkResult(null);
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_7, v_3, new Integer(95)).doCall().checkResult(null);
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("1111111")).doCall()
							.checkResult(new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] {}));
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("2222222")).doCall().checkResult(
							new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] { v_3, v_5, v_7 }));
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_7, new Integer(100)).doCall().checkResult(new Integer(905));
				if (ok_sofar) {
					v_8 = new CrearCuenta(v_1, new String("1111111"), 0).doCall();
					ok_sofar = v_8.checkResult(null);
				}
				if (ok_sofar)
					v_9 = v_8.getValue();
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_9, new Integer(0)).doCall().checkResult(new Integer(0));
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_5, new Integer(1000)).doCall().checkResult(new Integer(1375));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(720));
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("1111111")).doCall()
							.checkResult(new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] { v_9 }));
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_3, new Integer(100)).doCall().checkResult(new Integer(620));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_7, v_5, new Integer(501)).doCall().checkResult(null);
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_3, v_3, new Integer(827)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_5, new Integer(100)).doCall().checkResult(new Integer(1776));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_9).doCall().checkResult(new Integer(0));
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_5, new Integer(100)).doCall().checkResult(new Integer(1676));
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_3, new Integer(100)).doCall().checkResult(new Integer(520));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_9, v_3, new Integer(165)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_7, new Integer(100)).doCall().checkResult(new Integer(504));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_5, v_9, new Integer(982)).doCall().checkResult(null);
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_9).doCall().checkResult(new Integer(982));
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_3, new Integer(100)).doCall().checkResult(new Integer(420));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_5, v_3, new Integer(875)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("1111111")).doCall()
							.checkResult(new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] { v_9 }));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_9).doCall().checkResult(new Integer(982));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_9, v_7, new Integer(890)).doCall().checkResult(null);
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_7, new Integer(100)).doCall().checkResult(new Integer(1294));
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_3, new Integer(100)).doCall().checkResult(new Integer(520));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_9).doCall().checkResult(new Integer(92));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(520));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_7).doCall().checkResult(new Integer(1294));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_7).doCall().checkResult(new Integer(1294));
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_3, new Integer(1000)).doCall().checkResult(new Integer(1520));
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_9, new Integer(0)).doCall().checkResult(new Integer(92));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_5).doCall().checkResult(new Integer(694));
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("2222222")).doCall().checkResult(
							new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] { v_3, v_5, v_7 }));
				if (ok_sofar)
					ok_sofar = new GetCuentasOrdenadas(v_1).doCall()
							.checkResult(new String[][] { { v_9 }, { v_5 }, { v_7 }, { v_3 } });
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_7, new Integer(0)).doCall().checkResult(new Integer(1294));
				if (ok_sofar)
					ok_sofar = new BorrarCuenta(v_1, v_3).doCall().checkResult(new CuentaNoVaciaExc());
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_5).doCall().checkResult(new Integer(694));
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_7, new Integer(100)).doCall().checkResult(new Integer(1194));
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TestResult<String, Void> v_4 = null;
				String v_5 = null;
				TestResult<String, Void> v_6 = null;
				String v_7 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_41");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_41"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("2222222"), 100).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_3, new Integer(1000)).doCall().checkResult(new Integer(1100));
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_3, new Integer(0)).doCall().checkResult(new Integer(1100));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(1100));
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("2222222")).doCall()
							.checkResult(new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] { v_3 }));
				if (ok_sofar) {
					v_4 = new CrearCuenta(v_1, new String("1111111"), 0).doCall();
					ok_sofar = v_4.checkResult(null);
				}
				if (ok_sofar)
					v_5 = v_4.getValue();
				if (ok_sofar) {
					v_6 = new CrearCuenta(v_1, new String("1111111"), 0).doCall();
					ok_sofar = v_6.checkResult(null);
				}
				if (ok_sofar)
					v_7 = v_6.getValue();
				if (ok_sofar)
					ok_sofar = new GetSaldoCuentas(v_1, new String("1111111")).doCall().checkResult(new Integer(0));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(1100));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_7, v_5, new Integer(808)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new BorrarCuenta(v_1, v_7).doCall().checkResult(null);
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_5, new Integer(100)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_5).doCall().checkResult(new Integer(0));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_5).doCall().checkResult(new Integer(0));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(1100));
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TestResult<String, Void> v_4 = null;
				String v_5 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_42");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_42"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("2222222"), 100).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_3, new Integer(100)).doCall().checkResult(new Integer(0));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(0));
				if (ok_sofar) {
					v_4 = new CrearCuenta(v_1, new String("2222222"), 1000).doCall();
					ok_sofar = v_4.checkResult(null);
				}
				if (ok_sofar)
					v_5 = v_4.getValue();
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("1111111")).doCall()
							.checkResult(new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] {}));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, new String("xxxx_dineroB")).doCall()
							.checkResult(new CuentaNoExisteExc());
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_5, v_3, new Integer(754)).doCall().checkResult(null);
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(754));
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_3, new Integer(1000)).doCall().checkResult(new Integer(1754));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_3, v_3, new Integer(687)).doCall().checkResult(null);
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_5, v_3, new Integer(716)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_3, v_3, new Integer(70)).doCall().checkResult(null);
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(1754));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(1754));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_5, v_3, new Integer(876)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_3, new Integer(0)).doCall().checkResult(new Integer(1754));
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_43");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_43"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("2222222"), 1000).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TestResult<String, Void> v_4 = null;
				String v_5 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_44");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_44"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("2222222"), 1000).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(1000));
				if (ok_sofar) {
					v_4 = new CrearCuenta(v_1, new String("1111111"), 1000).doCall();
					ok_sofar = v_4.checkResult(null);
				}
				if (ok_sofar)
					v_5 = v_4.getValue();
				if (ok_sofar)
					ok_sofar = new GetCuentasOrdenadas(v_1).doCall().checkResult(new String[][] { { v_5, v_3 } });
				if (ok_sofar)
					ok_sofar = new BorrarCuenta(v_1, v_5).doCall().checkResult(new CuentaNoVaciaExc());
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_5, new Integer(100)).doCall().checkResult(new Integer(900));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_5, v_3, new Integer(408)).doCall().checkResult(null);
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TestResult<String, Void> v_4 = null;
				String v_5 = null;
				TestResult<String, Void> v_6 = null;
				String v_7 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_45");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_45"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("2222222"), 1000).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar) {
					v_4 = new CrearCuenta(v_1, new String("1111111"), 100).doCall();
					ok_sofar = v_4.checkResult(null);
				}
				if (ok_sofar)
					v_5 = v_4.getValue();
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_3, new Integer(100)).doCall().checkResult(new Integer(900));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_5).doCall().checkResult(new Integer(100));
				if (ok_sofar)
					ok_sofar = new GetCuentasOrdenadas(v_1).doCall().checkResult(new String[][] { { v_5 }, { v_3 } });
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_5).doCall().checkResult(new Integer(100));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_5, v_3, new Integer(441)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_3, new Integer(1000)).doCall().checkResult(new Integer(1900));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_5).doCall().checkResult(new Integer(100));
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_3, new Integer(1000)).doCall().checkResult(new Integer(2900));
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("1111111")).doCall()
							.checkResult(new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] { v_5 }));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_5, v_5, new Integer(476)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_5, v_5, new Integer(689)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_5, new Integer(100)).doCall().checkResult(new Integer(0));
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_3, new Integer(0)).doCall().checkResult(new Integer(2900));
				if (ok_sofar) {
					v_6 = new CrearCuenta(v_1, new String("1111111"), 0).doCall();
					ok_sofar = v_6.checkResult(null);
				}
				if (ok_sofar)
					v_7 = v_6.getValue();
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_7, v_3, new Integer(189)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_5, v_5, new Integer(83)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_5, new Integer(100)).doCall().checkResult(new Integer(100));
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_7, new Integer(1000)).doCall().checkResult(new Integer(1000));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_5).doCall().checkResult(new Integer(100));
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_5, new Integer(0)).doCall().checkResult(new Integer(100));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(2900));
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TestResult<String, Void> v_4 = null;
				String v_5 = null;
				TestResult<String, Void> v_6 = null;
				String v_7 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_46");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_46"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("2222222"), 1000).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar) {
					v_4 = new CrearCuenta(v_1, new String("1111111"), 100).doCall();
					ok_sofar = v_4.checkResult(null);
				}
				if (ok_sofar)
					v_5 = v_4.getValue();
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_5, new Integer(100)).doCall().checkResult(new Integer(0));
				if (ok_sofar) {
					v_6 = new CrearCuenta(v_1, new String("2222222"), 100).doCall();
					ok_sofar = v_6.checkResult(null);
				}
				if (ok_sofar)
					v_7 = v_6.getValue();
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_7, new Integer(100)).doCall().checkResult(new Integer(0));
				if (ok_sofar)
					ok_sofar = new BorrarCuenta(v_1, v_3).doCall().checkResult(new CuentaNoVaciaExc());
				if (ok_sofar)
					ok_sofar = new GetCuentasOrdenadas(v_1).doCall()
							.checkResult(new String[][] { { v_7, v_5 }, { v_3 } });
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TestResult<String, Void> v_4 = null;
				String v_5 = null;
				TestResult<String, Void> v_6 = null;
				String v_7 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_47");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_47"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("2222222"), 1000).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar) {
					v_4 = new CrearCuenta(v_1, new String("1111111"), 1000).doCall();
					ok_sofar = v_4.checkResult(null);
				}
				if (ok_sofar)
					v_5 = v_4.getValue();
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_5, new Integer(100)).doCall().checkResult(new Integer(900));
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_3, new Integer(100)).doCall().checkResult(new Integer(1100));
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_5, new Integer(1000)).doCall().checkResult(new Integer(1900));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(1100));
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_5, new Integer(100)).doCall().checkResult(new Integer(1800));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_3, v_5, new Integer(111)).doCall().checkResult(null);
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_5, new Integer(100)).doCall().checkResult(new Integer(1811));
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("2222222")).doCall()
							.checkResult(new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] { v_3 }));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_5, v_3, new Integer(793)).doCall().checkResult(null);
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_3, new Integer(100)).doCall().checkResult(new Integer(1682));
				if (ok_sofar) {
					v_6 = new CrearCuenta(v_1, new String("1111111"), 100).doCall();
					ok_sofar = v_6.checkResult(null);
				}
				if (ok_sofar)
					v_7 = v_6.getValue();
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("2222222")).doCall()
							.checkResult(new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] { v_3 }));
				if (ok_sofar)
					ok_sofar = new GetCuentasOrdenadas(v_1).doCall()
							.checkResult(new String[][] { { v_7 }, { v_5 }, { v_3 } });
				if (ok_sofar)
					ok_sofar = new GetSaldoCuentas(v_1, new String("1111111")).doCall().checkResult(new Integer(1118));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(1682));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_3, v_5, new Integer(0)).doCall().checkResult(null);
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_7).doCall().checkResult(new Integer(100));
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_3, new Integer(1000)).doCall().checkResult(new Integer(2682));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_7).doCall().checkResult(new Integer(100));
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_7, new Integer(100)).doCall().checkResult(new Integer(200));
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TestResult<String, Void> v_4 = null;
				String v_5 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_48");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_48"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("2222222"), 1000).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar) {
					v_4 = new CrearCuenta(v_1, new String("2222222"), 1000).doCall();
					ok_sofar = v_4.checkResult(null);
				}
				if (ok_sofar)
					v_5 = v_4.getValue();
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_5, v_5, new Integer(105)).doCall().checkResult(null);
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_5, new Integer(100)).doCall().checkResult(new Integer(900));
				if (ok_sofar)
					ok_sofar = new GetCuentasOrdenadas(v_1).doCall().checkResult(new String[][] { { v_5 }, { v_3 } });
				if (ok_sofar)
					ok_sofar = new GetCuentasOrdenadas(v_1).doCall().checkResult(new String[][] { { v_5 }, { v_3 } });
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_3, new Integer(100)).doCall().checkResult(new Integer(900));
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TestResult<String, Void> v_4 = null;
				String v_5 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_49");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_49"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("2222222"), 1000).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("1111111")).doCall()
							.checkResult(new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] {}));
				if (ok_sofar) {
					v_4 = new CrearCuenta(v_1, new String("1111111"), 0).doCall();
					ok_sofar = v_4.checkResult(null);
				}
				if (ok_sofar)
					v_5 = v_4.getValue();
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_5).doCall().checkResult(new Integer(0));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_3, v_5, new Integer(270)).doCall().checkResult(null);
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_5, v_5, new Integer(708)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_3, v_3, new Integer(883)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_5).doCall().checkResult(new Integer(270));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(730));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_5).doCall().checkResult(new Integer(270));
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, new String("xxxx_dineroB"), new Integer(1000)).doCall()
							.checkResult(new CuentaNoExisteExc());
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_3, new Integer(100)).doCall().checkResult(new Integer(630));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_3, v_3, new Integer(793)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_5, v_5, new Integer(262)).doCall().checkResult(null);
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_3, new Integer(0)).doCall().checkResult(new Integer(630));
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("2222222")).doCall()
							.checkResult(new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] { v_3 }));
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_5, new Integer(100)).doCall().checkResult(new Integer(170));
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TestResult<String, Void> v_4 = null;
				String v_5 = null;
				TestResult<String, Void> v_6 = null;
				String v_7 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_50");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_50"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("2222222"), 1000).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_3, new Integer(100)).doCall().checkResult(new Integer(1100));
				if (ok_sofar) {
					v_4 = new CrearCuenta(v_1, new String("2222222"), 1000).doCall();
					ok_sofar = v_4.checkResult(null);
				}
				if (ok_sofar)
					v_5 = v_4.getValue();
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_3, v_5, new Integer(409)).doCall().checkResult(null);
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_3, new Integer(100)).doCall().checkResult(new Integer(791));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(791));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_3, v_3, new Integer(376)).doCall().checkResult(null);
				if (ok_sofar)
					ok_sofar = new GetCuentasOrdenadas(v_1).doCall().checkResult(new String[][] { { v_3 }, { v_5 } });
				if (ok_sofar)
					ok_sofar = new GetCuentasOrdenadas(v_1).doCall().checkResult(new String[][] { { v_3 }, { v_5 } });
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_5, new Integer(100)).doCall().checkResult(new Integer(1309));
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_3, new Integer(100)).doCall().checkResult(new Integer(691));
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_5, new Integer(100)).doCall().checkResult(new Integer(1209));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_3, v_3, new Integer(961)).doCall()
							.checkResult(new InsuficienteSaldoExc());
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_3).doCall().checkResult(new Integer(691));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_5, new String("xxxx_dineroB"), new Integer(483)).doCall()
							.checkResult(new CuentaNoExisteExc());
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_5, new Integer(0)).doCall().checkResult(new Integer(1209));
				if (ok_sofar)
					ok_sofar = new GetCuentasOrdenadas(v_1).doCall().checkResult(new String[][] { { v_3 }, { v_5 } });
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_5, new Integer(100)).doCall().checkResult(new Integer(1109));
				if (ok_sofar)
					ok_sofar = new GetIdCuentas(v_1, new String("2222222")).doCall().checkResult(
							new es.upm.aedlib.indexedlist.ArrayIndexedList<String>(new String[] { v_3, v_5 }));
				if (ok_sofar)
					ok_sofar = new ConsultarSaldo(v_1, v_5).doCall().checkResult(new Integer(1109));
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_5, new Integer(1000)).doCall().checkResult(new Integer(2109));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_3, v_3, new Integer(182)).doCall().checkResult(null);
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_3, new Integer(100)).doCall().checkResult(new Integer(591));
				if (ok_sofar)
					ok_sofar = new HacerTransferencia(v_1, v_3, new String("xxxx_dineroB"), new Integer(960)).doCall()
							.checkResult(new CuentaNoExisteExc());
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_5, new Integer(100)).doCall().checkResult(new Integer(2009));
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_5, new Integer(0)).doCall().checkResult(new Integer(2009));
				if (ok_sofar) {
					v_6 = new CrearCuenta(v_1, new String("2222222"), 1000).doCall();
					ok_sofar = v_6.checkResult(null);
				}
				if (ok_sofar)
					v_7 = v_6.getValue();
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_5, new Integer(100)).doCall().checkResult(new Integer(1909));
				if (ok_sofar)
					ok_sofar = new RetirarDinero(v_1, v_3, new Integer(100)).doCall().checkResult(new Integer(491));
				if (ok_sofar)
					ok_sofar = new GetSaldoCuentas(v_1, new String("2222222")).doCall().checkResult(new Integer(3400));
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
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
				TestResult<BancoFiel, Void> v_0 = null;
				BancoFiel v_1 = null;
				TestResult<String, Void> v_2 = null;
				String v_3 = null;
				TesterCode.resetPrinter();
				TestData.initTrace();
				TestData.testName = new String("test_51");
				boolean ok_sofar = true;
				ResultsHandler.startTest(new String("test_51"));
				if (ok_sofar) {
					v_0 = new Constructor().doCall();
					ok_sofar = v_0.checkResult(null);
				}
				if (ok_sofar)
					v_1 = v_0.getValue();
				if (ok_sofar) {
					v_2 = new CrearCuenta(v_1, new String("2222222"), 1000).doCall();
					ok_sofar = v_2.checkResult(null);
				}
				if (ok_sofar)
					v_3 = v_2.getValue();
				if (ok_sofar)
					ok_sofar = new IngresarDinero(v_1, v_3, new Integer(1000)).doCall().checkResult(new Integer(2000));
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
		ResultsHandler.add_result(new String("bancoFiel"), resultIs);
		if (messages.length() > 0)
			System.out.println(messages);
		if (!resultIs)
			Assertions.assertTrue(resultIs, messages);
	}

	static class Tests {
		static String tester = "TesterLab1";
	}

	static class IntCuenta implements Comparable<IntCuenta> {
		String id;
		String dni;
		int saldo;

		IntCuenta(String id, String dni, int saldo) {
			this.id = id;
			this.dni = dni;
			this.saldo = saldo;
		}

		public int compareTo(IntCuenta otherCuenta) {
			return id.compareTo(otherCuenta.id);
		}

		public String toString() {
			return "Cuenta(\"" + id + "\",\"" + dni + "\"," + saldo + ")";
		}

		public boolean equals(Object obj) {
			if (obj instanceof IntCuenta) {
				IntCuenta otherCuenta = (IntCuenta) obj;
				return id.equals(otherCuenta.id) && dni.equals(otherCuenta.dni) && saldo == otherCuenta.saldo;
			} else {
				return false;
			}
		}

		public int hashCode() {
			if (id == null)
				return 0;
			else
				return id.hashCode();
		}
	}

	static class BancoUtils {
		public static void resetPrinter() {
		}

		public static String printer(Object obj) {
			if (obj instanceof BancoFiel) {
				return "bancoFiel";
			} else
				return TestUtils.printer(obj, x -> printer(x));
		}

		public static IndexedList<Cuenta> execOrdenarCuentas(BancoFiel banco) {
			return banco.getCuentasOrdenadas(new ComparadorSaldo());
		}

		public static boolean cuentasListOk(BancoFiel banco, String[] ids, String[] dnis, Integer[] saldos) {
			if (banco.cuentas == null) {
				TestUtils.printError(TestUtils.ExecutionTime.AFTER,
						"the list of cuentas is incorrect.\n" + "\nThe new value is NULL!");
				return false;
			}

			ArrayList<IntCuenta> cuentas = new ArrayList<IntCuenta>();
			ArrayList<IntCuenta> expected = new ArrayList<IntCuenta>();

			for (int i = 0; i < banco.cuentas.size(); i++) {
				Cuenta cuenta = banco.cuentas.get(i);
				if (cuenta == null) {
					TestUtils.printError(TestUtils.ExecutionTime.AFTER,
							"the list of cuentas is incorrect.\n" + "\nThe new value is " + banco.cuentas
									+ "; it contains NULL elements which it should not.");
					return false;
				}
				cuentas.add(new IntCuenta(cuenta.getId(), cuenta.getDNI(), cuenta.getSaldo()));
			}

			for (int i = 0; i < ids.length; i++)
				expected.add(new IntCuenta(ids[i], dnis[i], saldos[i]));

			if (!TestUtils.sameElements(expected, cuentas)) {
				TestUtils.printError(TestUtils.ExecutionTime.AFTER, "the list of cuentas is incorrect.\n"
						+ "\nThe new value is " + cuentas + "\nbut it should contain the elements " + expected);
				return false;
			}
			return true;
		}

		public static boolean checkOrdenarCuentas(TestCall<IndexedList<Cuenta>, String[][]> call,
				TestResult<IndexedList<Cuenta>, String[][]> result, String[][] expected) {
			if (call.noException() && call.nonNull()) {
				IndexedList<Cuenta> resultValue = result.getValue();
				IndexedList<String> results = new ArrayIndexedList<String>();
				ArrayIndexedList<ArrayIndexedList<String>> expectedList = new ArrayIndexedList<ArrayIndexedList<String>>();
				for (int i = 0; i < expected.length; i++) {
					String[] item = expected[i];
					ArrayIndexedList<String> itemList = new ArrayIndexedList<String>();
					for (int j = 0; j < item.length; j++)
						itemList.add(0, expected[i][j]);
					expectedList.add(expectedList.size(), itemList);
				}
				for (int i = 0; i < resultValue.size(); i++) {
					Cuenta cuenta = resultValue.get(i);
					String id = null;
					if (cuenta != null)
						id = cuenta.getId();
					results.add(results.size(), id);
				}
				return TestUtils.wellSorted(call, results, expectedList);
			} else
				return false;
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

		static <E, F> boolean unorderedIteratorCorrect(Supplier<String> callString, Iterator<E> it, F[] expected) {

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

	static class CrearCuenta extends TestCall<String, Void> {
		BancoFiel x_1;
		String x_2;
		int x_3;

		public CrearCuenta(BancoFiel x_1, String x_2, int x_3) {
			this.x_1 = x_1;
			this.x_2 = x_2;
			this.x_3 = x_3;
		}

		public String toString() {
			StringBuilder output = new StringBuilder();
			output.append(TesterCode.printer(x_1));
			output.append(new String(".crearCuenta"));
			output.append(new String("("));
			output.append(TesterCode.printer(x_2));
			output.append(new String(", "));
			output.append(TesterCode.printer(x_3));
			output.append(new String(")"));
			return output.toString();
		}

		public String call() {
			return x_1.crearCuenta(x_2, x_3);
		}

		public boolean checkResult(Void expected) {
			if (!noException())
				return false;
			if (!nonNull())
				return false;
			return true;
		}

	}

	static class BorrarCuenta extends TestCall<Void, Throwable> {
		BancoFiel x_1;
		String x_2;

		public BorrarCuenta(BancoFiel x_1, String x_2) {
			voidReturn = true;
			this.x_1 = x_1;
			this.x_2 = x_2;
		}

		public String toString() {
			StringBuilder output = new StringBuilder();
			output.append(TesterCode.printer(x_1));
			output.append(new String(".borrarCuenta"));
			output.append(new String("("));
			output.append(TesterCode.printer(x_2));
			output.append(new String(")"));
			return output.toString();
		}

		public Void call() throws Exception {
			x_1.borrarCuenta(x_2);
			return null;
		}

		public boolean checkResult(Throwable expected) {
			if (expected != null) {
				if (!throwsException(expected.getClass().getCanonicalName()))
					return false;
				return true;
			}
			if (!noException())
				return false;
			return true;
		}

	}

	static class HacerTransferencia extends TestCall<Void, Throwable> {
		BancoFiel x_1;
		String x_2;
		String x_3;
		Integer x_4;

		public HacerTransferencia(BancoFiel x_1, String x_2, String x_3, Integer x_4) {
			voidReturn = true;
			this.x_1 = x_1;
			this.x_2 = x_2;
			this.x_3 = x_3;
			this.x_4 = x_4;
		}

		public String toString() {
			StringBuilder output = new StringBuilder();
			output.append(TesterCode.printer(x_1));
			output.append(new String(".hacerTransferencia"));
			output.append(new String("("));
			output.append(TesterCode.printer(x_2));
			output.append(new String(", "));
			output.append(TesterCode.printer(x_3));
			output.append(new String(", "));
			output.append(TesterCode.printer(x_4));
			output.append(new String(")"));
			return output.toString();
		}

		public Void call() throws Exception {
			x_1.hacerTransferencia(x_2, x_3, x_4);
			return null;
		}

		public boolean checkResult(Throwable expected) {
			if (expected != null) {
				if (!throwsException(expected.getClass().getCanonicalName()))
					return false;
				return true;
			}
			if (!noException())
				return false;
			return true;
		}

	}

	static class Constructor extends TestCall<BancoFiel, Void> {

		public Constructor() {
		}

		public String toString() {
			StringBuilder output = new StringBuilder();
			output.append(new String("new BancoFiel"));
			output.append(new String("("));
			output.append(new String(")"));
			return output.toString();
		}

		public BancoFiel call() {
			return new BancoFiel();
		}

		public boolean checkResult(Void expected) {
			if (!noException())
				return false;
			return true;
		}

	}

	static class GetIdCuentas extends
			TestCall<es.upm.aedlib.indexedlist.IndexedList<String>, es.upm.aedlib.indexedlist.ArrayIndexedList<String>> {
		BancoFiel x_1;
		String x_2;

		public GetIdCuentas(BancoFiel x_1, String x_2) {
			this.x_1 = x_1;
			this.x_2 = x_2;
		}

		public String toString() {
			StringBuilder output = new StringBuilder();
			output.append(TesterCode.printer(x_1));
			output.append(new String(".getIdCuentas"));
			output.append(new String("("));
			output.append(TesterCode.printer(x_2));
			output.append(new String(")"));
			return output.toString();
		}

		public es.upm.aedlib.indexedlist.IndexedList<String> call() {
			return x_1.getIdCuentas(x_2);
		}

		public boolean checkResult(es.upm.aedlib.indexedlist.ArrayIndexedList<String> expected) {
			return TestUtils.sameElements(this, result, expected);
		}

	}

	static class GetCuentasOrdenadas extends TestCall<es.upm.aedlib.indexedlist.IndexedList<Cuenta>, String[][]> {
		BancoFiel x_1;

		public GetCuentasOrdenadas(BancoFiel x_1) {
			this.x_1 = x_1;
		}

		public String toString() {
			StringBuilder output = new StringBuilder();
			output.append(TesterCode.printer(x_1));
			output.append(new String(".getCuentasOrdenadas"));
			output.append(new String("("));
			output.append(new String(")"));
			return output.toString();
		}

		public es.upm.aedlib.indexedlist.IndexedList<Cuenta> call() {
			return BancoUtils.execOrdenarCuentas(x_1);
		}

		public boolean checkResult(String[][] expected) {
			if (!noException())
				return false;
			if (!nonNull())
				return false;
			if (!BancoUtils.checkOrdenarCuentas(this, result, expected))
				return false;
			return true;
		}

	}

	static class GetSaldoCuentas extends TestCall<Integer, Integer> {
		BancoFiel x_1;
		String x_2;

		public GetSaldoCuentas(BancoFiel x_1, String x_2) {
			this.x_1 = x_1;
			this.x_2 = x_2;
		}

		public String toString() {
			StringBuilder output = new StringBuilder();
			output.append(TesterCode.printer(x_1));
			output.append(new String(".getSaldoCuentas"));
			output.append(new String("("));
			output.append(TesterCode.printer(x_2));
			output.append(new String(")"));
			return output.toString();
		}

		public Integer call() {
			return x_1.getSaldoCuentas(x_2);
		}

		public boolean checkResult(Integer expected) {
			if (!noException())
				return false;
			if (!nonNull())
				return false;
			if (!valuesMatch(expected))
				return false;
			return true;
		}

	}

	static class CuentasListOk extends TestCall<Boolean, Boolean> {
		BancoFiel x_1;
		String[] x_2;
		String[] x_3;
		Integer[] x_4;

		public CuentasListOk(BancoFiel x_1, String[] x_2, String[] x_3, Integer[] x_4) {
			this.x_1 = x_1;
			this.x_2 = x_2;
			this.x_3 = x_3;
			this.x_4 = x_4;
		}

		public String toString() {
			return new String("");
		}

		public Boolean call() {
			return BancoUtils.cuentasListOk(x_1, x_2, x_3, x_4);
		}

		public boolean checkResult(Boolean expected) {
			return silentCheckTrueResult();
		}

	}

	static class ConsultarSaldo extends TestCall<Integer, Object> {
		BancoFiel x_1;
		String x_2;

		public ConsultarSaldo(BancoFiel x_1, String x_2) {
			this.x_1 = x_1;
			this.x_2 = x_2;
		}

		public String toString() {
			StringBuilder output = new StringBuilder();
			output.append(TesterCode.printer(x_1));
			output.append(new String(".consultarSaldo"));
			output.append(new String("("));
			output.append(TesterCode.printer(x_2));
			output.append(new String(")"));
			return output.toString();
		}

		public Integer call() throws CuentaNoExisteExc {
			return x_1.consultarSaldo(x_2);
		}

		public boolean checkResult(Object expected) {
			if (expected instanceof Throwable) {
				Throwable t = (Throwable) expected;
				if (!throwsException(t.getClass().getCanonicalName()))
					return false;
				return true;
			}
			if (!noException())
				return false;
			if (!nonNull())
				return false;
			if (!valuesMatch(expected))
				return false;
			return true;
		}

	}

	static class RetirarDinero extends TestCall<Integer, Object> {
		BancoFiel x_1;
		String x_2;
		Integer x_3;

		public RetirarDinero(BancoFiel x_1, String x_2, Integer x_3) {
			this.x_1 = x_1;
			this.x_2 = x_2;
			this.x_3 = x_3;
		}

		public String toString() {
			StringBuilder output = new StringBuilder();
			output.append(TesterCode.printer(x_1));
			output.append(new String(".retirarDinero"));
			output.append(new String("("));
			output.append(TesterCode.printer(x_2));
			output.append(new String(", "));
			output.append(TesterCode.printer(x_3));
			output.append(new String(")"));
			return output.toString();
		}

		public Integer call() throws Exception {
			return x_1.retirarDinero(x_2, x_3);
		}

		public boolean checkResult(Object expected) {
			if (expected instanceof Throwable) {
				Throwable t = (Throwable) expected;
				if (!throwsException(t.getClass().getCanonicalName()))
					return false;
				return true;
			}
			if (!noException())
				return false;
			if (!nonNull())
				return false;
			if (!valuesMatch(expected))
				return false;
			return true;
		}

	}

	static class IngresarDinero extends TestCall<Integer, Object> {
		BancoFiel x_1;
		String x_2;
		Integer x_3;

		public IngresarDinero(BancoFiel x_1, String x_2, Integer x_3) {
			this.x_1 = x_1;
			this.x_2 = x_2;
			this.x_3 = x_3;
		}

		public String toString() {
			StringBuilder output = new StringBuilder();
			output.append(TesterCode.printer(x_1));
			output.append(new String(".ingresarDinero"));
			output.append(new String("("));
			output.append(TesterCode.printer(x_2));
			output.append(new String(", "));
			output.append(TesterCode.printer(x_3));
			output.append(new String(")"));
			return output.toString();
		}

		public Integer call() throws Exception {
			return x_1.ingresarDinero(x_2, x_3);
		}

		public boolean checkResult(Object expected) {
			if (expected instanceof Throwable) {
				Throwable t = (Throwable) expected;
				if (!throwsException(t.getClass().getCanonicalName()))
					return false;
				return true;
			}
			if (!noException())
				return false;
			if (!nonNull())
				return false;
			if (!valuesMatch(expected))
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
			BancoUtils.resetPrinter();
		}

		public static String printer(Object obj) {
			return BancoUtils.printer(obj);
		}

	}

}
