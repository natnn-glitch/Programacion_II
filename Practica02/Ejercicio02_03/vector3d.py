"""
La Clase Vector3D .
Natalia Nicol Tambo Paredes
1.0 16/09/2026
"""
import math

class Vector3D :
    def __init__ ( self , a1 = 0.0 , a2 = 0.0 , a3 = 0.0 ) :
        self . a1 = float(a1)
        self . a2 = float(a2)
        self . a3 = float(a3)

    # a) Suma de dos vectores
    def __add__ ( self , o ) :
        return Vector3D ( self . a1 + o . a1 , self . a2 + o . a2 , self . a3 + o . a3 )

    # Resta (Necesaria para álgebra vectorial)
    def __sub__ ( self , o ) :
        return Vector3D ( self . a1 - o . a1 , self . a2 - o . a2 , self . a3 - o . a3 )

    # b y e) Multiplicación escalar y Producto escalar (Polimorfismo con isinstance)
    def __mul__ ( self , o ) :
        if isinstance(o, Vector3D):
            return self . a1 * o . a1 + self . a2 * o . a2 + self . a3 * o . a3
        else:
            return Vector3D ( self . a1 * o , self . a2 * o , self . a3 * o )
            
    def __rmul__ ( self , o ) :
        return self . __mul__ ( o )

    # c) Longitud de un vector
    def __abs__ ( self ) :
        return math.sqrt( self . a1**2 + self . a2**2 + self . a3**2 )

    # d) Normal de un vector
    def normal ( self ) :
        lon = abs(self)
        if lon == 0:
            return Vector3D (0, 0, 0)
        return Vector3D ( self . a1 / lon , self . a2 / lon , self . a3 / lon )

    # f) Producto vectorial (usaremos el operador ^)
    def __xor__ ( self , o ) :
        return Vector3D ( self . a2 * o . a3 - self . a3 * o . a2 ,
                          self . a3 * o . a1 - self . a1 * o . a3 ,
                          self . a1 * o . a2 - self . a2 * o . a1 )

    def __str__ ( self ) :
        return " ({}, {}, {}) " . format ( self . a1 , self . a2 , self . a3 )