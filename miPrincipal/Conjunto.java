package miPrincipal;
public class Conjunto {
	static int M = 20; //Aumento de la capacidad
	private Object cto[];
	private int cardinal;
	private int capacidad;
	//Operaciones
	public Conjunto()
	{
		cto = new Object[M];
		cardinal = 0;
		capacidad = M;
	}
	//determina si el conjunto esta vacio
	public boolean esVacio()
	{
	   return (cardinal == 0);
	}
	//añade un elemento si no está en el conjunto
	public Conjunto añadir(Object elemento){
		{
		Conjunto c =new Conjunto();
		if(!pertenece(elemento))
		{
		if(cardinal==capacidad)
		{
			Object[] nuevoCto;
			nuevoCto=new Object[capacidad + M];
			for(int k=0;k<capacidad;k++)
			nuevoCto[k]=cto[k];
			capacidad += M;
			cto=nuevoCto;
				}
				cto[cardinal++]=elemento;
				c.cto=cto;
			}
			return c;
		}
		
		
	}
	//quita el elemento del conjunto

	public Conjunto retirar(Object elemento)
	{
		Conjunto c = new Conjunto();
		if(pertenece(elemento))
		{
			int k=0;
			while (!cto[k].equals(elemento)) 
			k++;

			for(;k<cardinal;k++){
				cto[k] =cto[k+1];
				cardinal--;
				c.cto=cto;

			}
		}
		return c;
	}
	//busca si un elemento pertenece al conjunto
	public boolean pertenece(Object elemento)
	{
		int k=0;
		boolean encontrado=false;
		while(k<cardinal &&! encontrado)
		{
			encontrado=cto[k].equals(elemento);
			k++;
		}
		return encontrado;
	}
	//devuelve el número de elementos
	public int cardinal()
	{
		return this.cardinal;
	}
	//Operacion union de dos conjuntos
	public Conjunto union(Conjunto c2)
	{
		Conjunto u = new Conjunto();
		// primero copia el primer operando de la union
		for(int k = 0;k<cardinal;k++)
			u.cto[k] = cto[k];
		u.cardinal = cardinal;
		//añade los elementos de c2 no incluidos
		for (int k=0;k<c2.cardinal;k++)
			u.añadir(c2.cto[k]);
		return u;
	}
	public Object elemento(int n) throws Exception
	{
	  if (n<=cardinal)
		return cto[--n];
	  else
		throw new Exception("Fuera deRango");
	}
	
	public String toString()
	{
		String s = "{";
		for(int k = 0;k<cardinal;k++)
			s += cto[k].toString() + ",";
		if (cardinal>0)
			s = s.substring(0,s.length()-1);
		s += "}";
		return s;
	}

}