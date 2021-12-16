package domain;

/**
 *
 * @author vafla
 * herencia: permitira representar características o comportamiento en común entre clases, permitiendo definir en la clase Padre los atributos o métodos que sean comunes a las clases hijas, las cuales heredarán estos atributos o métodos definidos en la clase Padre.
 * extends: trae informacion de una clase padre
 * cuando se hace un extends a la clase Persona, esa clase va a heredar todas las caracteristicas de esa clase que sean posibles de heredar. Los atributos privados o todo lo que sea privado definido en la clase Persona no es posible heredarlo pero los demás modificadores de acceso como por ejemplo public y protected si podran ser heredados por las clases hijas
 * protected: sin importar si esta en otro paquete, si un atributo esta marcado como protected las clases hijas van a poder acceder al mismo y modificarlo directamente
 * si se usara por ejemplo private, otras clases hijas pueden acceder a estos atributos de forma indirecta por los metodos get y set publicos de cada atributo
 */
public class Persona {
    protected String nombre;
    protected char genero;
    protected int edad;
    protected String direccion;
    
    //cada constructor que se agregue es para crear distintos objetos de distintas maneras con valores iniciales de distinta forma
    //constructor vacio: basicamente para poder crear objetos de tipo Persona sin necesidad de inicializar los atributos de esta clase
    public Persona(){
        
    }
    
    //constructor con un argumento solamente para inicializar el atributo de nombre
    public Persona(String nombre){
        this.nombre = nombre;
    }
    
    //constructor completo para inicializar todos los atributos
    public Persona(String nombre, char genero, int edad, String direccion) {
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{nombre=").append(nombre);
        sb.append(", genero=").append(genero);
        sb.append(", edad=").append(edad);
        sb.append(", direccion=").append(direccion);
        sb.append(", ").append(super.toString()); //la clase Object imprime la referencia de memoria del objeto creado y para verlo, en el metodo toString de la clase principal padre se debe hacer una concatenacion de la llamada a super
        sb.append('}');
        return sb.toString();
    }
}
