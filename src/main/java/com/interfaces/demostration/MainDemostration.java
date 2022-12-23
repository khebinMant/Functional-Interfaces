package com.interfaces.demostration;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import com.interfaces.demostration.models.Vehicle;

public class MainDemostration {
    public static void main(String[] args) {
        
        //BIFUNCTION

        //Explicación 
        /*La interfaz funcional Bifunction
        toma 3 valores de los cuales se hace referencia 
        los 2 primeros los tipos de dato de entrada 
        y el tercero hace referencia al valor de retorno*/
        
        //Ejemplo
        BiFunction<Integer,Integer,Integer> func = (x, y)->x*y;
        Integer result = func.apply(5, 8);
        System.out.println("El resultado es: " + result);
        //Explicación 

        /* La interfaz BiFunction toma dos numeros enteros de entrada
         * y toma un entero como valor de salida en este caso multiplica 
         * el primero entero por segundo entero y retorna la respuesta
        */


        //BIPREDICATE

        /*
          * La interfaz funcional BiPredicate
          * que acepta 2 argumentos y retorna un valor boleano
          * es practicamente igual al Predicate pero toma 2 argumentos
        */

        //Ejemplo
        BiPredicate<String,Integer> biPredicate = (x,y)->{
        return x.length() == y;
        };
        boolean respTrue =  biPredicate.test("hola mundo",10);
        boolean respFalse =  biPredicate.test("hola mundo",50);
        System.out.println("El resultado es: " + respTrue);
        System.out.println("El resultado es: " + respFalse);

        //EXPLICACIÓN

        /*
           * Toma dos valores String e Integer 
           * determina si la longitud del string es igual al entero enviado
           * en el argumento si es asi retona true caso contrario false
        */


        //BICONSUMER
        /*
        * La interfaz funcional Biconsumer toma dos argumentos pero no retorna nada 
        */

        //Ejemplo

        BiConsumer<Integer, Integer> addNumbers = (x,y)-> System.out.println("Resultado BiConsumer sumar números: "+ (x+y));
        addNumbers.accept(50, 5);

        //EXPLICACIÓN
        /*
        * Como toma dos argumentos y no retorna nada 
        * en este caso se envian dos numeros y en la propia
        * implementación se hace la impresión de la suma ya que no retorna nada
        */


        //SUPPLIER
        /*
        * Suplier es una interfaz funcional que no recibe argumentos pero retorna un resultado
        */

        //Ejemplo
        Supplier<String> uuidString = ()->UUID.randomUUID().toString();
        System.out.println("Resultado: "+ uuidString);

        //Explicación

        /*
        * No recibe ningun argumento pero retorna un UUID aleatorio convertido a string
        */


        //UnaryOperator
        /*
        * La interfaz funcional UnaryOpertaor toma un argumento y retorna
        * un valor del mismo tipo
        * Por esta razón la interfaz funcional  Function<Integer, Integer> puede ser remplazada 
        * por UnaryOperator<Integer> sin problemas
        */

        //Ejemplo
        UnaryOperator<Integer> numberSqrd = x->x*x;
        Integer resp =  numberSqrd.apply(4);
        System.out.println("El número al cuadrado es: " + resp);

        //Explicación 
        /*
        * Se envía como argumento un integer en este caso el número 4 
        * y se espera que retorne el número elevado al cuadrado 
        * es decir un integer mismo.
        */

        //BinaryOperator

        /*
        * La interfaz funcional BinaryOperator toma un argumento y
        * y hace referencia al tipo de dato que va retornar
        * por esta razón se puede usar BinaryOperator<Integer> en vez de 
        * BiFunction<Integer, Integer, Integer>
        */

        //Ejemplo
        BinaryOperator<Integer> mult = (x1, x2) -> x1 * x2;
        Integer respBi = mult.apply(5,9);
        System.out.println("El resultado es: " +respBi);


        //Comparer

        /*
        * La interfaz funcional Comparer compara los atributos del 
        * mismo tipo de un objeto por ello es que suele ser usado en expresiones lambda 
        * como el sort que permite basasdo en el comparador ordenar la lista de objetos
        * aunque también se puede hacerlo si un lambda y es como se hacia en las versiones 
        * previas a java 8
        */

        //Ejemplo ordenar por año
        List<Vehicle> listVehicles = Arrays.asList(
            new Vehicle("Buick","Regal",1995),
            new Vehicle("Hyundai","Elantra",1988),
            new Vehicle("Buick","Skylark",1991),
            new Vehicle("Hyundai","Accent",1999)
        );

        Collections.sort(listVehicles, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle v1, Vehicle v2) {
                return v1.getYear() - v2.getYear();
            }
        });

        System.out.println("After Sort");
        for (Vehicle vehicle : listVehicles) {
            System.out.println(vehicle);
        }

        //Explicación
        /*
         * Se tiene una lista de vehiculos y se requiere ordenar por año 
         * ascendentemente  se utiliza el Comparator<Object> que recibe como argumento
         * el tipo de dato no primitivo a comparar.
         * Algo que sucede es que no se retorna un nueva Lista con los valores nuevos
         * se sobreescribe los valores en base al orden deseado por esta razón no se vuelve 
         * a instanciar una lista de vehiculos. 
         */


    
    }
}
