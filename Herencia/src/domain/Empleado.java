package domain;

/**
 *
 * @author vafla
 * Empleado extiende (hereda) de la clase Persona, por eso se escribe entends. Al no colocarlo no se podra acceder a metodos o propiedades directamente de la clase Persona. En java solo hay herencia simple, solo puede extender una clase
 * Cualquier clase en llava que no se le indique a quien extiende, se sabra que lo hace a la clase maestra Object
 * los constructores no se heredan pero las clases hijas pueden acceder a los constructores de la clase padre por medio de la palabra "super" y posteriormente seleccionando el constructor que desee utilizar y para saber qué constructor se quiere utilizar, se define por la cantidad de argumentos que se utilicen en la llamada al constructor, si no se pasa ningun argumento, sera el constructor vacio, con un argumento, el constructor que lo tenga y con todos el que lo tenga
 * 
 */
public class Empleado extends Persona {
    private int idEmpleado;//es private ya que se esta considerando que no va a tener clases hijas y por lo tanto no se accedera de forma directa a los atributos
    private double sueldo;
    private static int contadorEmpleado;//se va a usar para incrementa en uno cada que se vaya a crear un Empleado el cual se le asigna a la variable idEmpleado como valor unico

    public Empleado(String nombre, double sueldo) {
        //el atributo idEmpleado se va a asignar directamente de manera interna asi que ese atributo no se pasara como parametro y por lo tanto se usara un constructor distinto, se usara el constructor nombre de la clase padre y el atributo sueldo de la clase hija y de manera interna se inicializara el atributo idEmpleado
        //para poder inicializar el atributo nombre de la clase padre lo que se hace es mandar a llamar el constructor de la clase padre y para ello la primer linea debe de ser la palabra "super" se manda a llamar el constructor deseado de manera interna
        super(nombre);
        this.idEmpleado = ++Empleado.contadorEmpleado;//con o sin Empleado. antes de contadorEmpleado
        this.sueldo = sueldo;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

//    public void setIdEmpleado(int idEmpleado) {
//        this.idEmpleado = idEmpleado;
//    }este set para modificarlo no se necesita ya que este atributo se modifica de forma automatica. el constructor el es que se va a encargar de modificarlo

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();//se crea un objeto de la clase StringBuilder para no usar la concatenacion de cadenas (el toString normal con +)
        sb.append("Empleado{idEmpleado=").append(this.idEmpleado);//metodo append: este lo agrega para en vez de usar el + de concatenacion
        sb.append(", sueldo=").append(this.sueldo);
        //primera forma: sb.append(", nombre=").append(this.nombre);este no lo agrego por defecto, se agrego de forma manual y se hace uno por uno segun el atributo o metodo del atributo en la clase padre
        //esto se puede hacer agregando directamente el atributo o llamando el metodo get del atributo .append(this.getNombre())
        //segunda forma: reutilizar la llamada al metodo toString definida en la clase padre, entonces en vez de ir de atributo por atributo de la clase padre, se puede concatener por completo los valores del objeto y en vez de utilizar append(this.nombre) se usara super. ya que accede de forma directa a la clase padre
        sb.append(", ").append(super.toString());
        sb.append('}');
        return sb.toString();//al final se usa la variable sb y manda a llamar finalmente tambien el metodo toString que al final regresa un tipo String, la cadena que se ha generado a partir de las llamadas al metodo append que se han hecho. SI no se hace esa conversion al final(agregar toString() despues de sb.) entonces se tendra un error
    }   
}
