package ar.edu.unlam.pb1.parcial1.prueba;

import ar.edu.unlam.pb1.parcial1.dominio.Televisor;

public class TelevisorPrueba {

	public static void main(String[] args) {

		Televisor grundig= new Televisor((byte)128,(short)1000,(short)1111,(short)650,(short)655);
		Televisor sorny= new Televisor((byte)100,(short)8966,(short)3469,(short)8000,(short)8100);
		Televisor lg= new Televisor((byte)15,(short)666);
		
		//testGetEntradas
		
		/*System.out.println(grundig.getEntradaActual());
		grundig.seleccionarEntrada('C');
		System.out.println(grundig.getEntradaActual());
		grundig.seleccionarEntrada('2');
		System.out.println(grundig.getEntradaActual());*/
		
		//testGetNumeroDeSerie
		/*System.out.println(lg.getNumeroDeSerie());*/
		
		//testNoCambiaCanal
		
		/*grundig.seleccionarEntrada('C');
		System.out.println(grundig.getCanalActual());
		grundig.cambiarDeCanal('9');
		System.out.println(grundig.getCanalActual());
		grundig.seleccionarEntrada('U');
		grundig.cambiarDeCanal('4');
		grundig.subirOBajarAnalogicamente('<');
		grundig.subirOBajarAnalogicamente('>');
		System.out.println(grundig.getCanalActual());
		grundig.seleccionarEntrada('2');
		grundig.cambiarDeCanal('6');
		System.out.println(grundig.getCanalActual());
		grundig.seleccionarEntrada('A');
		grundig.cambiarDeCanal('3');
		System.out.println(grundig.getCanalActual());*/
		
		//testCanalesMaximos
		
		System.out.println(grundig.toString());
		grundig.seleccionarEntrada('A');
		System.out.println(grundig.toString());
		grundig.cambiarDeCanal('1', '2', '7');
		System.out.println(grundig.getCanalActual());
		grundig.subirOBajarAnalogicamente('>');
		System.out.println(grundig.getCanalActual());
		grundig.seleccionarEntrada('C');
		System.out.println(grundig.toString());
		grundig.cambiarDeCanal('1', '0', '0','0');
		System.out.println(grundig.getCanalActual());
		grundig.subirOBajarAnalogicamente('>');
		System.out.println(grundig.getCanalActual());
		
		
		//testLimitesVolumen
		
		/*grundig.setVolumenActual((byte)100);
		System.out.println(grundig.getVolumenActual());
		grundig.subirOBajarAnalogicamente('+');
		System.out.println(grundig.getVolumenActual());
		grundig.setVolumenActual((byte)0);
		System.out.println(grundig.getVolumenActual());
		grundig.subirOBajarAnalogicamente('-');
		System.out.println(grundig.getVolumenActual());*/
		
		//testDefinirControlParental
		
		/*System.out.println(sorny.isControlParenteralActivado());
		sorny.activarControlParenteral('6', '6', '4', '3');
		System.out.println(sorny.isControlParenteralActivado());
		sorny.activarControlParenteral('3', '4', '6', '9');
		System.out.println(sorny.isControlParenteralActivado());
		sorny.deactivarControlParenteral('1', '2', '4', '3');
		System.out.println(sorny.isControlParenteralActivado());
		sorny.deactivarControlParenteral('3', '4', '6', '9');
		System.out.println(sorny.isControlParenteralActivado());*/
		
		//testEncender
		
		/*System.out.println(grundig.isEncendido());
		grundig.encenderOApagar();
		System.out.println(grundig.isEncendido());
		grundig.encenderOApagar();
		System.out.println(grundig.isEncendido());*/
		
		//testToString
		
		/*System.out.println(sorny.toString());
		sorny.cambiarDeCanal('1', '4');
		System.out.println(sorny.toString());
		sorny.seleccionarEntrada('U');
		System.out.println(sorny.toString());
		sorny.setVolumenActual((byte)100);
		System.out.println(sorny.toString());
		sorny.seleccionarEntrada('C');
		sorny.cambiarDeCanal('6', '4','6');
		System.out.println(sorny.toString());
		sorny.activarControlParenteral('3', '4', '6', '9');
		System.out.println(sorny.toString());
		sorny.seleccionarEntrada('A');
		sorny.cambiarDeCanal('1', '7');
		System.out.println(sorny.toString());*/
		
		//testSeleccionarEntrada
		
		/*System.out.println(lg.getEntradaActual());
		lg.seleccionarEntrada('C');
		System.out.println(lg.getEntradaActual());
		lg.seleccionarEntrada('1');
		System.out.println(lg.getEntradaActual());
		lg.seleccionarEntrada('2');
		System.out.println(lg.getEntradaActual());
		lg.seleccionarEntrada('U');
		System.out.println(lg.getEntradaActual());
		lg.seleccionarEntrada('A');
		System.out.println(lg.getEntradaActual());*/
		
		//testSubirOBajarAnalogicamente
		
		//parte 1 (volumen)
		
		/*System.out.println(grundig.toString());
		grundig.subirOBajarAnalogicamente('-');
		grundig.subirOBajarAnalogicamente('-');
		grundig.subirOBajarAnalogicamente('-');
		System.out.println(grundig.toString());
		grundig.subirOBajarAnalogicamente('+');
		System.out.println(grundig.toString());
		grundig.setVolumenActual((byte)0);
		grundig.subirOBajarAnalogicamente('-');
		System.out.println(grundig.toString());
		grundig.setVolumenActual((byte)100);
		grundig.subirOBajarAnalogicamente('+');
		System.out.println(grundig.toString());*/
		
		//parte 2 (canales)
		
		System.out.println(grundig.toString());
		grundig.subirOBajarAnalogicamente('<');
		System.out.println(grundig.toString());
		grundig.subirOBajarAnalogicamente('>');
		grundig.subirOBajarAnalogicamente('>');
		grundig.subirOBajarAnalogicamente('>');
		System.out.println(grundig.toString());
		grundig.seleccionarEntrada('U');
		grundig.subirOBajarAnalogicamente('>');
		grundig.subirOBajarAnalogicamente('>');
		grundig.subirOBajarAnalogicamente('>');
		System.out.println(grundig.getCanalActual());
		System.out.println(grundig.toString());
		grundig.seleccionarEntrada('C');
		System.out.println(grundig.toString());
		grundig.subirOBajarAnalogicamente('<');
		System.out.println(grundig.toString());
		grundig.activarControlParenteral('1', '1', '1', '1');
		System.out.println(grundig.toString());
		grundig.cambiarDeCanal('6', '4','9');
		grundig.subirOBajarAnalogicamente('>');
		grundig.subirOBajarAnalogicamente('>');
		grundig.subirOBajarAnalogicamente('>');
		System.out.println(grundig.toString());
		grundig.subirOBajarAnalogicamente('<');
		grundig.subirOBajarAnalogicamente('<');
		grundig.subirOBajarAnalogicamente('<');
		grundig.subirOBajarAnalogicamente('<');
		System.out.println(grundig.toString());
		
		//testCambiarDeCanal
		
		/*sorny.cambiarDeCanal('4');
		System.out.println(sorny.getCanalActual());
		sorny.seleccionarEntrada('U');
		sorny.cambiarDeCanal('8');
		System.out.println(sorny.getCanalActual());
		sorny.seleccionarEntrada('C');
		System.out.println(sorny.getCanalActual());
		sorny.cambiarDeCanal('8','9');
		System.out.println(sorny.getCanalActual());
		sorny.cambiarDeCanal('8','9','6');
		System.out.println(sorny.getCanalActual());
		sorny.cambiarDeCanal('8','9','6','5');
		System.out.println(sorny.getCanalActual());
		sorny.cambiarDeCanal('8','9','6','7');
		System.out.println(sorny.getCanalActual());
		sorny.cambiarDeCanal('0','1','6','0');
		System.out.println(sorny.getCanalActual());
		sorny.activarControlParenteral('3', '4', '6', '9');
		System.out.println(sorny.isControlParenteralActivado());
		sorny.cambiarDeCanal('8','0','6','0');
		System.out.println(sorny.getCanalActual());	
		sorny.deactivarControlParenteral('3', '4', '6', '9');
		System.out.println(sorny.isControlParenteralActivado());
		sorny.cambiarDeCanal('8','0','6','0');
		System.out.println(sorny.getCanalActual());	*/
		
		//testVolverAlCanalAnterior
		
		/*grundig.seleccionarEntrada('C');
		System.out.println(grundig.toString());
		grundig.cambiarDeCanal('2', '2');
		System.out.println(grundig.getCanalActual());
		grundig.volverAlCanalAnterior();
		System.out.println(grundig.getCanalActual());
		grundig.cambiarDeCanal('7', '2','6');
		System.out.println(grundig.getCanalActual());
		grundig.cambiarDeCanal('7', '0','0');
		System.out.println(grundig.getCanalActual());
		grundig.cambiarDeCanal('6', '0','0');
		System.out.println(grundig.getCanalActual());
		grundig.volverAlCanalAnterior();
		System.out.println(grundig.getCanalActual());*/
		
		//testSilenciar
		
		/*grundig.setVolumenActual((byte)50);
		System.out.println(grundig.getVolumenActual());
		grundig.silenciar();
		System.out.println(grundig.getVolumenActual());
		grundig.silenciar();
		System.out.println(grundig.getVolumenActual());*/
		
		//testActivarControlParental
		
		/*System.out.println(grundig.toString());
		grundig.activarControlParenteral('1', '1', '1', '2');
		System.out.println(grundig.isControlParenteralActivado());
		grundig.activarControlParenteral('1', '1', '1', '1');
		System.out.println(grundig.isControlParenteralActivado());
		grundig.deactivarControlParenteral('1', '1', '1', '2');
		System.out.println(grundig.isControlParenteralActivado());
		grundig.deactivarControlParenteral('1', '1', '1', '1');
		System.out.println(grundig.isControlParenteralActivado());*/
		
		//testGetCanalActual
		
		/*System.out.println(grundig.getCanalActual());
		grundig.cambiarDeCanal('1', '1');
		System.out.println(grundig.getCanalActual());
		grundig.seleccionarEntrada('U');
		System.out.println(grundig.getCanalActual());
		grundig.cambiarDeCanal('1', '8');
		System.out.println(grundig.getCanalActual());
		grundig.seleccionarEntrada('A');
		grundig.cambiarDeCanal('1', '4');
		System.out.println(grundig.getCanalActual());*/
		
		//testGetVolumenActual 
		
		/*grundig.setVolumenActual((byte)20);
		System.out.println(grundig.getVolumenActual());
		grundig.silenciar();
		System.out.println(grundig.getVolumenActual());
		grundig.silenciar();
		System.out.println(grundig.getVolumenActual());
		grundig.setVolumenActual((byte)101);
		System.out.println(grundig.getVolumenActual());
		grundig.setVolumenActual((byte)100);
		System.out.println(grundig.getVolumenActual());*/
		
		
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
	}
}
		
		
		
	
		 
		
		
		
		
		
	
		
