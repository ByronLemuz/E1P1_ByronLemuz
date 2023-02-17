/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package e1p1_byronlemuz;
import java.util.Scanner;

public class E1P1_ByronLemuz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        
        while (opcion != 4) {
            System.out.println("-----------Menu------------");         
            System.out.println("1. Validación de números");
            System.out.println("2. Reordenamiento de cadenas");
            System.out.println("3. TRIGONOMETRIA");
            System.out.println("4. Salir");
            System.out.println("Seleccione una opción:");
            System.out.println("*--------------------------");
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el número que desea validar: ");
                    String entrada = scanner.next();
                    if (validarNumero(entrada)) {
                        System.out.println(entrada + " es un número válido.");
                    } else {
                        System.out.println(entrada + " no es un número válido.");
                    }
                    break;
                    
                case 2:
                    System.out.print("Ingrese la cadena que desea reordenar: ");
                    String cadena = scanner.next();
                    String reordenada = reordenarCadena(cadena);
                    System.out.println("String reordenado: " + reordenada);
                    break;
                    
                case 3:
                    System.out.print("Ingrese el ángulo (grados) que desea calcular: ");
                    double anguloGrados = scanner.nextDouble();
                    System.out.print("Ingrese la precisión deseada: ");
                    int precision = scanner.nextInt();
                    double resultado = Trigonometria(anguloGrados, precision);
                    System.out.println("sin(" + anguloGrados + ") = " + resultado);
                    break;
                    
                case 4:
                    System.out.println("¡Hasta pronto hermos@s!. ");
                    break;
                    
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida ombre, nada le cuesta.");
                    break;
            }
        }
    }
    
    
        public static boolean validarNumero(String entrada) {
    boolean esValido = true;
    int i = 0;
    int longitudEntrada = entrada.length();
    
    // Comprobar si hay un signo '-' al principio del número
    if (entrada.charAt(0) == '-') {
        i = 1;
        // Si hay más de un '-' al principio, el número no es válido
        if (entrada.charAt(1) == '-') {
            esValido = false;
        }
    }
    
    // Comprobar si hay un punto '.' al principio, en medio o al final del número
    boolean puntoEncontrado = false;
    if (entrada.charAt(i) == '.') {
        puntoEncontrado = true;
        i++;
    }
    for (; i < longitudEntrada; i++) {
        char caracter = entrada.charAt(i);
        if (caracter == '.') {
            // Si se encontró un punto antes, el número no es válido
            if (puntoEncontrado) {
                esValido = false;
            } else {
                puntoEncontrado = true;
            }
        } else if (caracter < '0' || caracter > '9') {
            // Si no es un dígito ni un punto, el número no es válido
            esValido = false;
        }
    }
    
    // Si no se encontró ningún número antes del punto, el número no es válido
    if (puntoEncontrado && i == 1) {
        esValido = false;
    }
    
    return esValido;
}

    
    
    public static String reordenarCadena(String cadena) {
    String numeros = "";
    String minuscula = "";
    String mayuscula = "";
    String otros = "";

    for (int i = 0; i < cadena.length(); i++) {
        char b = cadena.charAt(i);
        if (b >= '0' && b <= '9') {
            numeros += b;
        } else if (b >= 'a' && b <= 'z') {
            minuscula += b;
        } else if (b >= 'A' && b <= 'Z') {
            mayuscula += b;
        } else {
            otros += b;
        }
    }

    return numeros.concat(minuscula).concat(mayuscula).concat(otros);
}
    
    public static double Trigonometria(double angulo, int precision) {
       
    // Convertir el ángulo a radianes
    double radianes= angulo * Math.PI / 180;

    // Calcular la sumatoria
    double sum = 0;
    for (int i = 0; i <= precision; i++) {
        double numerador = Math.pow(-1, i) * Math.pow(radianes, 2*i + 1);
        double denominador = factorial(2*i + 1);
              sum += numerador / denominador;
    }

    return sum;
}

public static double factorial(int n) {
    if (n == 0) {
        return 1;
    } else {
        return n * factorial(n - 1);
    


    }
}}

    
    

