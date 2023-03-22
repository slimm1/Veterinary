# Veterinary
Otra pequeña práctica con clases, listas y lectura/escritura de datos en ficheros. La consola de java despliega un menú por el que se puede navegar para realizar diferentes acciones. 

El programa simula la base de datos de un veterinario, en el cual se pueden realizar diferentes operaciones como dar de alta una mascota paciente (creacion de objeto, añadirlo a un array de objetos), dar de baja a una mascota paciente, añadir un tratamiento a un paciente específico (hay una serie de tratamientos prestablecidos), mostrar una lista con las mascotas que tienen tratamientos en común o generar un fichero de texto embellecido con toString con los datos extraídos del fichero original.

Ejercicio útil para la práctica de creación de objetos, manejo de clases y utilización de arrays de objetos. Además fue mi primer ejercicio con el uso de la clase LocalDateTime y DateTimeFormatter. Uso de expresiones regulares para la lectura por Scanner de fechas. En esta práctica realicé mi primera sobreescritura del método equals. 

El algoritmo de lectura de datos lee del fichero las lineas y si hay algun nombre de mascota repetido en cada linea significa que esa mascota tiene más de un tratamiento asignado. Si los datos están repetidos no los carga en el programa. El programa puede guardar los datos introducidos con la opcion "guardar y salir" o puede descartar los cambios terminando directamente la ejecución.

El código puede ser un poco messy... contar con que es una de mis primeras prácticas, pero la primera que me hizo sentirme orgulloso <3
