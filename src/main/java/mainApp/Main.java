package mainApp;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	
	/**
	 * Logger
	 */
	private final static Logger LOGGER = LoggerFactory.getLogger(Main.class);
	
	/**
	 * Aplicacion que sumara numeros de X en X empezando desde Y y los ir� sumando Z veces
	 * X: Paso de numero elegido por el usuario.
	 * Y: Numero desde el que comienza la suma dado por el usuario.
	 * Z: Numero de veces que se desea realizar la suma. Tambi�n lo elige el usuario.
	 * @param args
	 */
	public static void main(String[] args) {
		if(LOGGER.isInfoEnabled())
		{
			LOGGER.info("Comienzo de ejecuci�n");
		}
		
		Scanner sc = new Scanner(System.in);
		int inicial =0;
		int paso =0;
		int repeticion =0;
		int resultado =0;
		
		System.out.println("Bienvenido a la aplicaci�n");
		
		System.out.println("�Cual ser� el numero de inicio?");
		boolean inicioValido = false;
		
		/*Creo un bucle para que el usuario no pueda propagar por el codigo un valor inicial que no sea un entero*/
		while(!inicioValido)
		{
			try {
				inicial=Integer.parseInt(sc.nextLine());
				inicioValido=true;
			} catch (Exception e) {
				System.out.println("Introduzca un n�mero por favor");
				LOGGER.error("El usuario introdujo algo que no era un numero como n�mero inicial");
				inicioValido=false;
			}
		}
		
		if(LOGGER.isInfoEnabled())
		{
			LOGGER.info("El usuario eligi� como numero inicial el {}.",inicial);
		}
		
		if(inicial<0)
		{
			if(LOGGER.isWarnEnabled())
			{
				LOGGER.warn("El usuario ha escogido un numero negativo como inicio.");
			}
		}
		
		System.out.println("�Cual desea que sea el paso entre n�meros?");
		boolean pasoValido = false;
		
		/*Creo un bucle pra que el usuario no pueda propagar por el codigo un paso negativo o no entero*/
		while(!pasoValido)
		{
			try {
				paso=Integer.parseInt(sc.nextLine());
				pasoValido=true;
				if(paso<0)
				{
					LOGGER.error("El usuario intent� escoger un numero negativo de paso.");
					System.out.println("No puede ser un paso negativo");
					pasoValido=false;
				}
			} catch (Exception e) {
				LOGGER.error("El usuario intent� meter algo que no era un numero como paso.");
				System.out.println("Introduzca un n�mero v�lido.");
				pasoValido=false;
			}
		}
		
		if(LOGGER.isInfoEnabled())
		{
			LOGGER.info("El usuario eligi� como numero de paso el {}.",paso);
		}
		
		System.out.println("�Cuantas veces desea realizar la suma?");
		boolean repeValido = false;
		
		/*Creo este bucle para que el usuario no pueda escoger un numero de repeticiones no valido*/
		while(!repeValido)
		{
			try {
				repeticion=Integer.parseInt(sc.nextLine());
				repeValido=true;
				if(repeticion<0)
				{
					LOGGER.error("El usuario intent� escoger un numero negativo de veces.");
					System.out.println("No puede ser un numero negativo de veces");
					repeValido=false;
				}
			} catch (Exception e) {
				LOGGER.error("El usuario intent� meter algo que no era un numero como numero de repeticiones.");
				System.out.println("Introduzca un n�mero v�lido.");
				repeValido=false;
			}
		}
		
		if(LOGGER.isInfoEnabled())
		{
			LOGGER.info("El usuario eligi� como numero de repeticiones el {}.",repeticion);
		}
		
		resultado=suma(inicial,paso,repeticion);
		
		System.out.println("El resultado es "+resultado);
		
		if(LOGGER.isInfoEnabled())
		{
			LOGGER.info("El resultado de esta ejecuci�n es {}", resultado);
		}
		
		if(LOGGER.isInfoEnabled())
		{
			LOGGER.info("Fin de ejecuci�n");
		}
	}
	
	/**
	 * Metodo que realiza la suma iterativa
	 * @param inicio numero desde el que se empieza
	 * @param salto paso de numero
	 * @param veces veces a sumar
	 * @return resultado final
	 */
	private static int suma(int inicio, int salto, int veces)
	{
		int siguiente=inicio+salto;
		
		if(LOGGER.isInfoEnabled())
		{
			LOGGER.info("Entra en el metodo suma");
		}
		
		for (int i = 0; i < veces; i++) {
			/*Genero un bucle para que haya suficientes logs como para poner a prueba la partici�n de ficheros*/
			for(int j=0;j<100;j++)
			{
				if(LOGGER.isInfoEnabled())
				{
					LOGGER.info("Iteracion numero {} del metodo suma()",(i+1));
				}
			}
			inicio=inicio+siguiente;
			if(LOGGER.isInfoEnabled())
			{
				LOGGER.info("El resultado de la iteracion es {}", inicio);
			}
			
			/*Control para evitar el overflow*/
			if(inicio>500000000 || inicio<-500000000)
			{
				System.out.println("Se proceder� a parar el programa en la suma numero "+(i+1)+" pues el numero ser�a demasiado grande");
				LOGGER.error("El numero alcanzado en esta iteraci�n es excesivamente grande.");
				break;
			}
			
			siguiente=siguiente+salto;
		}
		
		if(LOGGER.isInfoEnabled())
		{
			LOGGER.info("Terminado el metodo suma");
		}
		
		return inicio;
		
	}

}
