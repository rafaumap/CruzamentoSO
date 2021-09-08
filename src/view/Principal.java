package view;

import java.util.concurrent.Semaphore;

import controller.CarroController;

class Principal {
  public static void main(String[] args) {
      int permissoes = 1;
      Semaphore semaphore = new Semaphore(permissoes);

      for (int idCarro = 1; idCarro <= 4; idCarro++) {
        Thread tCarro = new CarroController(idCarro, semaphore);
        tCarro.start();
      }
  }
}