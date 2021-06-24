package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JunitHooksExample {


  @BeforeAll
  public static void metodaCareVaFiApelataInainteDeRulareaTuturorTestelor() {
    System.out.println("metodaCareVaFiApelataInainteDeRulareaTuturorTestelor");
  }

  @BeforeEach
  public void metodaCareVaFiApelataInainteDeRulareaFiecaruiTest() {
    System.out.println("metodaCareVaFiApelataInainteDeRulareaFiecaruiTest");
  }

  @Test
  public void metoda1() {
    System.out.println("ceva text de la metoda 1");
  }

  @Test
  public void metoda2() {
    System.out.println("ceva text de la metoda 2");
  }

}
