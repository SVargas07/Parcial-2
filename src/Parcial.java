public class Parcial {
    // Método para calcular la potencia de un número b elevado a la potencia e
    public int calcularPotencia(int b, int e) {
        try {
            // Verificar si la potencia es negativa
            if (e < 0) {
                throw new IllegalArgumentException("La potencia no puede ser negativa");
            }

            // Verificar si el resultado excede el valor máximo permitido
            if (e > 31 || b > 46340) { // El mayor valor que podemos elevar sin exceder Integer.MAX_VALUE
                throw new ArithmeticException("El resultado excede el valor máximo permitido");
            }

            // Calcular la potencia
            int resultado = (int) Math.pow(b, e);

            // Verificar si el resultado es válido
            if (resultado > Integer.MAX_VALUE) {
                throw new ArithmeticException("El resultado excede el valor máximo permitido");
            }

            return resultado;
        } catch (IllegalArgumentException | ArithmeticException ex) {
            System.err.println("Error: " + ex.getMessage());
            return 0; // Retorna 0 si hay algún error
        }
    }

    // Método main para probar la funcionalidad
    public static void main(String[] args) {
        Parcial parcial = new Parcial();

        // Ejemplos de uso
        System.out.println("Resultado: " + parcial.calcularPotencia(2, 5)); // Salida esperada: 32
        System.out.println("Resultado: " + parcial.calcularPotencia(10, 3)); // Salida esperada: 1000
        System.out.println("Resultado: " + parcial.calcularPotencia(0, 10)); // Salida esperada: 0
        System.out.println("Resultado: " + parcial.calcularPotencia(5, -2)); // Salida esperada: 0 (Error: La potencia no puede ser negativa)
        System.out.println("Resultado: " + parcial.calcularPotencia(100, 10)); // Salida esperada: 0 (Error: El resultado excede el valor máximo permitido)
    }
}
