package aula02;
public class Caneta {
        String modelo;
        String cor;
        float ponta;
        int carga;
        boolean tampada;
        
        void status(){
            System.out.println("Modelo: "+this.modelo
                    +"\nCor: "+this.cor+"\nPonta: "
                    +this.ponta+"\nCarga: "+this.carga
                    +"\nTampada: "+this.tampada);
        }
        
       public void rabiscar(){
           if (tampada == true) {
               System.out.println("Erro! Destampe para rabiscar!");
           } else {
               System.out.println("Rabiscando...");
           }
       } 
       public void tampar(){
           tampada = true; 
       }
       public void destampar(){
            tampada = false;
       }
}