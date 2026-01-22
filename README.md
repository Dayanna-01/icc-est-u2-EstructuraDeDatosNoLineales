# Práctica: Estructuras No Lineales 

## Autor
- Nombre: Janelly Dayanna Chacha Velez
- Carrera/Curso: Computacion


##  Práctica de Árboles – Implementación Integers - 2026-01-05
- Práctica: Práctica de Árboles – Implementación Integers
- Fecha: 2026-01-05

## Descripción
En esta práctica se implementó un Árbol Binario de Búsqueda para enteros.
El árbol permite insertar valores y realizar los recorridos PreOrder, InOrder y PostOrder.
Además, se implementó un método size() con complejidad O(1) utilizando un contador interno que aumenta cada vez que se inserta un nodo.

## Evidencias
### Captura 1
![alt text](assets/Order.png)
- Y también muestra el tamaño total del árbol, que es calculado en O(1) porque size() solo devuelve el valor del contador interno.

### Captura 2 
![alt text](assets/Size.png)
- La evidencia muestra:
el atributo private int size;
el incremento del contador dentro de insert()
el método size() que simplemente retorna el contador
Esto demuestra que el tamaño no se calcula recorriendo el árbol, sino leyendo una variable almacenada.

### Captura 3
![alt text](assets/Generico.png)
- El método searchByAge recorre el árbol en orden (izquierda, nodo, derecha) y en cada nodo verifica si el valor es una Person. Si lo es, compara su edad con la buscada y, si coinciden, la imprime. Así recorre todo el árbol y muestra todas las personas que tienen esa edad.

### Captura 4
- InOrder y la aptura del resultado de la busqueda en consola de una persona por edad.
![alt text](assets/InOrder.png)

### Captura 5
![alt text](assets/GRAPH.png)

### Captura 6
![alt text](assets/Salida.png)

### Captura 7 - BFS y DFS
![alt text](assets/GrafosClases.png)

### Captura 8 - Ruta encontrada de BFS y DFS
![alt text](assets/BFSyDFS.png)