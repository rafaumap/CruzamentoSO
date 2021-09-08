	package controller;

	import java.util.concurrent.Semaphore;

	public class CarroController extends Thread {
	  private int idCarro;
	  private Semaphore semaphore;
	  public static String sentido;

	  public CarroController(int idCarro, Semaphore semaphore) {
	    this.idCarro = idCarro;
	    this.semaphore = semaphore;
	  }

	  @Override
	  public void run() {
	    try {
	      semaphore.acquire();
	      atravessarCruzamento();
	    } catch (Exception error) {
	        error.printStackTrace();
	    } finally {
	      semaphore.release();
	    }
	  }

	  private void atravessarCruzamento() {
	    switch (idCarro) {
	      case 1: 
	        sentido = "baixo";
	        break;
	      case 2 :
	        sentido = "esquerda";
	        break;
	      case 3:
	        sentido = "cima";
	        break;
	      case 4: 
	        sentido = "direita";
	        break;
	    }

	    System.out.println("Carro " + idCarro + " está indo para " + sentido);
	  }
	}