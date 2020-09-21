package ar.edu.unlam.pb1.parcial1.dominio;

public class Televisor {
	private static final char ENTRADA_TELEVISION_DE_AIRE='A';
	private static final char ENTRADA_TELEVISION_POR_CABLE='C';
	private static final char ENTRADA_HDMI1='1';
	private static final char ENTRADA_HDMI2='2';
	private static final char ENTRADA_USB='U';
	private static long contadorDePlaquetasProducidas=0;
	private char entradaActual;
	private byte canalDeAire;
	private short canalDeCable;
	private boolean encendido;
	private byte volumenActual;
	private final long NUMERO_DE_SERIE;
	private final byte CANAL_MAXIMO_TELEVISION_ABIERTA;
	private final short CANAL_MAXIMO_TELEVISION_POR_CABLE;
	private final short CLAVE_CONTROL_PARENTERAL;
	private final short CANAL_PARA_MAYORES_INICIAL;
	private final short CANAL_PARA_MAYORES_FINAL;
	private short canalAnterior;
	private boolean controlParenteralActivado;
	private short canalActual;
	
 	public Televisor(byte canalMaximoTelevisionAbierta,short canalMaximoTelevisionPorCable) {
		contadorDePlaquetasProducidas++;
		NUMERO_DE_SERIE=contadorDePlaquetasProducidas;
		volumenActual=0;
		encendido=false;
		entradaActual=ENTRADA_TELEVISION_POR_CABLE;
		canalDeAire=1;
		canalDeCable=1;
		canalActual=1;
		CLAVE_CONTROL_PARENTERAL=0;
		CANAL_PARA_MAYORES_INICIAL=0;
		CANAL_PARA_MAYORES_FINAL=0;
		if(canalMaximoTelevisionAbierta>0&&canalMaximoTelevisionAbierta<=127) {
		this.CANAL_MAXIMO_TELEVISION_ABIERTA=canalMaximoTelevisionAbierta;
		}
		else 
			CANAL_MAXIMO_TELEVISION_ABIERTA=127;		
		if(canalMaximoTelevisionPorCable>0&&canalMaximoTelevisionPorCable<=32767) {
			this.CANAL_MAXIMO_TELEVISION_POR_CABLE=canalMaximoTelevisionPorCable;
			}
			else 
				CANAL_MAXIMO_TELEVISION_POR_CABLE=32767;
	}
	public Televisor(byte canalMaximoTelevisionAbierta,short canalMaximoTelevisionPorCable,short claveControlParenteral,
			short canalParaMayoresInicial,short canalParaMayoresFinal) {
		contadorDePlaquetasProducidas++;
		NUMERO_DE_SERIE=contadorDePlaquetasProducidas;
		volumenActual=0;  
		encendido=false;
		controlParenteralActivado=false;
		entradaActual=ENTRADA_TELEVISION_POR_CABLE;
		canalDeAire=1;
		canalDeCable=1;
		canalActual=1;
		if(canalMaximoTelevisionAbierta>0&&canalMaximoTelevisionAbierta<=127) {
			this.CANAL_MAXIMO_TELEVISION_ABIERTA=canalMaximoTelevisionAbierta;
			}
			else 
				CANAL_MAXIMO_TELEVISION_ABIERTA=127;		
			if(canalMaximoTelevisionPorCable>0&&canalMaximoTelevisionPorCable<=32767) {
				this.CANAL_MAXIMO_TELEVISION_POR_CABLE=canalMaximoTelevisionPorCable;
				}
				else 
					CANAL_MAXIMO_TELEVISION_POR_CABLE=32767;
		
		if(canalParaMayoresInicial>0&&canalParaMayoresInicial<=32767) {
			this.CANAL_PARA_MAYORES_INICIAL=canalParaMayoresInicial;
			}
			else 
				CANAL_PARA_MAYORES_INICIAL=0;
		if(canalParaMayoresFinal>=canalParaMayoresInicial&&canalParaMayoresFinal<=32767) {
			this.CANAL_PARA_MAYORES_FINAL=canalParaMayoresFinal;
			}
			else 
				CANAL_PARA_MAYORES_FINAL=32767;
		if(claveControlParenteral>0&&claveControlParenteral<=9999) {
			this.CLAVE_CONTROL_PARENTERAL=claveControlParenteral;	
			}
			else
				this.CLAVE_CONTROL_PARENTERAL=9999;	
				}

	public void encenderOApagar() {
		if (encendido==true) {
			encendido=false;
		}
		else {
			encendido=true;
		}
	}
	public String toString() {              
		String mensaje="";
		switch (entradaActual) {
		case 'A':
			mensaje="Usted esta viendo el canal "+canalActual+" de aire"+" a volumen "+volumenActual;
			break;
		case 'C':
			if(controlParenteralActivado==true) {
			mensaje="Usted esta viendo el canal "+canalActual+" de cable"+" a volumen " + volumenActual +". El control parental esta activado";
			}
			else {
				mensaje="Usted esta viendo el canal "+canalActual+" de cable"+" a volumen " + volumenActual +". El control parental esta desactivado";	
			}
			break;				
		case '1':
			mensaje="Usted esta utilizando la entrada HDMI1 "+"a volumen " + volumenActual;
			break;
		case '2':
			mensaje="Usted esta utilizando la entrada HDMI2 "+"a volumen " + volumenActual;
			break;
		case 'U':
			mensaje="Usted esta utilizando la entrada USB "+"a volumen " + volumenActual;
			break;
			
		}
		return mensaje;
		
	}
	public void seleccionarEntrada(char entradaDeseada) {   
		switch (entradaDeseada) {
		case 'A':
			entradaActual=ENTRADA_TELEVISION_DE_AIRE;
			canalDeAire=1;
			canalActual=1;
			canalAnterior=canalDeAire;
			break;
		case 'C':
			entradaActual=ENTRADA_TELEVISION_POR_CABLE;
			canalDeCable=1;
			canalActual=1;
			canalAnterior=canalDeCable;
			break;
		case '1':
			entradaActual=ENTRADA_HDMI1;
			break;
		case '2':
			entradaActual=ENTRADA_HDMI2;
			break;
		case 'U':
			entradaActual=ENTRADA_USB;
			break;
		}
	}
	public void subirOBajarAnalogicamente(char operacion) {    		
		switch(operacion) {
		case '+':
			if(volumenActual<100) {
			volumenActual++;
			break;
			}
			break;
		case '-':
			if(volumenActual>0) {
				volumenActual--;
				break;
				}
			break;
		case '>':
			if (entradaActual==ENTRADA_TELEVISION_DE_AIRE) {
				if (canalDeAire<CANAL_MAXIMO_TELEVISION_ABIERTA) {
					canalAnterior=canalDeAire;
					canalDeAire++;
					canalActual=canalDeAire;
					break;	
				}
				else
					canalAnterior=canalDeAire;
					canalDeAire=1;
					canalActual=canalDeAire;
				break;
			}
			if (entradaActual==ENTRADA_TELEVISION_POR_CABLE) {                                        
				if (controlParenteralActivado==true) {
					if (canalDeCable++<CANAL_MAXIMO_TELEVISION_POR_CABLE) {								
						if (canalDeCable++<CANAL_PARA_MAYORES_INICIAL) {    
							canalAnterior=canalDeCable;
							canalDeCable++;
							canalActual=canalDeCable;
							break;	
				}
				 if(CANAL_PARA_MAYORES_FINAL==CANAL_MAXIMO_TELEVISION_POR_CABLE) {
					 canalAnterior=canalDeCable;
					 canalDeCable=1;
					 canalActual=canalDeCable;
					 break;
				 }
				if(canalDeCable++>=CANAL_PARA_MAYORES_INICIAL) {    
					canalAnterior=canalDeCable; 
					canalDeCable=(short) (CANAL_PARA_MAYORES_FINAL+1);
					 canalActual=canalDeCable;
					 break;
				 }
				
			}
					else
						canalAnterior=canalDeCable;
						canalDeCable=1;
						canalActual=canalDeCable;
					break;
				}
				if (canalDeCable<CANAL_MAXIMO_TELEVISION_POR_CABLE) {
					canalAnterior=canalDeCable;
					canalDeCable++;
					canalActual=canalDeCable;
					break;	
				}
				else 
					canalAnterior=canalDeCable;
					canalDeCable=1;
					canalActual=canalDeCable;
				break;
		}
			break;
		case '<':
			if(entradaActual==ENTRADA_TELEVISION_DE_AIRE) {
				if (canalDeAire==1) {
				canalAnterior=canalDeAire;
				canalDeAire=CANAL_MAXIMO_TELEVISION_ABIERTA;
				canalActual=canalDeAire;
				break;
				}
			else {
				canalAnterior=canalDeAire;
				canalDeAire--;
				canalActual=canalDeAire;
				break;
			}
			}
			if (entradaActual==ENTRADA_TELEVISION_POR_CABLE) {
				if (controlParenteralActivado==true) {
					if (canalDeCable-1==CANAL_PARA_MAYORES_FINAL) {
						canalAnterior=canalDeCable;
						canalDeCable=(short) (CANAL_PARA_MAYORES_INICIAL-1);
						canalActual=canalDeCable;
						break;
						}
					}
					if (canalDeCable==1 && CANAL_MAXIMO_TELEVISION_POR_CABLE==CANAL_PARA_MAYORES_FINAL) {
						canalAnterior=canalDeCable;
						canalDeCable=(short) (CANAL_PARA_MAYORES_INICIAL-1);
						canalActual=canalDeCable;
						break;
					}
								
					if (canalDeCable==1) {
						canalAnterior=canalDeCable;
						canalDeCable=CANAL_MAXIMO_TELEVISION_POR_CABLE;
						canalActual=canalDeCable;
						break;	
					}
					else 
						canalAnterior=canalDeCable;
						--canalDeCable;
						canalActual=canalDeCable;
					break;
				}
				break;

			}
		}

	public void cambiarDeCanal(char canalDeseado) {            	
		short cambioCanal=convertirAShort1(canalDeseado);
		if(entradaActual==ENTRADA_TELEVISION_DE_AIRE) {
		if (cambioCanal<=this.CANAL_MAXIMO_TELEVISION_ABIERTA) {
			canalAnterior=canalDeAire;
			this.canalDeAire=(byte)cambioCanal;
			canalActual=canalDeAire;
		}
	}
		if (entradaActual==ENTRADA_TELEVISION_POR_CABLE) {
			if (controlParenteralActivado==true) {
				if (cambioCanal>=CANAL_PARA_MAYORES_INICIAL&&cambioCanal<=CANAL_PARA_MAYORES_FINAL) {
					canalDeCable=canalActual;
			}
				else if (cambioCanal<=this.CANAL_MAXIMO_TELEVISION_POR_CABLE) {
				canalAnterior=canalDeCable;
				this.canalDeCable=cambioCanal;
				canalActual=canalDeCable;
				}
				
					}
			else			
				if (cambioCanal<=this.CANAL_MAXIMO_TELEVISION_POR_CABLE) {
				canalAnterior=canalDeCable;
				this.canalDeCable=cambioCanal;
				canalActual=canalDeCable;
				}
	}
	}
	public void cambiarDeCanal(char primerDigito,char segundoDigito){     
		short cambioCanalDigito1=convertirAShort10(primerDigito);
		short cambioCanalDigito2=convertirAShort1(segundoDigito);
		short cambioCanal=(short) (cambioCanalDigito1+cambioCanalDigito2);
		if(entradaActual==ENTRADA_TELEVISION_DE_AIRE) {
			if (cambioCanal<=this.CANAL_MAXIMO_TELEVISION_ABIERTA) {
				canalAnterior=canalDeAire;
				this.canalDeAire=(byte) cambioCanal;
				canalActual=canalDeAire;
			}
			}
		if (entradaActual==ENTRADA_TELEVISION_POR_CABLE) {
			if (controlParenteralActivado==true) {
				if (cambioCanal>=CANAL_PARA_MAYORES_INICIAL&&cambioCanal<=CANAL_PARA_MAYORES_FINAL) {
					canalDeCable=canalActual;
			}
				else if (cambioCanal<=this.CANAL_MAXIMO_TELEVISION_POR_CABLE) {
				canalAnterior=canalDeCable;
				this.canalDeCable=cambioCanal;
				canalActual=canalDeCable;
				}
				
					}
			else			
				if (cambioCanal<=this.CANAL_MAXIMO_TELEVISION_POR_CABLE) {
				canalAnterior=canalDeCable;
				this.canalDeCable=cambioCanal;
				canalActual=canalDeCable;
				}
	}
	}
	public void cambiarDeCanal(char primerDigito,char segundoDigito,char tercerDigito){     
		short cambioCanalDigito1=convertirAShort100(primerDigito);
		short cambioCanalDigito2=convertirAShort10(segundoDigito);
		short cambioCanalDigito3=convertirAShort1(tercerDigito);
		short cambioCanal=(short) (cambioCanalDigito1+cambioCanalDigito2+cambioCanalDigito3);
		if(entradaActual==ENTRADA_TELEVISION_DE_AIRE) {			
			if (cambioCanal<=this.CANAL_MAXIMO_TELEVISION_ABIERTA) {
				canalAnterior=canalDeAire;
				this.canalDeAire=(byte) cambioCanal;
				canalActual=canalDeAire;
		}
		}
		if (entradaActual==ENTRADA_TELEVISION_POR_CABLE) {
			if (controlParenteralActivado==true) {
				if (cambioCanal>=CANAL_PARA_MAYORES_INICIAL&&cambioCanal<=CANAL_PARA_MAYORES_FINAL) {
					canalDeCable=canalActual;
			}
				else if (cambioCanal<=this.CANAL_MAXIMO_TELEVISION_POR_CABLE) {
				canalAnterior=canalDeCable;
				this.canalDeCable=cambioCanal;
				canalActual=canalDeCable;
				}
				
					}
			else			
				if (cambioCanal<=this.CANAL_MAXIMO_TELEVISION_POR_CABLE) {
				canalAnterior=canalDeCable;
				this.canalDeCable=cambioCanal;
				canalActual=canalDeCable;
				}
	}
	}
	public void cambiarDeCanal(char primerDigito,char segundoDigito,char tercerDigito,char cuartoDigito){ 
		short cambioCanalDigito1=convertirAShort1000(primerDigito);
		short cambioCanalDigito2=convertirAShort100(segundoDigito);
		short cambioCanalDigito3=convertirAShort10(tercerDigito);
		short cambioCanalDigito4=convertirAShort1(cuartoDigito);
		short cambioCanal=(short) (cambioCanalDigito1+cambioCanalDigito2+cambioCanalDigito3+cambioCanalDigito4);
		
		if (entradaActual==ENTRADA_TELEVISION_DE_AIRE) {
			if (cambioCanal<=this.CANAL_MAXIMO_TELEVISION_ABIERTA)
				canalAnterior=canalDeAire;
				this.canalDeAire=(byte) cambioCanal;
				canalActual=canalDeAire;		
			}
		
		if (entradaActual==ENTRADA_TELEVISION_POR_CABLE) {
			if (controlParenteralActivado==true) {
				if (cambioCanal>=CANAL_PARA_MAYORES_INICIAL&&cambioCanal<=CANAL_PARA_MAYORES_FINAL) {
					canalDeCable=canalActual;
			}
				else if (cambioCanal<=this.CANAL_MAXIMO_TELEVISION_POR_CABLE) {
				canalAnterior=canalDeCable;
				this.canalDeCable=cambioCanal;
				canalActual=canalDeCable;
				}
				
					}
			else			
				if (cambioCanal<=this.CANAL_MAXIMO_TELEVISION_POR_CABLE) {
				canalAnterior=canalDeCable;
				this.canalDeCable=cambioCanal;
				canalActual=canalDeCable;
				}
	}
	}
	public void volverAlCanalAnterior() {
		if (entradaActual==ENTRADA_TELEVISION_DE_AIRE) {
			canalDeAire=(byte)canalAnterior;
			canalActual=canalAnterior;
		}
		else if (entradaActual==ENTRADA_TELEVISION_POR_CABLE){
			canalDeCable=canalAnterior;
			canalActual=canalAnterior;
		}
	}
	public void silenciar() {
		if(volumenActual>0) {
		volumenActual=0;
		}
		else if(volumenActual==0) {
			volumenActual=15;
		}
	}
	public void activarControlParenteral(char primerDigitoDeLaClave,char segundoDigitoDeLaClave,char tercerDigitoDeLaClave,char cuartoDigitoDeLaClave) {
		short claveDigito1=convertirAShort1000(primerDigitoDeLaClave);
		short claveDigito2=convertirAShort100(segundoDigitoDeLaClave);
		short claveDigito3=convertirAShort10(tercerDigitoDeLaClave);
		short claveDigito4=convertirAShort1(cuartoDigitoDeLaClave);
		short clave=(short)(claveDigito1+claveDigito2+claveDigito3+claveDigito4);
		if(this.CLAVE_CONTROL_PARENTERAL==clave) {
			controlParenteralActivado=true;
		}
	}
	public void deactivarControlParenteral(char primerDigitoDeLaClave,char segundoDigitoDeLaClave,char tercerDigitoDeLaClave,char cuartoDigitoDeLaClave){
		short claveDigito1=convertirAShort1000(primerDigitoDeLaClave);
		short claveDigito2=convertirAShort100(segundoDigitoDeLaClave);
		short claveDigito3=convertirAShort10(tercerDigitoDeLaClave);
		short claveDigito4=convertirAShort1(cuartoDigitoDeLaClave);
		short clave=(short)(claveDigito1+claveDigito2+claveDigito3+claveDigito4);
		if(this.CLAVE_CONTROL_PARENTERAL==clave) {
			controlParenteralActivado=false;
		}
	}
	public char getEntradaTelevisionDeAire() {
		return ENTRADA_TELEVISION_DE_AIRE;
	}
	public char getEntradaTelevisionPorCable() {
		return ENTRADA_TELEVISION_POR_CABLE;
	}
	public char getEntradaHdmi1() {
		return ENTRADA_HDMI1;
	}
	public char getEntradaHdmi2() {
		return ENTRADA_HDMI2;
	}
	public char getEntradaUsb() {
		return ENTRADA_USB;
	}
	public long getNumeroDeSerie() {
		return NUMERO_DE_SERIE;
	}
	public boolean isEncendido() {
		return encendido;
	}
	public boolean isControlParenteralActivado() {
		return controlParenteralActivado;
	}
	public byte getVolumenActual() {
		return volumenActual;
	}
	public short getCanalActual() {
		return canalActual;
	}
	public char getEntradaActual() {
		return entradaActual;
	}
	private short convertirAShort1(char primerDigito) {
		return (short)(primerDigito-48);		
}
	private short convertirAShort10(char segundoDigito) {
		return (short)((segundoDigito-48)*10);
}
	private short convertirAShort100(char tercerDigito) {
		return (short)((tercerDigito-48)*100);
}
	private short convertirAShort1000(char cuartoDigito) {
		return (short)((cuartoDigito-48)*1000);
}
	public void setVolumenActual(byte volumenActual) {
		if (volumenActual>=0&&volumenActual<=100) {
			this.volumenActual = volumenActual;
		}

	}
}
	
