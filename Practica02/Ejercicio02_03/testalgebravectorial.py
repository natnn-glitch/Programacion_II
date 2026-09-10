"""
Programa de manejo de algebra vectorial .
Natalia Nicol Tambo Paredes
1.0 16/09/2026
"""
from vector3d import Vector3D
from algebravectorial import AlgebraVectorial

# Crea los objetos
v_base = Vector3D (1.0 , 0.0 , 0.0)
v_test = Vector3D (0.0 , 1.0 , 0.0)

alg = AlgebraVectorial (v_base)

# Imprime cada vector
print ( " vector a = " , v_base )
print ( " vector b = " , v_test )

# Imprime resultados de las operaciones
print ( " Son perpendiculares (usando objeto) = " , alg.perpendicular(v_test) )
print ( " Son perpendiculares (usando floats) = " , alg.perpendicular(0.0, 1.0, 0.0) )
print ( " Proyeccion = " , alg.proyeccion(v_test) )
print ( " Componente = " , alg.componente(v_test) )