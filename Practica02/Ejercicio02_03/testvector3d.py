"""
Programa de manejo de vectores .
Natalia Nicol Tambo Paredes
1.0 16/09/2026
"""
from vector3d import Vector3D

# Crea los objetos Vector3D
v1 = Vector3D (1 , 2 , 3)
v2 = Vector3D (4 , 5 , 6)

# Imprime cada vector
print ( " v1 = " , v1 )
print ( " v2 = " , v2 )

# Imprime resultados de las operaciones
s = v1 + v2
print ( " suma = " , s )
es = v1 * v2
print ( " producto escalar = " , es )
vec = v1 ^ v2
print ( " producto vectorial = " , vec )