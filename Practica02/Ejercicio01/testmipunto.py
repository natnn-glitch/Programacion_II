"""
Programa de manejo de puntos .
Natalia Nicol Tambo Paredes
1.0 16/09/2026
"""
from mipunto import MiPunto

# Crea los objetos MiPunto
p1 = MiPunto ()
p2 = MiPunto (10.0 , 30.5)

# Imprime cada punto
print ( " p1 = (" , p1.get_x() , "," , p1.get_y() , ")" )
print ( " p2 = (" , p2.get_x() , "," , p2.get_y() , ")" )

# Imprime resultados de las operaciones
d = p1.distancia(p2)
print ( " distancia = " , d )