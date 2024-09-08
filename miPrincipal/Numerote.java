package miPrincipal;

public class Numerote {
	
	private int numeros[];
	private int tamanio;
    

    public Numerote(){
    	numeros=new int[1];
        tamanio=0;
    }
    
    public Numerote(int[] n) {
        this.numeros=n;
        tamanio=numeros.length;
    }
    
    public Numerote(int n) {
    	String cadenaValor = String.valueOf(n);
    	// Convertir la cadena a un array de dígitos
    	
     numeros=new int[cadenaValor.length()];
		for (int i=0;i<numeros.length;i++)
    	{
			numeros[i]=cadenaValor.charAt(i)-'0';
		}
    }
    public Numerote(String n) {
    	numeros=new int[n.length()];
		for(int i=0;i<numeros.length;i++){
			numeros[i]=n.charAt(i)-'0';
		}
    }
    public int getTamanio() {
    	return tamanio;
    }
    public int[] getNumero() {
    	return numeros;
    }
    
    public Numerote suma(Numerote b) {
    	// Crear un array para almacenar el resultado de la suma
    	//El tamaño dependerá de la cadena mas larga
        int[] c = new int[Math.max(numeros.length, b.numeros.length) + 1];

        // Llevar la cuenta del acarreo
        int acarreo = 0;

        // Recorrer los dígitos de ambos números de derecha a izquierda
        for(int i=numeros.length-1,j=b.numeros.length-1,k=c.length-1;i>=0 || j>=0;i--,j--,k--) {
        	int op1=(i>=0 ? numeros[i]:0);
        	int op2=(j>=0 ? b.numeros[j]:0);
        	
        	int suma = op1+op2+acarreo;
        	
        	c[k]=suma%10;
        	acarreo = suma /10;
        			 	
        }
       

        // Si hay acarreo, agregarlo al resultado
        if (acarreo > 0) {
            //c[c.length - 1] = acarreo;
        	c[0]=acarreo;
        }
        

        // Crear un nuevo Numerote con el resultado
        c=eliminarCerosIzquierda(c);
        return new Numerote(c);
    }
    
    public Numerote resta(Numerote b) {
    	
    	 // Crear un array para almacenar el resultado de la resta
    	 int[] r = new int[Math.max(numeros.length, b.numeros.length)];

    	 // Llevar la cuenta del préstamo
    	 int prestamo = 0;

    	 // Recorrer los dígitos de ambos números de derecha a izquierda
    	 for (int i = numeros.length - 1, j = b.numeros.length - 1, k = r.length - 1; i >= 0 || j >= 0; i--, j--, k--) {

    	     // Restar los dígitos actuales y el préstamo
    	     int resta = (i >= 0 ? numeros[i] : 0) - (j >= 0 ? b.numeros[j] : 0) - prestamo;

    	     // Si la resta es negativa, tomar prestado 1 del siguiente dígito
    	     if (resta < 0) {
    	         resta += 10;
    	         prestamo = 1;
    	     } else {
    	         prestamo = 0;
    	     }

    	     // Almacenar el resultado de la resta en el array
    	     r[k] = resta;
    	 }

    	 // Eliminar los ceros a la izquierda
    	 
    	r= eliminarCerosIzquierda(r);

    	 // Crear un nuevo Numerote con el resultado
    	 return new Numerote(r);
    	

    }
    private int[] eliminarCerosIzquierda(int[] r ) {
    	 
   	     
   	    StringBuilder nuevaCadena = new StringBuilder();
   

        int j=0;
   	    while(r[j]==0)
   		    j++;
    	  
   	    for (int i=j;i<=r.length-1;i++) 
             nuevaCadena.append(r[i]);
                
        
    	String nCadena = nuevaCadena.toString();
    	
    	char[] caracteres = nCadena.toCharArray();
    	
    	
    	int[] numerosInt = new int[caracteres.length];

    	for (int i = 0; i < caracteres.length; i++) {
    	    numerosInt[i] = caracteres[i] - '0';
    	}
    	
    	return numerosInt;
    	
    }
   
	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();

		for (int numero : numeros) {
		    builder.append(numero);
		}

		String cadena = builder.toString();
		return cadena;
	}
    
    
	

}
