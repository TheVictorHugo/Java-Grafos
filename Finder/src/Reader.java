import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Profissional{
	public String nome;
	public double latitude;
	public double longitude;
	public String profissao;
	public String disponivel;
}

class Cliente{
	public String nome;
	public double latitude;
	public double longitude;
}
		

public class Reader {
	public static void main(String[] args) {
		//quando for calcular o raio dividir o grafo
	
			    Scanner ler = new Scanner(System.in);
			    System.out.printf("Informe o nome de arquivo texto:\n");
			    String nome = ler.nextLine();
			    System.out.printf("\nConteudo do arquivo texto:\n");
			    
			    ArrayList<Profissional> listaProfissional = new ArrayList<Profissional>();
			    Cliente cliente = new Cliente();
			    cliente.nome ="Victor Hugo";
			    cliente.latitude= -15.836073;
			    cliente.longitude =-47.912019;
	
			    String array[] = new String[5];
			    try {
			      FileReader arq = new FileReader(nome);
			      BufferedReader lerArq = new BufferedReader(arq);
			 
			      String linha = lerArq.readLine(); 
			      while (linha != null) {
			    	  array = linha.split("[;,] *");
			    	  Profissional p = new Profissional();
			    	  p.nome = array[0];
			    	  p.latitude = Double.parseDouble(array[1]);
			    	  p.longitude = Double.parseDouble(array[2]);
			    	  p.profissao = array[3];
			    	  p.disponivel = array[4];
			    	  
			    	listaProfissional.add(p);
			    	//System.out.printf("%f\n", p.lt);
			        //System.out.printf("%s\n", array[3]);
			        linha = lerArq.readLine();
			        double valor = -15.867068;
			        double valor1 = -47.761822;
			        double valor2 = -7.378871;
			        double valor3 = -37.189213;
			        
			        //double result;
			        //result = distance(valor,valor1,valor2,valor3);
			        //System.out.printf("%f\n",result );
			       
			      }
			 
			      arq.close();
			    } catch (IOException e) {
			        System.err.printf("Erro na abertura do arquivo: %s.\n",
			          e.getMessage());
			    }
			 
			    System.out.println();
			  }
	
	/* Calculate distance between two points in latitude 
	and longitude taking into account height difference. 
	If you are not interested in height difference pass 0.0.
	 Uses Haversine method as its base. lat1, lon1 Start point 
	lat2, lon2 End point el1 Start altitude in meters el2 End altitude 
	in meters */

	public static double distance(double lat1, double lat2, double lon1, double lon2) {

	    final int R = 6371; // Radius of the earth

	    Double latDistance = deg2rad(lat2 - lat1);
	    Double lonDistance = deg2rad(lon2 - lon1);
	    Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distance = R * c * 1000; // convert to meters

	    double height = 1.172;
	    distance = Math.pow(distance, 2) + Math.pow(height, 2);
	    return Math.sqrt(distance);
	}

	private static double deg2rad(double deg) {
	    return (deg * Math.PI / 180.0);
	}
}
