"""
La Clase MiPunto .
Natalia Nicol Tambo Paredes
1.0 16/09/2026
"""
import math
from multimethod import multimethod

class MiPunto :
    # Constructor con argumentos por defecto (simula constructor vacío y con parámetros)
    def __init__ ( self , x = 0.0 , y = 0.0 ) :
        self . __x = float(x)
        self . __y = float(y)

    def get_x ( self ) :
        return self . __x

    def get_y ( self ) :
        return self . __y

    # Sobrecarga de métodos: distancia hacia otro objeto MiPunto
    @multimethod
    def distancia ( self , o : object ) :
        return math.sqrt(( self . __x - o.get_x() )**2 + ( self . __y - o.get_y() )**2)

    # Sobrecarga de métodos: distancia hacia coordenadas x e y
    @multimethod
    def distancia ( self , x : float , y : float ) :
        return math.sqrt(( self . __x - x )**2 + ( self . __y - y )**2)