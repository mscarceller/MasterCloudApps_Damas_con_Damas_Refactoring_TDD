# Práctica Test con el Juego de las Damas. TDD
## Damas con Damas

* Elementos: dos jugadores, un tablero de ajedrez, con una esquina blanca a la derecha de cada jugador, y fichas blancas y negras, para los dos jugadores, 12 peones y 2 damas

* En el estado inicial de la partida se colocan todas los peones de cada jugador en los cuadros negros de las tres filas más cercanas a éste, como en la siguiente imagen.

* Los jugadores mueven alternativamente una de sus fichas, empezando por el jugador de las fichas blancas, de una de las siguientes maneras:

    * un peón de una casilla puede mover a una de las dos casillas adyacentes en diagonal y hacia adelante, si ésta está vacia

    * un peón de una casilla puede mover a una de las dos casillas adyacentes de las adyacentes en diagonal y hacia adelante, si ésta esta vacía y la adyacente está ocupada por un ficha contraria repitiendo este mismo movimiento hasta 3 veces desde la nueva casilla. Todas las fichas contrarias "saltadas" en este momvimiento se retiran del tablero

    * en cualquiera de los dos casos anteriores, si un peón termina su movimiento en la última fila del tablero, se convierte en dama.

    * una dama de una casilla puede mover a una de las casillas diagonales, si existe como máximo una ficha contraria, repitiendo este mismo movimiento hasta 3 veces desde la nueva casilla. Todas las fichas contrarias "saltadas" se retiran del tablero

* Pierde el jugador que no puede realizar movimientos, porque no se cumplen las condiciones para el movimiento de todas sus fichas o que ya no hay fichas sobre el tablero



<center>

![alternativetext](./out/uml/DiagramaActoresYCasosUso.png)

![alternativetext](./out/uml/DiagramaContexto.png)

![alternativetext](./out/uml/DiseñoModeloVistaControladorConPresentadorDelModeloVistaControlador.png)

</center>
