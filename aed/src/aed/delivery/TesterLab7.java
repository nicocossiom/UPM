
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
// File generated at: 2020/12/10 -- 15:11:22
// Seed: {1607,609479,442727}
//
//////////////////////////////////////////////////////////////////////



package aed.delivery;

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
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.*;
import java.lang.management.ManagementFactory;
import java.lang.reflect.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.function.*;
import java.util.function.Function;
import java.util.stream.Stream;



/**
 * The main tester class which contains JUnit5 tests.
 */
@SuppressWarnings({"unused","deprecation"})
public class TesterLab7 {

  
    

  @BeforeAll
  public static void init () 
  {
    TestUtils.reportPid() ;
    ResultsHandler.init() ;
    ResultsHandler.setNumTestsRemaining(70,60) ;
    TestData.setTesterType(true) ;
    TestUtils.ensureAedlibVersion(2,8,0) ;
  }
  
  @AfterAll
  public static void reportResults () 
  {
    ResultsHandler.report_results() ;
  }
  
  @Test
  public void test_01 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_01") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_01")) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_01")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_02 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_02") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_02")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Getafe"),new String("Valdelaguna"),new String("Las Rozas de Madrid"),new String("San Sebastian de los Reyes") },new Integer[][] { { null,null,null,null }, { 11,null,10,null }, { 92,17,null,65 }, { 54,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_02")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_03 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_03") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_03")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Villarejo de Salvanes"),new String("Horcajo de la Sierra-Aoslos"),new String("Horcajuelo de la Sierra"),new String("Miraflores de la Sierra"),new String("San Martin de la Vega") },new Integer[][] { { null,21,72,29,8 }, { 21,null,53,null,94 }, { 72,53,null,null,null }, { 29,null,null,null,null }, { 8,94,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_03")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_04 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_04") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_04")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Pozuelo del Rey"),new String("Quijorna"),new String("Villanueva del Pardillo"),new String("Collado Villalba"),new String("Tres Cantos"),new String("Torrejon de la Calzada"),new String("Villarejo de Salvanes") },new Integer[][] { { null,48,null,null,46,null,null }, { 34,null,null,null,null,56,null }, { 9,null,null,null,null,null,62 }, { null,30,null,null,null,null,null }, { 25,null,19,null,null,null,null }, { 94,null,null,null,null,null,null }, { 21,null,36,null,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_04")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_05 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_05") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_05")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Torrejon de la Calzada"),new String("Valdelaguna"),new String("Valdilecha"),new String("Reduena"),new String("Pradena del Rincon"),new String("Navalagamella"),new String("Torrelodones"),new String("Navacerrada"),new String("Valdemoro") },new Integer[][] { { null,10,65,66,null,null,null,null,null }, { 95,null,76,55,null,null,null,null,39 }, { 6,99,null,33,null,null,null,null,null }, { 16,38,27,null,null,43,null,null,null }, { 96,9,41,22,null,null,null,null,null }, { 62,21,98,null,85,null,null,null,67 }, { 97,95,55,7,32,null,null,null,null }, { 86,79,75,null,null,null,63,null,null }, { 14,28,55,null,null,null,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_05")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_06 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_06") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_06")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Collado Mediano"),new String("El Vellon") },new Integer[][] { { null,55 }, { null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Collado Mediano"),new String("El Vellon") },new Integer[][] { { null,55 }, { null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_06")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_07 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_07") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_07")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Arroyomolinos"),new String("Reduena"),new String("Patones") },new Integer[][] { { null,19,15 }, { 19,null,null }, { 15,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Arroyomolinos"),new String("Reduena"),new String("Patones") },new Integer[][] { { null,19,15 }, { 19,null,null }, { 15,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_07")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_08 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_08") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_08")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Puentes Viejas"),new String("Torrelaguna"),new String("Talamanca de Jarama") },new Integer[][] { { null,null,null }, { 9,null,null }, { 63,89,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Puentes Viejas"),new String("Torrelaguna"),new String("Talamanca de Jarama") },new Integer[][] { { null,null,null }, { 9,null,null }, { 63,89,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_08")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_09 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_09") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_09")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Olmeda de las Fuentes"),new String("Navalcarnero"),new String("Brunete"),new String("Santa Maria de la Alameda"),new String("Villanueva del Pardillo"),new String("Getafe"),new String("Collado Mediano"),new String("Navalafuente") },new Integer[][] { { null,null,22,null,null,null,null,null }, { 32,null,80,65,25,null,null,null }, { 62,73,null,null,null,76,null,null }, { 2,11,49,null,null,65,34,null }, { 64,92,22,null,null,null,null,null }, { 70,94,null,null,null,null,null,null }, { 82,71,82,null,null,null,null,null }, { 37,80,56,null,97,20,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Olmeda de las Fuentes"),new String("Navalcarnero"),new String("Brunete"),new String("Santa Maria de la Alameda"),new String("Villanueva del Pardillo"),new String("Getafe"),new String("Collado Mediano"),new String("Navalafuente") },new Integer[][] { { null,null,22,null,null,null,null,null }, { 32,null,80,65,25,null,null,null }, { 62,73,null,null,null,76,null,null }, { 2,11,49,null,null,65,34,null }, { 64,92,22,null,null,null,null,null }, { 70,94,null,null,null,null,null,null }, { 82,71,82,null,null,null,null,null }, { 37,80,56,null,97,20,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_09")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_10 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_10") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_10")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Robregordo"),new String("Camarma de Esteruelas"),new String("Cadalso de los Vidrios"),new String("Canencia"),new String("Estremera"),new String("Miraflores de la Sierra"),new String("Alcobendas"),new String("San Martin de la Vega"),new String("Boadilla del Monte") },new Integer[][] { { null,null,8,89,null,81,19,58,96 }, { null,null,null,63,13,91,null,null,null }, { 8,null,null,null,80,null,32,null,null }, { 89,63,null,null,null,34,87,null,null }, { null,13,80,null,null,null,88,null,null }, { 81,91,null,34,null,null,null,null,null }, { 19,null,32,87,88,null,null,32,null }, { 58,null,null,null,null,null,32,null,null }, { 96,null,null,null,null,null,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Robregordo"),new String("Camarma de Esteruelas"),new String("Cadalso de los Vidrios"),new String("Canencia"),new String("Estremera"),new String("Miraflores de la Sierra"),new String("Alcobendas"),new String("San Martin de la Vega"),new String("Boadilla del Monte") },new Integer[][] { { null,null,8,89,null,81,19,58,96 }, { null,null,null,63,13,91,null,null,null }, { 8,null,null,null,80,null,32,null,null }, { 89,63,null,null,null,34,87,null,null }, { null,13,80,null,null,null,88,null,null }, { 81,91,null,34,null,null,null,null,null }, { 19,null,32,87,88,null,null,32,null }, { 58,null,null,null,null,null,32,null,null }, { 96,null,null,null,null,null,null,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_10")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_11 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_11") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_11")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Pozuelo de Alarcon"),new String("Aldea del Fresno") },new Integer[][] { { null,null }, { 95,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Pozuelo de Alarcon"),new String("Aldea del Fresno") },new Integer[][] { { null,null }, { 95,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Pozuelo de Alarcon"),new String("Aldea del Fresno") },new Integer[][] { { null,null }, { 95,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_11")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_12 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_12") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_12")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Campo Real"),new String("Alcala de Henares"),new String("San Fernando de Henares"),new String("Fuenlabrada"),new String("Colmenar del Arroyo") },new Integer[][] { { null,6,null,17,null }, { 40,null,37,null,87 }, { null,null,null,23,null }, { null,null,null,null,null }, { 99,null,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Campo Real"),new String("Alcala de Henares"),new String("San Fernando de Henares"),new String("Fuenlabrada"),new String("Colmenar del Arroyo") },new Integer[][] { { null,6,null,17,null }, { 40,null,37,null,87 }, { null,null,null,23,null }, { null,null,null,null,null }, { 99,null,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Campo Real"),new String("Alcala de Henares"),new String("San Fernando de Henares"),new String("Fuenlabrada"),new String("Colmenar del Arroyo") },new Integer[][] { { null,6,null,17,null }, { 40,null,37,null,87 }, { null,null,null,23,null }, { null,null,null,null,null }, { 99,null,null,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_12")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_13 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_13") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_13")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Cenicientos"),new String("Loeches"),new String("Gargantilla del Lozoya y Pinilla de Buitrago"),new String("Corpa"),new String("San Martin de Valdeiglesias"),new String("Berzosa del Lozoya"),new String("Navarredonda y San Mames"),new String("Valdilecha") },new Integer[][] { { null,23,null,null,null,null,null,null }, { null,null,null,null,null,null,null,null }, { 65,null,null,null,95,null,73,null }, { 86,49,null,null,78,null,null,null }, { null,5,57,null,null,22,null,null }, { 10,68,12,null,null,null,73,null }, { 11,null,43,null,null,null,null,13 }, { 4,25,null,null,null,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Cenicientos"),new String("Loeches"),new String("Gargantilla del Lozoya y Pinilla de Buitrago"),new String("Corpa"),new String("San Martin de Valdeiglesias"),new String("Berzosa del Lozoya"),new String("Navarredonda y San Mames"),new String("Valdilecha") },new Integer[][] { { null,23,null,null,null,null,null,null }, { null,null,null,null,null,null,null,null }, { 65,null,null,null,95,null,73,null }, { 86,49,null,null,78,null,null,null }, { null,5,57,null,null,22,null,null }, { 10,68,12,null,null,null,73,null }, { 11,null,43,null,null,null,null,13 }, { 4,25,null,null,null,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Cenicientos"),new String("Loeches"),new String("Gargantilla del Lozoya y Pinilla de Buitrago"),new String("Corpa"),new String("San Martin de Valdeiglesias"),new String("Berzosa del Lozoya"),new String("Navarredonda y San Mames"),new String("Valdilecha") },new Integer[][] { { null,23,null,null,null,null,null,null }, { null,null,null,null,null,null,null,null }, { 65,null,null,null,95,null,73,null }, { 86,49,null,null,78,null,null,null }, { null,5,57,null,null,22,null,null }, { 10,68,12,null,null,null,73,null }, { 11,null,43,null,null,null,null,13 }, { 4,25,null,null,null,null,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_13")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_14 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_14") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_14")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Cadalso de los Vidrios"),new String("Reduena") },new Integer[][] { { null,29 }, { 29,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Cadalso de los Vidrios"),new String("Reduena") },new Integer[][] { { null,29 }, { 29,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Cadalso de los Vidrios"),new String("Reduena") },new Integer[][] { { null,29 }, { 29,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Cadalso de los Vidrios"),new String("Reduena") },new Integer[][] { { null,29 }, { 29,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_14")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_15 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_15") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_15")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Pradena del Rincon"),new String("Fresno de Torote") },new Integer[][] { { null,63 }, { 63,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Pradena del Rincon"),new String("Fresno de Torote") },new Integer[][] { { null,63 }, { 63,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Pradena del Rincon"),new String("Fresno de Torote") },new Integer[][] { { null,63 }, { 63,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Pradena del Rincon"),new String("Fresno de Torote") },new Integer[][] { { null,63 }, { 63,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_15")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_16 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_16") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_16")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Valdeolmos-Alalpardo"),new String("Colmenar de Oreja") },new Integer[][] { { null,53 }, { null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Valdeolmos-Alalpardo"),new String("Colmenar de Oreja") },new Integer[][] { { null,53 }, { null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Valdeolmos-Alalpardo"),new String("Colmenar de Oreja") },new Integer[][] { { null,53 }, { null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Valdeolmos-Alalpardo"),new String("Colmenar de Oreja") },new Integer[][] { { null,53 }, { null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_16")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_17 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_17") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_17")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Anchuelo"),new String("Navacerrada"),new String("Horcajo de la Sierra-Aoslos") },new Integer[][] { { null,null,80 }, { 53,null,null }, { null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Anchuelo"),new String("Navacerrada"),new String("Horcajo de la Sierra-Aoslos") },new Integer[][] { { null,null,80 }, { 53,null,null }, { null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Anchuelo"),new String("Navacerrada"),new String("Horcajo de la Sierra-Aoslos") },new Integer[][] { { null,null,80 }, { 53,null,null }, { null,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Anchuelo"),new String("Navacerrada"),new String("Horcajo de la Sierra-Aoslos") },new Integer[][] { { null,null,80 }, { 53,null,null }, { null,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_17")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_18 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_18") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_18")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Becerril de la Sierra"),new String("Colmenar del Arroyo"),new String("Villa del Prado") },new Integer[][] { { null,89,5 }, { 73,null,null }, { null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Becerril de la Sierra"),new String("Colmenar del Arroyo"),new String("Villa del Prado") },new Integer[][] { { null,89,5 }, { 73,null,null }, { null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Becerril de la Sierra"),new String("Colmenar del Arroyo"),new String("Villa del Prado") },new Integer[][] { { null,89,5 }, { 73,null,null }, { null,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Becerril de la Sierra"),new String("Colmenar del Arroyo"),new String("Villa del Prado") },new Integer[][] { { null,89,5 }, { 73,null,null }, { null,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_18")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_19 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_19") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_19")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Loeches"),new String("Valdemanco"),new String("Galapagar") },new Integer[][] { { null,16,43 }, { null,null,null }, { 40,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Loeches"),new String("Valdemanco"),new String("Galapagar") },new Integer[][] { { null,16,43 }, { null,null,null }, { 40,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Loeches"),new String("Valdemanco"),new String("Galapagar") },new Integer[][] { { null,16,43 }, { null,null,null }, { 40,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Loeches"),new String("Valdemanco"),new String("Galapagar") },new Integer[][] { { null,16,43 }, { null,null,null }, { 40,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_19")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_20 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_20") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_20")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Los Santos de la Humosa"),new String("Fuente el Saz de Jarama"),new String("Alcobendas") },new Integer[][] { { null,null,null }, { null,null,39 }, { 43,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Los Santos de la Humosa"),new String("Fuente el Saz de Jarama"),new String("Alcobendas") },new Integer[][] { { null,null,null }, { null,null,39 }, { 43,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Los Santos de la Humosa"),new String("Fuente el Saz de Jarama"),new String("Alcobendas") },new Integer[][] { { null,null,null }, { null,null,39 }, { 43,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Los Santos de la Humosa"),new String("Fuente el Saz de Jarama"),new String("Alcobendas") },new Integer[][] { { null,null,null }, { null,null,39 }, { 43,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_20")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_21 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_21") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_21")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Villamanta"),new String("Ambite"),new String("Las Rozas de Madrid") },new Integer[][] { { null,14,null }, { 30,null,null }, { null,8,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Villamanta"),new String("Ambite"),new String("Las Rozas de Madrid") },new Integer[][] { { null,14,null }, { 30,null,null }, { null,8,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Villamanta"),new String("Ambite"),new String("Las Rozas de Madrid") },new Integer[][] { { null,14,null }, { 30,null,null }, { null,8,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Villamanta"),new String("Ambite"),new String("Las Rozas de Madrid") },new Integer[][] { { null,14,null }, { 30,null,null }, { null,8,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_21")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_22 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_22") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_22")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Aldea del Fresno"),new String("La Acebeda"),new String("El Boalo"),new String("Colmenar Viejo") },new Integer[][] { { null,null,9,40 }, { null,null,null,88 }, { 9,null,null,null }, { 40,88,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Aldea del Fresno"),new String("La Acebeda"),new String("El Boalo"),new String("Colmenar Viejo") },new Integer[][] { { null,null,9,40 }, { null,null,null,88 }, { 9,null,null,null }, { 40,88,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Aldea del Fresno"),new String("La Acebeda"),new String("El Boalo"),new String("Colmenar Viejo") },new Integer[][] { { null,null,9,40 }, { null,null,null,88 }, { 9,null,null,null }, { 40,88,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Aldea del Fresno"),new String("La Acebeda"),new String("El Boalo"),new String("Colmenar Viejo") },new Integer[][] { { null,null,9,40 }, { null,null,null,88 }, { 9,null,null,null }, { 40,88,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_22")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_23 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_23") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_23")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Cabanillas de la Sierra"),new String("Daganzo de Arriba"),new String("San Agustin del Guadalix"),new String("Pelayos de la Presa") },new Integer[][] { { null,95,null,null }, { 58,null,null,null }, { 99,69,null,null }, { 26,100,81,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Cabanillas de la Sierra"),new String("Daganzo de Arriba"),new String("San Agustin del Guadalix"),new String("Pelayos de la Presa") },new Integer[][] { { null,95,null,null }, { 58,null,null,null }, { 99,69,null,null }, { 26,100,81,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Cabanillas de la Sierra"),new String("Daganzo de Arriba"),new String("San Agustin del Guadalix"),new String("Pelayos de la Presa") },new Integer[][] { { null,95,null,null }, { 58,null,null,null }, { 99,69,null,null }, { 26,100,81,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Cabanillas de la Sierra"),new String("Daganzo de Arriba"),new String("San Agustin del Guadalix"),new String("Pelayos de la Presa") },new Integer[][] { { null,95,null,null }, { 58,null,null,null }, { 99,69,null,null }, { 26,100,81,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_23")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_24 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_24") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_24")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("La Hiruela"),new String("Orusco de Tajuna"),new String("Valdemorillo"),new String("Carabana") },new Integer[][] { { null,89,null,null }, { 63,null,null,null }, { null,56,null,null }, { null,null,33,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("La Hiruela"),new String("Orusco de Tajuna"),new String("Valdemorillo"),new String("Carabana") },new Integer[][] { { null,89,null,null }, { 63,null,null,null }, { null,56,null,null }, { null,null,33,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("La Hiruela"),new String("Orusco de Tajuna"),new String("Valdemorillo"),new String("Carabana") },new Integer[][] { { null,89,null,null }, { 63,null,null,null }, { null,56,null,null }, { null,null,33,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("La Hiruela"),new String("Orusco de Tajuna"),new String("Valdemorillo"),new String("Carabana") },new Integer[][] { { null,89,null,null }, { 63,null,null,null }, { null,56,null,null }, { null,null,33,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_24")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_25 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_25") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_25")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Talamanca de Jarama"),new String("Carabana"),new String("Navalcarnero"),new String("Tres Cantos") },new Integer[][] { { null,null,null,null }, { 3,null,null,null }, { null,54,null,null }, { 52,null,74,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Talamanca de Jarama"),new String("Carabana"),new String("Navalcarnero"),new String("Tres Cantos") },new Integer[][] { { null,null,null,null }, { 3,null,null,null }, { null,54,null,null }, { 52,null,74,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Talamanca de Jarama"),new String("Carabana"),new String("Navalcarnero"),new String("Tres Cantos") },new Integer[][] { { null,null,null,null }, { 3,null,null,null }, { null,54,null,null }, { 52,null,74,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Talamanca de Jarama"),new String("Carabana"),new String("Navalcarnero"),new String("Tres Cantos") },new Integer[][] { { null,null,null,null }, { 3,null,null,null }, { null,54,null,null }, { 52,null,74,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_25")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_26 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_26") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_26")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Titulcia"),new String("Puebla de la Sierra"),new String("Villaviciosa de Odon"),new String("Algete") },new Integer[][] { { null,null,null,94 }, { 68,null,null,null }, { null,null,null,null }, { 10,null,36,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Titulcia"),new String("Puebla de la Sierra"),new String("Villaviciosa de Odon"),new String("Algete") },new Integer[][] { { null,null,null,94 }, { 68,null,null,null }, { null,null,null,null }, { 10,null,36,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Titulcia"),new String("Puebla de la Sierra"),new String("Villaviciosa de Odon"),new String("Algete") },new Integer[][] { { null,null,null,94 }, { 68,null,null,null }, { null,null,null,null }, { 10,null,36,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Titulcia"),new String("Puebla de la Sierra"),new String("Villaviciosa de Odon"),new String("Algete") },new Integer[][] { { null,null,null,94 }, { 68,null,null,null }, { null,null,null,null }, { 10,null,36,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_26")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_27 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_27") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_27")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Pinuecar-Gandullas"),new String("Valdelaguna"),new String("Colmenar Viejo"),new String("Torrejon de la Calzada"),new String("El Vellon") },new Integer[][] { { null,null,56,49,null }, { null,null,null,null,null }, { 26,87,null,10,null }, { null,2,null,null,null }, { 32,null,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Pinuecar-Gandullas"),new String("Valdelaguna"),new String("Colmenar Viejo"),new String("Torrejon de la Calzada"),new String("El Vellon") },new Integer[][] { { null,null,56,49,null }, { null,null,null,null,null }, { 26,87,null,10,null }, { null,2,null,null,null }, { 32,null,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Pinuecar-Gandullas"),new String("Valdelaguna"),new String("Colmenar Viejo"),new String("Torrejon de la Calzada"),new String("El Vellon") },new Integer[][] { { null,null,56,49,null }, { null,null,null,null,null }, { 26,87,null,10,null }, { null,2,null,null,null }, { 32,null,null,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Pinuecar-Gandullas"),new String("Valdelaguna"),new String("Colmenar Viejo"),new String("Torrejon de la Calzada"),new String("El Vellon") },new Integer[][] { { null,null,56,49,null }, { null,null,null,null,null }, { 26,87,null,10,null }, { null,2,null,null,null }, { 32,null,null,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_27")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_28 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_28") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_28")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Alcala de Henares"),new String("Villavieja del Lozoya"),new String("Villanueva de Perales"),new String("Colmenar de Oreja"),new String("Cenicientos"),new String("Pelayos de la Presa") },new Integer[][] { { null,100,95,null,null,null }, { 44,null,null,null,null,28 }, { 84,null,null,null,null,null }, { 47,null,58,null,42,null }, { 5,29,null,null,null,null }, { 87,56,19,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Alcala de Henares"),new String("Villavieja del Lozoya"),new String("Villanueva de Perales"),new String("Colmenar de Oreja"),new String("Cenicientos"),new String("Pelayos de la Presa") },new Integer[][] { { null,100,95,null,null,null }, { 44,null,null,null,null,28 }, { 84,null,null,null,null,null }, { 47,null,58,null,42,null }, { 5,29,null,null,null,null }, { 87,56,19,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Alcala de Henares"),new String("Villavieja del Lozoya"),new String("Villanueva de Perales"),new String("Colmenar de Oreja"),new String("Cenicientos"),new String("Pelayos de la Presa") },new Integer[][] { { null,100,95,null,null,null }, { 44,null,null,null,null,28 }, { 84,null,null,null,null,null }, { 47,null,58,null,42,null }, { 5,29,null,null,null,null }, { 87,56,19,null,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Alcala de Henares"),new String("Villavieja del Lozoya"),new String("Villanueva de Perales"),new String("Colmenar de Oreja"),new String("Cenicientos"),new String("Pelayos de la Presa") },new Integer[][] { { null,100,95,null,null,null }, { 44,null,null,null,null,28 }, { 84,null,null,null,null,null }, { 47,null,58,null,42,null }, { 5,29,null,null,null,null }, { 87,56,19,null,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_28")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_29 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_29") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_29")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Colmenar de Oreja"),new String("Colmenar Viejo"),new String("El Molar"),new String("Madarcos"),new String("Titulcia"),new String("Manzanares el Real") },new Integer[][] { { null,null,null,null,22,null }, { null,null,72,null,null,null }, { 98,null,null,null,null,null }, { 23,null,90,null,null,null }, { 50,null,null,10,null,null }, { null,85,null,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Colmenar de Oreja"),new String("Colmenar Viejo"),new String("El Molar"),new String("Madarcos"),new String("Titulcia"),new String("Manzanares el Real") },new Integer[][] { { null,null,null,null,22,null }, { null,null,72,null,null,null }, { 98,null,null,null,null,null }, { 23,null,90,null,null,null }, { 50,null,null,10,null,null }, { null,85,null,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Colmenar de Oreja"),new String("Colmenar Viejo"),new String("El Molar"),new String("Madarcos"),new String("Titulcia"),new String("Manzanares el Real") },new Integer[][] { { null,null,null,null,22,null }, { null,null,72,null,null,null }, { 98,null,null,null,null,null }, { 23,null,90,null,null,null }, { 50,null,null,10,null,null }, { null,85,null,null,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Colmenar de Oreja"),new String("Colmenar Viejo"),new String("El Molar"),new String("Madarcos"),new String("Titulcia"),new String("Manzanares el Real") },new Integer[][] { { null,null,null,null,22,null }, { null,null,72,null,null,null }, { 98,null,null,null,null,null }, { 23,null,90,null,null,null }, { 50,null,null,10,null,null }, { null,85,null,null,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_29")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_30 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_30") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_30")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Madrid"),new String("Pinuecar-Gandullas"),new String("Navas del Rey"),new String("Orusco de Tajuna"),new String("El Berrueco"),new String("Corpa") },new Integer[][] { { null,null,null,30,6,28 }, { 86,null,21,null,null,null }, { 55,null,null,null,null,null }, { 82,null,null,null,null,91 }, { 3,null,null,null,null,null }, { null,14,null,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Madrid"),new String("Pinuecar-Gandullas"),new String("Navas del Rey"),new String("Orusco de Tajuna"),new String("El Berrueco"),new String("Corpa") },new Integer[][] { { null,null,null,30,6,28 }, { 86,null,21,null,null,null }, { 55,null,null,null,null,null }, { 82,null,null,null,null,91 }, { 3,null,null,null,null,null }, { null,14,null,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Madrid"),new String("Pinuecar-Gandullas"),new String("Navas del Rey"),new String("Orusco de Tajuna"),new String("El Berrueco"),new String("Corpa") },new Integer[][] { { null,null,null,30,6,28 }, { 86,null,21,null,null,null }, { 55,null,null,null,null,null }, { 82,null,null,null,null,91 }, { 3,null,null,null,null,null }, { null,14,null,null,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Madrid"),new String("Pinuecar-Gandullas"),new String("Navas del Rey"),new String("Orusco de Tajuna"),new String("El Berrueco"),new String("Corpa") },new Integer[][] { { null,null,null,30,6,28 }, { 86,null,21,null,null,null }, { 55,null,null,null,null,null }, { 82,null,null,null,null,91 }, { 3,null,null,null,null,null }, { null,14,null,null,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_30")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_31 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_31") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_31")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Pelayos de la Presa"),new String("Villarejo de Salvanes"),new String("Horcajo de la Sierra-Aoslos"),new String("Brea de Tajo"),new String("San Lorenzo de El Escorial"),new String("Serranillos del Valle") },new Integer[][] { { null,51,null,null,65,null }, { 31,null,68,null,null,null }, { 8,null,null,null,89,89 }, { 29,null,null,null,null,null }, { 57,null,null,null,null,null }, { null,null,null,null,67,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Pelayos de la Presa"),new String("Villarejo de Salvanes"),new String("Horcajo de la Sierra-Aoslos"),new String("Brea de Tajo"),new String("San Lorenzo de El Escorial"),new String("Serranillos del Valle") },new Integer[][] { { null,51,null,null,65,null }, { 31,null,68,null,null,null }, { 8,null,null,null,89,89 }, { 29,null,null,null,null,null }, { 57,null,null,null,null,null }, { null,null,null,null,67,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Pelayos de la Presa"),new String("Villarejo de Salvanes"),new String("Horcajo de la Sierra-Aoslos"),new String("Brea de Tajo"),new String("San Lorenzo de El Escorial"),new String("Serranillos del Valle") },new Integer[][] { { null,51,null,null,65,null }, { 31,null,68,null,null,null }, { 8,null,null,null,89,89 }, { 29,null,null,null,null,null }, { 57,null,null,null,null,null }, { null,null,null,null,67,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Pelayos de la Presa"),new String("Villarejo de Salvanes"),new String("Horcajo de la Sierra-Aoslos"),new String("Brea de Tajo"),new String("San Lorenzo de El Escorial"),new String("Serranillos del Valle") },new Integer[][] { { null,51,null,null,65,null }, { 31,null,68,null,null,null }, { 8,null,null,null,89,89 }, { 29,null,null,null,null,null }, { 57,null,null,null,null,null }, { null,null,null,null,67,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_31")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_32 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_32") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_32")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Pinilla del Valle"),new String("Villavieja del Lozoya"),new String("Tres Cantos"),new String("Serranillos del Valle"),new String("Campo Real"),new String("Majadahonda") },new Integer[][] { { null,71,null,null,null,90 }, { null,null,22,null,null,null }, { 86,84,null,null,53,90 }, { 46,18,null,null,null,null }, { 6,null,71,null,null,null }, { 76,46,null,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Pinilla del Valle"),new String("Villavieja del Lozoya"),new String("Tres Cantos"),new String("Serranillos del Valle"),new String("Campo Real"),new String("Majadahonda") },new Integer[][] { { null,71,null,null,null,90 }, { null,null,22,null,null,null }, { 86,84,null,null,53,90 }, { 46,18,null,null,null,null }, { 6,null,71,null,null,null }, { 76,46,null,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Pinilla del Valle"),new String("Villavieja del Lozoya"),new String("Tres Cantos"),new String("Serranillos del Valle"),new String("Campo Real"),new String("Majadahonda") },new Integer[][] { { null,71,null,null,null,90 }, { null,null,22,null,null,null }, { 86,84,null,null,53,90 }, { 46,18,null,null,null,null }, { 6,null,71,null,null,null }, { 76,46,null,null,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Pinilla del Valle"),new String("Villavieja del Lozoya"),new String("Tres Cantos"),new String("Serranillos del Valle"),new String("Campo Real"),new String("Majadahonda") },new Integer[][] { { null,71,null,null,null,90 }, { null,null,22,null,null,null }, { 86,84,null,null,53,90 }, { 46,18,null,null,null,null }, { 6,null,71,null,null,null }, { 76,46,null,null,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_32")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_33 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_33") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_33")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Pozuelo del Rey"),new String("Ambite"),new String("Pinuecar-Gandullas"),new String("Alameda del Valle"),new String("Colmenar del Arroyo"),new String("Arroyomolinos") },new Integer[][] { { null,10,null,null,null,null }, { null,null,null,19,null,null }, { 61,null,null,null,15,null }, { 95,null,65,null,80,38 }, { 93,39,null,null,null,null }, { 67,77,null,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Pozuelo del Rey"),new String("Ambite"),new String("Pinuecar-Gandullas"),new String("Alameda del Valle"),new String("Colmenar del Arroyo"),new String("Arroyomolinos") },new Integer[][] { { null,10,null,null,null,null }, { null,null,null,19,null,null }, { 61,null,null,null,15,null }, { 95,null,65,null,80,38 }, { 93,39,null,null,null,null }, { 67,77,null,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Pozuelo del Rey"),new String("Ambite"),new String("Pinuecar-Gandullas"),new String("Alameda del Valle"),new String("Colmenar del Arroyo"),new String("Arroyomolinos") },new Integer[][] { { null,10,null,null,null,null }, { null,null,null,19,null,null }, { 61,null,null,null,15,null }, { 95,null,65,null,80,38 }, { 93,39,null,null,null,null }, { 67,77,null,null,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Pozuelo del Rey"),new String("Ambite"),new String("Pinuecar-Gandullas"),new String("Alameda del Valle"),new String("Colmenar del Arroyo"),new String("Arroyomolinos") },new Integer[][] { { null,10,null,null,null,null }, { null,null,null,19,null,null }, { 61,null,null,null,15,null }, { 95,null,65,null,80,38 }, { 93,39,null,null,null,null }, { 67,77,null,null,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_33")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_34 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_34") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_34")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Pradena del Rincon"),new String("Moralzarzal"),new String("Pinuecar-Gandullas"),new String("Villaconejos"),new String("Fuenlabrada"),new String("Rozas de Puerto Real") },new Integer[][] { { null,45,null,null,11,null }, { null,null,null,null,56,null }, { null,null,null,null,null,66 }, { null,null,55,null,null,null }, { 49,3,null,null,null,13 }, { 6,null,42,13,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Pradena del Rincon"),new String("Moralzarzal"),new String("Pinuecar-Gandullas"),new String("Villaconejos"),new String("Fuenlabrada"),new String("Rozas de Puerto Real") },new Integer[][] { { null,45,null,null,11,null }, { null,null,null,null,56,null }, { null,null,null,null,null,66 }, { null,null,55,null,null,null }, { 49,3,null,null,null,13 }, { 6,null,42,13,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Pradena del Rincon"),new String("Moralzarzal"),new String("Pinuecar-Gandullas"),new String("Villaconejos"),new String("Fuenlabrada"),new String("Rozas de Puerto Real") },new Integer[][] { { null,45,null,null,11,null }, { null,null,null,null,56,null }, { null,null,null,null,null,66 }, { null,null,55,null,null,null }, { 49,3,null,null,null,13 }, { 6,null,42,13,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Pradena del Rincon"),new String("Moralzarzal"),new String("Pinuecar-Gandullas"),new String("Villaconejos"),new String("Fuenlabrada"),new String("Rozas de Puerto Real") },new Integer[][] { { null,45,null,null,11,null }, { null,null,null,null,56,null }, { null,null,null,null,null,66 }, { null,null,55,null,null,null }, { 49,3,null,null,null,13 }, { 6,null,42,13,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_34")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_35 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_35") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_35")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("San Fernando de Henares"),new String("Estremera"),new String("Orusco de Tajuna"),new String("El Alamo"),new String("Talamanca de Jarama"),new String("Casarrubuelos") },new Integer[][] { { null,null,null,null,100,null }, { null,null,18,null,null,null }, { null,null,null,54,null,99 }, { null,null,null,null,null,11 }, { null,null,null,null,null,null }, { 9,null,null,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("San Fernando de Henares"),new String("Estremera"),new String("Orusco de Tajuna"),new String("El Alamo"),new String("Talamanca de Jarama"),new String("Casarrubuelos") },new Integer[][] { { null,null,null,null,100,null }, { null,null,18,null,null,null }, { null,null,null,54,null,99 }, { null,null,null,null,null,11 }, { null,null,null,null,null,null }, { 9,null,null,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("San Fernando de Henares"),new String("Estremera"),new String("Orusco de Tajuna"),new String("El Alamo"),new String("Talamanca de Jarama"),new String("Casarrubuelos") },new Integer[][] { { null,null,null,null,100,null }, { null,null,18,null,null,null }, { null,null,null,54,null,99 }, { null,null,null,null,null,11 }, { null,null,null,null,null,null }, { 9,null,null,null,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("San Fernando de Henares"),new String("Estremera"),new String("Orusco de Tajuna"),new String("El Alamo"),new String("Talamanca de Jarama"),new String("Casarrubuelos") },new Integer[][] { { null,null,null,null,100,null }, { null,null,18,null,null,null }, { null,null,null,54,null,99 }, { null,null,null,null,null,11 }, { null,null,null,null,null,null }, { 9,null,null,null,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_35")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_36 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_36") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_36")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Corpa"),new String("Brea de Tajo"),new String("Colmenar de Oreja"),new String("Villanueva de la Canada"),new String("Olmeda de las Fuentes"),new String("Mejorada del Campo"),new String("Arganda del Rey") },new Integer[][] { { null,52,null,null,null,null,null }, { 51,null,null,31,null,null,79 }, { null,null,null,null,7,null,null }, { null,null,null,null,null,null,98 }, { 31,85,null,72,null,null,null }, { null,97,null,null,null,null,null }, { 54,null,40,null,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Corpa"),new String("Brea de Tajo"),new String("Colmenar de Oreja"),new String("Villanueva de la Canada"),new String("Olmeda de las Fuentes"),new String("Mejorada del Campo"),new String("Arganda del Rey") },new Integer[][] { { null,52,null,null,null,null,null }, { 51,null,null,31,null,null,79 }, { null,null,null,null,7,null,null }, { null,null,null,null,null,null,98 }, { 31,85,null,72,null,null,null }, { null,97,null,null,null,null,null }, { 54,null,40,null,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Corpa"),new String("Brea de Tajo"),new String("Colmenar de Oreja"),new String("Villanueva de la Canada"),new String("Olmeda de las Fuentes"),new String("Mejorada del Campo"),new String("Arganda del Rey") },new Integer[][] { { null,52,null,null,null,null,null }, { 51,null,null,31,null,null,79 }, { null,null,null,null,7,null,null }, { null,null,null,null,null,null,98 }, { 31,85,null,72,null,null,null }, { null,97,null,null,null,null,null }, { 54,null,40,null,null,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Corpa"),new String("Brea de Tajo"),new String("Colmenar de Oreja"),new String("Villanueva de la Canada"),new String("Olmeda de las Fuentes"),new String("Mejorada del Campo"),new String("Arganda del Rey") },new Integer[][] { { null,52,null,null,null,null,null }, { 51,null,null,31,null,null,79 }, { null,null,null,null,7,null,null }, { null,null,null,null,null,null,98 }, { 31,85,null,72,null,null,null }, { null,97,null,null,null,null,null }, { 54,null,40,null,null,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_36")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_37 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_37") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_37")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Fuentiduena de Tajo"),new String("La Serna del Monte"),new String("Aldea del Fresno"),new String("Valdemoro"),new String("San Agustin del Guadalix"),new String("Cabanillas de la Sierra"),new String("Pinilla del Valle") },new Integer[][] { { null,null,null,5,null,58,null }, { null,null,null,null,null,null,null }, { 62,null,null,null,92,90,9 }, { 43,45,null,null,61,null,null }, { 13,null,null,null,null,55,null }, { 100,71,null,null,null,null,null }, { null,7,21,null,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Fuentiduena de Tajo"),new String("La Serna del Monte"),new String("Aldea del Fresno"),new String("Valdemoro"),new String("San Agustin del Guadalix"),new String("Cabanillas de la Sierra"),new String("Pinilla del Valle") },new Integer[][] { { null,null,null,5,null,58,null }, { null,null,null,null,null,null,null }, { 62,null,null,null,92,90,9 }, { 43,45,null,null,61,null,null }, { 13,null,null,null,null,55,null }, { 100,71,null,null,null,null,null }, { null,7,21,null,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Fuentiduena de Tajo"),new String("La Serna del Monte"),new String("Aldea del Fresno"),new String("Valdemoro"),new String("San Agustin del Guadalix"),new String("Cabanillas de la Sierra"),new String("Pinilla del Valle") },new Integer[][] { { null,null,null,5,null,58,null }, { null,null,null,null,null,null,null }, { 62,null,null,null,92,90,9 }, { 43,45,null,null,61,null,null }, { 13,null,null,null,null,55,null }, { 100,71,null,null,null,null,null }, { null,7,21,null,null,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Fuentiduena de Tajo"),new String("La Serna del Monte"),new String("Aldea del Fresno"),new String("Valdemoro"),new String("San Agustin del Guadalix"),new String("Cabanillas de la Sierra"),new String("Pinilla del Valle") },new Integer[][] { { null,null,null,5,null,58,null }, { null,null,null,null,null,null,null }, { 62,null,null,null,92,90,9 }, { 43,45,null,null,61,null,null }, { 13,null,null,null,null,55,null }, { 100,71,null,null,null,null,null }, { null,7,21,null,null,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_37")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_38 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_38") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_38")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("La Acebeda"),new String("Santorcaz"),new String("Serranillos del Valle"),new String("Paracuellos de Jarama"),new String("Valdetorres de Jarama"),new String("Fresnedillas de la Oliva"),new String("Mejorada del Campo") },new Integer[][] { { null,30,null,null,null,null,null }, { null,null,94,8,null,null,74 }, { 68,null,null,62,null,null,null }, { null,100,null,null,null,null,null }, { 15,null,null,null,null,null,null }, { 31,53,38,null,37,null,null }, { 26,null,29,null,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("La Acebeda"),new String("Santorcaz"),new String("Serranillos del Valle"),new String("Paracuellos de Jarama"),new String("Valdetorres de Jarama"),new String("Fresnedillas de la Oliva"),new String("Mejorada del Campo") },new Integer[][] { { null,30,null,null,null,null,null }, { null,null,94,8,null,null,74 }, { 68,null,null,62,null,null,null }, { null,100,null,null,null,null,null }, { 15,null,null,null,null,null,null }, { 31,53,38,null,37,null,null }, { 26,null,29,null,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("La Acebeda"),new String("Santorcaz"),new String("Serranillos del Valle"),new String("Paracuellos de Jarama"),new String("Valdetorres de Jarama"),new String("Fresnedillas de la Oliva"),new String("Mejorada del Campo") },new Integer[][] { { null,30,null,null,null,null,null }, { null,null,94,8,null,null,74 }, { 68,null,null,62,null,null,null }, { null,100,null,null,null,null,null }, { 15,null,null,null,null,null,null }, { 31,53,38,null,37,null,null }, { 26,null,29,null,null,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("La Acebeda"),new String("Santorcaz"),new String("Serranillos del Valle"),new String("Paracuellos de Jarama"),new String("Valdetorres de Jarama"),new String("Fresnedillas de la Oliva"),new String("Mejorada del Campo") },new Integer[][] { { null,30,null,null,null,null,null }, { null,null,94,8,null,null,74 }, { 68,null,null,62,null,null,null }, { null,100,null,null,null,null,null }, { 15,null,null,null,null,null,null }, { 31,53,38,null,37,null,null }, { 26,null,29,null,null,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_38")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_39 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_39") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_39")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Moraleja de Enmedio"),new String("Berzosa del Lozoya"),new String("Anchuelo"),new String("Tielmes"),new String("San Lorenzo de El Escorial"),new String("Fuente el Saz de Jarama"),new String("Pinto") },new Integer[][] { { null,85,null,21,null,null,null }, { 85,null,null,null,null,null,5 }, { null,null,null,null,88,null,null }, { 84,50,1,null,100,null,null }, { 5,null,15,7,null,null,null }, { 92,73,null,null,null,null,null }, { 23,56,null,null,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Moraleja de Enmedio"),new String("Berzosa del Lozoya"),new String("Anchuelo"),new String("Tielmes"),new String("San Lorenzo de El Escorial"),new String("Fuente el Saz de Jarama"),new String("Pinto") },new Integer[][] { { null,85,null,21,null,null,null }, { 85,null,null,null,null,null,5 }, { null,null,null,null,88,null,null }, { 84,50,1,null,100,null,null }, { 5,null,15,7,null,null,null }, { 92,73,null,null,null,null,null }, { 23,56,null,null,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Moraleja de Enmedio"),new String("Berzosa del Lozoya"),new String("Anchuelo"),new String("Tielmes"),new String("San Lorenzo de El Escorial"),new String("Fuente el Saz de Jarama"),new String("Pinto") },new Integer[][] { { null,85,null,21,null,null,null }, { 85,null,null,null,null,null,5 }, { null,null,null,null,88,null,null }, { 84,50,1,null,100,null,null }, { 5,null,15,7,null,null,null }, { 92,73,null,null,null,null,null }, { 23,56,null,null,null,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Moraleja de Enmedio"),new String("Berzosa del Lozoya"),new String("Anchuelo"),new String("Tielmes"),new String("San Lorenzo de El Escorial"),new String("Fuente el Saz de Jarama"),new String("Pinto") },new Integer[][] { { null,85,null,21,null,null,null }, { 85,null,null,null,null,null,5 }, { null,null,null,null,88,null,null }, { 84,50,1,null,100,null,null }, { 5,null,15,7,null,null,null }, { 92,73,null,null,null,null,null }, { 23,56,null,null,null,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_39")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_40 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_40") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_40")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Parla"),new String("Torres de la Alameda"),new String("Cercedilla"),new String("Colmenar Viejo"),new String("Los Santos de la Humosa"),new String("Navarredonda y San Mames"),new String("Carabana") },new Integer[][] { { null,87,48,null,19,null,null }, { 90,null,83,31,null,null,null }, { 6,null,null,null,null,null,null }, { null,15,null,null,15,68,null }, { 65,15,null,null,null,null,null }, { 44,null,null,null,null,null,null }, { 83,28,null,59,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Parla"),new String("Torres de la Alameda"),new String("Cercedilla"),new String("Colmenar Viejo"),new String("Los Santos de la Humosa"),new String("Navarredonda y San Mames"),new String("Carabana") },new Integer[][] { { null,87,48,null,19,null,null }, { 90,null,83,31,null,null,null }, { 6,null,null,null,null,null,null }, { null,15,null,null,15,68,null }, { 65,15,null,null,null,null,null }, { 44,null,null,null,null,null,null }, { 83,28,null,59,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Parla"),new String("Torres de la Alameda"),new String("Cercedilla"),new String("Colmenar Viejo"),new String("Los Santos de la Humosa"),new String("Navarredonda y San Mames"),new String("Carabana") },new Integer[][] { { null,87,48,null,19,null,null }, { 90,null,83,31,null,null,null }, { 6,null,null,null,null,null,null }, { null,15,null,null,15,68,null }, { 65,15,null,null,null,null,null }, { 44,null,null,null,null,null,null }, { 83,28,null,59,null,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Parla"),new String("Torres de la Alameda"),new String("Cercedilla"),new String("Colmenar Viejo"),new String("Los Santos de la Humosa"),new String("Navarredonda y San Mames"),new String("Carabana") },new Integer[][] { { null,87,48,null,19,null,null }, { 90,null,83,31,null,null,null }, { 6,null,null,null,null,null,null }, { null,15,null,null,15,68,null }, { 65,15,null,null,null,null,null }, { 44,null,null,null,null,null,null }, { 83,28,null,59,null,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_40")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_41 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_41") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_41")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Rivas-Vaciamadrid"),new String("Estremera"),new String("Villanueva de Perales"),new String("Soto del Real"),new String("La Hiruela"),new String("Quijorna"),new String("Villamanrique de Tajo") },new Integer[][] { { null,null,74,null,null,null,null }, { 24,null,null,null,null,null,41 }, { 30,63,null,null,null,null,null }, { 100,36,100,null,null,23,null }, { 40,null,40,6,null,6,null }, { 60,null,null,null,null,null,null }, { 42,53,null,null,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Rivas-Vaciamadrid"),new String("Estremera"),new String("Villanueva de Perales"),new String("Soto del Real"),new String("La Hiruela"),new String("Quijorna"),new String("Villamanrique de Tajo") },new Integer[][] { { null,null,74,null,null,null,null }, { 24,null,null,null,null,null,41 }, { 30,63,null,null,null,null,null }, { 100,36,100,null,null,23,null }, { 40,null,40,6,null,6,null }, { 60,null,null,null,null,null,null }, { 42,53,null,null,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Rivas-Vaciamadrid"),new String("Estremera"),new String("Villanueva de Perales"),new String("Soto del Real"),new String("La Hiruela"),new String("Quijorna"),new String("Villamanrique de Tajo") },new Integer[][] { { null,null,74,null,null,null,null }, { 24,null,null,null,null,null,41 }, { 30,63,null,null,null,null,null }, { 100,36,100,null,null,23,null }, { 40,null,40,6,null,6,null }, { 60,null,null,null,null,null,null }, { 42,53,null,null,null,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Rivas-Vaciamadrid"),new String("Estremera"),new String("Villanueva de Perales"),new String("Soto del Real"),new String("La Hiruela"),new String("Quijorna"),new String("Villamanrique de Tajo") },new Integer[][] { { null,null,74,null,null,null,null }, { 24,null,null,null,null,null,41 }, { 30,63,null,null,null,null,null }, { 100,36,100,null,null,23,null }, { 40,null,40,6,null,6,null }, { 60,null,null,null,null,null,null }, { 42,53,null,null,null,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_41")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_42 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_42") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_42")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Camarma de Esteruelas"),new String("Moraleja de Enmedio"),new String("Horcajo de la Sierra-Aoslos"),new String("Garganta de los Montes"),new String("Hoyo de Manzanares"),new String("Rivas-Vaciamadrid"),new String("Galapagar"),new String("Santorcaz") },new Integer[][] { { null,null,null,null,null,null,null,null }, { 84,null,63,null,null,null,48,null }, { 96,null,null,null,null,null,43,null }, { 22,null,null,null,null,23,null,null }, { null,75,null,56,null,null,null,null }, { 56,82,null,88,null,null,null,null }, { 45,null,49,null,58,null,null,null }, { null,61,null,null,null,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Camarma de Esteruelas"),new String("Moraleja de Enmedio"),new String("Horcajo de la Sierra-Aoslos"),new String("Garganta de los Montes"),new String("Hoyo de Manzanares"),new String("Rivas-Vaciamadrid"),new String("Galapagar"),new String("Santorcaz") },new Integer[][] { { null,null,null,null,null,null,null,null }, { 84,null,63,null,null,null,48,null }, { 96,null,null,null,null,null,43,null }, { 22,null,null,null,null,23,null,null }, { null,75,null,56,null,null,null,null }, { 56,82,null,88,null,null,null,null }, { 45,null,49,null,58,null,null,null }, { null,61,null,null,null,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Camarma de Esteruelas"),new String("Moraleja de Enmedio"),new String("Horcajo de la Sierra-Aoslos"),new String("Garganta de los Montes"),new String("Hoyo de Manzanares"),new String("Rivas-Vaciamadrid"),new String("Galapagar"),new String("Santorcaz") },new Integer[][] { { null,null,null,null,null,null,null,null }, { 84,null,63,null,null,null,48,null }, { 96,null,null,null,null,null,43,null }, { 22,null,null,null,null,23,null,null }, { null,75,null,56,null,null,null,null }, { 56,82,null,88,null,null,null,null }, { 45,null,49,null,58,null,null,null }, { null,61,null,null,null,null,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Camarma de Esteruelas"),new String("Moraleja de Enmedio"),new String("Horcajo de la Sierra-Aoslos"),new String("Garganta de los Montes"),new String("Hoyo de Manzanares"),new String("Rivas-Vaciamadrid"),new String("Galapagar"),new String("Santorcaz") },new Integer[][] { { null,null,null,null,null,null,null,null }, { 84,null,63,null,null,null,48,null }, { 96,null,null,null,null,null,43,null }, { 22,null,null,null,null,23,null,null }, { null,75,null,56,null,null,null,null }, { 56,82,null,88,null,null,null,null }, { 45,null,49,null,58,null,null,null }, { null,61,null,null,null,null,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_42")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_43 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_43") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_43")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("El Berrueco"),new String("Daganzo de Arriba"),new String("Navacerrada"),new String("Hoyo de Manzanares"),new String("Paracuellos de Jarama"),new String("Montejo de la Sierra"),new String("Valdelaguna"),new String("Estremera") },new Integer[][] { { null,65,14,58,null,9,25,null }, { 71,null,86,null,null,null,null,null }, { 35,64,null,null,1,null,null,null }, { 67,null,63,null,null,null,null,null }, { 62,81,null,null,null,73,null,null }, { null,null,null,null,null,null,null,null }, { 54,17,null,null,null,null,null,null }, { null,83,null,81,null,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("El Berrueco"),new String("Daganzo de Arriba"),new String("Navacerrada"),new String("Hoyo de Manzanares"),new String("Paracuellos de Jarama"),new String("Montejo de la Sierra"),new String("Valdelaguna"),new String("Estremera") },new Integer[][] { { null,65,14,58,null,9,25,null }, { 71,null,86,null,null,null,null,null }, { 35,64,null,null,1,null,null,null }, { 67,null,63,null,null,null,null,null }, { 62,81,null,null,null,73,null,null }, { null,null,null,null,null,null,null,null }, { 54,17,null,null,null,null,null,null }, { null,83,null,81,null,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("El Berrueco"),new String("Daganzo de Arriba"),new String("Navacerrada"),new String("Hoyo de Manzanares"),new String("Paracuellos de Jarama"),new String("Montejo de la Sierra"),new String("Valdelaguna"),new String("Estremera") },new Integer[][] { { null,65,14,58,null,9,25,null }, { 71,null,86,null,null,null,null,null }, { 35,64,null,null,1,null,null,null }, { 67,null,63,null,null,null,null,null }, { 62,81,null,null,null,73,null,null }, { null,null,null,null,null,null,null,null }, { 54,17,null,null,null,null,null,null }, { null,83,null,81,null,null,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("El Berrueco"),new String("Daganzo de Arriba"),new String("Navacerrada"),new String("Hoyo de Manzanares"),new String("Paracuellos de Jarama"),new String("Montejo de la Sierra"),new String("Valdelaguna"),new String("Estremera") },new Integer[][] { { null,65,14,58,null,9,25,null }, { 71,null,86,null,null,null,null,null }, { 35,64,null,null,1,null,null,null }, { 67,null,63,null,null,null,null,null }, { 62,81,null,null,null,73,null,null }, { null,null,null,null,null,null,null,null }, { 54,17,null,null,null,null,null,null }, { null,83,null,81,null,null,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_43")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_44 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_44") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_44")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Navalafuente"),new String("Cenicientos"),new String("Guadalix de la Sierra"),new String("Lozoya"),new String("Batres"),new String("Navarredonda y San Mames"),new String("Los Molinos"),new String("Villavieja del Lozoya") },new Integer[][] { { null,null,83,null,null,20,null,null }, { null,null,46,75,45,74,null,51 }, { null,null,null,null,null,68,29,null }, { 81,null,null,null,null,null,49,null }, { 20,30,null,null,null,null,null,null }, { 43,null,null,39,null,null,69,null }, { null,6,null,null,null,null,null,null }, { 26,6,null,16,null,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Navalafuente"),new String("Cenicientos"),new String("Guadalix de la Sierra"),new String("Lozoya"),new String("Batres"),new String("Navarredonda y San Mames"),new String("Los Molinos"),new String("Villavieja del Lozoya") },new Integer[][] { { null,null,83,null,null,20,null,null }, { null,null,46,75,45,74,null,51 }, { null,null,null,null,null,68,29,null }, { 81,null,null,null,null,null,49,null }, { 20,30,null,null,null,null,null,null }, { 43,null,null,39,null,null,69,null }, { null,6,null,null,null,null,null,null }, { 26,6,null,16,null,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Navalafuente"),new String("Cenicientos"),new String("Guadalix de la Sierra"),new String("Lozoya"),new String("Batres"),new String("Navarredonda y San Mames"),new String("Los Molinos"),new String("Villavieja del Lozoya") },new Integer[][] { { null,null,83,null,null,20,null,null }, { null,null,46,75,45,74,null,51 }, { null,null,null,null,null,68,29,null }, { 81,null,null,null,null,null,49,null }, { 20,30,null,null,null,null,null,null }, { 43,null,null,39,null,null,69,null }, { null,6,null,null,null,null,null,null }, { 26,6,null,16,null,null,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Navalafuente"),new String("Cenicientos"),new String("Guadalix de la Sierra"),new String("Lozoya"),new String("Batres"),new String("Navarredonda y San Mames"),new String("Los Molinos"),new String("Villavieja del Lozoya") },new Integer[][] { { null,null,83,null,null,20,null,null }, { null,null,46,75,45,74,null,51 }, { null,null,null,null,null,68,29,null }, { 81,null,null,null,null,null,49,null }, { 20,30,null,null,null,null,null,null }, { 43,null,null,39,null,null,69,null }, { null,6,null,null,null,null,null,null }, { 26,6,null,16,null,null,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_44")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_45 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_45") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_45")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Navalagamella"),new String("Villanueva de la Canada"),new String("Valverde de Alcala"),new String("Orusco de Tajuna"),new String("El Berrueco"),new String("Fresnedillas de la Oliva"),new String("Brunete"),new String("Alcorcon") },new Integer[][] { { null,59,83,34,null,25,null,null }, { 16,null,null,25,64,43,null,null }, { 92,65,null,95,null,null,null,null }, { 12,44,62,null,null,10,null,null }, { 97,21,2,80,null,12,51,null }, { 15,98,47,51,null,null,null,null }, { 2,22,1,3,10,44,null,null }, { 10,67,18,null,65,34,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Navalagamella"),new String("Villanueva de la Canada"),new String("Valverde de Alcala"),new String("Orusco de Tajuna"),new String("El Berrueco"),new String("Fresnedillas de la Oliva"),new String("Brunete"),new String("Alcorcon") },new Integer[][] { { null,59,83,34,null,25,null,null }, { 16,null,null,25,64,43,null,null }, { 92,65,null,95,null,null,null,null }, { 12,44,62,null,null,10,null,null }, { 97,21,2,80,null,12,51,null }, { 15,98,47,51,null,null,null,null }, { 2,22,1,3,10,44,null,null }, { 10,67,18,null,65,34,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Navalagamella"),new String("Villanueva de la Canada"),new String("Valverde de Alcala"),new String("Orusco de Tajuna"),new String("El Berrueco"),new String("Fresnedillas de la Oliva"),new String("Brunete"),new String("Alcorcon") },new Integer[][] { { null,59,83,34,null,25,null,null }, { 16,null,null,25,64,43,null,null }, { 92,65,null,95,null,null,null,null }, { 12,44,62,null,null,10,null,null }, { 97,21,2,80,null,12,51,null }, { 15,98,47,51,null,null,null,null }, { 2,22,1,3,10,44,null,null }, { 10,67,18,null,65,34,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Navalagamella"),new String("Villanueva de la Canada"),new String("Valverde de Alcala"),new String("Orusco de Tajuna"),new String("El Berrueco"),new String("Fresnedillas de la Oliva"),new String("Brunete"),new String("Alcorcon") },new Integer[][] { { null,59,83,34,null,25,null,null }, { 16,null,null,25,64,43,null,null }, { 92,65,null,95,null,null,null,null }, { 12,44,62,null,null,10,null,null }, { 97,21,2,80,null,12,51,null }, { 15,98,47,51,null,null,null,null }, { 2,22,1,3,10,44,null,null }, { 10,67,18,null,65,34,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_45")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_46 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_46") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_46")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Pedrezuela"),new String("Cubas de la Sagra"),new String("Buitrago del Lozoya"),new String("Alcala de Henares"),new String("Quijorna"),new String("El Alamo"),new String("Parla"),new String("Torremocha de Jarama") },new Integer[][] { { null,79,46,37,null,null,null,null }, { 43,null,83,null,null,99,null,null }, { 73,52,null,null,null,null,null,null }, { 68,39,null,null,36,72,null,null }, { 51,47,null,64,null,null,null,null }, { 97,22,73,null,null,null,null,10 }, { 83,29,null,19,null,null,null,null }, { 25,100,null,62,null,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Pedrezuela"),new String("Cubas de la Sagra"),new String("Buitrago del Lozoya"),new String("Alcala de Henares"),new String("Quijorna"),new String("El Alamo"),new String("Parla"),new String("Torremocha de Jarama") },new Integer[][] { { null,79,46,37,null,null,null,null }, { 43,null,83,null,null,99,null,null }, { 73,52,null,null,null,null,null,null }, { 68,39,null,null,36,72,null,null }, { 51,47,null,64,null,null,null,null }, { 97,22,73,null,null,null,null,10 }, { 83,29,null,19,null,null,null,null }, { 25,100,null,62,null,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Pedrezuela"),new String("Cubas de la Sagra"),new String("Buitrago del Lozoya"),new String("Alcala de Henares"),new String("Quijorna"),new String("El Alamo"),new String("Parla"),new String("Torremocha de Jarama") },new Integer[][] { { null,79,46,37,null,null,null,null }, { 43,null,83,null,null,99,null,null }, { 73,52,null,null,null,null,null,null }, { 68,39,null,null,36,72,null,null }, { 51,47,null,64,null,null,null,null }, { 97,22,73,null,null,null,null,10 }, { 83,29,null,19,null,null,null,null }, { 25,100,null,62,null,null,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Pedrezuela"),new String("Cubas de la Sagra"),new String("Buitrago del Lozoya"),new String("Alcala de Henares"),new String("Quijorna"),new String("El Alamo"),new String("Parla"),new String("Torremocha de Jarama") },new Integer[][] { { null,79,46,37,null,null,null,null }, { 43,null,83,null,null,99,null,null }, { 73,52,null,null,null,null,null,null }, { 68,39,null,null,36,72,null,null }, { 51,47,null,64,null,null,null,null }, { 97,22,73,null,null,null,null,10 }, { 83,29,null,19,null,null,null,null }, { 25,100,null,62,null,null,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_46")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_47 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_47") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_47")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Pinuecar-Gandullas"),new String("Valdelaguna"),new String("Gargantilla del Lozoya y Pinilla de Buitrago"),new String("Tielmes"),new String("Quijorna"),new String("Pinilla del Valle"),new String("Madrid"),new String("Villanueva del Pardillo") },new Integer[][] { { null,null,null,null,null,null,null,11 }, { 3,null,null,null,63,35,null,null }, { 26,50,null,null,null,null,null,null }, { 8,54,32,null,null,null,null,null }, { null,64,null,null,null,null,null,19 }, { 33,null,80,null,null,null,null,null }, { 40,10,null,null,null,36,null,null }, { 31,91,null,65,null,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Pinuecar-Gandullas"),new String("Valdelaguna"),new String("Gargantilla del Lozoya y Pinilla de Buitrago"),new String("Tielmes"),new String("Quijorna"),new String("Pinilla del Valle"),new String("Madrid"),new String("Villanueva del Pardillo") },new Integer[][] { { null,null,null,null,null,null,null,11 }, { 3,null,null,null,63,35,null,null }, { 26,50,null,null,null,null,null,null }, { 8,54,32,null,null,null,null,null }, { null,64,null,null,null,null,null,19 }, { 33,null,80,null,null,null,null,null }, { 40,10,null,null,null,36,null,null }, { 31,91,null,65,null,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Pinuecar-Gandullas"),new String("Valdelaguna"),new String("Gargantilla del Lozoya y Pinilla de Buitrago"),new String("Tielmes"),new String("Quijorna"),new String("Pinilla del Valle"),new String("Madrid"),new String("Villanueva del Pardillo") },new Integer[][] { { null,null,null,null,null,null,null,11 }, { 3,null,null,null,63,35,null,null }, { 26,50,null,null,null,null,null,null }, { 8,54,32,null,null,null,null,null }, { null,64,null,null,null,null,null,19 }, { 33,null,80,null,null,null,null,null }, { 40,10,null,null,null,36,null,null }, { 31,91,null,65,null,null,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Pinuecar-Gandullas"),new String("Valdelaguna"),new String("Gargantilla del Lozoya y Pinilla de Buitrago"),new String("Tielmes"),new String("Quijorna"),new String("Pinilla del Valle"),new String("Madrid"),new String("Villanueva del Pardillo") },new Integer[][] { { null,null,null,null,null,null,null,11 }, { 3,null,null,null,63,35,null,null }, { 26,50,null,null,null,null,null,null }, { 8,54,32,null,null,null,null,null }, { null,64,null,null,null,null,null,19 }, { 33,null,80,null,null,null,null,null }, { 40,10,null,null,null,36,null,null }, { 31,91,null,65,null,null,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_47")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_48 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_48") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_48")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Arroyomolinos"),new String("Torrejon de la Calzada"),new String("San Martin de Valdeiglesias"),new String("Villanueva de la Canada"),new String("Pinto"),new String("Pozuelo de Alarcon"),new String("Daganzo de Arriba"),new String("Moralzarzal"),new String("Cobena") },new Integer[][] { { null,61,11,null,null,null,29,null,null }, { 61,null,31,39,56,null,null,null,null }, { 13,3,null,71,null,null,null,null,null }, { 45,64,50,null,null,null,null,null,null }, { 43,55,82,63,null,10,null,null,null }, { 68,78,null,19,39,null,null,18,null }, { 2,20,null,null,13,null,null,null,null }, { 67,17,29,null,null,null,null,null,null }, { 7,4,68,88,50,null,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Arroyomolinos"),new String("Torrejon de la Calzada"),new String("San Martin de Valdeiglesias"),new String("Villanueva de la Canada"),new String("Pinto"),new String("Pozuelo de Alarcon"),new String("Daganzo de Arriba"),new String("Moralzarzal"),new String("Cobena") },new Integer[][] { { null,61,11,null,null,null,29,null,null }, { 61,null,31,39,56,null,null,null,null }, { 13,3,null,71,null,null,null,null,null }, { 45,64,50,null,null,null,null,null,null }, { 43,55,82,63,null,10,null,null,null }, { 68,78,null,19,39,null,null,18,null }, { 2,20,null,null,13,null,null,null,null }, { 67,17,29,null,null,null,null,null,null }, { 7,4,68,88,50,null,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Arroyomolinos"),new String("Torrejon de la Calzada"),new String("San Martin de Valdeiglesias"),new String("Villanueva de la Canada"),new String("Pinto"),new String("Pozuelo de Alarcon"),new String("Daganzo de Arriba"),new String("Moralzarzal"),new String("Cobena") },new Integer[][] { { null,61,11,null,null,null,29,null,null }, { 61,null,31,39,56,null,null,null,null }, { 13,3,null,71,null,null,null,null,null }, { 45,64,50,null,null,null,null,null,null }, { 43,55,82,63,null,10,null,null,null }, { 68,78,null,19,39,null,null,18,null }, { 2,20,null,null,13,null,null,null,null }, { 67,17,29,null,null,null,null,null,null }, { 7,4,68,88,50,null,null,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Arroyomolinos"),new String("Torrejon de la Calzada"),new String("San Martin de Valdeiglesias"),new String("Villanueva de la Canada"),new String("Pinto"),new String("Pozuelo de Alarcon"),new String("Daganzo de Arriba"),new String("Moralzarzal"),new String("Cobena") },new Integer[][] { { null,61,11,null,null,null,29,null,null }, { 61,null,31,39,56,null,null,null,null }, { 13,3,null,71,null,null,null,null,null }, { 45,64,50,null,null,null,null,null,null }, { 43,55,82,63,null,10,null,null,null }, { 68,78,null,19,39,null,null,18,null }, { 2,20,null,null,13,null,null,null,null }, { 67,17,29,null,null,null,null,null,null }, { 7,4,68,88,50,null,null,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_48")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_49 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_49") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_49")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Miraflores de la Sierra"),new String("Guadarrama"),new String("Buitrago del Lozoya"),new String("Carabana"),new String("Pozuelo del Rey"),new String("Alcala de Henares"),new String("San Agustin del Guadalix"),new String("Robregordo"),new String("Orusco de Tajuna") },new Integer[][] { { null,19,null,null,null,96,null,null,51 }, { 53,null,null,null,6,3,82,null,null }, { 59,null,null,47,null,null,null,null,null }, { null,null,null,null,40,null,96,null,null }, { 66,null,null,null,null,null,null,null,null }, { 62,null,null,null,40,null,null,null,31 }, { 44,42,null,null,null,null,null,null,null }, { null,null,null,88,null,null,null,null,null }, { 24,null,null,28,null,null,null,60,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Miraflores de la Sierra"),new String("Guadarrama"),new String("Buitrago del Lozoya"),new String("Carabana"),new String("Pozuelo del Rey"),new String("Alcala de Henares"),new String("San Agustin del Guadalix"),new String("Robregordo"),new String("Orusco de Tajuna") },new Integer[][] { { null,19,null,null,null,96,null,null,51 }, { 53,null,null,null,6,3,82,null,null }, { 59,null,null,47,null,null,null,null,null }, { null,null,null,null,40,null,96,null,null }, { 66,null,null,null,null,null,null,null,null }, { 62,null,null,null,40,null,null,null,31 }, { 44,42,null,null,null,null,null,null,null }, { null,null,null,88,null,null,null,null,null }, { 24,null,null,28,null,null,null,60,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Miraflores de la Sierra"),new String("Guadarrama"),new String("Buitrago del Lozoya"),new String("Carabana"),new String("Pozuelo del Rey"),new String("Alcala de Henares"),new String("San Agustin del Guadalix"),new String("Robregordo"),new String("Orusco de Tajuna") },new Integer[][] { { null,19,null,null,null,96,null,null,51 }, { 53,null,null,null,6,3,82,null,null }, { 59,null,null,47,null,null,null,null,null }, { null,null,null,null,40,null,96,null,null }, { 66,null,null,null,null,null,null,null,null }, { 62,null,null,null,40,null,null,null,31 }, { 44,42,null,null,null,null,null,null,null }, { null,null,null,88,null,null,null,null,null }, { 24,null,null,28,null,null,null,60,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Miraflores de la Sierra"),new String("Guadarrama"),new String("Buitrago del Lozoya"),new String("Carabana"),new String("Pozuelo del Rey"),new String("Alcala de Henares"),new String("San Agustin del Guadalix"),new String("Robregordo"),new String("Orusco de Tajuna") },new Integer[][] { { null,19,null,null,null,96,null,null,51 }, { 53,null,null,null,6,3,82,null,null }, { 59,null,null,47,null,null,null,null,null }, { null,null,null,null,40,null,96,null,null }, { 66,null,null,null,null,null,null,null,null }, { 62,null,null,null,40,null,null,null,31 }, { 44,42,null,null,null,null,null,null,null }, { null,null,null,88,null,null,null,null,null }, { 24,null,null,28,null,null,null,60,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_49")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_50 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_50") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_50")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Olmeda de las Fuentes"),new String("San Lorenzo de El Escorial"),new String("Navarredonda y San Mames"),new String("Brunete"),new String("Grinon"),new String("Tielmes"),new String("Reduena"),new String("Cercedilla"),new String("Aranjuez") },new Integer[][] { { null,null,88,null,11,14,null,null,null }, { 87,null,null,null,17,null,null,null,8 }, { 56,null,null,40,null,87,null,null,null }, { 31,null,null,null,null,null,80,null,null }, { 25,32,null,null,null,null,null,90,null }, { null,23,null,null,null,null,null,null,null }, { null,null,null,null,null,null,null,null,67 }, { 11,null,null,null,null,null,null,null,null }, { null,null,null,null,null,null,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Olmeda de las Fuentes"),new String("San Lorenzo de El Escorial"),new String("Navarredonda y San Mames"),new String("Brunete"),new String("Grinon"),new String("Tielmes"),new String("Reduena"),new String("Cercedilla"),new String("Aranjuez") },new Integer[][] { { null,null,88,null,11,14,null,null,null }, { 87,null,null,null,17,null,null,null,8 }, { 56,null,null,40,null,87,null,null,null }, { 31,null,null,null,null,null,80,null,null }, { 25,32,null,null,null,null,null,90,null }, { null,23,null,null,null,null,null,null,null }, { null,null,null,null,null,null,null,null,67 }, { 11,null,null,null,null,null,null,null,null }, { null,null,null,null,null,null,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Olmeda de las Fuentes"),new String("San Lorenzo de El Escorial"),new String("Navarredonda y San Mames"),new String("Brunete"),new String("Grinon"),new String("Tielmes"),new String("Reduena"),new String("Cercedilla"),new String("Aranjuez") },new Integer[][] { { null,null,88,null,11,14,null,null,null }, { 87,null,null,null,17,null,null,null,8 }, { 56,null,null,40,null,87,null,null,null }, { 31,null,null,null,null,null,80,null,null }, { 25,32,null,null,null,null,null,90,null }, { null,23,null,null,null,null,null,null,null }, { null,null,null,null,null,null,null,null,67 }, { 11,null,null,null,null,null,null,null,null }, { null,null,null,null,null,null,null,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Olmeda de las Fuentes"),new String("San Lorenzo de El Escorial"),new String("Navarredonda y San Mames"),new String("Brunete"),new String("Grinon"),new String("Tielmes"),new String("Reduena"),new String("Cercedilla"),new String("Aranjuez") },new Integer[][] { { null,null,88,null,11,14,null,null,null }, { 87,null,null,null,17,null,null,null,8 }, { 56,null,null,40,null,87,null,null,null }, { 31,null,null,null,null,null,80,null,null }, { 25,32,null,null,null,null,null,90,null }, { null,23,null,null,null,null,null,null,null }, { null,null,null,null,null,null,null,null,67 }, { 11,null,null,null,null,null,null,null,null }, { null,null,null,null,null,null,null,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_50")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_51 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_51") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_51")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Ribatejada"),new String("Buitrago del Lozoya"),new String("Cadalso de los Vidrios"),new String("Moralzarzal"),new String("Canencia"),new String("Titulcia"),new String("Villalbilla"),new String("Villanueva de la Canada"),new String("Somosierra") },new Integer[][] { { null,87,null,36,null,null,null,5,16 }, { null,null,null,12,25,null,null,null,null }, { 61,100,null,9,null,null,null,null,null }, { 78,47,46,null,null,null,73,null,null }, { null,null,null,null,null,69,null,null,70 }, { 57,61,100,null,null,null,61,null,null }, { 68,71,null,97,null,null,null,null,null }, { 16,null,null,null,null,null,null,null,null }, { null,50,null,null,null,null,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Ribatejada"),new String("Buitrago del Lozoya"),new String("Cadalso de los Vidrios"),new String("Moralzarzal"),new String("Canencia"),new String("Titulcia"),new String("Villalbilla"),new String("Villanueva de la Canada"),new String("Somosierra") },new Integer[][] { { null,87,null,36,null,null,null,5,16 }, { null,null,null,12,25,null,null,null,null }, { 61,100,null,9,null,null,null,null,null }, { 78,47,46,null,null,null,73,null,null }, { null,null,null,null,null,69,null,null,70 }, { 57,61,100,null,null,null,61,null,null }, { 68,71,null,97,null,null,null,null,null }, { 16,null,null,null,null,null,null,null,null }, { null,50,null,null,null,null,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Ribatejada"),new String("Buitrago del Lozoya"),new String("Cadalso de los Vidrios"),new String("Moralzarzal"),new String("Canencia"),new String("Titulcia"),new String("Villalbilla"),new String("Villanueva de la Canada"),new String("Somosierra") },new Integer[][] { { null,87,null,36,null,null,null,5,16 }, { null,null,null,12,25,null,null,null,null }, { 61,100,null,9,null,null,null,null,null }, { 78,47,46,null,null,null,73,null,null }, { null,null,null,null,null,69,null,null,70 }, { 57,61,100,null,null,null,61,null,null }, { 68,71,null,97,null,null,null,null,null }, { 16,null,null,null,null,null,null,null,null }, { null,50,null,null,null,null,null,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Ribatejada"),new String("Buitrago del Lozoya"),new String("Cadalso de los Vidrios"),new String("Moralzarzal"),new String("Canencia"),new String("Titulcia"),new String("Villalbilla"),new String("Villanueva de la Canada"),new String("Somosierra") },new Integer[][] { { null,87,null,36,null,null,null,5,16 }, { null,null,null,12,25,null,null,null,null }, { 61,100,null,9,null,null,null,null,null }, { 78,47,46,null,null,null,73,null,null }, { null,null,null,null,null,69,null,null,70 }, { 57,61,100,null,null,null,61,null,null }, { 68,71,null,97,null,null,null,null,null }, { 16,null,null,null,null,null,null,null,null }, { null,50,null,null,null,null,null,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_51")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_52 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_52") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_52")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Valdaracete"),new String("La Acebeda"),new String("Rivas-Vaciamadrid"),new String("Canencia"),new String("La Serna del Monte"),new String("Venturada"),new String("La Hiruela"),new String("La Cabrera"),new String("Valdemaqueda") },new Integer[][] { { null,10,null,null,null,62,null,null,null }, { null,null,36,null,null,null,null,null,null }, { 23,17,null,59,45,null,null,null,null }, { null,null,null,null,null,null,17,null,null }, { 10,null,null,null,null,null,null,null,null }, { 87,null,null,null,null,null,null,36,null }, { null,9,null,null,47,null,null,null,null }, { null,null,null,null,null,null,null,null,null }, { 76,34,null,null,null,null,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Valdaracete"),new String("La Acebeda"),new String("Rivas-Vaciamadrid"),new String("Canencia"),new String("La Serna del Monte"),new String("Venturada"),new String("La Hiruela"),new String("La Cabrera"),new String("Valdemaqueda") },new Integer[][] { { null,10,null,null,null,62,null,null,null }, { null,null,36,null,null,null,null,null,null }, { 23,17,null,59,45,null,null,null,null }, { null,null,null,null,null,null,17,null,null }, { 10,null,null,null,null,null,null,null,null }, { 87,null,null,null,null,null,null,36,null }, { null,9,null,null,47,null,null,null,null }, { null,null,null,null,null,null,null,null,null }, { 76,34,null,null,null,null,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Valdaracete"),new String("La Acebeda"),new String("Rivas-Vaciamadrid"),new String("Canencia"),new String("La Serna del Monte"),new String("Venturada"),new String("La Hiruela"),new String("La Cabrera"),new String("Valdemaqueda") },new Integer[][] { { null,10,null,null,null,62,null,null,null }, { null,null,36,null,null,null,null,null,null }, { 23,17,null,59,45,null,null,null,null }, { null,null,null,null,null,null,17,null,null }, { 10,null,null,null,null,null,null,null,null }, { 87,null,null,null,null,null,null,36,null }, { null,9,null,null,47,null,null,null,null }, { null,null,null,null,null,null,null,null,null }, { 76,34,null,null,null,null,null,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Valdaracete"),new String("La Acebeda"),new String("Rivas-Vaciamadrid"),new String("Canencia"),new String("La Serna del Monte"),new String("Venturada"),new String("La Hiruela"),new String("La Cabrera"),new String("Valdemaqueda") },new Integer[][] { { null,10,null,null,null,62,null,null,null }, { null,null,36,null,null,null,null,null,null }, { 23,17,null,59,45,null,null,null,null }, { null,null,null,null,null,null,17,null,null }, { 10,null,null,null,null,null,null,null,null }, { 87,null,null,null,null,null,null,36,null }, { null,9,null,null,47,null,null,null,null }, { null,null,null,null,null,null,null,null,null }, { 76,34,null,null,null,null,null,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_52")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_53 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_53") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_53")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Colmenar del Arroyo"),new String("Ambite"),new String("Velilla de San Antonio"),new String("Arroyomolinos"),new String("Manzanares el Real"),new String("Torremocha de Jarama"),new String("Navarredonda y San Mames"),new String("Lozoyuela-Navas-Sieteiglesias"),new String("Villar del Olmo"),new String("Cobena") },new Integer[][] { { null,53,78,58,1,null,25,81,null,null }, { 53,null,71,11,76,33,25,5,null,86 }, { 78,71,null,null,98,null,null,null,null,null }, { 58,11,null,null,null,50,null,null,null,null }, { 1,76,98,null,null,null,36,null,null,null }, { null,33,null,50,null,null,null,null,43,null }, { 25,25,null,null,36,null,null,null,29,null }, { 81,5,null,null,null,null,null,null,null,null }, { null,null,null,null,null,43,29,null,null,null }, { null,86,null,null,null,null,null,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Colmenar del Arroyo"),new String("Ambite"),new String("Velilla de San Antonio"),new String("Arroyomolinos"),new String("Manzanares el Real"),new String("Torremocha de Jarama"),new String("Navarredonda y San Mames"),new String("Lozoyuela-Navas-Sieteiglesias"),new String("Villar del Olmo"),new String("Cobena") },new Integer[][] { { null,53,78,58,1,null,25,81,null,null }, { 53,null,71,11,76,33,25,5,null,86 }, { 78,71,null,null,98,null,null,null,null,null }, { 58,11,null,null,null,50,null,null,null,null }, { 1,76,98,null,null,null,36,null,null,null }, { null,33,null,50,null,null,null,null,43,null }, { 25,25,null,null,36,null,null,null,29,null }, { 81,5,null,null,null,null,null,null,null,null }, { null,null,null,null,null,43,29,null,null,null }, { null,86,null,null,null,null,null,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Colmenar del Arroyo"),new String("Ambite"),new String("Velilla de San Antonio"),new String("Arroyomolinos"),new String("Manzanares el Real"),new String("Torremocha de Jarama"),new String("Navarredonda y San Mames"),new String("Lozoyuela-Navas-Sieteiglesias"),new String("Villar del Olmo"),new String("Cobena") },new Integer[][] { { null,53,78,58,1,null,25,81,null,null }, { 53,null,71,11,76,33,25,5,null,86 }, { 78,71,null,null,98,null,null,null,null,null }, { 58,11,null,null,null,50,null,null,null,null }, { 1,76,98,null,null,null,36,null,null,null }, { null,33,null,50,null,null,null,null,43,null }, { 25,25,null,null,36,null,null,null,29,null }, { 81,5,null,null,null,null,null,null,null,null }, { null,null,null,null,null,43,29,null,null,null }, { null,86,null,null,null,null,null,null,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Colmenar del Arroyo"),new String("Ambite"),new String("Velilla de San Antonio"),new String("Arroyomolinos"),new String("Manzanares el Real"),new String("Torremocha de Jarama"),new String("Navarredonda y San Mames"),new String("Lozoyuela-Navas-Sieteiglesias"),new String("Villar del Olmo"),new String("Cobena") },new Integer[][] { { null,53,78,58,1,null,25,81,null,null }, { 53,null,71,11,76,33,25,5,null,86 }, { 78,71,null,null,98,null,null,null,null,null }, { 58,11,null,null,null,50,null,null,null,null }, { 1,76,98,null,null,null,36,null,null,null }, { null,33,null,50,null,null,null,null,43,null }, { 25,25,null,null,36,null,null,null,29,null }, { 81,5,null,null,null,null,null,null,null,null }, { null,null,null,null,null,43,29,null,null,null }, { null,86,null,null,null,null,null,null,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_53")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_54 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_54") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_54")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Getafe"),new String("Villaconejos"),new String("Pozuelo de Alarcon"),new String("Casarrubuelos"),new String("San Fernando de Henares"),new String("La Serna del Monte"),new String("Fresnedillas de la Oliva"),new String("Coslada"),new String("Fuente el Saz de Jarama"),new String("Valdeolmos-Alalpardo") },new Integer[][] { { null,69,26,43,79,null,null,71,null,53 }, { 80,null,63,95,null,14,null,43,null,2 }, { 37,56,null,91,21,null,null,null,72,90 }, { 97,51,95,null,62,null,null,null,null,70 }, { 5,62,37,51,null,63,null,null,null,null }, { 84,5,97,65,81,null,null,55,null,56 }, { 7,45,18,64,9,null,null,null,null,null }, { 30,7,5,32,71,34,null,null,null,null }, { 7,7,8,53,60,80,null,null,null,null }, { 68,16,42,63,99,null,null,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Getafe"),new String("Villaconejos"),new String("Pozuelo de Alarcon"),new String("Casarrubuelos"),new String("San Fernando de Henares"),new String("La Serna del Monte"),new String("Fresnedillas de la Oliva"),new String("Coslada"),new String("Fuente el Saz de Jarama"),new String("Valdeolmos-Alalpardo") },new Integer[][] { { null,69,26,43,79,null,null,71,null,53 }, { 80,null,63,95,null,14,null,43,null,2 }, { 37,56,null,91,21,null,null,null,72,90 }, { 97,51,95,null,62,null,null,null,null,70 }, { 5,62,37,51,null,63,null,null,null,null }, { 84,5,97,65,81,null,null,55,null,56 }, { 7,45,18,64,9,null,null,null,null,null }, { 30,7,5,32,71,34,null,null,null,null }, { 7,7,8,53,60,80,null,null,null,null }, { 68,16,42,63,99,null,null,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Getafe"),new String("Villaconejos"),new String("Pozuelo de Alarcon"),new String("Casarrubuelos"),new String("San Fernando de Henares"),new String("La Serna del Monte"),new String("Fresnedillas de la Oliva"),new String("Coslada"),new String("Fuente el Saz de Jarama"),new String("Valdeolmos-Alalpardo") },new Integer[][] { { null,69,26,43,79,null,null,71,null,53 }, { 80,null,63,95,null,14,null,43,null,2 }, { 37,56,null,91,21,null,null,null,72,90 }, { 97,51,95,null,62,null,null,null,null,70 }, { 5,62,37,51,null,63,null,null,null,null }, { 84,5,97,65,81,null,null,55,null,56 }, { 7,45,18,64,9,null,null,null,null,null }, { 30,7,5,32,71,34,null,null,null,null }, { 7,7,8,53,60,80,null,null,null,null }, { 68,16,42,63,99,null,null,null,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Getafe"),new String("Villaconejos"),new String("Pozuelo de Alarcon"),new String("Casarrubuelos"),new String("San Fernando de Henares"),new String("La Serna del Monte"),new String("Fresnedillas de la Oliva"),new String("Coslada"),new String("Fuente el Saz de Jarama"),new String("Valdeolmos-Alalpardo") },new Integer[][] { { null,69,26,43,79,null,null,71,null,53 }, { 80,null,63,95,null,14,null,43,null,2 }, { 37,56,null,91,21,null,null,null,72,90 }, { 97,51,95,null,62,null,null,null,null,70 }, { 5,62,37,51,null,63,null,null,null,null }, { 84,5,97,65,81,null,null,55,null,56 }, { 7,45,18,64,9,null,null,null,null,null }, { 30,7,5,32,71,34,null,null,null,null }, { 7,7,8,53,60,80,null,null,null,null }, { 68,16,42,63,99,null,null,null,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_54")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_55 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_55") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_55")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Los Santos de la Humosa"),new String("Corpa"),new String("Collado Villalba"),new String("Patones"),new String("El Molar"),new String("Cenicientos"),new String("Torremocha de Jarama"),new String("Colmenar del Arroyo"),new String("Cadalso de los Vidrios"),new String("Anchuelo") },new Integer[][] { { null,11,38,92,36,null,null,null,null,null }, { 24,null,null,3,null,62,25,null,32,null }, { 34,80,null,null,38,29,null,null,null,null }, { 23,84,99,null,null,null,null,80,null,null }, { 71,42,38,null,null,51,null,null,null,null }, { 51,19,58,null,null,null,null,null,null,null }, { 20,84,76,null,null,null,null,null,null,null }, { 97,25,null,null,20,96,null,null,null,null }, { 81,27,null,84,9,50,28,null,null,null }, { 49,88,null,62,null,null,null,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Los Santos de la Humosa"),new String("Corpa"),new String("Collado Villalba"),new String("Patones"),new String("El Molar"),new String("Cenicientos"),new String("Torremocha de Jarama"),new String("Colmenar del Arroyo"),new String("Cadalso de los Vidrios"),new String("Anchuelo") },new Integer[][] { { null,11,38,92,36,null,null,null,null,null }, { 24,null,null,3,null,62,25,null,32,null }, { 34,80,null,null,38,29,null,null,null,null }, { 23,84,99,null,null,null,null,80,null,null }, { 71,42,38,null,null,51,null,null,null,null }, { 51,19,58,null,null,null,null,null,null,null }, { 20,84,76,null,null,null,null,null,null,null }, { 97,25,null,null,20,96,null,null,null,null }, { 81,27,null,84,9,50,28,null,null,null }, { 49,88,null,62,null,null,null,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Los Santos de la Humosa"),new String("Corpa"),new String("Collado Villalba"),new String("Patones"),new String("El Molar"),new String("Cenicientos"),new String("Torremocha de Jarama"),new String("Colmenar del Arroyo"),new String("Cadalso de los Vidrios"),new String("Anchuelo") },new Integer[][] { { null,11,38,92,36,null,null,null,null,null }, { 24,null,null,3,null,62,25,null,32,null }, { 34,80,null,null,38,29,null,null,null,null }, { 23,84,99,null,null,null,null,80,null,null }, { 71,42,38,null,null,51,null,null,null,null }, { 51,19,58,null,null,null,null,null,null,null }, { 20,84,76,null,null,null,null,null,null,null }, { 97,25,null,null,20,96,null,null,null,null }, { 81,27,null,84,9,50,28,null,null,null }, { 49,88,null,62,null,null,null,null,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Los Santos de la Humosa"),new String("Corpa"),new String("Collado Villalba"),new String("Patones"),new String("El Molar"),new String("Cenicientos"),new String("Torremocha de Jarama"),new String("Colmenar del Arroyo"),new String("Cadalso de los Vidrios"),new String("Anchuelo") },new Integer[][] { { null,11,38,92,36,null,null,null,null,null }, { 24,null,null,3,null,62,25,null,32,null }, { 34,80,null,null,38,29,null,null,null,null }, { 23,84,99,null,null,null,null,80,null,null }, { 71,42,38,null,null,51,null,null,null,null }, { 51,19,58,null,null,null,null,null,null,null }, { 20,84,76,null,null,null,null,null,null,null }, { 97,25,null,null,20,96,null,null,null,null }, { 81,27,null,84,9,50,28,null,null,null }, { 49,88,null,62,null,null,null,null,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_55")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_56 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_56") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_56")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Meco"),new String("Villaviciosa de Odon"),new String("Robledillo de la Jara"),new String("Torremocha de Jarama"),new String("Pelayos de la Presa"),new String("Getafe"),new String("Ambite"),new String("Rascafria"),new String("Los Molinos"),new String("La Acebeda") },new Integer[][] { { null,5,78,71,78,null,null,null,null,null }, { 99,null,null,40,null,null,null,83,89,null }, { 50,98,null,null,null,null,null,null,null,53 }, { 37,55,76,null,null,null,null,null,21,4 }, { 41,83,21,46,null,50,null,null,null,36 }, { 33,51,4,3,74,null,null,29,null,null }, { 30,60,67,78,null,null,null,null,null,null }, { 57,95,12,65,null,null,null,null,null,null }, { 90,41,52,4,null,null,null,null,null,null }, { 99,92,90,null,null,null,null,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Meco"),new String("Villaviciosa de Odon"),new String("Robledillo de la Jara"),new String("Torremocha de Jarama"),new String("Pelayos de la Presa"),new String("Getafe"),new String("Ambite"),new String("Rascafria"),new String("Los Molinos"),new String("La Acebeda") },new Integer[][] { { null,5,78,71,78,null,null,null,null,null }, { 99,null,null,40,null,null,null,83,89,null }, { 50,98,null,null,null,null,null,null,null,53 }, { 37,55,76,null,null,null,null,null,21,4 }, { 41,83,21,46,null,50,null,null,null,36 }, { 33,51,4,3,74,null,null,29,null,null }, { 30,60,67,78,null,null,null,null,null,null }, { 57,95,12,65,null,null,null,null,null,null }, { 90,41,52,4,null,null,null,null,null,null }, { 99,92,90,null,null,null,null,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Meco"),new String("Villaviciosa de Odon"),new String("Robledillo de la Jara"),new String("Torremocha de Jarama"),new String("Pelayos de la Presa"),new String("Getafe"),new String("Ambite"),new String("Rascafria"),new String("Los Molinos"),new String("La Acebeda") },new Integer[][] { { null,5,78,71,78,null,null,null,null,null }, { 99,null,null,40,null,null,null,83,89,null }, { 50,98,null,null,null,null,null,null,null,53 }, { 37,55,76,null,null,null,null,null,21,4 }, { 41,83,21,46,null,50,null,null,null,36 }, { 33,51,4,3,74,null,null,29,null,null }, { 30,60,67,78,null,null,null,null,null,null }, { 57,95,12,65,null,null,null,null,null,null }, { 90,41,52,4,null,null,null,null,null,null }, { 99,92,90,null,null,null,null,null,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Meco"),new String("Villaviciosa de Odon"),new String("Robledillo de la Jara"),new String("Torremocha de Jarama"),new String("Pelayos de la Presa"),new String("Getafe"),new String("Ambite"),new String("Rascafria"),new String("Los Molinos"),new String("La Acebeda") },new Integer[][] { { null,5,78,71,78,null,null,null,null,null }, { 99,null,null,40,null,null,null,83,89,null }, { 50,98,null,null,null,null,null,null,null,53 }, { 37,55,76,null,null,null,null,null,21,4 }, { 41,83,21,46,null,50,null,null,null,36 }, { 33,51,4,3,74,null,null,29,null,null }, { 30,60,67,78,null,null,null,null,null,null }, { 57,95,12,65,null,null,null,null,null,null }, { 90,41,52,4,null,null,null,null,null,null }, { 99,92,90,null,null,null,null,null,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_56")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_57 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_57") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_57")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Pozuelo de Alarcon"),new String("Rascafria"),new String("Quijorna"),new String("Corpa"),new String("Villaviciosa de Odon"),new String("Venturada"),new String("Valdeavero"),new String("Cobena"),new String("Gargantilla del Lozoya y Pinilla de Buitrago"),new String("Majadahonda") },new Integer[][] { { null,14,null,null,null,null,null,null,null,null }, { 41,null,14,null,20,null,null,null,null,null }, { 24,74,null,null,null,null,null,null,14,null }, { 30,19,null,null,null,null,52,null,null,null }, { 7,17,null,null,null,null,null,null,null,null }, { 31,83,null,null,null,null,null,85,null,null }, { 30,43,null,null,null,null,null,null,null,null }, { 22,26,null,86,13,null,null,null,54,null }, { 12,35,74,null,50,null,92,null,null,null }, { 31,69,49,null,null,30,null,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Pozuelo de Alarcon"),new String("Rascafria"),new String("Quijorna"),new String("Corpa"),new String("Villaviciosa de Odon"),new String("Venturada"),new String("Valdeavero"),new String("Cobena"),new String("Gargantilla del Lozoya y Pinilla de Buitrago"),new String("Majadahonda") },new Integer[][] { { null,14,null,null,null,null,null,null,null,null }, { 41,null,14,null,20,null,null,null,null,null }, { 24,74,null,null,null,null,null,null,14,null }, { 30,19,null,null,null,null,52,null,null,null }, { 7,17,null,null,null,null,null,null,null,null }, { 31,83,null,null,null,null,null,85,null,null }, { 30,43,null,null,null,null,null,null,null,null }, { 22,26,null,86,13,null,null,null,54,null }, { 12,35,74,null,50,null,92,null,null,null }, { 31,69,49,null,null,30,null,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Pozuelo de Alarcon"),new String("Rascafria"),new String("Quijorna"),new String("Corpa"),new String("Villaviciosa de Odon"),new String("Venturada"),new String("Valdeavero"),new String("Cobena"),new String("Gargantilla del Lozoya y Pinilla de Buitrago"),new String("Majadahonda") },new Integer[][] { { null,14,null,null,null,null,null,null,null,null }, { 41,null,14,null,20,null,null,null,null,null }, { 24,74,null,null,null,null,null,null,14,null }, { 30,19,null,null,null,null,52,null,null,null }, { 7,17,null,null,null,null,null,null,null,null }, { 31,83,null,null,null,null,null,85,null,null }, { 30,43,null,null,null,null,null,null,null,null }, { 22,26,null,86,13,null,null,null,54,null }, { 12,35,74,null,50,null,92,null,null,null }, { 31,69,49,null,null,30,null,null,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Pozuelo de Alarcon"),new String("Rascafria"),new String("Quijorna"),new String("Corpa"),new String("Villaviciosa de Odon"),new String("Venturada"),new String("Valdeavero"),new String("Cobena"),new String("Gargantilla del Lozoya y Pinilla de Buitrago"),new String("Majadahonda") },new Integer[][] { { null,14,null,null,null,null,null,null,null,null }, { 41,null,14,null,20,null,null,null,null,null }, { 24,74,null,null,null,null,null,null,14,null }, { 30,19,null,null,null,null,52,null,null,null }, { 7,17,null,null,null,null,null,null,null,null }, { 31,83,null,null,null,null,null,85,null,null }, { 30,43,null,null,null,null,null,null,null,null }, { 22,26,null,86,13,null,null,null,54,null }, { 12,35,74,null,50,null,92,null,null,null }, { 31,69,49,null,null,30,null,null,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_57")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_58 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_58") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_58")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Robledo de Chavela"),new String("Torres de la Alameda"),new String("Getafe"),new String("Chapineria"),new String("Cubas de la Sagra"),new String("Carabana"),new String("Perales de Tajuna"),new String("Fresno de Torote"),new String("Villamantilla"),new String("El Molar") },new Integer[][] { { null,80,null,null,88,94,null,null,null,null }, { 42,null,null,null,70,null,null,83,null,92 }, { 28,3,null,null,null,null,null,null,71,null }, { 44,17,null,null,null,69,null,null,null,null }, { 32,71,45,60,null,null,null,null,null,null }, { 79,32,90,null,null,null,null,null,null,null }, { 52,99,null,null,34,89,null,10,null,null }, { 63,100,null,null,null,null,null,null,null,null }, { 39,null,null,null,null,null,null,null,null,null }, { 39,95,null,null,null,null,null,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Robledo de Chavela"),new String("Torres de la Alameda"),new String("Getafe"),new String("Chapineria"),new String("Cubas de la Sagra"),new String("Carabana"),new String("Perales de Tajuna"),new String("Fresno de Torote"),new String("Villamantilla"),new String("El Molar") },new Integer[][] { { null,80,null,null,88,94,null,null,null,null }, { 42,null,null,null,70,null,null,83,null,92 }, { 28,3,null,null,null,null,null,null,71,null }, { 44,17,null,null,null,69,null,null,null,null }, { 32,71,45,60,null,null,null,null,null,null }, { 79,32,90,null,null,null,null,null,null,null }, { 52,99,null,null,34,89,null,10,null,null }, { 63,100,null,null,null,null,null,null,null,null }, { 39,null,null,null,null,null,null,null,null,null }, { 39,95,null,null,null,null,null,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Robledo de Chavela"),new String("Torres de la Alameda"),new String("Getafe"),new String("Chapineria"),new String("Cubas de la Sagra"),new String("Carabana"),new String("Perales de Tajuna"),new String("Fresno de Torote"),new String("Villamantilla"),new String("El Molar") },new Integer[][] { { null,80,null,null,88,94,null,null,null,null }, { 42,null,null,null,70,null,null,83,null,92 }, { 28,3,null,null,null,null,null,null,71,null }, { 44,17,null,null,null,69,null,null,null,null }, { 32,71,45,60,null,null,null,null,null,null }, { 79,32,90,null,null,null,null,null,null,null }, { 52,99,null,null,34,89,null,10,null,null }, { 63,100,null,null,null,null,null,null,null,null }, { 39,null,null,null,null,null,null,null,null,null }, { 39,95,null,null,null,null,null,null,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Robledo de Chavela"),new String("Torres de la Alameda"),new String("Getafe"),new String("Chapineria"),new String("Cubas de la Sagra"),new String("Carabana"),new String("Perales de Tajuna"),new String("Fresno de Torote"),new String("Villamantilla"),new String("El Molar") },new Integer[][] { { null,80,null,null,88,94,null,null,null,null }, { 42,null,null,null,70,null,null,83,null,92 }, { 28,3,null,null,null,null,null,null,71,null }, { 44,17,null,null,null,69,null,null,null,null }, { 32,71,45,60,null,null,null,null,null,null }, { 79,32,90,null,null,null,null,null,null,null }, { 52,99,null,null,34,89,null,10,null,null }, { 63,100,null,null,null,null,null,null,null,null }, { 39,null,null,null,null,null,null,null,null,null }, { 39,95,null,null,null,null,null,null,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_58")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_59 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_59") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_59")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Somosierra"),new String("Torrejon de la Calzada"),new String("Cabanillas de la Sierra"),new String("Cubas de la Sagra"),new String("Valdetorres de Jarama"),new String("El Berrueco"),new String("Chinchon"),new String("Madarcos"),new String("Pinuecar-Gandullas"),new String("Patones") },new Integer[][] { { null,44,6,34,52,5,6,9,2,59 }, { 44,null,32,15,null,null,14,69,75,35 }, { 6,32,null,39,null,null,25,75,null,null }, { 34,15,39,null,null,28,null,null,97,null }, { 52,null,null,null,null,null,null,null,null,null }, { 5,null,null,28,null,null,null,96,null,null }, { 6,14,25,null,null,null,null,null,null,null }, { 9,69,75,null,null,96,null,null,null,null }, { 2,75,null,97,null,null,null,null,null,null }, { 59,35,null,null,null,null,null,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Somosierra"),new String("Torrejon de la Calzada"),new String("Cabanillas de la Sierra"),new String("Cubas de la Sagra"),new String("Valdetorres de Jarama"),new String("El Berrueco"),new String("Chinchon"),new String("Madarcos"),new String("Pinuecar-Gandullas"),new String("Patones") },new Integer[][] { { null,44,6,34,52,5,6,9,2,59 }, { 44,null,32,15,null,null,14,69,75,35 }, { 6,32,null,39,null,null,25,75,null,null }, { 34,15,39,null,null,28,null,null,97,null }, { 52,null,null,null,null,null,null,null,null,null }, { 5,null,null,28,null,null,null,96,null,null }, { 6,14,25,null,null,null,null,null,null,null }, { 9,69,75,null,null,96,null,null,null,null }, { 2,75,null,97,null,null,null,null,null,null }, { 59,35,null,null,null,null,null,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Somosierra"),new String("Torrejon de la Calzada"),new String("Cabanillas de la Sierra"),new String("Cubas de la Sagra"),new String("Valdetorres de Jarama"),new String("El Berrueco"),new String("Chinchon"),new String("Madarcos"),new String("Pinuecar-Gandullas"),new String("Patones") },new Integer[][] { { null,44,6,34,52,5,6,9,2,59 }, { 44,null,32,15,null,null,14,69,75,35 }, { 6,32,null,39,null,null,25,75,null,null }, { 34,15,39,null,null,28,null,null,97,null }, { 52,null,null,null,null,null,null,null,null,null }, { 5,null,null,28,null,null,null,96,null,null }, { 6,14,25,null,null,null,null,null,null,null }, { 9,69,75,null,null,96,null,null,null,null }, { 2,75,null,97,null,null,null,null,null,null }, { 59,35,null,null,null,null,null,null,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Somosierra"),new String("Torrejon de la Calzada"),new String("Cabanillas de la Sierra"),new String("Cubas de la Sagra"),new String("Valdetorres de Jarama"),new String("El Berrueco"),new String("Chinchon"),new String("Madarcos"),new String("Pinuecar-Gandullas"),new String("Patones") },new Integer[][] { { null,44,6,34,52,5,6,9,2,59 }, { 44,null,32,15,null,null,14,69,75,35 }, { 6,32,null,39,null,null,25,75,null,null }, { 34,15,39,null,null,28,null,null,97,null }, { 52,null,null,null,null,null,null,null,null,null }, { 5,null,null,28,null,null,null,96,null,null }, { 6,14,25,null,null,null,null,null,null,null }, { 9,69,75,null,null,96,null,null,null,null }, { 2,75,null,97,null,null,null,null,null,null }, { 59,35,null,null,null,null,null,null,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_59")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_60 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_60") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_60")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Torres de la Alameda"),new String("Torremocha de Jarama"),new String("Valdepielagos"),new String("Alpedrete"),new String("Valdemaqueda"),new String("Zarzalejo"),new String("Leganes"),new String("Villaconejos"),new String("Mejorada del Campo"),new String("Torrelaguna") },new Integer[][] { { null,24,16,12,86,3,null,null,null,null }, { 50,null,9,29,25,47,null,null,77,null }, { 12,2,null,32,99,null,null,null,null,null }, { 68,79,1,null,77,74,null,69,31,null }, { 12,29,30,85,null,68,5,80,null,null }, { 26,76,30,31,54,null,null,null,null,null }, { 30,92,26,37,null,null,null,13,null,null }, { 88,97,78,84,86,47,null,null,null,null }, { 77,15,98,62,null,null,null,93,null,null }, { 12,13,87,34,92,null,null,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Torres de la Alameda"),new String("Torremocha de Jarama"),new String("Valdepielagos"),new String("Alpedrete"),new String("Valdemaqueda"),new String("Zarzalejo"),new String("Leganes"),new String("Villaconejos"),new String("Mejorada del Campo"),new String("Torrelaguna") },new Integer[][] { { null,24,16,12,86,3,null,null,null,null }, { 50,null,9,29,25,47,null,null,77,null }, { 12,2,null,32,99,null,null,null,null,null }, { 68,79,1,null,77,74,null,69,31,null }, { 12,29,30,85,null,68,5,80,null,null }, { 26,76,30,31,54,null,null,null,null,null }, { 30,92,26,37,null,null,null,13,null,null }, { 88,97,78,84,86,47,null,null,null,null }, { 77,15,98,62,null,null,null,93,null,null }, { 12,13,87,34,92,null,null,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Torres de la Alameda"),new String("Torremocha de Jarama"),new String("Valdepielagos"),new String("Alpedrete"),new String("Valdemaqueda"),new String("Zarzalejo"),new String("Leganes"),new String("Villaconejos"),new String("Mejorada del Campo"),new String("Torrelaguna") },new Integer[][] { { null,24,16,12,86,3,null,null,null,null }, { 50,null,9,29,25,47,null,null,77,null }, { 12,2,null,32,99,null,null,null,null,null }, { 68,79,1,null,77,74,null,69,31,null }, { 12,29,30,85,null,68,5,80,null,null }, { 26,76,30,31,54,null,null,null,null,null }, { 30,92,26,37,null,null,null,13,null,null }, { 88,97,78,84,86,47,null,null,null,null }, { 77,15,98,62,null,null,null,93,null,null }, { 12,13,87,34,92,null,null,null,null,null } }),new Boolean(true))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
if (ok_sofar)
  ok_sofar = new Length(v_1,v_3).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Torres de la Alameda"),new String("Torremocha de Jarama"),new String("Valdepielagos"),new String("Alpedrete"),new String("Valdemaqueda"),new String("Zarzalejo"),new String("Leganes"),new String("Villaconejos"),new String("Mejorada del Campo"),new String("Torrelaguna") },new Integer[][] { { null,24,16,12,86,3,null,null,null,null }, { 50,null,9,29,25,47,null,null,77,null }, { 12,2,null,32,99,null,null,null,null,null }, { 68,79,1,null,77,74,null,69,31,null }, { 12,29,30,85,null,68,5,80,null,null }, { 26,76,30,31,54,null,null,null,null,null }, { 30,92,26,37,null,null,null,13,null,null }, { 88,97,78,84,86,47,null,null,null,null }, { 77,15,98,62,null,null,null,93,null,null }, { 12,13,87,34,92,null,null,null,null,null } })) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_60")) ;
    ResultsHandler.add_result(new String("withTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_61 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_61") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_61")) ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_61")) ;
    ResultsHandler.add_result(new String("withoutTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_62 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_62") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_62")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Alameda del Valle"),new String("Cenicientos"),new String("Cabanillas de la Sierra"),new String("El Molar"),new String("Lozoya") },new Integer[][] { { null,null,null,23,50 }, { null,null,null,34,null }, { null,null,null,78,null }, { null,null,null,null,null }, { 56,null,56,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_62")) ;
    ResultsHandler.add_result(new String("withoutTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_63 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_63") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_63")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Fresnedillas de la Oliva"),new String("Fuente el Saz de Jarama") },new Integer[][] { { null,null }, { null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Fresnedillas de la Oliva"),new String("Fuente el Saz de Jarama") },new Integer[][] { { null,null }, { null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Fresnedillas de la Oliva"),new String("Fuente el Saz de Jarama") },new Integer[][] { { null,null }, { null,null } }),new Boolean(false))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_63")) ;
    ResultsHandler.add_result(new String("withoutTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_64 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_64") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_64")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Santa Maria de la Alameda"),new String("Madrid") },new Integer[][] { { null,null }, { null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Santa Maria de la Alameda"),new String("Madrid") },new Integer[][] { { null,null }, { null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Santa Maria de la Alameda"),new String("Madrid") },new Integer[][] { { null,null }, { null,null } }),new Boolean(false))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_64")) ;
    ResultsHandler.add_result(new String("withoutTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_65 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_65") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_65")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Cadalso de los Vidrios"),new String("Valdemoro"),new String("Villavieja del Lozoya") },new Integer[][] { { null,null,41 }, { null,null,null }, { null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Cadalso de los Vidrios"),new String("Valdemoro"),new String("Villavieja del Lozoya") },new Integer[][] { { null,null,41 }, { null,null,null }, { null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Cadalso de los Vidrios"),new String("Valdemoro"),new String("Villavieja del Lozoya") },new Integer[][] { { null,null,41 }, { null,null,null }, { null,null,null } }),new Boolean(false))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_65")) ;
    ResultsHandler.add_result(new String("withoutTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_66 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_66") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_66")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Pelayos de la Presa"),new String("Villarejo de Salvanes"),new String("Collado Mediano"),new String("San Sebastian de los Reyes") },new Integer[][] { { null,null,null,null }, { null,null,null,69 }, { null,null,null,null }, { 65,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Pelayos de la Presa"),new String("Villarejo de Salvanes"),new String("Collado Mediano"),new String("San Sebastian de los Reyes") },new Integer[][] { { null,null,null,null }, { null,null,null,69 }, { null,null,null,null }, { 65,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Pelayos de la Presa"),new String("Villarejo de Salvanes"),new String("Collado Mediano"),new String("San Sebastian de los Reyes") },new Integer[][] { { null,null,null,null }, { null,null,null,69 }, { null,null,null,null }, { 65,null,null,null } }),new Boolean(false))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_66")) ;
    ResultsHandler.add_result(new String("withoutTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_67 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_67") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_67")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Ambite"),new String("Valdeavero"),new String("Valdelaguna"),new String("Villamanta"),new String("Valverde de Alcala") },new Integer[][] { { null,60,5,8,null }, { 68,null,null,null,null }, { 8,null,null,null,null }, { null,37,null,null,null }, { 94,7,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Ambite"),new String("Valdeavero"),new String("Valdelaguna"),new String("Villamanta"),new String("Valverde de Alcala") },new Integer[][] { { null,60,5,8,null }, { 68,null,null,null,null }, { 8,null,null,null,null }, { null,37,null,null,null }, { 94,7,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Ambite"),new String("Valdeavero"),new String("Valdelaguna"),new String("Villamanta"),new String("Valverde de Alcala") },new Integer[][] { { null,60,5,8,null }, { 68,null,null,null,null }, { 8,null,null,null,null }, { null,37,null,null,null }, { 94,7,null,null,null } }),new Boolean(false))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_67")) ;
    ResultsHandler.add_result(new String("withoutTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_68 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_68") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_68")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Mostoles"),new String("Chapineria"),new String("Humanes de Madrid"),new String("Colmenar del Arroyo"),new String("Torrejon de Ardoz"),new String("Colmenar Viejo"),new String("Villavieja del Lozoya") },new Integer[][] { { null,66,23,null,1,null,null }, { 27,null,55,60,null,null,null }, { 78,4,null,null,41,null,null }, { null,78,null,null,6,null,null }, { null,70,null,null,null,null,null }, { 76,66,null,null,null,null,20 }, { null,30,null,null,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Mostoles"),new String("Chapineria"),new String("Humanes de Madrid"),new String("Colmenar del Arroyo"),new String("Torrejon de Ardoz"),new String("Colmenar Viejo"),new String("Villavieja del Lozoya") },new Integer[][] { { null,66,23,null,1,null,null }, { 27,null,55,60,null,null,null }, { 78,4,null,null,41,null,null }, { null,78,null,null,6,null,null }, { null,70,null,null,null,null,null }, { 76,66,null,null,null,null,20 }, { null,30,null,null,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Mostoles"),new String("Chapineria"),new String("Humanes de Madrid"),new String("Colmenar del Arroyo"),new String("Torrejon de Ardoz"),new String("Colmenar Viejo"),new String("Villavieja del Lozoya") },new Integer[][] { { null,66,23,null,1,null,null }, { 27,null,55,60,null,null,null }, { 78,4,null,null,41,null,null }, { null,78,null,null,6,null,null }, { null,70,null,null,null,null,null }, { 76,66,null,null,null,null,20 }, { null,30,null,null,null,null,null } }),new Boolean(false))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_68")) ;
    ResultsHandler.add_result(new String("withoutTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_69 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_69") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_69")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("Parla"),new String("Navalafuente"),new String("Navas del Rey"),new String("Reduena"),new String("Valdetorres de Jarama"),new String("Madrid"),new String("Miraflores de la Sierra") },new Integer[][] { { null,null,null,null,null,null,null }, { 99,null,74,null,null,90,null }, { 79,null,null,86,null,null,null }, { 22,11,null,null,77,78,null }, { 56,14,null,null,null,null,null }, { 73,null,77,null,null,null,null }, { 22,null,null,null,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Parla"),new String("Navalafuente"),new String("Navas del Rey"),new String("Reduena"),new String("Valdetorres de Jarama"),new String("Madrid"),new String("Miraflores de la Sierra") },new Integer[][] { { null,null,null,null,null,null,null }, { 99,null,74,null,null,90,null }, { 79,null,null,86,null,null,null }, { 22,11,null,null,77,78,null }, { 56,14,null,null,null,null,null }, { 73,null,77,null,null,null,null }, { 22,null,null,null,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("Parla"),new String("Navalafuente"),new String("Navas del Rey"),new String("Reduena"),new String("Valdetorres de Jarama"),new String("Madrid"),new String("Miraflores de la Sierra") },new Integer[][] { { null,null,null,null,null,null,null }, { 99,null,74,null,null,90,null }, { 79,null,null,86,null,null,null }, { 22,11,null,null,77,78,null }, { 56,14,null,null,null,null,null }, { 73,null,77,null,null,null,null }, { 22,null,null,null,null,null,null } }),new Boolean(false))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_69")) ;
    ResultsHandler.add_result(new String("withoutTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  
  @Test
  public void test_70 () 
  {
    if (ResultsHandler.isTimedout())
    {
      Assertions.assertTrue(false,new String("Testing stopped due to global timeout -- too slow execution")) ;
    }
    boolean resultIs = true ;
    try
    {
      resultIs = Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ()  -> {
TestResult<Delivery<String>,Void> v_0 = null ;
Delivery<String> v_1 = null ;
TestResult<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>> v_2 = null ;
es.upm.aedlib.positionlist.PositionList<Vertex<String>> v_3 = null ;
TesterCode.resetPrinter() ;
TestData.initTrace() ;
TestData.testName = new String("test_70") ;
boolean ok_sofar = true ;
ResultsHandler.startTest(new String("test_70")) ;
if (ok_sofar)
{
  v_0 = new Constructor(new String[] { new String("El Berrueco"),new String("Cabanillas de la Sierra"),new String("El Alamo"),new String("San Martin de la Vega"),new String("La Acebeda"),new String("Somosierra"),new String("Corpa"),new String("Cobena"),new String("Carabana"),new String("Aldea del Fresno") },new Integer[][] { { null,87,null,null,null,null,null,null,null,30 }, { 34,null,null,84,null,null,null,null,null,null }, { 45,null,null,4,null,91,null,null,null,80 }, { 52,55,57,null,null,null,null,null,null,null }, { 35,null,54,null,null,null,84,null,12,67 }, { null,69,89,32,null,null,null,null,null,null }, { 92,40,null,null,null,null,null,77,null,29 }, { 74,88,84,null,null,null,null,null,null,null }, { 21,null,null,6,null,null,null,null,null,null }, { 45,38,54,null,null,null,null,null,null,null } }).doCall() ;
  ok_sofar = v_0.checkResult(null) ;
}
if (ok_sofar)
  v_1 = v_0.getValue() ;
if (ok_sofar)
  ok_sofar = new GetGraph(v_1).doCall().checkResult(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("El Berrueco"),new String("Cabanillas de la Sierra"),new String("El Alamo"),new String("San Martin de la Vega"),new String("La Acebeda"),new String("Somosierra"),new String("Corpa"),new String("Cobena"),new String("Carabana"),new String("Aldea del Fresno") },new Integer[][] { { null,87,null,null,null,null,null,null,null,30 }, { 34,null,null,84,null,null,null,null,null,null }, { 45,null,null,4,null,91,null,null,null,80 }, { 52,55,57,null,null,null,null,null,null,null }, { 35,null,54,null,null,null,84,null,12,67 }, { null,69,89,32,null,null,null,null,null,null }, { 92,40,null,null,null,null,null,77,null,29 }, { 74,88,84,null,null,null,null,null,null,null }, { 21,null,null,6,null,null,null,null,null,null }, { 45,38,54,null,null,null,null,null,null,null } })) ;
if (ok_sofar)
{
  v_2 = new Tour(v_1).doCall() ;
  ok_sofar = v_2.checkResult(new es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>(new es.upm.aedlib.Pair<String[],Integer[][]>(new String[] { new String("El Berrueco"),new String("Cabanillas de la Sierra"),new String("El Alamo"),new String("San Martin de la Vega"),new String("La Acebeda"),new String("Somosierra"),new String("Corpa"),new String("Cobena"),new String("Carabana"),new String("Aldea del Fresno") },new Integer[][] { { null,87,null,null,null,null,null,null,null,30 }, { 34,null,null,84,null,null,null,null,null,null }, { 45,null,null,4,null,91,null,null,null,80 }, { 52,55,57,null,null,null,null,null,null,null }, { 35,null,54,null,null,null,84,null,12,67 }, { null,69,89,32,null,null,null,null,null,null }, { 92,40,null,null,null,null,null,77,null,29 }, { 74,88,84,null,null,null,null,null,null,null }, { 21,null,null,6,null,null,null,null,null,null }, { 45,38,54,null,null,null,null,null,null,null } }),new Boolean(false))) ;
}
if (ok_sofar)
  v_3 = v_2.getValue() ;
return ok_sofar ;
}
) ;
    }
    catch ( org.opentest4j.AssertionFailedError exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.DURING,new String("*** TIMEOUT! *** Very slow or non-terminating execution"),exc) ;
      resultIs = false ;
    }
    catch ( Throwable exc )
    {
      TestUtils.printCallException(TestUtils.ExecutionTime.UNRELATED,new String("Internal testing error; please report this to teachers"),exc) ;
      resultIs = false ;
    }
    String messages = TestData.getMessages() ;
    ResultsHandler.stopTest(new String("test_70")) ;
    ResultsHandler.add_result(new String("withoutTour"),resultIs) ;
    if (messages.length() > 0)
      System.out.println(messages) ;
    if (!resultIs)
      Assertions.assertTrue(resultIs,messages) ;
  }
  


static class Tests {
  static String tester = "TesterLab7";
}












static class RouteChecker {

  static boolean graphCorrect(GetGraph call,
                           TestResult<DirectedGraph<String,Integer>,Pair<String[],Integer[][]>> result,
                           Pair<String[],Integer[][]> expected)
  {
    // We have to check that the number of graph vertices is equal to the length of the array
    // and that every node in the array is present as a vertice in the graph.
    // Next we check that the transition function is correct according to the matrix.

    boolean ok_sofar = true;
    DirectedGraph<String,Integer> graph = result.getValue();
    String[] nodeElements = expected.getLeft();
    Integer[][] matrix = expected.getRight();

    if (graph.numVertices() != nodeElements.length) {
      ok_sofar = false;
      TestUtils.printError
        (TestUtils.ExecutionTime.LAST,
         "the call "+call+" returned a graph with "+graph.numVertices()+" vertices"+
         " but the graph should have contained "+nodeElements.length+" vertices.");
    }

    if (ok_sofar) {
      int expectedNumEdges = 0;
      for (int x=0; x<matrix.length; x++) {
        Integer[] row = matrix[x];
        for (int y=0; y<row.length; y++) {
          if (row[y] != null) ++expectedNumEdges;
        }
      }

      if (graph.numEdges() != expectedNumEdges) {
        ok_sofar = false;
        TestUtils.printError
          (TestUtils.ExecutionTime.LAST,
           "the call "+call+" returned a graph with "+graph.numEdges()+" edges"+
           " but the graph should have contained "+expectedNumEdges+" edges.");
      }
    }

    Map<Integer,Vertex<String>> extToInt = new HashTableMap<>();

    if (ok_sofar) {
      for (int i=0; i<nodeElements.length; i++) {
        String nodeName = nodeElements[i];
        boolean found = false;
        for (Vertex<String> graphNode : graph.vertices()) {
          if (nodeName.equals(graphNode.element())) {
            found = true;
            extToInt.put(i,graphNode);
          }
        }
        if (!found) {
          ok_sofar = false;
          TestUtils.printError
            (TestUtils.ExecutionTime.LAST,
             "the call "+call+" returned a graph where there is no vertex with the element "+
             nodeName+" but there should be.");
        }
      }
    }

    if (ok_sofar) {
      for (int x=0; x<matrix.length && ok_sofar; x++) {
        for (int y=0; y<matrix.length && ok_sofar; y++) {
          Integer value = matrix[x][y];
          if (value != null) {
            Vertex<String> fromNode = extToInt.get(x);
            Vertex<String> toNode = extToInt.get(y);
            boolean found = false;
            for (Edge<Integer> e : graph.outgoingEdges(fromNode)) {
              Vertex<String> endNode = graph.endVertex(e);
              if (toNode == endNode) {
                if (value.equals(e.element())) {
                  found = true;
                  break;
                } else {
                  ok_sofar = false;
                  TestUtils.printError
                    (TestUtils.ExecutionTime.LAST,
                     "the call "+call+" returned a graph where there is no edge from "+
                     fromNode+" to "+toNode+" with the element "+value);
                  break;
                }
              }
            }
            if (!found) {
              ok_sofar = false;
              TestUtils.printError
                (TestUtils.ExecutionTime.LAST,
                 "the call "+call+" returned a graph where there is no edge from "+
                 fromNode+" to "+toNode);
              break;
            }
          }
        }
      }
    }
    return ok_sofar;
  }

  static boolean tourCorrect(Tour call,
                             TestResult<PositionList<Vertex<String>>,Pair<Pair<String[],Integer[][]>,Boolean>> result,
                             Pair<Pair<String[],Integer[][]>,Boolean> expected)
  {
    boolean ok_sofar = true;

    if (!call.noException())
      return false;

    PositionList<Vertex<String>> tour = result.getValue();

    if (tour == null) {
      if (expected.getRight() == true) {
        TestUtils.printError
            (TestUtils.ExecutionTime.LAST,
             "the call "+call+" did not return a tour but should have done so");
        return false;
      } else return true;
    } else {
      if (expected.getRight() == false) {
        TestUtils.printError
            (TestUtils.ExecutionTime.LAST,
             "the call "+call+" returned a tour but should not have done so");
        return false;
      }
    }

    String[] nodeElements = expected.getLeft().getLeft();
    Integer[][] matrix = expected.getLeft().getRight();

    if (ok_sofar) {
      if (tour.size() != nodeElements.length) {
        ok_sofar = false;
        TestUtils.printError
            (TestUtils.ExecutionTime.LAST,
             "the call "+call+" returned a tour\n  "+tour+
             "\nbut the length of the tour "+tour.size()+
             " is different from the number of nodes in the graph = "+nodeElements.length);
      }
    }

    Map<Vertex<String>,Integer> intToExt = new HashTableMap<>();

    if (ok_sofar) {
      for (int i=0; i<nodeElements.length; i++) {
        String nodeName = nodeElements[i];
        boolean found = false;
        for (Vertex<String> node : tour) {
          if (nodeName.equals(node.element())) {
            found = true;
            intToExt.put(node,i);
          }
        }
        if (!found) {
          ok_sofar = false;
          TestUtils.printError
            (TestUtils.ExecutionTime.LAST,
             "the call "+call+" returned a tour which does not visit "+nodeName);
        }
      }
      if (intToExt.size() != nodeElements.length) {
        ok_sofar = false;
        TestUtils.printError
          (TestUtils.ExecutionTime.LAST,
           "the call "+call+" returned a tour which does not visit all nodes among "+
           nodeElements);
      }
    }

    if (ok_sofar) {
      Vertex<String> previous = null;
      for (Vertex<String> now : tour) {
        if (now == null) {
          ok_sofar = false;
          TestUtils.printError
            (TestUtils.ExecutionTime.LAST,
             "the call "+call+" returned a tour\n  "+tour+
             "\nwith a null vertex");
          break;
        }
        
        if (previous != null) {
          boolean found = false;
          int fromNode = intToExt.get(previous);
          int toNode = intToExt.get(now);
          Integer edge = matrix[fromNode][toNode];
          if (edge == null) {
            ok_sofar = false;
            TestUtils.printError
              (TestUtils.ExecutionTime.LAST,
               "the call "+call+" returned a tour\n  "+tour+
               "\nwith two consecutive nodes "+
               previous.element()+" and "+now.element()+
               " but there is no edge between these nodes in the matrix");
            break;
          }
        }
        previous = now;
      }
    }
    return ok_sofar;
  }

  static boolean tourLengthCorrect(Length call,
                           TestResult<Integer,Pair<String[],Integer[][]>> result,
                                   Pair<String[],Integer[][]> expected)
  {
    // Check that the length of the tour is correct
    boolean ok_sofar = true;

    if (!call.noException())
      return false;

    Integer tourLength = result.getValue();
    PositionList<Vertex<String>> tour = call.tour;
    String[] nodeElements = expected.getLeft();
    Integer[][] matrix = expected.getRight();

    Map<Vertex<String>,Integer> intToExt = new HashTableMap<>();

    for (int i=0; i<nodeElements.length; i++) {
      String nodeName = nodeElements[i];
      boolean found = false;
      for (Vertex<String> node : tour) {
        if (nodeName.equals(node.element())) {
          found = true;
          intToExt.put(node,i);
        }
      }
    }

    Vertex<String> previous = null;
    int length = 0;
    
    for (Vertex<String> now : tour) {
      if (previous != null) {
        boolean found = false;
        int fromNode = intToExt.get(previous);
        int toNode = intToExt.get(now);
        Integer edge = matrix[fromNode][toNode];
        length += edge;
      }
      previous = now;
    }

    if (length != tourLength) {
      ok_sofar = false;
      TestUtils.printError
        (TestUtils.ExecutionTime.LAST,
         "the call "+call+" returned a length "+tourLength+" for the tour\n  "+tour+
         "\nbut the expected length is "+length);
    }
    
    return ok_sofar;
  }
}




























static class TestUtils {
  enum ExecutionTime { AFTER, LAST, DURING, UNRELATED }

  static String print(Object obj) {
    return TesterCode.printer(obj);
  }

  static String standardPrinter(Object obj) {
    return printer(obj, x -> standardPrinter(x));
  }

  static String printer(Object obj, Function<Object,String> print) {
    if (obj == null)
      return "null";

    if (obj instanceof String) {
      return("\""+obj.toString()+"\"");
    } else if (obj instanceof Position<?>) {
      return obj.toString();
    } else if (obj instanceof Pair<?,?>) {
      Pair<?,?> p = (Pair<?,?>) obj;
      return "Pair("+print.apply(p.getLeft())+","+print.apply(p.getRight())+")";
    } else if (obj instanceof java.util.Set<?>) {
      Iterable<?> l = (Iterable<?>) obj;
      StringBuffer buf = new StringBuffer();
      buf.append("{");
      boolean first = true;
      for (Object lobj : l) {
        if (first) first=false;
        else buf.append(",");
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
        if (first) first=false;
        else buf.append(",");
        buf.append(print.apply(lobj));
      }
      buf.append("]");
      return buf.toString();
    } else if (obj instanceof Map<?,?>) {
      Map<?,?> m = (Map<?,?>) obj;
      StringBuffer buf = new StringBuffer();
      buf.append("[");
      boolean first = true;
      for (Entry<?,?> lobj : m.entries()) {
        if (first) first=false;
        else buf.append(",");
        buf.append("("+print.apply(lobj.getKey())+","+print.apply(lobj.getValue())+")");
      }
      buf.append("]");
      return buf.toString();
    } else if (obj instanceof Object[]) {
      Object[] arr = (Object[]) obj;
      StringBuffer buf = new StringBuffer();
      buf.append("[");
      boolean first = true;
      for (int i=0; i<arr.length; i++) {
        Object aobj = arr[i];
        if (first) first=false;
        else buf.append(",");
        buf.append(print.apply(aobj));
      }
      buf.append("]");
      return buf.toString();
    } else if (obj instanceof int[]) {
      int[] arr = (int[]) obj;
      StringBuffer buf = new StringBuffer();
      buf.append("[");
      boolean first = true;
      for (int i=0; i<arr.length; i++) {
        int aobj = arr[i];
        if (first) first=false;
        else buf.append(",");
        buf.append(print.apply(aobj));
      }
      buf.append("]");
      return buf.toString();
    }
    else
      return obj.toString();
  }

  static void printWarning(String TestName) {
      TestData.message("\n*** Warning in "+(TestName==null?"":TestName)+":");
  }

  static void printError(String TestName) {
      TestData.message("\n\n***********************************************");
      TestData.message("*** Error in "+(TestName==null?"":TestName)+":");
  }

  static void terminateErrorPrint() {
      TestData.message("\n***********************************************\n\n");
  }

  static boolean compare(Object o1, Object o2) {
      if (o1==null) return o2==null;
      else return o1.equals(o2);
  }

  static void printCallException(ExecutionTime time, String msg, Throwable exc) {
    printError(TestData.testName);

      int traceLength = TestData.numCommands();

      if (traceLength > 0) {
        TestData.message("\n"+callSeqString(traceLength,time)+"\n");
        TestData.message(TestData.getTrace());
      }

      switch (time) {
      case AFTER:
	  TestData.message("the call to "+msg+" raised the exception "+exc+
			     " although it should not have");
	  break;
      default:
	  TestData.message(" -- the exception "+exc+" was raised although it "+
			     "should not have been\n"+msg);
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
    for (int i=0; i<stackTrace.length; i++) {
      String className = stackTrace[i].getClassName();
      if (className.startsWith("jdk.internal")
          || className.startsWith("org.junit")) break;
      l.add(stackTrace[i]);
    }
    StackTraceElement[] cutStackTrace = new StackTraceElement[l.size()];
    throwable.setStackTrace(l.toArray(cutStackTrace));
  }

  static void printCallException(String msg, Throwable exc) {
    printCallException(ExecutionTime.AFTER,msg,exc);
  }

  static void printCallException(Throwable exc) {
    printCallException(ExecutionTime.LAST,"",exc);
  }

  static void printCallException(Throwable exc, Supplier<String> msg) {
    printCallException(ExecutionTime.LAST,msg.get(),exc);
  }

  static void printWarning(ExecutionTime time, String msg) {
    TestData.message("\n\n***********************************************");
    if (TestData.testName != "") {
      TestData.message("\n*** Warning for "+TestData.testName+": ");
    } else
      TestData.message("\n*** Warning:");

    if (time != TestUtils.ExecutionTime.UNRELATED) {
      int traceLength = TestData.numCommands();
    
      if (traceLength > 0) {
        TestData.message(callSeqString(traceLength,time));
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
        TestData.message("\n"+callSeqString(traceLength,time));
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
      switch(time) {
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
  static <E extends Iterable<?>,F extends Iterable<?>>
    boolean sameSet(TestCall<E,F> call,
                    TestResult<E,F> result,
                    F expected) {
    return sameSet(call,result.getValue(),expected);
  }

  // *********************************************
  // WARNING: this relies on a sane definition of
  // hashCode and equals which does not fail upon finding
  // null values...
  static <E extends Iterable<?>,F extends Iterable<?>>
    boolean sameSet(TestCall<?,?> call, E value, F expected) {

    HashSet<Object> s1 = new HashSet<Object>();
    HashSet<Object> s2 = new HashSet<Object>();
    for (Object e : value)
      s1.add(e);
    for (Object f : expected)
      s2.add(f);
    if (!s1.equals(s2)) {
      printError
        (ExecutionTime.DURING,
         "the call "+call.toString()+
         " returned a value which contained the elements\n  "+TestUtils.print(s1)+
         "\nwhich differs from the expected elements\n  "+TestUtils.print(s2));
      return false;
    }
    return true;
  }

  // Checks that results, which are basic arrays, are equal
  static <E,F> boolean eqArrays(TestCall<int[],int[]> call,
                                TestResult<int[],int[]> result,
                                int[] expected) {
    if (!call.noException())
      return false;
    if (!call.nonNull())
      return false;

    return eqArrays(call, result.getValue(), expected);
  }

  static boolean eqArrays(TestCall<int[],int[]> call, int[] value, int[] expected) {
    boolean ok_sofar = value.length == expected.length;

    if (ok_sofar) {
      for (int i=0; i<value.length && ok_sofar; i++) {
        ok_sofar = ok_sofar && (value[i] == expected[i]);
      }
    }

    if (!ok_sofar) {
      printError
        (ExecutionTime.DURING,
         "the call "+call.toString()+
         " returned an array "+printArray(value)+
         " which differs from the expected array "+printArray(expected));
    }
    return ok_sofar;
  }

  // Checks that results, which are iterables, return the same
  // elements, regardless of the order.
  static <E,F> boolean sameElements(TestCall<E,F> call,
                                    TestResult<E,F> result,
                                    F expected) {
    if (!call.noException())
      return false;
    if (!call.nonNull())
      return false;

    return sameElements(call,result.getValue(),expected);
  }

  // *********************************************
  // WARNING: this relies on a sane definition of
  // hashCode and equals which does not fail upon finding
  // null values...

  static <E,F> boolean sameElements(TestCall<E,F> call,
                                    E value,
                                    F expected) {
    
    if (!sameElements(value,expected)) {
      printError
        (ExecutionTime.DURING,
         "the call "+call.toString()+
         " returned a value which contained the elements\n  "+TestUtils.print(value)+
         "\nwhich differs from the expected elements\n  "+TestUtils.print(expected));
      return false;
    }
    return true;
  }

  // *********************************************
  // WARNING: this relies on a sane definition of
  // hashCode and equals which does not fail upon finding
  // null values...
  static <E,F>
    boolean sameElements(E valueP, F expectedP) {
    if ((valueP instanceof Iterable<?>) &&
        (expectedP instanceof Iterable<?>)) {
      Iterable<?> value = (Iterable<?>) valueP;
      Iterable<?> expected = (Iterable<?>) expectedP;
    
      HashMap<Object,Integer> s1 = new HashMap<Object,Integer>();
      HashMap<Object,Integer> s2 = new HashMap<Object,Integer>();
      for (Object e : value) {
        Integer si = s1.get(e);
        if (si == null) si = 0;
        s1.put(e,si+1);
      }
      for (Object f : expected) {
        Integer si = s2.get(f);
        if (si == null) si = 0;
        s2.put(f,si+1);
      }
      if (!s1.equals(s2)) 
        return false;
      else
        return true;
    } else {
      if (!(valueP instanceof Iterable<?>))
        System.out.println
          ("*** Error: result of type "+valueP.getClass()+" does not implement Iterable");
      if (!(expectedP instanceof Iterable<?>))
        System.out.println
          ("*** Error: expected of type "+expectedP.getClass()+" does not implement Iterable");
      throw new RuntimeException();
    }
  }

  // *********************************************
  // WARNING: this relies on a sane definition of
  // equals which does not fail upon finding
  // null values...
  static <E> boolean wellSorted(TestCall<?,?> call,
                                IndexedList<E> value,
                                ArrayIndexedList<ArrayIndexedList<E>> expected) {
    
    int i = 0;
    IndexedList<E> eqClass = null;
    for (E e : value) {
      if (eqClass == null) {
        if (i < expected.size())
          eqClass = new ArrayIndexedList<E>(expected.get(i));
        else {
          printError
            (ExecutionTime.DURING,
             "the call "+call.toString()+
             " returned a list: "+value+
             " which isn't sorted correctly. The correct sort order is "+expected);
          return false;
        }
      }
      if (!eqClass.remove(e)) {
          printError
            (ExecutionTime.DURING,
             "the call "+call.toString()+
             " returned a list: "+value+
             " which isn't sorted correctly. The correct sort order is "+expected);
          return false;
      }
      if (eqClass.size() == 0) {
        eqClass = null;
        i++;
      }
    }
    if (eqClass != null || i < expected.size()) {
          printError
            (ExecutionTime.DURING,
             "the call "+call.toString()+
             " returned a list: "+value+
             " which isn't sorted correctly. The correct sort order is "+expected);
          return false;
    }
    return true;
  }


  static <E> boolean wellSorted(TestCall<?,?> call,
                                PositionList<E> value,
                                PositionList<E> expected,
                                Function<Pair<E,E>,Boolean> isSame) {

    PositionList<E> expectedCopy = new NodePositionList<E>(expected);

    if (value.size() != expected.size()) {
      printError
        (ExecutionTime.DURING,
         "the call "+call.toString()+
         " returned a list:\n  "+value+
         "\nwhich contains the wrong number of elements.\n"+
         "The correct list (modulo order of equal elements) is\n  "+
         expectedCopy);
      return false;
    }

    Position<E> valuePos = value.first();
    
    while (valuePos != null) {
      E valueE = valuePos.element();

      if (valueE == null) {
        if (value.size() != expected.size()) {
          printError
            (ExecutionTime.DURING,
             "the call "+call.toString()+
             " returned a list:\n  "+value+
             "\nwhich contains a null element.\n"+
             "The correct list (modulo order of equal elements) is\n  "+
             expectedCopy);
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
        } else if (!isSame.apply(new Pair<E,E>(valueE,expectedE)))
          equals = false;

        if (!found && equals) {
          expectedPos = expected.next(expectedPos);
        }
      }

      if (!found) {
        printError
          (ExecutionTime.DURING,
           "the call "+call.toString()+
           " returned a list:\n  "+value+
           "\nwhich contains elements either incorrect elements or elements in the wrong order."+
           "\nThe correct list (modulo order of equal elements) is\n  "+
           expectedCopy);
        return false;
      }

      valuePos = value.next(valuePos);
    }
    return true;
  }


  static <E> PositionList<E> extractElementsFromIterable(String callString, Iterable<E> i) {
    if (i == null) {
      printError
        (ExecutionTime.DURING,
         "the call "+callString+
         " returned an null iterable");
      return null;
    }

    PositionList<E> l = null;

    try {
      java.util.Iterator<E> it = i.iterator();
      l = extractElementsFromIterator(it);
    } catch (Throwable exc) {
      printError
        (ExecutionTime.DURING,
         "the call "+callString+
         " returned an iterable which when used raised the exception "+
         exc+"\n"+getStackTrace(exc));
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

  static <E,F> boolean unorderedIterableCorrect
    (TestCall<Iterable<E>,F[]> call,
     TestResult<Iterable<E>,F[]> result,
     F[] expected) {
    java.util.Iterator<E> it = null;

    try {
      it = result.getValue().iterator();
      if (it == null) {
        printError
          (ExecutionTime.DURING,
           "the call "+call.toString()+
           " returned an iterable which returned a null iterator");
	return false;
      }
      else return unorderedIteratorCorrect(() -> call.toString(), it, expected);
    } catch (Throwable exc) {
      printError
        (ExecutionTime.DURING,
         "the call "+call.toString()+
         " returned an iterable which when used raised the exception "+
         exc+"\n"+getStackTrace(exc));
      return false;
    }
  }

  static <E,F> boolean unorderedIteratorCorrect
    (TestCall<java.util.Iterator<E>,F[]> call,
     TestResult<java.util.Iterator<E>,F[]> result,
     F[] expected) {
    java.util.Iterator<E> it = result.getValue();
    return unorderedIteratorCorrect(() -> call.toString(), it, expected);
  }

  static <E,F> boolean unorderedIteratorCorrect
    (Supplier<String> callString,
     java.util.Iterator<E> it,
     F[] expected) {

    PositionList<E> l = null;

    try { l = extractElementsFromIterator(it); }
    catch ( Throwable exc ) {
      TestUtils.printCallException(exc);
      return false;
    }

    if (l == null) return false;

    boolean correct = (expected.length == l.size());

    if (correct) {
      PositionList<F> expectedList = new NodePositionList<F>();
      for (int j=0; j<expected.length; j++) {
        expectedList.addLast(expected[j]);
      }
      HashSet<Object> s1 = new HashSet<Object>();
      HashSet<Object> s2 = new HashSet<Object>();
      for (Object e : l)
        s1.add(e);
      for (Object f : expectedList)
        s2.add(f);
      if (!s1.equals(s2)) {
        printError
          (ExecutionTime.DURING,
           "the call "+callString.get()+
           " returned an iterator which returned the elements "+TestUtils.print(s1)+
           " which differs from the expected elements "+TestUtils.print(s2));
        return false;
      }
    }
   
    if (!correct) {
      printError
        (ExecutionTime.DURING,
         "the call "+callString.get()+
         " returned an iterable with the elements "+TestUtils.print(l)+
         " but should have returned the elements "+TestUtils.print(expected));
      return false;
    } else return true;
  }

  static <E,F> boolean iterableCorrect(String callString, E[] original, Iterable<E> i) {
    PositionList<E> l = extractElementsFromIterable(callString, i);
    if (l == null) return false;

    boolean correct = (original.length == l.size());

    if (correct) {
      Position<E> cursor = l.first();
      for (int j=0; j<original.length; j++) {
        if (original[j] == null) {
          correct = correct && (cursor.element() == null);
        }
        correct = correct && original[j].equals(cursor.element());
        if (!correct) break;
        cursor = l.next(cursor);
      }
    }
   
    if (!correct) {
      printError
        (ExecutionTime.DURING,
         "the call "+callString+
         " returned an iterable with the elements "+TestUtils.print(l)+
         " but should have returned the elements "+TestUtils.print(original));
      return false;
    } else return true;
  }

  static <E> boolean unchanged(String callString, E[] original, PositionList<E> l) {
      boolean ok_sofar = true;
      
      if (l.size() != original.length) {
	  ok_sofar = false;
      }

      Position<E> lPos = l.first();
      int i=0;
      while (ok_sofar && lPos != null) {
	  E elem = lPos.element();

	  if (elem == null) ok_sofar = (original[i] == null);
	  else ok_sofar = elem.equals(original[i]);

	  lPos = l.next(lPos);
	  ++i;
      }

      if (!ok_sofar) {
	  printError
            (ExecutionTime.DURING,
	       "the call "+callString+
	       " has modified the input list "+TestUtils.print(original)+
	     "; it has now the elements "+TestUtils.print(l));
	  return ok_sofar;
      }
      return ok_sofar;
  }

  static <E> boolean unchanged(String callString, E[] original, E[] newer) {
      boolean ok_sofar = true;
      
      if (newer.length != original.length) {
	  ok_sofar = false;
      }

      for (int i=0; i<newer.length; i++) {
	  if (newer[i] == null) ok_sofar = (original[i] == null);
	  else ok_sofar = newer[i].equals(original[i]);
      }

      if (!ok_sofar) {
	  printError
	      (ExecutionTime.DURING,
	       "the call "+callString+
	       " has modified the input array "+TestUtils.print(original)+
	       "; it has now the elements "+TestUtils.print(newer));
	  return ok_sofar;
      }
      return ok_sofar;
  }

  static String printArray(Object[] arr) {
      if (arr == null) return "null";
      else {
	  StringBuilder arrString = new StringBuilder("[");
      
	  for (int i = 0; i < arr.length; i++) {
	      arrString.append(arr[i]);
	      if (i < arr.length-1)
		  arrString.append(", ");
	  }
	  arrString.append("]");
	  return arrString.toString();
      }
  }

  static String printArray(int[] arr) {
      if (arr == null) return "null";
      else {
	  StringBuilder arrString = new StringBuilder("[");
      
	  for (int i = 0; i < arr.length; i++) {
	      arrString.append(arr[i]);
	      if (i < arr.length-1)
		  arrString.append(", ");
	  }
	  arrString.append("]");
	  return arrString.toString();
      }
  }

  static String printArray(char[] arr) {
      if (arr == null) return "null";
      else {
	  StringBuilder arrString = new StringBuilder("[");
      
	  for (int i = 0; i < arr.length; i++) {
	      arrString.append(arr[i]);
	      if (i < arr.length-1)
		  arrString.append(", ");
	  }
	  arrString.append("]");
	  return arrString.toString();
      }
  }

  public static <T> PositionList<T> toPositionList(T[] arr) {
    NodePositionList<T> l = new NodePositionList<T>();
    for (int i=0; i<arr.length; i++)
      l.addLast(arr[i]);
    return l;
  }

  public static <T> IndexedList<T> toIndexedList(T[] arr) {
    ArrayIndexedList<T> l = new ArrayIndexedList<T>();
    for (int i=0; i<arr.length; i++)
      l.add(0,arr[i]);
    return l;
  }

  public static Object accessAttribute(String fieldName, Object obj) {
    try {
      Field field;
      field = obj.getClass().getDeclaredField(fieldName);
      field.setAccessible(true);
      return field.get(obj);
    } catch ( Throwable exc ) {
      TestUtils.printCallException
        (TestUtils.ExecutionTime.LAST,
         "cannot access the field "+fieldName+": ",
         exc);
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
  public static <T> T[] toGenericArray(T ... elems) {
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

      aedlibMajor =
	(Integer) majorMethod.invoke(null);
      aedlibMinor = 
	(Integer) minorMethod.invoke(null);
      aedlibPatchlevel = 
	(Integer) patchlevelMethod.invoke(null);

      isOk =
	((aedlibMajor > major)
	 || ((aedlibMajor == major) &&
	     ((aedlibMinor > minor)
	      || ((aedlibMinor == minor) &&
		  (aedlibPatchlevel >= patchlevel)))));
    } catch (Throwable exc) {
      System.out.println
	("*** WARNING: cannot check aedlib version number due to "+exc);
      exc.printStackTrace();
    }

    if (!isOk) {
      String errorMessage =
	"*** ERROR: aedlib is too old. Minimum version needed is "+
	major+"."+minor+"."+patchlevel+"; your version is "+
	aedlibMajor+"."+aedlibMinor+"."+aedlibPatchlevel+
	". Please download a new version of aedlib from moodle\n";
      System.out.println(errorMessage);
      throw new RuntimeException(errorMessage);
    } else return true; 	      
  }

  @SuppressWarnings("unchecked")
  public static es.upm.aedlib.Entry<es.upm.aedlib.graph.Vertex<Integer>,Integer> es_upm_aedlib_map_Entry_refl_cnstr(Object... params) {
    return (es.upm.aedlib.Entry<es.upm.aedlib.graph.Vertex<Integer>,Integer>) reflectionNew("es.upm.aedlib.map.HashEntry",params);
  }

  public static Object reflectionNew(String className, Object... params) {
    try {
      Class<?> cl = Class.forName(className);
      for (java.lang.reflect.Constructor<?> cnstr : cl.getConstructors()) {
        Class<?>[] parameterTypes = cnstr.getParameterTypes();
        if (parameterTypes.length == params.length) {
          boolean equals = true;
          for (int i=0; i<parameterTypes.length && equals; i++) {
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
      System.out.println
        ("*** Warning: could not access class "+className);
      throw new RuntimeException();
    } catch (InstantiationException exc) {
      System.out.println
        ("*** Warning: could not instantiate "+className);
      throw new RuntimeException();
    } catch (IllegalAccessException exc) {
      System.out.println
        ("*** Warning: could not access "+className);
      throw new RuntimeException();
    } catch (InvocationTargetException exc) {
      System.out.println
        ("*** Warning: constructor "+className+" raised an exception");
      throw new RuntimeException();
    }
    throw new RuntimeException();
  }
}

interface TestResult<E,F> {
  boolean isException();
  Throwable getException();
  E getValue();
  boolean checkResult(F expected);
}

static class Result<E,F> implements TestResult<E,F> {
  private boolean isException;
  private Throwable exception;
  private E value;
  Call<E,F> call;

  public static <E,F> Result<E,F> result(E e, Call<E,F> call) {
    Result<E,F> result = new Result<E,F>();
    result.isException = false;
    result.value = e;
    result.call = call;
    return result;
  }
  
  public static <E,F> Result<E,F> exception(Throwable exception, Call<E,F> call) {
    Result<E,F> result = new Result<E,F>();
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
  
  Call<E,F> getCall() {
    return call;
  }

  public boolean checkResult(F expected) {
    try {
      return getCall().checkResult(expected);
    } catch (Throwable exc) {
      System.out.println("\n\n\n*** Internal testing error: checkResult("+expected+") raised exception "+exc);
      exc.printStackTrace();
      TestData.message("\n\n\n*** Internal testing error: checkResult("+expected+") raised exception "+exc);
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
	{
          String valueString = TesterCode.printer(getValue());
          return callString + "  =>  " + format_value(valueString);
        }
    } else return callString;
  }

  private String format_value(String msg) {
    String[] lines = msg.split("\\r?\\n");
    if (lines.length == 1) return msg;
    else {
      StringBuffer resultString = new StringBuffer();
      for (String line : lines) {
        resultString.append("\n    ");
        resultString.append(line);
      }
      return resultString.toString();
    }
  }
}

interface Call<E,F> {
  TestResult<E,F> doCall();
  String toString();
  boolean checkResult(F expected);
}

static abstract class TestCall<E,F> implements Call<E,F> {
  TestResult<E,F> result;
  boolean hasCalled;
  boolean voidReturn = false;

  public TestResult<E,F> doCall() {
    if (hasCalled())
      throw new RuntimeException();

    hasCalled = true;
    TestData.addCallToTrace(this.toString());
    
    try {
      E e = call();
      result = Result.result(e,this);
    } catch (Throwable exception) {
      result = Result.exception(exception,this);
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
      TestUtils.printCallException(throwable,msg);
      return false;
    }
    return true;
  }

  boolean throwsException(String expectedName) {
    if (!result.isException()) {
      TestUtils.printError
        (TestUtils.ExecutionTime.LAST,
         "\nthe call to "+this+" should have thrown an exception "+expectedName+
         " but did not.");
      return false;
    }

    Throwable exception = result.getException();
    if (!expectedName.equals(exception.getClass().getCanonicalName())) {
      TestUtils.printError
        (TestUtils.ExecutionTime.LAST,
         "\nthe call to "+this+" should have thrown the exception "+
         expectedName+
         ", but throwed the exception "+exception+"\n"+
         TestUtils.getStackTrace(exception));
      return false;
    }

    return true;
  }

  boolean nonNull() {
    if (!noException())
      return false;
    if (result.getValue() == null) {
      TestUtils.printError
        (TestUtils.ExecutionTime.LAST,
         "\nthe call to "+this+
         " returned null but it should not have\n");
      return false;
    } else return true;
  }

  boolean nonNull(Supplier<String> msg) {
    if (!noException())
      return false;
    if (result.getValue() == null) {
      TestUtils.printError
        (TestUtils.ExecutionTime.LAST,
         "\nthe call to "+this+
         " returned null but it should not have\n"+
         msg.get());
      return false;
    } else return true;
  }

  boolean fresh(Object obj) {
    return fresh(result.getValue(),obj);
  }

  boolean fresh(Object obj1, Object obj2) {
    if (obj1 != null && obj1 == obj2) {
      TestUtils.printError
        (TestUtils.ExecutionTime.LAST,
         "\nthe call to "+this+
         " returned an object\n  "+TestUtils.print(obj1)+
         "\nwhich is the same REFERENCE as an argument object; "+
         "a NEW object should have been returned\n");
      return false;
    } else return true;
  }

  boolean unchanged(Object obj1, Object obj2) {
    return report_unchanged(obj1.equals(obj2),obj1,obj2);
  }

  boolean report_unchanged(boolean result, Object obj1, Object obj2) {
    if (!result) {
      TestUtils.printError
        (TestUtils.ExecutionTime.LAST,
         "\nthe call to "+this+
         "\nchanged a method parameter into\n  "+TestUtils.print(obj1)+
         "\nwhich used to be\n  "+TestUtils.print(obj2)+".\nIt should not have been changed.\n");
    }
    return result;
  }

  boolean unchanged_array(Object[] original, Object[] newer) {
      boolean ok_sofar = true;
      
      if (newer.length != original.length) {
	  ok_sofar = false;
      }

      for (int i=0; i<newer.length; i++) {
	  if (newer[i] == null) ok_sofar = (original[i] == null);
	  else ok_sofar = newer[i].equals(original[i]);
      }

      if (!ok_sofar) {
	  TestUtils.printError
	      (TestUtils.ExecutionTime.LAST,
	       "the call to "+this+
	       " has modified the input array "+TestUtils.printArray(original)+
	       "; it has now the elements "+TestUtils.printArray(newer));
	  return ok_sofar;
      }
      return ok_sofar;
  }

  boolean unchanged_array(int[] original, int[] newer) {
      boolean ok_sofar = true;
      
      if (newer.length != original.length) {
	  ok_sofar = false;
      }

      for (int i=0; i<newer.length; i++) {
	  ok_sofar = newer[i] == original[i];
      }

      if (!ok_sofar) {
	  TestUtils.printError
	      (TestUtils.ExecutionTime.LAST,
	       "the call to "+this+
	       " has modified the input array "+TestUtils.printArray(original)+
	       "; it has now the elements "+TestUtils.printArray(newer));
	  return ok_sofar;
      }
      return ok_sofar;
  }

  boolean unchanged_array(char[] original, char[] newer) {
      boolean ok_sofar = true;
      
      if (newer.length != original.length) {
	  ok_sofar = false;
      }

      for (int i=0; i<newer.length; i++) {
	  ok_sofar = newer[i] == original[i];
      }

      if (!ok_sofar) {
	  TestUtils.printError
	      (TestUtils.ExecutionTime.LAST,
	       "the call to "+this+
	       " has modified the input array "+TestUtils.printArray(original)+
	       "; it has now the elements "+TestUtils.printArray(newer));
	  return ok_sofar;
      }
      return ok_sofar;
  }

  boolean setsMatch(Object expected) {
    if (!noException())
      return false;

    if (!(expected instanceof Iterable<?>)) {
      TestData.message("Cannot iterate over expected value "+TestUtils.print(expected));
      throw new RuntimeException();
    }
    Iterable<?> ev = (Iterable<?>) expected;

    E value = result.getValue();
    if (!(value instanceof Iterable<?>)) {
      TestData.message("Cannot iterate over result value "+TestUtils.print(value));
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
      TestUtils.printError
        (TestUtils.ExecutionTime.LAST,
         "\nthe call to "+this+
         " returned a value\n"+TestUtils.print(value)+
         "\nwhich does not contain the same elements as the expected answer"+
         "\n"+expected);
      return false;
    }

    return true;
  }

  // For use in invariant checking code only -- does not report failure
  boolean silentCheckTrueResult() {
    if (result.isException()) {
      TestUtils.printError
	(TestUtils.ExecutionTime.LAST,
	 "\n*** INTERNAL ERROR in tester: an invariant raised an exception\n");
      Throwable throwable = result.getException();
      TestUtils.printCallException(throwable);
      return false;
    }

    E value = result.getValue();

    if (value == null) {
      TestUtils.printError
	(TestUtils.ExecutionTime.LAST,
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
          TestUtils.printError
            (TestUtils.ExecutionTime.LAST,
             "\nthe call to "+this+" returned null, "+
             "but should have returned "+TestUtils.print(expected));
          return false;
        }
        else return true;
      }
      
      if (!value.equals(expected)) {
        TestUtils.printError
          (TestUtils.ExecutionTime.LAST,
           "\nthe call to "+this+" returned\n  "+TestUtils.print(value)+
           "\n\nbut should have returned\n  "+TestUtils.print(expected));
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


static class Constructor extends TestCall<Delivery<String>,Void>
{
  String[] x_1;
  String[] x_1_orig;
  Integer[][] x_2;
  Integer[][] x_2_orig;
  
  public Constructor (String[] x_1,Integer[][] x_2)
  {
    this.x_1 = x_1 ;
    if (x_1 == null)
      x_1_orig = null ;
    else
      x_1_orig = x_1.clone() ;
    this.x_2 = x_2 ;
    if (x_2 == null)
      x_2_orig = null ;
    else
      x_2_orig = x_2.clone() ;
  }
  
  public String toString () 
  {
    StringBuilder output = new StringBuilder() ;
    output.append(new String("new Delivery<String>")) ;
    output.append(new String("(")) ;
    output.append(TesterCode.printer(x_1_orig)) ;
    output.append(new String(", ")) ;
    output.append(TesterCode.printer(x_2_orig)) ;
    output.append(new String(")")) ;
    return output.toString() ;
  }
  
  public Delivery<String> call () 
  {
    return new Delivery<String>(x_1,x_2) ;
  }
  
  public boolean checkResult (Void expected) 
  {
    if (!noException())
      return false ;
    if (!unchanged_array(x_1,x_1_orig))
      return false ;
    if (!unchanged_array(x_2,x_2_orig))
      return false ;
    return true ;
  }
  
}


static class Tour extends TestCall<es.upm.aedlib.positionlist.PositionList<Vertex<String>>,es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean>>
{
  Delivery<String> x_1;
  
  public Tour (Delivery<String> x_1)
  {
    this.x_1 = x_1 ;
  }
  
  public String toString () 
  {
    StringBuilder output = new StringBuilder() ;
    output.append(TesterCode.printer(x_1)) ;
    output.append(new String(".tour")) ;
    output.append(new String("(")) ;
    output.append(new String(")")) ;
    return output.toString() ;
  }
  
  public es.upm.aedlib.positionlist.PositionList<Vertex<String>> call () 
  {
    return x_1.tour() ;
  }
  
  public boolean checkResult (es.upm.aedlib.Pair<es.upm.aedlib.Pair<String[],Integer[][]>,Boolean> expected) 
  {
    if (!noException())
      return false ;
    if (!RouteChecker.tourCorrect(this,result,expected))
      return false ;
    return true ;
  }
  
}


static class GetGraph extends TestCall<DirectedGraph<String,Integer>,es.upm.aedlib.Pair<String[],Integer[][]>>
{
  Delivery<String> x_1;
  
  public GetGraph (Delivery<String> x_1)
  {
    this.x_1 = x_1 ;
  }
  
  public String toString () 
  {
    StringBuilder output = new StringBuilder() ;
    output.append(TesterCode.printer(x_1)) ;
    output.append(new String(".getGraph")) ;
    output.append(new String("(")) ;
    output.append(new String(")")) ;
    return output.toString() ;
  }
  
  public DirectedGraph<String,Integer> call () 
  {
    return x_1.getGraph() ;
  }
  
  public boolean checkResult (es.upm.aedlib.Pair<String[],Integer[][]> expected) 
  {
    if (!noException())
      return false ;
    if (!nonNull())
      return false ;
    if (!RouteChecker.graphCorrect(this,result,expected))
      return false ;
    return true ;
  }
  
}


static class Length extends TestCall<Integer,es.upm.aedlib.Pair<String[],Integer[][]>>
{
  Delivery<String> x_1;
  es.upm.aedlib.positionlist.PositionList<Vertex<String>> tour;
  
  public Length (Delivery<String> x_1,es.upm.aedlib.positionlist.PositionList<Vertex<String>> tour)
  {
    this.x_1 = x_1 ;
    this.tour = tour ;
  }
  
  public String toString () 
  {
    StringBuilder output = new StringBuilder() ;
    output.append(TesterCode.printer(x_1)) ;
    output.append(new String(".length")) ;
    output.append(new String("(")) ;
    output.append(TesterCode.printer(tour)) ;
    output.append(new String(")")) ;
    return output.toString() ;
  }
  
  public Integer call () 
  {
    return x_1.length(tour) ;
  }
  
  public boolean checkResult (es.upm.aedlib.Pair<String[],Integer[][]> expected) 
  {
    if (!noException())
      return false ;
    if (!nonNull())
      return false ;
    if (!RouteChecker.tourLengthCorrect(this,result,expected))
      return false ;
    return true ;
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
      trace.add("  "+callString);
    else
      trace.add(callString);
  }

  public static void modifyLastCallInTrace(String callString) {
    if (trace.size() > 0) {
      trace.remove(trace.size()-1);
    if (!callString.equals(""))
      trace.add("  "+callString);
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

    for (int i=0; i<arr.size(); i++) {
      String item = arr.get(i);
      if (!item.equals("")) {
	sb.append(item+"\n");
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
  static LinkedHashMap<String,Boolean> results_sofar;
  static HashSet<String> runningTests;
  static int numTestsRemaining = 1000;
  static long endTime = 0;

  static void init() {
    results_sofar = new LinkedHashMap<String,Boolean>();
    runningTests = new HashSet<String>();
  }

  static void setNumTestsRemaining(int numTestsToRun, int GlobalTimeoutInSeconds) {
    numTestsRemaining = numTestsToRun;
    endTime = System.currentTimeMillis() + GlobalTimeoutInSeconds*1000;
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
    return (result==null) || result;
  }

  static void add_result(String test_type, boolean result) {
    Boolean old_result = results_sofar.get(test_type);
    if ((old_result == null) || old_result)
      results_sofar.put(test_type,result);
  }

  static boolean results_ok() {
    if (results_sofar.size() == 0) {
      System.out.println("\n*** Error: no tests were run");
      return false;
    }

    if (runningTests.size() > 0) {
      System.out.println("\n*** Error: some tests ("+runningTests.size()+") are still running\n");
      return false;
    }

    for (String key : results_sofar.keySet())
      if (!results_sofar.get(key))
        return false;

    if (numTestsRemaining > 0) {
      System.out.println("\n*** Error: some tests ("+numTestsRemaining+") did not run\n");
      return false;
    }

    return true;
  }

  static int get_nota() {
    if (results_ok()) return 10;
    else return 0;
  }

  static void report_results() {
    System.out.println("\n\n++++++++++++++++++++++++++++++++++++++++++\n");

    for (String testName : results_sofar.keySet()) {
      System.out.print("Testing results for "+testName+": ");
      if (results_sofar.get(testName)) {
        System.out.println("succeeded");
      } else {
        System.out.println("failed");
      }
    }

    System.out.println("\n------------------------------------------");
    if (results_ok()) {
      System.out.println("\n"+Tests.tester+": Test finalizado correctamente.\n");
      System.out.println(readFile("aed_success_message.txt"));
    } else {
      System.out.println("\n"+Tests.tester+": errores detectados.\n\n");
    }
  }

  private static String readFile(String filePath) 
  {
    StringBuilder sb = new StringBuilder();
    Path path = Paths.get(filePath);
 
    if (Files.isReadable(path)) {
      try (Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8)) 
        {
          stream.forEach(s -> sb.append(s).append("\n"));
        }
      catch (IOException e) {};
    }
 
    return sb.toString();
  }
  
}


static class TesterCode
{
  
  public static void resetPrinter () 
  {
  }
  
  public static String printer (Object obj) 
  {
    return TestUtils.standardPrinter(obj) ;
  }
  
}


}
