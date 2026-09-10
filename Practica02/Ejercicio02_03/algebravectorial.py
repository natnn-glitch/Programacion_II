"""
La Clase AlgebraVectorial .
Natalia Nicol Tambo Paredes
1.0 16/09/2026
"""
from vector3d import Vector3D
from multimethod import multimethod

class AlgebraVectorial :
    
    # Sobrecarga de constructores
    @multimethod
    def __init__ ( self , v : Vector3D ) :
        self . a = v
        
    @multimethod
    def __init__ ( self , a1 : float , a2 : float , a3 : float ) :
        self . a = Vector3D (a1, a2, a3)

    # a, b, c, d) Perpendicular
    @multimethod
    def perpendicular ( self , b : Vector3D ) :
        # Regla c: a * b = 0
        return round(self . a * b, 5) == 0.0

    @multimethod
    def perpendicular ( self , b1 : float , b2 : float , b3 : float ) :
        # Regla a: |a + b| = |a - b|
        b = Vector3D (b1, b2, b3)
        return round(abs(self . a + b), 5) == round(abs(self . a - b), 5)

    # e, f) Paralela
    @multimethod
    def paralela ( self , b : Vector3D ) :
        # Regla f: a x b = 0
        cruz = self . a ^ b
        return round(abs(cruz), 5) == 0.0

    @multimethod
    def paralela ( self , b1 : float , b2 : float , b3 : float ) :
        # Regla e: a = rb
        b = Vector3D (b1, b2, b3)
        if abs(b) == 0:
            return False
        r = abs(self . a) / abs(b)
        r_b = r * b
        return round(self . a . a1, 5) == round(r_b . a1, 5) and \
               round(self . a . a2, 5) == round(r_b . a2, 5) and \
               round(self . a . a3, 5) == round(r_b . a3, 5)

    # g) Proyección de a sobre b
    def proyeccion ( self , b : Vector3D ) :
        if abs(b) == 0:
            return Vector3D (0, 0, 0)
        escalar = (self . a * b) / (abs(b)**2)
        return b * escalar

    # h) Componente de a en b
    def componente ( self , b : Vector3D ) :
        if abs(b) == 0:
            return 0.0
        return (self . a * b) / abs(b)