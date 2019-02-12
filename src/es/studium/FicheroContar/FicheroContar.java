package es.studium.FicheroContar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FicheroContar
{
	public static void main(String[] args)
	{
		// Creamos objeto entrada, enlazado al teclado
		BufferedReader entrada= new BufferedReader(new InputStreamReader(System.in));
		String fichero1 = "";
		String s = "";
		String contenido = "";
		int contadorVocales = 0;
		int contadorConsonantes = 0;
		int contadorSignos = 0;
		try
		{
			// Preguntamos al usuario por el nombre del fichero
			System.out.println("Indicar el nombre del primer fichero:");
			fichero1 = entrada.readLine();
			// Origen de los datos
			FileReader fr1 = new FileReader(fichero1);
			// Buffer de lectura
			BufferedReader origen = new BufferedReader(fr1);
			// Sacamos el contenido del fichero y lo guardamos en la variable contenido
			while((s=origen.readLine())!=null)
			{
				contenido += s;
			}
			//Cerrar los objetos
			entrada.close();
			origen.close();
			fr1.close();
			
			// Recorrer la cadena como si fuera un array e ir contando
			for(int i=0; i< contenido.length(); i++)
			{
				switch(contenido.charAt(i))
				{
					case 'a': case 'e': case 'i': case 'o': case 'u':
					case 'A': case 'E': case 'I': case 'O': case 'U':
						case 'á': case 'é': case 'í': case 'ó': case 'ú':
						case 'Á': case 'É': case 'Í': case 'Ó': case 'Ú':
					
						contadorVocales++;
						break;
					case ' ': case ',': case ':': case '.':
						contadorSignos++;
						break;
					case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
						break;
					default:
						contadorConsonantes++;					
				}
			}
			System.out.println("En el archivo hay "+ contadorVocales + " vocales, " + contadorConsonantes + " consonantes y " + contadorSignos + " signos.");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Archivo NO encontrado");
		}
		catch(IOException i)
		{
			System.out.println("Se produjo un error de Archivo");
		}
	}
}