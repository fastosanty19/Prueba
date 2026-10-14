package ejercicios;
import java.util.Random;
import java.util.Scanner;

public class Game {

	    private Scanner input = new Scanner(System.in);
	    private Random random = new Random();

	    public void play() {
	        //start game
	        System.out.println("Vamos a jugar al papel piedra o tijera!");
	        System.out.println("Escribe \"piedra\", \"papel\", or \"tijera\" para indicar tu eleccion. En caso contrario escribe \"salir\" para salir.");
	        String eleccion = input.nextLine(); //mensaje escrito por el usuario
	        eleccion = eleccion.toLowerCase(); //change to lowercase for consistency

	        //inicializar variables
	        int numEmpates = 0;
	        int numGanados = 0;
	        int numPerdidos = 0;

	        while (!eleccion.equals("salir")) //hacer esto mientras el usuario no escriba salir
	        {
	            int numElegido = 0;
	            if (eleccion.equals("piedra")) //asignar un 1 si ha escogido piedra
	            {
	            	numElegido = 1;
	            }
	            else if (eleccion.equals("papel")) //asignar un 2 si ha escodigo papel
	            {
	            	numElegido = 2;
	            }
	            else if (eleccion.equals("tijera"))//asignar un 3 si ha escogido tijera
	            {
	            	numElegido = 3;
	            }
	            else // respuestas no validas
	            {
	                while(numElegido == 0) //Si es 0 la respuesta no es valida y continua pidiendo datos
	                {
	                    System.out.println("Lo siento no has elegido una opcion correcta intentelo de nuevo.");
	                    eleccion = input.nextLine();
	                    eleccion = eleccion.toLowerCase();
	                    if (eleccion.equals("piedra"))
	                    {
	                    	numElegido = 1;
	                    }
	                    else if (eleccion.equals("papel"))
	                    {
	                    	numElegido = 2;
	                    }
	                    else if (eleccion.equals("tijera"))
	                    {
	                    	numElegido = 3;
	                    }
	                    else if (eleccion.equals("salir"))
	                        System.exit(0); //salir del programa
	                }
	            }
	            int numAlAzar = (int) (random.nextInt(3)) + 1;//numero aleatorio generado por el programa
	            
	            if (numAlAzar == 1) System.out.println("El ordenador eligio piedra");
	            if (numAlAzar == 2) System.out.println("El ordenador eligio papel");
	            if (numAlAzar == 3) System.out.println("El ordenador eligio tijera");


	            if(numElegido == numAlAzar) //Empate
	            {
	                System.out.println("Empate!");
	                numEmpates++;
	            }
	            else if (numElegido == 1 && numAlAzar == 3)//usuario gano roca vs tijeras
	            {
	                System.out.println("Has ganado!");
	                numGanados++;
	            }
	            else if (numElegido == 3 && numAlAzar == 2) //usuario gano tijera vs papel
	            {
	                System.out.println("Has ganado!");
	                numGanados++;
	            }
	            else if (numElegido == 2 && numAlAzar ==1) // usuario gano papel vs piedra
	            {
	                System.out.println("Has ganado!");
	                numGanados++;
	            }
	            else //en los demas casos gana el ordenador.
	            {
	                System.out.println("Perdiste.");
	                numPerdidos++;
	            }
	            mostrarResultados(numGanados,numPerdidos,numEmpates);
	            System.out.println("Jugemos de nuevo! \n \n"); 
	            System.out.println("Escribe \"piedra\", \"papel\", o \"tijera\" . Escribe \"salir\" para terminar el juego.");
	            eleccion = input.nextLine(); 
	            eleccion = eleccion.toLowerCase();
	        }
	        if(eleccion.equals("salir")) 
	            return;
	    }
	    public void mostrarResultados(int numGanados, int numPerdidos, int numEmpates) {
            System.out.println("Partidas ganadas:" + numGanados + "\n partidas perdidas:" + numPerdidos + "\n partidas empatadas:" + numEmpates); //print out number of wins, ties, and loses

	    }
	    
	    public static void main(String[] args) {
			// TODO Auto-generated method stub
		      Game game = new Game();
		       game.play();
		}
	    
}
