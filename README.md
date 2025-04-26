# Grupo3BuscaMinas
# Buscaminas Colaborativo

##Instrucciones de instalación y ejecucción
	###Requisitos previos
		Asegurarse de instalar los siguientes programas en tu sistema:
			-Java Development Kit (JDK) 11 o superior: Necesario para compilar y ejecutar el proyecto
			-Eclipse IDE: Para facilitar el acceso,edición y ejecucción del código aunque puede llegar a usarse cualquier IDE.
	
	###Clonar el repositorio
		####Opción 1:
				-Si está en Eclipse, sin abrir la terminal vaya a Window>Show View>Other>Git>Git Repositories y despues pinche en la
				opción de Clone a Git Repository and add the clone to this view, despues seleccione la opcion de Clone URI y introduzca 
				la direccion de Github del repositorio y sus credenciales, despues de eso tendras que seleccionar donde poner el proyecto
		### Opción 2
				-Abre una terminal o consola en la maquina local
				-Clona el repositorio de Github en la maquina el siguiente comando 
				"git clone https://github.com/tu-usuario/tu-repositorio.git" Sustituye tu-usuario y tu-repositorio 
				por tu nombre de usuario y el nombre de tu repositorio en GitHub, respectivamente.
	###Ejecucción 
				-Ejecute el Main para poder probar el juego

##Breve explicación de la estructura del código.

	###Package: controlador
		-Archivo: Main.java
		-Responsabilidad principal:
			Se encarga de coordinar las ventanas de la aplicacion Buscaminas, ademas tambien se encarga de gestionar los cambios entre
			pantallas(Inicio,Juego,Ranking y Perder)
		-Componentes principales:
			--Atributos privados estáticos:
				--ventanaInicio, ventanaJuego, ventanaRanking, ventanaPerder
				--Propósito: mantener una referencia a cada ventana para mostrarla o cerrarla cuando sea necesario.
			--Método main:
				--Punto de entrada de la aplicación.
				--Crea una instancia de la VentanaInicio y la muestra.
			--Métodos de cambio de ventana:
				--cambioInicioJuego(nombre, dificultad)
					--Cambia de la ventana de inicio al tablero de juego.
				--cambioJuegoRanking()
					--Muestra el ranking después de jugar.
				--cambioRankingInico()
					--Permite volver del ranking al inicio.
				--cerrarSesionRanking()
					--Cierra la ventana de ranking.
			--Manejo de la derrota:
				--apareceVentanaPerder(nombre, dificultad, ventanaJuego)
					--Muestra una ventana especial cuando el jugador pierde.
				--cerrarSesion(nombre, dificultad, ventanaJuego)
					--Cierra las ventanas de juego y de derrota, y vuelve a Inicio.
					
	###Package: modelo
		-Este paquete se encarga de contener la lógica del juego Buscaminas: las casillas,las dificultades del tablero, la puntuación,ranking,el tablero, zona mina y zona vacia
			--Clase Abstracta Casilla:
				---Descripción:
					--Clase base para las casillas del tablero (mina o vacía).
							--Gestiona:
								--Si una casilla tiene mina.
								--Si está revelada.
								--Si tiene bandera.
								--El botón gráfico que la representa (Swing JButton).

							--Funciones importantes:
									--revelarConBandera(): para marcar o desmarcar una casilla con una bandera (clic derecho).
									--revelar(): método abstracto (cada tipo de casilla define su forma de revelarse).
									--setNumeroMinasAlrededor(int n) y getNumeroMinasAlrededor(): métodos abstractos para gestionar las minas cercanas en casillas vacías.

									--Nota:
										--Se indica que el listener del ratón (clic izquierdo/derecho) debe añadirse en la parte visual (VentanaJuego).
		--Clase Enumerada Dificultad:
			--Descripción:
					--Enum que define tres niveles de dificultad: FACIL, MEDIA, DIFICIL.

				--Cada nivel guarda:
						--Número de filas.
						--Número de columnas.
						--Número de bombas.

				--Funciones importantes:
						--getFilas(), getColumnas(), getBombas(): acceder a cada propiedad.
						--coeficientePuntuacion(): coeficiente usado para calcular la puntuación final según dificultad.
						--obtenerDificultad(String nombre): para convertir un String a una dificultad válida.
		--Clase Puntuacion:
				--Descripción:
					--Clase para representar y comparar las puntuaciones de los jugadores.
				--Atributos:
					--nombre: nombre del jugador.
					--puntuacion: valor de la puntuación, redondeado a 2 decimales.
					--tiempo: tiempo usado para completar la partida.
				--Funciones importantes:
					--compareTo(): permite ordenar puntuaciones de mayor a menor.
					--convertirObjeto(String linea): reconstruye un objeto Puntuacion a partir de una línea de texto (nombre|puntuacion|tiempo).
					--toString(): devuelve la representación en texto de la puntuación para guardarla o mostrarla.
		--Clase Ranking:
				--Gestiona el ranking de puntuaciones del juego. Se encarga de:
						--Calcular y guardar las mejores puntuaciones.
						--Leer y cargar las puntuaciones desde un archivo de texto.
						--Mantener una lista de los mejores jugadores (máximo 5).
				Atributos:
						--private static final String RANKING_FICHERO: ruta del archivo donde se guardan las puntuaciones.
						--private static final int USUARIOS_MAX: cantidad máxima de usuarios en el ranking (5).
						--private static Ranking instance: instancia única (patrón Singleton).
						--private List<Puntuacion> puntuacionLista: lista de puntuaciones actuales.
				--Constructor:
						--Inicializa puntuacionLista como un ArrayList vacío.
						--Llama a cargarPuntuacion() para llenar la lista desde el archivo.
						
				--getInstance:
						--Si no existe una instancia, la crea.
						--Si ya existe, devuelve la misma.
				--calcularPuntuacion(String nombre, int c, int m, int d, int tiempo)
						--Calcula una puntuación basada en:
						--Correctas (c)
						--Incorrectas (m)
						--Dificultad (d)
						--Tiempo (tiempo)
						--Fórmula de puntuación: (c - m) + (d / tiempo)
						--Añade la nueva puntuación a la lista y la ordena (Collections.sort).
						--Si hay más de 5 usuarios, elimina los últimos.
						--Guarda todo de nuevo con guardarPuntuacion().
				--cargarPuntuacion()
					--Lee el archivo línea por línea.
					--Cada línea se convierte en un objeto Puntuacion.
					--Añade las puntuaciones leídas al puntuacionLista.
				--guardarPuntuacion()
					--Escribe todas las puntuaciones del ranking en el archivo de texto.
					--Cada objeto Puntuacion se escribe como una línea.
				--Getters
					--getRankingFichero(): devuelve la ruta del fichero.
					--getUsuariosMax(): devuelve el número máximo de usuarios.
					--getPuntuacionLista(): devuelve la lista de puntuaciones.
		--Clase Tablero Entero:
				--Descripción:Se encarga de gestionar toda la lógica del tablero del Buscaminas:
					--Crear el tablero.
					--Colocar minas aleatoriamente.
					--Revelar casillas.
					--Marcar casillas.
					--Comprobar si el jugador ha ganado o perdido.
				--Atributos:
					--filas, columnas, bombas: dimensiones del tablero y cantidad de minas.
					--casilla: matriz 2D que representa las casillas.
					--juegoAcabado: indica si la partida terminó.
					--casillasReveladas: número de casillas abiertas por el jugador.
					--bombasRestantes: minas que quedan por marcar.
					--minasMarcadas: minas correctamente marcadas.
				--Metodos:
					--Constructor TableroEntero(Dificultad dificultad)
							--Inicializa las imágenes de números (imagenesNumeros()).
							--Configura dimensiones y bombas basándose en la dificultad.
							--Crea todas las casillas como ZonaVacia.
							--Llama a:
								--colocarMinas()
								--calcularMinas()
								--sillasAdyacentes()
							--mostrarTablero()
								--Inicializa todo el tablero con objetos ZonaVacia.
							--colocarMinas()
								--Coloca minas (ZonaMina) aleatoriamente en el tablero.
							--casillasAdyacentes()
								--Para cada ZonaVacia, guarda una lista de sus 8 casillas vecinas.
								--Sirve para revelar automáticamente si una casilla no tiene minas cercanas.
							--contarMinas(int fila, int columna)
								--Cuenta cuántas minas hay alrededor de una casilla.
							--validar(int fila, int columna)
								--Comprueba si las coordenadas están dentro del tablero.
							--calcularMinas()
								--Asigna a cada ZonaVacia cuántas minas tiene alrededor (setNumeroMinasAlrededor).
							--revelarCasilla(int fila, int columna)
								--Revela la casilla.
								--Si es una mina, el juego termina.
								--Si es una zona vacía y no hay minas alrededor, revela recursivamente las adyacentes.
							--marcarCasilla(int fila, int columna)
								--Pone o quita una bandera en la casilla.
								--Actualiza bombasRestantes y minasMarcadas.
							--perder(int fila, int columna)
								--Retorna true si el jugador reveló una casilla con mina.
							--ganar()
								--Retorna true si el jugador ha abierto todas las casillas que no tienen mina.

		--Clase Zona Mina:
			--Descripcion:Representa una casilla que contiene una mina en el tablero.
			--Atributos:
				--hereda de Casilla.
				--Al construirse, pone tieneMina = true.
			--Metodos:
				--Constructor ZonaMina()
					--Llama a super() (el constructor de Casilla).
					--Marca la casilla como que contiene mina.
				--revelar()
					--Si no estaba revelada y no tenía bandera:
					--Muestra la imagen de la explosión (bombdeath.gif).
					--Desactiva el botón.
		--Clase Zona Vacia:
			--Descripcion:Representa una casilla vacía que no tiene mina. Puede tener un número (0-8) indicando las minas cercanas.
			--Atributos:
				--numero: número de minas cercanas.
				--adyacentes: lista de casillas adyacentes (para revelar en cadena).
				--casillaAbierta y numeroCasilla: iconos para mostrar en pantalla.
			--Metodos:
				--Constructor ZonaVacia(int numero)
					--Inicializa los atributos.
					--Marca la casilla como no revelada y sin mina.
				--imagenesNumeros()
					--Carga los iconos de los números del 0 al 8 desde la carpeta images/.
				--setAdyacentes(List<Casilla> adyacentes)
					--Guarda las casillas vecinas para revelarlas automáticamente si el número es 0.
				--revelar()
					--Revela la casilla (si no tenía bandera).
					--Desactiva el botón.
					-Llama a mostrarNumero().
				--mostrarNumero()
					--Muestra el icono del número correspondiente.
				--Métodos sobrescritos
					--setNumeroMinasAlrededor(int n): establece el número de minas cercanas.
					--getNumeroMinasAlrededor(): devuelve el número de minas cercanas.
					--esZonaVacia(): retorna true (permite diferenciar ZonaVacia de ZonaMina).
	###package: Test
		-TestCasilla: Este se encarga de probar las casillas individuales
			-Comentario: Verifica minas, revelado y banderas
		-TestRanking: Este se encarga de comprobar que va bien el ranking de puntuaciones
			-Comentario: Calcula,guarda y carga puntuaciones
		-TestTableroEntero: Este se encarga de comprobar el tablero completo
			-Comentario: Mina colocada, revelar. ganar/perder
		-TestZonaMina: Este se encarga de comprobar que casillas que tienen mina
			-Comentario:Reveledado y caracteristica de la mina
		-TestZonaVacia: Este se encarga de comprobar las casillas vacias
			-Comentario: Reveladp y conteo de minas alrededor
	###package:Vista
			-Clase VentanaInicio:
				--Es la ventana principal donde el usuario:
					--Escribe su nombre.
					--Selecciona la dificultad ("Fácil", "Media", "Difícil") de una combo box.
					--Tiene dos botones: Iniciar Partida y Salir.
					--Estructura interna:
					--Usa un GridBagLayout para organizar los componentes.
					--Se valida que el nombre no esté vacío antes de iniciar.
					--Al iniciar partida, se llama a Main.cambioInicioJuego(nombre, dificultad) (controlador), quien debe lanzar el juego.
					--Si clicas "Salir", el programa se cierra (System.exit(0)).
			-Clase VentanaJuego:
				--Es la ventana donde se juega al Buscaminas:
					--Muestra:
						--Nombre del jugador.
						--Número de bombas restantes.
						--Dificultad seleccionada (se puede cambiar en juego).
						--Tablero de botones (cada botón es una casilla del juego).
						--Un temporizador visual basado en imágenes tipo "time001.gif", "time002.gif"…
					--Estructura interna:
						--Calcula dinámicamente el tamaño de la ventana en función de la dificultad.
						--Tiene un temporizador (Timer) que cuenta segundos y actualiza la UI.
						--Los botones de las casillas reaccionan a:
						--Click izquierdo: Revela la casilla.
						--Click derecho: Marca o desmarca la casilla como bomba.
					--Si el jugador:
						--Pierde (revela una bomba) → aparece ventana de derrota.
						--Gana (revela todas sin bombas) → se calcula y registra una puntuación.	
			-Clase VentanaPerder
				--Descripcion:Esta clase crea una ventana que aparece cuando el jugador pierde la partida. Le pregunta al usuario si quiere jugar otra vez o salir.
				--Atributos:nombre, dificultad y ventanaJuego: se usan para crear una nueva partida o cerrar la sesión.
				--Diseño:
					--Usa GridBagLayout para acomodar los elementos.
					--Tiene dos JLabel (uno que dice "¡Perdiste!" y otro que pregunta si quiere jugar de nuevo).
					--Tiene un JPanel donde hay dos botones: "Sí" y "No".
				--Botones:
					--"Sí": Cierra las ventanas actuales y abre una nueva partida.
					--"No": Llama al método cerrarSesion en la clase Main para terminar la sesión.
			-Clase VentanaRanking:
					--Descripcion:Esta clase muestra un ranking de los mejores jugadores (usuario, puntuación y tiempo).
					--Atributos:
						--ranking: instancia del objeto Ranking (que probablemente guarda los mejores resultados).
						--Varios JLabel (Ranking1, Puntuacion1, Tiempo1, etc.) para mostrar los datos de los cinco mejores jugadores.
					--Diseño:
						--Usa GridBagLayout para organizar todo en una estructura de 3 columnas: Usuario - Puntuación - Tiempo.
						--Paneles internos (JPanel) para organizar los nombres, puntuaciones y tiempos.
					--Estilo
						--Bordes (por ejemplo, MatteBorder) para que los datos estén visualmente separados.
						--Fuentes en negrita para títulos.
##Integrantes del grupo:
 Iniciamos siendo 4 que eramos : Janire Martinez, Iván Dobarrio, Aritz Alvarez y Jurgi Adame pero durante el desarrollo del juego Aritz y Jurgi dejaron de estar tan al tanto del 
 desarrollo y lo hemos acabado haciendo Janire Martinez y yo (Ivan Dobarrio) para cumplir la fecha de entrega.
					
