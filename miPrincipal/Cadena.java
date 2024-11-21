package miPrincipal;

public class Cadena {
    private char[] cadena = new char[80]; // Arreglo para almacenar los caracteres
    private int tamanio = 0; // Tamaño actual de la cadena
    private final int TOPE = 80; // Límite máximo de caracteres

    // Constructor por defecto
    public Cadena() {
        this.tamanio = 0;
    }

    // Constructor con arreglo inicial
    public Cadena(char[] cadena) {
        if (cadena.length > TOPE) {
            throw new IllegalArgumentException("La longitud de la cadena excede el límite permitido de " + TOPE);
        }
        System.arraycopy(cadena, 0, this.cadena, 0, cadena.length);
        this.tamanio = cadena.length;
    }

    // Borra el primer elemento de la cadena
    public void borrarInicio() {
        if (vacia()) {
            throw new IllegalStateException("No se puede borrar elementos de una cadena vacía.");
        }
        for (int i = 0; i < tamanio - 1; i++) {
            cadena[i] = cadena[i + 1];
        }
        cadena[tamanio - 1] = '\0'; 
        tamanio--; // Decrementa el tamaño correctamente
    }

    // Agrega un carácter al final, validando restricciones
    public void agregarFinal(char c) throws PosicionIlegalException {
        if (tamanio >= TOPE) {
            throw new PosicionIlegalException("La cadena está llena, no se pueden agregar más caracteres.");
        }

        boolean esLetraMinuscula = (c >= 'a' && c <= 'z');
        boolean esLetraMayuscula = (c >= 'A' && c <= 'Z');
        boolean esDigito = (c >= '0' && c <= '9');

        if (!(esLetraMinuscula || esLetraMayuscula || esDigito)) {
            throw new PosicionIlegalException("Carácter no permitido: " + c);
        }

        cadena[tamanio] = c;
        tamanio++;
    }

    // Verifica si la cadena está vacía
    public boolean vacia() {
        return tamanio == 0;
    }

    // Verifica si la cadena está llena
    public boolean llena() {
        return tamanio == TOPE;
    }

    // Invierte la cadena actual y retorna una nueva instancia
    public Cadena invertir() throws PosicionIlegalException {
        if (vacia()) {
            throw new PosicionIlegalException("La cadena está vacía, no se puede invertir.");
        }

        char[] invertida = new char[tamanio];
        for (int i = 0; i < tamanio; i++) {
            invertida[i] = cadena[tamanio - 1 - i];
        }
        return new Cadena(invertida);
    }

    // Obtiene la cadena como arreglo (solo los caracteres válidos)
    public char[] getCadena() {
        char[] resultado = new char[tamanio];
        System.arraycopy(cadena, 0, resultado, 0, tamanio);
        return resultado;
    }

    // Retorna el tamaño actual de la cadena
    public int tamanio() {
        return tamanio;
    }

    // Representación en texto de la cadena
    @Override
    public String toString() {
        StringBuilder cadenita = new StringBuilder();
        for (int i = 0; i < tamanio; i++) {
            cadenita.append(cadena[i]);
        }
        return cadenita.toString();
    }
}

// Excepción personalizada para posiciones o caracteres inválidos
class PosicionIlegalException extends Exception {
    public PosicionIlegalException() {
        super("Posición ilegal o carácter inválido.");
    }
    public PosicionIlegalException(String mensaje) {
        super(mensaje);
    }
}
